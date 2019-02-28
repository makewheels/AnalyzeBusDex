package com.e4a.runtime.components.impl.android;

import android.graphics.Matrix;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class TVOffAnimation extends Animation {
    private int halfHeight;
    private int halfWidth;

    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setDuration(500);
        setFillAfter(true);
        this.halfWidth = width / 2;
        this.halfHeight = height / 2;
        setInterpolator(new AccelerateDecelerateInterpolator());
    }

    protected void applyTransformation(float interpolatedTime, Transformation t) {
        Matrix matrix = t.getMatrix();
        if (((double) interpolatedTime) < 0.8d) {
            matrix.preScale((0.625f * interpolatedTime) + 1.0f, (1.0f - (interpolatedTime / 0.8f)) + 0.01f, (float) this.halfWidth, (float) this.halfHeight);
        } else {
            matrix.preScale(7.5f * (1.0f - interpolatedTime), 0.01f, (float) this.halfWidth, (float) this.halfHeight);
        }
    }
}
