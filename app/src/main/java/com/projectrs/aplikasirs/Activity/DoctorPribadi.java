package com.projectrs.aplikasirs.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.projectrs.aplikasirs.ConfigurationMenu.MenuDoctorPribadi;
import com.projectrs.aplikasirs.ConfigurationMenu.MenuJadwal;
import com.projectrs.aplikasirs.Data.DataDoctorPribadi;
import com.projectrs.aplikasirs.Data.DataJadwal;
import com.projectrs.aplikasirs.R;

import java.util.ArrayList;
import java.util.List;

public class DoctorPribadi extends AppCompatActivity {
    private GridLayoutManager gridDoctorLayout;
    private RecyclerView rvDoctorPribadi;
    MenuDoctorPribadi menuDoctorPribadi;
    private List<DataDoctorPribadi> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_pribadi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        InitData();

        rvDoctorPribadi = findViewById(R.id.rvDoctorPribadi);
        rvDoctorPribadi.setHasFixedSize(true);

        gridDoctorLayout = new GridLayoutManager(getApplicationContext(), 1,
                GridLayoutManager.VERTICAL, false);

        rvDoctorPribadi.setLayoutManager(gridDoctorLayout);
        menuDoctorPribadi = new MenuDoctorPribadi(list, getApplicationContext());
        rvDoctorPribadi.setAdapter(menuDoctorPribadi);


    }

    private void InitData() {
        list.add(new DataDoctorPribadi(R.drawable.dokter, "Dr. Yulisna Leman", "Spesialis : Dokter Kandungan", "Alamat : Jl. Bukit Damai Indah R/ 51, Surabaya"));
        list.add(new DataDoctorPribadi(R.drawable.dokter, "Dr. Yulisna Leman", "Spesialis : Dokter Kandungan", "Alamat : Jl. Bukit Damai Indah R/ 51, Surabaya"));
        list.add(new DataDoctorPribadi(R.drawable.dokter, "Dr. Yulisna Leman", "Spesialis : Dokter Kandungan", "Alamat : Jl. Bukit Damai Indah R/ 51, Surabaya"));
        list.add(new DataDoctorPribadi(R.drawable.dokter, "Dr. Yulisna Leman", "Spesialis : Dokter Kandungan", "Alamat : Jl. Bukit Damai Indah R/ 51, Surabaya"));
        list.add(new DataDoctorPribadi(R.drawable.dokter, "Dr. Yulisna Leman", "Spesialis : Dokter Kandungan", "Alamat : Jl. Bukit Damai Indah R/ 51, Surabaya"));
        list.add(new DataDoctorPribadi(R.drawable.dokter, "Dr. Yulisna Leman", "Spesialis : Dokter Kandungan", "Alamat : Jl. Bukit Damai Indah R/ 51, Surabaya"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
