package com.bawei.yuanchenran20191230.adpater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bawei.yuanchenran20191230.R;
import com.bawei.yuanchenran20191230.bean.MySmses;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<MySmses> smses=new ArrayList<>();
    private Context context;

    public MyAdapter(List<MySmses> smses, Context context) {
        this.smses .addAll(smses);
        this.context = context;
    }

    @Override
    public int getCount() {
        return smses.size();
    }

    @Override
    public int getItemViewType(int position) {
        MySmses mySmses = smses.get(position);
        int isread = mySmses.getIsread();
        if (isread==1){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return smses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int itemViewType = getItemViewType(position);
        if (itemViewType==0){
            OneViewHolder oneViewHolder=null;
            if (convertView == null) {
                convertView=View.inflate(context, R.layout.item_one,null);
                oneViewHolder=new OneViewHolder();
                oneViewHolder.one_content=convertView.findViewById(R.id.one_content);
                oneViewHolder.one_from=convertView.findViewById(R.id.one_from);
                convertView.setTag(oneViewHolder);
            }else {
                oneViewHolder= (OneViewHolder) convertView.getTag();
            }
            oneViewHolder.one_from.setText(smses.get(position).getFrom());
            oneViewHolder.one_content.setText(smses.get(position).getContent());
            return convertView;
        }else if (itemViewType==1){
            TwoViewHolder twoViewHolder=null;
            if (convertView == null) {
                convertView=View.inflate(context, R.layout.item_two,null);
                twoViewHolder=new TwoViewHolder();
                twoViewHolder.content=convertView.findViewById(R.id.content);
                twoViewHolder.from=convertView.findViewById(R.id.from);
                convertView.setTag(twoViewHolder);
            }else {
                twoViewHolder= (TwoViewHolder) convertView.getTag();
            }
            twoViewHolder.from.setText(smses.get(position).getFrom());
            twoViewHolder.content.setText(smses.get(position).getContent());
            return convertView;
        }
        return convertView;
    }
    class OneViewHolder{
        TextView one_from,one_content;
    }
    class TwoViewHolder{
        TextView from,content;
    }
}
