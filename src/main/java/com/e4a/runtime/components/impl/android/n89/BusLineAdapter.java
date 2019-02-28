package com.e4a.runtime.components.impl.android.n89;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.amap.api.services.busline.BusLineItem;
import com.e4a.runtime.C0894;
import java.util.List;

public class BusLineAdapter extends BaseAdapter {
    private List<BusLineItem> busLineItems;
    private LayoutInflater layoutInflater;

    class ViewHolder {
        public TextView busId;
        public TextView busName;

        ViewHolder() {
        }
    }

    public BusLineAdapter(Context context, List<BusLineItem> busLineItems) {
        this.busLineItems = busLineItems;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.busLineItems.size();
    }

    public Object getItem(int position) {
        return Integer.valueOf(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(C0894.m6890("busline_item", "layout"), null);
            holder = new ViewHolder();
            holder.busName = (TextView) convertView.findViewById(C0894.m6890("busname", "id"));
            holder.busId = (TextView) convertView.findViewById(C0894.m6890("busid", "id"));
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.busName.setText("公交名称:" + ((BusLineItem) this.busLineItems.get(position)).getBusLineName());
        holder.busId.setText("公交ID:" + ((BusLineItem) this.busLineItems.get(position)).getBusLineId());
        return convertView;
    }
}
