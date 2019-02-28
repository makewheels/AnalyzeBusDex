package com.e4a.runtime.components.impl.android.n15;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebIconDatabase;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.android.mainActivity.OnActivityResultListener;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.android.ViewComponent;
import com.e4a.runtime.events.EventDispatcher;
import com.e4a.runtime.parameters.IntegerReferenceParameter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import org.apache.http.util.EncodingUtils;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.n15.浏览框Impl */
public class C0713Impl extends ViewComponent implements C0698, OnActivityResultListener {
    private final int FILE_SELECTED = 444;
    private final int RESULT_OK = -1;
    private int currX;
    private int currY;
    private int lastX;
    private int lastY;
    private GestureDetector mGestureDetector;
    private Handler mHandler = new C07114();
    private ValueCallback mUploadMessage;
    /* renamed from: 可显示对话框 */
    private boolean f4287 = true;
    /* renamed from: 子窗口 */
    private boolean f4288;
    /* renamed from: 自动拉伸 */
    private boolean f4289 = false;

    /* renamed from: com.e4a.runtime.components.impl.android.n15.浏览框Impl$1 */
    class C06991 implements DownloadListener {
        C06991() {
        }

        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
            C0713Impl.this.mo964(url, contentLength);
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n15.浏览框Impl$MyWebChromeClient */
    private class MyWebChromeClient extends WebChromeClient {
        private MyWebChromeClient() {
        }

        public void openFileChooser(ValueCallback uploadMsg) {
            openFileChooser(uploadMsg, bi_常量类.f6358b_空串);
        }

        public void openFileChooser(ValueCallback uploadMsg, String acceptType) {
            C0713Impl.this.mUploadMessage = uploadMsg;
        }

        public void openFileChooser(ValueCallback uploadMsg, String acceptType, String capture) {
            openFileChooser(uploadMsg, acceptType);
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n15.浏览框Impl$3 */
    class C07103 extends WebViewClient {
        C07103() {
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            IntegerReferenceParameter shield = new IntegerReferenceParameter(1);
            C0713Impl.this.mo941(url, shield);
            switch (shield.get()) {
                case 1:
                    return false;
                case 2:
                    mainActivity.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    return true;
                case 3:
                    return true;
                default:
                    return false;
            }
        }

        public void onPageStarted(WebView view, String url, Bitmap facicon) {
            super.onPageStarted(view, url, facicon);
            C0713Impl.this.mo965(url);
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            C0713Impl.this.mo979(url);
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            C0713Impl.this.mo978(errorCode, failingUrl);
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n15.浏览框Impl$4 */
    class C07114 extends Handler {
        C07114() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == 123) {
                C0713Impl.this.mo967(msg.getData().getString("webmsg"));
            }
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n15.浏览框Impl$MyWebView */
    private class MyWebView extends WebView {
        public void getFocus() {
            requestFocus();
        }

        public void removeFocus() {
            clearFocus();
        }

        public MyWebView(Context context) {
            super(context);
            C0713Impl.this.mGestureDetector = new GestureDetector(new SimpleOnGestureListener(C0713Impl.this) {
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    int deltaX = (int) (e1.getRawX() - e2.getRawX());
                    int deltaY = (int) (e1.getRawY() - e2.getRawY());
                    int direction = Math.abs(deltaX) > Math.abs(deltaY) ? deltaX > 0 ? 4 : 5 : deltaY > 0 ? 2 : 3;
                    C0713Impl.this.mo974(direction);
                    return false;
                }

                public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                    int direction = Math.abs(distanceX) > Math.abs(distanceY) ? distanceX > 0.0f ? 8 : 9 : distanceY > 0.0f ? 6 : 7;
                    C0713Impl.this.mo974(direction);
                    return false;
                }

                public boolean onSingleTapConfirmed(MotionEvent e) {
                    C0713Impl.this.mo974(0);
                    MyWebView.this.getFocus();
                    return false;
                }

                public boolean onDoubleTap(MotionEvent e) {
                    C0713Impl.this.mo974(1);
                    return false;
                }
            });
        }

        public boolean dispatchTouchEvent(MotionEvent ev) {
            C0713Impl.this.mGestureDetector.onTouchEvent(ev);
            return super.dispatchTouchEvent(ev);
        }

        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int expandSpec;
            if (C0713Impl.this.f4289) {
                expandSpec = MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
            } else {
                expandSpec = heightMeasureSpec;
            }
            super.onMeasure(widthMeasureSpec, expandSpec);
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n15.浏览框Impl$WebAppInterface */
    public class WebAppInterface {
        WebAppInterface() {
        }

        public void jsAndroid(String toast) {
            Bundle bundle = new Bundle();
            bundle.putString("webmsg", toast);
            Message msg = new Message();
            msg.setData(bundle);
            msg.what = 123;
            C0713Impl.this.mHandler.sendMessage(msg);
        }
    }

    /* renamed from: 自动拉伸高度 */
    public void mo973(boolean value) {
        this.f4289 = value;
    }

    public C0713Impl(ComponentContainer container) {
        super(container);
    }

    public String getDirs(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return path;
    }

    protected View createView() {
        final MyWebView web = new MyWebView(mainActivity.getContext());
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportMultipleWindows(true);
        webSettings.setPluginState(PluginState.ON);
        webSettings.setBlockNetworkImage(false);
        if (VERSION.SDK_INT > 8) {
            web.setOverScrollMode(2);
        }
        webSettings.setDatabaseEnabled(true);
        String dir = mainActivity.getContext().getDir("database", 0).getPath();
        webSettings.setDatabasePath(dir);
        webSettings.setDomStorageEnabled(true);
        webSettings.setGeolocationDatabasePath(dir);
        webSettings.setGeolocationEnabled(true);
        webSettings.setAppCachePath(mainActivity.getContext().getDir("cache", 0).getPath());
        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(2);
        webSettings.setAppCacheMaxSize(8388608);
        webSettings.setAllowFileAccess(true);
        web.setFocusable(true);
        web.requestFocus();
        web.requestFocusFromTouch();
        web.setLongClickable(true);
        WebIconDatabase.getInstance().open(getDirs(mainActivity.getContext().getCacheDir().getAbsolutePath() + "/icons/"));
        web.setDownloadListener(new C06991());
        mainActivity.getContext().addOnActivityResultListener(this);
        web.setWebChromeClient(new MyWebChromeClient() {

            /* renamed from: com.e4a.runtime.components.impl.android.n15.浏览框Impl$2$3 */
            class C07023 implements OnKeyListener {
                C07023() {
                }

                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    return true;
                }
            }

            /* renamed from: com.e4a.runtime.components.impl.android.n15.浏览框Impl$2$6 */
            class C07056 implements OnKeyListener {
                C07056() {
                }

                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    return true;
                }
            }

            /* renamed from: com.e4a.runtime.components.impl.android.n15.浏览框Impl$2$9 */
            class C07089 implements OnKeyListener {
                C07089() {
                }

                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    return true;
                }
            }

            public boolean onCreateWindow(WebView view, boolean dialog, boolean userGesture, Message resultMsg) {
                final MyWebView newweb = new MyWebView(mainActivity.getContext());
                newweb.setLayoutParams(new LayoutParams(-1, -1));
                WebSettings setting = newweb.getSettings();
                setting.setJavaScriptEnabled(true);
                setting.setPluginState(PluginState.ON);
                setting.setSupportZoom(true);
                setting.setBuiltInZoomControls(true);
                setting.setDatabaseEnabled(true);
                String dir = mainActivity.getContext().getDir("database", 0).getPath();
                setting.setDomStorageEnabled(true);
                setting.setGeolocationDatabasePath(dir);
                setting.setGeolocationEnabled(true);
                setting.setAppCachePath(mainActivity.getContext().getDir("cache", 0).getPath());
                setting.setAppCacheEnabled(true);
                setting.setCacheMode(2);
                setting.setAppCacheMaxSize(8388608);
                setting.setAllowFileAccess(true);
                setting.setDatabasePath(dir);
                setting.setUseWideViewPort(true);
                setting.setLoadWithOverviewMode(true);
                setting.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
                web.addView(newweb);
                if (C0713Impl.this.f4288) {
                    newweb.bringToFront();
                }
                newweb.setWebViewClient(new WebViewClient() {
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        if (C0713Impl.this.f4288) {
                            return false;
                        }
                        web.removeView(newweb);
                        web.loadUrl(url);
                        return true;
                    }

                    public void onPageStarted(WebView view, String url, Bitmap facicon) {
                        super.onPageStarted(view, url, facicon);
                        C0713Impl.this.mo961(url);
                    }

                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                        C0713Impl.this.mo962(url);
                    }
                });
                resultMsg.obj.setWebView(newweb);
                resultMsg.sendToTarget();
                return true;
            }

            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                C0713Impl.this.mo981(newProgress);
            }

            public boolean onJsAlert(WebView view, final String url, final String message, final JsResult result) {
                Builder builder = new Builder(view.getContext());
                if (C0713Impl.this.f4287) {
                    builder.setTitle("信息").setMessage(message).setPositiveButton("确定", new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            result.confirm();
                            C0713Impl.this.mo935(url, message);
                        }
                    });
                    builder.setOnKeyListener(new C07023());
                    builder.setCancelable(false);
                    builder.create().show();
                } else {
                    result.confirm();
                }
                return true;
            }

            public boolean onJsConfirm(WebView view, final String url, final String message, final JsResult result) {
                Builder builder = new Builder(view.getContext());
                if (C0713Impl.this.f4287) {
                    builder.setTitle("询问");
                    builder.setMessage(message);
                    builder.setPositiveButton("确定", new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            result.confirm();
                            C0713Impl.this.mo975(url, message, 0);
                        }
                    });
                    builder.setNegativeButton("取消", new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            result.cancel();
                            C0713Impl.this.mo975(url, message, 1);
                        }
                    });
                    builder.setOnKeyListener(new C07056());
                    builder.setCancelable(false);
                    builder.create().show();
                } else {
                    result.confirm();
                }
                return true;
            }

            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                Builder builder = new Builder(view.getContext());
                if (C0713Impl.this.f4287) {
                    builder.setTitle("输入").setMessage(message);
                    final EditText et = new EditText(view.getContext());
                    et.setSingleLine();
                    et.setText(defaultValue);
                    builder.setView(et);
                    final JsPromptResult jsPromptResult = result;
                    final String str = url;
                    final String str2 = message;
                    builder.setPositiveButton("确定", new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            String text = et.getText().toString();
                            jsPromptResult.confirm(text);
                            C0713Impl.this.mo980(str, str2, text, 0);
                        }
                    });
                    jsPromptResult = result;
                    str = url;
                    str2 = message;
                    builder.setNegativeButton("取消", new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            String text = et.getText().toString();
                            jsPromptResult.cancel();
                            C0713Impl.this.mo980(str, str2, text, 1);
                        }
                    });
                    builder.setOnKeyListener(new C07089());
                    builder.setCancelable(false);
                    builder.create().show();
                } else {
                    result.confirm(defaultValue);
                }
                return true;
            }

            public void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, QuotaUpdater quotaUpdater) {
                quotaUpdater.updateQuota(2 * estimatedSize);
            }

            public void onGeolocationPermissionsShowPrompt(String origin, Callback callback) {
                callback.invoke(origin, true, false);
                super.onGeolocationPermissionsShowPrompt(origin, callback);
            }

            public void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota, QuotaUpdater quotaUpdater) {
                quotaUpdater.updateQuota(2 * spaceNeeded);
            }

            public void openFileChooser(ValueCallback uploadMsg, String acceptType, String capture) {
                if (C0713Impl.this.mUploadMessage == null) {
                    C0713Impl.this.mUploadMessage = uploadMsg;
                    Intent i = new Intent("android.intent.action.GET_CONTENT");
                    i.addCategory("android.intent.category.OPENABLE");
                    i.setType("*/*");
                    mainActivity.getContext().startActivityForResult(Intent.createChooser(i, "选择文件"), 444);
                }
            }

            public void openFileChooser(ValueCallback uploadMsg, String acceptType) {
                if (C0713Impl.this.mUploadMessage == null) {
                    C0713Impl.this.mUploadMessage = uploadMsg;
                    Intent i = new Intent("android.intent.action.GET_CONTENT");
                    i.addCategory("android.intent.category.OPENABLE");
                    i.setType("*/*");
                    mainActivity.getContext().startActivityForResult(Intent.createChooser(i, "选择文件"), 444);
                }
            }

            public void openFileChooser(ValueCallback uploadMsg) {
                if (C0713Impl.this.mUploadMessage == null) {
                    C0713Impl.this.mUploadMessage = uploadMsg;
                    Intent i = new Intent("android.intent.action.GET_CONTENT");
                    i.addCategory("android.intent.category.OPENABLE");
                    i.setType("*/*");
                    mainActivity.getContext().startActivityForResult(Intent.createChooser(i, "选择文件"), 444);
                }
            }
        });
        web.setWebViewClient(new C07103());
        return web;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 444 && this.mUploadMessage != null) {
            Uri result = (data == null || resultCode != -1) ? null : data.getData();
            this.mUploadMessage.onReceiveValue(result);
            this.mUploadMessage = null;
        }
    }

    /* renamed from: 即将跳转 */
    public void mo941(String url, IntegerReferenceParameter type) {
        EventDispatcher.dispatchEvent(this, "即将跳转", url, type);
    }

    /* renamed from: 开始下载 */
    public void mo964(String url, long contentLength) {
        EventDispatcher.dispatchEvent(this, "开始下载", url, Long.valueOf(contentLength));
    }

    /* renamed from: 触摸手势 */
    public void mo974(int direction) {
        EventDispatcher.dispatchEvent(this, "触摸手势", Integer.valueOf(direction));
    }

    /* renamed from: 加载数据 */
    public void mo940(String baseUrl, String data) {
        try {
            ((MyWebView) getView()).loadDataWithBaseURL(baseUrl, data, "text/html", "utf-8", null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /* renamed from: 跳转 */
    public void mo976(String URL) {
        try {
            ((MyWebView) getView()).loadUrl(URL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /* renamed from: 跳转2 */
    public void mo9772(String URL, String param) {
        try {
            ((MyWebView) getView()).postUrl(URL, EncodingUtils.getBytes(param, "BASE64"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /* renamed from: 开始载入 */
    public void mo965(String url) {
        EventDispatcher.dispatchEvent(this, "开始载入", url);
    }

    /* renamed from: 子窗口开始载入 */
    public void mo961(String url) {
        EventDispatcher.dispatchEvent(this, "子窗口开始载入", url);
    }

    /* renamed from: 进度改变 */
    public void mo981(int newProgress) {
        EventDispatcher.dispatchEvent(this, "进度改变", Integer.valueOf(newProgress));
    }

    /* renamed from: 载入完毕 */
    public void mo979(String url) {
        EventDispatcher.dispatchEvent(this, "载入完毕", url);
    }

    /* renamed from: 载入失败 */
    public void mo978(int errorCode, String failingUrl) {
        EventDispatcher.dispatchEvent(this, "载入失败", Integer.valueOf(errorCode), failingUrl);
    }

    /* renamed from: 信息框被单击 */
    public void mo935(String url, String message) {
        EventDispatcher.dispatchEvent(this, "信息框被单击", url, message);
    }

    /* renamed from: 询问框被单击 */
    public void mo975(String url, String message, int buttonId) {
        EventDispatcher.dispatchEvent(this, "询问框被单击", url, message, Integer.valueOf(buttonId));
    }

    /* renamed from: 输入框被单击 */
    public void mo980(String url, String message, String text, int buttonId) {
        EventDispatcher.dispatchEvent(this, "输入框被单击", url, message, text, Integer.valueOf(buttonId));
    }

    /* renamed from: 子窗口载入完毕 */
    public void mo962(String url) {
        EventDispatcher.dispatchEvent(this, "子窗口载入完毕", url);
    }

    /* renamed from: 后退 */
    public void mo952() {
        ((MyWebView) getView()).goBack();
    }

    /* renamed from: 重载 */
    public void mo983() {
        ((MyWebView) getView()).reload();
    }

    /* renamed from: 前进 */
    public void mo939() {
        ((MyWebView) getView()).goForward();
    }

    /* renamed from: 停止 */
    public void mo936() {
        ((MyWebView) getView()).stopLoading();
    }

    /* renamed from: 显示方式 */
    public void mo969(int style) {
        WebSettings webSettings = ((MyWebView) getView()).getSettings();
        if (style == 1) {
            webSettings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        } else {
            webSettings.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        }
    }

    /* renamed from: 宽屏显示 */
    public void mo963(boolean value) {
        ((MyWebView) getView()).getSettings().setUseWideViewPort(value);
    }

    /* renamed from: 置请求头 */
    public void mo972(String value) {
        ((MyWebView) getView()).getSettings().setUserAgentString(value);
    }

    /* renamed from: 取请求头 */
    public String mo947() {
        return ((MyWebView) getView()).getSettings().getUserAgentString();
    }

    /* renamed from: 取默认请求头 */
    public String mo949() {
        WebSettings webSettings = ((MyWebView) getView()).getSettings();
        if (VERSION.SDK_INT >= 17) {
            return WebSettings.getDefaultUserAgent(mainActivity.getContext());
        }
        return webSettings.getUserAgentString();
    }

    /* renamed from: 置cookie */
    public void mo971cookie(String url, String value) {
        CookieSyncManager.createInstance(mainActivity.getContext()).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie(url, value);
        CookieSyncManager.getInstance().sync();
    }

    /* renamed from: 取cookie */
    public String mo942cookie(String url) {
        CookieSyncManager.createInstance(mainActivity.getContext()).sync();
        return CookieManager.getInstance().getCookie(url);
    }

    /* renamed from: 清空cookie */
    public void mo970cookie() {
        CookieSyncManager cookieSyncMngr = CookieSyncManager.createInstance(mainActivity.getContext());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeSessionCookie();
        cookieManager.removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    /* renamed from: 显示子窗口 */
    public void mo968(boolean value) {
        this.f4288 = value;
    }

    /* renamed from: 保存密码 */
    public void mo933(boolean value) {
        ((MyWebView) getView()).getSettings().setSavePassword(value);
    }

    /* renamed from: 保存表单 */
    public void mo934(boolean value) {
        ((MyWebView) getView()).getSettings().setSaveFormData(value);
    }

    /* renamed from: 启用JS */
    public void mo954JS(boolean value) {
        ((MyWebView) getView()).getSettings().setJavaScriptEnabled(value);
    }

    /* renamed from: 启用缩放 */
    public void mo958(boolean value) {
        WebSettings webSettings = ((MyWebView) getView()).getSettings();
        webSettings.setSupportZoom(value);
        webSettings.setBuiltInZoomControls(value);
    }

    /* renamed from: 启用缩放按钮 */
    public void mo959(boolean value) {
        WebSettings webSettings = ((MyWebView) getView()).getSettings();
        if (VERSION.SDK_INT >= 11) {
            webSettings.setDisplayZoomControls(value);
        }
    }

    /* renamed from: 启用插件 */
    public void mo956(boolean value) {
        WebSettings webSettings = ((MyWebView) getView()).getSettings();
        if (value) {
            webSettings.setPluginState(PluginState.ON);
        } else {
            webSettings.setPluginState(PluginState.OFF);
        }
    }

    /* renamed from: 启用DomStorage */
    public void mo953DomStorage(boolean value) {
        WebSettings webSettings = ((MyWebView) getView()).getSettings();
        webSettings.setDatabaseEnabled(value);
        webSettings.setDatabasePath(mainActivity.getContext().getDir("database", 0).getPath());
        webSettings.setDomStorageEnabled(value);
    }

    /* renamed from: 启用地理定位 */
    public void mo955(boolean value) {
        WebSettings webSettings = ((MyWebView) getView()).getSettings();
        webSettings.setDatabaseEnabled(value);
        webSettings.setGeolocationDatabasePath(mainActivity.getContext().getDir("database", 0).getPath());
        webSettings.setGeolocationEnabled(value);
        webSettings.setDomStorageEnabled(value);
    }

    /* renamed from: 启用缓存 */
    public void mo957(boolean value) {
        WebSettings webSettings = ((MyWebView) getView()).getSettings();
        webSettings.setDatabaseEnabled(value);
        webSettings.setAppCachePath(mainActivity.getContext().getDir("cache", 0).getPath());
        webSettings.setAppCacheEnabled(value);
        webSettings.setCacheMode(-1);
        webSettings.setAppCacheMaxSize(8388608);
    }

    /* renamed from: 允许加载图片 */
    public void mo937(boolean value) {
        ((MyWebView) getView()).getSettings().setBlockNetworkImage(!value);
    }

    /* renamed from: 允许弹出对话框 */
    public void mo938(boolean value) {
        this.f4287 = value;
    }

    /* renamed from: 取数据库目录 */
    public String mo945() {
        return mainActivity.getContext().getDir("database", 0).getPath();
    }

    /* renamed from: 取进度 */
    public int mo948() {
        return ((MyWebView) getView()).getProgress();
    }

    /* renamed from: 取标题 */
    public String mo946() {
        return ((MyWebView) getView()).getTitle();
    }

    /* renamed from: 取地址 */
    public String mo944() {
        return ((MyWebView) getView()).getUrl();
    }

    /* renamed from: 取图标 */
    public byte[] mo943() {
        Bitmap b = ((MyWebView) getView()).getFavicon();
        if (b != null) {
            return Bitmap2Bytes(b);
        }
        return new byte[0];
    }

    /* renamed from: 可否前进 */
    public boolean mo950() {
        return ((MyWebView) getView()).canGoForward();
    }

    /* renamed from: 可否后退 */
    public boolean mo951() {
        return ((MyWebView) getView()).canGoBack();
    }

    /* renamed from: 释放内存 */
    public void mo982() {
        ((MyWebView) getView()).freeMemory();
    }

    /* renamed from: 截取快照 */
    public byte[] mo966() {
        Picture snapShot = ((MyWebView) getView()).capturePicture();
        if (snapShot.getWidth() <= 0 || snapShot.getHeight() <= 0) {
            return new byte[0];
        }
        Bitmap b = Bitmap.createBitmap(snapShot.getWidth(), snapShot.getHeight(), Config.ARGB_8888);
        snapShot.draw(new Canvas(b));
        return Bitmap2Bytes(b);
    }

    private byte[] Bitmap2Bytes(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    /* renamed from: 增加JS接口 */
    public void mo960JS(String name) {
        MyWebView view = (MyWebView) getView();
        WebSettings webSettings = view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("GBK");
        view.addJavascriptInterface(new WebAppInterface(), name);
    }

    /* renamed from: 接口事件 */
    public void mo967(String webmsg) {
        EventDispatcher.dispatchEvent(this, "接口事件", webmsg);
    }
}
