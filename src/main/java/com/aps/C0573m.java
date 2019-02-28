package com.aps;

import com.amap.api.location.LocationManagerProxy;
import com.amap.api.services.district.DistrictSearchQuery;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.SAXParserFactory;
import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import p054u.aly.bi_常量类;

/* compiled from: Parser */
/* renamed from: com.aps.m */
public class C0573m {

    /* compiled from: Parser */
    /* renamed from: com.aps.m$a */
    private static class C0571a extends DefaultHandler {
        /* renamed from: a */
        public C0556c f3508a;
        /* renamed from: b */
        private String f3509b;

        private C0571a() {
            this.f3508a = new C0556c();
            this.f3509b = bi_常量类.f6358b_空串;
        }

        public void characters(char[] cArr, int i, int i2) {
            this.f3509b = String.valueOf(cArr, i, i2);
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            this.f3509b = bi_常量类.f6358b_空串;
        }

        public void endElement(String str, String str2, String str3) {
            if (str2.equals("retype")) {
                this.f3508a.m4443e(this.f3509b);
            } else if (str2.equals("adcode")) {
                this.f3508a.m4449h(this.f3509b);
            } else if (str2.equals("citycode")) {
                this.f3508a.m4445f(this.f3509b);
            } else if (str2.equals("radius")) {
                try {
                    this.f3508a.m4430a(Float.valueOf(this.f3509b).floatValue());
                } catch (Throwable th) {
                    th.printStackTrace();
                    C0583t.m4574a(th);
                    this.f3508a.m4430a(3891.0f);
                }
            } else if (str2.equals("cenx")) {
                try {
                    this.f3509b = C0579q.m4558a(Double.valueOf(this.f3509b), "#.000000");
                    this.f3508a.m4429a(Double.valueOf(this.f3509b).doubleValue());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    C0583t.m4574a(th2);
                    this.f3508a.m4429a(0.0d);
                }
            } else if (str2.equals("ceny")) {
                try {
                    this.f3509b = C0579q.m4558a(Double.valueOf(this.f3509b), "#.000000");
                    this.f3508a.m4436b(Double.valueOf(this.f3509b).doubleValue());
                } catch (Throwable th22) {
                    th22.printStackTrace();
                    C0583t.m4574a(th22);
                    this.f3508a.m4436b(0.0d);
                }
            } else if (str2.equals("desc")) {
                this.f3508a.m4447g(this.f3509b);
            } else if (str2.equals(DistrictSearchQuery.KEYWORDS_COUNTRY)) {
                this.f3508a.m4451i(this.f3509b);
            } else if (str2.equals(DistrictSearchQuery.KEYWORDS_PROVINCE)) {
                this.f3508a.m4453j(this.f3509b);
            } else if (str2.equals(DistrictSearchQuery.KEYWORDS_CITY)) {
                this.f3508a.m4455k(this.f3509b);
            } else if (str2.equals("road")) {
                this.f3508a.m4457l(this.f3509b);
            } else if (str2.equals("street")) {
                this.f3508a.m4459m(this.f3509b);
            } else if (str2.equals("poiname")) {
                this.f3508a.m4461n(this.f3509b);
            } else if (str2.equals("BIZ")) {
                if (this.f3508a.m4458m() == null) {
                    this.f3508a.m4434a(new JSONObject());
                }
                try {
                    this.f3508a.m4458m().put("BIZ", this.f3509b);
                } catch (Throwable th222) {
                    th222.printStackTrace();
                }
            } else if (str2.equals("flr")) {
                this.f3508a.m4437b(this.f3509b);
            } else if (str2.equals("pid")) {
                this.f3508a.m4433a(this.f3509b);
            } else if (str2.equals("apiTime")) {
                try {
                    if (!bi_常量类.f6358b_空串.equals(this.f3509b)) {
                        this.f3508a.m4431a(Long.parseLong(this.f3509b));
                    }
                } catch (Throwable th2222) {
                    th2222.printStackTrace();
                    C0583t.m4574a(th2222);
                    this.f3508a.m4431a(C0583t.m4572a());
                }
            }
            if (this.f3508a.m4458m() == null) {
                this.f3508a.m4434a(new JSONObject());
            }
            try {
                if (str2.equals("eab")) {
                    this.f3508a.m4458m().put(str2, this.f3509b);
                } else if (str2.equals("ctl")) {
                    this.f3508a.m4458m().put(str2, this.f3509b);
                } else if (str2.equals("suc")) {
                    this.f3508a.m4458m().put(str2, this.f3509b);
                } else if (str2.equals("spa")) {
                    this.f3508a.m4458m().put(str2, this.f3509b);
                }
            } catch (Throwable th22222) {
                th22222.printStackTrace();
            }
        }
    }

    /* compiled from: Parser */
    /* renamed from: com.aps.m$b */
    private static class C0572b extends DefaultHandler {
        /* renamed from: a */
        public String f3510a;
        /* renamed from: b */
        private boolean f3511b;

        private C0572b() {
            this.f3510a = bi_常量类.f6358b_空串;
            this.f3511b = false;
        }

        public void characters(char[] cArr, int i, int i2) {
            if (this.f3511b) {
                this.f3510a = String.valueOf(cArr, i, i2);
            }
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str2.equals("sres")) {
                this.f3511b = true;
            }
        }

        public void endElement(String str, String str2, String str3) {
            if (str2.equals("sres")) {
                this.f3511b = false;
            }
        }
    }

    protected C0573m() {
    }

    /* renamed from: a */
    String m4543a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        InputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            byteArrayInputStream = null;
        }
        DefaultHandler c0572b = new C0572b();
        if (byteArrayInputStream != null) {
            try {
                SAXParserFactory.newInstance().newSAXParser().parse(byteArrayInputStream, c0572b);
                byteArrayInputStream.close();
            } catch (SAXException e2) {
            } catch (Throwable th) {
                th.printStackTrace();
                C0583t.m4574a(th);
            }
        }
        return c0572b.f3510a;
    }

    /* renamed from: b */
    C0556c m4544b(String str) {
        if (str == null || str.length() == 0 || str.contains("SuccessCode=\"0\"")) {
            return null;
        }
        InputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            byteArrayInputStream = null;
        }
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        DefaultHandler c0571a = new C0571a();
        if (byteArrayInputStream != null) {
            try {
                newInstance.newSAXParser().parse(byteArrayInputStream, c0571a);
                byteArrayInputStream.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        c0571a.f3508a.m4439c(LocationManagerProxy.NETWORK_PROVIDER);
        if (c0571a.f3508a.m4446g() == 0) {
            c0571a.f3508a.m4431a(C0583t.m4572a());
        }
        return c0571a.f3508a;
    }
}
