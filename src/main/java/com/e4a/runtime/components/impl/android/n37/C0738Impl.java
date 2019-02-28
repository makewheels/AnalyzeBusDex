package com.e4a.runtime.components.impl.android.n37;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.ComponentImpl;
import com.e4a.runtime.events.EventDispatcher;
import com.tencent.smtt.sdk.WebView;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/* renamed from: com.e4a.runtime.components.impl.android.n37.客户Impl */
public class C0738Impl extends ComponentImpl implements C0736 {
    private static final int CONNECT_FAIL = 1;
    private static final int CONNECT_SUCCEED = 2;
    private static final int DISCONNECT = 4;
    private static final int RECEIVE_MSG = 3;
    private ConnectThread connectThread;
    private ConnectedThread connectedThread;
    private Handler mHandler = new C07371();
    private int receiveSize = 1024;
    private Socket socket;
    private boolean stop = true;

    /* renamed from: com.e4a.runtime.components.impl.android.n37.客户Impl$1 */
    class C07371 extends Handler {
        C07371() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    C0738Impl.this.mo1134(false);
                    return;
                case 2:
                    C0738Impl.this.socket = C0738Impl.this.connectThread.getSocket();
                    C0738Impl.this.stop = false;
                    C0738Impl.this.connectedThread = new ConnectedThread(C0738Impl.this.socket);
                    C0738Impl.this.connectedThread.start();
                    C0738Impl.this.mo1134(true);
                    return;
                case 3:
                    C0738Impl.this.mo1131(msg.getData().getByteArray("byte"));
                    return;
                case 4:
                    C0738Impl.this.mo1132();
                    C0738Impl.this.mo1135();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n37.客户Impl$ConnectThread */
    private class ConnectThread extends Thread {
        private String IP;
        private int PORT;
        private Socket SOKET;
        private int TIMEOUT;

        ConnectThread(String ip, int port, int timeout) {
            this.IP = ip;
            this.PORT = port;
            this.TIMEOUT = timeout;
        }

        public void run() {
            try {
                this.SOKET = new Socket();
                this.SOKET.setOOBInline(true);
                this.SOKET.setKeepAlive(true);
                this.SOKET.connect(new InetSocketAddress(this.IP, this.PORT), this.TIMEOUT);
            } catch (IOException e) {
                C0738Impl.this.mHandler.sendEmptyMessage(1);
                this.SOKET = null;
            }
            if (this.SOKET != null) {
                Message msg = new Message();
                msg.what = 2;
                C0738Impl.this.mHandler.sendMessage(msg);
            }
        }

        public Socket getSocket() {
            return this.SOKET;
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n37.客户Impl$ConnectedThread */
    private class ConnectedThread extends Thread {
        private Socket SOKET;
        private InputStream inStream = null;
        private OutputStream outStream = null;

        ConnectedThread(Socket s) {
            this.SOKET = s;
        }

        public void run() {
            while (!C0738Impl.this.stop) {
                int size;
                byte[] buf = new byte[C0738Impl.this.m5948()];
                try {
                    this.inStream = this.SOKET.getInputStream();
                    size = this.inStream.read(buf);
                } catch (IOException e) {
                    e.printStackTrace();
                    size = 0;
                }
                if (size > 0) {
                    byte[] buf2 = new byte[size];
                    System.arraycopy(buf, 0, buf2, 0, size);
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("byte", buf2);
                    Message msg = new Message();
                    msg.setData(bundle);
                    msg.what = 3;
                    C0738Impl.this.mHandler.sendMessage(msg);
                }
            }
        }

        public void writeByte(byte[] buf) {
            try {
                this.outStream = this.SOKET.getOutputStream();
                this.outStream.write(buf);
                this.outStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
                Message msg = new Message();
                msg.what = 4;
                C0738Impl.this.mHandler.sendMessage(msg);
            }
        }

        public boolean writeInt(int buf) {
            try {
                this.outStream = this.SOKET.getOutputStream();
                this.outStream.write(buf);
                this.outStream.flush();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                Message msg = new Message();
                msg.what = 4;
                C0738Impl.this.mHandler.sendMessage(msg);
                return false;
            }
        }
    }

    public C0738Impl(ComponentContainer container) {
        super(container);
    }

    /* renamed from: 连接完毕 */
    public void mo1134(boolean result) {
        EventDispatcher.dispatchEvent(this, "连接完毕", Boolean.valueOf(result));
    }

    /* renamed from: 收到数据 */
    public void mo1131(byte[] msg) {
        EventDispatcher.dispatchEvent(this, "收到数据", msg);
    }

    /* renamed from: 连接断开 */
    public void mo1135() {
        EventDispatcher.dispatchEvent(this, "连接断开", new Object[0]);
    }

    /* renamed from: 置接收数据包大小 */
    public void mo1133(int size) {
        this.receiveSize = size;
    }

    /* renamed from: 取接收数据包大小 */
    private int m5948() {
        return this.receiveSize;
    }

    /* renamed from: 连接服务器 */
    public void mo1136(String ip, int port, int timeout) {
        this.connectThread = new ConnectThread(ip, port, timeout);
        this.connectThread.start();
    }

    /* renamed from: 取连接状态 */
    public boolean mo1130() {
        if (this.socket == null) {
            return false;
        }
        try {
            this.socket.sendUrgentData(WebView.NORMAL_MODE_ALPHA);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: 发送数据 */
    public void mo1129(byte[] sendStr) {
        if (this.socket != null) {
            this.connectedThread.writeByte(sendStr);
        }
    }

    /* renamed from: 断开连接 */
    public void mo1132() {
        this.stop = true;
        if (this.socket != null) {
            try {
                this.socket.shutdownInput();
                this.socket.shutdownOutput();
                InputStream in = this.socket.getInputStream();
                OutputStream ou = this.socket.getOutputStream();
                in.close();
                ou.close();
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.connectThread != null) {
            this.connectThread.interrupt();
        }
        if (this.connectedThread != null) {
            this.connectedThread.interrupt();
        }
    }
}
