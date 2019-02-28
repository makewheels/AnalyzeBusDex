package com.e4a.runtime.variants;

import com.e4a.runtime.helpers.ConvHelpers;
import com.e4a.runtime.helpers.ExprHelpers;

public final class SingleVariant extends Variant {
    private float value;

    public static final SingleVariant getSingleVariant(float value) {
        return new SingleVariant(value);
    }

    private SingleVariant(float value) {
        super((byte) 6);
        this.value = value;
    }

    public boolean getBoolean() {
        return ConvHelpers.single2boolean(this.value);
    }

    public byte getByte() {
        return ConvHelpers.single2byte(this.value);
    }

    public short getShort() {
        return ConvHelpers.single2short(this.value);
    }

    public int getInteger() {
        return (int) this.value;
    }

    public long getLong() {
        return (long) this.value;
    }

    public float getSingle() {
        return this.value;
    }

    public double getDouble() {
        return (double) this.value;
    }

    public String getString() {
        return Float.toString(this.value);
    }

    public Variant add(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
            case (byte) 5:
            case (byte) 6:
                return getSingleVariant(getSingle() + rightOp.getSingle());
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
            case (byte) 6:
                return getSingleVariant(getSingle() - rightOp.getSingle());
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
            case (byte) 6:
                return getSingleVariant(getSingle() * rightOp.getSingle());
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
            case (byte) 6:
                return getSingleVariant(ExprHelpers.idiv(getSingle(), rightOp.getSingle()));
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
            case (byte) 6:
                return getSingleVariant(getSingle() % rightOp.getSingle());
            case (byte) 7:
            case (byte) 8:
                return DoubleVariant.getDoubleVariant(getDouble() % rightOp.getDouble());
            default:
                return super.mod(rightOp);
        }
    }

    public Variant pow(Variant rightOp) {
        return DoubleVariant.getDoubleVariant(Math.pow(getDouble(), rightOp.getDouble()));
    }

    public Variant neg() {
        return getSingleVariant(-this.value);
    }

    public int cmp(Variant rightOp) {
        switch (rightOp.getKind()) {
            case (byte) 1:
            case (byte) 2:
            case (byte) 3:
            case (byte) 4:
            case (byte) 5:
            case (byte) 6:
                float rvalue = rightOp.getSingle();
                if (this.value == rvalue) {
                    return 0;
                }
                return this.value > rvalue ? 1 : -1;
            default:
                return -rightOp.cmp(this);
        }
    }
}
