package com.amap.api.maps2d;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.amap.api.maps2d.model.RuntimeRemoteException;
import com.amap.api.p015a.af;
import com.amap.api.p015a.ai;
import com.amap.api.p015a.aw;

public class MapView extends FrameLayout {
    /* renamed from: a */
    private ai f2562a;
    /* renamed from: b */
    private AMap f2563b;

    public MapView(Context context) {
        super(context);
        getMapFragmentDelegate().mo65a(context);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getMapFragmentDelegate().mo65a(context);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        getMapFragmentDelegate().mo65a(context);
    }

    public MapView(Context context, AMapOptions aMapOptions) {
        super(context);
        getMapFragmentDelegate().mo65a(context);
        getMapFragmentDelegate().mo67a(aMapOptions);
    }

    protected ai getMapFragmentDelegate() {
        if (this.f2562a == null) {
            this.f2562a = new aw();
        }
        return this.f2562a;
    }

    public AMap getMap() {
        ai mapFragmentDelegate = getMapFragmentDelegate();
        if (mapFragmentDelegate == null) {
            return null;
        }
        try {
            af a = mapFragmentDelegate.mo63a();
            if (a == null) {
                return null;
            }
            if (this.f2563b == null) {
                this.f2563b = new AMap(a);
            }
            return this.f2563b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void onCreate(Bundle bundle) {
        try {
            addView(getMapFragmentDelegate().mo62a(null, null, bundle), new LayoutParams(-1, -1));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onResume() {
        try {
            getMapFragmentDelegate().mo68b();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onPause() {
        try {
            getMapFragmentDelegate().mo70c();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().mo72e();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().mo73f();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().mo69b(bundle);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
