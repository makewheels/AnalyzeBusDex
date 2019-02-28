package com.e4a.runtime;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.e4a.runtime.components.Component;
import com.tencent.smtt.sdk.WebView;

public class ColorPickerDialog extends Dialog {
    private String ButtonTitle;
    private Context mContext;
    private int mInitialColor;
    private OnColorChangedListener mListener;
    private String mTitle;

    protected abstract class ColorPickerView extends View {
        protected Paint mCenterPaint;
        protected float mCenterRadius;
        protected final int[] mCircleColors;
        protected Paint mCirclePaint;
        protected float mCircleRadius;
        protected boolean mDownInCircle = true;
        protected boolean mDownInRect;
        protected int mHeight;
        protected boolean mHighlightCenter;
        protected Paint mLinePaint;
        protected OnColorChangedListener mListener;
        protected float mRectBottom;
        protected final int[] mRectColors;
        protected float mRectLeft;
        protected Paint mRectPaint;
        protected float mRectRight;
        protected Shader mRectShader;
        protected float mRectTop;
        protected int mWidth;
        protected boolean mlittleLightCenter;

        abstract int interpRectColor(int[] iArr, float f, float f2);

        public ColorPickerView(Context context, OnColorChangedListener l) {
            super(context);
            this.mListener = l;
            this.mCircleColors = new int[]{Component.f3916, Component.f3898, Component.f3925, Component.f3929, Component.f3920, Component.f3941, Component.f3916};
            this.mRectColors = new int[]{-16777216, r5.mInitialColor, -1};
        }

        protected int ave(int s, int d, float p) {
            return Math.round(((float) (d - s)) * p) + s;
        }

        protected boolean inColorCircle(float x, float y, float outRadius, float inRadius) {
            double fingerCircle = 3.141592653589793d * ((double) ((x * x) + (y * y)));
            return fingerCircle < (3.141592653589793d * ((double) outRadius)) * ((double) outRadius) && fingerCircle > (3.141592653589793d * ((double) inRadius)) * ((double) inRadius);
        }

        protected boolean inCenter(float x, float y, float centerRadius) {
            return 3.141592653589793d * ((double) ((x * x) + (y * y))) < (((double) centerRadius) * 3.141592653589793d) * ((double) centerRadius);
        }

        protected boolean inRect(float x, float y) {
            return x <= this.mRectRight && x >= this.mRectLeft && y <= this.mRectBottom && y >= this.mRectTop;
        }

        protected int interpCircleColor(int[] colors, float unit) {
            if (unit <= 0.0f) {
                return colors[0];
            }
            if (unit >= 1.0f) {
                return colors[colors.length - 1];
            }
            float p = unit * ((float) (colors.length - 1));
            int i = (int) p;
            p -= (float) i;
            int c0 = colors[i];
            int c1 = colors[i + 1];
            return Color.argb(ave(Color.alpha(c0), Color.alpha(c1), p), ave(Color.red(c0), Color.red(c1), p), ave(Color.green(c0), Color.green(c1), p), ave(Color.blue(c0), Color.blue(c1), p));
        }

        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(this.mWidth, this.mHeight);
        }

        protected void onActionDown(boolean inCircle, boolean inCenter, boolean inRect) {
            this.mDownInCircle = inCircle;
            this.mDownInRect = inRect;
            this.mHighlightCenter = inCenter;
        }

        protected void onActionMove(float x, float y, boolean inCircle, boolean inCenter, boolean inRect) {
            if (this.mDownInCircle && inCircle) {
                float unit = (float) (((double) ((float) Math.atan2((double) y, (double) x))) / 6.283185307179586d);
                if (unit < 0.0f) {
                    unit += 1.0f;
                }
                this.mCenterPaint.setColor(interpCircleColor(this.mCircleColors, unit));
            } else if (this.mDownInRect && inRect) {
                this.mCenterPaint.setColor(interpRectColor(this.mRectColors, x, y));
            }
            if ((this.mHighlightCenter && inCenter) || (this.mlittleLightCenter && inCenter)) {
                this.mHighlightCenter = true;
                this.mlittleLightCenter = false;
            } else if (this.mHighlightCenter || this.mlittleLightCenter) {
                this.mHighlightCenter = false;
                this.mlittleLightCenter = true;
            } else {
                this.mHighlightCenter = false;
                this.mlittleLightCenter = false;
            }
            invalidate();
        }

        protected void onActionUp(boolean inCenter) {
            if (this.mHighlightCenter && inCenter && this.mListener != null) {
                this.mListener.colorChanged(this.mCenterPaint.getColor());
                ColorPickerDialog.this.dismiss();
            }
            if (this.mDownInCircle) {
                this.mDownInCircle = false;
            }
            if (this.mDownInRect) {
                this.mDownInRect = false;
            }
            if (this.mHighlightCenter) {
                this.mHighlightCenter = false;
            }
            if (this.mlittleLightCenter) {
                this.mlittleLightCenter = false;
            }
            invalidate();
        }
    }

    private class LandscapeColorPickerView extends ColorPickerView {
        public LandscapeColorPickerView(Context context, OnColorChangedListener l) {
            super(context, l);
            Display display = ColorPickerDialog.this.getWindow().getWindowManager().getDefaultDisplay();
            int height = ((int) (((float) display.getHeight()) * 0.8f)) - 36;
            int width = (int) (((float) display.getWidth()) * 0.5f);
            this.mHeight = height;
            this.mWidth = width;
            setMinimumHeight(height);
            setMinimumWidth(width);
            Shader s = new SweepGradient(0.0f, 0.0f, this.mCircleColors, null);
            this.mCirclePaint = new Paint(1);
            this.mCirclePaint.setShader(s);
            this.mCirclePaint.setStyle(Style.STROKE);
            this.mCirclePaint.setStrokeWidth(50.0f);
            this.mCircleRadius = (((float) (this.mHeight / 2)) * 0.7f) - (this.mCirclePaint.getStrokeWidth() * 0.5f);
            this.mCenterPaint = new Paint(1);
            this.mCenterPaint.setColor(ColorPickerDialog.this.mInitialColor);
            this.mCenterPaint.setStrokeWidth(5.0f);
            this.mCenterRadius = (this.mCircleRadius - (this.mCirclePaint.getStrokeWidth() / 2.0f)) * 0.7f;
            this.mLinePaint = new Paint(1);
            this.mLinePaint.setColor(Color.parseColor("#72A1D1"));
            this.mLinePaint.setStrokeWidth(4.0f);
            this.mRectPaint = new Paint(1);
            this.mRectPaint.setStrokeWidth(5.0f);
            this.mRectLeft = ((this.mCircleRadius + (this.mCirclePaint.getStrokeWidth() * 0.5f)) + (this.mLinePaint.getStrokeMiter() * 0.5f)) + 15.0f;
            this.mRectTop = (-this.mCircleRadius) - (this.mCirclePaint.getStrokeWidth() * 0.5f);
            this.mRectRight = this.mRectLeft + 50.0f;
            this.mRectBottom = this.mCircleRadius + (this.mCirclePaint.getStrokeWidth() * 0.5f);
        }

        protected void onDraw(Canvas canvas) {
            canvas.translate((float) ((this.mWidth / 2) - 50), (float) (this.mHeight / 2));
            canvas.drawCircle(0.0f, 0.0f, this.mCenterRadius, this.mCenterPaint);
            if (this.mHighlightCenter || this.mlittleLightCenter) {
                int c = this.mCenterPaint.getColor();
                this.mCenterPaint.setStyle(Style.STROKE);
                if (this.mHighlightCenter) {
                    this.mCenterPaint.setAlpha(WebView.NORMAL_MODE_ALPHA);
                } else if (this.mlittleLightCenter) {
                    this.mCenterPaint.setAlpha(144);
                }
                canvas.drawCircle(0.0f, 0.0f, this.mCenterRadius + this.mCenterPaint.getStrokeWidth(), this.mCenterPaint);
                this.mCenterPaint.setStyle(Style.FILL);
                this.mCenterPaint.setColor(c);
            }
            canvas.drawOval(new RectF(-this.mCircleRadius, -this.mCircleRadius, this.mCircleRadius, this.mCircleRadius), this.mCirclePaint);
            if (this.mDownInCircle) {
                this.mRectColors[1] = this.mCenterPaint.getColor();
            }
            this.mRectShader = new LinearGradient(0.0f, this.mRectTop, 0.0f, this.mRectBottom, this.mRectColors, null, TileMode.MIRROR);
            this.mRectPaint.setShader(this.mRectShader);
            canvas.drawRect(this.mRectLeft, this.mRectTop, this.mRectRight, this.mRectBottom, this.mRectPaint);
            float offset = this.mLinePaint.getStrokeWidth() / 2.0f;
            Canvas canvas2 = canvas;
            canvas2.drawLine(this.mRectLeft - offset, this.mRectTop - (offset * 2.0f), this.mRectLeft - offset, (offset * 2.0f) + this.mRectBottom, this.mLinePaint);
            canvas2 = canvas;
            canvas2.drawLine(this.mRectLeft - (offset * 2.0f), this.mRectTop - offset, (offset * 2.0f) + this.mRectRight, this.mRectTop - offset, this.mLinePaint);
            canvas2 = canvas;
            canvas2.drawLine(this.mRectRight + offset, this.mRectTop - (offset * 2.0f), this.mRectRight + offset, (offset * 2.0f) + this.mRectBottom, this.mLinePaint);
            canvas2 = canvas;
            canvas2.drawLine(this.mRectLeft - (offset * 2.0f), this.mRectBottom + offset, (offset * 2.0f) + this.mRectRight, this.mRectBottom + offset, this.mLinePaint);
            super.onDraw(canvas);
        }

        public boolean onTouchEvent(MotionEvent event) {
            float x = (event.getX() - ((float) (this.mWidth / 2))) + 50.0f;
            float y = event.getY() - ((float) (this.mHeight / 2));
            boolean inCircle = inColorCircle(x, y, this.mCircleRadius + (this.mCirclePaint.getStrokeWidth() / 2.0f), this.mCircleRadius - (this.mCirclePaint.getStrokeWidth() / 2.0f));
            boolean inCenter = inCenter(x, y, this.mCenterRadius);
            boolean inRect = inRect(x, y);
            System.out.println(x + "..." + y);
            System.out.println(this.mRectLeft + "..." + this.mRectRight + "..." + this.mRectTop + "..." + this.mRectBottom);
            switch (event.getAction()) {
                case 0:
                    onActionDown(inCircle, inCenter, inRect);
                    break;
                case 1:
                    onActionUp(inCenter);
                    break;
                case 2:
                    break;
            }
            onActionMove(x, y, inCircle, inCenter, inRect);
            return true;
        }

        protected int interpRectColor(int[] colors, float x, float y) {
            int c0;
            int c1;
            float p;
            float referLine = this.mRectBottom;
            if (y < 0.0f) {
                c0 = colors[0];
                c1 = colors[1];
                p = (y + referLine) / referLine;
            } else {
                c0 = colors[1];
                c1 = colors[2];
                p = y / referLine;
            }
            return Color.argb(ave(Color.alpha(c0), Color.alpha(c1), p), ave(Color.red(c0), Color.red(c1), p), ave(Color.green(c0), Color.green(c1), p), ave(Color.blue(c0), Color.blue(c1), p));
        }
    }

    public interface OnColorChangedListener {
        void colorChanged(int i);
    }

    private class PortraitColorPickerView extends ColorPickerView {
        public PortraitColorPickerView(Context context, OnColorChangedListener l) {
            super(context, l);
            Display display = ColorPickerDialog.this.getWindow().getWindowManager().getDefaultDisplay();
            int height = ((int) (((float) display.getHeight()) * 0.5f)) - 36;
            int width = (int) (((float) display.getWidth()) * 0.7f);
            this.mHeight = height;
            this.mWidth = width;
            setMinimumHeight(height);
            setMinimumWidth(width);
            Shader s = new SweepGradient(0.0f, 0.0f, this.mCircleColors, null);
            this.mCirclePaint = new Paint(1);
            this.mCirclePaint.setShader(s);
            this.mCirclePaint.setStyle(Style.STROKE);
            this.mCirclePaint.setStrokeWidth(50.0f);
            this.mCircleRadius = (((float) (width / 2)) * 0.7f) - (this.mCirclePaint.getStrokeWidth() * 0.5f);
            this.mCenterPaint = new Paint(1);
            this.mCenterPaint.setColor(ColorPickerDialog.this.mInitialColor);
            this.mCenterPaint.setStrokeWidth(5.0f);
            this.mCenterRadius = (this.mCircleRadius - (this.mCirclePaint.getStrokeWidth() / 2.0f)) * 0.7f;
            this.mLinePaint = new Paint(1);
            this.mLinePaint.setColor(Color.parseColor("#72A1D1"));
            this.mLinePaint.setStrokeWidth(4.0f);
            this.mRectPaint = new Paint(1);
            this.mRectPaint.setStrokeWidth(5.0f);
            this.mRectLeft = (-this.mCircleRadius) - (this.mCirclePaint.getStrokeWidth() * 0.5f);
            this.mRectTop = ((this.mCircleRadius + (this.mCirclePaint.getStrokeWidth() * 0.5f)) + (this.mLinePaint.getStrokeMiter() * 0.5f)) + 15.0f;
            this.mRectRight = this.mCircleRadius + (this.mCirclePaint.getStrokeWidth() * 0.5f);
            this.mRectBottom = this.mRectTop + 50.0f;
        }

        protected void onDraw(Canvas canvas) {
            canvas.translate((float) (this.mWidth / 2), (float) ((this.mHeight / 2) - 50));
            canvas.drawCircle(0.0f, 0.0f, this.mCenterRadius, this.mCenterPaint);
            if (this.mHighlightCenter || this.mlittleLightCenter) {
                int c = this.mCenterPaint.getColor();
                this.mCenterPaint.setStyle(Style.STROKE);
                if (this.mHighlightCenter) {
                    this.mCenterPaint.setAlpha(WebView.NORMAL_MODE_ALPHA);
                } else if (this.mlittleLightCenter) {
                    this.mCenterPaint.setAlpha(144);
                }
                canvas.drawCircle(0.0f, 0.0f, this.mCenterRadius + this.mCenterPaint.getStrokeWidth(), this.mCenterPaint);
                this.mCenterPaint.setStyle(Style.FILL);
                this.mCenterPaint.setColor(c);
            }
            canvas.drawOval(new RectF(-this.mCircleRadius, -this.mCircleRadius, this.mCircleRadius, this.mCircleRadius), this.mCirclePaint);
            if (this.mDownInCircle) {
                this.mRectColors[1] = this.mCenterPaint.getColor();
            }
            this.mRectShader = new LinearGradient(this.mRectLeft, 0.0f, this.mRectRight, 0.0f, this.mRectColors, null, TileMode.MIRROR);
            this.mRectPaint.setShader(this.mRectShader);
            canvas.drawRect(this.mRectLeft, this.mRectTop, this.mRectRight, this.mRectBottom, this.mRectPaint);
            float offset = this.mLinePaint.getStrokeWidth() / 2.0f;
            Canvas canvas2 = canvas;
            canvas2.drawLine(this.mRectLeft - offset, this.mRectTop - (offset * 2.0f), this.mRectLeft - offset, (offset * 2.0f) + this.mRectBottom, this.mLinePaint);
            canvas2 = canvas;
            canvas2.drawLine(this.mRectLeft - (offset * 2.0f), this.mRectTop - offset, (offset * 2.0f) + this.mRectRight, this.mRectTop - offset, this.mLinePaint);
            canvas2 = canvas;
            canvas2.drawLine(this.mRectRight + offset, this.mRectTop - (offset * 2.0f), this.mRectRight + offset, (offset * 2.0f) + this.mRectBottom, this.mLinePaint);
            canvas2 = canvas;
            canvas2.drawLine(this.mRectLeft - (offset * 2.0f), this.mRectBottom + offset, (offset * 2.0f) + this.mRectRight, this.mRectBottom + offset, this.mLinePaint);
            super.onDraw(canvas);
        }

        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX() - ((float) (this.mWidth / 2));
            float y = (event.getY() - ((float) (this.mHeight / 2))) + 50.0f;
            boolean inCircle = inColorCircle(x, y, this.mCircleRadius + (this.mCirclePaint.getStrokeWidth() / 2.0f), this.mCircleRadius - (this.mCirclePaint.getStrokeWidth() / 2.0f));
            boolean inCenter = inCenter(x, y, this.mCenterRadius);
            boolean inRect = inRect(x, y);
            System.out.println(x + "..." + y);
            System.out.println(this.mRectLeft + "..." + this.mRectRight + "..." + this.mRectTop + "..." + this.mRectBottom);
            switch (event.getAction()) {
                case 0:
                    onActionDown(inCircle, inCenter, inRect);
                    break;
                case 1:
                    onActionUp(inCenter);
                    break;
                case 2:
                    break;
            }
            onActionMove(x, y, inCircle, inCenter, inRect);
            return true;
        }

        protected int interpRectColor(int[] colors, float x, float y) {
            int c0;
            int c1;
            float p;
            if (x < 0.0f) {
                c0 = colors[0];
                c1 = colors[1];
                p = (this.mRectRight + x) / this.mRectRight;
            } else {
                c0 = colors[1];
                c1 = colors[2];
                p = x / this.mRectRight;
            }
            return Color.argb(ave(Color.alpha(c0), Color.alpha(c1), p), ave(Color.red(c0), Color.red(c1), p), ave(Color.green(c0), Color.green(c1), p), ave(Color.blue(c0), Color.blue(c1), p));
        }
    }

    public ColorPickerDialog(Context context, String title, String button, OnColorChangedListener l) {
        this(context, title, button, Component.f3912, l);
    }

    public ColorPickerDialog(Context context, String title, String button, int initalColor, OnColorChangedListener l) {
        super(context);
        this.mContext = context;
        this.mTitle = title;
        this.ButtonTitle = button;
        this.mListener = l;
        this.mInitialColor = initalColor;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this.mContext);
        layout.setOrientation(1);
        layout.setVerticalGravity(16);
        Button button;
        if (m5379(this.mContext)) {
            final PortraitColorPickerView PortraitColorPicker = new PortraitColorPickerView(this.mContext, this.mListener);
            layout.addView(PortraitColorPicker);
            button = new Button(this.mContext);
            button.setText(this.ButtonTitle);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (ColorPickerDialog.this.mListener != null) {
                        ColorPickerDialog.this.mListener.colorChanged(PortraitColorPicker.mCenterPaint.getColor());
                        ColorPickerDialog.this.dismiss();
                    }
                }
            });
            layout.addView(button);
        } else {
            final LandscapeColorPickerView LandscapeColorPicker = new LandscapeColorPickerView(this.mContext, this.mListener);
            layout.addView(LandscapeColorPicker);
            button = new Button(this.mContext);
            button.setText(this.ButtonTitle);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (ColorPickerDialog.this.mListener != null) {
                        ColorPickerDialog.this.mListener.colorChanged(LandscapeColorPicker.mCenterPaint.getColor());
                        ColorPickerDialog.this.dismiss();
                    }
                }
            });
            layout.addView(button);
        }
        setContentView(layout);
        setTitle(this.mTitle);
    }

    /* renamed from: 是否为竖屏 */
    private boolean m5379(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }
}
