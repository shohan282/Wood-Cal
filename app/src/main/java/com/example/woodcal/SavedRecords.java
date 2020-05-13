package com.example.woodcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.woodcal.databinding.ActivitySavedRecordsBinding;

public class SavedRecords extends AppCompatActivity {

    ActivitySavedRecordsBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivitySavedRecordsBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);

    }
}
