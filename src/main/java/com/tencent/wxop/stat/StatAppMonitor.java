package com.tencent.wxop.stat;

public class StatAppMonitor implements Cloneable {
    public static final int FAILURE_RESULT_TYPE = 1;
    public static final int LOGIC_FAILURE_RESULT_TYPE = 2;
    public static final int SUCCESS_RESULT_TYPE = 0;
    /* renamed from: a */
    private String f5202a = null;
    /* renamed from: b */
    private long f5203b = 0;
    /* renamed from: c */
    private long f5204c = 0;
    /* renamed from: d */
    private int f5205d = 0;
    /* renamed from: e */
    private long f5206e = 0;
    /* renamed from: f */
    private int f5207f = 0;
    /* renamed from: g */
    private int f5208g = 1;

    public StatAppMonitor(String str) {
        this.f5202a = str;
    }

    public StatAppMonitor(String str, int i, int i2, long j, long j2, long j3, int i3) {
        this.f5202a = str;
        this.f5203b = j;
        this.f5204c = j2;
        this.f5205d = i;
        this.f5206e = j3;
        this.f5207f = i2;
        this.f5208g = i3;
    }

    public StatAppMonitor clone() {
        try {
            return (StatAppMonitor) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getInterfaceName() {
        return this.f5202a;
    }

    public long getMillisecondsConsume() {
        return this.f5206e;
    }

    public long getReqSize() {
        return this.f5203b;
    }

    public long getRespSize() {
        return this.f5204c;
    }

    public int getResultType() {
        return this.f5205d;
    }

    public int getReturnCode() {
        return this.f5207f;
    }

    public int getSampling() {
        return this.f5208g;
    }

    public void setInterfaceName(String str) {
        this.f5202a = str;
    }

    public void setMillisecondsConsume(long j) {
        this.f5206e = j;
    }

    public void setReqSize(long j) {
        this.f5203b = j;
    }

    public void setRespSize(long j) {
        this.f5204c = j;
    }

    public void setResultType(int i) {
        this.f5205d = i;
    }

    public void setReturnCode(int i) {
        this.f5207f = i;
    }

    public void setSampling(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.f5208g = i;
    }
}
