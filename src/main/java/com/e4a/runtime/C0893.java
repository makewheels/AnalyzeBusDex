package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleDataElement;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.components.Component;
import com.e4a.runtime.variants.IntegerVariant;
import com.e4a.runtime.variants.Variant;
import java.math.BigDecimal;
import java.util.Stack;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.算术运算 */
public final class C0893 {
    @SimpleDataElement
    /* renamed from: E */
    public static final double f4335E = 2.718281828459045d;
    @SimpleDataElement
    public static final double PI = 3.141592653589793d;

    private C0893() {
    }

    @SimpleFunction
    /* renamed from: 取绝对值 */
    public static Variant m6859(Variant v) {
        if (v.cmp(IntegerVariant.getIntegerVariant(0)) < 0) {
            return v.mul(IntegerVariant.getIntegerVariant(-1));
        }
        return v;
    }

    @SimpleFunction
    /* renamed from: 求反正切 */
    public static double m6867(double v) {
        return Math.atan(v);
    }

    @SimpleFunction
    public static double Atn2(double y, double x) {
        return Math.atan2(y, x);
    }

    @SimpleFunction
    /* renamed from: 求余弦 */
    public static double m6863(double v) {
        return Math.cos(v);
    }

    @SimpleFunction
    /* renamed from: 求反对数 */
    public static double m6866(double v) {
        return Math.exp(v);
    }

    @SimpleFunction
    /* renamed from: 取整 */
    public static long m6855(Variant v) {
        return v.getLong();
    }

    @SimpleFunction
    /* renamed from: 求自然对数 */
    public static double m6872(double v) {
        return Math.log(v);
    }

    @SimpleFunction
    /* renamed from: 取最大值 */
    public static Variant m6856(Variant v1, Variant v2) {
        v1.getDouble();
        v2.getDouble();
        return v1.cmp(v2) < 0 ? v2 : v1;
    }

    @SimpleFunction
    /* renamed from: 取最小值 */
    public static Variant m6857(Variant v1, Variant v2) {
        v1.getDouble();
        v2.getDouble();
        return v1.cmp(v2) >= 0 ? v2 : v1;
    }

    @SimpleFunction
    /* renamed from: 取随机数 */
    public static int m6860(int start, int end) {
        if (start > end || start < 0 || end < 0) {
            return -1;
        }
        return (int) ((Math.random() * ((double) ((end - start) + 1))) + ((double) start));
    }

    @SimpleFunction
    /* renamed from: 求正弦 */
    public static double m6871(double v) {
        return Math.sin(v);
    }

    @SimpleFunction
    /* renamed from: 取符号 */
    public static int m6858(double v) {
        return (int) Math.signum(v);
    }

    @SimpleFunction
    /* renamed from: 求平方根 */
    public static double m6869(double v) {
        return Math.sqrt(v);
    }

    @SimpleFunction
    /* renamed from: 求正切 */
    public static double m6870(double v) {
        return Math.tan(v);
    }

    @SimpleFunction
    /* renamed from: 角度转弧度 */
    public static double m6874(double d) {
        return Math.toRadians(d);
    }

    @SimpleFunction
    /* renamed from: 弧度转角度 */
    public static double m6862(double r) {
        return Math.toDegrees(r);
    }

    @SimpleFunction
    /* renamed from: 四舍五入 */
    public static double m6861(double r, int p) {
        return new BigDecimal(String.valueOf(r)).setScale(p, 4).doubleValue();
    }

    @SimpleFunction
    /* renamed from: 求余数 */
    public static double m6864(double a, double b) {
        return a % b;
    }

    @SimpleFunction
    /* renamed from: 求反正弦 */
    public static double m6868(double v) {
        return Math.asin(v);
    }

    @SimpleFunction
    /* renamed from: 求反余弦 */
    public static double m6865(double v) {
        return Math.acos(v);
    }

    @SimpleFunction
    /* renamed from: 表达式计算 */
    public static double m6873(String expstr) {
        Stack s1 = new Stack();
        String[] hou = new String[30];
        String[] hao = new String[30];
        int i = 0;
        int j = 0;
        int fu = 0;
        while (i < expstr.length()) {
            String shu = bi_常量类.f6358b;
            char ch = expstr.charAt(i);
            switch (ch) {
                case Component.KEYCODE_L /*40*/:
                    hao[j] = shu + ch;
                    i++;
                    j++;
                    break;
                case Component.KEYCODE_M /*41*/:
                    hao[j] = shu + ch;
                    i++;
                    j++;
                    break;
                case Component.KEYCODE_N /*42*/:
                case Component.KEYCODE_S /*47*/:
                    hao[j] = shu + ch;
                    i++;
                    j++;
                    break;
                case Component.KEYCODE_O /*43*/:
                    hao[j] = shu + ch;
                    i++;
                    j++;
                    break;
                case Component.KEYCODE_Q /*45*/:
                    if (i <= 0 || expstr.charAt(i - 1) != '(') {
                        if (i != 0) {
                            hao[j] = shu + ch;
                            i++;
                            j++;
                            break;
                        }
                        fu = 1;
                        i++;
                        break;
                    }
                    fu = 1;
                    i++;
                    break;
                case Component.KEYCODE_DEL /*67*/:
                    hao[j] = shu + ch;
                    i++;
                    j++;
                    break;
                case 'K':
                    hao[j] = shu + ch;
                    i++;
                    j++;
                    break;
                default:
                    while (true) {
                        if ((ch < '0' || ch > '9') && ch != '.') {
                            if (fu == 1) {
                                shu = '-' + shu;
                                fu = 0;
                            }
                            hao[j] = shu;
                            j++;
                            break;
                        }
                        shu = shu + ch;
                        i++;
                        if (i < expstr.length()) {
                            ch = expstr.charAt(i);
                        } else {
                            ch = '=';
                        }
                    }
                    break;
            }
        }
        int t = 0;
        int o = 0;
        while (t < j) {
            if (hao[t].equals("+")) {
                while (!s1.empty() && !s1.peek().equals("(")) {
                    hou[o] = (String) s1.pop();
                    o++;
                }
                s1.push(hao[t]);
                t++;
            } else if (hao[t].equals("-")) {
                while (!s1.empty() && !s1.peek().equals("(")) {
                    hou[o] = (String) s1.pop();
                    o++;
                }
                s1.push(hao[t]);
                t++;
            } else if (hao[t].equals("*")) {
                while (!s1.empty() && !s1.peek().equals("(") && !s1.peek().equals("+") && !s1.peek().equals("-")) {
                    hou[o] = (String) s1.pop();
                    o++;
                }
                s1.push(hao[t]);
                t++;
            } else if (hao[t].equals("/")) {
                while (!s1.empty() && !s1.peek().equals("(") && !s1.peek().equals("+") && !s1.peek().equals("-")) {
                    hou[o] = (String) s1.pop();
                    o++;
                }
                s1.push(hao[t]);
                t++;
            } else if (hao[t].equals("C")) {
                s1.push(hao[t]);
                t++;
            } else if (hao[t].equals("K")) {
                s1.push(hao[t]);
                t++;
            } else if (hao[t].equals("(")) {
                s1.push(hao[t]);
                t++;
            } else if (hao[t].equals(")")) {
                for (String out = (String) s1.pop(); !out.equals("("); out = (String) s1.pop()) {
                    hou[o] = out;
                    o++;
                }
                t++;
            } else {
                hou[o] = hao[t];
                o++;
                t++;
            }
        }
        while (!s1.isEmpty()) {
            hou[o] = (String) s1.pop();
            o++;
        }
        Stack s2 = new Stack();
        int m = 0;
        while (m < o) {
            String q;
            if (hou[m].equals("+")) {
                q = (String) s2.pop();
                s2.push(Double.toString(Double.parseDouble(q) + Double.parseDouble((String) s2.pop())));
                m++;
            } else if (hou[m].equals("-")) {
                q = (String) s2.pop();
                s2.push(Double.toString(Double.parseDouble(q) - Double.parseDouble((String) s2.pop())));
                m++;
            } else if (hou[m].equals("*")) {
                q = (String) s2.pop();
                s2.push(Double.toString(Double.parseDouble(q) * Double.parseDouble((String) s2.pop())));
                m++;
            } else if (hou[m].equals("/")) {
                q = (String) s2.pop();
                s2.push(Double.toString(Double.parseDouble(q) / Double.parseDouble((String) s2.pop())));
                m++;
            } else if (hou[m].equals("C")) {
                double a = Double.parseDouble((String) s2.pop());
                s2.push(Double.toString(a * a));
                m++;
            } else if (hou[m].equals("K")) {
                s2.push(Double.toString(Math.sqrt(Double.parseDouble((String) s2.pop()))));
                m++;
            } else {
                s2.push(hou[m]);
                m++;
            }
        }
        if (s2.empty()) {
            return 0.0d;
        }
        return Double.parseDouble((String) s2.pop());
    }
}
