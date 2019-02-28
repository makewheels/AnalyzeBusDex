package com.e4a.runtime.helpers;

import com.e4a.runtime.C0888;
import com.e4a.runtime.collections.C0683_集合类;
import com.e4a.runtime.variants.ArrayVariant;
import com.e4a.runtime.variants.IntegerVariant;
import com.e4a.runtime.variants.ObjectVariant;
import com.e4a.runtime.variants.Variant;

public final class StmtHelpers {
    private StmtHelpers() {
    }

    public static int forEachCount(Variant v) {
        if (v instanceof ArrayVariant) {
            return C0888.m6768(v, 1);
        }
        return ((C0683_集合类) ((ObjectVariant) v).getObject()).m5456();
    }

    public static Variant forEachItem(Variant v, int index) {
        if (!(v instanceof ArrayVariant)) {
            return ((C0683_集合类) ((ObjectVariant) v).getObject()).m5455(index);
        }
        return ((ArrayVariant) v).array(new Variant[]{IntegerVariant.getIntegerVariant(index)});
    }
}
