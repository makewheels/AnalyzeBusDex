package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;
import com.tencent.smtt.utils.C1157u;
import p054u.aly.bi_常量类;

public class WebSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    /* renamed from: a */
    private IX5WebSettings f4884a;
    /* renamed from: b */
    private android.webkit.WebSettings f4885b;
    /* renamed from: c */
    private boolean f4886c;

    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS
    }

    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(125),
        LARGEST(150);
        
        int value;

        private TextSize(int i) {
            this.value = i;
        }
    }

    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);
        
        int value;

        private ZoomDensity(int i) {
            this.value = i;
        }
    }

    WebSettings(android.webkit.WebSettings webSettings) {
        this.f4884a = null;
        this.f4885b = null;
        this.f4886c = false;
        this.f4884a = null;
        this.f4885b = webSettings;
        this.f4886c = false;
    }

    WebSettings(IX5WebSettings iX5WebSettings) {
        this.f4884a = null;
        this.f4885b = null;
        this.f4886c = false;
        this.f4884a = iX5WebSettings;
        this.f4885b = null;
        this.f4886c = true;
    }

    @TargetApi(17)
    public static String getDefaultUserAgent(Context context) {
        if ((C1110i.m7845a(false) != null && C1110i.m7845a(false).m7858b()) || VERSION.SDK_INT < 17) {
            return null;
        }
        Object a = C1157u.m8040a(android.webkit.WebSettings.class, "getDefaultUserAgent", new Class[]{Context.class}, context);
        return a == null ? null : (String) a;
    }

    @Deprecated
    public boolean enableSmoothTransition() {
        if (this.f4886c && this.f4884a != null) {
            return this.f4884a.enableSmoothTransition();
        }
        if (this.f4886c || this.f4885b == null || VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = C1157u.m8041a(this.f4885b, "enableSmoothTransition");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    @TargetApi(11)
    public boolean getAllowContentAccess() {
        if (this.f4886c && this.f4884a != null) {
            return this.f4884a.getAllowContentAccess();
        }
        if (this.f4886c || this.f4885b == null || VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = C1157u.m8041a(this.f4885b, "getAllowContentAccess");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    @TargetApi(3)
    public boolean getAllowFileAccess() {
        return (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.getAllowFileAccess() : this.f4884a.getAllowFileAccess();
    }

    public synchronized boolean getBlockNetworkImage() {
        boolean blockNetworkImage;
        blockNetworkImage = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.getBlockNetworkImage() : this.f4884a.getBlockNetworkImage();
        return blockNetworkImage;
    }

    @TargetApi(8)
    public synchronized boolean getBlockNetworkLoads() {
        boolean z = false;
        synchronized (this) {
            if (this.f4886c && this.f4884a != null) {
                z = this.f4884a.getBlockNetworkLoads();
            } else if (!(this.f4886c || this.f4885b == null || VERSION.SDK_INT < 8)) {
                z = this.f4885b.getBlockNetworkLoads();
            }
        }
        return z;
    }

    @TargetApi(3)
    public boolean getBuiltInZoomControls() {
        return (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.getBuiltInZoomControls() : this.f4884a.getBuiltInZoomControls();
    }

    public int getCacheMode() {
        return (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? 0 : this.f4885b.getCacheMode() : this.f4884a.getCacheMode();
    }

    public synchronized String getCursiveFontFamily() {
        String cursiveFontFamily;
        cursiveFontFamily = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? bi_常量类.f6358b_空串 : this.f4885b.getCursiveFontFamily() : this.f4884a.getCursiveFontFamily();
        return cursiveFontFamily;
    }

    @TargetApi(5)
    public synchronized boolean getDatabaseEnabled() {
        boolean databaseEnabled;
        databaseEnabled = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.getDatabaseEnabled() : this.f4884a.getDatabaseEnabled();
        return databaseEnabled;
    }

    @TargetApi(5)
    public synchronized String getDatabasePath() {
        String databasePath;
        databasePath = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? bi_常量类.f6358b_空串 : this.f4885b.getDatabasePath() : this.f4884a.getDatabasePath();
        return databasePath;
    }

    public synchronized int getDefaultFixedFontSize() {
        int defaultFixedFontSize;
        defaultFixedFontSize = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? 0 : this.f4885b.getDefaultFixedFontSize() : this.f4884a.getDefaultFixedFontSize();
        return defaultFixedFontSize;
    }

    public synchronized int getDefaultFontSize() {
        int defaultFontSize;
        defaultFontSize = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? 0 : this.f4885b.getDefaultFontSize() : this.f4884a.getDefaultFontSize();
        return defaultFontSize;
    }

    public synchronized String getDefaultTextEncodingName() {
        String defaultTextEncodingName;
        defaultTextEncodingName = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? bi_常量类.f6358b_空串 : this.f4885b.getDefaultTextEncodingName() : this.f4884a.getDefaultTextEncodingName();
        return defaultTextEncodingName;
    }

    @TargetApi(7)
    public ZoomDensity getDefaultZoom() {
        return (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? null : ZoomDensity.valueOf(this.f4885b.getDefaultZoom().name()) : ZoomDensity.valueOf(this.f4884a.getDefaultZoom().name());
    }

    @TargetApi(11)
    public boolean getDisplayZoomControls() {
        if (this.f4886c && this.f4884a != null) {
            return this.f4884a.getDisplayZoomControls();
        }
        if (this.f4886c || this.f4885b == null || VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = C1157u.m8041a(this.f4885b, "getDisplayZoomControls");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    @TargetApi(7)
    public synchronized boolean getDomStorageEnabled() {
        boolean domStorageEnabled;
        domStorageEnabled = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.getDomStorageEnabled() : this.f4884a.getDomStorageEnabled();
        return domStorageEnabled;
    }

    public synchronized String getFantasyFontFamily() {
        String fantasyFontFamily;
        fantasyFontFamily = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? bi_常量类.f6358b_空串 : this.f4885b.getFantasyFontFamily() : this.f4884a.getFantasyFontFamily();
        return fantasyFontFamily;
    }

    public synchronized String getFixedFontFamily() {
        String fixedFontFamily;
        fixedFontFamily = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? bi_常量类.f6358b_空串 : this.f4885b.getFixedFontFamily() : this.f4884a.getFixedFontFamily();
        return fixedFontFamily;
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        boolean javaScriptCanOpenWindowsAutomatically;
        javaScriptCanOpenWindowsAutomatically = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.getJavaScriptCanOpenWindowsAutomatically() : this.f4884a.getJavaScriptCanOpenWindowsAutomatically();
        return javaScriptCanOpenWindowsAutomatically;
    }

    public synchronized boolean getJavaScriptEnabled() {
        boolean javaScriptEnabled;
        javaScriptEnabled = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.getJavaScriptEnabled() : this.f4884a.getJavaScriptEnabled();
        return javaScriptEnabled;
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        LayoutAlgorithm valueOf;
        valueOf = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? null : LayoutAlgorithm.valueOf(this.f4885b.getLayoutAlgorithm().name()) : LayoutAlgorithm.valueOf(this.f4884a.getLayoutAlgorithm().name());
        return valueOf;
    }

    public boolean getLightTouchEnabled() {
        return (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.getLightTouchEnabled() : this.f4884a.getLightTouchEnabled();
    }

    @TargetApi(7)
    public boolean getLoadWithOverviewMode() {
        return (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.getLoadWithOverviewMode() : this.f4884a.getLoadWithOverviewMode();
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        boolean loadsImagesAutomatically;
        loadsImagesAutomatically = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.getLoadsImagesAutomatically() : this.f4884a.getLoadsImagesAutomatically();
        return loadsImagesAutomatically;
    }

    @TargetApi(17)
    public boolean getMediaPlaybackRequiresUserGesture() {
        if (this.f4886c && this.f4884a != null) {
            return this.f4884a.getMediaPlaybackRequiresUserGesture();
        }
        if (this.f4886c || this.f4885b == null || VERSION.SDK_INT < 17) {
            return false;
        }
        Object a = C1157u.m8041a(this.f4885b, "getMediaPlaybackRequiresUserGesture");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public synchronized int getMinimumFontSize() {
        int minimumFontSize;
        minimumFontSize = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? 0 : this.f4885b.getMinimumFontSize() : this.f4884a.getMinimumFontSize();
        return minimumFontSize;
    }

    public synchronized int getMinimumLogicalFontSize() {
        int minimumLogicalFontSize;
        minimumLogicalFontSize = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? 0 : this.f4885b.getMinimumLogicalFontSize() : this.f4884a.getMinimumLogicalFontSize();
        return minimumLogicalFontSize;
    }

    public synchronized int getMixedContentMode() {
        int i = -1;
        synchronized (this) {
            if (this.f4886c && this.f4884a != null) {
                try {
                    i = this.f4884a.getMixedContentMode();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else if (VERSION.SDK_INT >= 21) {
                Object a = C1157u.m8042a(this.f4885b, "getMixedContentMode", new Class[0], new Object[0]);
                i = a == null ? i : ((Integer) a).intValue();
            }
        }
        return i;
    }

    public boolean getNavDump() {
        if (this.f4886c && this.f4884a != null) {
            return this.f4884a.getNavDump();
        }
        if (this.f4886c || this.f4885b == null) {
            return false;
        }
        Object a = C1157u.m8041a(this.f4885b, "getNavDump");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    @TargetApi(8)
    @Deprecated
    public synchronized PluginState getPluginState() {
        PluginState valueOf;
        if (this.f4886c && this.f4884a != null) {
            valueOf = PluginState.valueOf(this.f4884a.getPluginState().name());
        } else if (this.f4886c || this.f4885b == null) {
            valueOf = null;
        } else if (VERSION.SDK_INT >= 8) {
            Object a = C1157u.m8041a(this.f4885b, "getPluginState");
            valueOf = a == null ? null : PluginState.valueOf(((android.webkit.WebSettings.PluginState) a).name());
        } else {
            valueOf = null;
        }
        return valueOf;
    }

    @TargetApi(8)
    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        boolean z = false;
        synchronized (this) {
            if (this.f4886c && this.f4884a != null) {
                z = this.f4884a.getPluginsEnabled();
            } else if (!(this.f4886c || this.f4885b == null)) {
                if (VERSION.SDK_INT <= 17) {
                    Object a = C1157u.m8041a(this.f4885b, "getPluginsEnabled");
                    z = a == null ? false : ((Boolean) a).booleanValue();
                } else if (VERSION.SDK_INT == 18 && android.webkit.WebSettings.PluginState.ON == this.f4885b.getPluginState()) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Deprecated
    public synchronized String getPluginsPath() {
        String pluginsPath;
        if (this.f4886c && this.f4884a != null) {
            pluginsPath = this.f4884a.getPluginsPath();
        } else if (this.f4886c || this.f4885b == null) {
            pluginsPath = bi_常量类.f6358b_空串;
        } else if (VERSION.SDK_INT <= 17) {
            Object a = C1157u.m8041a(this.f4885b, "getPluginsPath");
            pluginsPath = a == null ? null : (String) a;
        } else {
            pluginsPath = bi_常量类.f6358b_空串;
        }
        return pluginsPath;
    }

    public synchronized String getSansSerifFontFamily() {
        String sansSerifFontFamily;
        sansSerifFontFamily = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? bi_常量类.f6358b_空串 : this.f4885b.getSansSerifFontFamily() : this.f4884a.getSansSerifFontFamily();
        return sansSerifFontFamily;
    }

    public boolean getSaveFormData() {
        return (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.getSaveFormData() : this.f4884a.getSaveFormData();
    }

    public boolean getSavePassword() {
        return (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.getSavePassword() : this.f4884a.getSavePassword();
    }

    public synchronized String getSerifFontFamily() {
        String serifFontFamily;
        serifFontFamily = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? bi_常量类.f6358b_空串 : this.f4885b.getSerifFontFamily() : this.f4884a.getSerifFontFamily();
        return serifFontFamily;
    }

    public synchronized String getStandardFontFamily() {
        String standardFontFamily;
        standardFontFamily = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? bi_常量类.f6358b_空串 : this.f4885b.getStandardFontFamily() : this.f4884a.getStandardFontFamily();
        return standardFontFamily;
    }

    public TextSize getTextSize() {
        return (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? null : TextSize.valueOf(this.f4885b.getTextSize().name()) : TextSize.valueOf(this.f4884a.getTextSize().name());
    }

    @TargetApi(14)
    public synchronized int getTextZoom() {
        int i = 0;
        synchronized (this) {
            if (this.f4886c && this.f4884a != null) {
                i = this.f4884a.getTextZoom();
            } else if (!(this.f4886c || this.f4885b == null || VERSION.SDK_INT < 14)) {
                Object a = C1157u.m8041a(this.f4885b, "getTextZoom");
                i = a == null ? 0 : ((Integer) a).intValue();
            }
        }
        return i;
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        if (this.f4886c && this.f4884a != null) {
            return this.f4884a.getUseWebViewBackgroundForOverscrollBackground();
        }
        if (this.f4886c || this.f4885b == null) {
            return false;
        }
        Object a = C1157u.m8041a(this.f4885b, "getUseWebViewBackgroundForOverscrollBackground");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public synchronized boolean getUseWideViewPort() {
        boolean useWideViewPort;
        useWideViewPort = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.getUseWideViewPort() : this.f4884a.getUseWideViewPort();
        return useWideViewPort;
    }

    @TargetApi(3)
    public String getUserAgentString() {
        return (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? bi_常量类.f6358b_空串 : this.f4885b.getUserAgentString() : this.f4884a.getUserAgentString();
    }

    @TargetApi(11)
    public void setAllowContentAccess(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setAllowContentAccess(z);
        } else if (!this.f4886c && this.f4885b != null && VERSION.SDK_INT >= 11) {
            C1157u.m8042a(this.f4885b, "setAllowContentAccess", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(3)
    public void setAllowFileAccess(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setAllowFileAccess(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setAllowFileAccess(z);
        }
    }

    @TargetApi(16)
    public void setAllowFileAccessFromFileURLs(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setAllowFileAccessFromFileURLs(z);
        } else if (!this.f4886c && this.f4885b != null) {
            C1157u.m8042a(this.f4885b, "setAllowFileAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(16)
    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setAllowUniversalAccessFromFileURLs(z);
        } else if (!this.f4886c && this.f4885b != null) {
            C1157u.m8042a(this.f4885b, "setAllowUniversalAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(7)
    public void setAppCacheEnabled(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setAppCacheEnabled(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setAppCacheEnabled(z);
        }
    }

    @TargetApi(7)
    public void setAppCacheMaxSize(long j) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setAppCacheMaxSize(j);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setAppCacheMaxSize(j);
        }
    }

    @TargetApi(7)
    public void setAppCachePath(String str) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setAppCachePath(str);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setAppCachePath(str);
        }
    }

    public void setBlockNetworkImage(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setBlockNetworkImage(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setBlockNetworkImage(z);
        }
    }

    @TargetApi(8)
    public synchronized void setBlockNetworkLoads(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setBlockNetworkLoads(z);
        } else if (!(this.f4886c || this.f4885b == null || VERSION.SDK_INT < 8)) {
            this.f4885b.setBlockNetworkLoads(z);
        }
    }

    @TargetApi(3)
    public void setBuiltInZoomControls(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setBuiltInZoomControls(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setBuiltInZoomControls(z);
        }
    }

    public void setCacheMode(int i) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setCacheMode(i);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setCacheMode(i);
        }
    }

    public synchronized void setCursiveFontFamily(String str) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setCursiveFontFamily(str);
        } else if (!(this.f4886c || this.f4885b == null)) {
            this.f4885b.setCursiveFontFamily(str);
        }
    }

    @TargetApi(5)
    public void setDatabaseEnabled(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setDatabaseEnabled(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setDatabaseEnabled(z);
        }
    }

    @TargetApi(5)
    @Deprecated
    public void setDatabasePath(String str) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setDatabasePath(str);
        } else if (!this.f4886c && this.f4885b != null) {
            C1157u.m8042a(this.f4885b, "setDatabasePath", new Class[]{String.class}, str);
        }
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setDefaultFixedFontSize(i);
        } else if (!(this.f4886c || this.f4885b == null)) {
            this.f4885b.setDefaultFixedFontSize(i);
        }
    }

    public synchronized void setDefaultFontSize(int i) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setDefaultFontSize(i);
        } else if (!(this.f4886c || this.f4885b == null)) {
            this.f4885b.setDefaultFontSize(i);
        }
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setDefaultTextEncodingName(str);
        } else if (!(this.f4886c || this.f4885b == null)) {
            this.f4885b.setDefaultTextEncodingName(str);
        }
    }

    @TargetApi(7)
    public void setDefaultZoom(ZoomDensity zoomDensity) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setDefaultZoom(com.tencent.smtt.export.external.interfaces.IX5WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setDefaultZoom(android.webkit.WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        }
    }

    @TargetApi(11)
    public void setDisplayZoomControls(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setDisplayZoomControls(z);
        } else if (!this.f4886c && this.f4885b != null && VERSION.SDK_INT >= 11) {
            C1157u.m8042a(this.f4885b, "setDisplayZoomControls", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(7)
    public void setDomStorageEnabled(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setDomStorageEnabled(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setDomStorageEnabled(z);
        }
    }

    @TargetApi(11)
    @Deprecated
    public void setEnableSmoothTransition(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setEnableSmoothTransition(z);
        } else if (!this.f4886c && this.f4885b != null && VERSION.SDK_INT >= 11) {
            C1157u.m8042a(this.f4885b, "setEnableSmoothTransition", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public synchronized void setFantasyFontFamily(String str) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setFantasyFontFamily(str);
        } else if (!(this.f4886c || this.f4885b == null)) {
            this.f4885b.setFantasyFontFamily(str);
        }
    }

    public synchronized void setFixedFontFamily(String str) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setFixedFontFamily(str);
        } else if (!(this.f4886c || this.f4885b == null)) {
            this.f4885b.setFixedFontFamily(str);
        }
    }

    @TargetApi(5)
    public void setGeolocationDatabasePath(String str) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setGeolocationDatabasePath(str);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setGeolocationDatabasePath(str);
        }
    }

    @TargetApi(5)
    public void setGeolocationEnabled(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setGeolocationEnabled(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setGeolocationEnabled(z);
        }
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (!(this.f4886c || this.f4885b == null)) {
            this.f4885b.setJavaScriptCanOpenWindowsAutomatically(z);
        }
    }

    @Deprecated
    public void setJavaScriptEnabled(boolean z) {
        try {
            if (this.f4886c && this.f4884a != null) {
                this.f4884a.setJavaScriptEnabled(z);
            } else if (!this.f4886c && this.f4885b != null) {
                this.f4885b.setJavaScriptEnabled(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setLayoutAlgorithm(com.tencent.smtt.export.external.interfaces.IX5WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        }
    }

    public void setLightTouchEnabled(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setLightTouchEnabled(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setLightTouchEnabled(z);
        }
    }

    @TargetApi(7)
    public void setLoadWithOverviewMode(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setLoadWithOverviewMode(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setLoadWithOverviewMode(z);
        }
    }

    public void setLoadsImagesAutomatically(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setLoadsImagesAutomatically(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setLoadsImagesAutomatically(z);
        }
    }

    @TargetApi(17)
    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setMediaPlaybackRequiresUserGesture(z);
        } else if (!this.f4886c && this.f4885b != null && VERSION.SDK_INT >= 17) {
            C1157u.m8042a(this.f4885b, "setMediaPlaybackRequiresUserGesture", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public synchronized void setMinimumFontSize(int i) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setMinimumFontSize(i);
        } else if (!(this.f4886c || this.f4885b == null)) {
            this.f4885b.setMinimumFontSize(i);
        }
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setMinimumLogicalFontSize(i);
        } else if (!(this.f4886c || this.f4885b == null)) {
            this.f4885b.setMinimumLogicalFontSize(i);
        }
    }

    @TargetApi(21)
    public void setMixedContentMode(int i) {
        if ((!this.f4886c || this.f4884a == null) && !this.f4886c && this.f4885b != null && VERSION.SDK_INT >= 21) {
            C1157u.m8042a(this.f4885b, "setMixedContentMode", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setNavDump(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setNavDump(z);
        } else if (!this.f4886c && this.f4885b != null) {
            C1157u.m8042a(this.f4885b, "setNavDump", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setNeedInitialFocus(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setNeedInitialFocus(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setNeedInitialFocus(z);
        }
    }

    @TargetApi(8)
    @Deprecated
    public synchronized void setPluginState(PluginState pluginState) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setPluginState(com.tencent.smtt.export.external.interfaces.IX5WebSettings.PluginState.valueOf(pluginState.name()));
        } else if (!(this.f4886c || this.f4885b == null || VERSION.SDK_INT < 8)) {
            android.webkit.WebSettings.PluginState valueOf = android.webkit.WebSettings.PluginState.valueOf(pluginState.name());
            C1157u.m8042a(this.f4885b, "setPluginState", new Class[]{android.webkit.WebSettings.PluginState.class}, valueOf);
        }
    }

    @Deprecated
    public void setPluginsEnabled(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setPluginsEnabled(z);
        } else if (!this.f4886c && this.f4885b != null) {
            C1157u.m8042a(this.f4885b, "setPluginsEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @Deprecated
    public synchronized void setPluginsPath(String str) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setPluginsPath(str);
        } else if (!(this.f4886c || this.f4885b == null)) {
            C1157u.m8042a(this.f4885b, "setPluginsPath", new Class[]{String.class}, str);
        }
    }

    public void setRenderPriority(RenderPriority renderPriority) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setRenderPriority(com.tencent.smtt.export.external.interfaces.IX5WebSettings.RenderPriority.valueOf(renderPriority.name()));
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setRenderPriority(android.webkit.WebSettings.RenderPriority.valueOf(renderPriority.name()));
        }
    }

    public synchronized void setSansSerifFontFamily(String str) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setSansSerifFontFamily(str);
        } else if (!(this.f4886c || this.f4885b == null)) {
            this.f4885b.setSansSerifFontFamily(str);
        }
    }

    public void setSaveFormData(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setSaveFormData(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setSaveFormData(z);
        }
    }

    public void setSavePassword(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setSavePassword(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setSavePassword(z);
        }
    }

    public synchronized void setSerifFontFamily(String str) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setSerifFontFamily(str);
        } else if (!(this.f4886c || this.f4885b == null)) {
            this.f4885b.setSerifFontFamily(str);
        }
    }

    public synchronized void setStandardFontFamily(String str) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setStandardFontFamily(str);
        } else if (!(this.f4886c || this.f4885b == null)) {
            this.f4885b.setStandardFontFamily(str);
        }
    }

    public void setSupportMultipleWindows(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setSupportMultipleWindows(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setSupportMultipleWindows(z);
        }
    }

    public void setSupportZoom(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setSupportZoom(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setSupportZoom(z);
        }
    }

    public void setTextSize(TextSize textSize) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setTextSize(com.tencent.smtt.export.external.interfaces.IX5WebSettings.TextSize.valueOf(textSize.name()));
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setTextSize(android.webkit.WebSettings.TextSize.valueOf(textSize.name()));
        }
    }

    @TargetApi(14)
    public synchronized void setTextZoom(int i) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setTextZoom(i);
        } else if (!(this.f4886c || this.f4885b == null || VERSION.SDK_INT < 14)) {
            C1157u.m8042a(this.f4885b, "setTextZoom", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setUseWebViewBackgroundForOverscrollBackground(z);
        } else if (!this.f4886c && this.f4885b != null) {
            C1157u.m8042a(this.f4885b, "setUseWebViewBackgroundForOverscrollBackground", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setUseWideViewPort(boolean z) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setUseWideViewPort(z);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setUseWideViewPort(z);
        }
    }

    public void setUserAgent(String str) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setUserAgent(str);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setUserAgentString(str);
        }
    }

    @TargetApi(3)
    public void setUserAgentString(String str) {
        if (this.f4886c && this.f4884a != null) {
            this.f4884a.setUserAgentString(str);
        } else if (!this.f4886c && this.f4885b != null) {
            this.f4885b.setUserAgentString(str);
        }
    }

    public synchronized boolean supportMultipleWindows() {
        boolean supportMultipleWindows;
        supportMultipleWindows = (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.supportMultipleWindows() : this.f4884a.supportMultipleWindows();
        return supportMultipleWindows;
    }

    public boolean supportZoom() {
        return (!this.f4886c || this.f4884a == null) ? (this.f4886c || this.f4885b == null) ? false : this.f4885b.supportZoom() : this.f4884a.supportZoom();
    }
}
