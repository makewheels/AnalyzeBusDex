package com.amap.api.p015a.p016a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amap.api.maps2d.model.Tile;
import com.amap.api.maps2d.model.TileProvider;
import com.amap.api.p015a.bu.C0233a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* compiled from: ImageFetcher */
/* renamed from: com.amap.api.a.a.k */
public class C0199k extends C0198l {
    /* renamed from: e */
    private TileProvider f594e = null;

    public C0199k(Context context, int i, int i2) {
        super(context, i, i2);
        m774a(context);
    }

    /* renamed from: a */
    private void m774a(Context context) {
        m775b(context);
    }

    /* renamed from: a */
    public void m778a(TileProvider tileProvider) {
        this.f594e = tileProvider;
    }

    /* renamed from: b */
    private void m775b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            C0202n.m788a("ImageFetcher", "checkConnection - no connection found", ErrorCode.DOWNLOAD_OVER_FLOW);
        }
    }

    /* renamed from: c */
    private Bitmap m776c(C0233a c0233a) {
        C0202n.m788a("ImageFetcher", "processBitmap - " + c0233a, ErrorCode.NETWORK_NOT_WIFI_ERROR);
        Tile tile = this.f594e.getTile(c0233a.f924a, c0233a.f925b, c0233a.f926c);
        if (tile == null || tile == TileProvider.NO_TILE) {
            return null;
        }
        return BitmapFactory.decodeByteArray(tile.data, 0, tile.data.length);
    }

    /* renamed from: a */
    protected Bitmap mo32a(Object obj) {
        return m776c((C0233a) obj);
    }
}
