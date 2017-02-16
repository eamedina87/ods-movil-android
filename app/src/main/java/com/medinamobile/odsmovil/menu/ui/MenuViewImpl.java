package com.medinamobile.odsmovil.menu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.medinamobile.odsmovil.R;
import com.medinamobile.odsmovil.entities.ODS;
import com.medinamobile.odsmovil.menu.MenuPresenter;
import com.medinamobile.odsmovil.menu.MenuPresenterImpl;
import com.medinamobile.odsmovil.menu.ui.adapters.MenuAdapter;
import com.medinamobile.odsmovil.menu.ui.adapters.OnODSClickListener;
import com.medinamobile.odsmovil.preview.ui.PreviewViewImpl;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Supertel on 27/12/16.
 */

public class MenuViewImpl extends Fragment implements MenuView, OnODSClickListener {

    @BindView(R.id.ods_list)
    RecyclerView odsListLayout;
    private MenuPresenter presenter;
    private ArrayList<ODS> odsList;
    private MenuAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        ButterKnife.bind(this, view);
        presenter = new MenuPresenterImpl(this, getActivity().getApplicationContext());
        presenter.onCreate();
        onshowODSList(new ArrayList<ODS>());
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void onODSLocked(int ODSnumber) {
        String msg = String.format(getActivity().getResources().getString(R.string.ods_locked), ODSnumber-1);
        showMessage(msg);
    }

    @Override
    public void onODSUnlocked(int ODSnumber) {
        ODS selectedODS = odsList.get(ODSnumber-1);
        Intent intent = new Intent(getContext(), PreviewViewImpl.class);
        intent.putExtra(ODS.INTENT_NAME, selectedODS);
        startActivity(intent);
    }

    @Override
    public void onshowODSList(ArrayList<ODS> odsList) {
        this.odsList = odsList;
        setupAdapter();
        setupRecyclerView();
    }

    private void setupAdapter() {
        adapter = new MenuAdapter(odsList, this);
    }

    private void setupRecyclerView() {
        odsListLayout.setLayoutManager(new GridLayoutManager(getContext(),
                getContext().getResources().getInteger(R.integer.grid_columns),
                GridLayoutManager.VERTICAL, false));
        odsListLayout.setAdapter(adapter);
    }

    private void showMessage(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onODSClicked(ODS ods) {
        presenter.onODSSelected(ods);
    }
}
