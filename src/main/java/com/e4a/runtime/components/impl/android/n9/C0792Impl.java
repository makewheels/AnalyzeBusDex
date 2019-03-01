package com.e4a.runtime.components.impl.android.n9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.provider.CallLog.Calls;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.view.KeyEvent;
import com.alipay.sdk.cons.C0110c;
import com.e4a.runtime.C0841;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.collections.C0683_集合类;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.ComponentImpl;
import com.e4a.runtime.events.EventDispatcher;
import com.e4a.runtime.variants.ArrayVariant;
import com.tencent.smtt.sdk.WebView;
import com.umeng.analytics.onlineconfig.C1248a;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.n9.手机Impl */
public class C0792Impl extends ComponentImpl implements C0790 {
    private BroadcastReceiver mReceiver2;

    /* renamed from: com.e4a.runtime.components.impl.android.n9.手机Impl$1 */
    class C07911 extends BroadcastReceiver {
        C07911() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                C0792Impl.this.mo1412(intent.getIntExtra("status", 0), intent.getIntExtra("level", 0), intent.getIntExtra("temperature", 0));
            } else if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
                C0792Impl.this.mo1414(C0792Impl.this.mReceiver2.getResultData());
            }
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n9.手机Impl$MyPhoneStateListener */
    public class MyPhoneStateListener extends PhoneStateListener {
        public void onCallStateChanged(int state, String phoneNumber) {
            switch (state) {
                case 0:
                    C0792Impl.this.mo1415(phoneNumber);
                    return;
                case 1:
                    C0792Impl.this.mo1413(phoneNumber);
                    return;
                case 2:
                    C0792Impl.this.mo1416(phoneNumber);
                    return;
                default:
                    return;
            }
        }
    }

    public C0792Impl(ComponentContainer container) {
        super(container);
        m6462();
        m6461();
    }

    /* renamed from: 监听电池状态 */
    public void m6462() {
        this.mReceiver2 = new C07911();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.BATTERY_CHANGED");
        filter.addAction("android.intent.action.NEW_OUTGOING_CALL");
        C0841.m6594().registerReceiver(this.mReceiver2, filter);
    }

    /* renamed from: 电池状态改变 */
    public void mo1412(int 状态, int 剩余电量, int 温度) {
        EventDispatcher.dispatchEvent(this, "电池状态改变", Integer.valueOf(状态), Integer.valueOf(剩余电量), Integer.valueOf(温度));
    }

    /* renamed from: 监听手机状态 */
    public void m6461() {
        ((TelephonyManager) C0841.m6594().getSystemService("phone")).listen(new MyPhoneStateListener(), 32);
    }

    /* renamed from: 电话拨出 */
    public void mo1414(String phoneNumber) {
        EventDispatcher.dispatchEvent(this, "电话拨出", phoneNumber);
    }

    /* renamed from: 电话打进 */
    public void mo1413(String phoneNumber) {
        EventDispatcher.dispatchEvent(this, "电话打进", phoneNumber);
    }

    /* renamed from: 电话接听 */
    public void mo1416(String phoneNumber) {
        EventDispatcher.dispatchEvent(this, "电话接听", phoneNumber);
    }

    /* renamed from: 电话挂断 */
    public void mo1415(String phoneNumber) {
        EventDispatcher.dispatchEvent(this, "电话挂断", phoneNumber);
    }

    /* renamed from: 接听电话 */
    public void mo1411() {
        boolean 已接通;
        try {
            Object telephonyObject = getTelephonyObject(C0841.m6594());
            if (telephonyObject != null) {
                Method endCallMethod = telephonyObject.getClass().getMethod("answerRingingCall", new Class[0]);
                endCallMethod.setAccessible(true);
                endCallMethod.invoke(telephonyObject, new Object[0]);
            }
            已接通 = true;
        } catch (NoSuchMethodException e) {
            已接通 = false;
        } catch (Exception e2) {
            已接通 = false;
        }
        if (!已接通) {
            try {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(1, 79));
                C0841.m6594().sendOrderedBroadcast(intent, "android.permission.CALL_PRIVILEGED");
            } catch (Exception e3) {
                Intent meidaButtonIntent = new Intent("android.intent.action.MEDIA_BUTTON");
                meidaButtonIntent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(1, 79));
                C0841.m6594().sendOrderedBroadcast(meidaButtonIntent, null);
            }
        }
    }

    /* renamed from: 挂断电话 */
    public void mo1409() {
        try {
            Object telephonyObject = getTelephonyObject(C0841.m6594());
            if (telephonyObject != null) {
                Method endCallMethod = telephonyObject.getClass().getMethod("endCall", new Class[0]);
                endCallMethod.setAccessible(true);
                endCallMethod.invoke(telephonyObject, new Object[0]);
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    private Object getTelephonyObject(Context context) {
        Object telephonyObject = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Method getITelephony = telephonyManager.getClass().getDeclaredMethod("getITelephony", new Class[0]);
            getITelephony.setAccessible(true);
            telephonyObject = getITelephony.invoke(telephonyManager, new Object[0]);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        return telephonyObject;
    }

    /* renamed from: 拨号 */
    public void mo1408(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.length() > 0) {
            mainActivity.getContext().startActivity(new Intent("android.intent.action.CALL", Uri.parse(WebView.SCHEME_TEL + phoneNumber)));
        }
    }

    /* renamed from: 启动拨号界面 */
    public void mo1406(String phoneNumber) {
        mainActivity.getContext().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + phoneNumber)));
    }

    /* renamed from: 振动 */
    public void mo1410(int duration) {
        ((Vibrator) C0841.m6594().getSystemService("vibrator")).vibrate((long) duration);
    }

    /* renamed from: 取扬声器状态 */
    public boolean mo1400() {
        return ((AudioManager) C0841.m6594().getSystemService("audio")).isSpeakerphoneOn();
    }

    /* renamed from: 打开扬声器 */
    public void mo1407() {
        ((AudioManager) C0841.m6594().getSystemService("audio")).setSpeakerphoneOn(true);
    }

    /* renamed from: 关闭扬声器 */
    public void mo1390() {
        ((AudioManager) C0841.m6594().getSystemService("audio")).setSpeakerphoneOn(false);
    }

    /* renamed from: 发送邮件 */
    public void mo1393(String Address, String mailtitle, String mailtext) {
        Intent data = new Intent("android.intent.action.SENDTO");
        data.setData(Uri.parse(WebView.SCHEME_MAILTO + Address));
        data.putExtra("android.intent.extra.SUBJECT", mailtitle);
        data.putExtra("android.intent.extra.TEXT", mailtext);
        mainActivity.getContext().startActivity(data);
    }

    /* renamed from: 发送邮件2 */
    public void mo13942(String[] Address, String mailtitle, String mailtext, String filepath) {
        Intent email = new Intent("android.intent.action.SEND");
        File file = new File(filepath);
        email.setType("application/octet-stream");
        email.putExtra("android.intent.extra.EMAIL", Address);
        email.putExtra("android.intent.extra.SUBJECT", mailtitle);
        email.putExtra("android.intent.extra.TEXT", mailtext);
        email.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        mainActivity.getContext().startActivity(Intent.createChooser(email, "请选择邮件发送软件"));
    }

    /* renamed from: 发送彩信 */
    public void mo1392(String number, String text, String imagePath) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addFlags(268435456);
        intent.putExtra("address", number);
        intent.putExtra("sms_body", text);
        intent.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + imagePath));
        intent.setType("image/*");
        intent.setClassName("com.android.mms", "com.android.mms.ui.ComposeMessageActivity");
        mainActivity.getContext().startActivity(intent);
    }

    /* renamed from: 取IMSI码 */
    public String mo1396IMSI() {
        return ((TelephonyManager) C0841.m6594().getSystemService("phone")).getSubscriberId();
    }

    /* renamed from: 取IMEI码 */
    public String mo1395IMEI() {
        return ((TelephonyManager) C0841.m6594().getSystemService("phone")).getDeviceId();
    }

    /* renamed from: 取本机号码 */
    public String mo1401() {
        return ((TelephonyManager) C0841.m6594().getSystemService("phone")).getLine1Number();
    }

    /* renamed from: 取手机型号 */
    public String mo1399() {
        return Build.MODEL;
    }

    /* renamed from: 取系统版本号 */
    public String mo1403() {
        return VERSION.SDK;
    }

    /* renamed from: 取系统版本名 */
    public String mo1404() {
        return VERSION.RELEASE;
    }

    /* renamed from: 取通话记录 */
    public String mo1405() {
        String result = bi_常量类.f6358b_空串;
        Cursor cursor = C0841.m6594().getContentResolver().query(Calls.CONTENT_URI, new String[]{"number", C0110c.f289e, C1248a.f5654a, "date", "duration"}, null, null, "date DESC");
        int i = 0;
        cursor.moveToFirst();
        while (!cursor.isAfterLast() && i < 100) {
            String strNumber = cursor.getString(0);
            String strName = cursor.getString(1);
            int type = cursor.getInt(2);
            String str_type = bi_常量类.f6358b_空串;
            if (type == 1) {
                str_type = "呼入";
            } else if (type == 2) {
                str_type = "呼出";
            } else if (type == 3) {
                str_type = "未接";
            }
            long duration = cursor.getLong(4);
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.parseLong(cursor.getString(3))));
            if (result.equals(bi_常量类.f6358b_空串)) {
                result = str_type + "," + strName + "," + strNumber + "," + time + "," + duration;
            } else {
                result = result + "\n" + str_type + "," + strName + "," + strNumber + "," + time + "," + duration;
            }
            i++;
            cursor.moveToNext();
        }
        return result;
    }

    /* renamed from: 删除通话记录 */
    public void mo1391(String 号码) {
        C0841.m6594().getContentResolver().delete(Calls.CONTENT_URI, "number=?", new String[]{号码});
    }

    /* renamed from: 取SIM卡状态 */
    public int mo1397SIM() {
        int simState = ((TelephonyManager) C0841.m6594().getSystemService("phone")).getSimState();
        if (simState == 5) {
            return 1;
        }
        if (simState == 1) {
            return 2;
        }
        return 3;
    }

    /* renamed from: 取当前基站信息 */
    public String[] mo1398() {
        TelephonyManager mTelephonyManager = (TelephonyManager) C0841.m6594().getSystemService("phone");
        String operator = mTelephonyManager.getNetworkOperator();
        String MCC = operator.substring(0, 3);
        if (operator.substring(3).equals("02")) {
            CdmaCellLocation location1 = (CdmaCellLocation) mTelephonyManager.getCellLocation();
            String SID = Integer.toString(location1.getSystemId());
            String NID = Integer.toString(location1.getNetworkId());
            String BID = Integer.toString(location1.getBaseStationId());
            return new String[]{MCC, MNC, NID, BID, SID};
        }
        GsmCellLocation location2 = (GsmCellLocation) mTelephonyManager.getCellLocation();
        String LAC = Integer.toString(location2.getLac());
        String CID = Integer.toString(location2.getCid());
        return new String[]{MCC, MNC, LAC, CID, bi_常量类.f6358b_空串};
    }

    /* renamed from: 取相邻基站信息 */
    public C0683_集合类 mo1402() {
        List<NeighboringCellInfo> infos = ((TelephonyManager) C0841.m6594().getSystemService("phone")).getNeighboringCellInfo();
        C0683_集合类 result = new C0683_集合类();
        for (NeighboringCellInfo info1 : infos) {
            String lac = Integer.toString(info1.getLac());
            String cid = Integer.toString(info1.getCid());
            String bss = Integer.toString((info1.getRssi() * 2) - 113);
            result.m5454_集合add元素(ArrayVariant.getArrayVariant(new String[]{lac, cid, bss}));
        }
        return result;
    }
}
