package com.projectrs.aplikasirs.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.projectrs.aplikasirs.BMI.BeratBadanIdeal;
import com.projectrs.aplikasirs.BMI.HitungLemakTubuh;
import com.projectrs.aplikasirs.BMI.RasioPinggangIdeal;
import com.projectrs.aplikasirs.R;

public class BMIActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    CardView card_BBI, card_RPI, card_HLT;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        card_BBI = findViewById(R.id.card_BBI);
        card_RPI = findViewById(R.id.card_RPI);
        card_HLT = findViewById(R.id.card_HLT);

        card_BBI.setOnClickListener(this);
        card_RPI.setOnClickListener(this);
        card_HLT.setOnClickListener(this);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v == card_BBI){
            startActivity(new Intent(this, BeratBadanIdeal.class));
        }

        if (v == card_RPI){
            startActivity(new Intent(this, RasioPinggangIdeal.class));
        }

        if (v == card_HLT){
            startActivity(new Intent(this, HitungLemakTubuh.class));
        }
    }
}
