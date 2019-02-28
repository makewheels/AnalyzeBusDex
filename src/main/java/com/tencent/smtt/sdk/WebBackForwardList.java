package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

public class WebBackForwardList {
    /* renamed from: a */
    private IX5WebBackForwardList f4878a = null;
    /* renamed from: b */
    private android.webkit.WebBackForwardList f4879b = null;

    /* renamed from: a */
    static WebBackForwardList m7644a(android.webkit.WebBackForwardList webBackForwardList) {
        if (webBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList2 = new WebBackForwardList();
        webBackForwardList2.f4879b = webBackForwardList;
        return webBackForwardList2;
    }

    /* renamed from: a */
    static WebBackForwardList m7645a(IX5WebBackForwardList iX5WebBackForwardList) {
        if (iX5WebBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList = new WebBackForwardList();
        webBackForwardList.f4878a = iX5WebBackForwardList;
        return webBackForwardList;
    }

    public int getCurrentIndex() {
        return this.f4878a != null ? this.f4878a.getCurrentIndex() : this.f4879b.getCurrentIndex();
    }

    public WebHistoryItem getCurrentItem() {
        return this.f4878a != null ? WebHistoryItem.m7647a(this.f4878a.getCurrentItem()) : WebHistoryItem.m7646a(this.f4879b.getCurrentItem());
    }

    public WebHistoryItem getItemAtIndex(int i) {
        return this.f4878a != null ? WebHistoryItem.m7647a(this.f4878a.getItemAtIndex(i)) : WebHistoryItem.m7646a(this.f4879b.getItemAtIndex(i));
    }

    public int getSize() {
        return this.f4878a != null ? this.f4878a.getSize() : this.f4879b.getSize();
    }
}
