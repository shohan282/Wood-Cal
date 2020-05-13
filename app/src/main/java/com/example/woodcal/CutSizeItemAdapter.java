package com.example.woodcal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CutSizeItemAdapter extends BaseAdapter {

    ArrayList<String> widths,thickss,lengths,qualities,total;

    public CutSizeItemAdapter(ArrayList<String> widths, ArrayList<String> thickss, ArrayList<String> lengths, ArrayList<String> qualities, ArrayList<String> total) {
        this.widths = widths;
        this.thickss = thickss;
        this.lengths = lengths;
        this.qualities = qualities;
        this.total = total;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return widths.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cutsize_item_layout,null);
        }

        if(position%2==0)
        {
            convertView.setBackgroundColor(parent.getResources().getColor(R.color.gray));
        }
        else{
            convertView.setBackgroundColor(parent.getResources().getColor(R.color.white));

        }
        TextView widthText,lengthText,thickText,nosText,serText,cutTExt;
        widthText = convertView.findViewById(R.id.widthTextID);
        lengthText=convertView.findViewById(R.id.lengthTextID);
        thickText=convertView.findViewById(R.id.thickTextID);
        nosText=convertView.findViewById(R.id.nosTextID);
        serText = convertView.findViewById(R.id.serialTextID);
        cutTExt = convertView.findViewById(R.id.cutFTTextID);

        widthText.setText(widths.get(position));
        lengthText.setText(lengths.get(position));
        thickText.setText(thickss.get(position));
        nosText.setText(qualities.get(position));
        serText.setText(String.valueOf(position+1));
        cutTExt.setText(total.get(position));

        return convertView;
    }
}
