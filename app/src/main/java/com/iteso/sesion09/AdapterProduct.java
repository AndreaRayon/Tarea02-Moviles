package com.iteso.sesion09;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import com.iteso.sesion09.beans.ItemProduct;


public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>{

    ArrayList<ItemProduct> products;
    private Context context;
    public AdapterProduct(ArrayList<ItemProduct> products){
        this.products = products;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTitle;
        public TextView mStore;
        public TextView mPhone;
        public TextView mLocation;
        public Button mDetail;
        public ImageView mImage;
        public ImageView mImageStore;
        public LinearLayout mEdit;


        public ViewHolder(View v){
            super(v);
            mTitle = v.findViewById(R.id.item_product_title);
            mStore = v.findViewById(R.id.item_product_store);
            mPhone = v.findViewById(R.id.item_product_phone);
            mLocation = v.findViewById(R.id.item_product_location);
            mDetail = v.findViewById(R.id.item_product_detail);
            mImage = v.findViewById(R.id.item_product_image);
            mImageStore = v.findViewById(R.id.item_product_thumbnail);
            mEdit = v.findViewById(R.id.card_home_info);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product,
                viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.mTitle.setText(products.get(i).getName());
        viewHolder.mTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(v, i);
            }
        });

        viewHolder.mStore.setText(products.get(i).getStore());
        viewHolder.mStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(v, i);
            }
        });

        viewHolder.mPhone.setText(products.get(i).getPhone());
        viewHolder.mPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(v, i);
            }
        });

        viewHolder.mLocation.setText(products.get(i).getName());
        viewHolder.mLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(v, i);
            }
        });

        viewHolder.mDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(v, i);
            }
        });
        viewHolder.mImage.setImageDrawable(products.get(i).getImg());
        viewHolder.mImageStore.setImageDrawable(products.get(i).getImgStore());


    }
    public void showToast(View v, final int position){
        Toast.makeText(v.getContext(), products.get(position).toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
