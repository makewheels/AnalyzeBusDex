package com.e4a.runtime.components.impl.android;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.components.C0642;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.Layout;
import com.e4a.runtime.components.VisibleComponent;
import com.e4a.runtime.components.impl.ComponentImpl;
import com.e4a.runtime.components.impl.android.util.ViewUtil;
import com.e4a.runtime.errors.IndexOutOfBoundsError;
import com.e4a.runtime.events.EventDispatcher;

public abstract class ViewComponent extends ComponentImpl implements VisibleComponent, OnFocusChangeListener {
    private int backgroundColor;
    private int column = -1;
    private int currX;
    private int currY;
    private int height;
    private int lastX;
    private int lastY;
    private int left;
    private int row = -1;
    private int top;
    private final View view = createView();
    private int width;
    /* renamed from: 特效重复模式 */
    private int f3943 = -1;
    /* renamed from: 特效重复次数 */
    private int f3944 = -1;

    /* renamed from: com.e4a.runtime.components.impl.android.ViewComponent$1 */
    class C06841 implements AnimationListener {
        C06841() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            ViewComponent.this.mo784();
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.ViewComponent$2 */
    class C06852 implements AnimationListener {
        C06852() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            ViewComponent.this.mo784();
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.ViewComponent$3 */
    class C06863 implements AnimationListener {
        C06863() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            ViewComponent.this.mo784();
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.ViewComponent$4 */
    class C06874 implements AnimationListener {
        C06874() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            ViewComponent.this.mo784();
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.ViewComponent$5 */
    class C06885 implements AnimationListener {
        C06885() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            ViewComponent.this.mo784();
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.ViewComponent$6 */
    class C06896 implements AnimationListener {
        C06896() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            ViewComponent.this.mo784();
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.ViewComponent$7 */
    class C06907 implements AnimationListener {
        C06907() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            ViewComponent.this.mo784();
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.ViewComponent$8 */
    class C06918 implements AnimationListener {
        C06918() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            ViewComponent.this.mo792();
        }
    }

    protected abstract View createView();

    public View getView() {
        return this.view;
    }

    protected ViewComponent(ComponentContainer container) {
        super(container);
        if (this.view != null) {
            getComponentContainer().addComponent(this);
            this.view.setOnFocusChangeListener(this);
        }
    }

    public void onFocusChange(View previouslyFocused, boolean gainFocus) {
        if (gainFocus) {
            mo799();
        } else {
            mo778();
        }
    }

    /* renamed from: 获得焦点 */
    public void mo799() {
        EventDispatcher.dispatchEvent(this, "获得焦点", new Object[0]);
    }

    /* renamed from: 失去焦点 */
    public void mo778() {
        EventDispatcher.dispatchEvent(this, "失去焦点", new Object[0]);
    }

    /* renamed from: 列 */
    public int mo766() {
        return this.column;
    }

    /* renamed from: 列 */
    public void mo767(int newColumn) {
        if (this.column != -1) {
            throw new IndexOutOfBoundsError();
        }
        this.column = newColumn;
        if (this.row != -1) {
            Layout layout = getComponentContainer().getLayout();
            if (layout instanceof C0828Impl) {
                ((C0828Impl) layout).placeComponent(this);
            }
        }
    }

    /* renamed from: 行 */
    public int mo800() {
        return this.row;
    }

    /* renamed from: 行 */
    public void mo801(int newRow) {
        if (this.row != -1) {
            throw new IndexOutOfBoundsError();
        }
        this.row = newRow;
        if (this.column != -1) {
            Layout layout = getComponentContainer().getLayout();
            if (layout instanceof C0828Impl) {
                ((C0828Impl) layout).placeComponent(this);
            }
        }
    }

    /* renamed from: 宽度 */
    public int mo779() {
        return this.width;
    }

    /* renamed from: 宽度 */
    public void mo780(int newWidth) {
        this.width = newWidth;
        Layout layout = getComponentContainer().getLayout();
        if (layout instanceof C0826Impl) {
            ((C0826Impl) layout).placeComponent(this);
        } else {
            ViewUtil.setWidth(getView(), newWidth);
        }
    }

    /* renamed from: 高度 */
    public int mo805() {
        return this.height;
    }

    /* renamed from: 高度 */
    public void mo806(int newHeight) {
        this.height = newHeight;
        Layout layout = getComponentContainer().getLayout();
        if (layout instanceof C0826Impl) {
            ((C0826Impl) layout).placeComponent(this);
        } else {
            ViewUtil.setHeight(getView(), newHeight);
        }
    }

    /* renamed from: 左边 */
    public int mo781() {
        return this.left;
    }

    /* renamed from: 左边 */
    public void mo782(int newLeft) {
        this.left = newLeft;
        Layout layout = getComponentContainer().getLayout();
        if (layout instanceof C0826Impl) {
            ((C0826Impl) layout).placeComponent(this);
        }
    }

    /* renamed from: 顶边 */
    public int mo803() {
        return this.top;
    }

    /* renamed from: 顶边 */
    public void mo804(int newTop) {
        this.top = newTop;
        Layout layout = getComponentContainer().getLayout();
        if (layout instanceof C0826Impl) {
            ((C0826Impl) layout).placeComponent(this);
        }
    }

    /* renamed from: 移动 */
    public void mo790移动(int newLeft, int newTop, int newWidth, int newHeight) {
        this.left = newLeft;
        this.top = newTop;
        this.width = newWidth;
        this.height = newHeight;
        Layout layout = getComponentContainer().getLayout();
        if (layout instanceof C0826Impl) {
            ((C0826Impl) layout).placeComponent(this);
        }
    }

    /* renamed from: 到顶层 */
    public void mo768() {
        View v = getView();
        v.bringToFront();
        if (v.getVisibility() == 0) {
            v.setVisibility(4);
            v.setVisibility(0);
            return;
        }
        v.setVisibility(0);
        v.setVisibility(4);
    }

    /* renamed from: 取宽度 */
    public int mo770() {
        View view = getView();
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredWidth();
    }

    /* renamed from: 取高度 */
    public int mo771() {
        View view = getView();
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    /* renamed from: 刷新 */
    public void mo769() {
        getView().invalidate();
    }

    /* renamed from: 销毁 */
    public View mo802() {
        View view = getView();
        if (view.getParent() != null) {
            ((ViewGroup) getView().getParent()).removeView(view);
        }
        return view;
    }

    /* renamed from: 开启特效 */
    public void mo783(int type, int time, boolean keep) {
        Animation animationSet;
        switch (type) {
            case 1:
                animationSet = new AnimationSet(true);
                RotateAnimation rotate_animation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                animationSet.addAnimation(rotate_animation);
                rotate_animation.setDuration((long) time);
                animationSet.setFillAfter(keep);
                if (this.f3943 > -1) {
                    rotate_animation.setRepeatMode(this.f3943);
                }
                if (this.f3944 > -1) {
                    rotate_animation.setRepeatCount(this.f3944);
                }
                rotate_animation.setAnimationListener(new C06841());
                getView().startAnimation(animationSet);
                return;
            case 2:
                animationSet = new AnimationSet(true);
                ScaleAnimation scale_animation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                animationSet.addAnimation(scale_animation);
                scale_animation.setDuration((long) time);
                animationSet.setFillAfter(keep);
                if (this.f3943 > -1) {
                    scale_animation.setRepeatMode(this.f3943);
                }
                if (this.f3944 > -1) {
                    scale_animation.setRepeatCount(this.f3944);
                }
                scale_animation.setAnimationListener(new C06852());
                getView().startAnimation(animationSet);
                return;
            case 3:
                animationSet = new AnimationSet(true);
                AlphaAnimation alpha_animation = new AlphaAnimation(1.0f, 0.0f);
                animationSet.addAnimation(alpha_animation);
                alpha_animation.setDuration((long) time);
                animationSet.setFillAfter(keep);
                if (this.f3943 > -1) {
                    alpha_animation.setRepeatMode(this.f3943);
                }
                if (this.f3944 > -1) {
                    alpha_animation.setRepeatCount(this.f3944);
                }
                alpha_animation.setAnimationListener(new C06863());
                getView().startAnimation(animationSet);
                return;
            case 4:
                animationSet = new AnimationSet(true);
                RotateAnimation rotate_animation2 = new RotateAnimation(360.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                animationSet.addAnimation(rotate_animation2);
                rotate_animation2.setDuration((long) time);
                animationSet.setFillAfter(keep);
                if (this.f3943 > -1) {
                    rotate_animation2.setRepeatMode(this.f3943);
                }
                if (this.f3944 > -1) {
                    rotate_animation2.setRepeatCount(this.f3944);
                }
                rotate_animation2.setAnimationListener(new C06874());
                getView().startAnimation(animationSet);
                return;
            case 5:
                animationSet = new AnimationSet(true);
                ScaleAnimation scale_animation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                animationSet.addAnimation(scale_animation2);
                scale_animation2.setDuration((long) time);
                animationSet.setFillAfter(keep);
                if (this.f3943 > -1) {
                    scale_animation2.setRepeatMode(this.f3943);
                }
                if (this.f3944 > -1) {
                    scale_animation2.setRepeatCount(this.f3944);
                }
                scale_animation2.setAnimationListener(new C06885());
                getView().startAnimation(animationSet);
                return;
            case 6:
                animationSet = new AnimationSet(true);
                AlphaAnimation alpha_animation2 = new AlphaAnimation(0.0f, 1.0f);
                animationSet.addAnimation(alpha_animation2);
                alpha_animation2.setDuration((long) time);
                animationSet.setFillAfter(keep);
                if (this.f3943 > -1) {
                    alpha_animation2.setRepeatMode(this.f3943);
                }
                if (this.f3944 > -1) {
                    alpha_animation2.setRepeatCount(this.f3944);
                }
                alpha_animation2.setAnimationListener(new C06896());
                getView().startAnimation(animationSet);
                return;
            default:
                return;
        }
    }

    /* renamed from: 开启特效完毕 */
    public void mo784() {
        EventDispatcher.dispatchEvent(this, "开启特效完毕", new Object[0]);
    }

    /* renamed from: 旋转特效 */
    public void mo785(float fromDegrees, float toDegrees, int time, boolean keep) {
        AnimationSet rotate_animation_set = new AnimationSet(true);
        RotateAnimation rotate_animation = new RotateAnimation(fromDegrees, toDegrees, 1, 0.5f, 1, 0.5f);
        rotate_animation_set.addAnimation(rotate_animation);
        rotate_animation.setDuration((long) time);
        rotate_animation_set.setFillAfter(keep);
        if (this.f3943 > -1) {
            rotate_animation.setRepeatMode(this.f3943);
        }
        if (this.f3944 > -1) {
            rotate_animation.setRepeatCount(this.f3944);
        }
        rotate_animation.setAnimationListener(new C06907());
        getView().startAnimation(rotate_animation_set);
    }

    /* renamed from: 移动特效 */
    public void mo791(int xfrom, int xto, int yfrom, int yto, int time, boolean keep) {
        AnimationSet translate_animation_set = new AnimationSet(true);
        TranslateAnimation translate_animation = new TranslateAnimation((float) xfrom, (float) xto, (float) yfrom, (float) yto);
        translate_animation_set.addAnimation(translate_animation);
        translate_animation.setDuration((long) time);
        translate_animation_set.setFillAfter(keep);
        if (this.f3943 > -1) {
            translate_animation.setRepeatMode(this.f3943);
        }
        if (this.f3944 > -1) {
            translate_animation.setRepeatCount(this.f3944);
        }
        translate_animation.setAnimationListener(new C06918());
        getView().startAnimation(translate_animation_set);
    }

    /* renamed from: 移动特效完毕 */
    public void mo792() {
        EventDispatcher.dispatchEvent(this, "移动特效完毕", new Object[0]);
    }

    /* renamed from: 置特效重复模式 */
    public void mo795(int repeatMode, int repeatCount) {
        this.f3943 = repeatMode;
        this.f3944 = repeatCount;
    }

    /* renamed from: 电视机关闭特效 */
    public void mo788() {
        getView().startAnimation(new TVOffAnimation());
    }

    /* renamed from: 获取焦点 */
    public void mo798() {
        getView().requestFocus();
    }

    /* renamed from: 清除焦点 */
    public void mo786() {
        getView().clearFocus();
    }

    /* renamed from: 可停留焦点 */
    public boolean mo773() {
        return getView().isFocusable();
    }

    /* renamed from: 可停留焦点 */
    public void mo772(boolean focusable) {
        getView().setFocusable(focusable);
    }

    /* renamed from: 可用 */
    public boolean mo775() {
        return getView().isEnabled();
    }

    /* renamed from: 可用 */
    public void mo774(boolean enabled) {
        getView().setEnabled(enabled);
    }

    /* renamed from: 可视 */
    public void mo776_可视(boolean visiable) {
        View view = getView();
        if (visiable) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }

    /* renamed from: 可视 */
    public boolean mo777() {
        if (getView().getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: 背景颜色 */
    public int mo796() {
        return this.backgroundColor;
    }

    /* renamed from: 背景颜色 */
    public void mo797_背景颜色(int argb) {
        this.backgroundColor = argb;
        getView().setBackgroundColor(argb);
    }

    /* renamed from: 绑定弹出菜单 */
    public void mo793() {
        C0880_应用操作类.m6700(getView());
    }

    /* renamed from: 监听绘制 */
    public void mo789() {
        final View view = getView();
        view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ViewComponent.this.mo794(view.getWidth(), view.getHeight());
            }
        });
    }

    /* renamed from: 绘制完毕 */
    public void mo794(int 宽度, int 高度) {
        EventDispatcher.dispatchEvent(this, "绘制完毕", Integer.valueOf(宽度), Integer.valueOf(高度));
    }

    /* renamed from: 父组件 */
    public void mo787(C0642 param面板) {
        C0643Impl local面板Impl = (C0643Impl) param面板;
        if (getView().getParent() != null) {
            ((ViewGroup) getView().getParent()).removeView(getView());
        }
        ((LayoutImpl) local面板Impl.getLayout()).getLayoutManager().addView(getView(), new LayoutParams(-1, -1));
    }
}
