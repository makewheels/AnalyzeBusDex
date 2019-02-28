package com.e4a.runtime.components.impl.android.n1;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.C0797;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.android.C0798Impl;
import com.e4a.runtime.components.impl.android.TextViewComponent;
import com.e4a.runtime.events.EventDispatcher;
import java.io.File;
import java.io.IOException;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.n1.按钮Impl */
public class C0695Impl extends TextViewComponent implements C0693, OnTouchListener, OnClickListener, OnLongClickListener {
    private String backgroundImage = bi_常量类.f6358b_空串;
    private int backgroundImage2 = -1;
    private int currX;
    private int currY;
    private String downImage = bi_常量类.f6358b_空串;
    private int downImage2 = -1;
    private float fontsize = 9.0f;
    private int lastX;
    private int lastY;
    private GestureDetector mGestureDetector;
    private String upImage = bi_常量类.f6358b_空串;
    private int upImage2 = -1;
    /* renamed from: 监听器 */
    private C0798Impl f4284;
    /* renamed from: 索引 */
    private int f4285;
    /* renamed from: 绑定 */
    private boolean f4286 = false;

    /* renamed from: com.e4a.runtime.components.impl.android.n1.按钮Impl$1 */
    class C06941 extends SimpleOnGestureListener {
        C06941() {
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            int deltaX = (int) (e1.getRawX() - e2.getRawX());
            int deltaY = (int) (e1.getRawY() - e2.getRawY());
            int direction = Math.abs(deltaX) > Math.abs(deltaY) ? deltaX > 0 ? 4 : 5 : deltaY > 0 ? 2 : 3;
            C0695Impl.this.mo923(direction);
            return true;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            int direction = Math.abs(distanceX) > Math.abs(distanceY) ? distanceX > 0.0f ? 8 : 9 : distanceY > 0.0f ? 6 : 7;
            C0695Impl.this.mo923(direction);
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent e) {
            C0695Impl.this.mo923(0);
            return true;
        }

        public boolean onDoubleTap(MotionEvent e) {
            C0695Impl.this.mo923(1);
            return true;
        }
    }

    public C0695Impl(ComponentContainer container) {
        super(container);
    }

    protected View createView() {
        Button view = new Button(mainActivity.getContext());
        view.setOnClickListener(this);
        view.setFocusable(true);
        this.mGestureDetector = new GestureDetector(new C06941());
        view.setLongClickable(true);
        view.setOnTouchListener(this);
        view.setOnLongClickListener(this);
        return view;
    }

    public boolean onTouch(View view, MotionEvent event) {
        this.lastX = this.currX;
        this.lastY = this.currY;
        this.currX = (int) event.getRawX();
        this.currY = (int) event.getRawY();
        switch (event.getAction()) {
            case 0:
                this.lastX = this.currX;
                this.lastY = this.currY;
                if (!this.downImage.equals(bi_常量类.f6358b_空串)) {
                    mo902(this.downImage);
                } else if (this.downImage2 != -1) {
                    mo9042(this.downImage2);
                }
                mo920(this.currX, this.currY);
                if (this.f4284 != null) {
                    this.f4284.mo1429(this.f4285, this.currX, this.currY);
                    break;
                }
                break;
            case 1:
                this.lastX = this.currX;
                this.lastY = this.currY;
                if (!this.upImage.equals(bi_常量类.f6358b_空串)) {
                    mo902(this.upImage);
                } else if (this.upImage2 != -1) {
                    mo9042(this.upImage2);
                }
                mo919(this.currX, this.currY);
                if (this.f4284 != null) {
                    this.f4284.mo1428(this.f4285, this.currX, this.currY);
                    break;
                }
                break;
            case 2:
                mo921(this.lastX, this.lastY, this.currX, this.currY);
                if (this.f4286) {
                    this.f4284.mo1430(this.f4285, this.lastX, this.lastY, this.currX, this.currY);
                    break;
                }
                break;
        }
        this.mGestureDetector.onTouchEvent(event);
        return false;
    }

    /* renamed from: 触摸手势 */
    public void mo923(int direction) {
        EventDispatcher.dispatchEvent(this, "触摸手势", Integer.valueOf(direction));
    }

    /* renamed from: 被按下 */
    public void mo920(int x, int y) {
        EventDispatcher.dispatchEvent(this, "被按下", Integer.valueOf(x), Integer.valueOf(y));
    }

    /* renamed from: 被弹起 */
    public void mo919(int x, int y) {
        EventDispatcher.dispatchEvent(this, "被弹起", Integer.valueOf(x), Integer.valueOf(y));
    }

    /* renamed from: 被移动 */
    public void mo921(int x1, int y1, int x2, int y2) {
        EventDispatcher.dispatchEvent(this, "被移动", Integer.valueOf(x1), Integer.valueOf(y1), Integer.valueOf(x2), Integer.valueOf(y2));
    }

    public void onClick(View view) {
        mo918();
        if (this.f4286) {
            this.f4284.mo1427(this.f4285);
        }
    }

    /* renamed from: 被单击 */
    public void mo918() {
        EventDispatcher.dispatchEvent(this, "被单击", new Object[0]);
    }

    public boolean onLongClick(View v) {
        mo922();
        if (this.f4286) {
            this.f4284.mo1431(this.f4285);
        }
        return false;
    }

    /* renamed from: 被长按 */
    public void mo922() {
        EventDispatcher.dispatchEvent(this, "被长按", new Object[0]);
    }

    /* renamed from: 置组件索引 */
    public void mo916(int id) {
        getView().setId(id);
        this.f4285 = id;
    }

    /* renamed from: 取组件索引 */
    public int mo900() {
        return getView().getId();
    }

    /* renamed from: 绑定事件 */
    public void mo915(C0797 listener) {
        this.f4284 = (C0798Impl) listener;
        this.f4286 = true;
    }

    /* renamed from: 图片 */
    public String mo901() {
        return this.backgroundImage;
    }

    /* renamed from: 图片 */
    public void mo902(String imagePath) {
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

    /* renamed from: 图片2 */
    public int mo9032() {
        return this.backgroundImage2;
    }

    /* renamed from: 图片2 */
    public void mo9042(int id) {
        this.backgroundImage2 = id;
        getView().setBackgroundResource(id);
    }

    /* renamed from: 按下图片 */
    public String mo911() {
        return this.downImage;
    }

    /* renamed from: 按下图片 */
    public void mo912(String image) {
        this.downImage = image;
    }

    /* renamed from: 按下图片2 */
    public int mo9132() {
        return this.downImage2;
    }

    /* renamed from: 按下图片2 */
    public void mo9142(int image) {
        this.downImage2 = image;
    }

    /* renamed from: 弹起图片 */
    public String mo907() {
        return this.upImage;
    }

    /* renamed from: 弹起图片 */
    public void mo908(String image) {
        this.upImage = image;
    }

    /* renamed from: 弹起图片2 */
    public int mo9092() {
        return this.upImage2;
    }

    /* renamed from: 弹起图片2 */
    public void mo9102(int image) {
        this.upImage2 = image;
    }

    /* renamed from: 字体大小 */
    public float mo905() {
        return this.fontsize;
    }

    /* renamed from: 字体大小 */
    public void mo906(float size) {
        Button button = (Button) getView();
        if (C0880_应用操作类.m6699()) {
            button.setTextSize(0, C0880_应用操作类.m6713(size));
        } else {
            button.setTextSize(size);
        }
        this.fontsize = size;
    }

    /* renamed from: 自定义字体 */
    public void mo917(String name) {
        Typeface type;
        Button view = (Button) getView();
        if (name.startsWith("/")) {
            type = Typeface.createFromFile(name);
        } else {
            type = Typeface.createFromAsset(mainActivity.getContext().getAssets(), name);
        }
        view.setTypeface(type);
    }
}
