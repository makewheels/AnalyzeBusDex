package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.amap.api.navi.AMapHudView;

public class AutoNaviHudMirroImage extends RelativeLayout {
    AMapHudView autoNaviHudDlg;
    private Bitmap hudMirrorBitmap;
    private Canvas hudMirrorCanvas;
    private Matrix hudMirrorMatrix;
    private Paint hudMirrorPaint;
    private boolean isHudMirrorImage = false;
    public int nHeight = 800;
    public int nWidth = 480;

    public AutoNaviHudMirroImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        invalidate();
    }

    public void refreshMirrorImage() {
        invalidate();
        postInvalidate();
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.isHudMirrorImage) {
            if (this.hudMirrorBitmap == null) {
                this.hudMirrorBitmap = Bitmap.createBitmap(this.nWidth, this.nHeight, Config.RGB_565);
            }
            if (this.hudMirrorCanvas == null) {
                this.hudMirrorCanvas = new Canvas(this.hudMirrorBitmap);
            }
            if (this.hudMirrorPaint == null) {
                this.hudMirrorPaint = new Paint();
            }
            if (this.hudMirrorMatrix == null) {
                this.hudMirrorMatrix = new Matrix();
            }
            this.hudMirrorPaint.setAntiAlias(true);
            this.hudMirrorCanvas.drawColor(-16777216);
            super.dispatchDraw(this.hudMirrorCanvas);
            this.hudMirrorMatrix.setScale(1.0f, -1.0f);
            this.hudMirrorMatrix.postTranslate(0.0f, (float) this.nHeight);
            canvas.drawBitmap(this.hudMirrorBitmap, this.hudMirrorMatrix, this.hudMirrorPaint);
            return;
        }
        canvas.drawColor(-16777216);
        super.dispatchDraw(canvas);
    }

    public void destroyHudMirrorRes() {
        if (this.hudMirrorBitmap != null) {
            this.hudMirrorBitmap.recycle();
            this.hudMirrorBitmap = null;
        }
        this.hudMirrorCanvas = null;
        this.hudMirrorMatrix = null;
        this.hudMirrorPaint = null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.autoNaviHudDlg != null) {
                this.autoNaviHudDlg.onTouchHudMirrorEvent(motionEvent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return true;
    }

    public void setIsHudMirror(boolean z) {
        this.isHudMirrorImage = z;
    }

    public void setAutoNaviHudDlg(AMapHudView aMapHudView) {
        this.autoNaviHudDlg = aMapHudView;
    }

    public boolean getHudMirror() {
        return this.isHudMirrorImage;
    }
}
