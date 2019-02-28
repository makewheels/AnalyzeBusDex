package com.umeng.analytics.social;

import android.text.TextUtils;
import com.umeng.analytics.C1233a;
import java.util.Locale;
import p054u.aly.bi_常量类;

public class UMPlatformData {
    /* renamed from: a */
    private UMedia f5679a;
    /* renamed from: b */
    private String f5680b = bi_常量类.f6358b_空串;
    /* renamed from: c */
    private String f5681c = bi_常量类.f6358b_空串;
    /* renamed from: d */
    private String f5682d;
    /* renamed from: e */
    private GENDER f5683e;

    public enum GENDER {
        MALE(0) {
            public String toString() {
                return String.format(Locale.US, "Male:%d", new Object[]{Integer.valueOf(this.value)});
            }
        },
        FEMALE(1) {
            public String toString() {
                return String.format(Locale.US, "Female:%d", new Object[]{Integer.valueOf(this.value)});
            }
        };
        
        public int value;

        private GENDER(int i) {
            this.value = i;
        }
    }

    public enum UMedia {
        SINA_WEIBO {
            public String toString() {
                return "sina";
            }
        },
        TENCENT_WEIBO {
            public String toString() {
                return "tencent";
            }
        },
        TENCENT_QZONE {
            public String toString() {
                return "qzone";
            }
        },
        TENCENT_QQ {
            public String toString() {
                return "qq";
            }
        },
        WEIXIN_FRIENDS {
            public String toString() {
                return "wxsesion";
            }
        },
        WEIXIN_CIRCLE {
            public String toString() {
                return "wxtimeline";
            }
        },
        RENREN {
            public String toString() {
                return "renren";
            }
        },
        DOUBAN {
            public String toString() {
                return "douban";
            }
        }
    }

    public UMPlatformData(UMedia uMedia, String str) {
        if (uMedia == null || TextUtils.isEmpty(str)) {
            C1265b.m8471b(C1233a.f5589e, "parameter is not valid");
            return;
        }
        this.f5679a = uMedia;
        this.f5680b = str;
    }

    public String getWeiboId() {
        return this.f5681c;
    }

    public void setWeiboId(String str) {
        this.f5681c = str;
    }

    public UMedia getMeida() {
        return this.f5679a;
    }

    public String getUsid() {
        return this.f5680b;
    }

    public String getName() {
        return this.f5682d;
    }

    public void setName(String str) {
        this.f5682d = str;
    }

    public GENDER getGender() {
        return this.f5683e;
    }

    public void setGender(GENDER gender) {
        this.f5683e = gender;
    }

    public boolean isValid() {
        if (this.f5679a == null || TextUtils.isEmpty(this.f5680b)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "UMPlatformData [meida=" + this.f5679a + ", usid=" + this.f5680b + ", weiboId=" + this.f5681c + ", name=" + this.f5682d + ", gender=" + this.f5683e + "]";
    }
}
