package com.e4a.runtime.components.impl.android.n4;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.C0797;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.android.C0798Impl;
import com.e4a.runtime.components.impl.android.ViewComponent;
import com.e4a.runtime.events.EventDispatcher;
import java.io.File;
import java.io.IOException;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.n4.图片框Impl */
public class C0742Impl extends ViewComponent implements C0739, OnTouchListener, OnClickListener, OnLongClickListener {
    private String backgroundImage = bi_常量类.f6358b_空串;
    private int backgroundImage2 = -1;
    private int currX;
    private int currY;
    private int lastX;
    private int lastY;
    private GestureDetector mGestureDetector;
    /* renamed from: 方式 */
    private int f4312 = 1;
    /* renamed from: 监听器 */
    private C0798Impl f4313;
    /* renamed from: 索引 */
    private int f4314;
    /* renamed from: 绑定 */
    private boolean f4315 = false;

    /* renamed from: com.e4a.runtime.components.impl.android.n4.图片框Impl$2 */
    class C07412 extends SimpleOnGestureListener {
        C07412() {
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            int deltaX = (int) (e1.getRawX() - e2.getRawX());
            int deltaY = (int) (e1.getRawY() - e2.getRawY());
            int direction = Math.abs(deltaX) > Math.abs(deltaY) ? deltaX > 0 ? 4 : 5 : deltaY > 0 ? 2 : 3;
            C0742Impl.this.mo1151(direction);
            return true;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            int direction = Math.abs(distanceX) > Math.abs(distanceY) ? distanceX > 0.0f ? 8 : 9 : distanceY > 0.0f ? 6 : 7;
            C0742Impl.this.mo1151(direction);
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent e) {
            C0742Impl.this.mo1151(0);
            return true;
        }

        public boolean onDoubleTap(MotionEvent e) {
            C0742Impl.this.mo1151(1);
            return true;
        }
    }

    public C0742Impl(ComponentContainer container) {
        super(container);
    }

    protected View createView() {
        View view = new ImageView(mainActivity.getContext()) {
            public boolean verifyDrawable(Drawable dr) {
                super.verifyDrawable(dr);
                return true;
            }
        };
        view.setFocusable(true);
        view.setOnClickListener(this);
        this.mGestureDetector = new GestureDetector(new C07412());
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
                mo1148(this.currX, this.currY);
                if (this.f4313 != null) {
                    this.f4313.mo1429(this.f4314, this.currX, this.currY);
                    break;
                }
                break;
            case 1:
                this.lastX = this.currX;
                this.lastY = this.currY;
                mo1147(this.currX, this.currY);
                if (this.f4313 != null) {
                    this.f4313.mo1428(this.f4314, this.currX, this.currY);
                    break;
                }
                break;
            case 2:
                mo1149(this.lastX, this.lastY, this.currX, this.currY);
                if (this.f4315) {
                    this.f4313.mo1430(this.f4314, this.lastX, this.lastY, this.currX, this.currY);
                    break;
                }
                break;
        }
        this.mGestureDetector.onTouchEvent(event);
        return false;
    }

    /* renamed from: 触摸手势 */
    public void mo1151(int direction) {
        EventDispatcher.dispatchEvent(this, "触摸手势", Integer.valueOf(direction));
    }

    /* renamed from: 被按下 */
    public void mo1148(int x, int y) {
        EventDispatcher.dispatchEvent(this, "被按下", Integer.valueOf(x), Integer.valueOf(y));
    }

    /* renamed from: 被弹起 */
    public void mo1147(int x, int y) {
        EventDispatcher.dispatchEvent(this, "被弹起", Integer.valueOf(x), Integer.valueOf(y));
    }

    /* renamed from: 被移动 */
    public void mo1149(int x1, int y1, int x2, int y2) {
        EventDispatcher.dispatchEvent(this, "被移动", Integer.valueOf(x1), Integer.valueOf(y1), Integer.valueOf(x2), Integer.valueOf(y2));
    }

    public void onClick(View view) {
        mo1146();
        if (this.f4315) {
            this.f4313.mo1427(this.f4314);
        }
    }

    /* renamed from: 被单击 */
    public void mo1146() {
        EventDispatcher.dispatchEvent(this, "被单击", new Object[0]);
    }

    public boolean onLongClick(View v) {
        mo1150();
        if (this.f4315) {
            this.f4313.mo1431(this.f4314);
        }
        return false;
    }

    /* renamed from: 被长按 */
    public void mo1150() {
        EventDispatcher.dispatchEvent(this, "被长按", new Object[0]);
    }

    /* renamed from: 置组件索引 */
    public void mo1145(int id) {
        getView().setId(id);
        this.f4314 = id;
    }

    /* renamed from: 取组件索引 */
    public int mo1137() {
        return getView().getId();
    }

    /* renamed from: 绑定事件 */
    public void mo1144(C0797 listener) {
        this.f4313 = (C0798Impl) listener;
        this.f4315 = true;
    }

    /* renamed from: 显示方式 */
    public int mo1142() {
        return this.f4312;
    }

    /* renamed from: 显示方式 */
    public void mo1143(int style) {
        this.f4312 = style;
        ImageView img = (ImageView) getView();
        if (this.f4312 == 1) {
            img.setScaleType(ScaleType.FIT_XY);
        } else if (this.f4312 == 2) {
            img.setScaleType(ScaleType.CENTER_INSIDE);
        } else {
            img.setScaleType(ScaleType.FIT_CENTER);
        }
    }

    /* renamed from: 图像 */
    public String mo1138() {
        return this.backgroundImage;
    }

    /* renamed from: 图像 */
    public void mo1139(String imagePath) {
        ImageView img = (ImageView) getView();
        this.backgroundImage = imagePath;
        if (imagePath.length() > 0) {
            try {
                if (!imagePath.startsWith("/")) {
                    img.setImageDrawable(Drawable.createFromStream(mainActivity.getContext().getResources().getAssets().open(imagePath), imagePath));
                    return;
                } else if (new File(imagePath).exists()) {
                    img.setImageBitmap(BitmapFactory.decodeFile(imagePath));
                    return;
                } else {
                    return;
                }
            } catch (IOException e) {
                return;
            }
        }
        img.setImageDrawable(null);
    }

    /* renamed from: 图像2 */
    public int mo11402() {
        return this.backgroundImage2;
    }

    /* renamed from: 图像2 */
    public void mo11412(int id) {
        this.backgroundImage2 = id;
        getView().setBackgroundResource(id);
    }

    /* renamed from: 载入字节图片 */
    public void mo1152(byte[] image) {
        ImageView img = (ImageView) getView();
        if (image != null) {
            img.setImageBitmap(BitmapFactory.decodeByteArray(image, 0, image.length));
        } else {
            img.setImageBitmap(null);
        }
    }

    /* renamed from: 载入超大图片 */
    public void mo1153(String imagePath, int width, int height) {
        ImageView img = (ImageView) getView();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagePath, options);
        options.inSampleSize = calculateInSampleSize(options, width, height);
        options.inJustDecodeBounds = false;
        img.setImageBitmap(BitmapFactory.decodeFile(imagePath, options));
    }

    public int calculateInSampleSize(Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        if (height <= reqHeight && width <= reqWidth) {
            return 1;
        }
        int heightRatio = Math.round(((float) height) / ((float) reqHeight));
        int widthRatio = Math.round(((float) width) / ((float) reqWidth));
        if (heightRatio < widthRatio) {
            return heightRatio;
        }
        return widthRatio;
    }
}
