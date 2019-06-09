package com.example.android.noqfoodprototype.constructors;

public class CardapioItens{

        //Nome dos produtos de cada cardapio (Ex: bigmac, whopper)
        private String mNomeProduto;

        // Text color of the text
        //private int mTextColor;

        // ID da imagem (Ex: drawable...)
        private int mImageResourceID;

        private String mValorProduto;

        /** Constant value that represents no image was provided for this word */
        private static final int NO_IMAGE_PROVIDED = -1;


        /**
         * Constructs a new TextView with initial values for text and text color.
         */
        public CardapioItens(int imageResourceID, String nomeProduto, String valorProduto) {
            mImageResourceID = imageResourceID;
            mNomeProduto = nomeProduto;
            mValorProduto = valorProduto;
        }

        /**
         * Gets the imageID
         *
         * @return current image ID
        **/
        public int getImageResourceID(){
            return mImageResourceID;
        }

        /**
         * Gets the product name
         *
         * @return current product name
         **/

        public String getNomeProduto(){
            return mNomeProduto;
        }

        /**
         * Gets the product valor
         *
         * @return current product valor
         **/
        public String getValorProduto(){
            return mValorProduto;
        }

        /**
         * Returns whether or not there is an image for this word.
         */
        public boolean hasImage() {
            return mImageResourceID != NO_IMAGE_PROVIDED;
        }

}
