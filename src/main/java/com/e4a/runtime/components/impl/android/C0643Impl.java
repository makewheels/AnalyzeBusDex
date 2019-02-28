package com.e4a.runtime.components.impl.android;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.C0642;
import com.e4a.runtime.components.Component;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.Layout;
import com.e4a.runtime.variants.ObjectVariant;
import com.e4a.runtime.variants.Variant;
import java.io.File;
import java.io.IOException;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.面板Impl */
public class C0643Impl extends ViewComponent implements C0642, ViewComponentContainer {
    private int backgroundColor;
    private String backgroundImage = bi_常量类.f6358b_空串;
    private int backgroundImage2 = -1;
    private Variant layout;
    private boolean layoutFixed = false;
    protected LayoutImpl viewLayout;
    private boolean visiable;

    public C0643Impl(ComponentContainer container) {
        super(container);
    }

    protected View createView() {
        return null;
    }

    /* renamed from: 背景图片 */
    public String mo816() {
        return this.backgroundImage;
    }

    /* renamed from: 背景图片 */
    public void mo817(String imagePath) {
        if (imagePath.length() > 0) {
            this.backgroundImage = imagePath;
            Drawable drawable = null;
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
    public int mo8182() {
        return this.backgroundImage2;
    }

    /* renamed from: 背景图片2 */
    public void mo8192(int id) {
        this.backgroundImage2 = id;
        getView().setBackgroundResource(id);
    }

    /* renamed from: 背景颜色 */
    public int mo796() {
        return this.backgroundColor;
    }

    /* renamed from: 背景颜色 */
    public void mo797(int argb) {
        this.backgroundColor = argb;
        if (this.viewLayout != null) {
            this.viewLayout.getLayoutManager().setBackgroundColor(argb);
        }
    }

    /* renamed from: 布局 */
    public Variant mo812() {
        return this.layout;
    }

    /* renamed from: 布局 */
    public void mo813(Variant layoutType) {
        if (this.layoutFixed) {
            throw new IllegalStateException("The Layout property may not be changed after children components have been added to its container");
        }
        switch (layoutType.getInteger()) {
            case 1:
                this.viewLayout = new C0824Impl(this);
                break;
            case 2:
                this.viewLayout = new C0828Impl(this);
                break;
            case 3:
                this.viewLayout = new C0800Impl(this);
                break;
            case 4:
                this.viewLayout = new C0826Impl(this);
                break;
            default:
                throw new IllegalArgumentException("Unknown layout");
        }
        this.layout = ObjectVariant.getObjectVariant(this.viewLayout);
        mo797(this.backgroundColor);
        addToContainer();
    }

    protected void addToContainer() {
        getComponentContainer().addComponent(this);
    }

    public ViewGroup getLayoutManager() {
        return this.viewLayout.getLayoutManager();
    }

    public void addComponent(Component component) {
        this.layoutFixed = true;
        this.viewLayout.addComponent((ViewComponent) component);
    }

    public Layout getLayout() {
        return this.viewLayout;
    }

    public View getView() {
        return this.viewLayout == null ? null : this.viewLayout.getLayoutManager();
    }

    /* renamed from: 添加组件 */
    public void mo814(ViewComponent 组件) {
        组件.mo802();
        this.viewLayout.addComponent(组件);
        if (this.viewLayout instanceof C0826Impl) {
            组件.getView().setLayoutParams(new LayoutParams(组件.mo779(), 组件.mo805(), 组件.mo781(), 组件.mo803()));
        } else if (this.viewLayout instanceof C0824Impl) {
            组件.getView().setLayoutParams(new LinearLayout.LayoutParams(组件.mo779(), 组件.mo805()));
        } else if (this.viewLayout instanceof C0800Impl) {
            组件.getView().setLayoutParams(new FrameLayout.LayoutParams(组件.mo779(), 组件.mo805()));
        } else if (this.viewLayout instanceof C0828Impl) {
            组件.getView().setLayoutParams(new TableLayout.LayoutParams(-2, -2));
        }
    }

    /* renamed from: 清空组件 */
    public void mo815() {
        this.viewLayout.getLayoutManager().removeAllViews();
    }
}
