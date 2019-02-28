package com.e4a.runtime.components.impl.android.p018ok;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import com.alipay.sdk.cons.C0109b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import junit.framework.Assert;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.ok微信支付类库.Util */
public class Util {
    private static final int MAX_DECODE_PICTURE_SIZE = 2764800;
    private static final String TAG = "SDK_Sample.Util";

    /* renamed from: com.e4a.runtime.components.impl.android.ok微信支付类库.Util$SSLSocketFactoryEx */
    private static class SSLSocketFactoryEx extends SSLSocketFactory {
        SSLContext sslContext = SSLContext.getInstance("TLS");

        /* renamed from: com.e4a.runtime.components.impl.android.ok微信支付类库.Util$SSLSocketFactoryEx$1 */
        class C07931 implements X509TrustManager {
            C07931() {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }
        }

        public SSLSocketFactoryEx(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
            super(keyStore);
            C07931 c07931 = new C07931();
            this.sslContext.init(null, new TrustManager[]{c07931}, null);
        }

        public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
            return this.sslContext.getSocketFactory().createSocket(socket, str, i, z);
        }

        public Socket createSocket() throws IOException {
            return this.sslContext.getSocketFactory().createSocket();
        }
    }

    public static byte[] bmpToByteArray(Bitmap bitmap, boolean z) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        if (z) {
            bitmap.recycle();
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toByteArray;
    }

    public static byte[] httpGet(String str) {
        byte[] bArr = null;
        if (str == null || str.length() == 0) {
            Log.e(TAG, "httpGet, url is null");
        } else {
            try {
                HttpResponse execute = Util.getNewHttpClient().execute(new HttpGet(str));
                if (execute.getStatusLine().getStatusCode() != 200) {
                    Log.e(TAG, "httpGet fail, status code = " + execute.getStatusLine().getStatusCode());
                } else {
                    bArr = EntityUtils.toByteArray(execute.getEntity());
                }
            } catch (Exception e) {
                Log.e(TAG, "httpGet exception, e = " + e.getMessage());
                e.printStackTrace();
            }
        }
        return bArr;
    }

    public static byte[] httpPost(String str, String str2) {
        byte[] bArr = null;
        if (str == null || str.length() == 0) {
            Log.e(TAG, "httpPost, url is null");
        } else {
            HttpClient newHttpClient = Util.getNewHttpClient();
            HttpUriRequest httpPost = new HttpPost(str);
            try {
                httpPost.setEntity(new StringEntity(str2));
                httpPost.setHeader("Accept", "application/json");
                httpPost.setHeader("Content-type", "application/json");
                HttpResponse execute = newHttpClient.execute(httpPost);
                if (execute.getStatusLine().getStatusCode() != 200) {
                    Log.e(TAG, "httpGet fail, status code = " + execute.getStatusLine().getStatusCode());
                } else {
                    bArr = EntityUtils.toByteArray(execute.getEntity());
                }
            } catch (Exception e) {
                Log.e(TAG, "httpPost exception, e = " + e.getMessage());
                e.printStackTrace();
            }
        }
        return bArr;
    }

    private static HttpClient getNewHttpClient() {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load(null, null);
            SocketFactory sSLSocketFactoryEx = new SSLSocketFactoryEx(instance);
            sSLSocketFactoryEx.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme(C0109b.f275a, sSLSocketFactoryEx, 443));
            return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }

    public static byte[] readFromFile(String str, int i, int i2) {
        byte[] bArr = null;
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                if (i2 == -1) {
                    i2 = (int) file.length();
                }
                Log.d(TAG, "readFromFile : offset = " + i + " len = " + i2 + " offset + len = " + (i + i2));
                if (i < 0) {
                    Log.e(TAG, "readFromFile invalid offset:" + i);
                } else if (i2 <= 0) {
                    Log.e(TAG, "readFromFile invalid len:" + i2);
                } else if (i + i2 > ((int) file.length())) {
                    Log.e(TAG, "readFromFile invalid file len:" + file.length());
                } else {
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
                        bArr = new byte[i2];
                        randomAccessFile.seek((long) i);
                        randomAccessFile.readFully(bArr);
                        randomAccessFile.close();
                    } catch (Exception e) {
                        Log.e(TAG, "readFromFile : errMsg = " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } else {
                Log.i(TAG, "readFromFile: file not found");
            }
        }
        return bArr;
    }

    public static Bitmap extractThumbNail(String str, int i, int i2, boolean z) {
        boolean z2 = false;
        if (str != null && !str.equals(bi_常量类.f6358b_空串) && i > 0 && i2 > 0) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Options options = new Options();
        try {
            int i3;
            int i4;
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile != null) {
                decodeFile.recycle();
            }
            Log.d(TAG, "extractThumbNail: round=" + i2 + "x" + i + ", crop=" + z);
            double d = (((double) options.outHeight) * 1.0d) / ((double) i);
            double d2 = (((double) options.outWidth) * 1.0d) / ((double) i2);
            Log.d(TAG, "extractThumbNail: extract beX = " + d2 + ", beY = " + d);
            double d3 = z ? d > d2 ? d2 : d : d < d2 ? d2 : d;
            options.inSampleSize = (int) d3;
            if (options.inSampleSize <= 1) {
                options.inSampleSize = 1;
            }
            while ((options.outHeight * options.outWidth) / options.inSampleSize > MAX_DECODE_PICTURE_SIZE) {
                options.inSampleSize++;
            }
            if (z) {
                if (d > d2) {
                    i3 = i2;
                    i4 = (int) (((((double) i2) * 1.0d) * ((double) options.outHeight)) / ((double) options.outWidth));
                } else {
                    i3 = (int) (((((double) i) * 1.0d) * ((double) options.outWidth)) / ((double) options.outHeight));
                    i4 = i;
                }
            } else if (d < d2) {
                i3 = i2;
                i4 = (int) (((((double) i2) * 1.0d) * ((double) options.outHeight)) / ((double) options.outWidth));
            } else {
                i3 = (int) (((((double) i) * 1.0d) * ((double) options.outWidth)) / ((double) options.outHeight));
                i4 = i;
            }
            options.inJustDecodeBounds = false;
            Log.i(TAG, "bitmap required size=" + i3 + "x" + i4 + ", orig=" + options.outWidth + "x" + options.outHeight + ", sample=" + options.inSampleSize);
            decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile == null) {
                Log.e(TAG, "bitmap decode failed");
                return null;
            }
            Log.i(TAG, "bitmap decoded size=" + decodeFile.getWidth() + "x" + decodeFile.getHeight());
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, i3, i4, true);
            if (createScaledBitmap != null) {
                decodeFile.recycle();
            } else {
                createScaledBitmap = decodeFile;
            }
            if (z) {
                decodeFile = Bitmap.createBitmap(createScaledBitmap, (createScaledBitmap.getWidth() - i2) >> 1, (createScaledBitmap.getHeight() - i) >> 1, i2, i);
                if (decodeFile == null) {
                    return createScaledBitmap;
                }
                createScaledBitmap.recycle();
                Log.i(TAG, "bitmap croped size=" + decodeFile.getWidth() + "x" + decodeFile.getHeight());
            } else {
                decodeFile = createScaledBitmap;
            }
            return decodeFile;
        } catch (OutOfMemoryError e) {
            Log.e(TAG, "decode bitmap failed: " + e.getMessage());
            return null;
        }
    }

    public static String sha1(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }

    public static List<String> stringsToList(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (Object add : strArr) {
            arrayList.add(add);
        }
        return arrayList;
    }
}
