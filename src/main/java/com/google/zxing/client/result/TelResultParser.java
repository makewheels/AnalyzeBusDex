package com.google.zxing.client.result;

import com.google.zxing.Result;
import com.tencent.smtt.sdk.WebView;

public final class TelResultParser extends ResultParser {
    public TelParsedResult parse(Result result) {
        String rawText = result.getText();
        if (!rawText.startsWith(WebView.SCHEME_TEL) && !rawText.startsWith("TEL:")) {
            return null;
        }
        String telURI;
        if (rawText.startsWith("TEL:")) {
            telURI = WebView.SCHEME_TEL + rawText.substring(4);
        } else {
            telURI = rawText;
        }
        int queryStart = rawText.indexOf(63, 4);
        return new TelParsedResult(queryStart < 0 ? rawText.substring(4) : rawText.substring(4, queryStart), telURI, null);
    }
}
