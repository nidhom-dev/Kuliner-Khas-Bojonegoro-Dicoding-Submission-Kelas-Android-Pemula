package com.nidhom.kulinerkhasbojonegoro;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.nidhom.kulinerkhasbojonegoro.adapter.KulinerAdapter;
import com.nidhom.kulinerkhasbojonegoro.model.DataKuliner;
import com.nidhom.kulinerkhasbojonegoro.model.Kuliner;

import java.util.ArrayList;
import java.util.zip.Inflater;

import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView item_kuliner;
    ArrayList<Kuliner> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item_kuliner = findViewById(R.id.item_kuliner);
        item_kuliner.setHasFixedSize(true);

        list.addAll(DataKuliner.getListData());
        showRecycleList();

    }


    private void showRecycleList() {

        item_kuliner.setLayoutManager(new LinearLayoutManager(this));
        KulinerAdapter kulinerAdapter = new KulinerAdapter(list);
        item_kuliner.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        item_kuliner.setItemAnimator(new SlideInDownAnimator());
        item_kuliner.setAdapter(kulinerAdapter);
        kulinerAdapter.setOnItemClickCallback(new KulinerAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Kuliner data) {
                showSelectedKuliner(data);
            }
        });

    }
    private void showSelectedKuliner(Kuliner kuliner) {
        Toast.makeText(this, "Kamu memilih " + kuliner.getNama(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.tentangsaya:
                Intent intent = new Intent(MainActivity.this , AboutActivity.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
