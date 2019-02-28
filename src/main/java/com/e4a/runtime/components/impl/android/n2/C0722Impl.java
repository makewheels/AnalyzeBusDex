package com.e4a.runtime.components.impl.android.n2;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.C0797;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.android.C0798Impl;
import com.e4a.runtime.components.impl.android.TextViewComponent;
import com.e4a.runtime.events.EventDispatcher;
import com.e4a.runtime.parameters.BooleanReferenceParameter;
import java.io.File;
import java.io.IOException;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.n2.编辑框Impl */
public class C0722Impl extends TextViewComponent implements C0717, OnClickListener {
    private int InputType;
    private String backgroundImage = bi_常量类.f6358b_空串;
    private int backgroundImage2 = -1;
    private float fontsize = 9.0f;
    private String hint = bi_常量类.f6358b_空串;
    private Handler mHandler = new C07203();
    /* renamed from: 次数 */
    private int f4293 = 0;
    /* renamed from: 监听器 */
    private C0798Impl f4294;
    /* renamed from: 索引 */
    private int f4295;
    /* renamed from: 绑定 */
    private boolean f4296 = false;

    /* renamed from: com.e4a.runtime.components.impl.android.n2.编辑框Impl$1 */
    class C07181 implements TextWatcher {
        C07181() {
        }

        public void afterTextChanged(Editable s) {
            if (C0722Impl.this.f4293 < 6) {
                C0722Impl.this.f4293 = C0722Impl.this.f4293 + 1;
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("text", s.toString());
            Message msg = new Message();
            msg.setData(bundle);
            msg.what = 123;
            C0722Impl.this.mHandler.sendMessage(msg);
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n2.编辑框Impl$2 */
    class C07192 implements OnKeyListener {
        C07192() {
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event.getAction() != 0) {
                return false;
            }
            BooleanReferenceParameter shield = new BooleanReferenceParameter(false);
            C0722Impl.this.mo1021(keyCode, shield);
            return shield.get();
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n2.编辑框Impl$3 */
    class C07203 extends Handler {
        C07203() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == 123) {
                String text = msg.getData().getString("text");
                C0722Impl.this.mo1012(text);
                if (C0722Impl.this.f4296) {
                    C0722Impl.this.f4294.mo1426(C0722Impl.this.f4295, text);
                }
            }
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n2.编辑框Impl$4 */
    class C07214 implements ImageGetter {
        C07214() {
        }

        public Drawable getDrawable(String source) {
            Drawable d = mainActivity.getContext().getResources().getDrawable(Integer.parseInt(source));
            d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
            return d;
        }
    }

    public C0722Impl(ComponentContainer container) {
        super(container);
    }

    protected View createView() {
        EditText view = new EditText(mainActivity.getContext());
        view.setFocusable(true);
        view.addTextChangedListener(new C07181());
        view.setOnKeyListener(new C07192());
        return view;
    }

    /* renamed from: 内容被改变 */
    public void mo1012(String 新内容) {
        EventDispatcher.dispatchEvent(this, "内容被改变", 新内容);
    }

    /* renamed from: 按下某键 */
    public void mo1021(int keycode, BooleanReferenceParameter shield) {
        EventDispatcher.dispatchEvent(this, "按下某键", Integer.valueOf(keycode), shield);
    }

    /* renamed from: 置组件索引 */
    public void mo1033(int id) {
        getView().setId(id);
        this.f4295 = id;
    }

    /* renamed from: 取组件索引 */
    public int mo1018() {
        return getView().getId();
    }

    /* renamed from: 绑定事件 */
    public void mo1028(C0797 listener) {
        this.f4294 = (C0798Impl) listener;
        this.f4296 = true;
    }

    /* renamed from: 监听被单击事件 */
    public void mo1027() {
        getView().setOnClickListener(this);
    }

    public void onClick(View view) {
        mo1039();
        if (this.f4296) {
            this.f4294.mo1427(this.f4295);
        }
    }

    /* renamed from: 被单击 */
    public void mo1039() {
        EventDispatcher.dispatchEvent(this, "被单击", new Object[0]);
    }

    /* renamed from: 输入方式 */
    public int mo1040() {
        return this.InputType;
    }

    /* renamed from: 输入方式 */
    public void mo1041(int method) {
        EditText view = (EditText) getView();
        this.InputType = method;
        switch (method) {
            case 1:
                view.setInputType(1);
                return;
            case 2:
                view.setInputType(3);
                return;
            case 3:
                view.setInputType(0);
                return;
            case 4:
                view.setInputType(131073);
                return;
            default:
                return;
        }
    }

    /* renamed from: 置多行模式 */
    public void mo1030(boolean singleline) {
        EditText view = (EditText) getView();
        view.setSingleLine(!singleline);
        view.invalidate();
    }

    /* renamed from: 显示输入法 */
    public void mo1026() {
        ((InputMethodManager) mainActivity.getContext().getSystemService("input_method")).showSoftInput((EditText) getView(), 0);
    }

    /* renamed from: 隐藏输入法 */
    public void mo1044() {
        ((InputMethodManager) mainActivity.getContext().getSystemService("input_method")).hideSoftInputFromWindow(((EditText) getView()).getApplicationWindowToken(), 0);
    }

    /* renamed from: 显示光标 */
    public void mo1025() {
        ((EditText) getView()).setCursorVisible(true);
    }

    /* renamed from: 隐藏光标 */
    public void mo1043() {
        ((EditText) getView()).setCursorVisible(false);
    }

    /* renamed from: 取光标位置 */
    public int mo1017() {
        return ((EditText) getView()).getSelectionStart();
    }

    /* renamed from: 置光标位置 */
    public void mo1029(int location) {
        ((EditText) getView()).setSelection(location);
    }

    /* renamed from: 选中文本 */
    public void mo1042(int start, int stop) {
        ((EditText) getView()).setSelection(start, stop);
    }

    /* renamed from: 全选 */
    public void mo1011() {
        ((EditText) getView()).selectAll();
    }

    /* renamed from: 加入文本 */
    public void mo1014(String text) {
        EditText view = (EditText) getView();
        view.setText(view.getText().toString() + text);
    }

    /* renamed from: 插入文本 */
    public void mo1024(int location, String text) {
        ((EditText) getView()).getText().insert(location, text);
    }

    /* renamed from: 删除文本 */
    public void mo1013(int start, int stop) {
        ((EditText) getView()).getText().delete(start, stop);
    }

    /* renamed from: 加载超文本 */
    public void mo1015(String html) {
        EditText view = (EditText) getView();
        view.setText(Html.fromHtml(html));
        view.invalidate();
    }

    /* renamed from: 加载超文本2 */
    public void mo10162(String html) {
        EditText view = (EditText) getView();
        view.setText(Html.fromHtml(html, new C07214(), null));
        view.invalidate();
    }

    /* renamed from: 置左侧图标 */
    public void mo1031(String imagePath, int 宽度, int 高度, int 边距) {
        EditText view = (EditText) getView();
        Drawable drawable = GetDrawable(imagePath);
        drawable.setBounds(0, 0, 宽度, 高度);
        view.setCompoundDrawables(drawable, null, null, null);
        view.setCompoundDrawablePadding(边距);
        view.invalidate();
    }

    private Drawable GetDrawable(String imagePath) {
        Drawable drawable = null;
        if (imagePath.length() <= 0) {
            return drawable;
        }
        if (!imagePath.startsWith("/")) {
            try {
                return Drawable.createFromStream(mainActivity.getContext().getResources().getAssets().open(imagePath), imagePath);
            } catch (IOException e) {
                return drawable;
            }
        } else if (new File(imagePath).exists()) {
            return Drawable.createFromPath(imagePath);
        } else {
            return drawable;
        }
    }

    /* renamed from: 置提示信息颜色 */
    public void mo1032(int color) {
        EditText view = (EditText) getView();
        view.setHintTextColor(color);
        view.invalidate();
    }

    /* renamed from: 提示信息 */
    public String mo1022() {
        return this.hint;
    }

    /* renamed from: 提示信息 */
    public void mo1023(String newhint) {
        this.hint = newhint;
        EditText view = (EditText) getView();
        view.setHint(this.hint);
        view.invalidate();
    }

    /* renamed from: 背景图片 */
    public String mo1034() {
        return this.backgroundImage;
    }

    /* renamed from: 背景图片 */
    public void mo1035(String imagePath) {
        this.backgroundImage = imagePath;
        Drawable drawable = null;
        if (imagePath.length() > 0) {
            if (!imagePath.startsWith("/")) {
                try {
                    drawable = Drawable.createFromStream(mainActivity.getContext().getResources().getAssets().open(imagePath), imagePath);
                } catch (IOException e) {
                }
            } else if (new File(imagePath).exists()) {
                drawable = Drawable.createFromPath(imagePath);
            }
            View view = getView();
            view.setBackgroundDrawable(drawable);
            view.invalidate();
        }
    }

    /* renamed from: 背景图片2 */
    public int mo10362() {
        return this.backgroundImage2;
    }

    /* renamed from: 背景图片2 */
    public void mo10372(int id) {
        this.backgroundImage2 = id;
        getView().setBackgroundResource(id);
    }

    /* renamed from: 字体大小 */
    public float mo1019() {
        return this.fontsize;
    }

    /* renamed from: 字体大小 */
    public void mo1020(float size) {
        EditText view = (EditText) getView();
        if (C0880_应用操作类.m6699()) {
            view.setTextSize(0, C0880_应用操作类.m6713(size));
        } else {
            view.setTextSize(size);
        }
        this.fontsize = size;
    }

    /* renamed from: 自定义字体 */
    public void mo1038(String name) {
        Typeface type;
        EditText view = (EditText) getView();
        if (name.startsWith("/")) {
            type = Typeface.createFromFile(name);
        } else {
            type = Typeface.createFromAsset(mainActivity.getContext().getAssets(), name);
        }
        view.setTypeface(type);
    }
}
