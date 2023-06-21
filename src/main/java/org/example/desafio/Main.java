package org.example.desafio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Registros registros = new Registros();
        Scanner scanner = new Scanner(System.in);


        try {
            int num = 0;
            boolean encerrar=false;
            while (!encerrar) {
                System.out.println("----- MENU -----");
                System.out.println("1. Cadastrar vendedor");
                System.out.println("2. Cadastrar cliente");
                System.out.println("3. Logar como vendedor");
                System.out.println("4. Logar como cliente");
                System.out.println("5. Sair");
                System.out.println("Digite a opção desejada: ");
                String opcao = scanner.next();
                num = Integer.parseInt(opcao);

                switch (num) {
                    case 1:
                        System.out.println("Qual seu nome: ");
                        String nomeV = scanner.next();
                        System.out.println("Qual seu email: ");
                        String emailV = scanner.next();
                        System.out.println("Qual seu cpf : ");
                        String cpfV = scanner.next();
                        System.out.println("Informe uma senha para quando for logar: ");
                        String senhaV = scanner.next();
                        registros.cadastrarVendedor(nomeV, emailV, cpfV, senhaV);

                        break;
                    case 2:
                        System.out.println("Qual seu nome: ");
                        String nomeC = scanner.next();
                        System.out.println("Qual seu email: ");
                        String emailC = scanner.next();
                        System.out.println("Qual seu cpf: ");
                        String cpfC = scanner.next();
                        System.out.println("Informe uma senha para quando for logar: ");
                        String senhaC = scanner.next();
                        registros.cadastrarCliente(nomeC, emailC, cpfC, senhaC);
                        break;
                    case 3:
                        registros.listarVendedores();
                        System.out.println("Qual seu cpf: ");
                        int cpf = scanner.nextInt();
                        System.out.println("Qual sua senha: ");
                        String senha = scanner.next();
                        registros.logarComoVendedor(cpf, senha);
                        break;
                    case 4:
                        registros.listarClientes();
                        System.out.println("Qual seu cpf: ");
                        int cpfc = scanner.nextInt();
                        System.out.println("Qual sua senha: ");
                        String senhac = scanner.next();
                        registros.logarComoCliente(cpfc, senhac);
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        encerrar=true;

                        break;

                    default:
                        System.out.println("Opção inválida. Digite novamente.");
                        break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Digite um numero inteito!");
        }
    }
}