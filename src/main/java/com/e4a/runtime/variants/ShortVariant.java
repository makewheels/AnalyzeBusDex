package com.e4a.runtime.variants;

import com.e4a.runtime.helpers.ConvHelpers;
import com.e4a.runtime.helpers.ExprHelpers;

public final class ShortVariant extends Variant {
    private short value;

    public static final ShortVariant getShortVariant(short value) {
        return new ShortVariant(value);
    }

    private ShortVariant(short value) {
        super((byte) 3);
        this.value = value;
    }

    public boolean getBoolean() {
        return this.value != (short) 0;
    }

    public byte getByte() {
        return ConvHelpers.short2byte(this.value);
    }

    public short getShort() {
        return this.value;
    }

    public int getInteger() {
        return this.value;
    }

    public long getLong() {
        return (long) this.value;
    }

    public float getSingle() {
        return (float) this.value;
    }

    public double getDouble() {
        return (double) this.value;
    }

    public String getString() {
        return Short.toString(this.value);
    }

    public Variant add(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
                return IntegerVariant.getIntegerVariant(getInteger() + rightOp.getInteger());
            default:
                return rightOp.add(this);
        }
    }

    public Variant sub(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
                return IntegerVariant.getIntegerVariant(getInteger() - rightOp.getInteger());
            case (byte) 5:
                return LongVariant.getLongVariant(getLong() - rightOp.getLong());
            case (byte) 6:
                return SingleVariant.getSingleVariant(getSingle() - rightOp.getSingle());
            case (byte) 7:
            case (byte) 8:
                return DoubleVariant.getDoubleVariant(getDouble() - rightOp.getDouble());
            default:
                return super.sub(rightOp);
        }
    }

    public Variant mul(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
                return IntegerVariant.getIntegerVariant(getInteger() * rightOp.getInteger());
            default:
                return rightOp.mul(this);
        }
    }

    public Variant div(Variant rightOp) {
        return DoubleVariant.getDoubleVariant(getDouble()).div(rightOp);
    }

    public Variant idiv(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
                return IntegerVariant.getIntegerVariant(getInteger() / rightOp.getInteger());
            case (byte) 5:
                return LongVariant.getLongVariant(getLong() / rightOp.getLong());
            case (byte) 6:
                return SingleVariant.getSingleVariant(ExprHelpers.idiv(getSingle(), rightOp.getSingle()));
            case (byte) 7:
            case (byte) 8:
                return DoubleVariant.getDoubleVariant(ExprHelpers.idiv(getDouble(), rightOp.getDouble()));
            default:
                return super.idiv(rightOp);
        }
    }

    public Variant mod(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
                return IntegerVariant.getIntegerVariant(getInteger() % rightOp.getInteger());
            case (byte) 5:
                return LongVariant.getLongVariant(getLong() % rightOp.getLong());
            case (byte) 6:
                return SingleVariant.getSingleVariant(getSingle() % rightOp.getSingle());
            case (byte) 7:
            case (byte) 8:
                return DoubleVariant.getDoubleVariant(getDouble() % rightOp.getDouble());
            default:
                return super.mod(rightOp);
        }
    }

    public Variant pow(Variant rightOp) {
        return DoubleVariant.getDoubleVariant(getDouble()).pow(rightOp);
    }

    public Variant neg() {
        return getShortVariant((short) (-this.value));
    }

    public Variant shl(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
                return IntegerVariant.getIntegerVariant(getInteger() << rightOp.getInteger());
            case (byte) 5:
            case (byte) 8:
                return LongVariant.getLongVariant(getLong() << ((int) rightOp.getLong()));
            default:
                return super.and(rightOp);
        }
    }

    public Variant shr(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
                return IntegerVariant.getIntegerVariant(getInteger() >> rightOp.getInteger());
            case (byte) 5:
            case (byte) 8:
                return LongVariant.getLongVariant(getLong() >> ((int) rightOp.getLong()));
            default:
                return super.and(rightOp);
        }
    }

    public int cmp(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
                return getInteger() - rightOp.getInteger();
            default:
                return -rightOp.cmp(this);
        }
    }

    public Variant not() {
        return getShortVariant((short) (this.value ^ -1));
    }

    public Variant and(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
                return IntegerVariant.getIntegerVariant(getInteger() & rightOp.getInteger());
            case (byte) 5:
            case (byte) 8:
                return LongVariant.getLongVariant(getLong() & rightOp.getLong());
            default:
                return super.and(rightOp);
        }
    }

    public Variant or(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
                return IntegerVariant.getIntegerVariant(getInteger() | rightOp.getInteger());
            case (byte) 5:
            case (byte) 8:
                return LongVariant.getLongVariant(getLong() | rightOp.getLong());
            default:
                return super.or(rightOp);
        }
    }

    public Variant xor(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
                return IntegerVariant.getIntegerVariant(getInteger() ^ rightOp.getInteger());
            case (byte) 5:
            case (byte) 8:
                return LongVariant.getLongVariant(getLong() ^ rightOp.getLong());
            default:
                return super.xor(rightOp);
        }
    }
}
