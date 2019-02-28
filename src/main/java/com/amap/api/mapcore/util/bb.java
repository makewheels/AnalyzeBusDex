package com.amap.api.mapcore.util;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import p054u.aly.bi_常量类;

/* compiled from: ANRLogWriter */
class bb extends bj {
    /* renamed from: a */
    private String[] f2017a = new String[10];
    /* renamed from: b */
    private int f2018b = 0;
    /* renamed from: c */
    private boolean f2019c = false;
    /* renamed from: d */
    private int f2020d = 0;
    /* renamed from: e */
    private C0362a f2021e;

    /* compiled from: ANRLogWriter */
    /* renamed from: com.amap.api.mapcore.util.bb$a */
    private class C0362a implements bo {
        /* renamed from: a */
        final /* synthetic */ bb f2014a;
        /* renamed from: b */
        private al f2015b;

        private C0362a(bb bbVar, al alVar) {
            this.f2014a = bbVar;
            this.f2015b = alVar;
        }

        /* renamed from: a */
        public void mo599a(String str) {
            try {
                this.f2015b.m3089b(str, this.f2014a.mo600a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    bb() {
    }

    /* renamed from: a */
    protected int mo600a() {
        return 2;
    }

    /* renamed from: b */
    protected String mo604b() {
        return bg.f2039d;
    }

    /* renamed from: a */
    protected String mo602a(String str) {
        return ab.m3012b(str);
    }

    /* renamed from: a */
    protected bo mo601a(al alVar) {
        try {
            if (this.f2021e == null) {
                this.f2021e = new C0362a(alVar);
            }
        } catch (Throwable th) {
            az.m3143a(th, "ANRWriter", "getListener");
            th.printStackTrace();
        }
        return this.f2021e;
    }

    /* renamed from: a */
    protected String mo603a(List<ad> list) {
        InputStream fileInputStream;
        bp bpVar;
        InputStream inputStream;
        Throwable e;
        IOException iOException;
        InputStream inputStream2 = null;
        bp bpVar2 = null;
        try {
            File file = new File("/data/anr/traces.txt");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    bpVar2 = new bp(fileInputStream, bq.f2082a);
                    Object obj = null;
                    while (true) {
                        try {
                            String str;
                            Object obj2;
                            String a = bpVar2.m3279a();
                            if (a.contains("pid")) {
                                while (!a.contains("\"main\"")) {
                                    a = bpVar2.m3279a();
                                }
                                str = a;
                                obj2 = 1;
                            } else {
                                str = a;
                                obj2 = obj;
                            }
                            if (str.equals(bi_常量类.f6358b_空串)) {
                                obj = null;
                            } else {
                                obj = obj2;
                            }
                            if (obj != null) {
                                m3191b(str);
                                if (this.f2020d == 5) {
                                    break;
                                } else if (this.f2019c) {
                                    this.f2020d++;
                                } else {
                                    for (ad adVar : list) {
                                        this.f2019c = m3189a(adVar.m3038f(), str);
                                        if (this.f2019c) {
                                            m3188a(adVar);
                                        }
                                    }
                                }
                            }
                        } catch (EOFException e2) {
                        } catch (FileNotFoundException e3) {
                            bpVar = bpVar2;
                            inputStream = fileInputStream;
                        } catch (IOException e4) {
                            e = e4;
                        }
                    }
                    if (bpVar2 != null) {
                        try {
                            bpVar2.close();
                        } catch (Throwable e5) {
                            az.m3143a(e5, "ANRWriter", "initLog1");
                            e5.printStackTrace();
                        } catch (Throwable e52) {
                            az.m3143a(e52, "ANRWriter", "initLog2");
                            e52.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            e52 = e6;
                            az.m3143a(e52, "ANRWriter", "initLog3");
                            iOException.printStackTrace();
                            if (this.f2019c) {
                                return null;
                            }
                            return m3192c();
                        } catch (Throwable th) {
                            e52 = th;
                            az.m3143a(e52, "ANRWriter", "initLog4");
                            e52.printStackTrace();
                            if (this.f2019c) {
                                return m3192c();
                            }
                            return null;
                        }
                    }
                } catch (FileNotFoundException e7) {
                    bpVar = null;
                    inputStream = fileInputStream;
                    if (bpVar != null) {
                        try {
                            bpVar.close();
                        } catch (Throwable e522) {
                            az.m3143a(e522, "ANRWriter", "initLog1");
                            e522.printStackTrace();
                        } catch (Throwable e5222) {
                            az.m3143a(e5222, "ANRWriter", "initLog2");
                            e5222.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e8) {
                            iOException = e8;
                            az.m3143a((Throwable) iOException, "ANRWriter", "initLog3");
                            iOException.printStackTrace();
                            if (this.f2019c) {
                                return null;
                            }
                            return m3192c();
                        } catch (Throwable th2) {
                            e5222 = th2;
                            az.m3143a(e5222, "ANRWriter", "initLog4");
                            e5222.printStackTrace();
                            if (this.f2019c) {
                                return m3192c();
                            }
                            return null;
                        }
                    }
                    if (this.f2019c) {
                        return null;
                    }
                    return m3192c();
                } catch (IOException e9) {
                    e5222 = e9;
                    bpVar2 = null;
                    try {
                        az.m3143a(e5222, "ANRWriter", "initLog");
                        e5222.printStackTrace();
                        if (bpVar2 != null) {
                            try {
                                bpVar2.close();
                            } catch (Throwable e52222) {
                                az.m3143a(e52222, "ANRWriter", "initLog1");
                                e52222.printStackTrace();
                            } catch (Throwable e522222) {
                                az.m3143a(e522222, "ANRWriter", "initLog2");
                                e522222.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e10) {
                                e522222 = e10;
                                az.m3143a(e522222, "ANRWriter", "initLog3");
                                iOException.printStackTrace();
                                if (this.f2019c) {
                                    return null;
                                }
                                return m3192c();
                            } catch (Throwable th3) {
                                e522222 = th3;
                                az.m3143a(e522222, "ANRWriter", "initLog4");
                                e522222.printStackTrace();
                                if (this.f2019c) {
                                    return m3192c();
                                }
                                return null;
                            }
                        }
                        if (this.f2019c) {
                            return m3192c();
                        }
                        return null;
                    } catch (Throwable th4) {
                        e522222 = th4;
                        if (bpVar2 != null) {
                            try {
                                bpVar2.close();
                            } catch (Throwable e11) {
                                az.m3143a(e11, "ANRWriter", "initLog1");
                                e11.printStackTrace();
                            } catch (Throwable e112) {
                                az.m3143a(e112, "ANRWriter", "initLog2");
                                e112.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e1122) {
                                az.m3143a(e1122, "ANRWriter", "initLog3");
                                e1122.printStackTrace();
                            } catch (Throwable e11222) {
                                az.m3143a(e11222, "ANRWriter", "initLog4");
                                e11222.printStackTrace();
                            }
                        }
                        throw e522222;
                    }
                } catch (Throwable th5) {
                    e522222 = th5;
                    bpVar2 = null;
                    if (bpVar2 != null) {
                        bpVar2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e522222;
                }
                if (this.f2019c) {
                    return m3192c();
                }
                return null;
            }
            if (null != null) {
                try {
                    bpVar2.close();
                } catch (Throwable e12) {
                    az.m3143a(e12, "ANRWriter", "initLog1");
                    e12.printStackTrace();
                } catch (Throwable e122) {
                    az.m3143a(e122, "ANRWriter", "initLog2");
                    e122.printStackTrace();
                }
            }
            if (null != null) {
                try {
                    inputStream2.close();
                } catch (Throwable e5222222) {
                    az.m3143a(e5222222, "ANRWriter", "initLog3");
                    e5222222.printStackTrace();
                } catch (Throwable e52222222) {
                    az.m3143a(e52222222, "ANRWriter", "initLog4");
                    e52222222.printStackTrace();
                }
            }
            return null;
        } catch (FileNotFoundException e13) {
            bpVar = null;
            inputStream = null;
            if (bpVar != null) {
                bpVar.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (this.f2019c) {
                return null;
            }
            return m3192c();
        } catch (IOException e14) {
            e52222222 = e14;
            bpVar2 = null;
            fileInputStream = null;
            az.m3143a(e52222222, "ANRWriter", "initLog");
            e52222222.printStackTrace();
            if (bpVar2 != null) {
                bpVar2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (this.f2019c) {
                return m3192c();
            }
            return null;
        } catch (Throwable th6) {
            e52222222 = th6;
            bpVar2 = null;
            fileInputStream = null;
            if (bpVar2 != null) {
                bpVar2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e52222222;
        }
    }

    /* renamed from: c */
    private String m3192c() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int i = this.f2018b;
            while (i < 10 && i <= 9) {
                stringBuilder.append(this.f2017a[i]);
                i++;
            }
            for (i = 0; i < this.f2018b; i++) {
                stringBuilder.append(this.f2017a[i]);
            }
        } catch (Throwable th) {
            az.m3143a(th, "ANRWriter", "getLogInfo");
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private void m3191b(String str) {
        try {
            if (this.f2018b > 9) {
                this.f2018b = 0;
            }
            this.f2017a[this.f2018b] = str;
            this.f2018b++;
        } catch (Throwable th) {
            az.m3143a(th, "ANRWriter", "addData");
            th.printStackTrace();
        }
    }
}
