package com.iteso.sesion09;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.iteso.sesion09.beans.ItemProduct;

import java.util.ArrayList;
import java.util.Iterator;

public class FragmentElectronics extends Fragment {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public FragmentElectronics() {
    }
    ArrayList<ItemProduct> products = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.fragment_recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);


        products.add(new ItemProduct(getResources().getString(R.string.refig_title),
                getResources().getString(R.string.bestbuy_store),
                getResources().getString(R.string.bestbuy_phone),
                getResources().getString(R.string.sec_location),
                0, 0 , 0));

        products.add(new ItemProduct(getResources().getString(R.string.micro_title),
                getResources().getString(R.string.bestbuy_store),
                getResources().getString(R.string.bestbuy_phone),
                getResources().getString(R.string.third_location),
                0, 0, 0));

        AdapterProduct adapterProduct = new AdapterProduct(products);
        recyclerView.setAdapter(adapterProduct);
        return v;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ItemProduct itemProduct = data.getParcelableExtra("ITEM");
        Iterator<ItemProduct> itemProductIterator = products.iterator();
        int i = 0;
        while(itemProductIterator.hasNext()){
            ItemProduct item = itemProductIterator.next();
            if(item.getCode() == itemProduct.getCode()){
                products.set(i, itemProduct);
                break;
            }
            i++;
        }
        mAdapter.notifyDataSetChanged();
    }
}
