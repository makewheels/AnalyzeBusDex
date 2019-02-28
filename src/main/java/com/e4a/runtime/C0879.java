package com.e4a.runtime;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.e4a.runtime.ColorPickerDialog.OnColorChangedListener;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.parameters.BooleanReferenceParameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.对话框类 */
public final class C0879 {
    private static MyAdapter Adapter;
    private static String CANCEL = "取消";
    private static int InputType = 4;
    private static String OK = "确定";
    private static List<Map<String, String>> data;
    private static ProgressDialog progressDialog;
    /* renamed from: 可取消 */
    private static boolean f4333 = false;

    /* renamed from: com.e4a.runtime.对话框类$ColorBox */
    private static class ColorBox {
        private int dialogResult;
        private Handler mHandler;

        /* renamed from: com.e4a.runtime.对话框类$ColorBox$1 */
        class C08541 implements OnColorChangedListener {
            C08541() {
            }

            public void colorChanged(int color) {
                ColorBox.this.endDialog(color);
            }
        }

        private ColorBox() {
        }

        public int getDialogResult() {
            return this.dialogResult;
        }

        public void setDialogResult(int dialogResult) {
            this.dialogResult = dialogResult;
        }

        public void endDialog(int result) {
            setDialogResult(result);
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
        }

        public int showDialog(String title, int initalColor) {
            ColorPickerDialog dialog = new ColorPickerDialog(mainActivity.getContext(), title, C0879.OK, initalColor, new C08541());
            dialog.setCancelable(false);
            dialog.show();
            this.mHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message mesg) {
                    throw new RuntimeException();
                }
            };
            try {
                Looper.getMainLooper();
                Looper.loop();
            } catch (RuntimeException re) {
                re.printStackTrace();
            }
            return this.dialogResult;
        }
    }

    /* renamed from: com.e4a.runtime.对话框类$DialogBox */
    private static class DialogBox {
        private String[] Items;
        private boolean[] State;
        private String dialogResult;
        private Handler mHandler;

        /* renamed from: com.e4a.runtime.对话框类$DialogBox$1 */
        class C08561 implements OnClickListener {
            C08561() {
            }

            public void onClick(DialogInterface dialog, int which) {
                boolean[] s = DialogBox.this.getState();
                for (int i = 0; i < s.length; i++) {
                    if (i == which) {
                        s[i] = true;
                    } else {
                        s[i] = false;
                    }
                }
                DialogBox.this.setState(s);
            }
        }

        /* renamed from: com.e4a.runtime.对话框类$DialogBox$2 */
        class C08572 implements OnClickListener {
            C08572() {
            }

            public void onClick(DialogInterface dialog, int which) {
                String result = bi_常量类.f6358b_空串;
                boolean[] s = DialogBox.this.getState();
                String[] it = DialogBox.this.getItems();
                for (int i = 0; i < s.length; i++) {
                    if (s[i]) {
                        result = it[i];
                    }
                }
                DialogBox.this.endDialog(result);
            }
        }

        /* renamed from: com.e4a.runtime.对话框类$DialogBox$3 */
        class C08583 implements OnClickListener {
            C08583() {
            }

            public void onClick(DialogInterface dialog, int which) {
                DialogBox.this.endDialog(bi_常量类.f6358b_空串);
            }
        }

        /* renamed from: com.e4a.runtime.对话框类$DialogBox$5 */
        class C08605 implements OnMultiChoiceClickListener {
            C08605() {
            }

            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                boolean[] s = DialogBox.this.getState();
                s[which] = isChecked;
                DialogBox.this.setState(s);
            }
        }

        /* renamed from: com.e4a.runtime.对话框类$DialogBox$6 */
        class C08616 implements OnClickListener {
            C08616() {
            }

            public void onClick(DialogInterface dialog, int which) {
                String result = bi_常量类.f6358b_空串;
                boolean[] s = DialogBox.this.getState();
                String[] it = DialogBox.this.getItems();
                for (int i = 0; i < s.length; i++) {
                    if (s[i]) {
                        if (result == bi_常量类.f6358b_空串) {
                            result = it[i];
                        } else {
                            result = result + "\n" + it[i];
                        }
                    }
                }
                DialogBox.this.endDialog(result);
            }
        }

        /* renamed from: com.e4a.runtime.对话框类$DialogBox$7 */
        class C08627 implements OnClickListener {
            C08627() {
            }

            public void onClick(DialogInterface dialog, int which) {
                DialogBox.this.endDialog(bi_常量类.f6358b_空串);
            }
        }

        private DialogBox() {
        }

        public String getDialogResult() {
            return this.dialogResult;
        }

        public void setDialogResult(String dialogResult) {
            this.dialogResult = dialogResult;
        }

        public String[] getItems() {
            return this.Items;
        }

        public void setItems(String[] items) {
            this.Items = items;
        }

        public boolean[] getState() {
            return this.State;
        }

        public void setState(boolean[] state) {
            this.State = state;
        }

        public void endDialog(String result) {
            setDialogResult(result);
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
        }

        public String showDialog(Builder builder, String title, String[] items, boolean[] state) {
            this.Items = items;
            this.State = state;
            int checkedItem = 0;
            for (int k = 0; k < state.length; k++) {
                if (state[k]) {
                    checkedItem = k;
                    break;
                }
            }
            builder.setTitle(title).setCancelable(false);
            builder.setSingleChoiceItems(items, checkedItem, new C08561());
            builder.setPositiveButton(C0879.OK, new C08572());
            builder.setNegativeButton(C0879.CANCEL, new C08583());
            builder.show();
            this.mHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message mesg) {
                    throw new RuntimeException();
                }
            };
            try {
                Looper.getMainLooper();
                Looper.loop();
            } catch (RuntimeException re) {
                re.printStackTrace();
            }
            return this.dialogResult;
        }

        public String showDialog2(Builder builder, String title, String[] items, boolean[] state) {
            this.Items = items;
            this.State = state;
            builder.setTitle(title).setCancelable(false);
            builder.setMultiChoiceItems(items, state, new C08605());
            builder.setPositiveButton(C0879.OK, new C08616());
            builder.setNegativeButton(C0879.CANCEL, new C08627());
            builder.show();
            this.mHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message mesg) {
                    throw new RuntimeException();
                }
            };
            try {
                Looper.getMainLooper();
                Looper.loop();
            } catch (RuntimeException re) {
                re.printStackTrace();
            }
            return this.dialogResult;
        }
    }

    /* renamed from: com.e4a.runtime.对话框类$InputBox */
    private static class InputBox {
        private String dialogResult;
        private Handler mHandler;

        private InputBox() {
        }

        public String getDialogResult() {
            return this.dialogResult;
        }

        public void setDialogResult(String dialogResult) {
            this.dialogResult = dialogResult;
        }

        public void endDialog(String result) {
            setDialogResult(result);
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
        }

        public String showDialog(Builder builder, String title, String text, BooleanReferenceParameter accept) {
            final EditText inputServer = new EditText(mainActivity.getContext());
            switch (C0879.InputType) {
                case 1:
                    inputServer.setInputType(1);
                    break;
                case 2:
                    inputServer.setInputType(3);
                    break;
                case 3:
                    inputServer.setInputType(0);
                    break;
                case 4:
                    inputServer.setInputType(131073);
                    break;
            }
            final BooleanReferenceParameter choice = accept;
            inputServer.setText(text);
            inputServer.setFocusable(true);
            builder.setTitle(title).setView(inputServer).setCancelable(false).setPositiveButton(C0879.OK, new OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    choice.set(true);
                    InputBox.this.endDialog(inputServer.getText().toString());
                }
            }).setNegativeButton(C0879.CANCEL, new OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    choice.set(false);
                    InputBox.this.endDialog(bi_常量类.f6358b_空串);
                }
            }).show();
            this.mHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message mesg) {
                    throw new RuntimeException();
                }
            };
            try {
                Looper.getMainLooper();
                Looper.loop();
            } catch (RuntimeException re) {
                re.printStackTrace();
            }
            return this.dialogResult;
        }

        public String showDialog2(Builder builder, String 标题, String 项目一, String 项目二, String 初始内容, String 提示内容, BooleanReferenceParameter 输入结果) {
            LinearLayout layout = new LinearLayout(mainActivity.getContext());
            layout.setOrientation(1);
            LayoutParams param = new LayoutParams(-1, -1);
            param.weight = 1.0f;
            ListView listview = new ListView(mainActivity.getContext());
            listview.setFocusable(true);
            C0879.data = new ArrayList();
            C0879.Adapter = new MyAdapter();
            listview.setAdapter(C0879.Adapter);
            Map<String, String> map1 = new HashMap();
            map1.put("title", 项目一);
            C0879.data.add(map1);
            Map<String, String> map2 = new HashMap();
            map2.put("title", 项目二);
            C0879.data.add(map2);
            C0879.Adapter.notifyDataSetChanged();
            final EditText inputServer = new EditText(mainActivity.getContext());
            inputServer.setFocusable(true);
            inputServer.setInputType(1);
            inputServer.setTransformationMethod(PasswordTransformationMethod.getInstance());
            inputServer.setText(初始内容);
            inputServer.setHint(提示内容);
            layout.addView(listview, param);
            layout.addView(inputServer, param);
            final BooleanReferenceParameter choice = 输入结果;
            builder.setTitle(标题).setView(layout).setCancelable(false).setPositiveButton(C0879.OK, new OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    choice.set(true);
                    InputBox.this.endDialog(inputServer.getText().toString());
                }
            }).setNegativeButton(C0879.CANCEL, new OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    choice.set(false);
                    InputBox.this.endDialog(bi_常量类.f6358b_空串);
                }
            }).show();
            this.mHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message mesg) {
                    throw new RuntimeException();
                }
            };
            try {
                Looper.getMainLooper();
                Looper.loop();
            } catch (RuntimeException re) {
                re.printStackTrace();
            }
            return this.dialogResult;
        }
    }

    /* renamed from: com.e4a.runtime.对话框类$MessageBox3 */
    private static class MessageBox3 {
        private int dialogResult;
        private Handler mHandler;

        /* renamed from: com.e4a.runtime.对话框类$MessageBox3$2 */
        class C08762 implements OnClickListener {
            C08762() {
            }

            public void onClick(DialogInterface dialog, int which) {
                MessageBox3.this.endDialog(0);
            }
        }

        /* renamed from: com.e4a.runtime.对话框类$MessageBox3$3 */
        class C08773 implements OnClickListener {
            C08773() {
            }

            public void onClick(DialogInterface dialog, int which) {
                MessageBox3.this.endDialog(1);
            }
        }

        private MessageBox3() {
            this.dialogResult = 0;
        }

        public int getDialogResult() {
            return this.dialogResult;
        }

        public void setDialogResult(int dialogResult) {
            this.dialogResult = dialogResult;
        }

        public void endDialog(int result) {
            setDialogResult(result);
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
        }

        public int showDialog(Builder builder, String title, String message1, String message2, String btnOK, String btnNO, boolean state, BooleanReferenceParameter accept) {
            final BooleanReferenceParameter choice = accept;
            builder.setTitle(title).setCancelable(false);
            LinearLayout layout = new LinearLayout(mainActivity.getContext());
            layout.setOrientation(1);
            LayoutParams param = new LayoutParams(-1, -1);
            param.weight = 1.0f;
            TextView text = new TextView(mainActivity.getContext());
            text.setText(message1);
            CheckBox check = new CheckBox(mainActivity.getContext());
            check.setText(message2);
            check.setChecked(state);
            check.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    choice.set(isChecked);
                }
            });
            layout.addView(text, param);
            layout.addView(check, param);
            builder.setView(layout);
            builder.setPositiveButton(btnOK, new C08762());
            builder.setNegativeButton(btnNO, new C08773());
            builder.show();
            this.mHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message mesg) {
                    throw new RuntimeException();
                }
            };
            try {
                Looper.getMainLooper();
                Looper.loop();
            } catch (RuntimeException re) {
                re.printStackTrace();
            }
            return this.dialogResult;
        }
    }

    /* renamed from: com.e4a.runtime.对话框类$MessageBox */
    private static class MessageBox {
        private int dialogResult;
        private Handler mHandler;

        /* renamed from: com.e4a.runtime.对话框类$MessageBox$1 */
        class C08701 implements OnClickListener {
            C08701() {
            }

            public void onClick(DialogInterface dialog, int which) {
                MessageBox.this.endDialog(0);
            }
        }

        /* renamed from: com.e4a.runtime.对话框类$MessageBox$3 */
        class C08723 implements OnClickListener {
            C08723() {
            }

            public void onClick(DialogInterface dialog, int which) {
                MessageBox.this.endDialog(1);
            }
        }

        /* renamed from: com.e4a.runtime.对话框类$MessageBox$4 */
        class C08734 implements OnClickListener {
            C08734() {
            }

            public void onClick(DialogInterface dialog, int which) {
                MessageBox.this.endDialog(0);
            }
        }

        private MessageBox() {
            this.dialogResult = 0;
        }

        public int getDialogResult() {
            return this.dialogResult;
        }

        public void setDialogResult(int dialogResult) {
            this.dialogResult = dialogResult;
        }

        public void endDialog(int result) {
            setDialogResult(result);
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
        }

        public int showDialog(Builder builder, String title, String message, String btnOK) {
            builder.setTitle(title).setMessage(message).setCancelable(false).setPositiveButton(btnOK, new C08701()).show();
            this.mHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message mesg) {
                    throw new RuntimeException();
                }
            };
            try {
                Looper.getMainLooper();
                Looper.loop();
            } catch (RuntimeException re) {
                re.printStackTrace();
            }
            return this.dialogResult;
        }

        public int showDialog2(Builder builder, String title, String message, String btnOK, String btnNO) {
            builder.setTitle(title).setMessage(message).setCancelable(false).setPositiveButton(btnOK, new C08734()).setNegativeButton(btnNO, new C08723()).show();
            this.mHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message mesg) {
                    throw new RuntimeException();
                }
            };
            try {
                Looper.getMainLooper();
                Looper.loop();
            } catch (RuntimeException re) {
                re.printStackTrace();
            }
            return this.dialogResult;
        }
    }

    /* renamed from: com.e4a.runtime.对话框类$MyAdapter */
    private static class MyAdapter extends BaseAdapter {
        private MyAdapter() {
        }

        public int getCount() {
            return C0879.data.size();
        }

        public Object getItem(int position) {
            return Integer.valueOf(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView result = (TextView) convertView;
            if (result == null) {
                result = new TextView(mainActivity.getContext());
                result.setPadding(15, 15, 15, 15);
                result.setGravity(4);
            }
            result.setText((CharSequence) ((Map) C0879.data.get(position)).get("title"));
            result.setTextSize(0, C0880_应用操作类.m6713(9.0f));
            return result;
        }
    }

    private C0879() {
    }

    @SimpleFunction
    /* renamed from: 设置对话框语言类型 */
    public static void m6683(int value) {
        if (value == 1) {
            OK = "确定";
            CANCEL = "取消";
            return;
        }
        OK = "OK";
        CANCEL = "Cancel";
    }

    @SimpleFunction
    /* renamed from: 设置进度对话框可取消 */
    public static void m6685(boolean value) {
        f4333 = value;
    }

    @SimpleFunction
    /* renamed from: 显示进度对话框 */
    public static void m6678(String msg) {
        progressDialog = ProgressDialog.show(mainActivity.getContext(), bi_常量类.f6358b_空串, msg, true, f4333);
    }

    @SimpleFunction
    /* renamed from: 设置进度对话框信息 */
    public static void m6684(String msg) {
        if (progressDialog != null) {
            progressDialog.setMessage(msg);
        }
    }

    @SimpleFunction
    /* renamed from: 关闭进度对话框 */
    public static void m6671() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @SimpleFunction
    /* renamed from: 显示进度对话框2 */
    public static void m66792(String title, String msg, boolean cancelable) {
        progressDialog = new ProgressDialog(mainActivity.getContext());
        progressDialog.setTitle(title);
        progressDialog.setMessage(msg);
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(cancelable);
        progressDialog.setProgressStyle(1);
        progressDialog.setProgress(0);
        progressDialog.show();
    }

    @SimpleFunction
    /* renamed from: 设置进度对话框进度 */
    public static void m6686(int progress) {
        if (progressDialog != null) {
            progressDialog.setProgress(progress);
        }
    }

    @SimpleFunction
    /* renamed from: 信息框 */
    public static int m6668(String title, String msg, String btnOK) {
        return new MessageBox().showDialog(new Builder(mainActivity.getContext()), title, msg, btnOK);
    }

    @SimpleFunction
    /* renamed from: 信息框2 */
    public static int m66692(String title, String msg, String btnOK, String btnNO) {
        return new MessageBox().showDialog2(new Builder(mainActivity.getContext()), title, msg, btnOK, btnNO);
    }

    @SimpleFunction
    /* renamed from: 信息框3 */
    public static int m66703(String title, String message1, String message2, String btnOK, String btnNO, boolean state, BooleanReferenceParameter accept) {
        return new MessageBox3().showDialog(new Builder(mainActivity.getContext()), title, message1, message2, btnOK, btnNO, state, accept);
    }

    @SimpleFunction
    /* renamed from: 单选对话框 */
    public static String m6672(String title, String[] items, boolean[] state) {
        return new DialogBox().showDialog(new Builder(mainActivity.getContext()), title, items, state);
    }

    @SimpleFunction
    /* renamed from: 多选对话框 */
    public static String m6673(String title, String[] items, boolean[] state) {
        return new DialogBox().showDialog2(new Builder(mainActivity.getContext()), title, items, state);
    }

    @SimpleFunction
    /* renamed from: 置输入框输入方式 */
    public static void m6682(int method) {
        InputType = method;
    }

    @SimpleFunction
    /* renamed from: 输入框 */
    public static String m6687(String title, String text, BooleanReferenceParameter accept) {
        return new InputBox().showDialog(new Builder(mainActivity.getContext()), title, text, accept);
    }

    @SimpleFunction
    /* renamed from: 密码输入框 */
    public static String m6674(String 标题, String 项目一, String 项目二, String 初始内容, String 提示内容, BooleanReferenceParameter 输入结果) {
        return new InputBox().showDialog2(new Builder(mainActivity.getContext()), 标题, 项目一, 项目二, 初始内容, 提示内容, 输入结果);
    }

    /* renamed from: 是否为竖屏 */
    private static boolean m6675(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    @SimpleFunction
    /* renamed from: 颜色选择框 */
    public static int m6688(String title, int initalColor) {
        return new ColorBox().showDialog(title, initalColor);
    }

    @SimpleFunction
    /* renamed from: 置日期选择框初始日期 */
    public static void m6680(int year, int monthOfYear, int dayOfMonth) {
        mainActivity.f4273 = year;
        mainActivity.f4276 = monthOfYear - 1;
        mainActivity.f4274 = dayOfMonth;
    }

    @SimpleFunction
    /* renamed from: 显示日期选择框 */
    public static void m6676() {
        mainActivity.getContext().showDialog(0);
    }

    @SimpleFunction
    /* renamed from: 置时间选择框初始时间 */
    public static void m6681(int hourOfDay, int minute) {
        mainActivity.f4275 = hourOfDay;
        mainActivity.f4272 = minute;
    }

    @SimpleFunction
    /* renamed from: 显示时间选择框 */
    public static void m6677() {
        mainActivity.getContext().showDialog(1);
    }
}
