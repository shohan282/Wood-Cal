package com.example.woodcal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.woodcal.databinding.ActivityPlywoodBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Plywood extends AppCompatActivity {

    ActivityPlywoodBinding b;

    ArrayList<String> widths = new ArrayList<>();
    ArrayList<String> lengths = new ArrayList<>();
    ArrayList<String> qualities = new ArrayList<>();
    ArrayList<String> total = new ArrayList<>();

    String l,w,q;
    double cumt=0,cMt;
    int n,tot,cuft=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityPlywoodBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);

        checkBoxFunction();

        b.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                l=b.l.getText().toString();
                w=b.w.getText().toString();
                q=b.q.getText().toString();

                if (l.isEmpty()) {

                    b.l.setError("test is empty");
                    b.l.requestFocus();

                }
                else if (w.isEmpty()) {

                    b.w.setError("test is empty");
                    b.w.requestFocus();

                }
                else if (q.isEmpty()) {

                    b.q.setError("test is empty");
                    b.q.requestFocus();

                } else {

                    tot=Integer.parseInt(l)*Integer.parseInt(w)*Integer.parseInt(q);

                    cMt = tot*0.09290304;

                    widths.add(w);
                    lengths.add(l);
                    qualities.add(q);
                    total.add(String.valueOf(tot));

                    PlywoodAdapter adapter = new PlywoodAdapter(widths, lengths, qualities,total);
                    b.list.setAdapter(adapter);

                    cuft=cuft+tot;
                    cumt=cumt+cMt;
                    cumt =Double.parseDouble(new DecimalFormat("##.###").format(cumt));
                    n=n+Integer.parseInt(q);

                    b.text.setText("SqFt: "+String.valueOf(cuft)+"       SqMt: "+String.valueOf(cumt)+"      Nos: "+String.valueOf(n));

                    if(!b.cw.isChecked()){

                        b.w.setText(null);

                    }

                    if(!b.cq.isChecked()){

                        b.q.setText(null);

                    }

                    if(!b.cl.isChecked()){

                        b.l.setText(null);
                        b.l.requestFocus();

                    } else if(!b.cq.isChecked()){

                        b.w.requestFocus();

                    }

                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting,menu);
        MenuItem item = menu.findItem(R.id.plywood);
        item.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.clear:
                b.list.setAdapter(null);
                finish();
                return true;

            case R.id.cut:
                startActivity(new Intent(Plywood.this,CutSize.class));
                finish();
                return true;

            case R.id.roundlog:
                startActivity(new Intent(Plywood.this,RoundLog.class));
                finish();
                return true;

            case R.id.flushdor:
                startActivity(new Intent(Plywood.this,FlushDoor.class));
                finish();
                return true;

            default:
                return false;

        }
    }

    private void checkBoxFunction() {

        b.cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b.cl.isChecked()) {

                    b.l.setFocusable(false);
                    b.l.setTextColor(getResources().getColor(R.color.gray));

                } else{

                    b.l.setFocusableInTouchMode(true);
                    b.l.setTextColor(getResources().getColor(R.color.black));

                }
            }
        });

        b.cw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b.cw.isChecked()) {

                    b.w.setFocusable(false);
                    b.w.setTextColor(getResources().getColor(R.color.gray));

                } else{

                    b.w.setFocusableInTouchMode(true);
                    b.w.setTextColor(getResources().getColor(R.color.black));

                }
            }
        });

        b.cq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b.cq.isChecked()) {

                    b.q.setFocusable(false);
                    b.q.setTextColor(getResources().getColor(R.color.gray));

                } else{

                    b.q.setFocusableInTouchMode(true);
                    b.q.setTextColor(getResources().getColor(R.color.black));

                }
            }
        });

    }

}
