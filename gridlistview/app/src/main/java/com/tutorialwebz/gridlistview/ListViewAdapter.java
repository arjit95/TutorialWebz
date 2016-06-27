package com.tutorialwebz.gridlistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ListViewAdapter extends BaseAdapter {
    static class ViewHolder{
      TextView tv;
      ImageView iv;
    };
    int drawables[]= {
            R.drawable.sample_0,R.drawable.sample_1,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_6,R.drawable.sample_7,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_6,R.drawable.sample_7,
            R.drawable.sample_4,R.drawable.sample_5,
            R.drawable.sample_2,R.drawable.sample_3,
            R.drawable.sample_4,R.drawable.sample_5,
            };
    @Override
    public int getCount() {
        return drawables.length;
    }

    @Override
    public Object getItem(int i) {
        return drawables[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder vh;
        if(convertView==null) {
        convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        vh = new ViewHolder();
        vh.tv = (TextView) convertView.findViewById(R.id.grid_text);
        vh.iv = (ImageView) convertView.findViewById(R.id.grid_image);
        convertView.setTag(vh);
       }
        else{
           vh = (ViewHolder) convertView.getTag();
       }
        vh.tv.setText("Puppy "+(i+1));
        vh.iv.setImageResource(drawables[i]);
        return convertView;
    }
}
