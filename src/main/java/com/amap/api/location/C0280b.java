package com.amap.api.location;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.location.core.C0282a;
import com.amap.api.location.core.C0284c;
import com.amap.api.location.core.C0285d;
import com.aps.C0569l;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: AMapWeather */
/* renamed from: com.amap.api.location.b */
public class C0280b implements AMapLocationListener {
    /* renamed from: a */
    C0279a f1272a = null;
    /* renamed from: b */
    AMapLocalWeatherListener f1273b;
    /* renamed from: c */
    C0277a f1274c;
    /* renamed from: d */
    private Context f1275d;
    /* renamed from: e */
    private int f1276e;
    /* renamed from: f */
    private AMapLocalWeatherListener f1277f;

    /* compiled from: AMapWeather */
    /* renamed from: com.amap.api.location.b$a */
    static class C0279a extends Handler {
        /* renamed from: a */
        private WeakReference<C0280b> f1271a;

        C0279a(C0280b c0280b, Looper looper) {
            super(looper);
            try {
                this.f1271a = new WeakReference(c0280b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void handleMessage(Message message) {
            try {
                super.handleMessage(message);
                final C0280b c0280b = (C0280b) this.f1271a.get();
                switch (message.what) {
                    case 1:
                        if (c0280b.f1273b != null) {
                            c0280b.f1273b.onWeatherLiveSearched((AMapLocalWeatherLive) message.obj);
                            return;
                        }
                        return;
                    case 2:
                        if (c0280b.f1273b != null) {
                            c0280b.f1273b.onWeatherForecaseSearched((AMapLocalWeatherForecast) message.obj);
                            return;
                        }
                        return;
                    case 3:
                        final AMapLocation aMapLocation = (AMapLocation) message.obj;
                        new Thread(this) {
                            /* renamed from: c */
                            final /* synthetic */ C0279a f1270c;

                            public void run() {
                                try {
                                    if (c0280b.f1276e == 1) {
                                        c0280b.m1800a(aMapLocation, "base", c0280b.f1277f);
                                    }
                                    if (c0280b.f1276e == 2) {
                                        c0280b.m1800a(aMapLocation, "all", c0280b.f1277f);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        }.start();
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            th.printStackTrace();
        }
    }

    public C0280b(C0277a c0277a, Context context) {
        this.f1275d = context;
        this.f1274c = c0277a;
        this.f1272a = new C0279a(this, context.getMainLooper());
    }

    /* renamed from: a */
    void m1799a(int i, AMapLocalWeatherListener aMapLocalWeatherListener, AMapLocation aMapLocation) {
        try {
            this.f1276e = i;
            this.f1277f = aMapLocalWeatherListener;
            if (aMapLocation == null) {
                this.f1274c.m1784a(-1, 10.0f, (AMapLocationListener) this, LocationProviderProxy.AMapNetwork, true);
                return;
            }
            if (i == 1) {
                m1800a(aMapLocation, "base", aMapLocalWeatherListener);
            }
            if (i == 2) {
                m1800a(aMapLocation, "all", aMapLocalWeatherListener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    void m1800a(AMapLocation aMapLocation, String str, AMapLocalWeatherListener aMapLocalWeatherListener) throws Exception {
        this.f1273b = aMapLocalWeatherListener;
        if (aMapLocation != null) {
            AMapLocException aMapLocException;
            byte[] a = m1795a(aMapLocation, str);
            String a2 = m1794a();
            AMapLocException aMapLocException2 = new AMapLocException();
            String str2 = null;
            try {
                str2 = C0569l.m4533a().m4540a(this.f1275d, a2, a, "sea");
            } catch (AMapLocException e) {
                aMapLocException2 = e;
            }
            if ("base".equals(str)) {
                AMapLocalWeatherLive a3;
                if (str2 != null) {
                    aMapLocException = aMapLocException2;
                    a3 = m1793a(str2, aMapLocation);
                } else {
                    a3 = new AMapLocalWeatherLive();
                    aMapLocException = new AMapLocException("http连接失败 - ConnectionException");
                }
                a3.m1751a(aMapLocException);
                a3.setCity(aMapLocation.getCity());
                a3.setCityCode(aMapLocation.getCityCode());
                a3.setProvince(aMapLocation.getProvince());
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = a3;
                this.f1272a.sendMessage(obtain);
            } else {
                aMapLocException = aMapLocException2;
            }
            if ("all".equals(str)) {
                AMapLocalWeatherForecast b;
                if (str2 != null) {
                    b = m1796b(str2, aMapLocation);
                } else {
                    b = new AMapLocalWeatherForecast();
                    aMapLocException = new AMapLocException("http连接失败 - ConnectionException");
                }
                b.m1748a(aMapLocException);
                Message obtain2 = Message.obtain();
                obtain2.what = 2;
                obtain2.obj = b;
                this.f1272a.sendMessage(obtain2);
            }
        }
    }

    /* renamed from: a */
    private byte[] m1795a(AMapLocation aMapLocation, String str) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&ec=1").append("&extensions=" + str).append("&city=").append(aMapLocation.getAdCode());
        stringBuffer.append("&key=" + C0284c.m1823a());
        return C0282a.m1818b(C0282a.m1815a(stringBuffer.toString())).getBytes("utf-8");
    }

    /* renamed from: a */
    private String m1794a() {
        return "http://restapi.amap.com/v3/weather/weatherInfo?";
    }

    /* renamed from: a */
    private AMapLocalWeatherLive m1793a(String str, AMapLocation aMapLocation) throws JSONException {
        AMapLocalWeatherLive aMapLocalWeatherLive = new AMapLocalWeatherLive();
        try {
            C0285d.m1845a(str);
        } catch (AMapLocException e) {
            aMapLocalWeatherLive.m1751a(e);
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("lives");
            if (jSONArray != null && jSONArray.length() > 0) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(0);
                String a = m1798a(jSONObject, "weather");
                String a2 = m1798a(jSONObject, "temperature");
                String a3 = m1798a(jSONObject, "winddirection");
                String a4 = m1798a(jSONObject, "windpower");
                String a5 = m1798a(jSONObject, "humidity");
                String a6 = m1798a(jSONObject, "reporttime");
                aMapLocalWeatherLive.m1752a(a);
                aMapLocalWeatherLive.m1757f(a6);
                aMapLocalWeatherLive.m1756e(a5);
                aMapLocalWeatherLive.m1753b(a2);
                aMapLocalWeatherLive.m1754c(a3);
                aMapLocalWeatherLive.m1755d(a4);
                aMapLocalWeatherLive.setCity(aMapLocation.getCity());
                aMapLocalWeatherLive.setCityCode(aMapLocation.getCityCode());
                aMapLocalWeatherLive.setProvince(aMapLocation.getProvince());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aMapLocalWeatherLive;
    }

    /* renamed from: b */
    private AMapLocalWeatherForecast m1796b(String str, AMapLocation aMapLocation) throws JSONException {
        AMapLocalWeatherForecast aMapLocalWeatherForecast = new AMapLocalWeatherForecast();
        try {
            C0285d.m1845a(str);
        } catch (AMapLocException e) {
            aMapLocalWeatherForecast.m1748a(e);
            e.printStackTrace();
        }
        JSONArray jSONArray = new JSONObject(str).getJSONArray("forecasts");
        if (jSONArray != null && jSONArray.length() > 0) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(0);
            aMapLocalWeatherForecast.m1749a(m1798a(jSONObject, "reporttime"));
            JSONArray jSONArray2 = jSONObject.getJSONArray("casts");
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                List arrayList = new ArrayList();
                for (int i = 0; i < jSONArray2.length(); i++) {
                    AMapLocalDayWeatherForecast aMapLocalDayWeatherForecast = new AMapLocalDayWeatherForecast();
                    jSONObject = (JSONObject) jSONArray2.get(i);
                    String a = m1798a(jSONObject, "date");
                    String a2 = m1798a(jSONObject, "week");
                    String a3 = m1798a(jSONObject, "dayweather");
                    String a4 = m1798a(jSONObject, "nightweather");
                    String a5 = m1798a(jSONObject, "daytemp");
                    String a6 = m1798a(jSONObject, "nighttemp");
                    String a7 = m1798a(jSONObject, "daywind");
                    String a8 = m1798a(jSONObject, "nightwind");
                    String a9 = m1798a(jSONObject, "daypower");
                    String a10 = m1798a(jSONObject, "nightpower");
                    aMapLocalDayWeatherForecast.m1738a(a);
                    aMapLocalDayWeatherForecast.m1739b(a2);
                    aMapLocalDayWeatherForecast.m1740c(a3);
                    aMapLocalDayWeatherForecast.m1741d(a4);
                    aMapLocalDayWeatherForecast.m1742e(a5);
                    aMapLocalDayWeatherForecast.m1743f(a6);
                    aMapLocalDayWeatherForecast.m1744g(a7);
                    aMapLocalDayWeatherForecast.m1745h(a8);
                    aMapLocalDayWeatherForecast.m1746i(a9);
                    aMapLocalDayWeatherForecast.m1747j(a10);
                    aMapLocalDayWeatherForecast.setCity(aMapLocation.getCity());
                    aMapLocalDayWeatherForecast.setCityCode(aMapLocation.getCityCode());
                    aMapLocalDayWeatherForecast.setProvince(aMapLocation.getProvince());
                    arrayList.add(aMapLocalDayWeatherForecast);
                }
                aMapLocalWeatherForecast.m1750a(arrayList);
            }
        }
        return aMapLocalWeatherForecast;
    }

    /* renamed from: a */
    protected String m1798a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null) {
            return bi_常量类.f6358b_空串;
        }
        String str2 = bi_常量类.f6358b_空串;
        if (!jSONObject.has(str) || jSONObject.getString(str).equals("[]")) {
            return str2;
        }
        return jSONObject.optString(str);
    }

    public void onLocationChanged(Location location) {
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            try {
                if (aMapLocation.getAMapException() != null && aMapLocation.getAMapException().getErrorCode() == 0) {
                    this.f1274c.m1786a((AMapLocationListener) this);
                    Message obtain = Message.obtain();
                    obtain.what = 3;
                    obtain.obj = aMapLocation;
                    this.f1272a.sendMessage(obtain);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
