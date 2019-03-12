package com.iteso.sesion09;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.iteso.sesion09.beans.ItemProduct;

public class ActivityProduct extends AppCompatActivity {
  EditText title;
  EditText store;
  EditText location;
  EditText phone;
  ImageView img;
  ItemProduct p1, p2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        title = findViewById(R.id.item_product_title);
        store = findViewById(R.id.item_product_store);
        location = findViewById(R.id.item_product_location);
        phone = findViewById(R.id.item_product_phone);
        img = findViewById(R.id.item_product_image);

        try{
            if(getIntent().getExtras() != null){
                p1 = getIntent().getParcelableExtra("ITEM");
                if(p1 != null){
                    title.setText(p1.getName());
                    store.setText(p1.getStore());
                    location.setText(p1.getLocation());
                    phone.setText(p1.getPhone());
                    switch (p1.getImg()){
                        case 0: img.setImageResource(R.drawable.mac); break;
                        case 1: img.setImageResource(R.drawable.alienware); break;
                        case 2: img.setImageResource(R.drawable.micro); break;
                        case 3: img.setImageResource(R.drawable.refrigerator); break;
                        case 4: img.setImageResource(R.drawable.sheets); break;
                        case 5: img.setImageResource(R.drawable.pillows); break;
                        default: img.setImageResource(R.drawable.mac); break;
                    }
                }
            }
        }catch (Exception e){}
    }
    public void cancel(View v){
        setResult(RESULT_CANCELED);
        finish();
    }
    public void save(View v){
        p2 = new ItemProduct();
        p2.setName(title.getText().toString());
        p2.setStore(store.getText().toString());
        p2.setPhone(phone.getText().toString());
        p2.setLocation(location.getText().toString());
        p2.setImg(p1.getImg());
        p2.setCode(p1.getCode());

        Intent intent = new Intent();
        intent.putExtra("ITEM", p2);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
