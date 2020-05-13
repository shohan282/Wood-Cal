package com.example.woodcal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RoundAdapter extends BaseAdapter {

    ArrayList<Integer> peri,lengths,qualities;
    ArrayList<Double> total;

    public RoundAdapter(ArrayList<Integer> peri, ArrayList<Integer> lengths, ArrayList<Integer> qualities, ArrayList<Double> total) {
        this.peri = peri;
        this.lengths = lengths;
        this.qualities = qualities;
        this.total = total;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return peri.size();
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

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.round_layout,null);

        TextView p,l,q,s,c;

        p=convertView.findViewById(R.id.peri);
        l=convertView.findViewById(R.id.lt);
        q=convertView.findViewById(R.id.qt);
        s=convertView.findViewById(R.id.sr);
        c=convertView.findViewById(R.id.cfit);

        p.setText(String.valueOf(peri.get(position)));
        l.setText(String.valueOf(lengths.get(position)));
        q.setText(String.valueOf(qualities.get(position)));
        s.setText(String.valueOf(position+1));
        c.setText(String.valueOf(total.get(position)));

        return convertView;

    }
}
