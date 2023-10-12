package com.pucrs;

public class Locomotiva {
    private int idLocomotiva;
    private double pesoMaximo;
    private int numeroMaxVagoes;
    private Composicao composicao;

    public Locomotiva(int idLocomotiva, double pesoMaximo, int numeroMaxVagoes, Composicao composicao){
        this.idLocomotiva = idLocomotiva;
        this.pesoMaximo = pesoMaximo;
        this.numeroMaxVagoes = numeroMaxVagoes;
        this.composicao = composicao;
    }

    public int getIdLocomotiva() {
        return idLocomotiva;
    }

    public void setIdLocomotiva(int idLocomotiva) {
        this.idLocomotiva = idLocomotiva;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public int getNumeroMaxVagoes() {
        return numeroMaxVagoes;
    }

    public void setNumeroMaxVagoes(int numeroMaxVagoes) {
        this.numeroMaxVagoes = numeroMaxVagoes;
    }

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }
}