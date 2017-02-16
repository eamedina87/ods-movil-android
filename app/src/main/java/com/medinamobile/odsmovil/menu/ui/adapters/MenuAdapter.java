package com.medinamobile.odsmovil.menu.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.medinamobile.odsmovil.R;
import com.medinamobile.odsmovil.entities.ODS;
import com.medinamobile.odsmovil.libs.ODSHelper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {


    private final ArrayList<ODS> odsList;
    private final OnODSClickListener listener;

    public MenuAdapter(ArrayList<ODS> odsList, OnODSClickListener listener) {
        this.odsList = odsList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ods_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ODS temp = odsList.get(position);
        holder.lock.setVisibility(View.INVISIBLE);
        if (temp.isUnlocked()){
            holder.image.setImageResource(ODSHelper.getODSImageUnlocked(temp.getNumber()));
        } else {
            //holder.image.setImageResource(ODSHelper.getODSImageLocked(temp.getNumber()));
        }
        holder.setClickListener(temp, listener);
    }

    @Override
    public int getItemCount() {
        return odsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.ods_grid_image)
        ImageView image;
        @BindView(R.id.ods_grid_lock)
        ImageView lock;

        private final View view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, view);
        }

        private void setClickListener (final ODS ods, final OnODSClickListener listener){
            this.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onODSClicked(ods);
                }
            });
        }

    }
}
