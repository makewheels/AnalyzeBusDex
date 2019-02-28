package com.e4a.runtime.components.impl.android.n36.download;

public class Info {
    private Integer done;
    private String path;
    private Integer thid;

    public Info(String path, Integer thid, Integer done) {
        this.path = path;
        this.thid = thid;
        this.done = done;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getThid() {
        return this.thid;
    }

    public void setThid(Integer thid) {
        this.thid = thid;
    }

    public Integer getDone() {
        return this.done;
    }

    public void setDone(Integer done) {
        this.done = done;
    }
}
