package com.e4a.runtime.events;

import com.e4a.runtime.errors.RuntimeError;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDispatcher {
    private static Map<String, List<EventHandlerClosure>> registry = new HashMap();

    private static final class EventHandlerClosure {
        private Field dataMember;
        private Method eventHandler;
        private final Object object;

        EventHandlerClosure(Object object, String dataMemberName, String eventName) {
            this.object = object;
            Class<?> cls = object.getClass();
            for (Method method : cls.getMethods()) {
                if (method.getName().equals(dataMemberName + '$' + eventName)) {
                    this.eventHandler = method;
                    break;
                }
            }
            try {
                this.dataMember = cls.getField(dataMemberName);
            } catch (NoSuchFieldException e) {
            }
        }

        Object getDataMemberObject() {
            Object obj = null;
            if (this.dataMember != null) {
                try {
                    obj = this.dataMember.get(this.object);
                } catch (IllegalAccessException e) {
                }
            }
            return obj;
        }

        void invokeEvent(Object... args) {
            try {
                this.eventHandler.invoke(this.object, args);
            } catch (Throwable t) {
                RuntimeError.convertToRuntimeError(t);
            }
        }
    }

    private EventDispatcher() {
    }

    public static void registerEvent(Object object, String dataMemberName, String eventName) {
        List<EventHandlerClosure> closures = (List) registry.get(eventName);
        if (closures == null) {
            closures = new ArrayList();
            registry.put(eventName, closures);
        }
        closures.add(new EventHandlerClosure(object, dataMemberName, eventName));
    }

    public static synchronized void dispatchEvent(Object that, String eventName, Object... args) {
        synchronized (EventDispatcher.class) {
            List<EventHandlerClosure> closures = (List) registry.get(eventName);
            if (closures != null) {
                for (EventHandlerClosure closure : (EventHandlerClosure[]) closures.toArray(new EventHandlerClosure[closures.size()])) {
                    if (closure.getDataMemberObject() == that) {
                        closure.invokeEvent(args);
                    }
                }
            }
        }
    }
}
