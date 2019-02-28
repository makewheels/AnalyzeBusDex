package com.e4a.runtime.components.impl.android.n56;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.alipay.sdk.cons.C0108a;
import com.e4a.runtime.C0841;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.android.ViewComponent;
import com.e4a.runtime.events.EventDispatcher;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.n56.分组列表框Impl */
public class C0767Impl extends ViewComponent implements C0757 {
    private int ButtonHeight = 40;
    private int ButtonWitdh = 55;
    private int ImageHeight = 50;
    private int ImageWitdh = 50;
    private ExpandableAdapter adapter;
    private String backgroundImage = bi_常量类.f6358b;
    private int backgroundImage2 = -1;
    private int childButtontextColor = -16777216;
    private float childButtontextSize = 6.0f;
    private int childInfotextColor = -7566708;
    private float childInfotextSize = 6.0f;
    private int childTitletextColor = -16777216;
    private float childTitletextSize = 9.0f;
    private List<List<Map<String, String>>> childlist;
    private ExpandableListView expandableListView;
    private int groupInfotextColor = -7566708;
    private float groupInfotextSize = 6.0f;
    private int groupTitletextColor = -16777216;
    private float groupTitletextSize = 9.0f;
    private List<Map<String, String>> groups;
    private boolean haveButton = true;
    private boolean haveCheck = false;
    private ImageLoader imageLoader;
    private Set<String> items;
    ImageLoadingListener listener = new C07636();
    private DisplayImageOptions options;
    private boolean richtext = false;
    /* renamed from: 不弹出菜单 */
    private boolean f4318 = true;
    /* renamed from: 监听加载完毕 */
    private boolean f4319 = false;

    /* renamed from: com.e4a.runtime.components.impl.android.n56.分组列表框Impl$1 */
    class C07581 implements OnChildClickListener {
        C07581() {
        }

        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            C0767Impl.this.mo1233(groupPosition, childPosition);
            return false;
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n56.分组列表框Impl$2 */
    class C07592 implements OnItemLongClickListener {
        C07592() {
        }

        public boolean onItemLongClick(AdapterView<?> parent, View childView, int flatPos, long id) {
            if (ExpandableListView.getPackedPositionType(id) == 1) {
                long packedPos = ((ExpandableListView) parent).getExpandableListPosition(flatPos);
                C0767Impl.this.mo1234(ExpandableListView.getPackedPositionGroup(packedPos), ExpandableListView.getPackedPositionChild(packedPos));
            } else if (ExpandableListView.getPackedPositionType(id) == 0) {
                C0767Impl.this.mo1192(ExpandableListView.getPackedPositionGroup(((ExpandableListView) parent).getExpandableListPosition(flatPos)));
            }
            return C0767Impl.this.f4318;
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n56.分组列表框Impl$3 */
    class C07603 implements OnGroupExpandListener {
        C07603() {
        }

        public void onGroupExpand(int groupPosition) {
            C0767Impl.this.mo1190(groupPosition);
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n56.分组列表框Impl$4 */
    class C07614 implements OnGroupCollapseListener {
        C07614() {
        }

        public void onGroupCollapse(int groupPosition) {
            C0767Impl.this.mo1191(groupPosition);
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n56.分组列表框Impl$5 */
    class C07625 implements OnGroupClickListener {
        C07625() {
        }

        public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
            C0767Impl.this.mo1189(groupPosition);
            return false;
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n56.分组列表框Impl$6 */
    class C07636 implements ImageLoadingListener {
        C07636() {
        }

        public void onLoadingStarted(String paramString, View paramView) {
        }

        public void onLoadingFailed(String paramString, View paramView, FailReason paramFailReason) {
            C0767Impl.this.mo1211(false, paramString, null);
        }

        public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap) {
            C0767Impl.this.mo1211(true, paramString, C0767Impl.this.Bitmap2Bytes(paramBitmap));
        }

        public void onLoadingCancelled(String paramString, View paramView) {
            C0767Impl.this.mo1211(false, paramString, null);
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n56.分组列表框Impl$ExpandableAdapter */
    private class ExpandableAdapter extends BaseExpandableListAdapter {
        private Context context;

        /* renamed from: com.e4a.runtime.components.impl.android.n56.分组列表框Impl$ExpandableAdapter$3 */
        class C07663 implements ImageGetter {
            C07663() {
            }

            public Drawable getDrawable(String source) {
                Drawable d = mainActivity.getContext().getResources().getDrawable(Integer.parseInt(source));
                d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
                return d;
            }
        }

        /* renamed from: com.e4a.runtime.components.impl.android.n56.分组列表框Impl$ExpandableAdapter$childItemview */
        public final class childItemview {
            public Button button;
            public CheckBox check;
            public ImageView image;
            public TextView info;
            public TextView title;
        }

        /* renamed from: com.e4a.runtime.components.impl.android.n56.分组列表框Impl$ExpandableAdapter$groupview */
        public final class groupview {
            public TextView info;
            public TextView title;
        }

        public ExpandableAdapter(Context context) {
            this.context = context;
        }

        public int getGroupCount() {
            return C0767Impl.this.groups.size();
        }

        public Object getGroup(int groupPosition) {
            return ((Map) C0767Impl.this.groups.get(groupPosition)).get("title");
        }

        public long getGroupId(int groupPosition) {
            return (long) groupPosition;
        }

        public int getChildrenCount(int groupPosition) {
            return ((List) C0767Impl.this.childlist.get(groupPosition)).size();
        }

        public Object getChild(int groupPosition, int childPosition) {
            return ((Map) ((List) C0767Impl.this.childlist.get(groupPosition)).get(childPosition)).get("title");
        }

        public long getChildId(int groupPosition, int childPosition) {
            return (long) childPosition;
        }

        public boolean hasStableIds() {
            return true;
        }

        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            groupview gv;
            if (convertView == null) {
                gv = new groupview();
                View layout = new LinearLayout(this.context);
                layout.setOrientation(0);
                layout.setVerticalGravity(16);
                LayoutParams param1 = new LayoutParams(-2, -1);
                param1.weight = 1.0f;
                gv.title = new TextView(this.context);
                gv.title.setGravity(19);
                gv.title.setPadding(m6127(50), 0, 0, 0);
                layout.addView(gv.title, param1);
                LayoutParams param2 = new LayoutParams(-2, m6127(50));
                param2.setMargins(m6127(5), 0, m6127(5), 0);
                gv.info = new TextView(this.context);
                gv.info.setGravity(21);
                layout.addView(gv.info, param2);
                convertView = layout;
                convertView.setTag(gv);
            } else {
                gv = (groupview) convertView.getTag();
            }
            if (C0880_应用操作类.m6699()) {
                gv.title.setTextSize(0, C0880_应用操作类.m6713(C0767Impl.this.groupTitletextSize));
            } else {
                gv.title.setTextSize(C0767Impl.this.groupTitletextSize);
            }
            gv.title.setTextColor(C0767Impl.this.groupTitletextColor);
            if (C0767Impl.this.richtext) {
                m6126(gv.title, (String) ((Map) C0767Impl.this.groups.get(groupPosition)).get("title"));
            } else {
                gv.title.setText((CharSequence) ((Map) C0767Impl.this.groups.get(groupPosition)).get("title"));
            }
            if (C0880_应用操作类.m6699()) {
                gv.info.setTextSize(0, C0880_应用操作类.m6713(C0767Impl.this.groupInfotextSize));
            } else {
                gv.info.setTextSize(C0767Impl.this.groupInfotextSize);
            }
            gv.info.setTextColor(C0767Impl.this.groupInfotextColor);
            if (((String) ((Map) C0767Impl.this.groups.get(groupPosition)).get("info")).equals(bi_常量类.f6358b)) {
                gv.info.setVisibility(8);
            } else {
                gv.info.setVisibility(0);
            }
            if (C0767Impl.this.richtext) {
                m6126(gv.info, (String) ((Map) C0767Impl.this.groups.get(groupPosition)).get("info"));
            } else {
                gv.info.setText((CharSequence) ((Map) C0767Impl.this.groups.get(groupPosition)).get("info"));
            }
            return convertView;
        }

        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if (C0767Impl.this.groups.size() == 0) {
                return null;
            }
            childItemview civ;
            final int groupid = groupPosition;
            final int childid = childPosition;
            if (convertView == null) {
                civ = new childItemview();
                View layout = new LinearLayout(this.context);
                layout.setOrientation(0);
                layout.setVerticalGravity(16);
                LayoutParams check = new LayoutParams(-2, -2);
                civ.check = new CheckBox(this.context);
                civ.check.setFocusable(false);
                civ.check.setLayoutParams(check);
                layout.addView(civ.check, check);
                LayoutParams image = new LayoutParams(m6127(C0767Impl.this.ImageWitdh), m6127(C0767Impl.this.ImageHeight));
                image.setMargins(m6127(5), m6127(5), m6127(5), m6127(5));
                civ.image = new ImageView(this.context);
                civ.image.setLayoutParams(image);
                layout.addView(civ.image, image);
                View linearLayout = new LinearLayout(this.context);
                ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
                layoutParams.weight = 1.0f;
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams title = new LayoutParams(-1, -1);
                title.weight = 1.0f;
                civ.title = new TextView(this.context);
                civ.title.setGravity(19);
                civ.title.setPadding(0, m6127(5), 0, m6127(5));
                linearLayout.addView(civ.title, title);
                LayoutParams info = new LayoutParams(-1, -1);
                info.weight = 1.0f;
                civ.info = new TextView(this.context);
                civ.info.setGravity(19);
                civ.info.setPadding(0, m6127(5), 0, m6127(5));
                linearLayout.addView(civ.info, info);
                layout.addView(linearLayout, layoutParams);
                LayoutParams button = new LayoutParams(m6127(C0767Impl.this.ButtonWitdh), m6127(C0767Impl.this.ButtonHeight));
                button.setMargins(m6127(5), 0, m6127(5), 0);
                civ.button = new Button(this.context);
                civ.button.setFocusable(false);
                civ.button.setLayoutParams(button);
                layout.addView(civ.button, button);
                convertView = layout;
                convertView.setTag(civ);
            } else {
                civ = (childItemview) convertView.getTag();
            }
            Map<String, String> map = (Map) ((List) C0767Impl.this.childlist.get(groupPosition)).get(childPosition);
            final CheckBox checkbox = civ.check;
            if (((String) map.get("check")).equals(C0108a.f262e)) {
                checkbox.setChecked(true);
            } else {
                checkbox.setChecked(false);
            }
            checkbox.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    C0767Impl.this.mo1256(groupid, childid, checkbox.isChecked());
                    C0767Impl.this.mo1235(groupid, childid, checkbox.isChecked());
                }
            });
            if (C0767Impl.this.mo1241()) {
                checkbox.setVisibility(0);
            } else {
                checkbox.setVisibility(8);
            }
            String imagePath = (String) map.get("image");
            if (C0767Impl.this.options == null || C0767Impl.this.imageLoader == null) {
                civ.image.setBackgroundDrawable(getDrawable(imagePath));
            } else if (C0767Impl.this.f4319) {
                String id = Integer.toString(groupPosition) + "|" + Integer.toString(childPosition);
                if (C0767Impl.this.items.contains(id)) {
                    C0767Impl.this.imageLoader.displayImage(imagePath, civ.image, C0767Impl.this.options);
                } else {
                    C0767Impl.this.items.add(id);
                    C0767Impl.this.imageLoader.displayImage(imagePath, civ.image, C0767Impl.this.options, C0767Impl.this.listener);
                }
            } else {
                C0767Impl.this.imageLoader.displayImage(imagePath, civ.image, C0767Impl.this.options);
            }
            if (C0880_应用操作类.m6699()) {
                civ.title.setTextSize(0, C0880_应用操作类.m6713(C0767Impl.this.childTitletextSize));
            } else {
                civ.title.setTextSize(C0767Impl.this.childTitletextSize);
            }
            civ.title.setTextColor(C0767Impl.this.childTitletextColor);
            if (C0767Impl.this.richtext) {
                m6126(civ.title, (String) map.get("title"));
            } else {
                civ.title.setText((CharSequence) map.get("title"));
            }
            if (C0880_应用操作类.m6699()) {
                civ.info.setTextSize(0, C0880_应用操作类.m6713(C0767Impl.this.childInfotextSize));
            } else {
                civ.info.setTextSize(C0767Impl.this.childInfotextSize);
            }
            civ.info.setTextColor(C0767Impl.this.childInfotextColor);
            if (((String) map.get("info")).equals(bi_常量类.f6358b)) {
                civ.info.setVisibility(8);
            } else {
                civ.info.setVisibility(0);
            }
            if (C0767Impl.this.richtext) {
                m6126(civ.info, (String) map.get("info"));
            } else {
                civ.info.setText((CharSequence) map.get("info"));
            }
            civ.button.setBackgroundDrawable(getDrawable((String) map.get("buttonimage")));
            civ.button.setFocusable(false);
            if (C0880_应用操作类.m6699()) {
                civ.button.setTextSize(0, C0880_应用操作类.m6713(C0767Impl.this.childButtontextSize));
            } else {
                civ.button.setTextSize(C0767Impl.this.childButtontextSize);
            }
            civ.button.setTextColor(C0767Impl.this.childButtontextColor);
            civ.button.setGravity(17);
            if (C0767Impl.this.richtext) {
                m6126(civ.button, (String) map.get("buttontitle"));
            } else {
                civ.button.setText((CharSequence) map.get("buttontitle"));
            }
            civ.button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    C0767Impl.this.mo1226(groupid, childid);
                }
            });
            if (C0767Impl.this.mo1239()) {
                civ.button.setVisibility(0);
            } else {
                civ.button.setVisibility(8);
            }
            return convertView;
        }

        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        private Drawable getDrawable(String imagePath) {
            Drawable drawable = null;
            if (imagePath.length() <= 0) {
                return drawable;
            }
            if (!imagePath.startsWith("/")) {
                try {
                    return Drawable.createFromStream(this.context.getResources().getAssets().open(imagePath), imagePath);
                } catch (IOException e) {
                    return drawable;
                }
            } else if (new File(imagePath).exists()) {
                return Drawable.createFromPath(imagePath);
            } else {
                return drawable;
            }
        }

        /* renamed from: 取相对像素 */
        private int m6127(int value) {
            return (int) ((((float) value) * this.context.getResources().getDisplayMetrics().density) + 0.5f);
        }

        /* renamed from: 加载超文本内容 */
        private void m6126(TextView view, String html) {
            view.setText(Html.fromHtml(html, new C07663(), null));
            view.invalidate();
        }
    }

    public C0767Impl(ComponentContainer container) {
        super(container);
    }

    protected View createView() {
        this.expandableListView = new ExpandableListView(mainActivity.getContext());
        this.expandableListView.setFocusable(true);
        this.expandableListView.setCacheColorHint(0);
        this.items = new HashSet();
        this.groups = new ArrayList();
        this.childlist = new ArrayList();
        this.adapter = new ExpandableAdapter(mainActivity.getContext());
        this.expandableListView.setAdapter(this.adapter);
        this.expandableListView.setOnChildClickListener(new C07581());
        this.expandableListView.setOnItemLongClickListener(new C07592());
        this.expandableListView.setOnGroupExpandListener(new C07603());
        this.expandableListView.setOnGroupCollapseListener(new C07614());
        this.expandableListView.setOnGroupClickListener(new C07625());
        return this.expandableListView;
    }

    /* renamed from: 绑定弹出菜单 */
    public void mo793() {
        C0880_应用操作类.m6700((ExpandableListView) getView());
        this.f4318 = false;
    }

    /* renamed from: 子项被单击 */
    public void mo1233(int groupid, int childid) {
        EventDispatcher.dispatchEvent(this, "子项被单击", Integer.valueOf(groupid), Integer.valueOf(childid));
    }

    /* renamed from: 子项被长按 */
    public void mo1234(int groupid, int childid) {
        EventDispatcher.dispatchEvent(this, "子项被长按", Integer.valueOf(groupid), Integer.valueOf(childid));
    }

    /* renamed from: 分组被长按 */
    public void mo1192(int groupid) {
        EventDispatcher.dispatchEvent(this, "分组被长按", Integer.valueOf(groupid));
    }

    /* renamed from: 子项按钮被单击 */
    public void mo1226(int groupid, int childid) {
        EventDispatcher.dispatchEvent(this, "子项按钮被单击", Integer.valueOf(groupid), Integer.valueOf(childid));
    }

    /* renamed from: 子项选择框被单击 */
    public void mo1235(int groupid, int childid, boolean 选择框状态) {
        EventDispatcher.dispatchEvent(this, "子项选择框被单击", Integer.valueOf(groupid), Integer.valueOf(childid), Boolean.valueOf(选择框状态));
    }

    /* renamed from: 分组被展开 */
    public void mo1190(int groupid) {
        EventDispatcher.dispatchEvent(this, "分组被展开", Integer.valueOf(groupid));
    }

    /* renamed from: 分组被收起 */
    public void mo1191(int groupid) {
        EventDispatcher.dispatchEvent(this, "分组被收起", Integer.valueOf(groupid));
    }

    /* renamed from: 分组被单击 */
    public void mo1189(int groupid) {
        EventDispatcher.dispatchEvent(this, "分组被单击", Integer.valueOf(groupid));
    }

    /* renamed from: 添加分组 */
    public int mo1242(String title, String info) {
        Map<String, String> map = new HashMap();
        map.put("title", title);
        map.put("info", info);
        map.put("tag", bi_常量类.f6358b);
        this.groups.add(map);
        this.childlist.add(new ArrayList());
        this.adapter.notifyDataSetChanged();
        return this.groups.size() - 1;
    }

    /* renamed from: 取分组标记 */
    public String mo1200(int position) {
        return (String) ((Map) this.groups.get(position)).get("tag");
    }

    /* renamed from: 置分组标记 */
    public void mo1248(int position, String tag) {
        ((Map) this.groups.get(position)).put("tag", tag);
    }

    /* renamed from: 取分组标题 */
    public String mo1201(int groupid) {
        return (String) ((Map) this.groups.get(groupid)).get("title");
    }

    /* renamed from: 置分组标题 */
    public void mo1249(int groupid, String title) {
        ((Map) this.groups.get(groupid)).put("title", title);
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 取分组信息 */
    public String mo1198(int groupid) {
        return (String) ((Map) this.groups.get(groupid)).get("info");
    }

    /* renamed from: 置分组信息 */
    public void mo1247(int groupid, String info) {
        ((Map) this.groups.get(groupid)).put("info", info);
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 取分组总数 */
    public int mo1199() {
        return this.groups.size();
    }

    /* renamed from: 删除分组 */
    public void mo1194(int groupid) {
        this.childlist.remove(groupid);
        this.groups.remove(groupid);
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 清空所有数据 */
    public void mo1246() {
        this.groups.clear();
        this.childlist.clear();
        this.items.clear();
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 添加子项 */
    public void mo1243(int groupid, String image, String title, String info, String buttonimage, String buttontitle) {
        Map<String, String> map = new HashMap();
        map.put("image", image);
        map.put("title", title);
        map.put("info", info);
        map.put("buttonimage", buttonimage);
        map.put("buttontitle", buttontitle);
        map.put("tag", bi_常量类.f6358b);
        map.put("check", "0");
        ((List) this.childlist.get(groupid)).add(map);
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 取子项选择框状态 */
    public boolean mo1210(int groupid, int childid) {
        if (((String) ((Map) ((List) this.childlist.get(groupid)).get(childid)).get("check")).equals(C0108a.f262e)) {
            return true;
        }
        return false;
    }

    /* renamed from: 置子项选择框状态 */
    public void mo1256(int groupid, int childid, boolean check) {
        Map<String, String> map = (Map) ((List) this.childlist.get(groupid)).get(childid);
        if (check) {
            map.put("check", C0108a.f262e);
        } else {
            map.put("check", "0");
        }
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 子项图片宽度 */
    public int mo1216() {
        return this.ImageWitdh;
    }

    /* renamed from: 子项图片宽度 */
    public void mo1217(int value) {
        this.ImageWitdh = value;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 子项图片高度 */
    public int mo1218() {
        return this.ImageHeight;
    }

    /* renamed from: 子项图片高度 */
    public void mo1219(int value) {
        this.ImageHeight = value;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 子项按钮宽度 */
    public int mo1224() {
        return this.ButtonWitdh;
    }

    /* renamed from: 子项按钮宽度 */
    public void mo1225(int value) {
        this.ButtonWitdh = value;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 子项按钮高度 */
    public int mo1227() {
        return this.ButtonHeight;
    }

    /* renamed from: 子项按钮高度 */
    public void mo1228(int value) {
        this.ButtonHeight = value;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 取子项标记 */
    public String mo1208(int groupid, int childid) {
        return (String) ((Map) ((List) this.childlist.get(groupid)).get(childid)).get("tag");
    }

    /* renamed from: 置子项标记 */
    public void mo1254(int groupid, int childid, String tag) {
        ((Map) ((List) this.childlist.get(groupid)).get(childid)).put("tag", tag);
    }

    /* renamed from: 取子项图片 */
    public String mo1204(int groupid, int childid) {
        return (String) ((Map) ((List) this.childlist.get(groupid)).get(childid)).get("image");
    }

    /* renamed from: 置子项图片 */
    public void mo1251(int groupid, int childid, String image) {
        ((Map) ((List) this.childlist.get(groupid)).get(childid)).put("image", image);
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 取子项标题 */
    public String mo1209(int groupid, int childid) {
        return (String) ((Map) ((List) this.childlist.get(groupid)).get(childid)).get("title");
    }

    /* renamed from: 置子项标题 */
    public void mo1255(int groupid, int childid, String title) {
        ((Map) ((List) this.childlist.get(groupid)).get(childid)).put("title", title);
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 取子项信息 */
    public String mo1203(int groupid, int childid) {
        return (String) ((Map) ((List) this.childlist.get(groupid)).get(childid)).get("info");
    }

    /* renamed from: 置子项信息 */
    public void mo1250(int groupid, int childid, String info) {
        ((Map) ((List) this.childlist.get(groupid)).get(childid)).put("info", info);
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 取子项按钮图片 */
    public String mo1206(int groupid, int childid) {
        return (String) ((Map) ((List) this.childlist.get(groupid)).get(childid)).get("buttonimage");
    }

    /* renamed from: 置子项按钮图片 */
    public void mo1252(int groupid, int childid, String buttonimage) {
        ((Map) ((List) this.childlist.get(groupid)).get(childid)).put("buttonimage", buttonimage);
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 取子项按钮标题 */
    public String mo1207(int groupid, int childid) {
        return (String) ((Map) ((List) this.childlist.get(groupid)).get(childid)).get("buttontitle");
    }

    /* renamed from: 置子项按钮标题 */
    public void mo1253(int groupid, int childid, String buttontitle) {
        ((Map) ((List) this.childlist.get(groupid)).get(childid)).put("buttontitle", buttontitle);
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 取子项总数 */
    public int mo1205(int groupid) {
        return ((List) this.childlist.get(groupid)).size();
    }

    /* renamed from: 删除子项 */
    public void mo1195(int groupid, int childid) {
        ((List) this.childlist.get(groupid)).remove(childid);
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 清空子项 */
    public void mo1245(int groupid) {
        ((List) this.childlist.get(groupid)).clear();
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 展开分组 */
    public void mo1236(int groupid) {
        this.expandableListView.expandGroup(groupid);
    }

    /* renamed from: 收起分组 */
    public void mo1237(int groupid) {
        this.expandableListView.collapseGroup(groupid);
    }

    /* renamed from: 取分组状态 */
    public boolean mo1202(int groupid) {
        return this.expandableListView.isGroupExpanded(groupid);
    }

    /* renamed from: 选中子项 */
    public void mo1262(int groupPosition, int childPosition, boolean shouldExpandGroup) {
        this.expandableListView.setSelectedChild(groupPosition, childPosition, shouldExpandGroup);
    }

    /* renamed from: 选中分组 */
    public void mo1261(int groupPosition) {
        this.expandableListView.setSelectedGroup(groupPosition);
    }

    /* renamed from: 显示子项按钮 */
    public void mo1238(boolean value) {
        this.haveButton = value;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 显示子项按钮 */
    public boolean mo1239() {
        return this.haveButton;
    }

    /* renamed from: 显示子项选择框 */
    public void mo1240(boolean value) {
        this.haveCheck = value;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 显示子项选择框 */
    public boolean mo1241() {
        return this.haveCheck;
    }

    /* renamed from: 分组标题字体大小 */
    public float mo1185() {
        return this.groupTitletextSize;
    }

    /* renamed from: 分组标题字体大小 */
    public void mo1186(float size) {
        this.groupTitletextSize = size;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 分组标题字体颜色 */
    public int mo1187() {
        return this.groupTitletextColor;
    }

    /* renamed from: 分组标题字体颜色 */
    public void mo1188(int argb) {
        this.groupTitletextColor = argb;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 分组信息字体大小 */
    public float mo1181() {
        return this.groupInfotextSize;
    }

    /* renamed from: 分组信息字体大小 */
    public void mo1182(float size) {
        this.groupInfotextSize = size;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 分组信息字体颜色 */
    public int mo1183() {
        return this.groupInfotextColor;
    }

    /* renamed from: 分组信息字体颜色 */
    public void mo1184(int argb) {
        this.groupInfotextColor = argb;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 子项标题字体大小 */
    public float mo1229() {
        return this.childTitletextSize;
    }

    /* renamed from: 子项标题字体大小 */
    public void mo1230(float size) {
        this.childTitletextSize = size;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 子项标题字体颜色 */
    public int mo1231() {
        return this.childTitletextColor;
    }

    /* renamed from: 子项标题字体颜色 */
    public void mo1232(int argb) {
        this.childTitletextColor = argb;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 子项信息字体大小 */
    public float mo1212() {
        return this.childInfotextSize;
    }

    /* renamed from: 子项信息字体大小 */
    public void mo1213(float size) {
        this.childInfotextSize = size;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 子项信息字体颜色 */
    public int mo1214() {
        return this.childInfotextColor;
    }

    /* renamed from: 子项信息字体颜色 */
    public void mo1215(int argb) {
        this.childInfotextColor = argb;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 子项按钮字体大小 */
    public float mo1220() {
        return this.childButtontextSize;
    }

    /* renamed from: 子项按钮字体大小 */
    public void mo1221(float size) {
        this.childButtontextSize = size;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 子项按钮字体颜色 */
    public int mo1222() {
        return this.childButtontextColor;
    }

    /* renamed from: 子项按钮字体颜色 */
    public void mo1223(int argb) {
        this.childButtontextColor = argb;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 加载超文本 */
    public void mo1196(boolean value) {
        this.richtext = value;
        this.adapter.notifyDataSetChanged();
    }

    /* renamed from: 加载超文本 */
    public boolean mo1197() {
        return this.richtext;
    }

    /* renamed from: 背景图片 */
    public String mo1257() {
        return this.backgroundImage;
    }

    /* renamed from: 背景图片 */
    public void mo1258(String imagePath) {
        this.backgroundImage = imagePath;
        Drawable drawable = null;
        if (imagePath.length() > 0) {
            if (!imagePath.startsWith("/")) {
                try {
                    drawable = Drawable.createFromStream(mainActivity.getContext().getResources().getAssets().open(imagePath), imagePath);
                } catch (IOException e) {
                }
            } else if (new File(imagePath).exists()) {
                drawable = Drawable.createFromPath(imagePath);
            }
            this.expandableListView.setBackgroundDrawable(drawable);
            this.expandableListView.invalidate();
        }
    }

    /* renamed from: 背景图片2 */
    public int mo12592() {
        return this.backgroundImage2;
    }

    /* renamed from: 背景图片2 */
    public void mo12602(int id) {
        this.backgroundImage2 = id;
        getView().setBackgroundResource(id);
    }

    /* renamed from: 清空下载缓存 */
    public void mo1244() {
        if (this.options != null && this.imageLoader != null) {
            this.imageLoader.clearMemoryCache();
            this.imageLoader.clearDiskCache();
        }
    }

    /* renamed from: 初始化下载引擎 */
    public void mo1193(int 加载过程中显示的图片资源索引, int 加载内容为空时显示的图片资源索引, int 加载失败时显示的图片资源索引, int 图片圆角弧度, boolean 是否监听加载完毕) {
        ImageLoader.getInstance().init(new Builder(C0841.m6594()).threadPriority(10).denyCacheImageMultipleSizesInMemory().diskCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).writeDebugLogs().build());
        this.imageLoader = ImageLoader.getInstance();
        if (图片圆角弧度 > 0) {
            this.options = new DisplayImageOptions.Builder().showImageOnLoading(加载过程中显示的图片资源索引).showImageForEmptyUri(加载内容为空时显示的图片资源索引).showImageOnFail(加载失败时显示的图片资源索引).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(Config.RGB_565).displayer(new RoundedBitmapDisplayer(图片圆角弧度)).build();
        } else {
            this.options = new DisplayImageOptions.Builder().showImageOnLoading(加载过程中显示的图片资源索引).showImageForEmptyUri(加载内容为空时显示的图片资源索引).showImageOnFail(加载失败时显示的图片资源索引).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(Config.RGB_565).displayer(new SimpleBitmapDisplayer()).build();
        }
        this.f4319 = 是否监听加载完毕;
    }

    /* renamed from: 图片加载完毕 */
    public void mo1211(boolean 加载结果, String 图片地址, byte[] 图片数据) {
        EventDispatcher.dispatchEvent(this, "图片加载完毕", Boolean.valueOf(加载结果), 图片地址, 图片数据);
    }

    private byte[] Bitmap2Bytes(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
}
