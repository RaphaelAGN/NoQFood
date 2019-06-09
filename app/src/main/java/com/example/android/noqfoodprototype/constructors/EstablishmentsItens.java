package com.example.android.noqfoodprototype.constructors;

public class EstablishmentsItens {
    //Nome de cada estabelecimento (Ex: mcdonalds, burger king)
    private String nomeEstabelecimento;

    // ID da imagem (Ex: drawable...)
    private int imageID;

    public EstablishmentsItens(int imageID, String nomeEstabelecimento) {
        this.imageID = imageID;
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public EstablishmentsItens(){
        this.nomeEstabelecimento = "";
        this.imageID = -1;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
