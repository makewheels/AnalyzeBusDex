package com.amap.api.navi;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.view.AutoNaviHudMirroImage;
import com.autonavi.tbt.C0615f;
import com.autonavi.tbt.C0617g;
import com.chedaole.C0641R;
import p054u.aly.bi_常量类;

public class AMapHudView extends FrameLayout implements OnClickListener, OnTouchListener, C0443e {
    private static final byte HUDMIRROR = (byte) 2;
    private static final byte HUDNORMAL = (byte) 1;
    private static final long delayMillis = 2000;
    static final int[] hud_imgActions = new int[]{2130837532, 2130837532, 2130837532, 2130837533, 2130837534, 2130837535, 2130837536, 2130837537, 2130837538, 2130837539, 2130837522, 2130837523, 2130837524, 2130837525, 2130837526, 2130837527, 2130837528, 2130837529, 2130837530, 2130837531};
    AMapHudViewListener aMapHudVewListener;
    private AutoNaviHudMirroImage autonaviHudMirrosImage;
    private Handler disappearHudHandler = new Handler();
    private Runnable disappearHudTitleRunnable = new C0448b(this);
    private String distanceTimeTextStr;
    private View frameLayout;
    private int hudMode = 1;
    private byte hudStatus = (byte) 1;
    private View hudmirrortitle;
    private boolean isHudMenu = true;
    boolean isLandscape = false;
    private TextView limitSpeedTextView;
    private OnCheckedChangeListener listener = new C0447a(this);
    private AMapNavi mAMapNavi;
    private Context mContext;
    private int mHeight = 800;
    private int mWidth = 480;
    private SpannableString nextRoadDisTextSpannableStr = null;
    private TextView nextRoadDistanceText;
    private TextView nextRoadNameText;
    private String nextRoadNameTextStr;
    private int resId;
    private TextView restDistanceText;
    private String restDistanceTextStr;
    private TextView restDistanceTime;
    private ImageView roadsignimg;
    private CheckBox save;
    private View title_btn_goback;

    /* renamed from: com.amap.api.navi.AMapHudView$1 */
    class C04421 implements AnimationListener {
        /* renamed from: a */
        final /* synthetic */ AMapHudView f2682a;

        C04421(AMapHudView aMapHudView) {
            this.f2682a = aMapHudView;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f2682a.hudmirrortitle.setVisibility(8);
        }
    }

    public AMapHudView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            init(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AMapHudView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        try {
            init(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setHudViewMode(int i) {
        try {
            this.hudMode = i;
            if (i == 1) {
                if (this.autonaviHudMirrosImage != null) {
                    this.hudStatus = (byte) 2;
                    postInvalidateHudMirros(true);
                }
            } else if (i != 2) {
            } else {
                if (this.autonaviHudMirrosImage != null) {
                    this.hudStatus = (byte) 1;
                    postInvalidateHudMirros(false);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getHudViewMode() {
        return this.hudMode;
    }

    public void setHudMenuEnabled(Boolean bool) {
        this.isHudMenu = bool.booleanValue();
    }

    public boolean getHudMenuEnabled() {
        return this.isHudMenu;
    }

    public void onCreate(Bundle bundle) {
    }

    public final void onResume() {
    }

    public final void onPause() {
    }

    public final void onDestroy() {
        try {
            if (this.autonaviHudMirrosImage != null) {
                this.autonaviHudMirrosImage.destroyHudMirrorRes();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
    }

    public void setHudViewListener(AMapHudViewListener aMapHudViewListener) {
        this.aMapHudVewListener = aMapHudViewListener;
    }

    public AMapHudView(Context context) {
        super(context);
        init(context);
    }

    public void init(Context context) {
        try {
            this.mContext = context;
            this.mAMapNavi = AMapNavi.getInstance(context);
            boolean z = ((Activity) getContext()).getRequestedOrientation() == 0 || getResources().getConfiguration().orientation == 2;
            this.isLandscape = z;
            if (this.isLandscape) {
                this.frameLayout = C0617g.m4844a((Activity) getContext(), C0641R.layout.prom_dialog, null);
            } else {
                this.frameLayout = C0617g.m4844a((Activity) getContext(), C0641R.layout.poi_result_list, null);
            }
            addView(this.frameLayout);
            initReslution();
            initWidget();
            this.mAMapNavi.setAMapNaviListener(this);
            onNaviInfoUpdate(this.mAMapNavi.getNaviInfo());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void initReslution() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.mWidth = displayMetrics.widthPixels;
        this.mHeight = displayMetrics.heightPixels;
    }

    public boolean onTouchHudMirrorEvent(MotionEvent motionEvent) {
        try {
            if (this.isHudMenu) {
                loadShowHudTitleAnimation();
                removeCallbacks();
                this.disappearHudHandler.postDelayed(this.disappearHudTitleRunnable, delayMillis);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return true;
    }

    private void loadShowHudTitleAnimation() {
        if (this.hudmirrortitle != null && this.hudmirrortitle.getVisibility() == 8) {
            Animation a = C0617g.m4845a(this.mContext, (int) C0641R.string.app_name);
            this.hudmirrortitle.setVisibility(0);
            this.hudmirrortitle.startAnimation(a);
        }
    }

    private void initWidget() {
        this.hudmirrortitle = this.frameLayout.findViewById(2131427344);
        this.autonaviHudMirrosImage = (AutoNaviHudMirroImage) this.frameLayout.findViewById(2131427337);
        this.save = (CheckBox) this.frameLayout.findViewById(2131427336);
        this.nextRoadNameText = (TextView) this.frameLayout.findViewById(2131427338);
        this.restDistanceText = (TextView) this.frameLayout.findViewById(2131427341);
        this.roadsignimg = (ImageView) this.frameLayout.findViewById(2131427339);
        this.nextRoadDistanceText = (TextView) this.frameLayout.findViewById(2131427340);
        this.title_btn_goback = this.frameLayout.findViewById(2131427334);
        this.restDistanceTime = (TextView) this.frameLayout.findViewById(2131427342);
        this.limitSpeedTextView = (TextView) this.frameLayout.findViewById(2131427343);
        getScreenInfo();
        setWidgetListener();
        updateHudWidgetContent();
    }

    private void getScreenInfo() {
        if (this.autonaviHudMirrosImage != null) {
            this.autonaviHudMirrosImage.nWidth = this.mWidth;
            this.autonaviHudMirrosImage.nHeight = this.mHeight - 50;
        }
    }

    private void updateHudWidgetContent() {
        if (this.nextRoadNameText != null) {
            this.nextRoadNameText.setText(this.nextRoadNameTextStr);
        }
        if (this.nextRoadDistanceText != null) {
            this.nextRoadDistanceText.setText(this.nextRoadDisTextSpannableStr);
        }
        if (this.restDistanceText != null) {
            this.restDistanceText.setText(this.restDistanceTextStr);
        }
        if (this.restDistanceTime != null) {
            this.restDistanceTime.setText(this.distanceTimeTextStr);
        }
        if (this.roadsignimg != null && this.resId != 0 && this.resId != 1) {
            this.roadsignimg.setBackgroundDrawable(C0617g.m4842a().getDrawable(hud_imgActions[this.resId]));
            if (this.autonaviHudMirrosImage != null) {
                this.autonaviHudMirrosImage.invalidate();
                this.autonaviHudMirrosImage.postInvalidate();
            }
        }
    }

    private void setWidgetListener() {
        if (this.autonaviHudMirrosImage != null) {
            this.autonaviHudMirrosImage.setAutoNaviHudDlg(this);
            setOnTouchListener(this);
        }
        if (this.save != null) {
            this.save.setOnCheckedChangeListener(this.listener);
        }
        if (this.title_btn_goback != null) {
            this.title_btn_goback.setOnClickListener(this);
        }
    }

    private void removeCallbacks() {
        if (this.disappearHudHandler != null && this.disappearHudTitleRunnable != null) {
            this.disappearHudHandler.removeCallbacks(this.disappearHudTitleRunnable);
        }
    }

    private void postInvalidateHudMirros(boolean z) {
        if (this.save != null) {
            this.save.setChecked(z);
        }
        if (this.autonaviHudMirrosImage != null) {
            this.autonaviHudMirrosImage.setIsHudMirror(z);
            this.autonaviHudMirrosImage.invalidate();
            this.autonaviHudMirrosImage.postInvalidate();
        }
    }

    private void loadHideHudTitleAnimation() {
        if (this.hudmirrortitle != null && this.hudmirrortitle.getVisibility() == 0) {
            Animation a = C0617g.m4845a(this.mContext, 2130968577);
            a.setAnimationListener(new C04421(this));
            this.hudmirrortitle.startAnimation(a);
        }
    }

    public void onClick(View view) {
        try {
            if (this.title_btn_goback == view && this.aMapHudVewListener != null) {
                this.aMapHudVewListener.onHudViewCancel();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean isHudMirror() {
        return this.hudStatus == (byte) 2;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        try {
            if (this.autonaviHudMirrosImage != null) {
                this.autonaviHudMirrosImage.destroyHudMirrorRes();
                this.autonaviHudMirrosImage = null;
            }
            removeAllViews();
            if (getResources().getConfiguration().orientation == 2) {
                this.frameLayout = C0617g.m4844a((Activity) getContext(), C0641R.layout.prom_dialog, null);
            } else {
                this.frameLayout = C0617g.m4844a((Activity) getContext(), C0641R.layout.poi_result_list, null);
            }
            addView(this.frameLayout);
            initReslution();
            initWidget();
            getScreenInfo();
            onNaviInfoUpdate(this.mAMapNavi.getNaviInfo());
            boolean isHudMirror = isHudMirror();
            if (this.autonaviHudMirrosImage != null) {
                this.save.setChecked(isHudMirror);
                this.autonaviHudMirrosImage.setIsHudMirror(isHudMirror);
                this.autonaviHudMirrosImage.invalidate();
                this.autonaviHudMirrosImage.postInvalidate();
            }
            postInvalidateHudMirros(isHudMirror());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onConfigurationChanged(configuration);
    }

    public void updateHudUI(NaviInfo naviInfo) {
        if (naviInfo != null) {
            try {
                this.nextRoadNameTextStr = naviInfo.m_NextRoadName;
                this.restDistanceTextStr = C0615f.m4829a(naviInfo.getPathRetainDistance());
                this.nextRoadDisTextSpannableStr = switchStrFromMeter(naviInfo.m_SegRemainDis);
                this.resId = naviInfo.m_Icon;
                this.distanceTimeTextStr = C0615f.m4839b(naviInfo.m_RouteRemainTime);
                if (this.mAMapNavi.getNaviSetting().m3846a() && this.mAMapNavi.getEngineType() == 0 && naviInfo.getCameraDistance() > 0 && this.limitSpeedTextView != null && naviInfo.m_CameraSpeed > 0) {
                    this.limitSpeedTextView.setText(bi_常量类.f6358b + naviInfo.m_CameraSpeed);
                    this.limitSpeedTextView.setVisibility(0);
                } else if (naviInfo.m_CameraSpeed == 0 && this.limitSpeedTextView != null) {
                    this.limitSpeedTextView.setVisibility(8);
                }
                updateHudWidgetContent();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private SpannableString switchStrFromMeter(int i) {
        if (i < 1000) {
            return getSpanableString(this.mContext, i + bi_常量类.f6358b, "米");
        }
        return getSpanableString(this.mContext, (((float) Math.round((((float) i) / 1000.0f) * 10.0f)) / 10.0f) + bi_常量类.f6358b, "公里");
    }

    private SpannableString getSpanableString(Context context, String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        int a = C0615f.m4825a(context, 60);
        int a2 = C0615f.m4825a(context, 30);
        int length = str.length();
        spannableString.setSpan(new AbsoluteSizeSpan(a), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, length, 33);
        a = str2.length() + length;
        spannableString.setSpan(new AbsoluteSizeSpan(a2), length, a, 33);
        spannableString.setSpan(new ForegroundColorSpan(-1), length, a, 33);
        return spannableString;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            onTouchHudMirrorEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public void onInitNaviFailure() {
    }

    public void onInitNaviSuccess() {
    }

    public void onStartNavi(int i) {
    }

    public void onTrafficStatusUpdate() {
    }

    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {
    }

    public void onGetNavigationText(int i, String str) {
    }

    public void onEndEmulatorNavi() {
    }

    public void onArriveDestination() {
    }

    public void onCalculateRouteSuccess() {
    }

    public void onCalculateRouteFailure(int i) {
    }

    public void onReCalculateRouteForYaw() {
    }

    public void onReCalculateRouteForTrafficJam() {
    }

    public void onArrivedWayPoint(int i) {
    }

    public void onGpsOpenStatus(boolean z) {
    }

    public void onNaviInfoUpdate(NaviInfo naviInfo) {
        try {
            updateHudUI(naviInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showLaneInfo(byte[] bArr, byte[] bArr2) {
    }

    public void hideLaneInfo() {
    }

    public void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
    }
}
