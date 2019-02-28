package com.umeng.analytics.social;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.cons.C0110c;
import com.umeng.analytics.C1233a;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

public abstract class UMSocialService {

    /* renamed from: com.umeng.analytics.social.UMSocialService$a */
    private static class C1262a extends AsyncTask<Void, Void, C1267d> {
        /* renamed from: a */
        String f5684a;
        /* renamed from: b */
        String f5685b;
        /* renamed from: c */
        C1263b f5686c;
        /* renamed from: d */
        UMPlatformData[] f5687d;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m8463a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m8464a((C1267d) obj);
        }

        public C1262a(String[] strArr, C1263b c1263b, UMPlatformData[] uMPlatformDataArr) {
            this.f5684a = strArr[0];
            this.f5685b = strArr[1];
            this.f5686c = c1263b;
            this.f5687d = uMPlatformDataArr;
        }

        protected void onPreExecute() {
            if (this.f5686c != null) {
                this.f5686c.m8465a();
            }
        }

        /* renamed from: a */
        protected C1267d m8463a(Void... voidArr) {
            String a;
            if (TextUtils.isEmpty(this.f5685b)) {
                a = C1266c.m8480a(this.f5684a);
            } else {
                a = C1266c.m8481a(this.f5684a, this.f5685b);
            }
            try {
                JSONObject jSONObject = new JSONObject(a);
                int optInt = jSONObject.optInt("st");
                C1267d c1267d = new C1267d(optInt == 0 ? C1268e.f5714t : optInt);
                String optString = jSONObject.optString(C0110c.f286b);
                if (!TextUtils.isEmpty(optString)) {
                    c1267d.m8484a(optString);
                }
                Object optString2 = jSONObject.optString("data");
                if (TextUtils.isEmpty(optString2)) {
                    return c1267d;
                }
                c1267d.m8486b(optString2);
                return c1267d;
            } catch (Exception e) {
                return new C1267d(-99, e);
            }
        }

        /* renamed from: a */
        protected void m8464a(C1267d c1267d) {
            if (this.f5686c != null) {
                this.f5686c.m8466a(c1267d, this.f5687d);
            }
        }
    }

    /* renamed from: com.umeng.analytics.social.UMSocialService$b */
    public interface C1263b {
        /* renamed from: a */
        void m8465a();

        /* renamed from: a */
        void m8466a(C1267d c1267d, UMPlatformData... uMPlatformDataArr);
    }

    /* renamed from: a */
    private static void m8467a(Context context, C1263b c1263b, String str, UMPlatformData... uMPlatformDataArr) {
        int i = 0;
        if (uMPlatformDataArr != null) {
            try {
                int length = uMPlatformDataArr.length;
                while (i < length) {
                    if (uMPlatformDataArr[i].isValid()) {
                        i++;
                    } else {
                        throw new C1264a("parameter is not valid.");
                    }
                }
            } catch (Throwable e) {
                Log.e(C1233a.f5589e, "unable send event.", e);
                return;
            } catch (Throwable e2) {
                Log.e(C1233a.f5589e, bi_常量类.f6358b, e2);
                return;
            }
        }
        new C1262a(C1269f.m8493a(context, str, uMPlatformDataArr), c1263b, uMPlatformDataArr).execute(new Void[0]);
    }

    public static void share(Context context, String str, UMPlatformData... uMPlatformDataArr) {
        m8467a(context, null, str, uMPlatformDataArr);
    }

    public static void share(Context context, UMPlatformData... uMPlatformDataArr) {
        m8467a(context, null, null, uMPlatformDataArr);
    }
}
