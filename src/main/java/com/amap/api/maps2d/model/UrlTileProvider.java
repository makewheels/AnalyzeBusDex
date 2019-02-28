package com.amap.api.maps2d.model;

import com.amap.api.p015a.p016a.C0202n;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
    /* renamed from: a */
    private final int f2654a;
    /* renamed from: b */
    private final int f2655b;

    public abstract URL getTileUrl(int i, int i2, int i3);

    public UrlTileProvider(int i, int i2) {
        this.f2654a = i;
        this.f2655b = i2;
    }

    public final Tile getTile(int i, int i2, int i3) {
        URL tileUrl = getTileUrl(i, i2, i3);
        if (tileUrl == null) {
            return NO_TILE;
        }
        C0202n.m788a("UrlTileProvider", "url: " + tileUrl.toString(), ErrorCode.NETWORK_NOT_WIFI_ERROR);
        try {
            return new Tile(this.f2654a, this.f2655b, m3799a(tileUrl.openStream()));
        } catch (IOException e) {
            return NO_TILE;
        }
    }

    /* renamed from: a */
    private static byte[] m3799a(InputStream inputStream) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m3798a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    private static long m3798a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public int getTileWidth() {
        return this.f2654a;
    }

    public int getTileHeight() {
        return this.f2655b;
    }
}
