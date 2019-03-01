package com.e4a.runtime.components.impl.android.n3;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.TextUtils.TruncateAt;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.C0797;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.android.C0798Impl;
import com.e4a.runtime.components.impl.android.TextViewComponent;
import com.e4a.runtime.events.EventDispatcher;

/* renamed from: com.e4a.runtime.components.impl.android.n3.标签Impl */
public class C0725Impl extends TextViewComponent implements C0723, OnClickListener, OnLongClickListener {
    private float fontsize = 9.0f;
    /* renamed from: 监听器 */
    private C0798Impl f4297;
    /* renamed from: 索引 */
    private int f4298;
    /* renamed from: 绑定 */
    private boolean f4299 = false;

    /* renamed from: com.e4a.runtime.components.impl.android.n3.标签Impl$1 */
    class C07241 implements ImageGetter {
        C07241() {
        }

        public Drawable getDrawable(String source) {
            Drawable d = mainActivity.getContext().getResources().getDrawable(Integer.parseInt(source));
            d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
            return d;
        }
    }

    public C0725Impl(ComponentContainer container) {
        super(container);
    }

    protected View createView() {
        TextView view = new TextView(mainActivity.getContext());
        view.setEllipsize(TruncateAt.valueOf("END"));
        view.setFocusable(true);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return view;
    }

    /* renamed from: 被单击 */
    public void mo1056() {
        EventDispatcher.dispatchEvent(this, "被单击", new Object[0]);
    }

    public void onClick(View view) {
        mo1056();
        if (this.f4299) {
            this.f4297.mo1427(this.f4298);
        }
    }

    public boolean onLongClick(View v) {
        mo1057();
        if (this.f4299) {
            this.f4297.mo1431(this.f4298);
        }
        return false;
    }

    /* renamed from: 被长按 */
    public void mo1057() {
        EventDispatcher.dispatchEvent(this, "被长按", new Object[0]);
    }

    /* renamed from: 置组件索引 */
    public void mo1053(int id) {
        getView().setId(id);
        this.f4298 = id;
    }

    /* renamed from: 取组件索引 */
    public int mo1047() {
        return getView().getId();
    }

    /* renamed from: 绑定事件 */
    public void mo1052(C0797 listener) {
        this.f4297 = (C0798Impl) listener;
        this.f4299 = true;
    }

    /* renamed from: 添加滚动条 */
    public void mo1051() {
        ((TextView) getView()).setMovementMethod(new ScrollingMovementMethod());
    }

    /* renamed from: 加载超文本 */
    public void mo1045(String html) {
        TextView view = (TextView) getView();
        view.setText(Html.fromHtml(html));
        view.invalidate();
    }

    /* renamed from: 加载超文本2 */
    public void mo10462(String html) {
        TextView view = (TextView) getView();
        view.setText(Html.fromHtml(html, new C07241(), null));
        view.invalidate();
    }

    /* renamed from: 字体大小 */
    public float mo1048() {
        return this.fontsize;
    }

    /* renamed from: 字体大小 */
    public void mo1049_字体大小(float size) {
        TextView view = (TextView) getView();
        if (C0880_应用操作类.m6699()) {
            view.setTextSize(0, C0880_应用操作类.m6713(size));
        } else {
            view.setTextSize(size);
        }
        this.fontsize = size;
    }

    /* renamed from: 自定义字体 */
    public void mo1055(String name) {
        Typeface type;
        TextView view = (TextView) getView();
        if (name.startsWith("/")) {
            type = Typeface.createFromFile(name);
        } else {
            type = Typeface.createFromAsset(mainActivity.getContext().getAssets(), name);
        }
        view.setTypeface(type);
    }

    /* renamed from: 置背景图片 */
    public void mo1054(int id) {
        View view = getView();
        view.setBackgroundResource(id);
        view.invalidate();
    }

    /* renamed from: 添加删除线 */
    public void mo1050() {
        TextView view = (TextView) getView();
        view.getPaint().setFlags(16);
        view.invalidate();
    }
}
