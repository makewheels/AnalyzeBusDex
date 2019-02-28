package p054u.aly;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: TBaseHelper */
/* renamed from: u.aly.ca */
public final class ca {
    /* renamed from: a */
    private static final Comparator f6412a = new C1422a();

    /* compiled from: TBaseHelper */
    /* renamed from: u.aly.ca$a */
    private static class C1422a implements Comparator {
        private C1422a() {
        }

        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            if (obj instanceof List) {
                return ca.m10112a((List) obj, (List) obj2);
            }
            if (obj instanceof Set) {
                return ca.m10114a((Set) obj, (Set) obj2);
            }
            if (obj instanceof Map) {
                return ca.m10113a((Map) obj, (Map) obj2);
            }
            if (obj instanceof byte[]) {
                return ca.m10117a((byte[]) obj, (byte[]) obj2);
            }
            return ca.m10108a((Comparable) obj, (Comparable) obj2);
        }
    }

    private ca() {
    }

    /* renamed from: a */
    public static int m10109a(Object obj, Object obj2) {
        if (obj instanceof Comparable) {
            return ca.m10108a((Comparable) obj, (Comparable) obj2);
        }
        if (obj instanceof List) {
            return ca.m10112a((List) obj, (List) obj2);
        }
        if (obj instanceof Set) {
            return ca.m10114a((Set) obj, (Set) obj2);
        }
        if (obj instanceof Map) {
            return ca.m10113a((Map) obj, (Map) obj2);
        }
        if (obj instanceof byte[]) {
            return ca.m10117a((byte[]) obj, (byte[]) obj2);
        }
        throw new IllegalArgumentException("Cannot compare objects of type " + obj.getClass());
    }

    /* renamed from: a */
    public static int m10116a(boolean z, boolean z2) {
        return Boolean.valueOf(z).compareTo(Boolean.valueOf(z2));
    }

    /* renamed from: a */
    public static int m10104a(byte b, byte b2) {
        if (b < b2) {
            return -1;
        }
        if (b2 < b) {
            return 1;
        }
        return 0;
    }

    /* renamed from: a */
    public static int m10115a(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        if (s2 < s) {
            return 1;
        }
        return 0;
    }

    /* renamed from: a */
    public static int m10106a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        if (i2 < i) {
            return 1;
        }
        return 0;
    }

    /* renamed from: a */
    public static int m10107a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        if (j2 < j) {
            return 1;
        }
        return 0;
    }

    /* renamed from: a */
    public static int m10105a(double d, double d2) {
        if (d < d2) {
            return -1;
        }
        if (d2 < d) {
            return 1;
        }
        return 0;
    }

    /* renamed from: a */
    public static int m10110a(String str, String str2) {
        return str.compareTo(str2);
    }

    /* renamed from: a */
    public static int m10117a(byte[] bArr, byte[] bArr2) {
        int a = ca.m10106a(bArr.length, bArr2.length);
        if (a != 0) {
            return a;
        }
        for (a = 0; a < bArr.length; a++) {
            int a2 = ca.m10104a(bArr[a], bArr2[a]);
            if (a2 != 0) {
                return a2;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m10108a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* renamed from: a */
    public static int m10112a(List list, List list2) {
        int a = ca.m10106a(list.size(), list2.size());
        if (a != 0) {
            return a;
        }
        for (a = 0; a < list.size(); a++) {
            int compare = f6412a.compare(list.get(a), list2.get(a));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m10114a(Set set, Set set2) {
        int a = ca.m10106a(set.size(), set2.size());
        if (a != 0) {
            return a;
        }
        SortedSet treeSet = new TreeSet(f6412a);
        treeSet.addAll(set);
        SortedSet treeSet2 = new TreeSet(f6412a);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            a = f6412a.compare(it.next(), it2.next());
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m10113a(Map map, Map map2) {
        int a = ca.m10106a(map.size(), map2.size());
        if (a != 0) {
            return a;
        }
        SortedMap treeMap = new TreeMap(f6412a);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        treeMap = new TreeMap(f6412a);
        treeMap.putAll(map2);
        Iterator it2 = treeMap.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Entry entry2 = (Entry) it2.next();
            int compare = f6412a.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            a = f6412a.compare(entry.getValue(), entry2.getValue());
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static void m10119a(ByteBuffer byteBuffer, StringBuilder stringBuilder) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int position = arrayOffset + byteBuffer.position();
        int limit = byteBuffer.limit() + arrayOffset;
        if (limit - position > 128) {
            arrayOffset = position + 128;
        } else {
            arrayOffset = limit;
        }
        for (int i = position; i < arrayOffset; i++) {
            if (i > position) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(ca.m10118a(array[i]));
        }
        if (limit != arrayOffset) {
            stringBuilder.append("...");
        }
    }

    /* renamed from: a */
    public static String m10118a(byte b) {
        return Integer.toHexString((b | 256) & 511).toUpperCase().substring(1);
    }

    /* renamed from: a */
    public static byte[] m10120a(ByteBuffer byteBuffer) {
        if (ca.m10122b(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        ca.m10111a(byteBuffer, bArr, 0);
        return bArr;
    }

    /* renamed from: b */
    public static boolean m10122b(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    /* renamed from: a */
    public static int m10111a(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int remaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, i, remaining);
        return remaining;
    }

    /* renamed from: c */
    public static ByteBuffer m10123c(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        return !ca.m10122b(byteBuffer) ? ByteBuffer.wrap(ca.m10120a(byteBuffer)) : byteBuffer;
    }

    /* renamed from: d */
    public static ByteBuffer m10124d(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(new byte[byteBuffer.remaining()]);
        if (byteBuffer.hasArray()) {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), wrap.array(), 0, byteBuffer.remaining());
            return wrap;
        }
        byteBuffer.slice().get(wrap.array());
        return wrap;
    }

    /* renamed from: a */
    public static byte[] m10121a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
