package com.e4a.runtime.variants;

import com.e4a.runtime.helpers.ConvHelpers;

public final class BooleanVariant extends Variant {
    private boolean value;

    public static final BooleanVariant getBooleanVariant(boolean value) {
        return new BooleanVariant(value);
    }

    private BooleanVariant(boolean value) {
        super((byte) 1);
        this.value = value;
    }

    public boolean getBoolean() {
        return this.value;
    }

    public byte getByte() {
        return (byte) ConvHelpers.boolean2integer(this.value);
    }

    public short getShort() {
        return (short) ConvHelpers.boolean2integer(this.value);
    }

    public int getInteger() {
        return ConvHelpers.boolean2integer(this.value);
    }

    public long getLong() {
        return ConvHelpers.boolean2long(this.value);
    }

    public float getSingle() {
        return ConvHelpers.boolean2single(this.value);
    }

    public double getDouble() {
        return ConvHelpers.boolean2double(this.value);
    }

    public String getString() {
        return ConvHelpers.boolean2string(this.value);
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
                return SingleVariant.getSingleVariant(getSingle()).idiv(rightOp);
            case (byte) 7:
            case (byte) 8:
                return DoubleVariant.getDoubleVariant(getDouble()).idiv(rightOp);
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
                return super.sub(rightOp);
        }
    }

    public Variant pow(Variant rightOp) {
        return DoubleVariant.getDoubleVariant(getDouble()).pow(rightOp);
    }

    public Variant neg() {
        return IntegerVariant.getIntegerVariant(-getInteger());
    }

    public Variant shl(Variant rightOp) {
        return this;
    }

    public Variant shr(Variant rightOp) {
        return this;
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
        return getBooleanVariant(!this.value);
    }

    public Variant and(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
                return getBooleanVariant(this.value & rightOp.getBoolean());
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
                return IntegerVariant.getIntegerVariant(getInteger() & rightOp.getInteger());
            case (byte) 5:
            case (byte) 8:
                return LongVariant.getLongVariant(((long) getInteger()) & rightOp.getLong());
            default:
                return super.and(rightOp);
        }
    }

    public Variant or(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
                return getBooleanVariant(this.value | rightOp.getBoolean());
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
                return IntegerVariant.getIntegerVariant(getInteger() | rightOp.getInteger());
            case (byte) 5:
            case (byte) 8:
                return LongVariant.getLongVariant(((long) getInteger()) | rightOp.getLong());
            default:
                return super.or(rightOp);
        }
    }

    public Variant xor(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
                return getBooleanVariant(this.value ^ rightOp.getBoolean());
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
                return IntegerVariant.getIntegerVariant(getInteger() ^ rightOp.getInteger());
            case (byte) 5:
            case (byte) 8:
                return LongVariant.getLongVariant(((long) getInteger()) ^ rightOp.getLong());
            default:
                return super.xor(rightOp);
        }
    }
}
