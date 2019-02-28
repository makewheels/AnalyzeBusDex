package p054u.aly;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: UError */
/* renamed from: u.aly.ac */
public class ac extends am implements C1275p {
    public ac() {
        m8586a(System.currentTimeMillis());
        m8588a(an.LEGIT);
    }

    public ac(String str) {
        this();
        m8587a(str);
    }

    public ac(Throwable th) {
        this();
        m8587a(m8607a(th));
    }

    /* renamed from: a */
    public ac m8608a(boolean z) {
        m8588a(z ? an.LEGIT : an.ALIEN);
        return this;
    }

    /* renamed from: a */
    private String m8607a(Throwable th) {
        String str = null;
        if (th != null) {
            try {
                Writer stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                    cause.printStackTrace(printWriter);
                }
                str = stringWriter.toString();
                printWriter.close();
                stringWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    /* renamed from: a */
    public void mo1926a(bf bfVar, String str) {
        if (bfVar.m9822s() > 0) {
            for (av avVar : bfVar.m9824u()) {
                if (str.equals(avVar.m9360c())) {
                    break;
                }
            }
        }
        av avVar2 = null;
        if (avVar2 == null) {
            avVar2 = new av();
            avVar2.m9348a(str);
            bfVar.m9790a(avVar2);
        }
        avVar2.m9350a((am) this);
    }
}
