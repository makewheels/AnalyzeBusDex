package com.google.zxing.common;

import com.tencent.smtt.sdk.WebView;

public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int numBits) {
        if (numBits < 1 || numBits > 32) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        if (this.bitOffset > 0) {
            int toRead;
            int bitsLeft = 8 - this.bitOffset;
            if (numBits < bitsLeft) {
                toRead = numBits;
            } else {
                toRead = bitsLeft;
            }
            int bitsToNotRead = bitsLeft - toRead;
            result = (this.bytes[this.byteOffset] & ((WebView.NORMAL_MODE_ALPHA >> (8 - toRead)) << bitsToNotRead)) >> bitsToNotRead;
            numBits -= toRead;
            this.bitOffset += toRead;
            if (this.bitOffset == 8) {
                this.bitOffset = 0;
                this.byteOffset++;
            }
        }
        if (numBits <= 0) {
            return result;
        }
        while (numBits >= 8) {
            result = (result << 8) | (this.bytes[this.byteOffset] & WebView.NORMAL_MODE_ALPHA);
            this.byteOffset++;
            numBits -= 8;
        }
        if (numBits <= 0) {
            return result;
        }
        bitsToNotRead = 8 - numBits;
        result = (result << numBits) | ((this.bytes[this.byteOffset] & ((WebView.NORMAL_MODE_ALPHA >> bitsToNotRead) << bitsToNotRead)) >> bitsToNotRead);
        this.bitOffset += numBits;
        return result;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }
}
