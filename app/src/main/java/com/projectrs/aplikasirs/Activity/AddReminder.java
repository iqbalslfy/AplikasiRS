package com.projectrs.aplikasirs.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.projectrs.aplikasirs.R;

public class AddReminder extends AppCompatActivity implements View.OnClickListener {
    TextView one, two, three;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        btnSubmit = findViewById(R.id.btnSubmitReminder);
        btnSubmit.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v == btnSubmit) {
            Toast.makeText(this, "Data : " + "\n" +
                            one.getText() + "\n" +
                            two.getText() + "\n" +
                            three.getText()
                    , Toast.LENGTH_SHORT).show();
        }
    }
}
