package cn.edu.gdpt.movie172;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

class HKAdapter extends BaseAdapter {
    List<Map<String,Object>> hkList;
    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public HKAdapter(List<Map<String,Object>> hkList){
        this.hkList=hkList;
    }
    @Override
    public int getCount() {
        return hkList.size();
    }

    @Override
    public Object getItem(int position) {
        return hkList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_hk, parent,false);
        TextView name=itemView.findViewById(R.id.name);
        TextView days=itemView.findViewById(R.id.day);
        TextView cur=itemView.findViewById(R.id.cur);
        TextView sum=itemView.findViewById(R.id.sum);
        name.setText(hkList.get(position).get("name").toString());
        days.setText(hkList.get(position).get("days").toString());
        cur.setText(hkList.get(position).get("cur").toString());
        sum.setText(hkList.get(position).get("sum").toString());
        return itemView;
    }
}

