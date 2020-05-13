package com.example.woodcal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.woodcal.databinding.ActivityRoundLogBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class RoundLog extends AppCompatActivity {

    ActivityRoundLogBinding b;

    ArrayList<Integer> peri = new ArrayList<>();
    ArrayList<Integer> lengths = new ArrayList<>();
    ArrayList<Integer> qualities = new ArrayList<>();
    ArrayList<Double> total = new ArrayList<>();

    int l,p,q,n;
    double mp,tot,cMt,cuft=0,cumt=0;
    String ll,pp,qq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityRoundLogBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);

        checkBoxFunction();

        b.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ll=b.l.getText().toString();
                pp=b.p.getText().toString();
                qq=b.q.getText().toString();

                if (ll.isEmpty()) {

                    b.l.setError("test is empty");
                    b.l.requestFocus();

                }
                else if (pp.isEmpty()) {

                    b.p.setError("test is empty");
                    b.p.requestFocus();

                }
                else if (qq.isEmpty()) {

                    b.q.setError("test is empty");
                    b.q.requestFocus();

                } else {

                    l= Integer.parseInt(ll);
                    p= Integer.parseInt(pp);
                    q= Integer.parseInt(qq);

                    mp=Double.parseDouble(pp);
                    tot=(22/7)*(mp/12)*(mp/12)*l*q;
                    tot =Double.parseDouble(new DecimalFormat("##.###").format(tot));

                    cMt = tot*0.0283168466;

                    peri.add(p);
                    lengths.add(l);
                    qualities.add(q);
                    total.add(tot);

                    RoundAdapter adapter = new RoundAdapter(peri, lengths, qualities,total);
                    b.list.setAdapter(adapter);

                    cuft=cuft+tot;
                    cuft =Double.parseDouble(new DecimalFormat("##.###").format(cuft));
                    cumt=cumt+cMt;
                    cumt =Double.parseDouble(new DecimalFormat("##.###").format(cumt));
                    n=n+q;

                    b.text.setText("CuFt: "+String.valueOf(cuft)+"       CuMt: "+String.valueOf(cumt)+"      Nos: "+String.valueOf(n));

                    if(!b.cp.isChecked()){

                        b.p.setText(null);

                    }

                    if(!b.cq.isChecked()){

                        b.q.setText(null);

                    }

                    if(!b.cl.isChecked()){

                        b.l.setText(null);
                        b.l.requestFocus();


                    } else if(!b.cq.isChecked()){

                        b.p.requestFocus();

                    }

                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting,menu);
        MenuItem item = menu.findItem(R.id.roundlog);
        item.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.clear:
                b.list.setAdapter(null);
                return true;

            case R.id.cut:
                startActivity(new Intent(RoundLog.this,CutSize.class));
                finish();
                return true;

            case R.id.flushdor:
                startActivity(new Intent(RoundLog.this,FlushDoor.class));
                finish();
                return true;

            case R.id.plywood:
                startActivity(new Intent(RoundLog.this,Plywood.class));
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

        b.cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b.cp.isChecked()) {

                    b.p.setFocusable(false);
                    b.p.setTextColor(getResources().getColor(R.color.gray));

                } else{

                    b.p.setFocusableInTouchMode(true);
                    b.p.setTextColor(getResources().getColor(R.color.black));

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
