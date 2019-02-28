package com.e4a.runtime.variants;

import com.e4a.runtime.helpers.ConvHelpers;
import com.e4a.runtime.helpers.ExprHelpers;

public final class LongVariant extends Variant {
    private long value;

    public static final LongVariant getLongVariant(long value) {
        return new LongVariant(value);
    }

    private LongVariant(long value) {
        super((byte) 5);
        this.value = value;
    }

    public boolean getBoolean() {
        return ConvHelpers.long2boolean(this.value);
    }

    public byte getByte() {
        return ConvHelpers.long2byte(this.value);
    }

    public short getShort() {
        return ConvHelpers.long2short(this.value);
    }

    public int getInteger() {
        return (int) this.value;
    }

    public long getLong() {
        return this.value;
    }

    public float getSingle() {
        return (float) this.value;
    }

    public double getDouble() {
        return (double) this.value;
    }

    public String getString() {
        return Long.toString(this.value);
    }

    public Variant add(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
            case (byte) 5:
                return getLongVariant(getLong() + rightOp.getLong());
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
            case (byte) 5:
                return getLongVariant(getLong() - rightOp.getLong());
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
            case (byte) 5:
                return getLongVariant(getLong() * rightOp.getLong());
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
            case (byte) 5:
                return getLongVariant(getLong() / rightOp.getLong());
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
            case (byte) 5:
                return getLongVariant(getLong() % rightOp.getLong());
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
        return getLongVariant(-this.value);
    }

    public Variant shl(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
            case (byte) 5:
            case (byte) 8:
                return getLongVariant(getLong() << ((int) rightOp.getLong()));
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
            case (byte) 5:
            case (byte) 8:
                return getLongVariant(getLong() >> ((int) rightOp.getLong()));
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
            case (byte) 5:
                long rvalue = rightOp.getLong();
                if (this.value == rvalue) {
                    return 0;
                }
                return this.value > rvalue ? 1 : -1;
            default:
                return -rightOp.cmp(this);
        }
    }

    public Variant not() {
        return getLongVariant(this.value ^ -1);
    }

    public Variant and(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
            case (byte) 5:
            case (byte) 8:
                return getLongVariant(getLong() & rightOp.getLong());
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
            case (byte) 5:
            case (byte) 8:
                return getLongVariant(getLong() | rightOp.getLong());
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
            case (byte) 5:
            case (byte) 8:
                return getLongVariant(getLong() ^ rightOp.getLong());
            default:
                return super.xor(rightOp);
        }
    }
}
