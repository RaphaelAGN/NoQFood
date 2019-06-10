package com.example.android.noqfoodprototype.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
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

import Adapters.CardapioAdapter;
import Adapters.EstabilishmentItemAdapter;
import Utils.StartSnapHelper;
import com.example.android.noqfoodprototype.GetList;
import com.example.android.noqfoodprototype.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements CardapioAdapter.ItemClickListener {

    private EstabilishmentItemAdapter adapter;
    private CardapioAdapter adapterCardapio;

    private LinearLayoutManager horizontalLayoutManager;
    private LinearLayoutManager verticalLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Actibity que será usada
        setContentView(R.layout.activity_estabilhments_itens);


        //Lista de estabelecimentos
        //Set RecyclerView da lista de estabelecimentos
        RecyclerView recyclerView = findViewById(R.id.estabilishmentsList);
        horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager( horizontalLayoutManager );
        adapter = new EstabilishmentItemAdapter(this, GetList.getEstabelecimentos() );
        //Seta o scrolllistener do RecyclerView
        recyclerView.addOnScrollListener(onScrollListener);
        recyclerView.setAdapter(adapter);

        //Set SnapHelper para centralizar os items da lista de estabelecimentos
        SnapHelper startSnapHelper = new StartSnapHelper();
        startSnapHelper.attachToRecyclerView( recyclerView );


        RecyclerView cardapioRecycler = findViewById(R.id.cardapioList);
        verticalLayout = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        cardapioRecycler.setLayoutManager(verticalLayout);
        setCardapio( 0 );
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, ("Item clicado: " + adapterCardapio.getItem( position )), Toast.LENGTH_SHORT).show();
    }

    private void setCardapio(int position){
        //Adiciona novamente a recyclerView a lista atualizada
        RecyclerView cardapioRecycler = findViewById(R.id.cardapioList);
        //Adiciona o adapter a nova lista de elementos criada
        adapterCardapio = new CardapioAdapter(this, GetList.getItens( adapter.getItem( position ) ));
        adapterCardapio.setClickListener(this);
        cardapioRecycler.setAdapter(adapterCardapio);
    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }
        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            //Se só houver um elemento sendo exibido na tela
            if ( (horizontalLayoutManager.getChildCount()) == 1 ){
                //Seta o cardapio para exibir os items dele
                setCardapio( horizontalLayoutManager.findFirstVisibleItemPosition() );
            }
        }
    };

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