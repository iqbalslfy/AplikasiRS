package com.projectrs.aplikasirs.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.projectrs.aplikasirs.R;

public class PesanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
