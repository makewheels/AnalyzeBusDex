package com.e4a.runtime.variants;

import com.e4a.runtime.errors.ConversionError;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public abstract class Variant {
    static Map<String, TypeOfChecker> TYPEOF_CHECKER_MAP = new HashMap();
    protected static final byte VARIANT_ARRAY = (byte) 10;
    protected static final byte VARIANT_BOOLEAN = (byte) 1;
    protected static final byte VARIANT_BYTE = (byte) 2;
    protected static final byte VARIANT_DATE = (byte) 11;
    protected static final byte VARIANT_DOUBLE = (byte) 7;
    protected static final byte VARIANT_INTEGER = (byte) 4;
    protected static final byte VARIANT_LONG = (byte) 5;
    protected static final byte VARIANT_OBJECT = (byte) 9;
    protected static final byte VARIANT_SHORT = (byte) 3;
    protected static final byte VARIANT_SINGLE = (byte) 6;
    protected static final byte VARIANT_STRING = (byte) 8;
    protected static final byte VARIANT_UNINITIALIZED = (byte) 0;
    private final byte kind;

    private interface TypeOfChecker {
        boolean check(Variant variant);
    }

    /* renamed from: com.e4a.runtime.variants.Variant$1 */
    static class C08321 implements TypeOfChecker {
        C08321() {
        }

        public boolean check(Variant v) {
            try {
                v.getString();
                return true;
            } catch (ConversionError e) {
                return false;
            }
        }
    }

    /* renamed from: com.e4a.runtime.variants.Variant$2 */
    static class C08332 implements TypeOfChecker {
        C08332() {
        }

        public boolean check(Variant v) {
            try {
                v.getDate();
                return true;
            } catch (ConversionError e) {
                return false;
            }
        }
    }

    /* renamed from: com.e4a.runtime.variants.Variant$3 */
    static class C08343 implements TypeOfChecker {
        C08343() {
        }

        public boolean check(Variant v) {
            try {
                v.getBoolean();
                return true;
            } catch (ConversionError e) {
                return false;
            }
        }
    }

    /* renamed from: com.e4a.runtime.variants.Variant$4 */
    static class C08354 implements TypeOfChecker {
        C08354() {
        }

        public boolean check(Variant v) {
            try {
                v.getByte();
                return true;
            } catch (ConversionError e) {
                return false;
            }
        }
    }

    /* renamed from: com.e4a.runtime.variants.Variant$5 */
    static class C08365 implements TypeOfChecker {
        C08365() {
        }

        public boolean check(Variant v) {
            try {
                v.getShort();
                return true;
            } catch (ConversionError e) {
                return false;
            }
        }
    }

    /* renamed from: com.e4a.runtime.variants.Variant$6 */
    static class C08376 implements TypeOfChecker {
        C08376() {
        }

        public boolean check(Variant v) {
            try {
                v.getInteger();
                return true;
            } catch (ConversionError e) {
                return false;
            }
        }
    }

    /* renamed from: com.e4a.runtime.variants.Variant$7 */
    static class C08387 implements TypeOfChecker {
        C08387() {
        }

        public boolean check(Variant v) {
            try {
                v.getLong();
                return true;
            } catch (ConversionError e) {
                return false;
            }
        }
    }

    /* renamed from: com.e4a.runtime.variants.Variant$8 */
    static class C08398 implements TypeOfChecker {
        C08398() {
        }

        public boolean check(Variant v) {
            try {
                v.getSingle();
                return true;
            } catch (ConversionError e) {
                return false;
            }
        }
    }

    /* renamed from: com.e4a.runtime.variants.Variant$9 */
    static class C08409 implements TypeOfChecker {
        C08409() {
        }

        public boolean check(Variant v) {
            try {
                v.getDouble();
                return true;
            } catch (ConversionError e) {
                return false;
            }
        }
    }

    static {
        TYPEOF_CHECKER_MAP.put("java/lang/String", new C08321());
        TYPEOF_CHECKER_MAP.put("java/util/Calendar", new C08332());
        TYPEOF_CHECKER_MAP.put("Z", new C08343());
        TYPEOF_CHECKER_MAP.put("B", new C08354());
        TYPEOF_CHECKER_MAP.put("S", new C08365());
        TYPEOF_CHECKER_MAP.put("I", new C08376());
        TYPEOF_CHECKER_MAP.put("J", new C08387());
        TYPEOF_CHECKER_MAP.put("F", new C08398());
        TYPEOF_CHECKER_MAP.put("D", new C08409());
    }

    protected Variant(byte kind) {
        this.kind = kind;
    }

    protected final byte getKind() {
        return this.kind;
    }

    public int getType() {
        return this.kind;
    }

    public boolean getBoolean() {
        throw new ConversionError();
    }

    public byte getByte() {
        throw new ConversionError();
    }

    public short getShort() {
        throw new ConversionError();
    }

    public int getInteger() {
        throw new ConversionError();
    }

    public long getLong() {
        throw new ConversionError();
    }

    public float getSingle() {
        throw new ConversionError();
    }

    public double getDouble() {
        throw new ConversionError();
    }

    public String getString() {
        throw new ConversionError();
    }

    public Object getObject() {
        throw new ConversionError();
    }

    public Object getArray() {
        throw new ConversionError();
    }

    public Calendar getDate() {
        throw new ConversionError();
    }

    public Variant add(Variant rightOp) {
        throw new ConversionError();
    }

    public Variant sub(Variant rightOp) {
        throw new ConversionError();
    }

    public Variant mul(Variant rightOp) {
        throw new ConversionError();
    }

    public Variant div(Variant rightOp) {
        throw new ConversionError();
    }

    public Variant idiv(Variant rightOp) {
        throw new ConversionError();
    }

    public Variant mod(Variant rightOp) {
        throw new ConversionError();
    }

    public Variant pow(Variant rightOp) {
        throw new ConversionError();
    }

    public Variant neg() {
        throw new ConversionError();
    }

    public Variant shl(Variant rightOp) {
        throw new ConversionError();
    }

    public Variant shr(Variant rightOp) {
        throw new ConversionError();
    }

    public int cmp(Variant rightOp) {
        throw new ConversionError();
    }

    public boolean identical(Variant rightOp) {
        throw new ConversionError();
    }

    public boolean like(Variant rightOp) {
        throw new ConversionError();
    }

    public boolean typeof(String internalName) {
        TypeOfChecker checker = (TypeOfChecker) TYPEOF_CHECKER_MAP.get(internalName);
        if (checker != null) {
            return checker.check(this);
        }
        try {
            return Class.forName(internalName.replace('/', '.')).isInstance(this.kind == (byte) 10 ? getArray() : getObject());
        } catch (ConversionError e) {
            return false;
        } catch (ClassNotFoundException e2) {
            return false;
        }
    }

    public Variant not() {
        throw new ConversionError();
    }

    public Variant and(Variant rightOp) {
        throw new ConversionError();
    }

    public Variant or(Variant rightOp) {
        throw new ConversionError();
    }

    public Variant xor(Variant rightOp) {
        throw new ConversionError();
    }

    public Variant function(String name, Variant[] args) {
        throw new ConversionError();
    }

    public Variant dataMember(String name) {
        throw new ConversionError();
    }

    public void dataMember(String name, Variant variant) {
        throw new ConversionError();
    }

    public Variant array(Variant[] indices) {
        throw new ConversionError();
    }

    public void array(Variant[] indices, Variant variant) {
        throw new ConversionError();
    }
}
