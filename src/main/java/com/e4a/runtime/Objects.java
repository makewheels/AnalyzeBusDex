package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;
import com.e4a.runtime.variants.IntegerVariant;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Objects {
    private static final Map<Class<?>, List<PropertyDescriptor>> COMPONENT_MAP = new HashMap();
    private static final Map<String, PropertyInitializer> PROPERTY_INITIALIZERS = new HashMap();

    private static abstract class PropertyInitializer {
        abstract void initializer(Object obj, Method method, String str) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException;

        private PropertyInitializer() {
        }

        void run(Object object, Method m, String value) {
            try {
                initializer(object, m, value);
            } catch (IllegalArgumentException e) {
                reportInitializePropertiesError(m, e);
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
                reportInitializePropertiesError(m, e3);
            }
        }

        private static void reportInitializePropertiesError(Method m, Exception e) {
            Log.Error(Log.MODULE_NAME_RTL, "Runtime exception setting property default values: " + m.getName());
            e.printStackTrace();
        }
    }

    /* renamed from: com.e4a.runtime.Objects$1 */
    static class C06641 extends PropertyInitializer {
        C06641() {
            super();
        }

        void initializer(Object object, Method m, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
            m.invoke(object, new Object[]{Objects.unquote(value)});
        }
    }

    /* renamed from: com.e4a.runtime.Objects$2 */
    static class C06652 extends PropertyInitializer {
        C06652() {
            super();
        }

        void initializer(Object object, Method m, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
            m.invoke(object, new Object[]{Boolean.valueOf(value.equals("True"))});
        }
    }

    /* renamed from: com.e4a.runtime.Objects$3 */
    static class C06663 extends PropertyInitializer {
        C06663() {
            super();
        }

        void initializer(Object object, Method m, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
            m.invoke(object, new Object[]{Integer.valueOf(value)});
        }
    }

    /* renamed from: com.e4a.runtime.Objects$4 */
    static class C06674 extends PropertyInitializer {
        C06674() {
            super();
        }

        void initializer(Object object, Method m, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
            m.invoke(object, new Object[]{Double.valueOf(value)});
        }
    }

    /* renamed from: com.e4a.runtime.Objects$5 */
    static class C06685 extends PropertyInitializer {
        C06685() {
            super();
        }

        void initializer(Object object, Method m, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
            m.invoke(object, new Object[]{Integer.valueOf(value)});
        }
    }

    /* renamed from: com.e4a.runtime.Objects$6 */
    static class C06696 extends PropertyInitializer {
        C06696() {
            super();
        }

        void initializer(Object object, Method m, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
            m.invoke(object, new Object[]{Integer.valueOf(value)});
        }
    }

    /* renamed from: com.e4a.runtime.Objects$7 */
    static class C06707 extends PropertyInitializer {
        C06707() {
            super();
        }

        void initializer(Object object, Method m, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
            m.invoke(object, new Object[]{IntegerVariant.getIntegerVariant(Integer.valueOf(value).intValue())});
        }
    }

    /* renamed from: com.e4a.runtime.Objects$8 */
    static class C06718 extends PropertyInitializer {
        C06718() {
            super();
        }

        void initializer(Object object, Method m, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
            m.invoke(object, new Object[]{Long.valueOf(value)});
        }
    }

    /* renamed from: com.e4a.runtime.Objects$9 */
    static class C06729 extends PropertyInitializer {
        C06729() {
            super();
        }

        void initializer(Object object, Method m, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
            m.invoke(object, new Object[]{Float.valueOf(value)});
        }
    }

    private static class PropertyDescriptor {
        private final String initializer;
        /* renamed from: m */
        private final Method f4268m;
        private final PropertyInitializer pi;

        PropertyDescriptor(PropertyInitializer pi, Method m, String initializer) {
            this.pi = pi;
            this.f4268m = m;
            this.initializer = initializer;
        }

        void runInitializer(Object object) {
            this.pi.run(object, this.f4268m, this.initializer);
        }
    }

    private Objects() {
    }

    static {
        PROPERTY_INITIALIZERS.put(SimpleProperty.PROPERTY_TYPE_ASSET, new C06641());
        PROPERTY_INITIALIZERS.put(SimpleProperty.PROPERTY_TYPE_BOOLEAN, new C06652());
        PROPERTY_INITIALIZERS.put(SimpleProperty.PROPERTY_TYPE_COLOR, new C06663());
        PROPERTY_INITIALIZERS.put(SimpleProperty.PROPERTY_TYPE_DOUBLE, new C06674());
        PROPERTY_INITIALIZERS.put(SimpleProperty.PROPERTY_TYPE_HORIZONTAL_ALIGNMENT, new C06685());
        PROPERTY_INITIALIZERS.put(SimpleProperty.PROPERTY_TYPE_INTEGER, new C06696());
        PROPERTY_INITIALIZERS.put(SimpleProperty.PROPERTY_TYPE_LAYOUT, new C06707());
        PROPERTY_INITIALIZERS.put(SimpleProperty.PROPERTY_TYPE_LONG, new C06718());
        PROPERTY_INITIALIZERS.put(SimpleProperty.PROPERTY_TYPE_SINGLE, new C06729());
        PROPERTY_INITIALIZERS.put(SimpleProperty.PROPERTY_TYPE_STRING, new PropertyInitializer() {
            void initializer(Object object, Method m, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
                m.invoke(object, new Object[]{Objects.unquote(value)});
            }
        });
        PROPERTY_INITIALIZERS.put(SimpleProperty.PROPERTY_TYPE_TEXT, new PropertyInitializer() {
            void initializer(Object object, Method m, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
                m.invoke(object, new Object[]{value});
            }
        });
        PROPERTY_INITIALIZERS.put(SimpleProperty.PROPERTY_TYPE_TEXTJUSTIFICATION, new PropertyInitializer() {
            void initializer(Object object, Method m, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
                m.invoke(object, new Object[]{Integer.valueOf(value)});
            }
        });
        PROPERTY_INITIALIZERS.put(SimpleProperty.PROPERTY_TYPE_TYPEFACE, new PropertyInitializer() {
            void initializer(Object object, Method m, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
                m.invoke(object, new Object[]{Integer.valueOf(value)});
            }
        });
        PROPERTY_INITIALIZERS.put(SimpleProperty.PROPERTY_TYPE_VERTICAL_ALIGNMENT, new PropertyInitializer() {
            void initializer(Object object, Method m, String value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
                m.invoke(object, new Object[]{Integer.valueOf(value)});
            }
        });
    }

    public static void initializeProperties(Object object) {
        Class<?> cls = object.getClass();
        List<PropertyDescriptor> pdl = (List) COMPONENT_MAP.get(cls);
        if (pdl == null) {
            pdl = new ArrayList();
            initializeProperties(object, cls, pdl);
            COMPONENT_MAP.put(cls, pdl);
            return;
        }
        for (PropertyDescriptor pd : pdl) {
            pd.runInitializer(object);
        }
    }

    private static void initializeProperties(Object object, Class<?> cls, List<PropertyDescriptor> pdl) {
        Class<?> scls = cls.getSuperclass();
        if (!(scls == null || scls == Object.class)) {
            initializeProperties(object, scls, pdl);
        }
        for (Class<?> iface : cls.getInterfaces()) {
            initializeProperties(object, iface, pdl);
        }
        if (((SimpleObject) cls.getAnnotation(SimpleObject.class)) != null) {
            for (Method m : cls.getDeclaredMethods()) {
                SimpleProperty p = (SimpleProperty) m.getAnnotation(SimpleProperty.class);
                if (p != null) {
                    String initializer = p.initializer();
                    if (initializer.length() != 0) {
                        if (m.getReturnType().equals(Void.TYPE)) {
                            PropertyInitializer pi = (PropertyInitializer) PROPERTY_INITIALIZERS.get(p.type());
                            if (pi == null) {
                                Log.Warning(Log.MODULE_NAME_RTL, "unknown property type: " + p.type());
                            } else {
                                PropertyDescriptor pd = new PropertyDescriptor(pi, m, initializer);
                                pd.runInitializer(object);
                                pdl.add(pd);
                            }
                        } else {
                            Log.Warning(Log.MODULE_NAME_RTL, "ignoring initializer on property getter method: " + cls.getName() + '.' + m.getName());
                        }
                    }
                }
            }
        }
    }

    private static String unquote(String s) {
        return s.substring(1, s.length() - 1);
    }
}
