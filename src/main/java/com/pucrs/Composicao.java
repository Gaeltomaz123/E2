package com.pucrs;

import java.util.ArrayList;

public class Composicao {
    private int idComposicao;
    private ArrayList<Locomotiva> arrayLocomotivas;
    private ArrayList<Vagao> arrayVagao;

    public Composicao(int idComposicao, ArrayList<Locomotiva> arrayLocomotivas, ArrayList<Vagao> arrayVagao) {
        this.idComposicao = idComposicao;
        this.arrayLocomotivas = arrayLocomotivas;
        this.arrayVagao = arrayVagao;
    }

    public int getidComposicao() {
        return idComposicao;
    }

    public int getQtdLocomotivas() {
        return arrayLocomotivas.size();
    }

    public Locomotiva getLocomotiva(int posicao) {
        return arrayLocomotivas.get(posicao);
    }

    public int getQtdVagao() {
        return arrayVagao.size();
    }

    public Vagao getVagao(int posicao) {
        return arrayVagao.get(posicao);
    }

    public boolean criarTrem(int id, ArrayList<Locomotiva> arrayLocomotivas) {
        boolean estado = false;
        return estado;
    }

    public boolean engataLocomotiva(Locomotiva locomotiva) {
        boolean estado = false;
        arrayLocomotivas.add(locomotiva);
        double reducao = 0.10;
        double capacidadeTotal = locomotiva.getPesoMaximo();
        for (int i = 0; i < arrayLocomotivas.size(); i++) {
            Locomotiva l = arrayLocomotivas.get(i);
            capacidadeTotal += l.getPesoMaximo() * reducao;
            l.setPesoMaximo(capacidadeTotal);
        }
        System.out.println("Nova capacidade total: " + capacidadeTotal);
        return estado;
    }

    public boolean engataVagao(Vagao vagao) {
        boolean estado = false;

        for (Locomotiva locomotiva : arrayLocomotivas) {
            if (locomotiva.getPesoMaximo() > 0) {
                estado = true;
                double capacidadeAtual = locomotiva.getPesoMaximo();
                double novaCapacidade = capacidadeAtual - 400;
                if (novaCapacidade < 400) {
                    novaCapacidade = 0;
                }
                novaCapacidade = Math.ceil(novaCapacidade * 10) / 10;
                locomotiva.setPesoMaximo(novaCapacidade);
                System.out.println(
                        "Locomotiva ID: " + locomotiva.getIdLocomotiva() + ", Capacidade Atual: " + novaCapacidade);
            } else {
                estado = false;
                System.out.println("O peso foi excedido!");
            }
        }
        if (estado == true) {
            arrayVagao.add(vagao);
        }
        return estado;
    }

    public boolean desengataLocomotiva(Locomotiva locomotiva) {
        boolean estado = false;
        arrayLocomotivas.remove(locomotiva);
        return estado;
    }

    public boolean desengataVagao(Vagao vagao) {
        boolean estado = false;
        arrayVagao.remove(vagao);
        return estado;
    }

    public void toString(ArrayList<Composicao> composicao, int posicao) {
        System.out.println("Id do Trem:" + composicao.get(posicao).getidComposicao()
                + "\nQuantidade Locomotivas: " + composicao.get(posicao).getQtdLocomotivas()
                + "\nLocomotivas: ");
        for (int i = 0; i < getQtdLocomotivas(); i++) {
            System.out
                    .println("Id da Locomotiva: " + composicao.get(posicao).arrayLocomotivas.get(i).getIdLocomotiva());
        }
        System.out.println("\nQuantidade Vagões: " + composicao.get(posicao).getQtdVagao()
                + "\nVagoẽs: ");
        for (int i = 0; i < getQtdVagao(); i++) {
            System.out.println("Id do Vagao: " + composicao.get(posicao).arrayVagao.get(i).getIdVagao());
        }
        ;
        System.out.println("..........................");
    }
}
