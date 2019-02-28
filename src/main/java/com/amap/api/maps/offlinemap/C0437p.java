package com.amap.api.maps.offlinemap;

import android.os.Environment;
import android.os.StatFs;
import com.alipay.sdk.cons.C0110c;
import com.amap.api.mapcore.util.C0399o;
import com.amap.api.mapcore.util.az;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: Utility */
/* renamed from: com.amap.api.maps.offlinemap.p */
class C0437p {
    /* renamed from: a */
    public static void m3753a(int i) {
        try {
            Thread.sleep((long) i);
        } catch (InterruptedException e) {
            Thread.interrupted();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m3755a(String str) {
    }

    /* renamed from: b */
    public static void m3760b(String str) {
        OutputStreamWriter outputStreamWriter;
        Throwable e;
        String str2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "  " + str;
        try {
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File(C0425d.m3655a() + "error.txt"), true), "utf-8");
            try {
                outputStreamWriter.write(str2);
                if (outputStreamWriter != null) {
                    try {
                        outputStreamWriter.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    az.m3143a(e, "Utility", "wirteErr");
                    e.printStackTrace();
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e5) {
            e = e5;
            outputStreamWriter = null;
            az.m3143a(e, "Utility", "wirteErr");
            e.printStackTrace();
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        } catch (Throwable th2) {
            e = th2;
            outputStreamWriter = null;
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            throw e;
        }
    }

    /* renamed from: a */
    public static String m3752a(Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    /* renamed from: a */
    public static long m3750a() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize());
    }

    /* renamed from: b */
    public static boolean m3761b() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static void m3758b(int i) {
    }

    /* renamed from: c */
    public static List<OfflineMapProvince> m3763c(String str) throws JSONException {
        List<OfflineMapProvince> arrayList = new ArrayList();
        if (str == null || bi_常量类.f6358b_空串.equals(str)) {
            return arrayList;
        }
        JSONObject optJSONObject = new JSONObject(str).optJSONObject("result");
        if (optJSONObject == null) {
            return arrayList;
        }
        optJSONObject = optJSONObject.optJSONObject("offlinemap_with_province");
        if (optJSONObject == null) {
            return arrayList;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("offlinemapinfo_with_province");
        if (optJSONObject2 == null) {
            return arrayList;
        }
        if (optJSONObject2.has("version")) {
            OfflineMapManager.f2421a = optJSONObject2.optString("version");
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("provinces");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
            if (optJSONObject3 != null) {
                arrayList.add(C0437p.m3751a(optJSONObject3));
            }
        }
        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("others");
        optJSONObject = null;
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            optJSONObject = optJSONArray2.getJSONObject(0);
        }
        if (optJSONObject == null) {
            C0399o.m3422a("amap3D", "全国概要为空 ", ErrorCode.DOWNLOAD_OVER_FLOW);
            return arrayList;
        }
        arrayList.add(C0437p.m3751a(optJSONObject));
        return arrayList;
    }

    /* renamed from: a */
    public static OfflineMapProvince m3751a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setUrl(jSONObject.optString("url"));
        offlineMapProvince.setProvinceName(jSONObject.optString(C0110c.f289e));
        offlineMapProvince.setJianpin(jSONObject.optString("jianpin"));
        offlineMapProvince.setPinyin(jSONObject.optString("pinyin"));
        offlineMapProvince.setProvinceCode(jSONObject.optString("adcode"));
        offlineMapProvince.setVersion(jSONObject.optString("version"));
        offlineMapProvince.setSize(Long.parseLong(jSONObject.optString("size")));
        offlineMapProvince.setCityList(C0437p.m3757b(jSONObject));
        return offlineMapProvince;
    }

    /* renamed from: b */
    public static ArrayList<OfflineMapCity> m3757b(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        ArrayList<OfflineMapCity> arrayList = new ArrayList();
        if (optJSONArray == null) {
            return arrayList;
        }
        if (optJSONArray.length() == 0) {
            arrayList.add(C0437p.m3762c(jSONObject));
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(C0437p.m3762c(optJSONObject));
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public static OfflineMapCity m3762c(JSONObject jSONObject) {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setAdcode(jSONObject.optString("adcode"));
        offlineMapCity.setUrl(jSONObject.optString("url"));
        offlineMapCity.setCity(jSONObject.optString(C0110c.f289e));
        offlineMapCity.setCode(jSONObject.optString("citycode"));
        offlineMapCity.setPinyin(jSONObject.optString("pinyin"));
        offlineMapCity.setJianpin(jSONObject.optString("jianpin"));
        offlineMapCity.setVersion(jSONObject.optString("version"));
        offlineMapCity.setSize(Long.parseLong(jSONObject.optString("size")));
        return offlineMapCity;
    }

    /* renamed from: a */
    public static void m3754a(File file, File file2) {
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                C0437p.m3754a(new File(file, list[i]), new File(file2, list[i]));
            }
            return;
        }
        try {
            C0437p.m3759b(file, file2);
        } catch (Throwable e) {
            az.m3143a(e, "Utility", "copyDirectory");
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m3759b(File file, File file2) throws IOException {
        Throwable th;
        FileChannel fileChannel;
        Throwable th2;
        FileChannel fileChannel2 = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                Object channel2 = fileOutputStream.getChannel();
                if (channel != null) {
                    channel.transferTo(0, channel.size(), channel2);
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (channel != null) {
                    channel.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (channel2 != null) {
                    channel2.close();
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel = channel;
                th2 = th;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            fileChannel = fileChannel2;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (fileChannel2 != null) {
                fileChannel2.close();
            }
            throw th2;
        }
    }

    /* renamed from: a */
    public static boolean m3756a(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else if (!C0437p.m3756a(listFiles[i])) {
                    return false;
                }
            }
        }
        return file.delete();
    }
}
