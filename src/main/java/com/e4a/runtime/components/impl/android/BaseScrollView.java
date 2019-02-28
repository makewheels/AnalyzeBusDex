package com.e4a.runtime.components.impl.android;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class BaseScrollView extends ScrollView {
    private OnScrollToBottomListener onScrollToBottom;

    public interface OnScrollToBottomListener {
        void onScrollBottomListener(int i, boolean z);
    }

    public BaseScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseScrollView(Context context) {
        super(context);
    }

    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        if (this.onScrollToBottom != null) {
            this.onScrollToBottom.onScrollBottomListener(scrollY, clampedY);
        }
    }

    public void setOnScrollToBottomLintener(OnScrollToBottomListener listener) {
        this.onScrollToBottom = listener;
    }
}
