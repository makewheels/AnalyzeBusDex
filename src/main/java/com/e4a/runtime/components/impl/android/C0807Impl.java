package com.e4a.runtime.components.impl.android;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.ScrollView;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.C0806;
import com.e4a.runtime.components.Component;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.Layout;
import com.e4a.runtime.components.impl.android.BaseScrollView.OnScrollToBottomListener;
import com.e4a.runtime.events.EventDispatcher;

/* renamed from: com.e4a.runtime.components.impl.android.垂直滚动框Impl */
public final class C0807Impl extends ViewComponent implements C0806, ViewComponentContainer {
    public C0826Impl layout;

    /* renamed from: com.e4a.runtime.components.impl.android.垂直滚动框Impl$1 */
    class C08031 implements OnScrollToBottomListener {
        C08031() {
        }

        public void onScrollBottomListener(int scrollY, boolean isBottom) {
            C0807Impl.this.mo1444(scrollY, isBottom);
        }
    }

    public C0807Impl(ComponentContainer container) {
        super(container);
    }

    protected View createView() {
        this.layout = new C0826Impl(this);
        BaseScrollView scrollView = new BaseScrollView(mainActivity.getContext());
        scrollView.addView(getLayoutManager(), new LayoutParams(-2, -2));
        scrollView.setOnScrollToBottomLintener(new C08031());
        return scrollView;
    }

    /* renamed from: 被滚动 */
    public void mo1444(int 滚动距离, boolean 是否已滚动到顶部或底部) {
        EventDispatcher.dispatchEvent(this, "被滚动", Integer.valueOf(滚动距离), Boolean.valueOf(是否已滚动到顶部或底部));
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
    public void mo1439(ViewComponent 组件) {
        组件.mo802();
        this.layout.addComponent(组件);
        组件.getView().setLayoutParams(new AbsoluteLayout.LayoutParams(组件.mo779(), 组件.mo805(), 组件.mo781(), 组件.mo803()));
    }

    /* renamed from: 清空组件 */
    public void mo1440() {
        this.layout.getLayoutManager().removeAllViews();
    }

    /* renamed from: 取最大滚动位置 */
    public int mo1437() {
        return ((ScrollView) getView()).getMaxScrollAmount();
    }

    /* renamed from: 滚动 */
    public void mo1441(int y) {
        ((ScrollView) getView()).smoothScrollTo(0, y);
    }

    /* renamed from: 滚动到顶部 */
    public void mo1443() {
        final ScrollView scrollView = (ScrollView) getView();
        new Handler().post(new Runnable() {
            public void run() {
                scrollView.fullScroll(33);
            }
        });
    }

    /* renamed from: 滚动到底部 */
    public void mo1442() {
        final ScrollView scrollView = (ScrollView) getView();
        new Handler().post(new Runnable() {
            public void run() {
                scrollView.fullScroll(130);
            }
        });
    }

    /* renamed from: 隐藏滚动条 */
    public void mo1445() {
        ((ScrollView) getView()).setVerticalScrollBarEnabled(false);
    }

    /* renamed from: 显示滚动条 */
    public void mo1438() {
        ((ScrollView) getView()).setVerticalScrollBarEnabled(true);
    }
}
