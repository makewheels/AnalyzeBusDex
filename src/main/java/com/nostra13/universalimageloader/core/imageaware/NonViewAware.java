package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

public class NonViewAware implements ImageAware {
    protected final ImageSize imageSize;
    protected final String imageUri;
    protected final ViewScaleType scaleType;

    public NonViewAware(ImageSize imageSize, ViewScaleType scaleType) {
        this(null, imageSize, scaleType);
    }

    public NonViewAware(String imageUri, ImageSize imageSize, ViewScaleType scaleType) {
        if (imageSize == null) {
            throw new IllegalArgumentException("imageSize must not be null");
        } else if (scaleType == null) {
            throw new IllegalArgumentException("scaleType must not be null");
        } else {
            this.imageUri = imageUri;
            this.imageSize = imageSize;
            this.scaleType = scaleType;
        }
    }

    public int getWidth() {
        return this.imageSize.getWidth();
    }

    public int getHeight() {
        return this.imageSize.getHeight();
    }

    public ViewScaleType getScaleType() {
        return this.scaleType;
    }

    public View getWrappedView() {
        return null;
    }

    public boolean isCollected() {
        return false;
    }

    public int getId() {
        return TextUtils.isEmpty(this.imageUri) ? super.hashCode() : this.imageUri.hashCode();
    }

    public boolean setImageDrawable(Drawable drawable) {
        return true;
    }

    public boolean setImageBitmap(Bitmap bitmap) {
        return true;
    }
}
