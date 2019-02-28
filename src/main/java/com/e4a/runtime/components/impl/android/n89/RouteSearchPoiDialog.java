package com.e4a.runtime.components.impl.android.n89;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import com.amap.api.services.core.PoiItem;
import com.e4a.runtime.C0894;
import java.util.List;

public class RouteSearchPoiDialog extends Dialog implements OnItemClickListener, OnItemSelectedListener {
    private RouteSearchAdapter adapter;
    private Context context;
    protected OnListItemClick mOnClickListener;
    private List<PoiItem> poiItems;

    /* renamed from: com.e4a.runtime.components.impl.android.n89.RouteSearchPoiDialog$1 */
    class C07771 implements OnItemClickListener {
        C07771() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            RouteSearchPoiDialog.this.dismiss();
            RouteSearchPoiDialog.this.mOnClickListener.onListItemClick(RouteSearchPoiDialog.this, (PoiItem) RouteSearchPoiDialog.this.poiItems.get(position));
        }
    }

    public interface OnListItemClick {
        void onListItemClick(RouteSearchPoiDialog routeSearchPoiDialog, PoiItem poiItem);
    }

    public RouteSearchPoiDialog(Context context) {
        this(context, 16973835);
    }

    public RouteSearchPoiDialog(Context context, int theme) {
        super(context, theme);
    }

    public RouteSearchPoiDialog(Context context, List<PoiItem> poiItems) {
        this(context, 16973835);
        this.poiItems = poiItems;
        this.context = context;
        this.adapter = new RouteSearchAdapter(context, poiItems);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0894.m6890("routesearch_list_poi", "layout"));
        ListView listView = (ListView) findViewById(C0894.m6890("ListView_nav_search_list_poi", "id"));
        listView.setAdapter(this.adapter);
        listView.setOnItemClickListener(new C07771());
    }

    public void onItemClick(AdapterView<?> adapterView, View view1, int arg2, long arg3) {
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setOnListClickListener(OnListItemClick l) {
        this.mOnClickListener = l;
    }
}
