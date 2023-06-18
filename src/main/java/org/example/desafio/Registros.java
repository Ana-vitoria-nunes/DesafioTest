package org.example.desafio;

import java.time.LocalDate;
import java.util.*;

public class Registros {
    private List<Vendas> vendas;
    private List<Produto>produtos;
    private Map<Integer, Vendedor> vendedores;
    private Map<Integer, Cliente> clientes;


    Scanner scanner = new Scanner(System.in);
    public Registros() {
        vendas = new ArrayList<>();
        vendedores = new HashMap<>();
        clientes = new HashMap<>();
        produtos=new ArrayList<>();
    }
    public void cadastrarVendedor(String nome,String email,String cpf) {
        vendedores.put(123, new Vendedor("Ana@nunes", "Ana", 123));
        vendedores.put(789, new Vendedor("Roberto@lopes", "Roberto", 789));
        vendedores.put(456, new Vendedor("Luis@carlos", "Luis", 456));

        // try {
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
            vendedores.put(numero, new Vendedor(email, nome, numero));
            System.out.println("Vendedor cadastrado com sucesso!");
        }
//        }catch (IllegalArgumentException e){
//            System.out.println("Erro; "+e.getMessage());
//        }
//    }
    }
    public void cadastrarCliente(String nomeC,String emailC,String cpfC) {
        clientes.put(333,new Cliente("Ricardo@","Ricardo",333));
        clientes.put(111,new Cliente("Daniel@","Daniel",111));
        clientes.put(222,new Cliente("Ruboia@","Rubia",222));

      //  try {
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
                clientes.put(numero, new Cliente(emailC, nomeC,numero));
                System.out.println("Cliente cadastrado com sucesso!");
            }

//        }catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//        }
    }
    public void cadastrarProdutos(int cpfPV, int cpfPC,int codigo,int quantidade) {
        clientes.put(333,new Cliente("Ricardo@","Ricardo",333));
        clientes.put(111,new Cliente("Daniel@","Daniel",111));
        clientes.put(222,new Cliente("Ruboia@","Rubia",222));

        vendedores.put(123,new Vendedor("Ana@nunes","Ana",123));

        produtos.add(new Produto(12,"Bolo de chocolate",5.75));

       // try {
            System.out.println();
            if (!vendedores.containsKey(cpfPV)) {
                throw new IllegalArgumentException("Vendedor não cadastrado!");
            }

            System.out.println();
            if (!clientes.containsKey(cpfPC)) {
                throw new IllegalArgumentException("Cliente não cadastrado!");
            }

            Produto produto=new Produto(0,"",0);
            for (int i=0;i<produtos.size();i++) {
                if (produtos.get(i).getCodigo() == codigo) {
                    System.out.println();
                    produto = produtos.get(i);
                }
            }
            if (produto.getNomeProduto().isEmpty()){
                throw new IllegalArgumentException("Codigo não encontrado");
            }

            System.out.println();
            LocalDate data = LocalDate.now();
            Vendedor vendedor = vendedores.get(cpfPV);
            Cliente cliente = clientes.get(cpfPC);
            vendas.add(new Vendas(vendedor, cliente, codigo, produto.getNomeProduto(),produto.getPreco(),quantidade, data));
            System.out.println("Produto cadastrado com sucesso");
//        }
//        catch (IllegalArgumentException e){
//            System.out.println(e.getMessage());
//        }

    }
   public void pesquisarComprasPorCliente(int cpfCliente) {
       clientes.put(111,new Cliente("Daniel@","Daniel",111));

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
            throw  new IllegalArgumentException("Cliente não encontrado!");
        }
    }
    public void pesquisarVendasPorVendedor(int cpf) {

        System.out.println();
        vendedores.put(789,new Vendedor("Roberto@lopes","Roberto",789));
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
        vendedores.put(123,new Vendedor("Ana@nunes","Ana",123));
        vendedores.put(789,new Vendedor("Roberto@lopes","Roberto",789));
        vendedores.put(456,new Vendedor("Luis@carlos","Luis",456));


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
                System.out.println("-----------------------");
            }
        }
    }
    public void listarClientes() {
        clientes.put(333,new Cliente("Ricardo@","Ricardo",333));
        clientes.put(111,new Cliente("Daniel@","Daniel",111));
        clientes.put(222,new Cliente("Ruboia@","Rubia",222));

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
                System.out.println("-----------------------");
            }
        }
    }


}