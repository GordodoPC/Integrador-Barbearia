package br.com.barbearia.menu;

import java.util.Scanner;

public class MenuPrincipal {

    private Scanner scanner = new Scanner(System.in);

    public void exibir() {
        int opcao;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Funcionários");
            System.out.println("3. Gerenciar Serviços");
            System.out.println("4. Gerenciar Agendamentos");
            System.out.println("5. Relatórios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    // chamar menu cliente
                    System.out.println("Menu de Clientes");
                    break;
                case 2:
                    // chamar menu funcionário
                    System.out.println("Menu de Funcionários");
                    break;
                case 3:
                    // chamar menu serviço
                    System.out.println("Menu de Serviços");
                    break;
                case 4:
                    // chamar menu agendamento
                    System.out.println("Menu de Agendamentos");
                    break;
                case 5:
                    // chamar menu de relatórios
                    System.out.println("Menu de Relatórios");
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }
}


