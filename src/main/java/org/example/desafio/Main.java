package org.example.desafio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Registros registros=new Registros();
        Scanner scanner = new Scanner(System.in);


        try {
            int num=0;
            while (num != 9) {
            System.out.println("----- MENU -----");
            System.out.println("1. Cadastrar vendedor");
            System.out.println("2. Cadastrar cliente");
            System.out.println("3. Cadastrar venda");
            System.out.println("4. Listar vendas");
            System.out.println("5. Listar vendedores");
            System.out.println("6. Listar clientes");
            System.out.println("7. Pesquisar compras por cliente");
            System.out.println("8. Pesquisar vendas por vendedor");
            System.out.println("9. Sair");
            System.out.println("Digite a opção desejada: ");
            String opcao = scanner.nextLine();
            num=Integer.parseInt(opcao);

            switch (num) {
                case 1:
                    System.out.println("Qual seu nome: ");
                    String nomeV = scanner.nextLine();
                    System.out.println("Qual seu email: ");
                    String emailV = scanner.nextLine();
                    System.out.println("Qual seu cpf : ");
                    String cpfV = scanner.nextLine();
                    registros.cadastrarVendedor(nomeV,emailV,cpfV);

                    break;
                case 2:
                    System.out.println("Qual seu nome: ");
                    String nomeC = scanner.nextLine();
                    System.out.println("Qual seu email: ");
                    String emailC = scanner.nextLine();
                    System.out.println("Qual seu cpf: ");
                    String  cpfC = scanner.nextLine();
                    registros.cadastrarCliente(nomeC,emailC,cpfC);
                    break;
                case 3:
                    System.out.println("Escolha um dos vendedores acima e digite o cpf dele: ");
                    int cpfPV = scanner.nextInt();
                    System.out.println("Qual seu cpf de cliente: ");
                    int cpfPC = scanner.nextInt();
                    System.out.println("Qual o codigo do produto que deseja: ");
                    int codigo = scanner.nextInt();
                    System.out.println("Quantas unidades deseja desse produto: ");
                    int quantidade = scanner.nextInt();
                    registros.listaPoduto();
                    registros.listarVendedores();
                    registros.cadastrarProdutos(cpfPV,cpfPC,codigo,quantidade);
                    break;
                case 4:
                    registros.listarVendas();
                    break;
                case 5:
                    registros.listarVendedores();
                    break;
                case 6:
                    registros.listarClientes();
                    break;
                case 7:
                    System.out.println("Qual seu cpf de  cliente: ");
                    int cpfCliente = scanner.nextInt();
                    registros.pesquisarComprasPorCliente(cpfCliente);
                    break;
                case 8:
                    System.out.print("Qual seu e-cpf de  vendedor: ");
                    int cpfVendedor = scanner.nextInt();
                    registros.pesquisarVendasPorVendedor(cpfVendedor);
                    break;
                case 9:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente.");
                    break;
            }
        }
        }catch (NumberFormatException e){
            System.out.println("Digite um numero inteito!");
        }
    }

}