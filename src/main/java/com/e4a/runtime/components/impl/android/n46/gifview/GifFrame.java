package com.e4a.runtime.components.impl.android.n46.gifview;

import android.graphics.Bitmap;

public class GifFrame {
    public int delay;
    public Bitmap image;
    public GifFrame nextFrame = null;

    public GifFrame(Bitmap im, int del) {
        this.image = im;
        this.delay = del;
    }
}
