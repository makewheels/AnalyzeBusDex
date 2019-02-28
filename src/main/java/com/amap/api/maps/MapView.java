package com.amap.api.maps;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.amap.api.mapcore.C0313u;
import com.amap.api.mapcore.C0318y;
import com.amap.api.mapcore.ak;
import com.amap.api.maps.model.RuntimeRemoteException;

public class MapView extends FrameLayout {
    /* renamed from: a */
    private C0318y f2230a;
    /* renamed from: b */
    private AMap f2231b;
    /* renamed from: c */
    private int f2232c = 0;

    public MapView(Context context) {
        super(context);
        getMapFragmentDelegate().mo449a(context);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2232c = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().mo449a(context);
        getMapFragmentDelegate().mo447a(this.f2232c);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2232c = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().mo449a(context);
        getMapFragmentDelegate().mo447a(this.f2232c);
    }

    public MapView(Context context, AMapOptions aMapOptions) {
        super(context);
        getMapFragmentDelegate().mo449a(context);
        getMapFragmentDelegate().mo451a(aMapOptions);
    }

    protected C0318y getMapFragmentDelegate() {
        if (this.f2230a == null) {
            this.f2230a = new ak();
        }
        return this.f2230a;
    }

    public AMap getMap() {
        try {
            C0313u a = getMapFragmentDelegate().mo446a();
            if (a == null) {
                return null;
            }
            if (this.f2231b == null) {
                this.f2231b = new AMap(a);
            }
            return this.f2231b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void onCreate(Bundle bundle) {
        try {
            addView(getMapFragmentDelegate().mo445a(null, null, bundle), new LayoutParams(-1, -1));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onResume() {
        try {
            getMapFragmentDelegate().mo452b();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onPause() {
        try {
            getMapFragmentDelegate().mo454c();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().mo456e();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().mo457f();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().mo453b(bundle);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setLayerType(int i, Paint paint) {
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        getMapFragmentDelegate().mo447a(i);
    }
}
