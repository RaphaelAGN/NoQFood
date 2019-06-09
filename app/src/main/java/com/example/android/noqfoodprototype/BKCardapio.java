package com.example.android.noqfoodprototype;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import Adapters.CardapioAdapter;
import com.example.android.noqfoodprototype.constructors.CardapioItens;

public class BKCardapio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        //---------Arrays list bk cardapio---------//
        final ArrayList<CardapioItens> produtosBK = new ArrayList<>();


        //--- Adicionando os produtos de cada estabelecimento
        produtosBK.add(new CardapioItens(R.drawable.cheeseburgerbk, "Cheeseburger", "R$18,90"));
        produtosBK.add(new CardapioItens(R.drawable.cheddarduplobk, "Cheddar Duplo", "R$22,90"));
        produtosBK.add(new CardapioItens(R.drawable.stackertriplobk, "Stacker Triplo", "R$27,90"));
        produtosBK.add(new CardapioItens(R.drawable.picanhabbbk, "Picanha Barbecue Bacon", "R$29,90"));
        produtosBK.add(new CardapioItens(R.drawable.fritasp, "Batata Frita P", "R$5,00"));
        produtosBK.add(new CardapioItens(R.drawable.fritasp, "Batata Frita M", "R$6,50"));
        produtosBK.add(new CardapioItens(R.drawable.fritasp, "Batata Frita G", "R$7,50"));
        produtosBK.add(new CardapioItens(R.drawable.bkmix, "BK Mix", "R$8,50"));


        //--- ArrayAdapter customizado para cardapio do BK adapter
        CardapioAdapter itensBKAdapter =
            new CardapioAdapter(this, produtosBK, R.color.light_green);

        //--- List views de cada estabelecimento
        ListView listViewBK = (ListView) findViewById(R.id.list_cardapio);
        listViewBK.setAdapter(itensBKAdapter);

        //----  Abrir nova intent click list view
        /*listViewBK.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0:  Intent cheeseburger = new Intent(BKCardapio.this, InfoProduto.class);
                        startActivity(cheeseburger);
                        break;
                    case 1:  Intent cheddardp = new Intent(BKCardapio.this, InfoProduto.class);
                        startActivity(cheddardp);
                        break;
                    case 2:  Intent bobs = new Intent(BKCardapio.this, InfoProduto.class);
                        startActivity(bobs);
                        break;
                    case 3:  Intent subway = new Intent(BKCardapio.this, InfoProduto.class);
                        startActivity(subway);
                        break;
                    case 4:  Intent tacobell = new Intent(BKCardapio.this, InfoProduto.class);
                        startActivity(tacobell);
                        break;
                }
            }
        });*/

    }

}
