package com.e4a.runtime.components.impl.android;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class BaseHorizontalScrollView extends HorizontalScrollView {
    private OnScrollToBottomListener onScrollToBottom;

    public interface OnScrollToBottomListener {
        void onScrollBottomListener(int i, boolean z);
    }

    public BaseHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseHorizontalScrollView(Context context) {
        super(context);
    }

    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        if (this.onScrollToBottom != null) {
            this.onScrollToBottom.onScrollBottomListener(scrollX, clampedX);
        }
    }

    public void setOnScrollToBottomLintener(OnScrollToBottomListener listener) {
        this.onScrollToBottom = listener;
    }
}
