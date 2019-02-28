package com.e4a.runtime.components.impl.android.n18;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.android.ViewComponent;
import com.e4a.runtime.events.EventDispatcher;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.n18.列表框Impl */
public class C0716Impl extends ViewComponent implements C0714, OnItemClickListener, OnItemLongClickListener, OnScrollListener {
    private MyAdapter Adapter;
    private int FirstVisibleItem;
    private int TotalItemCount;
    private int VisibleItemCount;
    private String backgroundImage = bi_常量类.f6358b_空串;
    private int backgroundImage2 = -1;
    private List<Map<String, String>> data;
    private boolean richtext = false;
    private boolean suolve = false;
    private int textColor = -1;
    private float textSize = 9.0f;
    /* renamed from: 不弹出菜单 */
    private boolean f4290 = true;
    /* renamed from: 对齐方式 */
    private int f4291 = -1;
    /* renamed from: 自动拉伸 */
    private boolean f4292 = false;

    /* renamed from: com.e4a.runtime.components.impl.android.n18.列表框Impl$1 */
    class C07151 implements ImageGetter {
        C07151() {
        }

        public Drawable getDrawable(String source) {
            Drawable d = mainActivity.getContext().getResources().getDrawable(Integer.parseInt(source));
            d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
            return d;
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n18.列表框Impl$MyAdapter */
    private class MyAdapter extends BaseAdapter {
        private MyAdapter() {
        }

        public int getCount() {
            return C0716Impl.this.data.size();
        }

        public Object getItem(int position) {
            return Integer.valueOf(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView result = (TextView) convertView;
            if (result == null) {
                result = new TextView(mainActivity.getContext());
                result.setPadding(15, 15, 15, 15);
                if (C0716Impl.this.suolve) {
                    result.setSingleLine(true);
                    result.setEllipsize(TruncateAt.valueOf("END"));
                }
                result.setGravity(4);
            }
            if (C0880_应用操作类.m6699()) {
                result.setTextSize(0, C0880_应用操作类.m6713(C0716Impl.this.textSize));
            } else {
                result.setTextSize(C0716Impl.this.textSize);
            }
            result.setTextColor(C0716Impl.this.textColor);
            if (C0716Impl.this.f4291 > -1) {
                int gravity = 19;
                switch (C0716Impl.this.f4291) {
                    case 3:
                        gravity = 51;
                        break;
                    case 4:
                        gravity = 19;
                        break;
                    case 5:
                        gravity = 83;
                        break;
                    case 6:
                        gravity = 49;
                        break;
                    case 7:
                        gravity = 17;
                        break;
                    case 8:
                        gravity = 81;
                        break;
                    case 9:
                        gravity = 53;
                        break;
                    case 10:
                        gravity = 21;
                        break;
                    case 11:
                        gravity = 85;
                        break;
                }
                result.setGravity(gravity);
            }
            if (C0716Impl.this.richtext) {
                C0716Impl.this.m5677(result, (String) ((Map) C0716Impl.this.data.get(position)).get("title"));
            } else {
                result.setText((CharSequence) ((Map) C0716Impl.this.data.get(position)).get("title"));
            }
            return result;
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n18.列表框Impl$NoScrollListView */
    public class NoScrollListView extends ListView {
        public NoScrollListView(Context context) {
            super(context);
        }

        public NoScrollListView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public NoScrollListView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int expandSpec;
            if (C0716Impl.this.f4292) {
                expandSpec = MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
            } else {
                expandSpec = heightMeasureSpec;
            }
            super.onMeasure(widthMeasureSpec, expandSpec);
        }
    }

    /* renamed from: 自动拉伸高度 */
    public void mo1007(boolean value) {
        this.f4292 = value;
        this.Adapter.notifyDataSetChanged();
    }

    /* renamed from: 加载超文本 */
    public void mo985(boolean value) {
        this.richtext = value;
        this.Adapter.notifyDataSetChanged();
    }

    /* renamed from: 加载超文本 */
    public boolean mo986() {
        return this.richtext;
    }

    public C0716Impl(ComponentContainer container) {
        super(container);
    }

    protected View createView() {
        NoScrollListView view = new NoScrollListView(mainActivity.getContext());
        view.setFocusable(true);
        this.data = new ArrayList();
        this.Adapter = new MyAdapter();
        view.setAdapter(this.Adapter);
        view.setOnItemClickListener(this);
        view.setOnItemLongClickListener(this);
        view.setOnScrollListener(this);
        view.setCacheColorHint(0);
        return view;
    }

    /* renamed from: 绑定弹出菜单 */
    public void mo793() {
        C0880_应用操作类.m6700((NoScrollListView) getView());
        this.f4290 = false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        mo1008(position);
    }

    /* renamed from: 表项被单击 */
    public void mo1008(int position) {
        EventDispatcher.dispatchEvent(this, "表项被单击", Integer.valueOf(position));
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        mo1010(position);
        return this.f4290;
    }

    /* renamed from: 表项被长按 */
    public void mo1010(int position) {
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
                mo1009(this.FirstVisibleItem, this.VisibleItemCount, this.TotalItemCount);
                return;
            default:
                return;
        }
    }

    /* renamed from: 表项被滚动 */
    public void mo1009(int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        EventDispatcher.dispatchEvent(this, "表项被滚动", Integer.valueOf(firstVisibleItem), Integer.valueOf(visibleItemCount), Integer.valueOf(totalItemCount));
    }

    /* renamed from: 添加项目 */
    public void mo995(String title) {
        Map<String, String> map = new HashMap();
        map.put("title", title);
        map.put("tag", bi_常量类.f6358b_空串);
        this.data.add(map);
        this.Adapter.notifyDataSetChanged();
    }

    /* renamed from: 插入项目 */
    public void mo994(int index, String title) {
        Map<String, String> map = new HashMap();
        map.put("title", title);
        map.put("tag", bi_常量类.f6358b_空串);
        this.data.add(index, map);
        this.Adapter.notifyDataSetChanged();
    }

    /* renamed from: 删除项目 */
    public void mo984(int position) {
        this.data.remove(position);
        this.Adapter.notifyDataSetChanged();
    }

    /* renamed from: 清空项目 */
    public void mo996() {
        this.data.clear();
        this.Adapter.notifyDataSetChanged();
    }

    /* renamed from: 取项目数 */
    public int mo988() {
        return this.data.size();
    }

    /* renamed from: 取项目内容 */
    public String mo987(int position) {
        return (String) ((Map) this.data.get(position)).get("title");
    }

    /* renamed from: 置项目内容 */
    public void mo1000(int position, String title) {
        ((Map) this.data.get(position)).put("title", title);
        this.Adapter.notifyDataSetChanged();
    }

    /* renamed from: 置现行选中项 */
    public void mo999(int position) {
        ((NoScrollListView) getView()).setSelection(position);
    }

    /* renamed from: 取项目标记 */
    public String mo989(int position) {
        return (String) ((Map) this.data.get(position)).get("tag");
    }

    /* renamed from: 置项目标记 */
    public void mo1002(int position, String tag) {
        ((Map) this.data.get(position)).put("tag", tag);
    }

    /* renamed from: 置项目对齐方式 */
    public void mo1001(int value) {
        this.f4291 = value;
        this.Adapter.notifyDataSetChanged();
    }

    /* renamed from: 字体大小 */
    public float mo990() {
        return this.textSize;
    }

    /* renamed from: 字体大小 */
    public void mo991(float size) {
        this.textSize = size;
        this.Adapter.notifyDataSetChanged();
    }

    /* renamed from: 字体颜色 */
    public int mo992() {
        return this.textColor;
    }

    /* renamed from: 字体颜色 */
    public void mo993(int argb) {
        this.textColor = argb;
        this.Adapter.notifyDataSetChanged();
    }

    /* renamed from: 背景图片 */
    public String mo1003() {
        return this.backgroundImage;
    }

    /* renamed from: 背景图片 */
    public void mo1004(String imagePath) {
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
            NoScrollListView view = (NoScrollListView) getView();
            view.setBackgroundDrawable(drawable);
            view.invalidate();
        }
    }

    /* renamed from: 背景图片2 */
    public int mo10052() {
        return this.backgroundImage2;
    }

    /* renamed from: 背景图片2 */
    public void mo10062(int id) {
        this.backgroundImage2 = id;
        getView().setBackgroundResource(id);
    }

    /* renamed from: 缩略内容 */
    public boolean mo998() {
        return this.suolve;
    }

    /* renamed from: 缩略内容 */
    public void mo997(boolean value) {
        this.suolve = value;
    }

    /* renamed from: 加载超文本内容 */
    private void m5677(TextView view, String html) {
        view.setText(Html.fromHtml(html, new C07151(), null));
        view.invalidate();
    }
}
