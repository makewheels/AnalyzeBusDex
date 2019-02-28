package com.e4a.runtime.components.impl.android.n36;

import android.os.Handler;
import android.os.Message;
import com.e4a.runtime.C0841;
import com.e4a.runtime.collections.C0683_集合类;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.ComponentImpl;
import com.e4a.runtime.components.impl.android.n36.download.Downloader;
import com.e4a.runtime.components.impl.android.n36.download.InfoDao;
import com.e4a.runtime.events.EventDispatcher;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.n36.下载器Impl */
public class C0735Impl extends ComponentImpl implements C0733 {
    private List<MyDownload> DownloadList = new ArrayList();

    /* renamed from: com.e4a.runtime.components.impl.android.n36.下载器Impl$MyDownload */
    private final class MyDownload {
        private int done;
        private int downloadID;
        private Downloader downloader;
        private int fileLen;
        private Handler handler = new C07341();
        private int result;

        /* renamed from: com.e4a.runtime.components.impl.android.n36.下载器Impl$MyDownload$1 */
        class C07341 extends Handler {
            C07341() {
            }

            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        MyDownload.this.fileLen = msg.getData().getInt("fileLen");
                        return;
                    case 1:
                        int[] data = msg.getData().getIntArray("done");
                        MyDownload.this.fileLen = data[0];
                        MyDownload.this.done = data[1];
                        C0735Impl.this.mo1128(MyDownload.this.downloadID, MyDownload.this.fileLen, MyDownload.this.done, (int) (Double.parseDouble(MyDownload.this.m5932(bi_常量类.f6358b + MyDownload.this.done, bi_常量类.f6358b + MyDownload.this.fileLen, 2)) * 100.0d));
                        if (MyDownload.this.done == MyDownload.this.fileLen) {
                            C0735Impl.this.mo1122(MyDownload.this.downloadID, true);
                            return;
                        }
                        return;
                    case 2:
                        MyDownload.this.result = msg.getData().getInt("result");
                        if (MyDownload.this.result == 2) {
                            C0735Impl.this.mo1122(MyDownload.this.downloadID, false);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public MyDownload(String sourcePath, String savePath, int threadNumber, int id) {
            this.downloadID = id;
            try {
                this.downloader = new Downloader(C0841.m6594(), this.handler);
                this.downloader.download(sourcePath, savePath, threadNumber);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* renamed from: 大数相除 */
        private String m5932(String a, String b, int scale) {
            return new BigDecimal(a).divide(new BigDecimal(b), scale, 4).toPlainString();
        }

        public void pausedownload() {
            this.downloader.pause();
        }

        public void resumedownload() {
            this.downloader.resume();
        }

        public void cancledownload() {
            this.downloader.cancle();
        }
    }

    public C0735Impl(ComponentContainer container) {
        super(container);
    }

    /* renamed from: 进度改变 */
    public void mo1128(int id, int totalsize, int downloadedsize, int percent) {
        EventDispatcher.dispatchEvent(this, "进度改变", Integer.valueOf(id), Integer.valueOf(totalsize), Integer.valueOf(downloadedsize), Integer.valueOf(percent));
    }

    /* renamed from: 下载完毕 */
    public void mo1122(int id, boolean result) {
        EventDispatcher.dispatchEvent(this, "下载完毕", Integer.valueOf(id), Boolean.valueOf(result));
    }

    /* renamed from: 取未完成记录 */
    public C0683_集合类 mo1123() {
        return new InfoDao(C0841.m6594()).queryUndone();
    }

    /* renamed from: 开始下载 */
    public int mo1125(String sourcePath, String savePath) {
        int id = this.DownloadList.size();
        this.DownloadList.add(new MyDownload(sourcePath, savePath, 1, id));
        return id;
    }

    /* renamed from: 暂停下载 */
    public void mo1126(int id) {
        if (this.DownloadList.size() - 1 >= id) {
            ((MyDownload) this.DownloadList.get(id)).pausedownload();
        }
    }

    /* renamed from: 继续下载 */
    public void mo1127(int id) {
        if (this.DownloadList.size() - 1 >= id) {
            ((MyDownload) this.DownloadList.get(id)).resumedownload();
        }
    }

    /* renamed from: 取消下载 */
    public void mo1124(int id) {
        if (this.DownloadList.size() - 1 >= id) {
            ((MyDownload) this.DownloadList.get(id)).cancledownload();
        }
    }
}
