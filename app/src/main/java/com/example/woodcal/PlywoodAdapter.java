package com.example.woodcal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PlywoodAdapter extends BaseAdapter {

    ArrayList<String> widths,lengths,qualities,total;

    public PlywoodAdapter(ArrayList<String> widths, ArrayList<String> lengths, ArrayList<String> qualities, ArrayList<String> total) {

        this.widths = widths;
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

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.plywood_layout,null);

        TextView p,l,q,s,c;

        p=convertView.findViewById(R.id.wt);
        l=convertView.findViewById(R.id.lt);
        q=convertView.findViewById(R.id.qt);
        s=convertView.findViewById(R.id.sr);
        c=convertView.findViewById(R.id.cfit);

        p.setText(String.valueOf(widths.get(position)));
        l.setText(String.valueOf(lengths.get(position)));
        q.setText(String.valueOf(qualities.get(position)));
        s.setText(String.valueOf(position+1));
        c.setText(String.valueOf(total.get(position)));

        return convertView;

    }
}
