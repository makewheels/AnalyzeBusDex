package com.autonavi.amap.mapcore;

import com.amap.api.mapcore.util.az;
import java.util.ArrayList;

public abstract class BaseMapCallImplement implements IBaseMapCallback, IMapCallback {
    private ArrayList<MapSourceGridData> baseMapGrids = new ArrayList();
    private ArrayList<MapSourceGridData> bldMapGrids = new ArrayList();
    private ArrayList<MapSourceGridData> bmpbmMapGirds = new ArrayList();
    private ConnectionManager connectionManager = null;
    C0593c connectionPool;
    private ArrayList<MapSourceGridData> mapModels = new ArrayList();
    private ArrayList<MapSourceGridData> screenGirds = new ArrayList();
    private ArrayList<MapSourceGridData> stiMapGirds = new ArrayList();
    C0594d tileProcessCtrl = null;
    private ArrayList<MapSourceGridData> vectmcMapGirds = new ArrayList();

    private void destory() {
        this.baseMapGrids.clear();
        this.bldMapGrids.clear();
        this.bmpbmMapGirds.clear();
        this.vectmcMapGirds.clear();
        this.stiMapGirds.clear();
        this.mapModels.clear();
        this.screenGirds.clear();
    }

    public void OnMapDataRequired(MapCore mapCore, int i, String[] strArr) {
        ArrayList arrayList;
        switch (i) {
            case 0:
                arrayList = this.baseMapGrids;
                break;
            case 1:
                arrayList = this.bldMapGrids;
                break;
            case 2:
                arrayList = this.bmpbmMapGirds;
                break;
            case 3:
                arrayList = this.stiMapGirds;
                break;
            case 4:
                arrayList = this.vectmcMapGirds;
                break;
            case 5:
                arrayList = this.screenGirds;
                break;
            case 6:
                arrayList = this.mapModels;
                break;
            default:
                arrayList = null;
                break;
        }
        if (arrayList != null) {
            arrayList.clear();
            for (String mapSourceGridData : strArr) {
                arrayList.add(new MapSourceGridData(mapSourceGridData, i));
            }
            if (5 != i) {
                try {
                    proccessRequiredData(mapCore, arrayList, i);
                } catch (Throwable th) {
                    az.m3143a(th, "BaseMapCallImplement", "OnMapDataRequired");
                }
            }
        }
    }

    public ArrayList<MapSourceGridData> getScreenGridList(int i) {
        switch (i) {
            case 0:
                return this.baseMapGrids;
            case 1:
                return this.bldMapGrids;
            case 2:
                return this.bmpbmMapGirds;
            case 3:
                return this.stiMapGirds;
            case 4:
                return this.vectmcMapGirds;
            case 5:
                return this.screenGirds;
            case 6:
                return this.mapModels;
            default:
                return null;
        }
    }

    public boolean isGridsInScreen(ArrayList<MapSourceGridData> arrayList, int i) {
        try {
            if (arrayList.size() == 0) {
                return false;
            }
            if (!isMapEngineValid()) {
                return false;
            }
            ArrayList screenGridList = getScreenGridList(i);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (isGridInList((MapSourceGridData) arrayList.get(i2), screenGridList)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            az.m3143a(th, "BaseMapCallImplement", "isGridsInScreen");
            return true;
        }
    }

    public boolean isGridInList(MapSourceGridData mapSourceGridData, ArrayList<MapSourceGridData> arrayList) {
        if (mapSourceGridData == null || arrayList == null) {
            return false;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (((MapSourceGridData) arrayList.get(i)).getGridName().equals(mapSourceGridData.getGridName())) {
                return true;
            }
        }
        return false;
    }

    private void proccessRequiredData(MapCore mapCore, ArrayList<MapSourceGridData> arrayList, int i) {
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (i2 < arrayList.size()) {
            MapSourceGridData mapSourceGridData = (MapSourceGridData) arrayList.get(i2);
            if (this.tileProcessCtrl != null && mapSourceGridData != null) {
                if (!this.tileProcessCtrl.m4650b(mapSourceGridData.getKeyGridName())) {
                    arrayList2.add(mapSourceGridData);
                }
                i2++;
            } else {
                return;
            }
        }
        if (arrayList2.size() > 0) {
            sendMapDataRequest(mapCore, arrayList2, i);
        }
    }

    private synchronized void sendMapDataRequest(MapCore mapCore, ArrayList<MapSourceGridData> arrayList, int i) {
        if (arrayList.size() != 0) {
            MapLoader mapLoader = new MapLoader(this, mapCore, i);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                MapSourceGridData mapSourceGridData = (MapSourceGridData) arrayList.get(i2);
                if (this.tileProcessCtrl == null) {
                    break;
                }
                if (!this.tileProcessCtrl.m4650b(mapSourceGridData.getKeyGridName())) {
                    this.tileProcessCtrl.m4651c(mapSourceGridData.getKeyGridName());
                    mapLoader.addReuqestTiles(mapSourceGridData);
                }
            }
            if (this.connectionManager != null) {
                this.connectionManager.insertConntionTask(mapLoader);
            }
        }
    }

    public void OnMapSurfaceCreate(MapCore mapCore) {
        onResume();
    }

    public synchronized void onPause() {
        try {
            if (this.connectionManager != null) {
                this.connectionManager.threadFlag = false;
                this.connectionPool = (C0593c) this.connectionManager.connectionPool.clone();
                this.connectionManager.connectionPool.clear();
                if (this.connectionManager.isAlive()) {
                    this.connectionManager.interrupt();
                    this.connectionManager = null;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void onResume() {
        try {
            if (this.tileProcessCtrl == null) {
                this.tileProcessCtrl = new C0594d();
            }
            if (this.connectionManager == null) {
                this.connectionManager = new ConnectionManager();
                if (this.connectionPool != null) {
                    this.connectionManager.connectionPool = this.connectionPool;
                }
                this.connectionManager.start();
            }
        } catch (Throwable th) {
            az.m3143a(th, "BaseMapCallImplement", "onResume");
            th.printStackTrace();
        }
    }

    public void OnMapDestory(MapCore mapCore) {
        try {
            destory();
            onPause();
        } catch (Throwable th) {
            az.m3143a(th, "BaseMapCallImplement", "OnMapDestory");
            th.printStackTrace();
        }
    }

    public boolean isDownloaded() {
        if (this.connectionManager != null) {
            return this.connectionManager.isEmptyTask();
        }
        return false;
    }

    public byte[] OnMapCharsWidthsRequired(MapCore mapCore, int[] iArr, int i, int i2) {
        return TextTextureGenerator.getCharsWidths(iArr);
    }

    public void OnMapLabelsRequired(MapCore mapCore, int[] iArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            try {
                int i3 = iArr[i2];
                mapCore.putCharbitmap(i3, new TextTextureGenerator().getTextPixelBuffer(i3));
                i2++;
            } catch (Throwable th) {
                az.m3143a(th, "BaseMapCallImplement", "OnMapLabelsRequired");
                th.printStackTrace();
                return;
            }
        }
    }
}
