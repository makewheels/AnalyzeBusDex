package com.e4a.runtime.components.impl.android.n83;

import android.content.Context;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.ComponentImpl;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;

/* renamed from: com.e4a.runtime.components.impl.android.n83.友盟统计Impl */
public class C0776Impl extends ComponentImpl implements C0775 {
    private Context context = mainActivity.getContext();

    public C0776Impl(ComponentContainer container) {
        super(container);
    }

    /* renamed from: 初始化 */
    public void mo1302(String appkey, String channel) {
        MobclickAgent.openActivityDurationTrack(false);
        AnalyticsConfig.setAppkey(appkey);
        AnalyticsConfig.setChannel(channel);
    }

    /* renamed from: 开始统计 */
    public void mo1303(String aty) {
        MobclickAgent.onPageStart(aty);
        MobclickAgent.onResume(this.context);
    }

    /* renamed from: 结束统计 */
    public void mo1304(String aty) {
        MobclickAgent.onPageEnd(aty);
        MobclickAgent.onPause(this.context);
    }

    /* renamed from: 统计事件 */
    public void mo1305(String eventId) {
        MobclickAgent.onEvent(this.context, eventId);
    }
}
