package com.example.android.noqfoodprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import Adapters.CardapioAdapter;
import com.example.android.noqfoodprototype.constructors.CardapioItens;

public class BobsCardapio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        //---------Arrays list bobs cardapio---------//
        ArrayList<CardapioItens> produtosBobs = new ArrayList<>();


        //--- Adicionando os produtos de cada estabelecimento
        produtosBobs.add(new CardapioItens(R.drawable.picanhabarbecuebobs, "Picanha Barbecue", "R$18,00"));
        produtosBobs.add(new CardapioItens(R.drawable.bigbob, "Big Bob", "R$12,00"));
        produtosBobs.add(new CardapioItens(R.drawable.franfilebobs, "Franfilé", "R$16,50"));
        produtosBobs.add(new CardapioItens(R.drawable.parmesaoartesanalbobs, "Parmesão Artesanal", "R$27,50"));
        produtosBobs.add(new CardapioItens(R.drawable.bobsmilkshake, "Milk Shake (300 ml)", "R$11,00"));
        produtosBobs.add(new CardapioItens(R.drawable.bobsmilkshake, "Milk Shake (500 ml)", "R$13,00"));
        produtosBobs.add(new CardapioItens(R.drawable.bobsmilkshake, "Milk Shake (700 ml)", "R$14,00"));


        //--- ArrayAdapter customizado para cardapio do bobs adapter
        CardapioAdapter itensBobsAdapter =
                new CardapioAdapter(this, produtosBobs, R.color.light_green);

        //--- List views de cada estabelecimento
        ListView listViewBobs = (ListView) findViewById(R.id.list_cardapio);
        listViewBobs.setAdapter(itensBobsAdapter);
    }
}
