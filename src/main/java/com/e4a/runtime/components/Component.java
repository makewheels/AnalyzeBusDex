package com.e4a.runtime.components;

import com.e4a.runtime.annotations.SimpleDataElement;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleObject;

@SimpleObject
public interface Component {
    @SimpleDataElement
    public static final float FONT_DEFAULT_SIZE = 9.0f;
    @SimpleDataElement
    public static final float GRAVITY_CENTER = 17.0f;
    @SimpleDataElement
    public static final float GRAVITY_EAST = 21.0f;
    @SimpleDataElement
    public static final float GRAVITY_NORTH = 49.0f;
    @SimpleDataElement
    public static final float GRAVITY_NORTHEAST = 53.0f;
    @SimpleDataElement
    public static final float GRAVITY_NORTHWEST = 51.0f;
    @SimpleDataElement
    public static final float GRAVITY_SOUTH = 81.0f;
    @SimpleDataElement
    public static final float GRAVITY_SOUTHEAST = 85.0f;
    @SimpleDataElement
    public static final float GRAVITY_SOUTHWEST = 83.0f;
    @SimpleDataElement
    public static final float GRAVITY_WEST = 19.0f;
    @SimpleDataElement
    /* renamed from: HOME键 */
    public static final int f3879HOME = 3;
    @SimpleDataElement
    public static final int HORIZONTAL_ALIGNMENT_CENTER = 1;
    @SimpleDataElement
    public static final int HORIZONTAL_ALIGNMENT_LEFT = 0;
    @SimpleDataElement
    public static final int HORIZONTAL_ALIGNMENT_RIGHT = 2;
    @SimpleDataElement
    public static final int JUSTIFY_CENTER = 1;
    @SimpleDataElement
    public static final int JUSTIFY_LEFT = 0;
    @SimpleDataElement
    public static final int JUSTIFY_RIGHT = 2;
    @SimpleDataElement
    public static final int KEYCODE_0 = 7;
    @SimpleDataElement
    public static final int KEYCODE_1 = 8;
    @SimpleDataElement
    public static final int KEYCODE_2 = 9;
    @SimpleDataElement
    public static final int KEYCODE_3 = 10;
    @SimpleDataElement
    public static final int KEYCODE_4 = 11;
    @SimpleDataElement
    public static final int KEYCODE_5 = 12;
    @SimpleDataElement
    public static final int KEYCODE_6 = 13;
    @SimpleDataElement
    public static final int KEYCODE_7 = 14;
    @SimpleDataElement
    public static final int KEYCODE_8 = 15;
    @SimpleDataElement
    public static final int KEYCODE_9 = 16;
    @SimpleDataElement
    public static final int KEYCODE_A = 29;
    @SimpleDataElement
    public static final int KEYCODE_APOSTROPHE = 75;
    @SimpleDataElement
    public static final int KEYCODE_AT = 77;
    @SimpleDataElement
    public static final int KEYCODE_B = 30;
    @SimpleDataElement
    public static final int KEYCODE_BACKSLASH = 73;
    @SimpleDataElement
    public static final int KEYCODE_C = 31;
    @SimpleDataElement
    public static final int KEYCODE_CALL = 5;
    @SimpleDataElement
    public static final int KEYCODE_CLEAR = 28;
    @SimpleDataElement
    public static final int KEYCODE_COMMA = 55;
    @SimpleDataElement
    public static final int KEYCODE_D = 32;
    @SimpleDataElement
    public static final int KEYCODE_DEL = 67;
    @SimpleDataElement
    public static final int KEYCODE_E = 33;
    @SimpleDataElement
    public static final int KEYCODE_ENDCALL = 6;
    @SimpleDataElement
    public static final int KEYCODE_ENVELOPE = 65;
    @SimpleDataElement
    public static final int KEYCODE_EQUALS = 70;
    @SimpleDataElement
    public static final int KEYCODE_EXPLORER = 64;
    @SimpleDataElement
    public static final int KEYCODE_F = 34;
    @SimpleDataElement
    public static final int KEYCODE_FOCUS = 80;
    @SimpleDataElement
    public static final int KEYCODE_G = 35;
    @SimpleDataElement
    public static final int KEYCODE_GRAVE = 68;
    @SimpleDataElement
    public static final int KEYCODE_H = 36;
    @SimpleDataElement
    public static final int KEYCODE_I = 37;
    @SimpleDataElement
    public static final int KEYCODE_J = 38;
    @SimpleDataElement
    public static final int KEYCODE_K = 39;
    @SimpleDataElement
    public static final int KEYCODE_L = 40;
    @SimpleDataElement
    public static final int KEYCODE_LEFT = 1;
    @SimpleDataElement
    public static final int KEYCODE_LEFT_ALT = 57;
    @SimpleDataElement
    public static final int KEYCODE_LEFT_BRACKET = 71;
    @SimpleDataElement
    public static final int KEYCODE_LEFT_SHIFT = 59;
    @SimpleDataElement
    public static final int KEYCODE_M = 41;
    @SimpleDataElement
    public static final int KEYCODE_MEDIA_FAST_FORWARD = 90;
    @SimpleDataElement
    public static final int KEYCODE_MEDIA_NEXT = 87;
    @SimpleDataElement
    public static final int KEYCODE_MEDIA_PLAY_PAUSE = 85;
    @SimpleDataElement
    public static final int KEYCODE_MEDIA_PREVIOUS = 88;
    @SimpleDataElement
    public static final int KEYCODE_MEDIA_REWIND = 89;
    @SimpleDataElement
    public static final int KEYCODE_MEDIA_STOP = 86;
    @SimpleDataElement
    public static final int KEYCODE_MINUS = 69;
    @SimpleDataElement
    public static final int KEYCODE_MUTE = 91;
    @SimpleDataElement
    public static final int KEYCODE_N = 42;
    @SimpleDataElement
    public static final int KEYCODE_NOTIFICATION = 83;
    @SimpleDataElement
    public static final int KEYCODE_NUM = 78;
    @SimpleDataElement
    public static final int KEYCODE_O = 43;
    @SimpleDataElement
    public static final int KEYCODE_P = 44;
    @SimpleDataElement
    public static final int KEYCODE_PERIOD = 56;
    @SimpleDataElement
    public static final int KEYCODE_PLUS = 81;
    @SimpleDataElement
    public static final int KEYCODE_POUND = 18;
    @SimpleDataElement
    public static final int KEYCODE_POWER = 8218;
    @SimpleDataElement
    public static final int KEYCODE_Q = 45;
    @SimpleDataElement
    public static final int KEYCODE_R = 46;
    @SimpleDataElement
    public static final int KEYCODE_RIGHT = 2;
    @SimpleDataElement
    public static final int KEYCODE_RIGHT_ALT = 58;
    @SimpleDataElement
    public static final int KEYCODE_RIGHT_BRACKET = 72;
    @SimpleDataElement
    public static final int KEYCODE_RIGHT_SHIFT = 60;
    @SimpleDataElement
    public static final int KEYCODE_S = 47;
    @SimpleDataElement
    public static final int KEYCODE_SEMICOLON = 74;
    @SimpleDataElement
    public static final int KEYCODE_SLASH = 76;
    @SimpleDataElement
    public static final int KEYCODE_SPACE = 62;
    @SimpleDataElement
    public static final int KEYCODE_STAR = 17;
    @SimpleDataElement
    public static final int KEYCODE_SYM = 63;
    @SimpleDataElement
    public static final int KEYCODE_T = 48;
    @SimpleDataElement
    public static final int KEYCODE_TAB = 61;
    @SimpleDataElement
    public static final int KEYCODE_U = 49;
    @SimpleDataElement
    public static final int KEYCODE_V = 50;
    @SimpleDataElement
    public static final int KEYCODE_W = 51;
    @SimpleDataElement
    public static final int KEYCODE_X = 52;
    @SimpleDataElement
    public static final int KEYCODE_Y = 53;
    @SimpleDataElement
    public static final int KEYCODE_Z = 54;
    public static final int LAYOUT_NO_COLUMN = -1;
    public static final int LAYOUT_NO_ROW = -1;
    @SimpleDataElement
    public static final int TYPEFACE_DEFAULT = 0;
    @SimpleDataElement
    public static final int TYPEFACE_MONOSPACE = 3;
    @SimpleDataElement
    public static final int TYPEFACE_SANSSERIF = 1;
    @SimpleDataElement
    public static final int TYPEFACE_SERIF = 2;
    @SimpleDataElement
    public static final int VERTICAL_ALIGNMENT_BOTTOM = 2;
    @SimpleDataElement
    public static final int VERTICAL_ALIGNMENT_CENTER = 1;
    @SimpleDataElement
    public static final int VERTICAL_ALIGNMENT_TOP = 0;
    @SimpleDataElement
    /* renamed from: 上滑 */
    public static final int f3880 = 2;
    @SimpleDataElement
    /* renamed from: 上移 */
    public static final int f3881 = 6;
    @SimpleDataElement
    /* renamed from: 上键 */
    public static final int f3882 = 19;
    @SimpleDataElement
    /* renamed from: 下滑 */
    public static final int f3883 = 3;
    @SimpleDataElement
    /* renamed from: 下移 */
    public static final int f3884 = 7;
    @SimpleDataElement
    /* renamed from: 下键 */
    public static final int f3885 = 20;
    @SimpleDataElement
    /* renamed from: 中键 */
    public static final int f3886 = 23;
    @SimpleDataElement
    /* renamed from: 单击 */
    public static final int f3887 = 0;
    @SimpleDataElement
    /* renamed from: 单帧布局 */
    public static final int f3888 = 3;
    @SimpleDataElement
    /* renamed from: 单行输入 */
    public static final int f3889 = 1;
    @SimpleDataElement
    /* renamed from: 双击 */
    public static final int f3890 = 1;
    @SimpleDataElement
    /* renamed from: 反旋转 */
    public static final int f3891 = 4;
    @SimpleDataElement
    /* renamed from: 反淡化 */
    public static final int f3892 = 6;
    @SimpleDataElement
    /* renamed from: 反缩放 */
    public static final int f3893 = 5;
    @SimpleDataElement
    /* renamed from: 只读方式 */
    public static final int f3894 = 3;
    @SimpleDataElement
    /* renamed from: 右滑 */
    public static final int f3895 = 5;
    @SimpleDataElement
    /* renamed from: 右移 */
    public static final int f3896 = 9;
    @SimpleDataElement
    /* renamed from: 右键 */
    public static final int f3897 = 22;
    @SimpleDataElement
    /* renamed from: 品红 */
    public static final int f3898 = -65281;
    @SimpleDataElement
    /* renamed from: 回车键 */
    public static final int f3899 = 66;
    @SimpleDataElement
    /* renamed from: 填充父 */
    public static final int f3900 = -1;
    @SimpleDataElement
    /* renamed from: 多行输入 */
    public static final int f3901 = 4;
    @SimpleDataElement
    /* renamed from: 左滑 */
    public static final int f3902 = 4;
    @SimpleDataElement
    /* renamed from: 左移 */
    public static final int f3903 = 8;
    @SimpleDataElement
    /* renamed from: 左键 */
    public static final int f3904 = 21;
    @SimpleDataElement
    /* renamed from: 搜索键 */
    public static final int f3905 = 84;
    @SimpleDataElement
    /* renamed from: 旋转 */
    public static final int f3906 = 1;
    @SimpleDataElement
    /* renamed from: 无色 */
    public static final int f3907 = 0;
    @SimpleDataElement
    /* renamed from: 横向 */
    public static final int f3908 = 0;
    @SimpleDataElement
    /* renamed from: 浅灰 */
    public static final int f3909 = -3355444;
    @SimpleDataElement
    /* renamed from: 淡化 */
    public static final int f3910 = 3;
    @SimpleDataElement
    /* renamed from: 深灰 */
    public static final int f3911 = -12303292;
    @SimpleDataElement
    /* renamed from: 灰色 */
    public static final int f3912 = -7829368;
    @SimpleDataElement
    /* renamed from: 白色 */
    public static final int f3913 = -1;
    @SimpleDataElement
    /* renamed from: 相机键 */
    public static final int f3914 = 27;
    @SimpleDataElement
    /* renamed from: 紫色 */
    public static final int f3915 = -8388353;
    @SimpleDataElement
    /* renamed from: 红色 */
    public static final int f3916 = -65536;
    @SimpleDataElement
    /* renamed from: 纵向 */
    public static final int f3917 = 1;
    @SimpleDataElement
    /* renamed from: 线性布局 */
    public static final int f3918 = 1;
    @SimpleDataElement
    /* renamed from: 绝对布局 */
    public static final int f3919 = 4;
    @SimpleDataElement
    /* renamed from: 绿色 */
    public static final int f3920 = -16711936;
    @SimpleDataElement
    /* renamed from: 缩放 */
    public static final int f3921 = 2;
    @SimpleDataElement
    /* renamed from: 耳机键 */
    public static final int f3922 = 79;
    @SimpleDataElement
    /* renamed from: 自适应 */
    public static final int f3923 = -2;
    @SimpleDataElement
    /* renamed from: 菜单键 */
    public static final int f3924 = 82;
    @SimpleDataElement
    /* renamed from: 蓝色 */
    public static final int f3925 = -16776961;
    @SimpleDataElement
    /* renamed from: 表格布局 */
    public static final int f3926 = 2;
    @SimpleDataElement
    /* renamed from: 输入数字 */
    public static final int f3927 = 2;
    @SimpleDataElement
    /* renamed from: 返回键 */
    public static final int f3928 = 4;
    @SimpleDataElement
    /* renamed from: 青绿 */
    public static final int f3929 = -16711681;
    @SimpleDataElement
    /* renamed from: 靠上右对齐 */
    public static final int f3930 = 9;
    @SimpleDataElement
    /* renamed from: 靠上居中 */
    public static final int f3931 = 6;
    @SimpleDataElement
    /* renamed from: 靠上左对齐 */
    public static final int f3932 = 3;
    @SimpleDataElement
    /* renamed from: 靠下右对齐 */
    public static final int f3933 = 11;
    @SimpleDataElement
    /* renamed from: 靠下居中 */
    public static final int f3934 = 8;
    @SimpleDataElement
    /* renamed from: 靠下左对齐 */
    public static final int f3935 = 5;
    @SimpleDataElement
    /* renamed from: 靠中右对齐 */
    public static final int f3936 = 10;
    @SimpleDataElement
    /* renamed from: 靠中居中 */
    public static final int f3937 = 7;
    @SimpleDataElement
    /* renamed from: 靠中左对齐 */
    public static final int f3938 = 4;
    @SimpleDataElement
    /* renamed from: 音量减键 */
    public static final int f3939 = 25;
    @SimpleDataElement
    /* renamed from: 音量增键 */
    public static final int f3940 = 24;
    @SimpleDataElement
    /* renamed from: 黄色 */
    public static final int f3941 = -256;
    @SimpleDataElement
    /* renamed from: 黑色 */
    public static final int f3942 = -16777216;

    @SimpleEvent
    /* renamed from: 创建完毕 */
    void mo765();
}
