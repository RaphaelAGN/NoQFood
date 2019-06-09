package com.example.android.noqfoodprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

import Adapters.CardapioAdapter;
import com.example.android.noqfoodprototype.constructors.CardapioItens;

public class MCDonaldsCardapio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        //---------Arrays list mc cardapio---------//
        ArrayList<CardapioItens> produtosMC = new ArrayList<>();


        //--- Adicionando os produtos de cada estabelecimento
        produtosMC.add(new CardapioItens(R.drawable.bigmac, "Bigmac", "R$22,90"));
        produtosMC.add(new CardapioItens(R.drawable.cheddarmcmelt, "Cheddar McMelt", "R$22,90"));
        produtosMC.add(new CardapioItens(R.drawable.mcfishmc, "McFish", "R$22,90"));
        produtosMC.add(new CardapioItens(R.drawable.quarteraomc, "Quarterão", "R$16,90"));
        produtosMC.add(new CardapioItens(R.drawable.mccolosso, "McColosso", "R$3,50"));


        //--- ArrayAdapter customizado para cardapio do MCDonalds adapter
        CardapioAdapter itensMCAdapter =
                new CardapioAdapter(this, produtosMC, R.color.light_green);

        //--- List views de cada estabelecimento
        ListView listViewMC = (ListView) findViewById(R.id.list_cardapio);
        listViewMC.setAdapter(itensMCAdapter);
    }

}
