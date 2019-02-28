package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

public class WebHistoryItem {
    /* renamed from: a */
    private IX5WebHistoryItem f4880a = null;
    /* renamed from: b */
    private android.webkit.WebHistoryItem f4881b = null;

    private WebHistoryItem() {
    }

    /* renamed from: a */
    static WebHistoryItem m7646a(android.webkit.WebHistoryItem webHistoryItem) {
        if (webHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem2 = new WebHistoryItem();
        webHistoryItem2.f4881b = webHistoryItem;
        return webHistoryItem2;
    }

    /* renamed from: a */
    static WebHistoryItem m7647a(IX5WebHistoryItem iX5WebHistoryItem) {
        if (iX5WebHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem = new WebHistoryItem();
        webHistoryItem.f4880a = iX5WebHistoryItem;
        return webHistoryItem;
    }

    public Bitmap getFavicon() {
        return this.f4880a != null ? this.f4880a.getFavicon() : this.f4881b.getFavicon();
    }

    public String getOriginalUrl() {
        return this.f4880a != null ? this.f4880a.getOriginalUrl() : this.f4881b.getOriginalUrl();
    }

    public String getTitle() {
        return this.f4880a != null ? this.f4880a.getTitle() : this.f4881b.getTitle();
    }

    public String getUrl() {
        return this.f4880a != null ? this.f4880a.getUrl() : this.f4881b.getUrl();
    }
}
