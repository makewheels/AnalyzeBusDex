package com.google.zxing.oned.rss.expanded.decoders;

import com.e4a.runtime.components.Component;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public abstract class AbstractExpandedDecoder {
    private final GeneralAppIdDecoder generalDecoder;
    private final BitArray information;

    public abstract String parseInformation() throws NotFoundException;

    AbstractExpandedDecoder(BitArray information) {
        this.information = information;
        this.generalDecoder = new GeneralAppIdDecoder(information);
    }

    protected BitArray getInformation() {
        return this.information;
    }

    protected GeneralAppIdDecoder getGeneralDecoder() {
        return this.generalDecoder;
    }

    public static AbstractExpandedDecoder createDecoder(BitArray information) {
        if (information.get(1)) {
            return new AI01AndOtherAIs(information);
        }
        if (!information.get(2)) {
            return new AnyAIDecoder(information);
        }
        switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(information, 1, 4)) {
            case 4:
                return new AI013103decoder(information);
            case 5:
                return new AI01320xDecoder(information);
            default:
                switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(information, 1, 5)) {
                    case 12:
                        return new AI01392xDecoder(information);
                    case 13:
                        return new AI01393xDecoder(information);
                    default:
                        switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(information, 1, 7)) {
                            case Component.KEYCODE_PERIOD /*56*/:
                                return new AI013x0x1xDecoder(information, "310", "11");
                            case Component.KEYCODE_LEFT_ALT /*57*/:
                                return new AI013x0x1xDecoder(information, "320", "11");
                            case Component.KEYCODE_RIGHT_ALT /*58*/:
                                return new AI013x0x1xDecoder(information, "310", "13");
                            case Component.KEYCODE_LEFT_SHIFT /*59*/:
                                return new AI013x0x1xDecoder(information, "320", "13");
                            case Component.KEYCODE_RIGHT_SHIFT /*60*/:
                                return new AI013x0x1xDecoder(information, "310", "15");
                            case Component.KEYCODE_TAB /*61*/:
                                return new AI013x0x1xDecoder(information, "320", "15");
                            case Component.KEYCODE_SPACE /*62*/:
                                return new AI013x0x1xDecoder(information, "310", "17");
                            case Component.KEYCODE_SYM /*63*/:
                                return new AI013x0x1xDecoder(information, "320", "17");
                            default:
                                throw new IllegalStateException("unknown decoder: " + information);
                        }
                }
        }
    }
}
