package com.projectrs.aplikasirs.ConfigurationMenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.projectrs.aplikasirs.Data.DataJadwalLasik;
import com.projectrs.aplikasirs.ItemClickListener;
import com.projectrs.aplikasirs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayo Maju on 31/01/2018.
 */

class JadwalDokterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView Tanggal, Hari, Jam;
    public TextView DokterIsi, TanggalIsi, HariIsi, JamIsi;
    private ItemClickListener itemClickListener;

    public JadwalDokterHolder(View itemView) {
        super(itemView);

        Tanggal = itemView.findViewById(R.id.txtTanggal);
        Hari = itemView.findViewById(R.id.txtHari);
        Jam = itemView.findViewById(R.id.txtJam);

        DokterIsi = itemView.findViewById(R.id.IsiNamaDokter);
        TanggalIsi = itemView.findViewById(R.id.IsiTanggal);
        HariIsi = itemView.findViewById(R.id.IsiHari);
        JamIsi = itemView.findViewById(R.id.IsiWaktu);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }
}

public class MenuJadwalDokter extends RecyclerView.Adapter<JadwalDokterHolder> {
    private List<DataJadwalLasik> lasikList = new ArrayList<>();
    private Context context;

    public MenuJadwalDokter(List<DataJadwalLasik> lasikList, Context context) {
        this.lasikList = lasikList;
        this.context = context;
    }

    @Override
    public JadwalDokterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_jadwal_dokter, parent, false);

        return new JadwalDokterHolder(view);
    }

    @Override
    public void onBindViewHolder(final JadwalDokterHolder holder, int position) {
        holder.Tanggal.setText(lasikList.get(position).getTanggal());
        holder.Hari.setText(lasikList.get(position).getHari());
        holder.Jam.setText(lasikList.get(position).getJam());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Toast.makeText(context, "Data : " + lasikList.get(position).getTanggal() + "\n" +
                        lasikList.get(position).getHari() + "\n" +
                        lasikList.get(position).getJam(), Toast.LENGTH_SHORT
                ).show();
if (position == 0){
    holder.TanggalIsi.setText(lasikList.get(position).getTanggal());
    holder.HariIsi.setText(lasikList.get(position).getHari());
    holder.JamIsi.setText(lasikList.get(position).getJam());
}

            }
        });
    }

    @Override
    public int getItemCount() {
        return lasikList.size();
    }
}
