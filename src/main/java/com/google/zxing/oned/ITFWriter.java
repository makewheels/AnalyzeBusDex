package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class ITFWriter extends UPCEANWriter {
    public BitMatrix encode(String contents, BarcodeFormat format, int width, int height, Map<EncodeHintType, ?> hints) throws WriterException {
        if (format == BarcodeFormat.ITF) {
            return super.encode(contents, format, width, height, hints);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + format);
    }

    public byte[] encode(String contents) {
        int length = contents.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The lenght of the input should be even");
        } else if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        } else {
            byte[] result = new byte[((length * 9) + 9)];
            int pos = OneDimensionalCodeWriter.appendPattern(result, 0, new int[]{1, 1, 1, 1}, 1);
            for (int i = 0; i < length; i += 2) {
                int one = Character.digit(contents.charAt(i), 10);
                int two = Character.digit(contents.charAt(i + 1), 10);
                int[] encoding = new int[18];
                for (int j = 0; j < 5; j++) {
                    encoding[j << 1] = ITFReader.PATTERNS[one][j];
                    encoding[(j << 1) + 1] = ITFReader.PATTERNS[two][j];
                }
                pos += OneDimensionalCodeWriter.appendPattern(result, pos, encoding, 1);
            }
            pos += OneDimensionalCodeWriter.appendPattern(result, pos, new int[]{3, 1, 1}, 1);
            return result;
        }
    }
}
