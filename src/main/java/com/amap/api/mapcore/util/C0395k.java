package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amap.api.mapcore.be.C0322a;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* compiled from: ImageFetcher */
/* renamed from: com.amap.api.mapcore.util.k */
public class C0395k extends C0394l {
    /* renamed from: e */
    private TileProvider f2172e = null;

    public C0395k(Context context, int i, int i2) {
        super(context, i, i2);
        m3403a(context);
    }

    /* renamed from: a */
    private void m3403a(Context context) {
        m3404b(context);
    }

    /* renamed from: a */
    public void m3407a(TileProvider tileProvider) {
        this.f2172e = tileProvider;
    }

    /* renamed from: b */
    private void m3404b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            C0399o.m3422a("ImageFetcher", "checkConnection - no connection found", ErrorCode.DOWNLOAD_OVER_FLOW);
        }
    }

    /* renamed from: c */
    private Bitmap m3405c(C0322a c0322a) {
        C0399o.m3422a("ImageFetcher", "processBitmap - " + c0322a, ErrorCode.NETWORK_NOT_WIFI_ERROR);
        Bitmap bitmap = null;
        try {
            Tile tile = this.f2172e.getTile(c0322a.f1664a, c0322a.f1665b, c0322a.f1666c);
            if (!(tile == null || tile == TileProvider.NO_TILE)) {
                bitmap = BitmapFactory.decodeByteArray(tile.data, 0, tile.data.length);
            }
        } catch (Throwable th) {
        }
        return bitmap;
    }

    /* renamed from: a */
    protected Bitmap mo613a(Object obj) {
        return m3405c((C0322a) obj);
    }
}
