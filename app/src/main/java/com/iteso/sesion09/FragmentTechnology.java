package com.iteso.sesion09;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.sesion09.beans.ItemProduct;

import java.util.ArrayList;

public class FragmentTechnology extends Fragment {
    private RecyclerView.LayoutManager mLayoutManager;
    public FragmentTechnology() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.fragment_recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ItemProduct> products = new ArrayList<>();
        products.add(new ItemProduct(getResources().getString(R.string.mac_title),
                                    getResources().getString(R.string.bestbuy_store),
                                    getResources().getString(R.string.bestbuy_phone),
                                    getResources().getString(R.string.first_location),
                                    getResources().getDrawable(R.drawable.mac),
                                    getResources().getDrawable(R.drawable.bestbuy)));

        products.add(new ItemProduct(getResources().getString(R.string.aw_title),
                                    getResources().getString(R.string.bestbuy_store),
                                    getResources().getString(R.string.bestbuy_phone),
                                    getResources().getString(R.string.sec_location),
                                    getResources().getDrawable(R.drawable.alienware),
                                    getResources().getDrawable(R.drawable.bestbuy)));

        AdapterProduct adapterProduct = new AdapterProduct(products);
        recyclerView.setAdapter(adapterProduct);
        return v;
    }
}
