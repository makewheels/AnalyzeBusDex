package com.e4a.runtime.components.impl.android.p020;

import android.text.TextUtils;

/* renamed from: com.e4a.runtime.components.impl.android.支付宝类库.PayResult */
public final class PayResult {
    private String memo;
    private String result;
    private String resultStatus;

    public PayResult(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(";")) {
                if (str2.startsWith("resultStatus")) {
                    this.resultStatus = gatValue(str2, "resultStatus");
                }
                if (str2.startsWith("result")) {
                    this.result = gatValue(str2, "result");
                }
                if (str2.startsWith("memo")) {
                    this.memo = gatValue(str2, "memo");
                }
            }
        }
    }

    public String toString() {
        return "resultStatus={" + this.resultStatus + "};memo={" + this.memo + "};result={" + this.result + "}";
    }

    private String gatValue(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str3.length() + str.indexOf(str3), str.lastIndexOf("}"));
    }

    public String getResultStatus() {
        return this.resultStatus;
    }

    public String getMemo() {
        return this.memo;
    }

    public String getResult() {
        return this.result;
    }
}
