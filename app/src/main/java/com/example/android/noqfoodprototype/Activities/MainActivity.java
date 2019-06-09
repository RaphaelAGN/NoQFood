package com.example.android.noqfoodprototype.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

import Adapters.CardapioAdapter;
import Adapters.EstabilishmentItemAdapter;
import Utils.StartSnapHelper;
import com.example.android.noqfoodprototype.R;
import com.example.android.noqfoodprototype.constructors.CardapioItens;
import com.example.android.noqfoodprototype.constructors.EstablishmentsItens;
import com.google.firebase.auth.FirebaseAuth;
public class MainActivity extends AppCompatActivity implements EstabilishmentItemAdapter.ItemClickListener, CardapioAdapter.ItemClickListener {

    private EstabilishmentItemAdapter adapter;
    private CardapioAdapter adapterCardapio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Tela que será usada
        setContentView(R.layout.activity_estabilhments_itens);

        //Lista de estabelecimentos
        ArrayList<EstablishmentsItens> estabelecimentos = new ArrayList<>();
        estabelecimentos.add(new EstablishmentsItens(R.drawable.bk, "Burger King"));
        estabelecimentos.add(new EstablishmentsItens(R.drawable.mcdonalds, "MC Donald's"));
        estabelecimentos.add(new EstablishmentsItens(R.drawable.bobs, "Bob's"));
        estabelecimentos.add(new EstablishmentsItens(R.drawable.subway, "Subway"));
        estabelecimentos.add(new EstablishmentsItens(R.drawable.tacobell, "Tacobell"));


        //Set RecyclerView da lista de estabelecimentos
        RecyclerView recyclerView = findViewById(R.id.estabilishmentsList);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        adapter = new EstabilishmentItemAdapter(this, estabelecimentos);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        //Set SnapHelper para centralizar os items da lista de estabelecimentos
        SnapHelper startSnapHelper = new StartSnapHelper();
        startSnapHelper.attachToRecyclerView( recyclerView );


        //Set Cardapio
        ArrayList<CardapioItens> cardapio = new ArrayList<>();
        cardapio.add(new CardapioItens(R.drawable.cheeseburgerbk, "Cheeseburger", "R$18,90"));
        cardapio.add(new CardapioItens(R.drawable.cheddarduplobk, "Cheddar Duplo", "R$22,90"));
        cardapio.add(new CardapioItens(R.drawable.stackertriplobk, "Stacker Triplo", "R$27,90"));
        cardapio.add(new CardapioItens(R.drawable.picanhabbbk, "Picanha Barbecue Bacon", "R$29,90"));
        cardapio.add(new CardapioItens(R.drawable.fritasp, "Batata Frita P", "R$5,00"));
        cardapio.add(new CardapioItens(R.drawable.fritasp, "Batata Frita M", "R$6,50"));
        cardapio.add(new CardapioItens(R.drawable.fritasp, "Batata Frita G", "R$7,50"));
        cardapio.add(new CardapioItens(R.drawable.bkmix, "BK Mix", "R$8,50"));

        RecyclerView cardapioRecycler = findViewById(R.id.cardapioList);
        LinearLayoutManager verticalLayout
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        cardapioRecycler.setLayoutManager(verticalLayout);
        adapterCardapio = new CardapioAdapter(this, cardapio);
        adapterCardapio.setClickListener(this);
        cardapioRecycler.setAdapter(adapterCardapio);
    }

    @Override

    public void onItemClick(View view, int position) {
        /*
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
        */
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