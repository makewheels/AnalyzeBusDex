package com.e4a.runtime.components.impl.android;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.HorizontalScrollView;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.C0821;
import com.e4a.runtime.components.Component;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.Layout;
import com.e4a.runtime.components.impl.android.BaseHorizontalScrollView.OnScrollToBottomListener;
import com.e4a.runtime.events.EventDispatcher;

/* renamed from: com.e4a.runtime.components.impl.android.水平滚动框Impl */
public final class C0822Impl extends ViewComponent implements C0821, ViewComponentContainer {
    public C0826Impl layout;

    /* renamed from: com.e4a.runtime.components.impl.android.水平滚动框Impl$1 */
    class C08181 implements OnScrollToBottomListener {
        C08181() {
        }

        public void onScrollBottomListener(int scrollX, boolean isBottom) {
            C0822Impl.this.mo1470(scrollX, isBottom);
        }
    }

    public C0822Impl(ComponentContainer container) {
        super(container);
    }

    protected View createView() {
        this.layout = new C0826Impl(this);
        BaseHorizontalScrollView scrollView = new BaseHorizontalScrollView(mainActivity.getContext());
        scrollView.addView(getLayoutManager(), new LayoutParams(-2, -2));
        scrollView.setOnScrollToBottomLintener(new C08181());
        return scrollView;
    }

    /* renamed from: 被滚动 */
    public void mo1470(int 滚动距离, boolean 是否已滚动到左边或右边) {
        EventDispatcher.dispatchEvent(this, "被滚动", Integer.valueOf(滚动距离), Boolean.valueOf(是否已滚动到左边或右边));
    }

    public ViewGroup getLayoutManager() {
        return this.layout.getLayoutManager();
    }

    public Layout getLayout() {
        return this.layout;
    }

    public void addComponent(Component component) {
        this.layout.addComponent((ViewComponent) component);
    }

    /* renamed from: 添加组件 */
    public void mo1465(ViewComponent 组件) {
        组件.mo802();
        this.layout.addComponent(组件);
        组件.getView().setLayoutParams(new AbsoluteLayout.LayoutParams(组件.mo779(), 组件.mo805(), 组件.mo781(), 组件.mo803()));
    }

    /* renamed from: 清空组件 */
    public void mo1466() {
        this.layout.getLayoutManager().removeAllViews();
    }

    /* renamed from: 取最大滚动位置 */
    public int mo1463() {
        return ((HorizontalScrollView) getView()).getMaxScrollAmount() * 2;
    }

    /* renamed from: 滚动 */
    public void mo1467(int x) {
        ((HorizontalScrollView) getView()).smoothScrollTo(x, 0);
    }

    /* renamed from: 滚动到左边 */
    public void mo1469() {
        final HorizontalScrollView scrollView = (HorizontalScrollView) getView();
        new Handler().post(new Runnable() {
            public void run() {
                scrollView.fullScroll(17);
            }
        });
    }

    /* renamed from: 滚动到右边 */
    public void mo1468() {
        final HorizontalScrollView scrollView = (HorizontalScrollView) getView();
        new Handler().post(new Runnable() {
            public void run() {
                scrollView.fullScroll(66);
            }
        });
    }

    /* renamed from: 隐藏滚动条 */
    public void mo1471() {
        ((HorizontalScrollView) getView()).setHorizontalScrollBarEnabled(false);
    }

    /* renamed from: 显示滚动条 */
    public void mo1464() {
        ((HorizontalScrollView) getView()).setHorizontalScrollBarEnabled(true);
    }
}
