package p054u.aly;

import android.os.AsyncTask;
import p054u.aly.bn.C1419a;

/* compiled from: ReportClient */
/* renamed from: u.aly.bl */
public class bl extends bo {
    /* renamed from: a */
    private static final String f6377a = bl.class.getName();

    /* compiled from: ReportClient */
    /* renamed from: u.aly.bl$a */
    public interface C1417a {
        /* renamed from: a */
        void m10019a();

        /* renamed from: a */
        void m10020a(C1419a c1419a);
    }

    /* compiled from: ReportClient */
    /* renamed from: u.aly.bl$b */
    private class C1418b extends AsyncTask<Integer, Integer, C1419a> {
        /* renamed from: a */
        final /* synthetic */ bl f6374a;
        /* renamed from: b */
        private bm f6375b;
        /* renamed from: c */
        private C1417a f6376c;

        protected /* synthetic */ Object doInBackground(Object... objArr) {
            return m10021a((Integer[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m10022a((C1419a) obj);
        }

        public C1418b(bl blVar, bm bmVar, C1417a c1417a) {
            this.f6374a = blVar;
            this.f6375b = bmVar;
            this.f6376c = c1417a;
        }

        protected void onPreExecute() {
            if (this.f6376c != null) {
                this.f6376c.m10019a();
            }
        }

        /* renamed from: a */
        protected void m10022a(C1419a c1419a) {
            if (this.f6376c != null) {
                this.f6376c.m10020a(c1419a);
            }
        }

        /* renamed from: a */
        protected C1419a m10021a(Integer... numArr) {
            return this.f6374a.m10023a(this.f6375b);
        }
    }

    /* renamed from: a */
    public C1419a m10023a(bm bmVar) {
        bn bnVar = (bn) m8441a((bp) bmVar, bn.class);
        return bnVar == null ? C1419a.FAIL : bnVar.f6381a;
    }

    /* renamed from: a */
    public void m10024a(bm bmVar, C1417a c1417a) {
        try {
            new C1418b(this, bmVar, c1417a).execute(new Integer[0]);
        } catch (Exception e) {
            bj.m10003b(f6377a, bi_常量类.f6358b, e);
            if (c1417a != null) {
                c1417a.m10020a(C1419a.FAIL);
            }
        }
    }
}
