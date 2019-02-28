package com.amap.api.services.core;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import p054u.aly.bi_常量类;

/* compiled from: Encrypt */
/* renamed from: com.amap.api.services.core.h */
public class C0483h {
    /* renamed from: a */
    static byte[] m4035a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        try {
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(1, secretKeySpec);
            bArr3 = instance.doFinal(bArr2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bArr3;
    }

    /* renamed from: a */
    public static byte[] m4034a(byte[] bArr, Key key) throws Exception {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    public static PublicKey m4032a(Context context) throws Exception {
        try {
            InputStream open = context.getAssets().open("search_public_key.der");
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            KeyFactory instance2 = KeyFactory.getInstance("RSA");
            Certificate generateCertificate = instance.generateCertificate(open);
            open.close();
            return instance2.generatePublic(new X509EncodedKeySpec(generateCertificate.getPublicKey().getEncoded()));
        } catch (IOException e) {
            return null;
        } catch (CertificateException e2) {
            return null;
        } catch (NoSuchAlgorithmException e3) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e4) {
            throw new Exception("公钥非法");
        } catch (NullPointerException e5) {
            throw new Exception("公钥数据为空");
        }
    }

    /* renamed from: a */
    public static byte[] m4033a(byte[] bArr) {
        byte[] toByteArray;
        Exception e;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return toByteArray;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            toByteArray = null;
            e = exception;
            e.printStackTrace();
            return toByteArray;
        }
        return toByteArray;
    }

    /* renamed from: b */
    public static String m4036b(byte[] bArr) {
        return bArr != null ? C0475a.m3989a(bArr) : bi_常量类.f6358b;
    }
}
