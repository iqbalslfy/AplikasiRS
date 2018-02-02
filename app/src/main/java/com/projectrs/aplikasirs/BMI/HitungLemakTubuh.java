package com.projectrs.aplikasirs.BMI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.projectrs.aplikasirs.R;

public class HitungLemakTubuh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_lemak_tubuh);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
