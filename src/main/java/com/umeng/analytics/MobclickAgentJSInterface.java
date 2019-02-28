package com.umeng.analytics;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

public class MobclickAgentJSInterface {
    /* renamed from: a */
    private Context f5574a;

    /* renamed from: com.umeng.analytics.MobclickAgentJSInterface$a */
    final class C1226a extends WebChromeClient {
        /* renamed from: a */
        WebChromeClient f5570a = null;
        /* renamed from: b */
        final /* synthetic */ MobclickAgentJSInterface f5571b;
        /* renamed from: c */
        private final String f5572c = "ekv";
        /* renamed from: d */
        private final String f5573d = "event";

        public C1226a(MobclickAgentJSInterface mobclickAgentJSInterface, WebChromeClient webChromeClient) {
            this.f5571b = mobclickAgentJSInterface;
            if (webChromeClient == null) {
                this.f5570a = new WebChromeClient();
            } else {
                this.f5570a = webChromeClient;
            }
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("ekv".equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    Map hashMap = new HashMap();
                    String str4 = (String) jSONObject.remove("id");
                    int intValue = jSONObject.isNull("duration") ? 0 : ((Integer) jSONObject.remove("duration")).intValue();
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str5 = (String) keys.next();
                        hashMap.put(str5, jSONObject.getString(str5));
                    }
                    MobclickAgent.getAgent().m8390a(this.f5571b.f5574a, str4, hashMap, (long) intValue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (!"event".equals(str2)) {
                return this.f5570a.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            } else {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    String optString = jSONObject2.optString("label");
                    if (bi_常量类.f6358b_空串.equals(optString)) {
                        optString = null;
                    }
                    MobclickAgent.getAgent().m8387a(this.f5571b.f5574a, jSONObject2.getString("tag"), optString, (long) jSONObject2.optInt("duration"), 1);
                } catch (Exception e2) {
                }
            }
            jsPromptResult.confirm();
            return true;
        }

        public void onCloseWindow(WebView webView) {
            this.f5570a.onCloseWindow(webView);
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            return this.f5570a.onCreateWindow(webView, z, z2, message);
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return this.f5570a.onJsAlert(webView, str, str2, jsResult);
        }

        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            return this.f5570a.onJsBeforeUnload(webView, str, str2, jsResult);
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            return this.f5570a.onJsConfirm(webView, str, str2, jsResult);
        }

        public void onProgressChanged(WebView webView, int i) {
            this.f5570a.onProgressChanged(webView, i);
        }

        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            this.f5570a.onReceivedIcon(webView, bitmap);
        }

        public void onReceivedTitle(WebView webView, String str) {
            this.f5570a.onReceivedTitle(webView, str);
        }

        public void onRequestFocus(WebView webView) {
            this.f5570a.onRequestFocus(webView);
        }
    }

    public MobclickAgentJSInterface(Context context, WebView webView) {
        this.f5574a = context;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new C1226a(this, null));
    }

    public MobclickAgentJSInterface(Context context, WebView webView, WebChromeClient webChromeClient) {
        this.f5574a = context;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new C1226a(this, webChromeClient));
    }
}
