package com.example.android.noqfoodprototype;

import com.example.android.noqfoodprototype.constructors.CardapioItens;

import java.util.ArrayList;


public class CardapioList {
    private static ArrayList<CardapioItens> cardapio;


    public static ArrayList<CardapioItens> getItens(String loja){
        cardapio = new ArrayList<>();

        if ( loja.equals("Burger King") ){
            cardapio.add(new CardapioItens(R.drawable.cheeseburgerbk, "Cheeseburger", "R$18,90"));
            cardapio.add(new CardapioItens(R.drawable.cheddarduplobk, "Cheddar Duplo", "R$22,90"));
            cardapio.add(new CardapioItens(R.drawable.stackertriplobk, "Stacker Triplo", "R$27,90"));
            cardapio.add(new CardapioItens(R.drawable.picanhabbbk, "Picanha Barbecue Bacon", "R$29,90"));
            cardapio.add(new CardapioItens(R.drawable.fritasp, "Batata Frita P", "R$5,00"));
            cardapio.add(new CardapioItens(R.drawable.fritasp, "Batata Frita M", "R$6,50"));
            cardapio.add(new CardapioItens(R.drawable.fritasp, "Batata Frita G", "R$7,50"));
            cardapio.add(new CardapioItens(R.drawable.bkmix, "BK Mix", "R$8,50"));
        }
        else if ( loja.equals("MC Donald's") ){
            cardapio.add(new CardapioItens(R.drawable.bigmac, "Bigmac", "R$22,90"));
            cardapio.add(new CardapioItens(R.drawable.cheddarmcmelt, "Cheddar McMelt", "R$22,90"));
            cardapio.add(new CardapioItens(R.drawable.mcfishmc, "McFish", "R$22,90"));
            cardapio.add(new CardapioItens(R.drawable.quarteraomc, "Quarterão", "R$16,90"));
            cardapio.add(new CardapioItens(R.drawable.mccolosso, "McColosso", "R$3,50"));
        }
        else if ( loja.equals("Bob's") ) {
            cardapio.add(new CardapioItens(R.drawable.picanhabarbecuebobs, "Picanha Barbecue", "R$18,00"));
            cardapio.add(new CardapioItens(R.drawable.bigbob, "Big Bob", "R$12,00"));
            cardapio.add(new CardapioItens(R.drawable.franfilebobs, "Franfilé", "R$16,50"));
            cardapio.add(new CardapioItens(R.drawable.parmesaoartesanalbobs, "Parmesão Artesanal", "R$27,50"));
            cardapio.add(new CardapioItens(R.drawable.bobsmilkshake, "Milk Shake (300 ml)", "R$11,00"));
            cardapio.add(new CardapioItens(R.drawable.bobsmilkshake, "Milk Shake (500 ml)", "R$13,00"));
            cardapio.add(new CardapioItens(R.drawable.bobsmilkshake, "Milk Shake (700 ml)", "R$14,00"));
        }
        else if ( loja.equals("Subway") ){
            cardapio.add(new CardapioItens(R.drawable.frangodefumadocreamcheese, "Creamcheese(15cm)", "R$18,00"));
            cardapio.add(new CardapioItens(R.drawable.carnequeijosubway, "Carne e Queijo(15cm)", "R$15,00"));
            cardapio.add(new CardapioItens(R.drawable.peitodeperusubway, "Peito de Peru(30cm)", "R$25,00"));
            cardapio.add(new CardapioItens(R.drawable.atumsubway, "Atum(30cm)", "R$26,00"));
            cardapio.add(new CardapioItens(R.drawable.subwaymelt, "Subway Melt(30cm)", "R$30,00"));
        }
        else if ( loja.equals("Tacobell") ){
            cardapio.add(new CardapioItens(R.drawable.quesadillasteak, "Quesadilla Steak", "R$25,50"));
            cardapio.add(new CardapioItens(R.drawable.tacosupremebeef, "Tacos Supreme Beef", "R$22,50"));
            cardapio.add(new CardapioItens(R.drawable.churrostaco, "Churros (5 uni)", "R$6,50"));
            cardapio.add(new CardapioItens(R.drawable.nachossteak, "Nachos Steak", "R$23,50"));
            cardapio.add(new CardapioItens(R.drawable.chocodillatacobell, "Chocodilla", "R$6,50"));
        }

        return cardapio;
    }
}
