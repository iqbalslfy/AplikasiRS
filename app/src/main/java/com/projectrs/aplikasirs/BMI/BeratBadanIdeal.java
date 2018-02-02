package com.projectrs.aplikasirs.BMI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.projectrs.aplikasirs.R;

public class BeratBadanIdeal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berat_badan_ideal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
