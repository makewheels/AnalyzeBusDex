package com.tencent.wxop.stat;

public class StatSpecifyReportedInfo {
    /* renamed from: a */
    private String f5279a = null;
    /* renamed from: b */
    private String f5280b = null;
    /* renamed from: c */
    private String f5281c = null;
    /* renamed from: d */
    private boolean f5282d = false;
    /* renamed from: e */
    private boolean f5283e = false;

    public String getAppKey() {
        return this.f5279a;
    }

    public String getInstallChannel() {
        return this.f5280b;
    }

    public String getVersion() {
        return this.f5281c;
    }

    public boolean isImportant() {
        return this.f5283e;
    }

    public boolean isSendImmediately() {
        return this.f5282d;
    }

    public void setAppKey(String str) {
        this.f5279a = str;
    }

    public void setImportant(boolean z) {
        this.f5283e = z;
    }

    public void setInstallChannel(String str) {
        this.f5280b = str;
    }

    public void setSendImmediately(boolean z) {
        this.f5282d = z;
    }

    public void setVersion(String str) {
        this.f5281c = str;
    }

    public String toString() {
        return "StatSpecifyReportedInfo [appKey=" + this.f5279a + ", installChannel=" + this.f5280b + ", version=" + this.f5281c + ", sendImmediately=" + this.f5282d + ", isImportant=" + this.f5283e + "]";
    }
}
