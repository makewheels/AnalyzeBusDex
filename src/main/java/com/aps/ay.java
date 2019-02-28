package com.aps;

import android.telephony.CellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

public final class ay {
    /* renamed from: a */
    int f3398a = Integer.MAX_VALUE;
    /* renamed from: b */
    int f3399b = Integer.MAX_VALUE;
    /* renamed from: c */
    int f3400c = Integer.MAX_VALUE;
    /* renamed from: d */
    int f3401d = Integer.MAX_VALUE;
    /* renamed from: e */
    int f3402e = Integer.MAX_VALUE;

    ay(CellLocation cellLocation) {
        if (cellLocation == null) {
            return;
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            this.f3402e = gsmCellLocation.getCid();
            this.f3401d = gsmCellLocation.getLac();
        } else if (cellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            this.f3400c = cdmaCellLocation.getBaseStationId();
            this.f3399b = cdmaCellLocation.getNetworkId();
            this.f3398a = cdmaCellLocation.getSystemId();
        }
    }
}
