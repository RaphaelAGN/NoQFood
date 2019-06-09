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
import android.widget.Toast;

import java.util.ArrayList;

import Adapters.CardapioAdapter;
import Adapters.EstabilishmentItemAdapter;
import Utils.StartSnapHelper;

import com.example.android.noqfoodprototype.CardapioList;
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



        ArrayList<CardapioItens> cardapio = CardapioList.getItens("Burger King");


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

        //Cria um novo array com os itens da posição clicada
        ArrayList<CardapioItens> cardapio = CardapioList.getItens( adapter.getItem( position ) );

        //Adiciona novamente a recyclerView a lista atualizada
        RecyclerView cardapioRecycler = findViewById(R.id.cardapioList);
        adapterCardapio = new CardapioAdapter(this, cardapio);
        cardapioRecycler.setAdapter(adapterCardapio);

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