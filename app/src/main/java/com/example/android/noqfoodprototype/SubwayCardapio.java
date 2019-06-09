package com.example.android.noqfoodprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import Adapters.CardapioAdapter;
import com.example.android.noqfoodprototype.constructors.CardapioItens;

public class SubwayCardapio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        //--------- ArrayList subway cardapio --------//
        ArrayList<CardapioItens> produtosSubway = new ArrayList<>();
        produtosSubway.add(new CardapioItens(R.drawable.frangodefumadocreamcheese, "Creamcheese(15cm)", "R$18,00"));
        produtosSubway.add(new CardapioItens(R.drawable.carnequeijosubway, "Carne e Queijo(15cm)", "R$15,00"));
        produtosSubway.add(new CardapioItens(R.drawable.peitodeperusubway, "Peito de Peru(30cm)", "R$25,00"));
        produtosSubway.add(new CardapioItens(R.drawable.atumsubway, "Atum(30cm)", "R$26,00"));
        produtosSubway.add(new CardapioItens(R.drawable.subwaymelt, "Subway Melt(30cm)", "R$30,00"));

        //--- ArrayAdapter customizado para cardapio do Subway adapter
        CardapioAdapter itensSubwayAdapter =
                new CardapioAdapter(this, produtosSubway, R.color.light_green);

        //--- Listview do subway
        ListView listViewSubway = (ListView) findViewById(R.id.list_cardapio);
        listViewSubway.setAdapter(itensSubwayAdapter);
    }
}
