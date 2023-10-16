package com.pucrs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LerArquivoCSV {
    public static void main(String[] args) {
        String arquivoCSV = "C:\\Users\\palad\\Desktop\\ex2\\src\\main\\java\\com\\example\\csv.csv";

        ArrayList<ArrayList<String>> trens = new ArrayList<>();
        trens.add(new ArrayList<>()); // Primeiro trem
        trens.add(new ArrayList<>()); // Segundo trem
        trens.add(new ArrayList<>()); // Terceiro trem

        int indiceAtual = 0; // Índice atual do trem

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] colunas = linha.split(",");
                for (String coluna : colunas) {
                    if (coluna.equals("T")) {
                        indiceAtual = (indiceAtual + 1) % trens.size();
                    } else {
                        ArrayList<String> tremAtual = trens.get(indiceAtual);
                        if (tremAtual.size() < 5) {
                            tremAtual.add(coluna);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < trens.size(); i++) {
            ArrayList<String> trem = trens.get(i);
            System.out.print("TREM " + (i + 1) + ":");
            for (String carro : trem) {
                System.out.print(carro);
            }
            System.out.println();
        }
    }
}
