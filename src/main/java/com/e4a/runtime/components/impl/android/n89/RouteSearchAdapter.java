package com.e4a.runtime.components.impl.android.n89;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.amap.api.services.core.PoiItem;
import com.e4a.runtime.C0894;
import java.util.List;

public class RouteSearchAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater mInflater;
    private List<PoiItem> poiItems = null;

    public RouteSearchAdapter(Context context, List<PoiItem> poiItems) {
        this.context = context;
        this.poiItems = poiItems;
        this.mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.poiItems.size();
    }

    public Object getItem(int position) {
        return Integer.valueOf(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        String address;
        if (convertView == null) {
            convertView = this.mInflater.inflate(C0894.m6890("poi_result_list", "layout"), null);
        }
        TextView poiAddress = (TextView) convertView.findViewById(C0894.m6890("poiAddress", "id"));
        ((TextView) convertView.findViewById(C0894.m6890("poiName", "id"))).setText(((PoiItem) this.poiItems.get(position)).getTitle());
        if (((PoiItem) this.poiItems.get(position)).getSnippet() != null) {
            address = ((PoiItem) this.poiItems.get(position)).getSnippet();
        } else {
            address = "中国";
        }
        poiAddress.setText("地址:" + address);
        return convertView;
    }
}
