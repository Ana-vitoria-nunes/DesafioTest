package org.example.desafio;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.*;

public class Registros {
    private List<Vendas> vendas;
    private List<Produto> produtos;
    private Map<Integer, Vendedor> vendedores;
    private Map<Integer, Cliente> clientes;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    Scanner scanner = new Scanner(System.in);

    public Registros() {
        vendas = new ArrayList<>();
        vendedores = new HashMap<>();
        clientes = new HashMap<>();
        produtos = new ArrayList<>();

    }

    public void cadastrarVendedor(String nome, String email, String cpf, String senha) {
        vendedores.put(123, new Vendedor("Ana@nunes", "Ana", 123, "ana123"));
        vendedores.put(789, new Vendedor("Roberto@lopes", "Roberto", 789, "roberto123"));
        vendedores.put(456, new Vendedor("Luis@carlos", "Luis", 456, "luis123"));

        try {
            System.out.println();
            if (!nome.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Valor informado não é uma string, digite seu nome com uma String valida e sem espaço!");
            }
            System.out.println();
            if (!email.contains("@")) {
                throw new IllegalArgumentException("O email precisa conter o @");
            }
            boolean encontrado = false;
            for (Vendedor produto : vendedores.values()) {
                if (produto.getEmail().equals(email)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                throw new IllegalArgumentException("E-mail já cadastrados para outro vendedor!");
            }

            System.out.println();
            int numero = Integer.parseInt(cpf);
            if (vendedores.containsKey(numero)) {
                throw new IllegalArgumentException("CPF já cadastrados para outro vendedor!");
            } else {

                String senhaCriptografada = passwordEncoder.encode(senha);
                vendedores.put(numero, new Vendedor(email, nome, numero, senhaCriptografada));
                System.out.println("Vendedor cadastrado com sucesso!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro; " + e.getMessage());
        }
    }

    public void cadastrarCliente(String nomeC, String emailC, String cpfC, String senha) {
        clientes.put(333, new Cliente("Ricardo@", "Ricardo", 333, senha));
        clientes.put(111, new Cliente("Daniel@", "Daniel", 111, senha));
        clientes.put(222, new Cliente("Ruboia@", "Rubia", 222, senha));

        try {
            if (!nomeC.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Valor informado não é uma string, digite seu nome com uma String valida e sem espaço!");
            }

            if (!emailC.contains("@")) {
                throw new IllegalArgumentException("O email precisa conter o @");
            }
            boolean encontrado = false;
            for (Cliente produto : clientes.values()) {
                if (produto.getEmail().equals(emailC)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                throw new IllegalArgumentException("E-mail já cadastrados para outro cliente!");
            }

            int numero = Integer.parseInt(cpfC);

            if (clientes.containsKey(numero)) {
                throw new IllegalArgumentException("CPF já cadastrados para outro Cliente!");
            } else {
                String senhaCriptografada = passwordEncoder.encode(senha);
                clientes.put(numero, new Cliente(emailC, nomeC, numero, senhaCriptografada));
                System.out.println("Cliente cadastrado com sucesso!");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void fazerCompra() {
        clientes.put(333, new Cliente("Ricardo@", "Ricardo", 333, "ricardo123"));
        clientes.put(111, new Cliente("Daniel@", "Daniel", 111, "daniel123"));
        clientes.put(222, new Cliente("Rubia@", "Rubia", 222, "rubia123"));

        vendedores.put(123, new Vendedor("Ana@nunes", "Ana", 123, "ana123"));

        produtos.add(new Produto(12, "Bolo de chocolate", 5.75));

        try {
            listarVendedores();
            System.out.println("Escolha um dos vendedores acima e digite o cpf dele: ");
            int cpfPV = scanner.nextInt();
            System.out.println("Qual seu cpf de cliente: ");
            int cpfPC = scanner.nextInt();
            listaPoduto();
            System.out.println("Qual o codigo do produto que deseja: ");
            int codigo = scanner.nextInt();
            System.out.println("Quantas unidades deseja desse produto: ");
            int quantidade = scanner.nextInt();
            System.out.println();
            if (!vendedores.containsKey(cpfPV)) {
                throw new IllegalArgumentException("Vendedor não cadastrado!");
            }

            System.out.println();
            if (!clientes.containsKey(cpfPC)) {
                throw new IllegalArgumentException("Cliente não cadastrado!");
            }

            Produto produto = new Produto(0, "", 0);
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getCodigo() == codigo) {
                    System.out.println();
                    produto = produtos.get(i);
                }
            }
            if (produto.getNomeProduto().isEmpty()) {
                throw new IllegalArgumentException("Codigo não encontrado");
            }
            System.out.println("Produto cadastrado com sucesso");
            LocalDate data = LocalDate.now();
            Vendedor vendedor = vendedores.get(cpfPV);
            Cliente cliente = clientes.get(cpfPC);
            vendas.add(new Vendas(vendedor, cliente, codigo, produto.getNomeProduto(), produto.getPreco(), quantidade, data));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public void logarComoVendedor(int cpfPV, String senha) {

        try {
            if (!vendedores.containsKey(cpfPV)) {
                throw new IllegalArgumentException("Cpf não cadastrado");
            }
            boolean encontrado = false;
            for (Vendedor senhas : vendedores.values()) {
                // Comparar a senha criptografada com a senha informada
                if (passwordEncoder.matches(senha, senhas.getSenha())) {
                    encontrado = true;
                    break;
                }
            }

//            boolean encontrado = false;
//            for (Vendedor senhas : vendedores.values()) {
//                if (senhas.getSenha().equals(senha)) {
//                    encontrado = true;
//                    break;
//                }
//            }
             if (encontrado){
                System.out.println("Bem vindo Vendedor");
                boolean encerrar = false;
                while (!encerrar) {
                    System.out.println("1. Listar vendas");
                    System.out.println("2. Listar vendedores");
                    System.out.println("3. Listar clientes");
                    System.out.println("4. Pesquisar vendas por vendedor");
                    System.out.println("5. Sair");
                    System.out.println("Digite a opção desejada: ");
                    int escolha=scanner.nextInt();

                    switch (escolha){
                        case 1:
                            listarVendas();
                            break;
                        case 2:
                            listarVendedores();
                            break;
                        case 3:
                            listarClientes();
                            break;
                        case 4:
                            pesquisarVendasPorVendedor();
                            break;
                        case 5:
                            System.out.println("Saindo...");
                            encerrar=true;
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                }
            }
             else {
                 throw new IllegalArgumentException("Senha não cadastrada");
             }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public void logarComoCliente(int cpfPV, String senhaC) {
        clientes.put(333, new Cliente("Ricardo@", "Ricardo", 333, "ricardo123"));

        try {
            if (!clientes.containsKey(cpfPV)) {
                throw new IllegalArgumentException("Cpf invalido");
            }

            boolean encontrado = false;
            for (Cliente senha : clientes.values()) {
                // Comparar a senha criptografada com a senha informada
                if (passwordEncoder.matches(senhaC, senha.getSenha())) {
                    encontrado = true;
                    break;
                }
            }
//            boolean encontrado = false;
//            for (Cliente senhas : clientes.values()) {
//                if (senhas.getSenha().equals(senha)) {
//                    encontrado = true;
//                    break;
//                }
//            }
            if (encontrado){
                System.out.println("Bem vindo Cliente");
                boolean encerrar = false;
                while (!encerrar) {
                    System.out.println("1. Fazer compra");
                    System.out.println("2. Pesquisar compras por cliente");
                    System.out.println("3. Sair");
                    System.out.println("Digite a opção desejada: ");
                    int opcao = scanner.nextInt();

                    switch (opcao) {
                        case 1:
                            fazerCompra();
                            break;
                        case 2:
                            pesquisarComprasPorCliente();
                            break;
                        case 3:
                            System.out.println("Saindo...");
                            encerrar = true;
                            break;
                        default:
                            System.out.println("Opção inválida");

                    }
                }
            }
            else {
                throw new IllegalArgumentException("Senha não cadastrada");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public void pesquisarComprasPorCliente() {
        clientes.put(111, new Cliente("Daniel@", "Daniel", 111, "daniel123"));
        System.out.println("Qual seu cpf de  cliente: ");
        int cpfCliente = scanner.nextInt();

        System.out.println();
        if (clientes.containsKey(cpfCliente)) {
            System.out.println("Compras do cliente com cpf " + cpfCliente + ":");
            for (Vendas venda : vendas) {
                if (clientes.containsKey(cpfCliente)) {
                    System.out.println("Código: " + venda.getCodigo());
                    System.out.println("Produto: " + venda.getNomeProduto());
                    System.out.println("Preço: " + venda.getPreco());
                    System.out.println("Quantidade: " + venda.getQuantidade());
                    System.out.println("Valor Total: " + venda.getValorTotal());
                    System.out.println("-----------------------");
                }
            }
        } else {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
    }
    public void pesquisarVendasPorVendedor() {

        vendedores.put(789,new Vendedor("Roberto@lopes","Roberto",789,"roberto123"));
        System.out.print("Qual seu e-cpf de  vendedor: ");
        int cpf = scanner.nextInt();
        if (vendedores.containsKey(cpf)) {
            System.out.println("Vendas do vendedor com cpf " + cpf + ":");
            for (Vendas venda : vendas) {
                if (!vendedores.containsValue(cpf)) {
                    System.out.println("Código: " + venda.getCodigo());
                    System.out.println("Produto: " + venda.getNomeProduto());
                    System.out.println("Preço: " + venda.getPreco());
                    System.out.println("Quantidade: " + venda.getQuantidade());
                    System.out.println("Valor Total: " + venda.getValorTotal());
                    System.out.println("-----------------------");
                }
            }
        } else {
            throw new IllegalArgumentException("Vendedor não encontrado!");
        }
    }
    public void listaPoduto(){
        produtos.add(new Produto(12,"Bolo de chocolate",5.75));
        produtos.add(new Produto(13,"Bolo de Ninho com nutela",8.99));
        produtos.add(new Produto(14,"Bolo de ninho com morango",8.50));
        produtos.add(new Produto(15,"Bolo de cenoura",5.0));

        System.out.println("=====Produtos disponiveis=====");
        for (Produto produto:produtos) {
            System.out.println("Codigo:"+produto.getCodigo()+"\nProduto:"+produto.getNomeProduto()+"\nPreço:"+produto.getPreco());
            System.out.println("------------------------------------------");
        }
    }
    public void listarVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda cadastrada.");
        } else {
            System.out.println("=====Lista de vendas=====");
            for (Vendas venda : vendas) {
                int cont=0;
                cont++;
                System.out.println("Venda "+cont);
                System.out.println("Código: " + venda.getCodigo());
                System.out.println("Produto: " + venda.getNomeProduto());
                System.out.println("Preço: " + venda.getPreco());
                System.out.println("Quantidade: " + venda.getQuantidade());
                System.out.println("Valor Total: " + venda.getValorTotal());
                System.out.println("Vendedor: " + venda.getVendedor().getNome());
                System.out.println("Cliente: " + venda.getCliente().getNome());
                System.out.println("Data: "+venda.getData());
                System.out.println("-----------------------");
            }
        }
    }
    public void listarVendedores() {
        vendedores.put(123,new Vendedor("Ana@nunes","Ana",123,"ana123"));
        vendedores.put(789,new Vendedor("Roberto@lopes","Roberto",789,"roberto123"));
        vendedores.put(456,new Vendedor("Luis@carlos","Luis",456,"luis123"));

        for (Vendedor vendedor : vendedores.values()) {
            String senhaCriptografada = passwordEncoder.encode(vendedor.getSenha());
            vendedor.setSenha(senhaCriptografada);
        }
        if (vendedores.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado.");
        } else {
            System.out.println("=====Lista de vendedores disponiveis=====:");
            int cont=0;
            for (Vendedor vendedor : vendedores.values()) {
                cont++;
                System.out.println("Vendedor "+cont);
                System.out.println("CPF: "+vendedor.getCpf());
                System.out.println("E-mail: " + vendedor.getEmail());
                System.out.println("Nome: " + vendedor.getNome());
                System.out.println("Senha: " + vendedor.getSenha());
                System.out.println("-----------------------");
            }
        }
    }
    public void listarClientes() {
        clientes.put(333,new Cliente("Ricardo@","Ricardo",333,"ricardo123"));
        clientes.put(111,new Cliente("Daniel@","Daniel",111,"danie123"));
        clientes.put(222,new Cliente("Rubia@","Rubia",222,"rubia123"));
        for (Cliente cliente : clientes.values()) {
            String senhaCriptografada = passwordEncoder.encode(cliente.getSenha());
            cliente.setSenha(senhaCriptografada);
        }

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("=====Lista de clientes=====");
            int cont=0;
            for (Cliente cliente : clientes.values()) {
                cont++;
                System.out.println("Cliente "+cont);
                System.out.println("CPF: "+cliente.getCpf());
                System.out.println("E-mail: " + cliente.getEmail());
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Senha: " + cliente.getSenha());
                System.out.println("-----------------------");
            }
        }
    }


}