package com.example.android.noqfoodprototype.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import Adapters.EstabilishmentItemAdapter;

import com.example.android.noqfoodprototype.BKCardapio;
import com.example.android.noqfoodprototype.BobsCardapio;
import com.example.android.noqfoodprototype.MCDonaldsCardapio;
import com.example.android.noqfoodprototype.R;
import com.example.android.noqfoodprototype.SubwayCardapio;
import com.example.android.noqfoodprototype.TacobellCardapio;
import com.example.android.noqfoodprototype.constructors.EstablishmentsItens;
import com.google.firebase.auth.FirebaseAuth;
public class MainActivity extends AppCompatActivity implements EstabilishmentItemAdapter.ItemClickListener {

    private EstabilishmentItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estabilhments_itens);

        ArrayList<EstablishmentsItens> estabelecimentos = new ArrayList<>();

        estabelecimentos.add(new EstablishmentsItens(R.drawable.bk, "Burger King"));
        estabelecimentos.add(new EstablishmentsItens(R.drawable.mcdonalds, "MC Donald's"));
        estabelecimentos.add(new EstablishmentsItens(R.drawable.bobs, "Bob's"));
        estabelecimentos.add(new EstablishmentsItens(R.drawable.subway, "Subway"));
        estabelecimentos.add(new EstablishmentsItens(R.drawable.tacobell, "Tacobell"));


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.estabilishmentsList);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        adapter = new EstabilishmentItemAdapter(this, estabelecimentos);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        switch(position){
            case 0:  Intent bk = new Intent(MainActivity.this, BKCardapio.class);
                startActivity(bk);
                break;
            case 1:  Intent mc = new Intent(MainActivity.this, MCDonaldsCardapio.class);
                startActivity(mc);
                break;
            case 2:  Intent bobs = new Intent(MainActivity.this, BobsCardapio.class);
                startActivity(bobs);
                break;
            case 3:  Intent subway = new Intent(MainActivity.this, SubwayCardapio.class);
                startActivity(subway);
                break;
            case 4:  Intent tacobell = new Intent(MainActivity.this, TacobellCardapio.class);
                startActivity(tacobell);
                break;
        }
        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on item position " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuLogout:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;

            case R.id.action_add:
        }
        return true;
    }
}