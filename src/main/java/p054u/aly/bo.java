package p054u.aly;

import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONObject;

/* compiled from: UClient */
/* renamed from: u.aly.bo */
public class bo {
    /* renamed from: a */
    private static final String f5650a = bo.class.getName();
    /* renamed from: b */
    private Map<String, String> f5651b;

    /* renamed from: a */
    public <T extends bq> T m8441a(bp bpVar, Class<T> cls) {
        JSONObject a;
        String trim = bpVar.m8431c().trim();
        m8439b(trim);
        if (bp.f5646c.equals(trim)) {
            a = m8436a(bpVar.mo1919b());
        } else if (bp.f5645b.equals(trim)) {
            a = m8437a(bpVar.f5647d, bpVar.mo1918a());
        } else {
            a = null;
        }
        if (a == null) {
            return null;
        }
        try {
            return (bq) cls.getConstructor(new Class[]{JSONObject.class}).newInstance(new Object[]{a});
        } catch (Exception e) {
            bj.m10003b(f5650a, "SecurityException", e);
            return null;
        } catch (Exception e2) {
            bj.m10003b(f5650a, "NoSuchMethodException", e2);
            return null;
        } catch (Exception e22) {
            bj.m10003b(f5650a, "IllegalArgumentException", e22);
            return null;
        } catch (Exception e222) {
            bj.m10003b(f5650a, "InstantiationException", e222);
            return null;
        } catch (Exception e2222) {
            bj.m10003b(f5650a, "IllegalAccessException", e2222);
            return null;
        } catch (Exception e22222) {
            bj.m10003b(f5650a, "InvocationTargetException", e22222);
            return null;
        }
    }

    /* renamed from: a */
    private JSONObject m8437a(String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        int nextInt = new Random().nextInt(1000);
        bj.m10004c(f5650a, new StringBuilder(String.valueOf(nextInt)).append(":\trequest: ").append(str).append(bv.f6383a).append(jSONObject2).toString());
        Object httpPost = new HttpPost(str);
        HttpClient defaultHttpClient = new DefaultHttpClient(m8438b());
        try {
            if (mo1920a()) {
                byte[] a = bu.m10048a("content=" + jSONObject2, Charset.defaultCharset().toString());
                httpPost.addHeader("Content-Encoding", "deflate");
                httpPost.setEntity(new InputStreamEntity(new ByteArrayInputStream(a), (long) a.length));
            } else {
                List arrayList = new ArrayList(1);
                arrayList.add(new BasicNameValuePair("content", jSONObject2));
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            }
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = execute.getEntity();
                if (entity == null) {
                    return null;
                }
                InputStream inputStream;
                InputStream content = entity.getContent();
                Header firstHeader = execute.getFirstHeader("Content-Encoding");
                if (firstHeader == null || !firstHeader.getValue().equalsIgnoreCase("deflate")) {
                    inputStream = content;
                } else {
                    inputStream = new InflaterInputStream(content);
                }
                String a2 = bo.m8435a(inputStream);
                bj.m10000a(f5650a, new StringBuilder(String.valueOf(nextInt)).append(":\tresponse: ").append(bv.f6383a).append(a2).toString());
                if (a2 == null) {
                    return null;
                }
                return new JSONObject(a2);
            }
            bj.m10004c(f5650a, new StringBuilder(String.valueOf(nextInt)).append(":\tFailed to send message. StatusCode = ").append(execute.getStatusLine().getStatusCode()).append(bv.f6383a).append(str).toString());
            return null;
        } catch (Exception e) {
            bj.m10005c(f5650a, new StringBuilder(String.valueOf(nextInt)).append(":\tClientProtocolException,Failed to send message.").append(str).toString(), e);
            return null;
        } catch (Exception e2) {
            bj.m10005c(f5650a, new StringBuilder(String.valueOf(nextInt)).append(":\tIOException,Failed to send message.").append(str).toString(), e2);
            return null;
        } catch (Exception e22) {
            bj.m10005c(f5650a, new StringBuilder(String.valueOf(nextInt)).append(":\tIOException,Failed to send message.").append(str).toString(), e22);
            return null;
        }
    }

    /* renamed from: a */
    public boolean mo1920a() {
        return false;
    }

    /* renamed from: a */
    private static String m8435a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 8192);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            try {
                stringBuilder.append(new StringBuilder(String.valueOf(readLine)).append("\n").toString());
            } catch (Exception e) {
                stringBuilder = f5650a;
                bj.m10003b(stringBuilder, "Caught IOException in convertStreamToString()", e);
                return null;
            } finally {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    bj.m10003b(f5650a, "Caught IOException in convertStreamToString()", e2);
                    return null;
                }
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private JSONObject m8436a(String str) {
        int nextInt = new Random().nextInt(1000);
        try {
            String property = System.getProperty("line.separator");
            if (str.length() <= 1) {
                bj.m10002b(f5650a, new StringBuilder(String.valueOf(nextInt)).append(":\tInvalid baseUrl.").toString());
                return null;
            }
            bj.m10000a(f5650a, new StringBuilder(String.valueOf(nextInt)).append(":\tget: ").append(str).toString());
            HttpUriRequest httpGet = new HttpGet(str);
            if (this.f5651b != null && this.f5651b.size() > 0) {
                for (String str2 : this.f5651b.keySet()) {
                    httpGet.addHeader(str2, (String) this.f5651b.get(str2));
                }
            }
            HttpResponse execute = new DefaultHttpClient(m8438b()).execute(httpGet);
            if (execute.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = execute.getEntity();
                if (entity != null) {
                    InputStream inflaterInputStream;
                    InputStream content = entity.getContent();
                    Header firstHeader = execute.getFirstHeader("Content-Encoding");
                    if (firstHeader == null || !firstHeader.getValue().equalsIgnoreCase("gzip")) {
                        if (firstHeader != null) {
                            if (firstHeader.getValue().equalsIgnoreCase("deflate")) {
                                bj.m10000a(f5650a, new StringBuilder(String.valueOf(nextInt)).append("  Use InflaterInputStream get data....").toString());
                                inflaterInputStream = new InflaterInputStream(content);
                            }
                        }
                        inflaterInputStream = content;
                    } else {
                        bj.m10000a(f5650a, new StringBuilder(String.valueOf(nextInt)).append("  Use GZIPInputStream get data....").toString());
                        inflaterInputStream = new GZIPInputStream(content);
                    }
                    String a = bo.m8435a(inflaterInputStream);
                    bj.m10000a(f5650a, new StringBuilder(String.valueOf(nextInt)).append(":\tresponse: ").append(property).append(a).toString());
                    if (a == null) {
                        return null;
                    }
                    return new JSONObject(a);
                }
            }
            bj.m10004c(f5650a, new StringBuilder(String.valueOf(nextInt)).append(":\tFailed to send message. StatusCode = ").append(execute.getStatusLine().getStatusCode()).append(bv.f6383a).append(str).toString());
            return null;
        } catch (Exception e) {
            bj.m10005c(f5650a, new StringBuilder(String.valueOf(nextInt)).append(":\tClientProtocolException,Failed to send message.").append(str).toString(), e);
            return null;
        } catch (Exception e2) {
            bj.m10005c(f5650a, new StringBuilder(String.valueOf(nextInt)).append(":\tIOException,Failed to send message.").append(str).toString(), e2);
            return null;
        }
    }

    /* renamed from: b */
    private HttpParams m8438b() {
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
        HttpProtocolParams.setUserAgent(basicHttpParams, System.getProperty("http.agent"));
        return basicHttpParams;
    }

    /* renamed from: a */
    public bo m8440a(Map<String, String> map) {
        this.f5651b = map;
        return this;
    }

    /* renamed from: b */
    private void m8439b(String str) {
        if (bv.m10066d(str) || (bp.f5646c.equals(str.trim()) ^ bp.f5645b.equals(str.trim())) == 0) {
            throw new RuntimeException("验证请求方式失败[" + str + "]");
        }
    }
}
