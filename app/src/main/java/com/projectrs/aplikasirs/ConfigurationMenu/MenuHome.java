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

import com.projectrs.aplikasirs.Activity.BMIActivity;
import com.projectrs.aplikasirs.Activity.BillReminderActivity;
import com.projectrs.aplikasirs.Activity.CheckUpReminderActivity;
import com.projectrs.aplikasirs.Activity.CheckUpHistoryActivity;
import com.projectrs.aplikasirs.Activity.DoctorPribadi;
import com.projectrs.aplikasirs.Activity.JadwalActivity;
import com.projectrs.aplikasirs.Data.DataMain;
import com.projectrs.aplikasirs.ItemClickListener;
import com.projectrs.aplikasirs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ayo Maju on 30/01/2018.
 */

class MenuHomeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView imgView;
    public TextView tvJudul;
    public CardView card_menu;
    private ItemClickListener itemClickListener;


    public MenuHomeHolder(View itemView) {
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

public class MenuHome extends RecyclerView.Adapter<MenuHomeHolder> {
    private List<DataMain> mainList = new ArrayList<>();
    public Context context;

    public MenuHome(List<DataMain> mainList, Context context) {
        this.mainList = mainList;
        this.context = context;
    }

    @Override
    public MenuHomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_menu, parent, false);

        return new MenuHomeHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuHomeHolder holder, int position) {
        holder.imgView.setImageResource(mainList.get(position).getImage());
        holder.tvJudul.setText(mainList.get(position).getJudul());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if (pos == 0) {
                    Intent i = new Intent(context, JadwalActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }

                if (pos == 1) {
                    Intent i = new Intent(context, DoctorPribadi.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }

                if (pos == 2) {
                    Intent i = new Intent(context, CheckUpReminderActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }

                if (pos == 3) {
                    Intent i = new Intent(context, CheckUpHistoryActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }

                if (pos == 4) {
                    Intent i = new Intent(context, BMIActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }

                if (pos == 5) {
                    Intent i = new Intent(context, BillReminderActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }

            }
        });

        if (position == 0) {
            holder.card_menu.setCardBackgroundColor(Color.parseColor("#1c1c1c")); //billing
        }

        if (position == 1) {
            holder.card_menu.setCardBackgroundColor(Color.parseColor("#339933"));//adm. umum
        }

        if (position == 2) {
            holder.card_menu.setCardBackgroundColor(Color.parseColor("#7b4f9d"));//rekammedic
        }

        if (position == 3) {
            holder.card_menu.setCardBackgroundColor(Color.parseColor("#f09609"));//apotek
        }

        if (position == 4) {
            holder.card_menu.setCardBackgroundColor(Color.parseColor("#008641"));//kepegawaian
        }

        if (position == 5) {
            holder.card_menu.setCardBackgroundColor(Color.parseColor("#e51400"));//absengaji
        }

        if (position == 6) {
            holder.card_menu.setCardBackgroundColor(Color.parseColor("#2e8bcc"));//asuransi
        }

        if (position == 7) {
            holder.card_menu.setCardBackgroundColor(Color.parseColor("#339933"));//logistic
        }

    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }
}
