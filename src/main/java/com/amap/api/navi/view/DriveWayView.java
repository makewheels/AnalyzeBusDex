package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.navi.AMapNaviView;
import com.autonavi.tbt.C0617g;
import p054u.aly.df;

public class DriveWayView extends View {
    private int COMMON_VALUE = 3;
    private int[] driveWayFrontId = new int[]{2130837557, 2130837558, 2130837544, 2130837561, 2130837546, 2130837564, 2130837548, 2130837549, 2130837570, 2130837551, 2130837552, 2130837553, 2130837554, 2130837579, 2130837556};
    private int[] driveWayGrayBgId = new int[]{2130837542, 2130837543, 2130837544, 2130837545, 2130837546, 2130837547, 2130837548, 2130837549, 2130837550, 2130837551, 2130837552, 2130837553, 2130837554, 2130837555, 2130837556};
    private int driveWayHeight = 0;
    private int driveWayPosX = 0;
    private int driveWayPosY = 0;
    private int driveWaySize = 0;
    private int driveWayWidth = 0;
    private Bitmap[] driveWaybitMap = null;
    private Bitmap[] driveWaybitMapBg = null;
    private AMapNaviView mAMapNaviView = null;

    public DriveWayView(Context context) {
        super(context);
    }

    public DriveWayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DriveWayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAMapNaviView(AMapNaviView aMapNaviView) {
        this.mAMapNaviView = aMapNaviView;
    }

    public void loadDriveWayBitmap(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i2] == df.f6529m) {
                this.driveWaySize = i2;
                break;
            }
        }
        if (this.driveWaySize != 0) {
            this.driveWaybitMapBg = new Bitmap[this.driveWaySize];
            this.driveWaybitMap = new Bitmap[this.driveWaySize];
            while (i < this.driveWaySize) {
                this.driveWaybitMapBg[i] = BitmapFactory.decodeResource(C0617g.m4842a(), this.driveWayGrayBgId[bArr[i]]);
                if (isComplexLane(bArr[i])) {
                    this.driveWaybitMap[i] = complexBitmap(bArr[i], bArr2[i]);
                } else if (isLoadLaneSelectInfo(bArr[i], bArr2[i])) {
                    this.driveWaybitMap[i] = BitmapFactory.decodeResource(C0617g.m4842a(), this.driveWayFrontId[bArr2[i]]);
                }
                i++;
            }
            if (this.driveWaybitMapBg[i - 1] != null) {
                this.driveWayWidth = this.driveWaybitMapBg[i - 1].getWidth();
                this.driveWayHeight = this.driveWaybitMapBg[i - 1].getHeight();
            }
        }
    }

    private boolean isLoadLaneSelectInfo(byte b, byte b2) {
        if (b2 == df.f6529m) {
            return false;
        }
        return true;
    }

    private boolean isComplexLane(int i) {
        return i == 14 || i == 2 || i == 4 || i == 9 || i == 10 || i == 11 || i == 12 || i == 6 || i == 7;
    }

    private Bitmap complexBitmap(int i, int i2) {
        Bitmap bitmap = null;
        if (i == 10) {
            if (i2 == 0) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837573);
            } else if (i2 == 8) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837574);
            }
        } else if (i == 9) {
            if (i2 == 0) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837571);
            } else if (i2 == 5) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837572);
            }
        } else if (i == 2) {
            if (i2 == 0) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837559);
            } else if (i2 == 1) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837560);
            }
        } else if (i == 4) {
            if (i2 == 0) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837562);
            } else if (i2 == 3) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837563);
            }
        } else if (i == 6) {
            if (i2 == 1) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837565);
            } else if (i2 == 3) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837566);
            }
        } else if (i == 7) {
            if (i2 == 0) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837567);
            } else if (i2 == 1) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837568);
            } else if (i2 == 3) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837569);
            }
        } else if (i == 11) {
            if (i2 == 5) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837576);
            } else if (i2 == 1) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837575);
            }
        } else if (i == 12) {
            if (i2 == 8) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837578);
            } else if (i2 == 3) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837577);
            }
        } else if (i == 14) {
            if (i2 == 1) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837580);
            } else if (i2 == 5) {
                bitmap = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837581);
            }
        }
        if (bitmap == null) {
            return BitmapFactory.decodeResource(C0617g.m4842a(), this.driveWayGrayBgId[i]);
        }
        return bitmap;
    }

    public void setBitmapPosition(int i, int i2) {
        if (this.mAMapNaviView != null) {
            if (this.mAMapNaviView.isShowRoadEnlarge()) {
                this.driveWayPosX = (i - (this.driveWayWidth * this.driveWaySize)) >> 1;
            } else {
                this.driveWayPosX = (((i - this.mAMapNaviView.getAutoNaviTitleLeftMargin()) - (this.driveWayWidth * this.driveWaySize)) >> 1) + this.mAMapNaviView.getAutoNaviTitleLeftMargin();
            }
            if (this.mAMapNaviView.isOrientationLandscape()) {
                this.driveWayPosY = (i2 / 6) + 5;
            } else if (this.mAMapNaviView.isShowRoadEnlarge()) {
                this.driveWayPosY = ((i2 * 3) / 8) - (this.driveWayHeight >> 1);
            } else {
                this.driveWayPosY = (i2 / 12) + this.COMMON_VALUE;
            }
        }
    }

    public void recycleDriveWayViewRescource() {
        for (int i = 0; i < this.driveWaySize; i++) {
            if (this.driveWaybitMap[i] != null) {
                this.driveWaybitMap[i].recycle();
                this.driveWaybitMap[i] = null;
            }
            if (this.driveWaybitMapBg[i] != null) {
                this.driveWaybitMapBg[i].recycle();
                this.driveWaybitMapBg[i] = null;
            }
        }
        this.driveWaySize = 0;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.driveWaySize; i++) {
            if (this.driveWaybitMap[i] != null) {
                canvas.drawBitmap(this.driveWaybitMap[i], (float) (this.driveWayPosX + (this.driveWayWidth * i)), (float) this.driveWayPosY, null);
            } else if (this.driveWaybitMapBg[i] != null) {
                canvas.drawBitmap(this.driveWaybitMapBg[i], (float) (this.driveWayPosX + (this.driveWayWidth * i)), (float) this.driveWayPosY, null);
            }
        }
    }

    public int getDriveWaySize() {
        return this.driveWaySize;
    }

    public boolean isMoveDown(int i) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(C0617g.m4842a(), 2130837516, options);
        if (((i - (this.driveWaySize * this.driveWayWidth)) >> 1) <= options.outWidth) {
            return true;
        }
        return false;
    }

    public int getDriveWayBgHeight() {
        return this.driveWayHeight;
    }
}
