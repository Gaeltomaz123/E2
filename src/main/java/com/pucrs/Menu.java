package com.pucrs;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Menu {
    private ArrayList<Locomotiva> arrayLocomotivas = new ArrayList<Locomotiva>();
    private ArrayList<Vagao> arrayVagao = new ArrayList<Vagao>();
    private ArrayList<Composicao> arrayComposicao = new ArrayList<Composicao>();
    private Scanner teclado = new Scanner(System.in);

    public void condicoesIniciais() {
        for (int i = 0; i < 5; i++) {
            arrayVagao.add(new Vagao(i, 200, null));
        }
        for (int i = 0; i < 3; i++) {
            arrayLocomotivas.add(new Locomotiva(i, 1000, 10, null));
        }
    }

    public Menu() {
        condicoesIniciais();
        String escolhaMenu = "0";
        String escolhaEditar;
        boolean controlaSwitchEdicao = true;
        boolean controlaSwitchMenu = true;
        do {
            System.out.println("\n[1] ...... Criar um trem");
            System.out.println("\n[2] ...... Editar um trem");
            System.out.println("\n[3] ...... Listar todos os trens criados"); // todos os trens que estao no patio
            System.out.println("\n[4] ...... Desfazer um trem");
            System.out.println("\n[5] ...... Sair");
            System.out.println("\n..................................");
            System.out.println("");
            escolhaMenu = teclado.next();
            System.out.println("");
            switch (escolhaMenu) {
                case "1": {
                    System.out.println("..........................");
                    System.out.println("Você selecionou a opção 1");
                    System.out.println("..........................");
                    // criar o trem
                    boolean continua = true;
                    int id = 0;
                    do {
                        try {
                            System.out.println("Digite o id do Trem a ser criado: ");
                            id = teclado.nextInt();
                            continua = false;
                        } catch (InputMismatchException erro1) {
                            System.err.println("Não é permitido inserir letras, informe apenas números inteiros!");
                            teclado.nextLine();
                        }
                    } while (continua);
                    ArrayList<Locomotiva> Locomotivas = new ArrayList<Locomotiva>();
                    Locomotivas.add(arrayLocomotivas.get(0));
                    ArrayList<Vagao> Vagoes = new ArrayList<Vagao>();
                    arrayComposicao.add(new Composicao(id, Locomotivas, Vagoes));
                    arrayLocomotivas.remove(0);
                    System.out.println("\nTrem criado com sucesso!");
                    break;
                }
                case "2": {
                    if (arrayComposicao.isEmpty()) {
                        System.out.println("Ainda não existe nenhum trem!");
                        break;
                    }
                    System.out.println("..........................");
                    System.out.println("Você selecionou a opção 2");
                    System.out.println("..........................");
                    System.out.println("Digite o id do trem a ser editado: ");
                    int id = teclado.nextInt();
                    for (int j = 0; j < arrayComposicao.size(); j++) {
                        while (arrayComposicao.get(j).getidComposicao() != id) {
                            System.out.println("Este trem não existe!");
                            System.out.println("Digite o id do trem a ser editado: ");
                            id = teclado.nextInt();
                        }
                    }
                    do {
                        System.out.println("\n[1] ...... Inserir locomotiva");
                        System.out.println("\n[2] ...... Inserir vagão");
                        System.out.println("\n[3] ...... Remover último elemento do trem");
                        System.out.println("\n[4] ...... Listar locomotivas livres");
                        System.out.println("\n[5] ...... Listar os vagões livres");
                        System.out.println("\n[6] ...... Voltar ao menu");
                        System.out.println("\n..................................");
                        System.out.println("");

                        escolhaEditar = teclado.next();

                        switch (escolhaEditar) {
                            case "1": {
                                System.out.println("..........................");
                                System.out.println("Você selecionou a opção 1");
                                System.out.println("..........................");
                                for (int i = 0; i < arrayComposicao.size(); i++) {
                                    if (arrayComposicao.get(i).getidComposicao() == id) {
                                        if (arrayComposicao.get(i).getQtdVagao() == 0) {
                                            arrayComposicao.get(i).engataLocomotiva(arrayLocomotivas.get(0));
                                            arrayLocomotivas.remove(0);
                                            System.out.println("Locomotiva adicionada com sucesso!");
                                        } else {
                                            System.out
                                                    .println("Não é possível adicionar uma locomotiva após um vagão!");
                                        }
                                    }
                                }
                                break;
                            }
                            case "2": {
                                System.out.println("..........................");
                                System.out.println("Você selecionou a opção 2");
                                System.out.println("..........................");
                                for (int i = 0; i < arrayComposicao.size(); i++) {
                                    if (arrayComposicao.get(i).getidComposicao() == id) {
                                        if (arrayComposicao.get(i).engataVagao(arrayVagao.get(0)) == true) {
                                            arrayVagao.remove(0);
                                            System.out.println("Vagão adicionado com sucesso!");
                                        }
                                    }
                                }
                                break;
                            }
                            case "3": {
                                System.out.println("..........................");
                                System.out.println("Você selecionou a opção 3");
                                System.out.println("..........................");
                                for (int i = 0; i < arrayComposicao.size();) {
                                    Composicao composicao = arrayComposicao.get(i);
                                    if (composicao.getQtdVagao() > 0) {
                                        arrayVagao.add(composicao.getVagao(composicao.getQtdVagao() - 1));
                                        composicao.desengataVagao(composicao.getVagao(composicao.getQtdVagao() - 1));
                                        System.out.println("Vagão removido!");
                                        break;
                                    } else {
                                        if (composicao.getQtdLocomotivas() > 1) {
                                            arrayLocomotivas
                                                    .add(composicao.getLocomotiva(composicao.getQtdLocomotivas() - 1));
                                            composicao.desengataLocomotiva(
                                                    composicao.getLocomotiva(composicao.getQtdLocomotivas() - 1));
                                            System.out.println("Locomotiva removida!");
                                            break;
                                        } else {
                                            System.out.println("Não é possível remover a locomotiva inicial!");
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            case "4": {
                                System.out.println("..........................");
                                System.out.println("Você selecionou a opção 4");
                                System.out.println("..........................");
                                for (int i = 0; i < arrayLocomotivas.size(); i++) {
                                    Locomotiva locomotiva = arrayLocomotivas.get(i);
                                    if (locomotiva != null) {
                                        System.out.println(
                                                "Locomotiva " + locomotiva.getIdLocomotiva() + " está disponível!");
                                        System.out.println("");
                                    }
                                }
                                break;
                            }
                            case "5": {
                                System.out.println("..........................");
                                System.out.println("Você selecionou a opção 5");
                                System.out.println("..........................");
                                for (int i = 0; i < arrayVagao.size(); i++) {
                                    Vagao vagao = arrayVagao.get(i);
                                    if (vagao != null) {
                                        System.out.println("Vagão " + vagao.getIdVagao() + " está disponível!");
                                        System.out.println("");
                                    }
                                }
                                break;
                                // mostrar os vagoes disponiveis
                            }
                            case "6": {
                                System.out.println("..........................");
                                System.out.println("Você selecionou a opção 6");
                                System.out.println("..........................");
                                controlaSwitchEdicao = false;
                                break;
                            }
                            default: {
                                System.out.println("Opção Inválida");
                                System.out.println("");
                                break;
                            }
                        }
                    } while (controlaSwitchEdicao == true);
                    break;
                }
                case "3": {
                    System.out.println("..........................");
                    System.out.println("Você selecionou a opção 3");
                    System.out.println("..........................");
                    if (arrayComposicao.isEmpty()) {
                        System.out.println("Nenhum trem no pátio!\n");
                    } else {
                        for (int i = 0; i < arrayComposicao.size(); i++) {
                            arrayComposicao.get(i).toString(arrayComposicao, i);
                            System.out.println();
                        }
                    }
                    break;
                }
                case "4": {
                    System.out.println("..........................");
                    System.out.println("Você selecionou a opção 4");
                    System.out.println("..........................");
                    // remover trem
                    System.out.println("Digite o id do trem a ser removido: ");
                    int id = teclado.nextInt();
                    Composicao composicao = null;
                    for (int i = 0; i < arrayComposicao.size(); i++) {
                        if (arrayComposicao.get(i).getidComposicao() == id) {
                            composicao = arrayComposicao.get(i);
                        }
                    }
                    System.out.println(composicao.toString());
                    for (int i = 0; i < composicao.getQtdLocomotivas(); i++) {
                        arrayLocomotivas.add(composicao.getLocomotiva(i));
                    }
                    for (int i = 0; i < composicao.getQtdVagao(); i++) {
                        arrayVagao.add(composicao.getVagao(i));
                    }
                    arrayComposicao.remove(composicao);
                    break;
                }
                case "5": {
                    System.out.println("..........................");
                    System.out.println(" ");
                    System.out.println("Fim do Programa");
                    System.out.println(" ");
                    System.out.println("..........................");
                    controlaSwitchMenu = false;
                    break;
                }
                default: {
                    System.out.println("Opção Inválida");
                    break;
                }
            }
        } while (controlaSwitchMenu == true);
    }
}
