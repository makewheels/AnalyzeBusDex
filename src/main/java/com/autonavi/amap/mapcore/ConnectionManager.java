package com.autonavi.amap.mapcore;

import com.amap.api.mapcore.util.az;

public class ConnectionManager extends Thread {
    public static boolean isDownloaded = false;
    C0593c connectionPool = new C0593c();
    int sleepTime = 30;
    boolean threadFlag = true;

    public ConnectionManager() {
        super("ConnectionManager");
    }

    public synchronized int getTaskCount() {
        return this.connectionPool.size();
    }

    public synchronized void addConntionTask(MapLoader mapLoader) {
        this.connectionPool.m4647a(mapLoader);
    }

    public synchronized void insertConntionTask(MapLoader mapLoader) {
        this.connectionPool.insertElementAt(mapLoader, 0);
    }

    public void run() {
        while (this.threadFlag) {
            while (true) {
                if (!this.threadFlag || isInterrupted() || this.connectionPool == null) {
                    try {
                        interrupt();
                        break;
                    } catch (Throwable th) {
                        az.m3143a(th, "ConnectionManager", "interrupt");
                        th.printStackTrace();
                    }
                }
                MapLoader mapLoader = (MapLoader) this.connectionPool.m4646a();
                if (mapLoader != null) {
                    isDownloaded = false;
                    do {
                        if (System.currentTimeMillis() - mapLoader.createtime > 50) {
                            try {
                                mapLoader.doRequest();
                                if (this.connectionPool.size() == 0) {
                                    isDownloaded = true;
                                }
                            } catch (Throwable th2) {
                                az.m3143a(th2, "ConnectionManager", "doRequest");
                                th2.printStackTrace();
                            }
                        } else {
                            try {
                                sleep(10);
                            } catch (Throwable th22) {
                                th22.printStackTrace();
                            }
                        }
                    } while (this.threadFlag);
                }
            }
            sleep((long) this.sleepTime);
        }
    }

    public synchronized boolean isEmptyTask() {
        boolean z;
        z = this.connectionPool.size() == 0 && isDownloaded;
        return z;
    }

    protected void finalize() {
        this.threadFlag = false;
        if (this.connectionPool != null) {
            this.connectionPool.clear();
        }
        interrupt();
    }
}
