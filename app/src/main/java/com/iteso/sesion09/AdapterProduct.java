package com.iteso.sesion09;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
        viewHolder.mStore.setText(products.get(i).getStore());
        viewHolder.mPhone.setText(products.get(i).getPhone());
        viewHolder.mPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+products.get(i).getPhone()));
                v.getContext().startActivity(intent);
            }
        });

        viewHolder.mLocation.setText(products.get(i).getName());

        switch (products.get(i).getImg()){
            case 0: viewHolder.mImage.setImageResource(R.drawable.mac); break;
            case 1: viewHolder.mImage.setImageResource(R.drawable.alienware); break;
            case 2: viewHolder.mImage.setImageResource(R.drawable.micro); break;
            case 3: viewHolder.mImage.setImageResource(R.drawable.refrigerator); break;
            case 4: viewHolder.mImage.setImageResource(R.drawable.sheets); break;
            case 5: viewHolder.mImage.setImageResource(R.drawable.pillows); break;
            default: viewHolder.mImage.setImageResource(R.drawable.mac); break;
        }
       switch (products.get(i).getImgStore()){
           case 0: viewHolder.mImageStore.setImageResource(R.drawable.bestbuy); break;
           case 1: viewHolder.mImageStore.setImageResource(R.drawable.liverpool); break;
           default: viewHolder.mImageStore.setImageResource(R.drawable.bestbuy); break;
       }
        viewHolder.mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemProduct itemProduct = new ItemProduct(
                        products.get(i).getName(),
                        products.get(i).getStore(),
                        products.get(i).getLocation(),
                        products.get(i).getPhone(),
                        products.get(i).getImg(),
                        products.get(i).getImgStore(),
                        products.get(i).getCode()
                );
                Intent intent = new Intent(context,ActivityProduct.class);
                intent.putExtra("ITEM", itemProduct);
                ((ActivityMain) context).startActivityForResult(intent,products.get(i).getCode());
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
