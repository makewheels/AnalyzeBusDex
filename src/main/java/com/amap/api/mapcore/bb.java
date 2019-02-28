package com.amap.api.mapcore;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.RemoteException;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;

/* compiled from: SensorEventHelper */
public class bb implements SensorEventListener {
    /* renamed from: a */
    private SensorManager f1626a;
    /* renamed from: b */
    private Sensor f1627b;
    /* renamed from: c */
    private long f1628c = 0;
    /* renamed from: d */
    private final int f1629d = 100;
    /* renamed from: e */
    private float f1630e;
    /* renamed from: f */
    private Context f1631f;
    /* renamed from: g */
    private C0313u f1632g;
    /* renamed from: h */
    private Marker f1633h;

    public bb(Context context, C0313u c0313u) {
        this.f1631f = context;
        this.f1632g = c0313u;
        this.f1626a = (SensorManager) context.getSystemService("sensor");
        this.f1627b = this.f1626a.getDefaultSensor(3);
    }

    /* renamed from: a */
    public void m2650a() {
        this.f1626a.registerListener(this, this.f1627b, 3);
    }

    /* renamed from: b */
    public void m2652b() {
        this.f1626a.unregisterListener(this, this.f1627b);
    }

    /* renamed from: a */
    public void m2651a(Marker marker) {
        this.f1633h = marker;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (System.currentTimeMillis() - this.f1628c >= 100 && this.f1632g.mo339N().m2863a()) {
            switch (sensorEvent.sensor.getType()) {
                case 3:
                    float a = (sensorEvent.values[0] + ((float) m2649a(this.f1631f))) % 360.0f;
                    if (a > 180.0f) {
                        a -= 360.0f;
                    } else if (a < -180.0f) {
                        a += 360.0f;
                    }
                    if (Math.abs(this.f1630e - a) >= 3.0f) {
                        if (Float.isNaN(a)) {
                            a = 0.0f;
                        }
                        this.f1630e = a;
                        if (this.f1633h != null) {
                            try {
                                this.f1632g.mo362a(C0338k.m2891d(this.f1630e));
                                this.f1633h.setRotateAngle(-this.f1630e);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                        this.f1628c = System.currentTimeMillis();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public static int m2649a(Context context) {
        switch (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 0:
                return 0;
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return -90;
            default:
                return 0;
        }
    }
}
