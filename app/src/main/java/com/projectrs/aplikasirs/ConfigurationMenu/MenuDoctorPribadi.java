package com.projectrs.aplikasirs.ConfigurationMenu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.projectrs.aplikasirs.Activity.JadwalActivity;
import com.projectrs.aplikasirs.Activity.PesanActivity;
import com.projectrs.aplikasirs.Data.DataDoctorPribadi;
import com.projectrs.aplikasirs.ItemClickListener;
import com.projectrs.aplikasirs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayo Maju on 01/02/2018.
 */

class DoctorPribadiHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView Img;
    public TextView Nama, Spesialis, Alamat;
    public CardView Msg,Tlf;
    private ItemClickListener itemClickListener;

    public DoctorPribadiHolder(View itemView) {
        super(itemView);

        Img = itemView.findViewById(R.id.ImgDoctor);
        Nama = itemView.findViewById(R.id.txtNamaDoctor);
        Spesialis = itemView.findViewById(R.id.txtSpesialis);
        Alamat = itemView.findViewById(R.id.txtAlamat);
        Msg = itemView.findViewById(R.id.card_Msg);
        Tlf= itemView.findViewById(R.id.card_Tlf);

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

public class MenuDoctorPribadi extends RecyclerView.Adapter<DoctorPribadiHolder> {
    private List<DataDoctorPribadi> list = new ArrayList<>();
    private Context context;

    public MenuDoctorPribadi(List<DataDoctorPribadi> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public DoctorPribadiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_doctor_pribadi, parent, false);

        return new DoctorPribadiHolder(view);
    }

    @Override
    public void onBindViewHolder(DoctorPribadiHolder holder, int position) {
        holder.Img.setImageResource(list.get(position).getImg());
        holder.Nama.setText(list.get(position).getDokter());
        holder.Spesialis.setText(list.get(position).getSpesialis());
        holder.Alamat.setText(list.get(position).getAlamat());

        holder.Msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, PesanActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        holder.Tlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Button Telfon Active!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
