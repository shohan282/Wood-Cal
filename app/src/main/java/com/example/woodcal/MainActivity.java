package com.example.woodcal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.woodcal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        b = ActivityMainBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);

        b.roundlog.setOnClickListener(this);
        b.plywood.setOnClickListener(this);
        b.flushdor.setOnClickListener(this);
        b.cutsize.setOnClickListener(this);
        b.save.setOnClickListener(this);
        b.buy.setOnClickListener(this);
        b.rate.setOnClickListener(this);
        b.share.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.theme, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.cutsize:
                startActivity(new Intent(MainActivity.this, CutSize.class));
                break;

            case R.id.roundlog:
                startActivity(new Intent(MainActivity.this, RoundLog.class));
                break;

            case R.id.flushdor:
                startActivity(new Intent(MainActivity.this, FlushDoor.class));
                break;

            case R.id.plywood:
                startActivity((new Intent(MainActivity.this, Plywood.class)));
                break;

            case R.id.save:
                startActivity((new Intent(MainActivity.this, SavedRecords.class)));
                break;

            case R.id.rate:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "com.nswebworld.volume")));
                break;

            case R.id.buy:
                startActivity((new Intent(MainActivity.this, Buy.class)));
                break;

            case R.id.share:
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"Download Calculator for Wood: http://play.google.com/store/apps/details?id=com.nswebworld.volume");
                startActivity(Intent.createChooser(intent,"share using..."));
                break;

        }

    }
}
