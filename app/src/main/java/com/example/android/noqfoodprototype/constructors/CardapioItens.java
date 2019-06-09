package com.example.android.noqfoodprototype.constructors;

public class CardapioItens{

        //Nome
        private String cardapioItemNome;
        //Image
        private int cardapioItemImage;
        //Preço
        private String cardapioItemPreco;

        /** Constant value that represents no image was provided for this word */
        private static final int NO_IMAGE_PROVIDED = -1;


        /**
         * Constructs a new TextView with initial values for text and text color.
         */
        public CardapioItens(int cardapioItemImage, String cardapioItemNome, String cardapioItemPreco) {
            this.cardapioItemImage = cardapioItemImage;
            this.cardapioItemNome = cardapioItemNome;
            this.cardapioItemPreco = cardapioItemPreco;
        }


        public boolean hasImage() {
            return getCardapioItemImage() != NO_IMAGE_PROVIDED;
        }

        public String getCardapioItemNome() {
            return cardapioItemNome;
        }

        public void setCardapioItemNome(String cardapioItemNome) {
            this.cardapioItemNome = cardapioItemNome;
        }

        public int getCardapioItemImage() {
            return cardapioItemImage;
        }

        public void setCardapioItemImage(int cardapioItemImage) {
            this.cardapioItemImage = cardapioItemImage;
        }

        public String getCardapioItemPreco() {
            return cardapioItemPreco;
        }

        public void setCardapioItemPreco(String cardapioItemPreco) {
            this.cardapioItemPreco = cardapioItemPreco;
        }
}
