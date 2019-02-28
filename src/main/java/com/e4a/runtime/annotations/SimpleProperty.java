package com.e4a.runtime.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleProperty {
    public static final String PROPERTY_TYPE_ASSET = "simple.asset";
    public static final String PROPERTY_TYPE_BOOLEAN = "simple.boolean";
    public static final String PROPERTY_TYPE_COLOR = "simple.color";
    public static final String PROPERTY_TYPE_DOUBLE = "simple.double";
    public static final String PROPERTY_TYPE_GRAVITY = "simple.gravity";
    public static final String PROPERTY_TYPE_HORIZONTAL_ALIGNMENT = "simple.halign";
    public static final String PROPERTY_TYPE_INTEGER = "simple.integer";
    public static final String PROPERTY_TYPE_LAYOUT = "simple.layout";
    public static final String PROPERTY_TYPE_LONG = "simple.long";
    public static final String PROPERTY_TYPE_SINGLE = "simple.single";
    public static final String PROPERTY_TYPE_STRING = "simple.string";
    public static final String PROPERTY_TYPE_TEXT = "simple.text";
    public static final String PROPERTY_TYPE_TEXTJUSTIFICATION = "simple.justification";
    public static final String PROPERTY_TYPE_TYPEFACE = "simple.typeface";
    public static final String PROPERTY_TYPE_VERTICAL_ALIGNMENT = "simple.valign";

    String initializer() default "";

    String type() default "simple.text";
}
