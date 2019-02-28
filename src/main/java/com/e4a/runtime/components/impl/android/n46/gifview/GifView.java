package com.e4a.runtime.components.impl.android.n46.gifview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.io.InputStream;

public class GifView extends View implements GifAction {
    private GifImageType animationType;
    private Bitmap currentImage;
    private DrawThread drawThread;
    private GifDecoder gifDecoder;
    private boolean isRun;
    private boolean pause;
    private Rect rect;
    private Handler redrawHandler;
    private int showHeight;
    private int showWidth;

    /* renamed from: com.e4a.runtime.components.impl.android.n46.gifview.GifView$1 */
    class C07551 extends Handler {
        C07551() {
        }

        public void handleMessage(Message msg) {
            GifView.this.invalidate();
        }
    }

    private class DrawThread extends Thread {
        private DrawThread() {
        }

        public void run() {
            if (GifView.this.gifDecoder != null) {
                while (GifView.this.isRun) {
                    if (GifView.this.pause) {
                        SystemClock.sleep(10);
                    } else if (GifView.this.gifDecoder.parseOk()) {
                        GifFrame frame = GifView.this.gifDecoder.next();
                        GifView.this.currentImage = frame.image;
                        long sp = (long) frame.delay;
                        if (GifView.this.redrawHandler != null) {
                            GifView.this.redrawHandler.sendMessage(GifView.this.redrawHandler.obtainMessage());
                            SystemClock.sleep(sp);
                        } else {
                            return;
                        }
                    } else {
                        GifView.this.currentImage = GifView.this.gifDecoder.getImage();
                        return;
                    }
                }
            }
        }
    }

    public enum GifImageType {
        WAIT_FINISH(0),
        SYNC_DECODER(1),
        COVER(2);
        
        final int nativeInt;

        private GifImageType(int i) {
            this.nativeInt = i;
        }
    }

    public GifView(Context context) {
        super(context);
        this.gifDecoder = null;
        this.currentImage = null;
        this.isRun = true;
        this.pause = false;
        this.showWidth = -1;
        this.showHeight = -1;
        this.rect = null;
        this.drawThread = null;
        this.animationType = GifImageType.SYNC_DECODER;
        this.redrawHandler = new C07551();
    }

    public GifView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GifView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.gifDecoder = null;
        this.currentImage = null;
        this.isRun = true;
        this.pause = false;
        this.showWidth = -1;
        this.showHeight = -1;
        this.rect = null;
        this.drawThread = null;
        this.animationType = GifImageType.SYNC_DECODER;
        this.redrawHandler = new C07551();
    }

    private void setGifDecoderImage(byte[] gif) {
        if (this.gifDecoder != null) {
            this.gifDecoder.free();
            this.gifDecoder = null;
        }
        this.gifDecoder = new GifDecoder(gif, (GifAction) this);
        this.gifDecoder.start();
    }

    private void setGifDecoderImage(InputStream is) {
        if (this.gifDecoder != null) {
            this.gifDecoder.free();
            this.gifDecoder = null;
        }
        this.gifDecoder = new GifDecoder(is, (GifAction) this);
        this.gifDecoder.start();
    }

    public void setGifImage(byte[] gif) {
        this.pause = true;
        this.isRun = false;
        this.drawThread = null;
        setGifDecoderImage(gif);
    }

    public void setGifImage(InputStream is) {
        this.pause = true;
        this.isRun = false;
        this.drawThread = null;
        setGifDecoderImage(is);
    }

    public void setGifImage(int resId) {
        this.pause = true;
        this.isRun = false;
        this.drawThread = null;
        setGifDecoderImage(getResources().openRawResource(resId));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.gifDecoder != null) {
            if (this.currentImage == null) {
                this.currentImage = this.gifDecoder.getImage();
            }
            if (this.currentImage != null) {
                int saveCount = canvas.getSaveCount();
                canvas.save();
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
                if (this.showWidth == -1) {
                    canvas.drawBitmap(this.currentImage, 0.0f, 0.0f, null);
                } else {
                    canvas.drawBitmap(this.currentImage, null, this.rect, null);
                }
                canvas.restoreToCount(saveCount);
            }
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w;
        int h;
        int pleft = getPaddingLeft();
        int pright = getPaddingRight();
        int ptop = getPaddingTop();
        int pbottom = getPaddingBottom();
        if (this.gifDecoder == null) {
            w = 1;
            h = 1;
        } else {
            w = this.gifDecoder.width;
            h = this.gifDecoder.height;
        }
        h += ptop + pbottom;
        setMeasuredDimension(resolveSize(Math.max(w + (pleft + pright), getSuggestedMinimumWidth()), widthMeasureSpec), resolveSize(Math.max(h, getSuggestedMinimumHeight()), heightMeasureSpec));
    }

    public void showCover() {
        if (this.gifDecoder != null) {
            this.pause = true;
            this.currentImage = this.gifDecoder.getImage();
            invalidate();
        }
    }

    public void showAnimation() {
        if (this.pause) {
            this.pause = false;
        }
    }

    public void setGifImageType(GifImageType type) {
        if (this.gifDecoder == null) {
            this.animationType = type;
        }
    }

    public void setShowDimension(int width, int height) {
        if (width > 0 && height > 0) {
            this.showWidth = width;
            this.showHeight = height;
            this.rect = new Rect();
            this.rect.left = 0;
            this.rect.top = 0;
            this.rect.right = width;
            this.rect.bottom = height;
        }
    }

    public void parseOk(boolean parseStatus, int frameIndex) {
        if (!parseStatus) {
            return;
        }
        if (this.gifDecoder != null) {
            switch (this.animationType) {
                case WAIT_FINISH:
                    if (frameIndex != -1) {
                        return;
                    }
                    if (this.gifDecoder.getFrameCount() > 1) {
                        this.isRun = true;
                        this.pause = false;
                        new DrawThread().start();
                        return;
                    }
                    reDraw();
                    return;
                case COVER:
                    if (frameIndex == 1) {
                        this.currentImage = this.gifDecoder.getImage();
                        reDraw();
                        return;
                    } else if (frameIndex != -1) {
                        return;
                    } else {
                        if (this.gifDecoder.getFrameCount() <= 1) {
                            reDraw();
                            return;
                        } else if (this.drawThread == null) {
                            this.isRun = true;
                            this.pause = false;
                            this.drawThread = new DrawThread();
                            this.drawThread.start();
                            return;
                        } else {
                            return;
                        }
                    }
                case SYNC_DECODER:
                    if (frameIndex == 1) {
                        this.currentImage = this.gifDecoder.getImage();
                        reDraw();
                        return;
                    } else if (frameIndex == -1) {
                        reDraw();
                        return;
                    } else if (this.drawThread == null) {
                        this.isRun = true;
                        this.pause = false;
                        this.drawThread = new DrawThread();
                        this.drawThread.start();
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
        Log.e("gif", "parse error");
    }

    private void reDraw() {
        if (this.redrawHandler != null) {
            this.redrawHandler.sendMessage(this.redrawHandler.obtainMessage());
        }
    }
}
