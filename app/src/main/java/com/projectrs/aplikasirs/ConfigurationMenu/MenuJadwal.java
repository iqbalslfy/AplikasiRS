package com.projectrs.aplikasirs.ConfigurationMenu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.projectrs.aplikasirs.Activity.JadwalActivity;
import com.projectrs.aplikasirs.Data.DataJadwal;
import com.projectrs.aplikasirs.ItemClickListener;
import com.projectrs.aplikasirs.JadwaldanReservasi.LayananLasik;
import com.projectrs.aplikasirs.JadwaldanReservasi.LayananLensaKontak;
import com.projectrs.aplikasirs.JadwaldanReservasi.LayananMataAnak;
import com.projectrs.aplikasirs.JadwaldanReservasi.LayananOkulaPlastik;
import com.projectrs.aplikasirs.JadwaldanReservasi.LayananRetina;
import com.projectrs.aplikasirs.JadwaldanReservasi.LayananStrabismus;
import com.projectrs.aplikasirs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayo Maju on 31/01/2018.
 */

class MenuJadwalHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView imgView;
    public TextView tvJudul;
    public CardView card_menu;
    private ItemClickListener itemClickListener;

    public MenuJadwalHolder(View itemView) {
        super(itemView);
        imgView = itemView.findViewById(R.id.ImgMenuHome);
        tvJudul = itemView.findViewById(R.id.txtTitleMenuHome);
        card_menu = itemView.findViewById(R.id.card_menu);
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

public class MenuJadwal extends RecyclerView.Adapter<MenuJadwalHolder> {
    private List<DataJadwal> jadwalList = new ArrayList<>();
    private Context context;

    public MenuJadwal(List<DataJadwal> jadwalList, Context context) {
        this.jadwalList = jadwalList;
        this.context = context;
    }

    @Override
    public MenuJadwalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_menu, parent, false);
        return new MenuJadwalHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuJadwalHolder holder, int position) {
        holder.imgView.setImageResource(jadwalList.get(position).getImage());
        holder.tvJudul.setText(jadwalList.get(position).getJudul());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if (pos== 0){
                    Intent i = new Intent(context, LayananLasik.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);

                }

                if (pos== 1){
                    Intent i = new Intent(context, LayananLensaKontak.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }

                if (pos== 2){
                    Intent i = new Intent(context, LayananMataAnak.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }

                if (pos== 3){
                    Intent i = new Intent(context, LayananOkulaPlastik.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }

                if (pos== 4){
                    Intent i = new Intent(context, LayananRetina.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }

                if (pos== 5){
                    Intent i = new Intent(context, LayananStrabismus.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);

                }

            }
        });


        if (position == 0) {
            holder.card_menu.setCardBackgroundColor(Color.parseColor("#2e8bcc"));//asuransi
        }

        if (position == 1) {
            holder.card_menu.setCardBackgroundColor(Color.parseColor("#339933"));//logistic
        }

        if (position == 2) {
            holder.card_menu.setCardBackgroundColor(Color.parseColor("#00394D"));//asset
        }

        if (position == 3) {
            holder.card_menu.setCardBackgroundColor(Color.parseColor("#f09609"));//akuntansi
        }

        if (position == 4) {
            holder.card_menu.setCardBackgroundColor(Color.parseColor("#008641"));//pengaturan
        }

        if (position == 5) {
            holder.card_menu.setCardBackgroundColor(Color.parseColor("#1c1c1c"));//antrian
        }
    }

    @Override
    public int getItemCount() {
        return jadwalList.size();
    }
}
