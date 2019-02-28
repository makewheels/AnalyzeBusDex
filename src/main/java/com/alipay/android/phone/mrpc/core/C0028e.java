package com.alipay.android.phone.mrpc.core;

import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.alipay.android.phone.mrpc.core.e */
final class C0028e extends DefaultRedirectHandler {
    /* renamed from: a */
    int f30a;
    /* renamed from: b */
    final /* synthetic */ C0027d f31b;

    C0028e(C0027d c0027d) {
        this.f31b = c0027d;
    }

    public final boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        this.f30a++;
        boolean isRedirectRequested = super.isRedirectRequested(httpResponse, httpContext);
        if (isRedirectRequested || this.f30a >= 5) {
            return isRedirectRequested;
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        return (statusCode == ErrorCode.ERROR_FORCE_SYSTEM_WEBVIEW_INNER_FAILED_TO_CREATE || statusCode == ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY) ? true : isRedirectRequested;
    }
}
