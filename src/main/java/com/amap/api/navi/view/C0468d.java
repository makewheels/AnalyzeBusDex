package com.amap.api.navi.view;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.amap.api.maps.model.Marker;

/* compiled from: PersonOverlay */
/* renamed from: com.amap.api.navi.view.d */
public class C0468d implements SensorEventListener {
    /* renamed from: a */
    private Sensor f2838a;
    /* renamed from: b */
    private Marker f2839b;
    /* renamed from: c */
    private Marker f2840c;
    /* renamed from: d */
    private Marker f2841d;
    /* renamed from: e */
    private int f2842e;
    /* renamed from: f */
    private float f2843f;
    /* renamed from: g */
    private SensorManager f2844g;

    /* renamed from: a */
    public void m3968a() {
        if (this.f2839b != null) {
            this.f2839b.destroy();
        }
        if (this.f2840c != null) {
            this.f2840c.destroy();
        }
        if (this.f2841d != null) {
            this.f2841d.destroy();
        }
        if (this.f2844g != null) {
            this.f2844g.unregisterListener(this);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == this.f2838a && this.f2838a != null) {
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length > 0) {
                if (fArr.length > 2) {
                    if (this.f2842e == 270 && fArr[2] > 30.0f) {
                        this.f2842e = 90;
                    } else if (this.f2842e == 90 && fArr[2] < -30.0f) {
                        this.f2842e = 270;
                    }
                }
                float f = (fArr[0] + ((float) this.f2842e)) % 360.0f;
                if (((double) Math.abs(f - this.f2843f)) > 0.1d) {
                    this.f2843f = f;
                    f = 360.0f - f;
                    if (this.f2840c != null) {
                        this.f2840c.setRotateAngle(f);
                    }
                }
            }
        }
    }
}
