package com.e4a.runtime.components.impl.android.n30;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.e4a.runtime.C0841;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.C0894;
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

/* renamed from: com.e4a.runtime.components.impl.android.n30.图片列表框Impl */
public class C0731Impl extends ViewComponent implements C0726, OnItemClickListener, OnItemLongClickListener, OnScrollListener {
    private int FirstVisibleItem;
    private int TitleBackColor = 0;
    private int TitletextColor = -1;
    private float TitletextSize = 9.0f;
    private int TotalItemCount;
    private int VisibleItemCount;
    private String backgroundImage = bi_常量类.f6358b_空串;
    private int backgroundImage2 = -1;
    private int horizontalSpacing = 15;
    private ImageAdapter imageAdapter;
    private int imageHeight = 50;
    private ImageLoader imageLoader;
    private int imageWitdh = 50;
    private Set<Integer> items;
    private List<Map<String, String>> listItems;
    ImageLoadingListener listener = new C07293();
    private GestureDetector mGestureDetector;
    private int numColumns = 3;
    private DisplayImageOptions options;
    private boolean richtext = false;
    private int verticalSpacing = 15;
    /* renamed from: 不弹出菜单 */
    private boolean f4302 = true;
    /* renamed from: 副标题字体大小 */
    private float f4303 = 9.0f;
    /* renamed from: 副标题字体颜色 */
    private int f4304 = -1;
    /* renamed from: 图片显示方式 */
    private int f4305 = 1;
    /* renamed from: 外边距 */
    private int f4306 = 0;
    /* renamed from: 是否显示副标题 */
    private boolean f4307 = false;
    /* renamed from: 是否显示标题 */
    private boolean f4308 = true;
    /* renamed from: 样式文件 */
    private int f4309 = -1;
    /* renamed from: 监听加载完毕 */
    private boolean f4310 = false;
    /* renamed from: 自动拉伸 */
    private boolean f4311 = false;

    /* renamed from: com.e4a.runtime.components.impl.android.n30.图片列表框Impl$1 */
    class C07271 extends SimpleOnGestureListener {
        C07271() {
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            int deltaX = (int) (e1.getRawX() - e2.getRawX());
            if (Math.abs(deltaX) <= Math.abs((int) (e1.getRawY() - e2.getRawY()))) {
                return false;
            }
            C0731Impl.this.mo1119(deltaX > 0 ? 4 : 5);
            return true;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        public boolean onSingleTapConfirmed(MotionEvent e) {
            return false;
        }

        public boolean onDoubleTap(MotionEvent e) {
            return false;
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n30.图片列表框Impl$2 */
    class C07282 implements OnTouchListener {
        C07282() {
        }

        public boolean onTouch(View view, MotionEvent event) {
            if (C0731Impl.this.mGestureDetector.onTouchEvent(event)) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n30.图片列表框Impl$3 */
    class C07293 implements ImageLoadingListener {
        C07293() {
        }

        public void onLoadingStarted(String paramString, View paramView) {
        }

        public void onLoadingFailed(String paramString, View paramView, FailReason paramFailReason) {
            C0731Impl.this.mo1081(false, paramString, null);
        }

        public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap) {
            C0731Impl.this.mo1081(true, paramString, C0731Impl.this.Bitmap2Bytes(paramBitmap));
        }

        public void onLoadingCancelled(String paramString, View paramView) {
            C0731Impl.this.mo1081(false, paramString, null);
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n30.图片列表框Impl$ImageAdapter */
    private class ImageAdapter extends BaseAdapter {
        private Context context;
        private List<Map<String, String>> listItems;

        /* renamed from: com.e4a.runtime.components.impl.android.n30.图片列表框Impl$ImageAdapter$1 */
        class C07301 implements ImageGetter {
            C07301() {
            }

            public Drawable getDrawable(String source) {
                Drawable d = mainActivity.getContext().getResources().getDrawable(Integer.parseInt(source));
                d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
                return d;
            }
        }

        /* renamed from: com.e4a.runtime.components.impl.android.n30.图片列表框Impl$ImageAdapter$ListItemView */
        public final class ListItemView {
            public ImageView image;
            public TextView title;
            /* renamed from: 副标题 */
            public TextView f4300;
            /* renamed from: 消息数 */
            public TextView f4301;
        }

        public ImageAdapter(Context context, List<Map<String, String>> listItems) {
            this.context = context;
            this.listItems = listItems;
        }

        public int getCount() {
            return this.listItems.size();
        }

        public Object getItem(int arg0) {
            return null;
        }

        public long getItemId(int arg0) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (this.listItems.size() == 0) {
                return null;
            }
            ListItemView listItemView;
            if (convertView == null) {
                listItemView = new ListItemView();
                View layout = new LinearLayout(this.context);
                layout.setOrientation(1);
                if (C0731Impl.this.f4309 != -1) {
                    layout.setBackgroundResource(C0731Impl.this.f4309);
                }
                LayoutParams image = new LayoutParams(m5862(C0731Impl.this.imageWitdh), m5862(C0731Impl.this.imageHeight));
                image.gravity = 17;
                image.setMargins(m5862(C0731Impl.this.f4306), m5862(C0731Impl.this.f4306), m5862(C0731Impl.this.f4306), m5862(C0731Impl.this.f4306));
                RelativeLayout relayout = new RelativeLayout(this.context);
                RelativeLayout.LayoutParams 图片 = new RelativeLayout.LayoutParams(-1, -1);
                图片.addRule(13);
                listItemView.image = new ImageView(this.context);
                relayout.addView(listItemView.image, 图片);
                RelativeLayout.LayoutParams 消息数 = new RelativeLayout.LayoutParams(m5862(20), m5862(20));
                消息数.addRule(11);
                listItemView.f4301 = new TextView(this.context);
                listItemView.f4301.setLayoutParams(消息数);
                relayout.addView(listItemView.f4301, 消息数);
                listItemView.f4300 = new TextView(this.context);
                listItemView.f4300.setBackgroundColor(1686143104);
                listItemView.f4300.setGravity(17);
                RelativeLayout.LayoutParams param2 = new RelativeLayout.LayoutParams(-1, -2);
                param2.addRule(12);
                relayout.addView(listItemView.f4300, param2);
                layout.addView(relayout, image);
                LayoutParams title = new LayoutParams(-1, -2);
                title.gravity = 17;
                listItemView.title = new TextView(this.context);
                listItemView.title.setBackgroundColor(C0731Impl.this.TitleBackColor);
                listItemView.title.setGravity(17);
                listItemView.title.setLayoutParams(title);
                layout.addView(listItemView.title, title);
                convertView = layout;
                convertView.setTag(listItemView);
            } else {
                listItemView = (ListItemView) convertView.getTag();
            }
            String imagePath = (String) ((Map) this.listItems.get(position)).get("image");
            if (C0731Impl.this.f4305 == 1) {
                listItemView.image.setScaleType(ScaleType.FIT_XY);
            } else if (C0731Impl.this.f4305 == 2) {
                listItemView.image.setScaleType(ScaleType.CENTER_INSIDE);
            } else {
                listItemView.image.setScaleType(ScaleType.FIT_CENTER);
            }
            if (C0731Impl.this.options == null || C0731Impl.this.imageLoader == null) {
                listItemView.image.setBackgroundDrawable(getDrawable(imagePath));
            } else if (C0731Impl.this.f4310) {
                Integer id = new Integer(position);
                if (C0731Impl.this.items.contains(id)) {
                    C0731Impl.this.imageLoader.displayImage(imagePath, listItemView.image, C0731Impl.this.options);
                } else {
                    C0731Impl.this.items.add(id);
                    C0731Impl.this.imageLoader.displayImage(imagePath, listItemView.image, C0731Impl.this.options, C0731Impl.this.listener);
                }
            } else {
                C0731Impl.this.imageLoader.displayImage(imagePath, listItemView.image, C0731Impl.this.options);
            }
            String messagecount = (String) ((Map) this.listItems.get(position)).get("count");
            if (Integer.parseInt(messagecount) > 0) {
                listItemView.f4301.setBackgroundResource(C0894.m6890("e4alistview_new_message", "drawable"));
                listItemView.f4301.setVisibility(0);
                listItemView.f4301.setTextSize(9.0f);
                listItemView.f4301.setTextColor(-1);
                listItemView.f4301.setGravity(17);
                listItemView.f4301.setText(messagecount);
            } else {
                listItemView.f4301.setVisibility(4);
            }
            if (C0880_应用操作类.m6699()) {
                listItemView.f4300.setTextSize(0, C0880_应用操作类.m6713(C0731Impl.this.f4303));
            } else {
                listItemView.f4300.setTextSize(C0731Impl.this.f4303);
            }
            listItemView.f4300.setTextColor(C0731Impl.this.f4304);
            if (C0731Impl.this.f4307) {
                listItemView.f4300.setVisibility(0);
            } else {
                listItemView.f4300.setVisibility(8);
            }
            if (C0731Impl.this.richtext) {
                m5861(listItemView.f4300, (String) ((Map) this.listItems.get(position)).get("副标题"));
            } else {
                listItemView.f4300.setText((CharSequence) ((Map) this.listItems.get(position)).get("副标题"));
            }
            if (C0880_应用操作类.m6699()) {
                listItemView.title.setTextSize(0, C0880_应用操作类.m6713(C0731Impl.this.TitletextSize));
            } else {
                listItemView.title.setTextSize(C0731Impl.this.TitletextSize);
            }
            listItemView.title.setTextColor(C0731Impl.this.TitletextColor);
            if (C0731Impl.this.f4308) {
                listItemView.title.setVisibility(0);
            } else {
                listItemView.title.setVisibility(8);
            }
            if (C0731Impl.this.richtext) {
                m5861(listItemView.title, (String) ((Map) this.listItems.get(position)).get("title"));
            } else {
                listItemView.title.setText((CharSequence) ((Map) this.listItems.get(position)).get("title"));
            }
            return convertView;
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
        private int m5862(int value) {
            if (value < 0) {
                return value;
            }
            return (int) ((((float) value) * this.context.getResources().getDisplayMetrics().density) + 0.5f);
        }

        /* renamed from: 加载超文本内容 */
        private void m5861(TextView view, String html) {
            view.setText(Html.fromHtml(html, new C07301(), null));
            view.invalidate();
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n30.图片列表框Impl$NoScrollGridView */
    public class NoScrollGridView extends GridView {
        public NoScrollGridView(Context context) {
            super(context);
        }

        public NoScrollGridView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public NoScrollGridView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int expandSpec;
            if (C0731Impl.this.f4311) {
                expandSpec = MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
            } else {
                expandSpec = heightMeasureSpec;
            }
            super.onMeasure(widthMeasureSpec, expandSpec);
        }
    }

    /* renamed from: 自动拉伸高度 */
    public void mo1113(boolean value) {
        this.f4311 = value;
        this.imageAdapter.notifyDataSetChanged();
    }

    public C0731Impl(ComponentContainer container) {
        super(container);
    }

    protected View createView() {
        NoScrollGridView view = new NoScrollGridView(mainActivity.getContext());
        view.setNumColumns(this.numColumns);
        view.setStretchMode(2);
        view.setGravity(17);
        view.setPadding(0, 0, 0, 0);
        view.setHorizontalSpacing(this.horizontalSpacing);
        view.setVerticalSpacing(this.verticalSpacing);
        this.listItems = new ArrayList();
        this.items = new HashSet();
        this.imageAdapter = new ImageAdapter(mainActivity.getContext(), this.listItems);
        view.setAdapter(this.imageAdapter);
        view.setOnItemClickListener(this);
        view.setOnItemLongClickListener(this);
        view.setOnScrollListener(this);
        view.setCacheColorHint(0);
        return view;
    }

    /* renamed from: 监听触摸手势 */
    public void mo1100() {
        this.mGestureDetector = new GestureDetector(new C07271());
        ((NoScrollGridView) getView()).setOnTouchListener(new C07282());
    }

    /* renamed from: 触摸手势 */
    public void mo1119(int direction) {
        EventDispatcher.dispatchEvent(this, "触摸手势", Integer.valueOf(direction));
    }

    /* renamed from: 绑定弹出菜单 */
    public void mo793() {
        C0880_应用操作类.m6700((NoScrollGridView) getView());
        this.f4302 = false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        mo1116(position);
    }

    /* renamed from: 表项被单击 */
    public void mo1116(int position) {
        EventDispatcher.dispatchEvent(this, "表项被单击", Integer.valueOf(position));
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        mo1118(position);
        return this.f4302;
    }

    /* renamed from: 表项被长按 */
    public void mo1118(int position) {
        EventDispatcher.dispatchEvent(this, "表项被长按", Integer.valueOf(position));
    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.FirstVisibleItem = firstVisibleItem;
        this.VisibleItemCount = visibleItemCount;
        this.TotalItemCount = totalItemCount;
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
            case 0:
                mo1117(this.FirstVisibleItem, this.VisibleItemCount, this.TotalItemCount);
                return;
            default:
                return;
        }
    }

    /* renamed from: 表项被滚动 */
    public void mo1117(int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        EventDispatcher.dispatchEvent(this, "表项被滚动", Integer.valueOf(firstVisibleItem), Integer.valueOf(visibleItemCount), Integer.valueOf(totalItemCount));
    }

    /* renamed from: 添加项目 */
    public void mo1097(String image, String title) {
        Map<String, String> map = new HashMap();
        map.put("image", image);
        map.put("title", title);
        map.put("副标题", bi_常量类.f6358b_空串);
        map.put("tag", bi_常量类.f6358b_空串);
        map.put("count", "0");
        this.listItems.add(map);
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 插入项目 */
    public void mo1092(int index, String image, String title) {
        Map<String, String> map = new HashMap();
        map.put("image", image);
        map.put("title", title);
        map.put("副标题", bi_常量类.f6358b_空串);
        map.put("tag", bi_常量类.f6358b_空串);
        map.put("count", "0");
        this.listItems.add(index, map);
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 删除项目 */
    public void mo1067(int position) {
        this.listItems.remove(position);
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 清空项目 */
    public void mo1099() {
        this.listItems.clear();
        this.items.clear();
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 取项目数 */
    public int mo1077() {
        return this.listItems.size();
    }

    /* renamed from: 取项目图片 */
    public String mo1076(int position) {
        return (String) ((Map) this.listItems.get(position)).get("image");
    }

    /* renamed from: 置项目图片 */
    public void mo1104(int position, String image) {
        ((Map) this.listItems.get(position)).put("image", image);
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 取项目消息数 */
    public int mo1080(int position) {
        return Integer.parseInt((String) ((Map) this.listItems.get(position)).get("count"));
    }

    /* renamed from: 置项目消息数 */
    public void mo1108(int position, int count) {
        ((Map) this.listItems.get(position)).put("count", Integer.toString(count));
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 置项目样式 */
    public void mo1107(int xml样式文件资源索引) {
        this.f4309 = xml样式文件资源索引;
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 取项目标题 */
    public String mo1079(int position) {
        return (String) ((Map) this.listItems.get(position)).get("title");
    }

    /* renamed from: 置项目标题 */
    public void mo1106(int position, String title) {
        ((Map) this.listItems.get(position)).put("title", title);
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 隐藏标题 */
    public void mo1121() {
        this.f4308 = false;
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 显示标题 */
    public void mo1094() {
        this.f4308 = true;
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 隐藏副标题 */
    public void mo1120() {
        this.f4307 = false;
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 显示副标题 */
    public void mo1093() {
        this.f4307 = true;
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 取项目副标题 */
    public String mo1075(int position) {
        return (String) ((Map) this.listItems.get(position)).get("副标题");
    }

    /* renamed from: 置项目副标题 */
    public void mo1103(int position, String title) {
        ((Map) this.listItems.get(position)).put("副标题", title);
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 取项目标记 */
    public String mo1078(int position) {
        return (String) ((Map) this.listItems.get(position)).get("tag");
    }

    /* renamed from: 置项目标记 */
    public void mo1105(int position, String tag) {
        ((Map) this.listItems.get(position)).put("tag", tag);
    }

    /* renamed from: 置现行选中项 */
    public void mo1102(int position) {
        ((NoScrollGridView) getView()).setSelection(position);
    }

    /* renamed from: 取图片显示方式 */
    public int mo1074() {
        return this.f4305;
    }

    /* renamed from: 置图片显示方式 */
    public void mo1101(int 方式) {
        this.f4305 = 方式;
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 加载超文本 */
    public void mo1072(boolean value) {
        this.richtext = value;
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 加载超文本 */
    public boolean mo1073() {
        return this.richtext;
    }

    /* renamed from: 字体大小 */
    public float mo1088() {
        return this.TitletextSize;
    }

    /* renamed from: 字体大小 */
    public void mo1089(float size) {
        this.TitletextSize = size;
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 字体颜色 */
    public int mo1090() {
        return this.TitletextColor;
    }

    /* renamed from: 字体颜色 */
    public void mo1091(int argb) {
        this.TitletextColor = argb;
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 标题背景颜色 */
    public int mo1095() {
        return this.TitleBackColor;
    }

    /* renamed from: 标题背景颜色 */
    public void mo1096(int argb) {
        this.TitleBackColor = argb;
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 副标题字体大小 */
    public float mo1068() {
        return this.f4303;
    }

    /* renamed from: 副标题字体大小 */
    public void mo1069(float size) {
        this.f4303 = size;
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 副标题字体颜色 */
    public int mo1070() {
        return this.f4304;
    }

    /* renamed from: 副标题字体颜色 */
    public void mo1071(int argb) {
        this.f4304 = argb;
        this.imageAdapter.notifyDataSetChanged();
    }

    /* renamed from: 列数 */
    public int mo1062() {
        return this.numColumns;
    }

    /* renamed from: 列数 */
    public void mo1063(int value) {
        this.numColumns = value;
        NoScrollGridView view = (NoScrollGridView) getView();
        view.setNumColumns(this.numColumns);
        view.invalidate();
    }

    /* renamed from: 行间距 */
    public int mo1114() {
        return this.horizontalSpacing;
    }

    /* renamed from: 行间距 */
    public void mo1115(int value) {
        this.horizontalSpacing = value;
        NoScrollGridView view = (NoScrollGridView) getView();
        view.setHorizontalSpacing(this.horizontalSpacing);
        view.invalidate();
    }

    /* renamed from: 列间距 */
    public int mo1064() {
        return this.verticalSpacing;
    }

    /* renamed from: 列间距 */
    public void mo1065(int value) {
        this.verticalSpacing = value;
        NoScrollGridView view = (NoScrollGridView) getView();
        view.setVerticalSpacing(this.verticalSpacing);
        view.invalidate();
    }

    /* renamed from: 图片宽度 */
    public int mo1084() {
        return this.imageWitdh;
    }

    /* renamed from: 图片宽度 */
    public void mo1085(int value) {
        this.imageWitdh = value;
        ((NoScrollGridView) getView()).invalidate();
    }

    /* renamed from: 图片高度 */
    public int mo1086() {
        return this.imageHeight;
    }

    /* renamed from: 图片高度 */
    public void mo1087(int value) {
        this.imageHeight = value;
        ((NoScrollGridView) getView()).invalidate();
    }

    /* renamed from: 图片外边距 */
    public int mo1082() {
        return this.f4306;
    }

    /* renamed from: 图片外边距 */
    public void mo1083(int value) {
        this.f4306 = value;
        ((NoScrollGridView) getView()).invalidate();
    }

    /* renamed from: 背景图片 */
    public String mo1109() {
        return this.backgroundImage;
    }

    /* renamed from: 背景图片 */
    public void mo1110(String imagePath) {
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
            NoScrollGridView view = (NoScrollGridView) getView();
            view.setBackgroundDrawable(drawable);
            view.invalidate();
        }
    }

    /* renamed from: 背景图片2 */
    public int mo11112() {
        return this.backgroundImage2;
    }

    /* renamed from: 背景图片2 */
    public void mo11122(int id) {
        this.backgroundImage2 = id;
        getView().setBackgroundResource(id);
    }

    /* renamed from: 清空下载缓存 */
    public void mo1098() {
        if (this.options != null && this.imageLoader != null) {
            this.imageLoader.clearMemoryCache();
            this.imageLoader.clearDiskCache();
        }
    }

    /* renamed from: 初始化下载引擎 */
    public void mo1066(int 加载过程中显示的图片资源索引, int 加载内容为空时显示的图片资源索引, int 加载失败时显示的图片资源索引, int 图片圆角弧度, boolean 是否监听加载完毕) {
        ImageLoader.getInstance().init(new Builder(C0841.m6594()).threadPriority(10).denyCacheImageMultipleSizesInMemory().diskCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).writeDebugLogs().build());
        this.imageLoader = ImageLoader.getInstance();
        if (图片圆角弧度 > 0) {
            this.options = new DisplayImageOptions.Builder().showImageOnLoading(加载过程中显示的图片资源索引).showImageForEmptyUri(加载内容为空时显示的图片资源索引).showImageOnFail(加载失败时显示的图片资源索引).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(Config.RGB_565).displayer(new RoundedBitmapDisplayer(图片圆角弧度)).build();
        } else {
            this.options = new DisplayImageOptions.Builder().showImageOnLoading(加载过程中显示的图片资源索引).showImageForEmptyUri(加载内容为空时显示的图片资源索引).showImageOnFail(加载失败时显示的图片资源索引).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(Config.RGB_565).displayer(new SimpleBitmapDisplayer()).build();
        }
        this.f4310 = 是否监听加载完毕;
    }

    /* renamed from: 图片加载完毕 */
    public void mo1081(boolean 加载结果, String 图片地址, byte[] 图片数据) {
        EventDispatcher.dispatchEvent(this, "图片加载完毕", Boolean.valueOf(加载结果), 图片地址, 图片数据);
    }

    private byte[] Bitmap2Bytes(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
}
