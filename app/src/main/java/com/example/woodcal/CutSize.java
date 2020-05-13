package com.example.woodcal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.woodcal.databinding.ActivityCutSizeBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CutSize extends AppCompatActivity {

    ActivityCutSizeBinding b;
    ArrayList<String> widths = new ArrayList<>();
    ArrayList<String> thickss = new ArrayList<>();
    ArrayList<String> lengths = new ArrayList<>();
    ArrayList<String> qualities = new ArrayList<>();
    ArrayList<String> total = new ArrayList<>();

    double tot,cMt,cuft=0,cumt=0;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityCutSizeBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);

        checkBoxFunction();

        b.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String width = b.editTextWidth.getText().toString();
                String length = b.editTextLength.getText().toString();
                String thick = b.editTextThick.getText().toString();
                String quality = b.editTextNos.getText().toString();



                if (width.isEmpty()) {
                    b.editTextWidth.setError("test is empty");
                    b.editTextWidth.requestFocus();
                }
                else if (length.isEmpty()) {
                    b.editTextLength.setError("test is empty");
                    b.editTextLength.requestFocus();
                }
                else if (thick.isEmpty()) {
                    b.editTextThick.setError("test is empty");
                    b.editTextThick.requestFocus();
                }
                else if (quality.isEmpty()) {
                    b.editTextNos.setError("test is empty");
                    b.editTextNos.requestFocus();
                } else {

                    tot=(Double.parseDouble(width)/12)*Integer.parseInt(length)*(Double.parseDouble(thick)/12)*Integer.parseInt(quality);
                    tot =Double.parseDouble(new DecimalFormat("##.###").format(tot));

                    cMt = tot*0.0283168466;

                    widths.add(width);
                    lengths.add(length);
                    thickss.add(thick);
                    qualities.add(quality);
                    total.add(String.valueOf(tot));

                    CutSizeItemAdapter adapter = new CutSizeItemAdapter(widths, thickss, lengths, qualities,total);
                    b.list.setAdapter(adapter);

                    cuft=cuft+tot;
                    cuft=Double.parseDouble(new DecimalFormat("##.###").format(cuft));
                    cumt=cumt+cMt;
                    cumt =Double.parseDouble(new DecimalFormat("##.###").format(cumt));
                    n=n+Integer.parseInt(quality);

                    b.text.setText("CuFt: "+String.valueOf(cuft)+"       CuMt: "+String.valueOf(cumt)+"      Nos: "+String.valueOf(n));

                    if(!b.checkBoxWidth.isChecked()){

                        b.editTextWidth.setText(null);
                        b.editTextWidth.requestFocus();

                    } else if(!b.checkBoxThick.isChecked()){

                        b.editTextThick.requestFocus();

                    } else {

                        b.editTextLength.requestFocus();

                    }

                    if(!b.checkBoxThick.isChecked()){

                        b.editTextThick.setText(null);

                    }

                    if(!b.checkBoxQuality.isChecked()){

                        b.editTextNos.setText(null);

                    }

                    if(!b.checkBoxLength.isChecked()){

                        b.editTextLength.setText(null);

                    }

                }

            }
        });


    }

    private void checkBoxFunction() {
        b.checkBoxWidth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b.checkBoxWidth.isChecked())
                {
                    b.editTextWidth.setFocusable(false);
                    b.editTextWidth.setTextColor(getResources().getColor(R.color.gray));

                }
                else{
                    b.editTextWidth.setFocusableInTouchMode(true);
                    b.editTextWidth.setTextColor(getResources().getColor(R.color.black));

                }
            }
        });

        b.checkBoxLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( b.checkBoxLength.isChecked())
                {
                    b.editTextLength.setFocusable(false);
                    b.editTextLength.setTextColor(getResources().getColor(R.color.gray));


                }
                else{
                    b.editTextLength.setFocusableInTouchMode(true);
                    b.editTextLength.setTextColor(getResources().getColor(R.color.black));

                }
            }
        });

        b.checkBoxThick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( b.checkBoxThick.isChecked())
                {
                    b.editTextThick.setFocusable(false);
                    b.editTextThick.setTextColor(getResources().getColor(R.color.gray));

                }
                else{
                    b.editTextThick.setFocusableInTouchMode(true);
                    b.editTextThick.setTextColor(getResources().getColor(R.color.black));


                }
            }
        });

        b.checkBoxQuality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( b.checkBoxQuality.isChecked())
                {
                    b.editTextNos.setFocusable(false);
                    b.editTextNos.setTextColor(getResources().getColor(R.color.gray));

                }
                else{
                    b.editTextNos.setFocusableInTouchMode(true);
                    b.editTextNos.setTextColor(getResources().getColor(R.color.black));

                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting, menu);
        MenuItem item = menu.findItem(R.id.cut);
        item.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.clear:
                b.list.setAdapter(null);
                return true;

            case R.id.flushdor:
                startActivity(new Intent(CutSize.this,FlushDoor.class));
                finish();
                return true;

            case R.id.roundlog:
                startActivity(new Intent(CutSize.this,RoundLog.class));
                finish();
                return true;

            case R.id.plywood:
                startActivity(new Intent(CutSize.this,Plywood.class));
                finish();
                return true;

            default:
                return false;

        }
    }

}
