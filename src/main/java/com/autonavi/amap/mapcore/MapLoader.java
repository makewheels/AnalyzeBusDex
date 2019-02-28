package com.autonavi.amap.mapcore;

import com.amap.api.mapcore.util.az;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import p054u.aly.bi_常量类;

public class MapLoader {
    long createtime;
    int datasource = 0;
    boolean mCanceled = false;
    BaseMapCallImplement mMapCallback;
    MapCore mMapCore;
    public ArrayList<MapSourceGridData> mapTiles = new ArrayList();
    int nextImgDataLength = 0;
    byte[] recievedDataBuffer;
    int recievedDataSize = 0;
    boolean recievedHeader = false;

    public void destory() {
        this.mapTiles.clear();
        this.mapTiles = null;
        this.recievedDataBuffer = null;
        VTMCDataCache.vtmcHs.clear();
        VTMCDataCache.vtmcList.clear();
    }

    public String getGridParma() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.mapTiles.size(); i++) {
            stringBuffer.append(((MapSourceGridData) this.mapTiles.get(i)).getGridName() + ";");
        }
        if (stringBuffer.length() <= 0) {
            return null;
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        if (this.datasource == 0) {
            return "t=VMMV3&cp=1&mesh=" + stringBuffer.toString();
        }
        if (this.datasource == 1) {
            return "t=VMMBLDV3&cp=1&mesh=" + stringBuffer.toString();
        }
        if (this.datasource == 2) {
            return "t=BMPBM&mesh=" + stringBuffer.toString();
        }
        if (this.datasource == 3) {
            return "t=BMTI&mesh=" + stringBuffer.toString();
        }
        if (this.datasource == 4) {
            return "t=TMCV&v=6.0.1&mesh=" + stringBuffer.toString();
        }
        return this.datasource == 6 ? "t=VMMV3&type=mod&cp=0&mid=" + stringBuffer.toString() : null;
    }

    public MapLoader(BaseMapCallImplement baseMapCallImplement, MapCore mapCore, int i) {
        this.mMapCallback = baseMapCallImplement;
        this.datasource = i;
        this.mMapCore = mapCore;
        this.createtime = System.currentTimeMillis();
    }

    public void OnException(int i) {
        if (this.datasource != 4 && this.datasource != 1) {
            this.mMapCallback.OnMapLoaderError(i);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doRequest() {
        /*
        r9 = this;
        r1 = 0;
        r7 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r0 = com.amap.api.maps.MapsInitializer.getNetWorkEnable();
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = r9.isRequestValid();
        if (r0 != 0) goto L_0x0014;
    L_0x0010:
        r9.onConnectionOver(r9);
        goto L_0x0009;
    L_0x0014:
        r0 = 0;
        r2 = new org.apache.http.params.BasicHttpParams;	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r2.<init>();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r3 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r2, r3);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r3 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        org.apache.http.params.HttpConnectionParams.setSoTimeout(r2, r3);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r3 = new org.apache.http.impl.client.DefaultHttpClient;	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r3.<init>(r2);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r2 = r3.getParams();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r4 = "User-Agent";
        r5 = com.amap.api.mapcore.C0344n.f1880c;	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r2.setParameter(r4, r5);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r2 = r9.mMapCallback;	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r2 = r2.getContext();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r2 = com.amap.api.mapcore.util.ac.m3018a(r2);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        if (r2 == 0) goto L_0x0049;
    L_0x0040:
        r4 = r3.getParams();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r5 = "http.route.default-proxy";
        r4.setParameter(r5, r2);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
    L_0x0049:
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r2.<init>();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r4 = "";
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r4 = r9.getGridParma();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r2 = r2.toString();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r4.<init>();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r5 = r9.mMapCallback;	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r5 = r5.getMapSvrAddress();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r5 = "/amapsrv/MPS?";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r2 = r4.append(r2);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r2 = r2.toString();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r4 = "amapv2";
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r5.<init>();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r6 = " getTile-->";
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r5 = r5.append(r2);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r5 = r5.toString();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r6 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        com.amap.api.mapcore.util.C0399o.m3422a(r4, r5, r6);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r4 = new org.apache.http.client.methods.HttpGet;	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r4.<init>(r2);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r2 = r3.execute(r4);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r4 = r2.getStatusLine();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r4 = r4.getStatusCode();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        if (r3 != r4) goto L_0x00f8;
    L_0x00ac:
        r2 = r2.getEntity();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r0 = r2.getContent();	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        r9.onConnectionOpened(r9);	 Catch:{ IOException -> 0x00e2 }
        r2 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r2 = new byte[r2];	 Catch:{ IOException -> 0x00e2 }
    L_0x00bb:
        r3 = r0.read(r2);	 Catch:{ IOException -> 0x00e2 }
        r4 = -1;
        if (r3 <= r4) goto L_0x00cc;
    L_0x00c2:
        r4 = r9.isRequestValid();	 Catch:{ IOException -> 0x00e2 }
        if (r4 == 0) goto L_0x00cc;
    L_0x00c8:
        r4 = r9.mCanceled;	 Catch:{ IOException -> 0x00e2 }
        if (r4 == 0) goto L_0x00dc;
    L_0x00cc:
        r9.onConnectionOver(r9);
        if (r0 == 0) goto L_0x0009;
    L_0x00d1:
        r0.close();	 Catch:{ IOException -> 0x00d6 }
        goto L_0x0009;
    L_0x00d6:
        r0 = move-exception;
        r9.OnException(r7);
        goto L_0x0009;
    L_0x00dc:
        r1 = r1 + r3;
        r4 = 0;
        r9.onConnectionRecieveData(r9, r4, r2, r3);	 Catch:{ IOException -> 0x00e2 }
        goto L_0x00bb;
    L_0x00e2:
        r1 = move-exception;
        r1 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r9.OnException(r1);	 Catch:{ all -> 0x0110 }
        r9.onConnectionOver(r9);
        if (r0 == 0) goto L_0x0009;
    L_0x00ed:
        r0.close();	 Catch:{ IOException -> 0x00f2 }
        goto L_0x0009;
    L_0x00f2:
        r0 = move-exception;
        r9.OnException(r7);
        goto L_0x0009;
    L_0x00f8:
        r1 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r9.OnException(r1);	 Catch:{ IOException -> 0x00e2, all -> 0x00fe }
        goto L_0x00cc;
    L_0x00fe:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
    L_0x0102:
        r9.onConnectionOver(r9);
        if (r1 == 0) goto L_0x010a;
    L_0x0107:
        r1.close();	 Catch:{ IOException -> 0x010b }
    L_0x010a:
        throw r0;
    L_0x010b:
        r1 = move-exception;
        r9.OnException(r7);
        goto L_0x010a;
    L_0x0110:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0102;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.amap.mapcore.MapLoader.doRequest():void");
    }

    public boolean isRequestValid() {
        return this.mMapCallback.isGridsInScreen(this.mapTiles, this.datasource);
    }

    public void onConnectionError(MapLoader mapLoader, int i, String str) {
    }

    public void onConnectionOpened(MapLoader mapLoader) {
        this.recievedDataBuffer = new byte[262144];
        this.nextImgDataLength = 0;
        this.recievedDataSize = 0;
        this.recievedHeader = false;
    }

    public void addReuqestTiles(MapSourceGridData mapSourceGridData) {
        this.mapTiles.add(mapSourceGridData);
    }

    public void onConnectionOver(MapLoader mapLoader) {
        this.recievedDataBuffer = null;
        this.nextImgDataLength = 0;
        this.recievedDataSize = 0;
        if (this.mMapCallback != null && this.mMapCallback.tileProcessCtrl != null && mapLoader != null && mapLoader.mapTiles != null) {
            for (int i = 0; i < mapLoader.mapTiles.size(); i++) {
                if (((MapSourceGridData) mapLoader.mapTiles.get(i)) != null) {
                    this.mMapCallback.tileProcessCtrl.m4649a(((MapSourceGridData) mapLoader.mapTiles.get(i)).getKeyGridName());
                }
            }
        }
    }

    public void onConnectionRecieveData(MapLoader mapLoader, int i, byte[] bArr, int i2) {
        if (mapLoader != null && bArr != null) {
            System.arraycopy(bArr, 0, this.recievedDataBuffer, this.recievedDataSize, i2);
            this.recievedDataSize += i2;
            if (!this.recievedHeader) {
                if (this.recievedDataSize <= 7) {
                    return;
                }
                if (Convert.getInt(this.recievedDataBuffer, 0) != 0) {
                    mapLoader.mCanceled = true;
                    return;
                }
                Convert.moveArray(this.recievedDataBuffer, 8, this.recievedDataBuffer, 0, i2 - 8);
                this.recievedDataSize -= 8;
                this.nextImgDataLength = 0;
                this.recievedHeader = true;
                processRecivedData();
            }
            processRecivedData();
        }
    }

    private void processRecivedData() {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        if (this.nextImgDataLength == 0) {
            if (this.recievedDataSize >= 8) {
                this.nextImgDataLength = Convert.getInt(this.recievedDataBuffer, 0) + 8;
                processRecivedData();
            }
        } else if (this.recievedDataSize >= this.nextImgDataLength) {
            int i = Convert.getInt(this.recievedDataBuffer, 0);
            int i2 = Convert.getInt(this.recievedDataBuffer, 4);
            if (i2 != 0) {
                try {
                    gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(this.recievedDataBuffer, 8, i));
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[128];
                        while (true) {
                            int read = gZIPInputStream.read(bArr);
                            if (read <= -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        processRecivedTileData(byteArrayOutputStream.toByteArray(), 0, i2);
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            az.m3143a(th, "MapLoader", "processRecivedData");
                            th.printStackTrace();
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                            Convert.moveArray(this.recievedDataBuffer, this.nextImgDataLength, this.recievedDataBuffer, 0, this.recievedDataSize - this.nextImgDataLength);
                            this.recievedDataSize -= this.nextImgDataLength;
                            this.nextImgDataLength = 0;
                            processRecivedData();
                        } catch (Throwable th3) {
                            th = th3;
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    gZIPInputStream = null;
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                    throw th;
                }
            } else if (this.datasource == 2) {
                processRecivedTileDataBmp(this.recievedDataBuffer, 8, i + 8);
            } else if (this.datasource == 4) {
                processRecivedTileDataVTmc(this.recievedDataBuffer, 8, i + 8);
            } else if (this.datasource == 6) {
                processRecivedModels(this.recievedDataBuffer, 8, i + 8);
            } else {
                processRecivedTileData(this.recievedDataBuffer, 8, i + 8);
            }
            Convert.moveArray(this.recievedDataBuffer, this.nextImgDataLength, this.recievedDataBuffer, 0, this.recievedDataSize - this.nextImgDataLength);
            this.recievedDataSize -= this.nextImgDataLength;
            this.nextImgDataLength = 0;
            processRecivedData();
        }
    }

    void processRecivedTileData(byte[] bArr, int i, int i2) {
        if (this.mMapCore.isMapEngineValid()) {
            this.mMapCore.putMapData(bArr, i, i2 - i, this.datasource);
        }
    }

    void processRecivedTileDataBmp(byte[] bArr, int i, int i2) {
        if (this.mMapCore.isMapEngineValid()) {
            this.mMapCore.putMapData(bArr, i, i2 - i, this.datasource);
        }
    }

    void processRecivedTileDataVTmc(byte[] bArr, int i, int i2) {
        String str;
        int i3 = i + 4;
        int i4 = i3 + 1;
        byte b = bArr[i3];
        String str2 = bi_常量类.f6358b_空串;
        try {
            str = new String(bArr, i4, b, "utf-8");
        } catch (Throwable e) {
            az.m3143a(e, "MapLoader", "processRecivedTileDataVTmc");
            e.printStackTrace();
            str = str2;
        }
        if (this.mMapCore.isMapEngineValid()) {
            VTMCDataCache instance = VTMCDataCache.getInstance();
            Object obj = new byte[(i2 - i)];
            System.arraycopy(bArr, i, obj, 0, i2 - i);
            instance.putData(str, obj);
            this.mMapCore.putMapData(bArr, i, i2 - i, this.datasource);
        }
    }

    void processRecivedModels(byte[] bArr, int i, int i2) {
        if (this.mMapCore.isMapEngineValid()) {
            System.arraycopy(bArr, i, new byte[(i2 - i)], 0, i2 - i);
            this.mMapCore.putMapData(bArr, i, i2 - i, this.datasource);
        }
    }
}
