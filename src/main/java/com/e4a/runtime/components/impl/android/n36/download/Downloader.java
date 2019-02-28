package com.e4a.runtime.components.impl.android.n36.download;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader {
    private InfoDao dao;
    private int done;
    private int fileLen;
    private Handler handler;
    private boolean isCancle;
    private boolean isPause;

    private final class DownloadThread extends Thread {
        private File file;
        private int id;
        private int partLen;
        private URL url;

        public DownloadThread(URL url, File file, int partLen, int id) {
            this.url = url;
            this.file = file;
            this.partLen = partLen;
            this.id = id;
        }

        public void run() {
            Info info = Downloader.this.dao.query(this.url.toString(), this.id);
            if (info != null) {
                Downloader.access$412(Downloader.this, info.getDone().intValue());
            } else {
                info = new Info(this.url.toString(), Integer.valueOf(this.id), Integer.valueOf(0));
                Downloader.this.dao.insert(info);
            }
            int start = (this.id * this.partLen) + info.getDone().intValue();
            int end = ((this.id + 1) * this.partLen) - 1;
            Message msg;
            try {
                HttpURLConnection conn = (HttpURLConnection) this.url.openConnection();
                conn.setReadTimeout(10000);
                conn.setRequestProperty("Range", "bytes=" + start + "-" + end);
                RandomAccessFile raf = new RandomAccessFile(this.file, "rws");
                raf.seek((long) start);
                InputStream in = conn.getInputStream();
                byte[] buf = new byte[10240];
                while (true) {
                    int len = in.read(buf);
                    if (len == -1 || Downloader.this.isCancle) {
                        in.close();
                        raf.close();
                    } else {
                        if (Downloader.this.isPause) {
                            synchronized (Downloader.this.dao) {
                                try {
                                    Downloader.this.dao.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        raf.write(buf, 0, len);
                        Downloader.access$412(Downloader.this, len);
                        info.setDone(Integer.valueOf(info.getDone().intValue() + len));
                        Downloader.this.dao.update(info);
                        msg = new Message();
                        msg.what = 1;
                        msg.getData().putIntArray("done", new int[]{Downloader.this.fileLen, Downloader.this.done});
                        Downloader.this.handler.sendMessage(msg);
                    }
                }
                in.close();
                raf.close();
                if (Downloader.this.isCancle) {
                    Downloader.this.dao.deleteAll2(info.getPath());
                    if (this.file.exists()) {
                        this.file.delete();
                        return;
                    }
                    return;
                }
                Downloader.this.dao.deleteAll(info.getPath(), Downloader.this.fileLen);
            } catch (IOException e2) {
                e2.printStackTrace();
                msg = new Message();
                msg.what = 2;
                msg.getData().putInt("result", 2);
                Downloader.this.handler.sendMessage(msg);
            }
        }
    }

    static /* synthetic */ int access$412(Downloader x0, int x1) {
        int i = x0.done + x1;
        x0.done = i;
        return i;
    }

    public Downloader(Context context, Handler handler) {
        this.dao = new InfoDao(context);
        this.handler = handler;
    }

    public void download(final String path, final String savePath, final int thCount) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(10000);
                    if (conn.getResponseCode() == 200) {
                        Downloader.this.fileLen = conn.getContentLength();
                        File file = new File(savePath);
                        RandomAccessFile raf = new RandomAccessFile(file, "rws");
                        raf.setLength((long) Downloader.this.fileLen);
                        raf.close();
                        Message msg = new Message();
                        msg.what = 0;
                        msg.getData().putInt("fileLen", Downloader.this.fileLen);
                        Downloader.this.handler.sendMessage(msg);
                        int partLen = ((Downloader.this.fileLen + thCount) - 1) / thCount;
                        for (int i = 0; i < thCount; i++) {
                            new DownloadThread(url, file, partLen, i).start();
                        }
                        return;
                    }
                    Downloader.this.m5924();
                } catch (MalformedURLException e) {
                    Downloader.this.m5924();
                } catch (IOException e2) {
                    Downloader.this.m5924();
                }
            }
        }).start();
    }

    /* renamed from: 发送下载失败消息 */
    private void m5924() {
        Message msg = new Message();
        msg.what = 2;
        msg.getData().putInt("result", 2);
        this.handler.sendMessage(msg);
    }

    public void pause() {
        this.isPause = true;
    }

    public void resume() {
        this.isPause = false;
        synchronized (this.dao) {
            this.dao.notifyAll();
        }
    }

    public void cancle() {
        if (this.isPause) {
            this.isPause = false;
            synchronized (this.dao) {
                this.dao.notifyAll();
            }
        }
        this.isCancle = true;
    }
}
