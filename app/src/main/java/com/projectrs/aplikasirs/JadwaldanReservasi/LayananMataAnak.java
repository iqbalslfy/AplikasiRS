package com.projectrs.aplikasirs.JadwaldanReservasi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.projectrs.aplikasirs.ConfigurationMenu.MenuJadwalDokter;
import com.projectrs.aplikasirs.Data.DataJadwalLasik;
import com.projectrs.aplikasirs.R;

import java.util.ArrayList;
import java.util.List;

public class LayananMataAnak extends AppCompatActivity implements View.OnClickListener {
    private GridLayoutManager layoutMenu;
    private RecyclerView rvMenu;
    MenuJadwalDokter menuJadwalDokter;
    private List<DataJadwalLasik> list = new ArrayList<>();
    Spinner spinner;
    TextView DokterIsi;
    TextView txtDokter, txtHari, txtTgl, txtWaktu, HasilText;
    Button btnBoking;
    private String[] SelectDoctor = {
            "Dr. Baharuddiin",
            "Dr. Edison",
            "Dr. Hasanah",
            "Dr. Excel",
            "Dr. Suyono",
            "Dr. Bambang",
            "Dr. Iqbal",
            "Dr. Maulana",
            "Dr. Muhammad"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layanan_mata_anak);
        jadwal();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DokterIsi = findViewById(R.id.IsiNamaDokter);

        spinner = findViewById(R.id.SpinDokter);
        rvMenu = findViewById(R.id.rvJadwalDokter);
        rvMenu.setHasFixedSize(true);

        layoutMenu = new GridLayoutManager(getApplicationContext(), 1, GridLayoutManager.VERTICAL, false);
        rvMenu.setLayoutManager(layoutMenu);
        menuJadwalDokter = new MenuJadwalDokter(list, getApplicationContext());
        rvMenu.setAdapter(menuJadwalDokter);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, SelectDoctor);
        spinner.setAdapter(adapter);
        btnBoking = findViewById(R.id.btnBooking);
        btnBoking.setOnClickListener(this);
    }

    private void DialogForm() {
        LayoutInflater inflater;
        final AlertDialog.Builder dialog;
        View dialogView;
        dialog = new AlertDialog.Builder(LayananMataAnak.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.layout_booking, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher_round);
        dialog.setTitle("Booking" + "\n");

        txtDokter = dialogView.findViewById(R.id.IsiNamaDokter);
        txtHari = dialogView.findViewById(R.id.IsiHari);
        txtTgl = dialogView.findViewById(R.id.IsiTanggal);
        txtWaktu = dialogView.findViewById(R.id.IsiWaktu);
        HasilText = dialogView.findViewById(R.id.txtHasil);

        dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Pemesanan Sukses! : " + "\n" +
                                txtDokter.getText() + "\n" +
                                txtHari.getText() + "\n" +
                                txtTgl.getText() + "\n" +
                                txtWaktu.getText()
                        , Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void jadwal() {
        list.add(new DataJadwalLasik("12/1/2017", "Senin", "10:00 s/d 13:00"));
        list.add(new DataJadwalLasik("12/1/2017", "Selasa", "13:00 s/d 15:00"));
        list.add(new DataJadwalLasik("12/1/2017", "Rabu", "10:00 s/d 13:00"));
        list.add(new DataJadwalLasik("12/1/2017", "Kamis", "10:00 s/d 13:00"));
        list.add(new DataJadwalLasik("12/1/2017", "Jum'at", "10:00 s/d 13:00"));
        list.add(new DataJadwalLasik("12/1/2017", "Sabtu", "10:00 s/d 13:00"));
        list.add(new DataJadwalLasik("12/1/2017", "Minggu", "10:00 s/d 13:00"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v == btnBoking) {
            DialogForm();
        }
    }
}
