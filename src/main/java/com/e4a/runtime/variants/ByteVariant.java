package com.e4a.runtime.variants;

import com.e4a.runtime.helpers.ConvHelpers;
import com.e4a.runtime.helpers.ExprHelpers;

public final class ByteVariant extends Variant {
    private byte value;

    public static final ByteVariant getByteVariant(byte value) {
        return new ByteVariant(value);
    }

    private ByteVariant(byte value) {
        super((byte) 2);
        this.value = value;
    }

    public boolean getBoolean() {
        return this.value != (byte) 0;
    }

    public byte getByte() {
        return this.value;
    }

    public short getShort() {
        return (short) ConvHelpers.byte2integer(this.value);
    }

    public int getInteger() {
        return ConvHelpers.byte2integer(this.value);
    }

    public long getLong() {
        return (long) ConvHelpers.byte2integer(this.value);
    }

    public float getSingle() {
        return (float) ConvHelpers.byte2integer(this.value);
    }

    public double getDouble() {
        return (double) ConvHelpers.byte2integer(this.value);
    }

    public String getString() {
        return Integer.toString(ConvHelpers.byte2integer(this.value));
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
        return getByteVariant((byte) (-this.value));
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
        return getByteVariant((byte) (this.value ^ -1));
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
