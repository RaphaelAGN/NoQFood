package com.example.android.noqfoodprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import Adapters.CardapioAdapter;
import com.example.android.noqfoodprototype.constructors.CardapioItens;

public class TacobellCardapio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        //--------- ArrayList tacobell cardapio --------//
        ArrayList<CardapioItens> produtosTacobell = new ArrayList<>();
        produtosTacobell.add(new CardapioItens(R.drawable.quesadillasteak, "Quesadilla Steak", "R$25,50"));
        produtosTacobell.add(new CardapioItens(R.drawable.tacosupremebeef, "Tacos Supreme Beef", "R$22,50"));
        produtosTacobell.add(new CardapioItens(R.drawable.churrostaco, "Churros (5 uni)", "R$6,50"));
        produtosTacobell.add(new CardapioItens(R.drawable.nachossteak, "Nachos Steak", "R$23,50"));
        produtosTacobell.add(new CardapioItens(R.drawable.chocodillatacobell, "Chocodilla", "R$6,50"));

        //--- ArrayAdapter customizado para cardapio do Tacobell adapter
        CardapioAdapter itensTacobellAdapter =
                new CardapioAdapter(this, produtosTacobell, R.color.light_green);

        //--- Listview do subway
        ListView listViewTacobell = (ListView) findViewById(R.id.list_cardapio);
        listViewTacobell.setAdapter(itensTacobellAdapter);
    }
}
