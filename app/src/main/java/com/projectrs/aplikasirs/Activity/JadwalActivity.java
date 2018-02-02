package com.projectrs.aplikasirs.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.projectrs.aplikasirs.ConfigurationMenu.MenuHome;
import com.projectrs.aplikasirs.ConfigurationMenu.MenuJadwal;
import com.projectrs.aplikasirs.Data.DataJadwal;
import com.projectrs.aplikasirs.Data.DataMain;
import com.projectrs.aplikasirs.R;

import java.util.ArrayList;
import java.util.List;

public class JadwalActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private GridLayoutManager gridjadwal;
    private RecyclerView rvJadwal;
    MenuJadwal menuJadwal;
    private List<DataJadwal> jadwalList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        jadwalLoad();

        rvJadwal = findViewById(R.id.rvMenuSchedule);
        rvJadwal.setHasFixedSize(true);

        gridjadwal = new GridLayoutManager(getApplicationContext(), 3,
                GridLayoutManager.VERTICAL, false);

        rvJadwal.setLayoutManager(gridjadwal);
        menuJadwal = new MenuJadwal(jadwalList, getApplicationContext());
        rvJadwal.setAdapter(menuJadwal);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void jadwalLoad() {
        jadwalList.add(new DataJadwal(R.drawable.asuransi, "LAYANAN LASIK"));
        jadwalList.add(new DataJadwal(R.drawable.pengaturan, "LAYANAN LENSA KONTAK"));
        jadwalList.add(new DataJadwal(R.drawable.pengaturan, "LAYANAN MATA ANAK"));
        jadwalList.add(new DataJadwal(R.drawable.akutansi, "LAYANAN OKULOPLASTIK"));
        jadwalList.add(new DataJadwal(R.drawable.logistic, "LAYANAN RETINA"));
        jadwalList.add(new DataJadwal(R.drawable.pengaturan, "LAYANAN STRABISMUS"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
