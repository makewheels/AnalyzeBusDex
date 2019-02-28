package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleDataElement;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.时间操作 */
public final class C0891 {
    @SimpleDataElement
    public static final int DATE_APRIL = 3;
    @SimpleDataElement
    public static final int DATE_AUGUST = 7;
    @SimpleDataElement
    public static final int DATE_DAY = 5;
    @SimpleDataElement
    public static final int DATE_DECEMBER = 11;
    @SimpleDataElement
    public static final int DATE_FEBRUARY = 1;
    @SimpleDataElement
    public static final int DATE_FRIDAY = 6;
    @SimpleDataElement
    public static final int DATE_HOUR = 11;
    @SimpleDataElement
    public static final int DATE_JANUARY = 0;
    @SimpleDataElement
    public static final int DATE_JULY = 6;
    @SimpleDataElement
    public static final int DATE_JUNE = 5;
    @SimpleDataElement
    public static final int DATE_MARCH = 2;
    @SimpleDataElement
    public static final int DATE_MAY = 4;
    @SimpleDataElement
    public static final int DATE_MINUTE = 12;
    @SimpleDataElement
    public static final int DATE_MONDAY = 2;
    @SimpleDataElement
    public static final int DATE_MONTH = 2;
    @SimpleDataElement
    public static final int DATE_NOVEMBER = 10;
    @SimpleDataElement
    public static final int DATE_OCTOBER = 9;
    @SimpleDataElement
    public static final int DATE_SATURDAY = 7;
    @SimpleDataElement
    public static final int DATE_SECOND = 13;
    @SimpleDataElement
    public static final int DATE_SEPTEMBER = 8;
    @SimpleDataElement
    public static final int DATE_SUNDAY = 1;
    @SimpleDataElement
    public static final int DATE_THURSDAY = 5;
    @SimpleDataElement
    public static final int DATE_TUESDAY = 3;
    @SimpleDataElement
    public static final int DATE_WEDNESDAY = 4;
    @SimpleDataElement
    public static final int DATE_WEEK = 3;
    @SimpleDataElement
    public static final int DATE_YEAR = 1;

    private C0891() {
    }

    @SimpleFunction
    /* renamed from: 增减时间 */
    public static Calendar m6841(Calendar date, int intervalKind, int interval) {
        int kind = 0;
        switch (intervalKind) {
            case 1:
                kind = 1;
                break;
            case 2:
                kind = 2;
                break;
            case 3:
                kind = 5;
                break;
            case 4:
                kind = 3;
                break;
            case 5:
                kind = 11;
                break;
            case 6:
                kind = 12;
                break;
            case 7:
                kind = 13;
                break;
        }
        date.add(kind, interval);
        return date;
    }

    @SimpleFunction
    /* renamed from: 到时间 */
    public static Calendar m6824(String value) {
        Calendar date = new GregorianCalendar();
        try {
            date.setTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(value));
        } catch (ParseException e) {
            try {
                date.setTime(new SimpleDateFormat("yyyy/MM/dd").parse(value));
            } catch (ParseException e2) {
                throw new IllegalArgumentException("illegal date/time format in function DateValue()");
            }
        }
        return date;
    }

    @SimpleFunction
    /* renamed from: 取日 */
    public static int m6830(Calendar date) {
        return date.get(5);
    }

    @SimpleFunction
    /* renamed from: 时间到文本 */
    public static String m6842(Calendar date) {
        return DateFormat.getDateTimeInstance(1, 1).format(date.getTime());
    }

    @SimpleFunction
    /* renamed from: 取小时 */
    public static int m6827(Calendar date) {
        return date.get(11);
    }

    @SimpleFunction
    /* renamed from: 取分钟 */
    public static int m6825(Calendar date) {
        return date.get(12);
    }

    @SimpleFunction
    /* renamed from: 取月份 */
    public static int m6834(Calendar date) {
        return date.get(2) + 1;
    }

    @SimpleFunction
    /* renamed from: 取月份名称 */
    public static String m6835(Calendar date) {
        return String.format("%1$tB", new Object[]{date});
    }

    @SimpleFunction
    /* renamed from: 取现行时间 */
    public static Calendar m6837() {
        return new GregorianCalendar();
    }

    @SimpleFunction
    /* renamed from: 取秒 */
    public static int m6840(Calendar date) {
        return date.get(13);
    }

    @SimpleFunction
    /* renamed from: 取启动时间 */
    public static long m6826() {
        return System.currentTimeMillis();
    }

    @SimpleFunction
    /* renamed from: 取星期几 */
    public static int m6832(Calendar date) {
        return date.get(7);
    }

    @SimpleFunction
    /* renamed from: 取星期几名称 */
    public static String m6833(Calendar date) {
        return String.format("%1$tA", new Object[]{date});
    }

    @SimpleFunction
    /* renamed from: 取年份 */
    public static int m6828(Calendar date) {
        return date.get(1);
    }

    @SimpleFunction
    /* renamed from: 取现行时间文本 */
    public static String m6839(String separator) {
        return new SimpleDateFormat("HH" + separator + "mm" + separator + "ss").format(new Date(System.currentTimeMillis()));
    }

    @SimpleFunction
    /* renamed from: 取现行日期文本 */
    public static String m6836(String separator) {
        return new SimpleDateFormat("yyyy" + separator + "MM" + separator + "dd").format(new Date(System.currentTimeMillis()));
    }

    @SimpleFunction
    /* renamed from: 取时间间隔 */
    public static long m6831(Calendar date1, Calendar date2) {
        return date1.getTimeInMillis() - date2.getTimeInMillis();
    }

    @SimpleFunction
    /* renamed from: 取现行时间戳 */
    public static String m6838(int type) {
        String s = String.valueOf(new Date().getTime());
        if (type == 2) {
            return s.substring(0, 10);
        }
        return s;
    }

    @SimpleFunction
    /* renamed from: 取指定时间戳 */
    public static String m6829(Calendar date, int type) {
        String s = String.valueOf(date.getTimeInMillis());
        if (type == 2) {
            return s.substring(0, 10);
        }
        return s;
    }

    @SimpleFunction
    /* renamed from: 时间戳到时间文本 */
    public static String m6843(String timestamp) {
        if (timestamp == null || timestamp.equals(bi_常量类.f6358b)) {
            return bi_常量类.f6358b;
        }
        Long stamp;
        if (timestamp.length() == 10) {
            stamp = Long.valueOf(Long.parseLong(timestamp) * 1000);
        } else if (timestamp.length() != 13) {
            return bi_常量类.f6358b;
        } else {
            stamp = Long.valueOf(Long.parseLong(timestamp));
        }
        Date date = new Date(stamp.longValue());
        String strs = bi_常量类.f6358b;
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return strs;
        }
    }
}
