package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.autonavi.tbt.C0617g;

public class DirectionView extends View implements OnClickListener {
    private Bitmap directionBmp;
    private Matrix driectionMatrix = new Matrix();
    private Paint paint;
    private PaintFlagsDrawFilter paintFlag;

    public DirectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initPaint();
    }

    public DirectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initPaint();
    }

    public DirectionView(Context context) {
        super(context);
        initPaint();
    }

    private void initPaint() {
        if (this.paint == null) {
            this.paint = new Paint();
            this.paint.setAntiAlias(true);
            this.directionBmp = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837596);
        }
        this.paintFlag = new PaintFlagsDrawFilter(0, 3);
    }

    public void setDriectionMatrix(float f) {
        if (this.directionBmp != null) {
            this.driectionMatrix.setRotate(f, ((float) this.directionBmp.getWidth()) / 2.0f, ((float) this.directionBmp.getHeight()) / 2.0f);
            invalidate();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.setDrawFilter(this.paintFlag);
        if (this.directionBmp != null && this.driectionMatrix != null) {
            canvas.drawBitmap(this.directionBmp, this.driectionMatrix, this.paint);
        }
    }

    public void onClick(View view) {
    }

    public void destroy() {
    }
}
