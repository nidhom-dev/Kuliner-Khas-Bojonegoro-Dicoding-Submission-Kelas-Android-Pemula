package com.nidhom.kulinerkhasbojonegoro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetailActivity extends AppCompatActivity {

    TextView tvtitle , tvdescription  ;
    ImageView img;
    String namakuliner , asalkuliner ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Detail Kuliner");
        }


        tvtitle = (TextView) findViewById(R.id.namadetailKuliner);
        tvdescription = (TextView) findViewById(R.id.asaldetailKuliner);
        img = (ImageView) findViewById(R.id.foto);


        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Nama");
        String Description = intent.getExtras().getString("Asal");
        String image = intent.getExtras().getString("Foto" ) ;


        tvtitle.setText(Title);
        tvdescription.setText(Description);
        Glide.with(this).load(image).into(img);
    }
}
