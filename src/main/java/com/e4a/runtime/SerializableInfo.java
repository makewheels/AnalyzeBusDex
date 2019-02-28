package com.e4a.runtime;

import java.io.Serializable;

public class SerializableInfo implements Serializable {
    private int Id;
    private int iconId;
    private boolean noclear;
    private boolean sound;
    /* renamed from: 信息 */
    private String f4269;
    /* renamed from: 名称 */
    private String f4270;
    /* renamed from: 标题 */
    private String f4271;

    public SerializableInfo(int 通知ID, String 通知名称, String 通知标题, String 通知信息, int 图标资源, boolean 播放声音, boolean 不可清除) {
        this.Id = 通知ID;
        this.f4270 = 通知名称;
        this.f4271 = 通知标题;
        this.f4269 = 通知信息;
        this.iconId = 图标资源;
        this.sound = 播放声音;
        this.noclear = 不可清除;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int 通知ID) {
        this.Id = 通知ID;
    }

    /* renamed from: get名称 */
    public String m5411get() {
        return this.f4270;
    }

    /* renamed from: set名称 */
    public void m5414set(String 通知名称) {
        this.f4270 = 通知名称;
    }

    /* renamed from: get标题 */
    public String m5412get() {
        return this.f4271;
    }

    /* renamed from: set标题 */
    public void m5415set(String 通知标题) {
        this.f4271 = 通知标题;
    }

    /* renamed from: get信息 */
    public String m5410get() {
        return this.f4269;
    }

    /* renamed from: set信息 */
    public void m5413set(String 通知信息) {
        this.f4269 = 通知信息;
    }

    public int geticonId() {
        return this.iconId;
    }

    public void seticonId(int 图标资源) {
        this.iconId = 图标资源;
    }

    public boolean getsound() {
        return this.sound;
    }

    public void setsound(boolean 播放声音) {
        this.sound = 播放声音;
    }

    public boolean getnoclear() {
        return this.noclear;
    }

    public void setnoclear(boolean 不可清除) {
        this.noclear = 不可清除;
    }
}
