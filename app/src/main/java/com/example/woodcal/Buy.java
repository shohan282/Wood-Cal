package com.example.woodcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;

import com.example.woodcal.databinding.ActivityBuyBinding;

public class Buy extends AppCompatActivity implements View.OnClickListener {

    ActivityBuyBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityBuyBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);

        b.b.setOnClickListener(this);
        b.b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

        }

    }
}
