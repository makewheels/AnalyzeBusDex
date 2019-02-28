package com.ta.utdid2.p039c.p040a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: FastXmlSerializer */
/* renamed from: com.ta.utdid2.c.a.a */
final class C1022a implements XmlSerializer {
    /* renamed from: a */
    private static final String[] f4706a = new String[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};
    /* renamed from: b */
    private final char[] f4707b = new char[8192];
    /* renamed from: c */
    private int f4708c;
    /* renamed from: d */
    private Writer f4709d;
    /* renamed from: e */
    private OutputStream f4710e;
    /* renamed from: f */
    private CharsetEncoder f4711f;
    /* renamed from: g */
    private ByteBuffer f4712g = ByteBuffer.allocate(8192);
    /* renamed from: h */
    private boolean f4713h;

    C1022a() {
    }

    /* renamed from: a */
    private void m7387a(char c) throws IOException {
        int i = this.f4708c;
        if (i >= 8191) {
            flush();
            i = this.f4708c;
        }
        this.f4707b[i] = c;
        this.f4708c = i + 1;
    }

    /* renamed from: a */
    private void m7389a(String str, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i + i2;
            while (i < i3) {
                int i4 = i + 8192;
                m7389a(str, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f4708c;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.f4708c;
        }
        str.getChars(i, i + i2, this.f4707b, i5);
        this.f4708c = i5 + i2;
    }

    /* renamed from: a */
    private void m7390a(char[] cArr, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i + i2;
            while (i < i3) {
                int i4 = i + 8192;
                m7390a(cArr, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f4708c;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.f4708c;
        }
        System.arraycopy(cArr, i, this.f4707b, i5, i2);
        this.f4708c = i5 + i2;
    }

    /* renamed from: a */
    private void m7388a(String str) throws IOException {
        m7389a(str, 0, str.length());
    }

    /* renamed from: b */
    private void m7391b(String str) throws IOException {
        int i = 0;
        int length = str.length();
        char length2 = (char) f4706a.length;
        String[] strArr = f4706a;
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt < length2) {
                String str2 = strArr[charAt];
                if (str2 != null) {
                    if (i < i2) {
                        m7389a(str, i, i2 - i);
                    }
                    i = i2 + 1;
                    m7388a(str2);
                }
            }
            i2++;
        }
        if (i < i2) {
            m7389a(str, i, i2 - i);
        }
    }

    public final XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        m7387a(' ');
        if (str != null) {
            m7388a(str);
            m7387a(':');
        }
        m7388a(str2);
        m7388a("=\"");
        m7391b(str3);
        m7387a('\"');
        return this;
    }

    public final void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    public final XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f4713h) {
            m7388a(" />\n");
        } else {
            m7388a("</");
            if (str != null) {
                m7388a(str);
                m7387a(':');
            }
            m7388a(str2);
            m7388a(">\n");
        }
        this.f4713h = false;
        return this;
    }

    public final void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    private void m7386a() throws IOException {
        int position = this.f4712g.position();
        if (position > 0) {
            this.f4712g.flip();
            this.f4710e.write(this.f4712g.array(), 0, position);
            this.f4712g.clear();
        }
    }

    public final void flush() throws IOException {
        if (this.f4708c > 0) {
            if (this.f4710e != null) {
                CharBuffer wrap = CharBuffer.wrap(this.f4707b, 0, this.f4708c);
                CoderResult encode = this.f4711f.encode(wrap, this.f4712g, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        m7386a();
                        encode = this.f4711f.encode(wrap, this.f4712g, true);
                    } else {
                        m7386a();
                        this.f4710e.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.f4709d.write(this.f4707b, 0, this.f4708c);
            this.f4709d.flush();
            this.f4708c = 0;
        }
    }

    public final int getDepth() {
        throw new UnsupportedOperationException();
    }

    public final boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    public final String getName() {
        throw new UnsupportedOperationException();
    }

    public final String getNamespace() {
        throw new UnsupportedOperationException();
    }

    public final String getPrefix(String str, boolean z) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public final Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    public final void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void setFeature(String str, boolean z) throws IllegalArgumentException, IllegalStateException {
        if (!str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            throw new UnsupportedOperationException();
        }
    }

    public final void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (outputStream == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.f4711f = Charset.forName(str).newEncoder();
            this.f4710e = outputStream;
        } catch (Throwable e) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e));
        } catch (Throwable e2) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
        }
    }

    public final void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.f4709d = writer;
    }

    public final void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        m7388a("<?xml version='1.0' encoding='utf-8' standalone='" + (bool.booleanValue() ? "yes" : "no") + "' ?>\n");
    }

    public final XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f4713h) {
            m7388a(">\n");
        }
        m7387a('<');
        if (str != null) {
            m7388a(str);
            m7387a(':');
        }
        m7388a(str2);
        this.f4713h = true;
        return this;
    }

    public final XmlSerializer text(char[] cArr, int i, int i2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f4713h) {
            m7388a(">");
            this.f4713h = false;
        }
        char length = (char) f4706a.length;
        String[] strArr = f4706a;
        int i3 = i + i2;
        int i4 = i;
        while (i < i3) {
            char c = cArr[i];
            if (c < length) {
                String str = strArr[c];
                if (str != null) {
                    if (i4 < i) {
                        m7390a(cArr, i4, i - i4);
                    }
                    i4 = i + 1;
                    m7388a(str);
                }
            }
            i++;
        }
        if (i4 < i) {
            m7390a(cArr, i4, i - i4);
        }
        return this;
    }

    public final XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f4713h) {
            m7388a(">");
            this.f4713h = false;
        }
        m7391b(str);
        return this;
    }
}
