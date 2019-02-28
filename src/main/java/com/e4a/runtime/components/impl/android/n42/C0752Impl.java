package com.e4a.runtime.components.impl.android.n42;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.e4a.runtime.C0897_网络操作;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.collections.C0682;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.ComponentImpl;
import com.e4a.runtime.events.EventDispatcher;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.n42.多线程Impl */
public class C0752Impl extends ComponentImpl implements C0743 {
    private Handler handler = new C07441();
    private Task task = null;
    /* renamed from: 网址 */
    private String f4316 = bi_常量类.f6358b_空串;

    /* renamed from: com.e4a.runtime.components.impl.android.n42.多线程Impl$1 */
    class C07441 extends Handler {
        C07441() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    String html = msg.getData().getString("result");
                    C0752Impl.this.f4316 = msg.getData().getString("dizhi");
                    C0752Impl.this.mo1162(html);
                    return;
                case 1:
                    String result = msg.getData().getString("result");
                    C0752Impl.this.f4316 = msg.getData().getString("dizhi");
                    C0752Impl.this.mo1157(result);
                    return;
                case 2:
                    byte[] bytes = msg.getData().getByteArray("result");
                    C0752Impl.this.f4316 = msg.getData().getString("dizhi");
                    C0752Impl.this.mo1160(bytes);
                    return;
                case 3:
                    String result3 = msg.getData().getString("result");
                    C0752Impl.this.f4316 = msg.getData().getString("dizhi");
                    C0752Impl.this.mo11553(result3);
                    return;
                case 4:
                    String result2 = msg.getData().getString("result");
                    C0752Impl.this.f4316 = msg.getData().getString("dizhi");
                    C0752Impl.this.mo11542(result2);
                    return;
                case 5:
                    String html2 = msg.getData().getString("result");
                    C0752Impl.this.f4316 = msg.getData().getString("dizhi");
                    C0752Impl.this.mo11612(html2);
                    return;
                case 6:
                    String result4 = msg.getData().getString("result");
                    C0752Impl.this.f4316 = msg.getData().getString("dizhi");
                    C0752Impl.this.mo11564(result4);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n42.多线程Impl$Task */
    private class Task extends AsyncTask<String, Integer, String> {
        public Task(Context context) {
        }

        protected String doInBackground(String... params) {
            C0752Impl.this.mo1174();
            return null;
        }

        protected void onCancelled() {
            C0752Impl.this.mo1171();
        }

        protected void onPostExecute(String result) {
            C0752Impl.this.mo1173();
        }

        protected void onPreExecute() {
            C0752Impl.this.mo1172();
        }

        protected void onProgressUpdate(Integer... values) {
            C0752Impl.this.mo1175(values[0].intValue());
        }
    }

    public C0752Impl(ComponentContainer container) {
        super(container);
    }

    /* renamed from: 启动线程 */
    public void mo1163() {
        this.task = new Task(mainActivity.getContext());
        this.task.execute(new String[]{"0"});
    }

    /* renamed from: 取消线程 */
    public void mo1159() {
        if (this.task != null) {
            this.task.cancel(true);
        }
    }

    /* renamed from: 线程开始 */
    public void mo1172() {
        EventDispatcher.dispatchEvent(this, "线程开始", new Object[0]);
    }

    /* renamed from: 线程过程 */
    public void mo1174() {
        EventDispatcher.dispatchEvent(this, "线程过程", new Object[0]);
    }

    /* renamed from: 线程进度 */
    public void mo1175(int 进度) {
        EventDispatcher.dispatchEvent(this, "线程进度", Integer.valueOf(进度));
    }

    /* renamed from: 线程取消 */
    public void mo1171() {
        EventDispatcher.dispatchEvent(this, "线程取消", new Object[0]);
    }

    /* renamed from: 线程结束 */
    public void mo1173() {
        EventDispatcher.dispatchEvent(this, "线程结束", new Object[0]);
    }

    /* renamed from: 取事件网址 */
    public String mo1158() {
        return this.f4316;
    }

    /* renamed from: 取网页源码完毕 */
    public void mo1162(String 源码) {
        EventDispatcher.dispatchEvent(this, "取网页源码完毕", 源码);
    }

    /* renamed from: 发送网络数据完毕 */
    public void mo1157(String 结果) {
        EventDispatcher.dispatchEvent(this, "发送网络数据完毕", 结果);
    }

    /* renamed from: 发送网络数据2完毕 */
    public void mo11542(String 结果) {
        EventDispatcher.dispatchEvent(this, "发送网络数据2完毕", 结果);
    }

    /* renamed from: 发送网络数据3完毕 */
    public void mo11553(String 结果) {
        EventDispatcher.dispatchEvent(this, "发送网络数据3完毕", 结果);
    }

    /* renamed from: 发送网络数据4完毕 */
    public void mo11564(String 结果) {
        EventDispatcher.dispatchEvent(this, "发送网络数据4完毕", 结果);
    }

    /* renamed from: 取网络文件完毕 */
    public void mo1160(byte[] 文件) {
        EventDispatcher.dispatchEvent(this, "取网络文件完毕", 文件);
    }

    /* renamed from: 取网页源码2完毕 */
    public void mo11612(String 源码) {
        EventDispatcher.dispatchEvent(this, "取网页源码2完毕", 源码);
    }

    /* renamed from: 开始取网页源码 */
    public void mo1169(String 网址, String 编码) {
        final String url = 网址;
        final String charset = 编码;
        new Thread(new Runnable() {
            public void run() {
                String html = C0897_网络操作.m6922(url, charset, 10000);
                Message msg = new Message();
                msg.what = 0;
                msg.getData().putString("result", html);
                msg.getData().putString("dizhi", url);
                C0752Impl.this.handler.sendMessage(msg);
            }
        }).start();
    }

    /* renamed from: 开始发送网络数据 */
    public void mo1164(String 网址, String 参数, String 编码) {
        final String url = 网址;
        final String paramHashmap = 参数;
        final String charset = 编码;
        new Thread(new Runnable() {
            public void run() {
                String result = C0897_网络操作.m6909(url, paramHashmap, charset, 10000);
                Message msg = new Message();
                msg.what = 1;
                msg.getData().putString("result", result);
                msg.getData().putString("dizhi", url);
                C0752Impl.this.handler.sendMessage(msg);
            }
        }).start();
    }

    /* renamed from: 开始发送网络数据2 */
    public void mo11652(String IP, int 端口, String 内容, String 编码) {
        final String url = IP;
        final int port = 端口;
        final String param = 内容;
        final String charset = 编码;
        new Thread(new Runnable() {
            public void run() {
                String result = C0897_网络操作.m69102(url, port, param, charset, 10000);
                Message msg = new Message();
                msg.what = 4;
                msg.getData().putString("result", result);
                msg.getData().putString("dizhi", url);
                C0752Impl.this.handler.sendMessage(msg);
            }
        }).start();
    }

    /* renamed from: 开始发送网络数据3 */
    public void mo11663(String 网址, C0682 参数, String 编码) {
        final String url = 网址;
        final C0682 param = 参数;
        final String charset = 编码;
        new Thread(new Runnable() {
            public void run() {
                String result = C0897_网络操作.m69113(url, param, charset, 10000);
                Message msg = new Message();
                msg.what = 3;
                msg.getData().putString("result", result);
                msg.getData().putString("dizhi", url);
                C0752Impl.this.handler.sendMessage(msg);
            }
        }).start();
    }

    /* renamed from: 开始发送网络数据4 */
    public void mo11674(String 网址, String 参数, String 编码) {
        final String url = 网址;
        final String paramHashmap = 参数;
        final String charset = 编码;
        new Thread(new Runnable() {
            public void run() {
                String result = C0897_网络操作.m69124(url, paramHashmap, charset, 10000);
                Message msg = new Message();
                msg.what = 6;
                msg.getData().putString("result", result);
                msg.getData().putString("dizhi", url);
                C0752Impl.this.handler.sendMessage(msg);
            }
        }).start();
    }

    /* renamed from: 开始取网络文件 */
    public void mo1168(String 网址) {
        final String url = 网址;
        new Thread(new Runnable() {
            public void run() {
                byte[] bytes = C0897_网络操作.m6918(url, 10000);
                Message msg = new Message();
                msg.what = 2;
                msg.getData().putByteArray("result", bytes);
                msg.getData().putString("dizhi", url);
                C0752Impl.this.handler.sendMessage(msg);
            }
        }).start();
    }

    /* renamed from: 开始取网页源码2 */
    public void mo11702(String 网址, String 编码) {
        final String url = 网址;
        final String charset = 编码;
        new Thread(new Runnable() {
            public void run() {
                String html = C0897_网络操作.m69232(url, charset, 10000);
                Message msg = new Message();
                msg.what = 5;
                msg.getData().putString("result", html);
                msg.getData().putString("dizhi", url);
                C0752Impl.this.handler.sendMessage(msg);
            }
        }).start();
    }
}
