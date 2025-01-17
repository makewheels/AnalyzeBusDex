package com.e4a.runtime.variants;

import com.e4a.runtime.errors.UnknownIdentifierError;
import com.e4a.runtime.helpers.ConvHelpers;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ObjectVariant extends Variant {
    private Object value;

    public static final ObjectVariant getObjectVariant(Object value) {
        return new ObjectVariant(value);
    }

    private ObjectVariant(Object value) {
        super((byte) 9);
        this.value = value;
    }

    public Object getObject() {
        return this.value;
    }

    public boolean identical(Variant rightOp) {
        if (rightOp.getKind() != (byte) 9) {
            return super.identical(rightOp);
        }
        return this.value == rightOp.getObject();
    }

    private Object convertVariant(Class<?> type, Variant variant) {
        if (type.isArray()) {
            return variant.getArray();
        }
        if (type == Boolean.TYPE) {
            return Boolean.valueOf(variant.getBoolean());
        }
        if (type == Byte.TYPE) {
            return Byte.valueOf(variant.getByte());
        }
        if (type == Short.TYPE) {
            return Short.valueOf(variant.getShort());
        }
        if (type == Integer.TYPE) {
            return Integer.valueOf(variant.getInteger());
        }
        if (type == Long.TYPE) {
            return Long.valueOf(variant.getLong());
        }
        if (type == Float.TYPE) {
            return Float.valueOf(variant.getSingle());
        }
        if (type == Double.TYPE) {
            return Double.valueOf(variant.getDouble());
        }
        if (type == String.class) {
            return variant.getString();
        }
        return variant.getObject();
    }

    private Variant convertObject(Class<?> type, Object object) {
        if (type == Void.TYPE) {
            return UninitializedVariant.getUninitializedVariant();
        }
        if (type == Boolean.TYPE) {
            return BooleanVariant.getBooleanVariant(((Boolean) object).booleanValue());
        }
        if (type == Byte.TYPE) {
            return ByteVariant.getByteVariant(ConvHelpers.integer2byte(((Byte) object).intValue()));
        }
        if (type == Short.TYPE) {
            return ShortVariant.getShortVariant(ConvHelpers.integer2short(((Short) object).intValue()));
        }
        if (type == Integer.TYPE) {
            return IntegerVariant.getIntegerVariant(((Integer) object).intValue());
        }
        if (type == Long.TYPE) {
            return LongVariant.getLongVariant(((Long) object).longValue());
        }
        if (type == Float.TYPE) {
            return SingleVariant.getSingleVariant(((Float) object).floatValue());
        }
        if (type == Double.TYPE) {
            return DoubleVariant.getDoubleVariant(((Double) object).doubleValue());
        }
        if (type == String.class) {
            return StringVariant.getStringVariant((String) object);
        }
        if (type.isArray()) {
            return ArrayVariant.getArrayVariant(object);
        }
        return getObjectVariant(object);
    }

    private Object[] convertArguments(Class<?>[] argTypes, Variant[] args) {
        int len = argTypes.length;
        Object[] objArgs = new Object[len];
        for (int i = 0; i < len; i++) {
            objArgs[i] = convertVariant(argTypes[i], args[i]);
        }
        return objArgs;
    }

    public Variant function(String name, Variant[] args) {
        for (Method method : this.value.getClass().getMethods()) {
            if (method.getName().equals(name)) {
                Class<?>[] argTypes = method.getParameterTypes();
                if (argTypes.length == args.length) {
                    Object result = null;
                    try {
                        result = method.invoke(this.value, convertArguments(argTypes, args));
                    } catch (IllegalAccessException e) {
                    } catch (InvocationTargetException e2) {
                        throw new UnknownIdentifierError();
                    }
                    return convertObject(method.getReturnType(), result);
                }
            }
        }
        throw new UnknownIdentifierError();
    }

    public Variant dataMember(String name) {
        try {
            Field field = this.value.getClass().getField(name);
            return convertObject(field.getType(), field.get(this.value));
        } catch (NoSuchFieldException e) {
            return function(name, new Variant[0]);
        } catch (IllegalAccessException e2) {
            return null;
        }
    }

    public void dataMember(String name, Variant variant) {
        try {
            Field field = this.value.getClass().getField(name);
            field.set(this.value, convertVariant(field.getType(), variant));
        } catch (NoSuchFieldException e) {
            function(name, new Variant[]{variant});
        } catch (IllegalAccessException e2) {
        }
    }
}
