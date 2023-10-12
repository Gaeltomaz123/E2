package com.pucrs;

public class Vagao {
    private int idVagao;
    private double capMaxdeCarga;
    private Composicao composicao;

    public Vagao (int idVagao, double capMaxdeCarga, Composicao composicao){
        this.idVagao = idVagao;
        this.capMaxdeCarga = capMaxdeCarga;
        this.composicao = composicao;    
    }

    public int getIdVagao() {
        return idVagao;
    }

    public void setIdVagao(int idVagao) {
        this.idVagao = idVagao;
    }

    public double getCapMaxdeCarga() {
        return capMaxdeCarga;
    }

    public void setCapMaxdeCarga(double capMaxdeCarga) {
        this.capMaxdeCarga = capMaxdeCarga;
    }

    public Composicao getComposicaoVagao() {
        return composicao;
    }

    public void setComposicaoVagao(Composicao composicao) {
        this.composicao = composicao;
    }
}
