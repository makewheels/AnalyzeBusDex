package com.ta.utdid2.p039c.p040a;

import android.util.Xml;
import com.ta.utdid2.p039c.p040a.C1025b.C1023a;
import com.ta.utdid2.p039c.p040a.C1025b.C1024b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: TransactionXMLFile */
/* renamed from: com.ta.utdid2.c.a.d */
public final class C1029d {
    /* renamed from: c */
    private static final Object f4736c = new Object();
    /* renamed from: a */
    private final Object f4737a = new Object();
    /* renamed from: b */
    private File f4738b;
    /* renamed from: d */
    private HashMap<File, C1028a> f4739d = new HashMap();

    /* compiled from: TransactionXMLFile */
    /* renamed from: com.ta.utdid2.c.a.d$a */
    private static final class C1028a implements C1025b {
        /* renamed from: f */
        private static final Object f4729f = new Object();
        /* renamed from: a */
        private final File f4730a;
        /* renamed from: b */
        private final File f4731b;
        /* renamed from: c */
        private final int f4732c;
        /* renamed from: d */
        private Map f4733d;
        /* renamed from: e */
        private boolean f4734e = false;
        /* renamed from: g */
        private WeakHashMap<C1024b, Object> f4735g;

        /* compiled from: TransactionXMLFile */
        /* renamed from: com.ta.utdid2.c.a.d$a$a */
        public final class C1027a implements C1023a {
            /* renamed from: a */
            final /* synthetic */ C1028a f4726a;
            /* renamed from: b */
            private final Map<String, Object> f4727b = new HashMap();
            /* renamed from: c */
            private boolean f4728c = false;

            public C1027a(C1028a c1028a) {
                this.f4726a = c1028a;
            }

            /* renamed from: a */
            public final C1023a mo1696a(String str, String str2) {
                synchronized (this) {
                    this.f4727b.put(str, str2);
                }
                return this;
            }

            /* renamed from: a */
            public final C1023a mo1694a(String str, int i) {
                synchronized (this) {
                    this.f4727b.put(str, Integer.valueOf(i));
                }
                return this;
            }

            /* renamed from: a */
            public final C1023a mo1695a(String str, long j) {
                synchronized (this) {
                    this.f4727b.put(str, Long.valueOf(j));
                }
                return this;
            }

            /* renamed from: a */
            public final C1023a mo1693a(String str, float f) {
                synchronized (this) {
                    this.f4727b.put(str, Float.valueOf(f));
                }
                return this;
            }

            /* renamed from: a */
            public final C1023a mo1697a(String str, boolean z) {
                synchronized (this) {
                    this.f4727b.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            /* renamed from: a */
            public final C1023a mo1692a() {
                synchronized (this) {
                    this.f4728c = true;
                }
                return this;
            }

            /* renamed from: b */
            public final boolean mo1698b() {
                boolean c;
                synchronized (C1029d.f4736c) {
                    List list;
                    Object obj = this.f4726a.f4735g.size() > 0 ? 1 : null;
                    Set hashSet;
                    if (obj != null) {
                        ArrayList arrayList = new ArrayList();
                        hashSet = new HashSet(this.f4726a.f4735g.keySet());
                        list = arrayList;
                    } else {
                        hashSet = null;
                        list = null;
                    }
                    synchronized (this) {
                        if (this.f4728c) {
                            this.f4726a.f4733d.clear();
                            this.f4728c = false;
                        }
                        for (Entry entry : this.f4727b.entrySet()) {
                            String str = (String) entry.getKey();
                            C1027a value = entry.getValue();
                            if (value == this) {
                                this.f4726a.f4733d.remove(str);
                            } else {
                                this.f4726a.f4733d.put(str, value);
                            }
                            if (obj != null) {
                                list.add(str);
                            }
                        }
                        this.f4727b.clear();
                    }
                    c = this.f4726a.m7423f();
                    if (c) {
                        this.f4726a.m7430d();
                    }
                }
                if (obj != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        list.get(size);
                        for (C1024b c1024b : r2) {
                            if (c1024b != null) {
                                C1028a c1028a = this.f4726a;
                            }
                        }
                    }
                }
                return c;
            }
        }

        C1028a(File file, Map map) {
            this.f4730a = file;
            this.f4731b = C1029d.m7435b(file);
            this.f4732c = 0;
            if (map == null) {
                map = new HashMap();
            }
            this.f4733d = map;
            this.f4735g = new WeakHashMap();
        }

        /* renamed from: a */
        public final boolean mo1701a() {
            if (this.f4730a == null || !new File(this.f4730a.getAbsolutePath()).exists()) {
                return false;
            }
            return true;
        }

        /* renamed from: d */
        public final void m7430d() {
            synchronized (this) {
                this.f4734e = true;
            }
        }

        /* renamed from: e */
        public final boolean m7431e() {
            boolean z;
            synchronized (this) {
                z = this.f4734e;
            }
            return z;
        }

        /* renamed from: a */
        public final void m7426a(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.f4733d = map;
                }
            }
        }

        /* renamed from: b */
        public final Map<String, ?> mo1702b() {
            Map hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.f4733d);
            }
            return hashMap;
        }

        /* renamed from: a */
        public final String mo1700a(String str, String str2) {
            String str3;
            synchronized (this) {
                str3 = (String) this.f4733d.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
            }
            return str3;
        }

        /* renamed from: a */
        public final long mo1699a(String str) {
            long longValue;
            synchronized (this) {
                Long l = (Long) this.f4733d.get(str);
                longValue = l != null ? l.longValue() : 0;
            }
            return longValue;
        }

        /* renamed from: c */
        public final C1023a mo1703c() {
            return new C1027a(this);
        }

        /* renamed from: a */
        private static FileOutputStream m7419a(File file) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    return new FileOutputStream(file);
                } catch (FileNotFoundException e2) {
                    return null;
                }
            }
        }

        /* renamed from: f */
        private boolean m7423f() {
            if (this.f4730a.exists()) {
                if (this.f4731b.exists()) {
                    this.f4730a.delete();
                } else if (!this.f4730a.renameTo(this.f4731b)) {
                    return false;
                }
            }
            try {
                OutputStream a = C1028a.m7419a(this.f4730a);
                if (a == null) {
                    return false;
                }
                Map map = this.f4733d;
                XmlSerializer c1022a = new C1022a();
                c1022a.setOutput(a, "utf-8");
                c1022a.startDocument(null, Boolean.valueOf(true));
                c1022a.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                C1030e.m7441a(map, null, c1022a);
                c1022a.endDocument();
                a.close();
                this.f4731b.delete();
                return true;
            } catch (XmlPullParserException e) {
                if (this.f4730a.exists()) {
                    return false;
                }
                this.f4730a.delete();
                return false;
            } catch (IOException e2) {
                if (this.f4730a.exists()) {
                    return false;
                }
                this.f4730a.delete();
                return false;
            }
        }
    }

    public C1029d(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.f4738b = new File(str);
    }

    /* renamed from: b */
    private File m7434b() {
        File file;
        synchronized (this.f4737a) {
            file = this.f4738b;
        }
        return file;
    }

    /* renamed from: a */
    public final C1025b m7436a(String str) {
        C1025b c1025b;
        FileInputStream fileInputStream;
        byte[] bArr;
        String str2;
        FileNotFoundException e;
        IOException e2;
        C1028a c1028a;
        Exception e3;
        File b = m7434b();
        String str3 = str + ".xml";
        if (str3.indexOf(File.separatorChar) < 0) {
            File file = new File(b, str3);
            synchronized (f4736c) {
                c1025b = (C1028a) this.f4739d.get(file);
                if (c1025b == null || c1025b.m7431e()) {
                    Map map;
                    File b2 = C1029d.m7435b(file);
                    if (b2.exists()) {
                        file.delete();
                        b2.renameTo(file);
                    }
                    if (file.exists()) {
                        file.canRead();
                    }
                    if (file.exists() && file.canRead()) {
                        try {
                            InputStream fileInputStream2 = new FileInputStream(file);
                            XmlPullParser newPullParser = Xml.newPullParser();
                            newPullParser.setInput(fileInputStream2, null);
                            map = (HashMap) C1030e.m7437a(newPullParser, new String[1]);
                            try {
                                fileInputStream2.close();
                            } catch (XmlPullParserException e4) {
                                try {
                                    fileInputStream = new FileInputStream(file);
                                    bArr = new byte[fileInputStream.available()];
                                    fileInputStream.read(bArr);
                                    str2 = new String(bArr, 0, bArr.length, "UTF-8");
                                } catch (FileNotFoundException e5) {
                                    e5.printStackTrace();
                                } catch (IOException e22) {
                                    e22.printStackTrace();
                                }
                                synchronized (f4736c) {
                                    if (c1025b != null) {
                                        c1028a = (C1028a) this.f4739d.get(file);
                                        if (c1028a == null) {
                                            c1025b = new C1028a(file, map);
                                            this.f4739d.put(file, c1025b);
                                        }
                                    } else {
                                        c1025b.m7426a(map);
                                    }
                                }
                                return c1025b;
                            } catch (FileNotFoundException e6) {
                                e5 = e6;
                                e5.printStackTrace();
                                synchronized (f4736c) {
                                    if (c1025b != null) {
                                        c1025b.m7426a(map);
                                    } else {
                                        c1028a = (C1028a) this.f4739d.get(file);
                                        if (c1028a == null) {
                                            c1025b = new C1028a(file, map);
                                            this.f4739d.put(file, c1025b);
                                        }
                                    }
                                }
                                return c1025b;
                            } catch (IOException e7) {
                                e22 = e7;
                                e22.printStackTrace();
                                synchronized (f4736c) {
                                    if (c1025b != null) {
                                        c1028a = (C1028a) this.f4739d.get(file);
                                        if (c1028a == null) {
                                            c1025b = new C1028a(file, map);
                                            this.f4739d.put(file, c1025b);
                                        }
                                    } else {
                                        c1025b.m7426a(map);
                                    }
                                }
                                return c1025b;
                            } catch (Exception e8) {
                                e3 = e8;
                                e3.printStackTrace();
                                synchronized (f4736c) {
                                    if (c1025b != null) {
                                        c1025b.m7426a(map);
                                    } else {
                                        c1028a = (C1028a) this.f4739d.get(file);
                                        if (c1028a == null) {
                                            c1025b = new C1028a(file, map);
                                            this.f4739d.put(file, c1025b);
                                        }
                                    }
                                }
                                return c1025b;
                            }
                        } catch (XmlPullParserException e9) {
                            map = null;
                            fileInputStream = new FileInputStream(file);
                            bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            str2 = new String(bArr, 0, bArr.length, "UTF-8");
                            synchronized (f4736c) {
                                if (c1025b != null) {
                                    c1028a = (C1028a) this.f4739d.get(file);
                                    if (c1028a == null) {
                                        c1025b = new C1028a(file, map);
                                        this.f4739d.put(file, c1025b);
                                    }
                                } else {
                                    c1025b.m7426a(map);
                                }
                            }
                            return c1025b;
                        } catch (FileNotFoundException e10) {
                            FileNotFoundException fileNotFoundException = e10;
                            map = null;
                            e5 = fileNotFoundException;
                            e5.printStackTrace();
                            synchronized (f4736c) {
                                if (c1025b != null) {
                                    c1025b.m7426a(map);
                                } else {
                                    c1028a = (C1028a) this.f4739d.get(file);
                                    if (c1028a == null) {
                                        c1025b = new C1028a(file, map);
                                        this.f4739d.put(file, c1025b);
                                    }
                                }
                            }
                            return c1025b;
                        } catch (IOException e11) {
                            IOException iOException = e11;
                            map = null;
                            e22 = iOException;
                            e22.printStackTrace();
                            synchronized (f4736c) {
                                if (c1025b != null) {
                                    c1028a = (C1028a) this.f4739d.get(file);
                                    if (c1028a == null) {
                                        c1025b = new C1028a(file, map);
                                        this.f4739d.put(file, c1025b);
                                    }
                                } else {
                                    c1025b.m7426a(map);
                                }
                            }
                            return c1025b;
                        } catch (Exception e12) {
                            Exception exception = e12;
                            map = null;
                            e3 = exception;
                            e3.printStackTrace();
                            synchronized (f4736c) {
                                if (c1025b != null) {
                                    c1025b.m7426a(map);
                                } else {
                                    c1028a = (C1028a) this.f4739d.get(file);
                                    if (c1028a == null) {
                                        c1025b = new C1028a(file, map);
                                        this.f4739d.put(file, c1025b);
                                    }
                                }
                            }
                            return c1025b;
                        }
                    }
                    map = null;
                    synchronized (f4736c) {
                        if (c1025b != null) {
                            c1025b.m7426a(map);
                        } else {
                            c1028a = (C1028a) this.f4739d.get(file);
                            if (c1028a == null) {
                                c1025b = new C1028a(file, map);
                                this.f4739d.put(file, c1025b);
                            }
                        }
                    }
                }
            }
            return c1025b;
        }
        throw new IllegalArgumentException("File " + str3 + " contains a path separator");
    }

    /* renamed from: b */
    private static File m7435b(File file) {
        return new File(file.getPath() + ".bak");
    }
}
