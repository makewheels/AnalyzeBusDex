package com.google.zxing.aztec.decoder;

import com.alipay.sdk.cons.C0108a;
import com.e4a.runtime.components.Component;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.iflytek.cloud.speech.ErrorCode;
import com.tencent.smtt.sdk.TbsListener;
import p054u.aly.bi_常量类;

public final class Decoder {
    private static final String[] DIGIT_TABLE = new String[]{"CTRL_PS", " ", "0", C0108a.f262e, "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    private static final String[] LOWER_TABLE = new String[]{"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = new String[]{"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final int[] NB_BITS = new int[]{0, 128, 288, 480, 704, 960, 1248, 1568, 1920, 2304, 2720, 3168, 3648, 4160, 4704, 5280, 5888, 6528, 7200, 7904, 8640, 9408, ErrorCode.MSP_ERROR_NET_BINDSEQUENCE, 11040, 11904, 12800, 13728, 14688, 15680, 16704, 17760, 18848, 19968};
    private static final int[] NB_BITS_COMPACT = new int[]{0, TbsListener.ErrorCode.WRITE_DISK_ERROR, 240, 408, 608};
    private static final int[] NB_DATABLOCK = new int[]{0, 21, 48, 60, 88, TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR, 156, 196, 240, 230, 272, TbsListener.ErrorCode.ERROR_QBSDK_INIT_END, 364, 416, 470, 528, 588, 652, 720, 790, 864, 940, 1020, 920, 992, 1066, 1144, 1224, 1306, 1392, 1480, 1570, 1664};
    private static final int[] NB_DATABLOCK_COMPACT = new int[]{0, 17, 40, 51, 76};
    private static final String[] PUNCT_TABLE = new String[]{bi_常量类.f6358b_空串, "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] UPPER_TABLE = new String[]{"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private int codewordSize;
    private AztecDetectorResult ddata;
    private int invertedBitCount;
    private int numCodewords;

    private enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public DecoderResult decode(AztecDetectorResult detectorResult) throws FormatException {
        this.ddata = detectorResult;
        BitMatrix matrix = detectorResult.getBits();
        if (!this.ddata.isCompact()) {
            matrix = removeDashedLines(this.ddata.getBits());
        }
        return new DecoderResult(null, getEncodedData(correctBits(extractBits(matrix))), null, null);
    }

    private String getEncodedData(boolean[] correctedBits) throws FormatException {
        int endIndex = (this.codewordSize * this.ddata.getNbDatablocks()) - this.invertedBitCount;
        if (endIndex > correctedBits.length) {
            throw FormatException.getFormatInstance();
        }
        Table lastTable = Table.UPPER;
        Table table = Table.UPPER;
        int startIndex = 0;
        StringBuilder result = new StringBuilder(20);
        boolean end = false;
        boolean shift = false;
        boolean switchShift = false;
        while (!end) {
            if (shift) {
                switchShift = true;
            } else {
                lastTable = table;
            }
            int code;
            switch (table) {
                case BINARY:
                    if (endIndex - startIndex >= 8) {
                        code = readCode(correctedBits, startIndex, 8);
                        startIndex += 8;
                        result.append((char) code);
                        break;
                    }
                    end = true;
                    break;
                default:
                    int size = 5;
                    if (table == Table.DIGIT) {
                        size = 4;
                    }
                    if (endIndex - startIndex >= size) {
                        code = readCode(correctedBits, startIndex, size);
                        startIndex += size;
                        String str = getCharacter(table, code);
                        if (!str.startsWith("CTRL_")) {
                            result.append(str);
                            break;
                        }
                        table = getTable(str.charAt(5));
                        if (str.charAt(6) == 'S') {
                            shift = true;
                            break;
                        }
                    }
                    end = true;
                    break;
                    break;
            }
            if (switchShift) {
                table = lastTable;
                shift = false;
                switchShift = false;
            }
        }
        return result.toString();
    }

    private static Table getTable(char t) {
        switch (t) {
            case Component.f3899 /*66*/:
                return Table.BINARY;
            case Component.KEYCODE_GRAVE /*68*/:
                return Table.DIGIT;
            case Component.KEYCODE_SLASH /*76*/:
                return Table.LOWER;
            case Component.KEYCODE_AT /*77*/:
                return Table.MIXED;
            case 'P':
                return Table.PUNCT;
            default:
                return Table.UPPER;
        }
    }

    private static String getCharacter(Table table, int code) {
        switch (table) {
            case UPPER:
                return UPPER_TABLE[code];
            case LOWER:
                return LOWER_TABLE[code];
            case MIXED:
                return MIXED_TABLE[code];
            case PUNCT:
                return PUNCT_TABLE[code];
            case DIGIT:
                return DIGIT_TABLE[code];
            default:
                return bi_常量类.f6358b_空串;
        }
    }

    private boolean[] correctBits(boolean[] rawbits) throws FormatException {
        GenericGF gf;
        int offset;
        int numECCodewords;
        int i;
        if (this.ddata.getNbLayers() <= 2) {
            this.codewordSize = 6;
            gf = GenericGF.AZTEC_DATA_6;
        } else if (this.ddata.getNbLayers() <= 8) {
            this.codewordSize = 8;
            gf = GenericGF.AZTEC_DATA_8;
        } else if (this.ddata.getNbLayers() <= 22) {
            this.codewordSize = 10;
            gf = GenericGF.AZTEC_DATA_10;
        } else {
            this.codewordSize = 12;
            gf = GenericGF.AZTEC_DATA_12;
        }
        int numDataCodewords = this.ddata.getNbDatablocks();
        if (this.ddata.isCompact()) {
            offset = NB_BITS_COMPACT[this.ddata.getNbLayers()] - (this.numCodewords * this.codewordSize);
            numECCodewords = NB_DATABLOCK_COMPACT[this.ddata.getNbLayers()] - numDataCodewords;
        } else {
            offset = NB_BITS[this.ddata.getNbLayers()] - (this.numCodewords * this.codewordSize);
            numECCodewords = NB_DATABLOCK[this.ddata.getNbLayers()] - numDataCodewords;
        }
        int[] dataWords = new int[this.numCodewords];
        for (i = 0; i < this.numCodewords; i++) {
            int j;
            int flag = 1;
            for (j = 1; j <= this.codewordSize; j++) {
                if (rawbits[(((this.codewordSize * i) + this.codewordSize) - j) + offset]) {
                    dataWords[i] = dataWords[i] + flag;
                }
                flag <<= 1;
            }
        }
        try {
            new ReedSolomonDecoder(gf).decode(dataWords, numECCodewords);
            offset = 0;
            this.invertedBitCount = 0;
            boolean[] correctedBits = new boolean[(this.codewordSize * numDataCodewords)];
            for (i = 0; i < numDataCodewords; i++) {
                boolean seriesColor = false;
                int seriesCount = 0;
                flag = 1 << (this.codewordSize - 1);
                for (j = 0; j < this.codewordSize; j++) {
                    boolean color = (dataWords[i] & flag) == flag;
                    if (seriesCount != this.codewordSize - 1) {
                        if (seriesColor == color) {
                            seriesCount++;
                        } else {
                            seriesCount = 1;
                            seriesColor = color;
                        }
                        correctedBits[((this.codewordSize * i) + j) - offset] = color;
                    } else if (color == seriesColor) {
                        throw FormatException.getFormatInstance();
                    } else {
                        seriesColor = false;
                        seriesCount = 0;
                        offset++;
                        this.invertedBitCount++;
                    }
                    flag >>>= 1;
                }
            }
            return correctedBits;
        } catch (ReedSolomonException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private boolean[] extractBits(BitMatrix matrix) throws FormatException {
        boolean[] rawbits;
        if (this.ddata.isCompact()) {
            if (this.ddata.getNbLayers() > NB_BITS_COMPACT.length) {
                throw FormatException.getFormatInstance();
            }
            rawbits = new boolean[NB_BITS_COMPACT[this.ddata.getNbLayers()]];
            this.numCodewords = NB_DATABLOCK_COMPACT[this.ddata.getNbLayers()];
        } else if (this.ddata.getNbLayers() > NB_BITS.length) {
            throw FormatException.getFormatInstance();
        } else {
            rawbits = new boolean[NB_BITS[this.ddata.getNbLayers()]];
            this.numCodewords = NB_DATABLOCK[this.ddata.getNbLayers()];
        }
        int layer = this.ddata.getNbLayers();
        int size = matrix.getHeight();
        int rawbitsOffset = 0;
        int matrixOffset = 0;
        while (layer != 0) {
            int i;
            int flip = 0;
            for (i = 0; i < (size * 2) - 4; i++) {
                rawbits[rawbitsOffset + i] = matrix.get(matrixOffset + flip, (i / 2) + matrixOffset);
                rawbits[(((size * 2) + rawbitsOffset) - 4) + i] = matrix.get((i / 2) + matrixOffset, ((matrixOffset + size) - 1) - flip);
                flip = (flip + 1) % 2;
            }
            flip = 0;
            for (i = (size * 2) + 1; i > 5; i--) {
                rawbits[((((size * 4) + rawbitsOffset) - 8) + ((size * 2) - i)) + 1] = matrix.get(((matrixOffset + size) - 1) - flip, ((i / 2) + matrixOffset) - 1);
                rawbits[((((size * 6) + rawbitsOffset) - 12) + ((size * 2) - i)) + 1] = matrix.get(((i / 2) + matrixOffset) - 1, matrixOffset + flip);
                flip = (flip + 1) % 2;
            }
            matrixOffset += 2;
            rawbitsOffset += (size * 8) - 16;
            layer--;
            size -= 4;
        }
        return rawbits;
    }

    private static BitMatrix removeDashedLines(BitMatrix matrix) {
        int nbDashed = ((((matrix.getWidth() - 1) / 2) / 16) * 2) + 1;
        BitMatrix newMatrix = new BitMatrix(matrix.getWidth() - nbDashed, matrix.getHeight() - nbDashed);
        int nx = 0;
        for (int x = 0; x < matrix.getWidth(); x++) {
            if (((matrix.getWidth() / 2) - x) % 16 != 0) {
                int ny = 0;
                for (int y = 0; y < matrix.getHeight(); y++) {
                    if (((matrix.getWidth() / 2) - y) % 16 != 0) {
                        if (matrix.get(x, y)) {
                            newMatrix.set(nx, ny);
                        }
                        ny++;
                    }
                }
                nx++;
            }
        }
        return newMatrix;
    }

    private static int readCode(boolean[] rawbits, int startIndex, int length) {
        int res = 0;
        for (int i = startIndex; i < startIndex + length; i++) {
            res <<= 1;
            if (rawbits[i]) {
                res++;
            }
        }
        return res;
    }
}
