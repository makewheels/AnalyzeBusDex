package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.collections.C0683_集合类;
import com.e4a.runtime.variants.ArrayVariant;
import java.util.ArrayList;

@SimpleObject
/* renamed from: com.e4a.runtime.字节集操作 */
public final class C0851 {
    private C0851() {
    }

    @SimpleFunction
    /* renamed from: 合并字节集 */
    public static byte[] m6658(byte[] array1, byte[] array2) {
        if (array1 == null && array2 != null) {
            return array2;
        }
        if (array1 != null && array2 == null) {
            return array1;
        }
        if (array1 == null && array2 == null) {
            return null;
        }
        byte[] array3 = new byte[(array1.length + array2.length)];
        System.arraycopy(array1, 0, array3, 0, array1.length);
        System.arraycopy(array2, 0, array3, array1.length, array2.length);
        return array3;
    }

    @SimpleFunction
    /* renamed from: 分割字节集 */
    public static C0683_集合类 m6653(byte[] bytes, byte[] forByte) {
        if (bytes == null || forByte == null) {
            return null;
        }
        int start;
        byte[] newByte;
        ArrayList<byte[]> byteslist = new ArrayList();
        int k = 0;
        int i = 0;
        while (i < bytes.length) {
            int mapByteslength;
            int n;
            if (bytes[i] == forByte[0]) {
                int j = 0;
                while (j < forByte.length && bytes[i + j] == forByte[j]) {
                    j++;
                }
                if (j == forByte.length) {
                    mapByteslength = 0;
                    if (byteslist.size() == 0) {
                        start = 0;
                    } else {
                        for (n = 0; n < byteslist.size(); n++) {
                            mapByteslength += ((byte[]) byteslist.get(n)).length + forByte.length;
                        }
                        start = mapByteslength;
                    }
                    newByte = new byte[(i - start)];
                    System.arraycopy(bytes, start, newByte, 0, newByte.length);
                    byteslist.add(newByte);
                    k++;
                }
            }
            i++;
        }
        if (byteslist.size() == 0) {
            start = 0;
        } else {
            mapByteslength = 0;
            for (n = 0; n < byteslist.size(); n++) {
                mapByteslength += ((byte[]) byteslist.get(n)).length + forByte.length;
            }
            start = mapByteslength;
        }
        newByte = new byte[(i - start)];
        System.arraycopy(bytes, start, newByte, 0, newByte.length);
        byteslist.add(newByte);
        C0683_集合类 returnbytes = new C0683_集合类();
        for (n = 0; n < byteslist.size(); n++) {
            returnbytes.m5454(ArrayVariant.getArrayVariant(byteslist.get(n)));
        }
        return returnbytes;
    }

    @SimpleFunction
    /* renamed from: 取字节集左边 */
    public static byte[] m6656(byte[] bytes, int length) {
        if (bytes == null) {
            return null;
        }
        byte[] result = new byte[length];
        System.arraycopy(bytes, 0, result, 0, length);
        return result;
    }

    @SimpleFunction
    /* renamed from: 取字节集右边 */
    public static byte[] m6655(byte[] bytes, int length) {
        if (bytes == null) {
            return null;
        }
        byte[] result = new byte[length];
        System.arraycopy(bytes, bytes.length - length, result, 0, length);
        return result;
    }

    @SimpleFunction
    /* renamed from: 取字节集中间 */
    public static byte[] m6654(byte[] bytes, int postion, int length) {
        if (bytes == null) {
            return null;
        }
        byte[] result = new byte[length];
        System.arraycopy(bytes, postion, result, 0, length);
        return result;
    }

    @SimpleFunction
    /* renamed from: 取字节集长度 */
    public static int m6657(byte[] bytes) {
        if (bytes == null) {
            return 0;
        }
        return bytes.length;
    }
}
