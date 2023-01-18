package com.virnanda.candiindonesia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_candi;
    private ArrayList<Candi> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_candi = findViewById(R.id.rvCandi);
        rv_candi.setHasFixedSize(true);

        list.addAll(DataCandi.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        rv_candi.setLayoutManager(new LinearLayoutManager(this));
        CardViewCandiAdapter cardViewCandiAdapter = new CardViewCandiAdapter(list);
        rv_candi.setAdapter(cardViewCandiAdapter);

        cardViewCandiAdapter.setOnItemClickCallback(new CardViewCandiAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Candi candi) {
                Intent move = new Intent(MainActivity.this, DetailActivity.class);
                move.putExtra(DetailActivity.ITEM_EXTRA, candi);
                startActivity(move);
            }
        });

    }

    //Keluar dari aplikasi
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Exit App");
        alertDialog.setMessage("Do you want to exit app?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}