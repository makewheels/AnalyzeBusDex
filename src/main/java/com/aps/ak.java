package com.aps;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;

final class ak extends PhoneStateListener {
    /* renamed from: a */
    private /* synthetic */ ai f3362a;

    private ak(ai aiVar) {
        this.f3362a = aiVar;
    }

    public final void onCellLocationChanged(CellLocation cellLocation) {
        try {
            this.f3362a.f3354s = System.currentTimeMillis();
            this.f3362a.f3357w = cellLocation;
            super.onCellLocationChanged(cellLocation);
        } catch (Exception e) {
        }
    }

    public final void onServiceStateChanged(ServiceState serviceState) {
        try {
            if (serviceState.getState() == 0) {
                this.f3362a.f3345j = true;
                String[] a = ai.m4350b(this.f3362a.f3337b);
                this.f3362a.f3349n = Integer.parseInt(a[0]);
                this.f3362a.f3350o = Integer.parseInt(a[1]);
            } else {
                this.f3362a.f3345j = false;
            }
            super.onServiceStateChanged(serviceState);
        } catch (Exception e) {
        }
    }

    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        try {
            if (this.f3362a.f3343h) {
                this.f3362a.f3344i = signalStrength.getCdmaDbm();
            } else {
                this.f3362a.f3344i = signalStrength.getGsmSignalStrength();
                if (this.f3362a.f3344i == 99) {
                    this.f3362a.f3344i = -1;
                } else {
                    this.f3362a.f3344i = (this.f3362a.f3344i * 2) - 113;
                }
            }
            super.onSignalStrengthsChanged(signalStrength);
        } catch (Exception e) {
        }
    }
}
