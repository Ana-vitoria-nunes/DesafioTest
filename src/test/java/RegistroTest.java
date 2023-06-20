import org.example.desafio.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RegistroTest {
    @Spy
    private Registros registros;

    // Teste do metodo cadastrar vendedor
    @Test
    public void deveCadastraVendedorComSucesso(){
        //Criando cenario de teste
        String nome="Ana";
        String email="ana@nunes";
        String cpf="12345";
        //Realizando ação de teste
        registros.cadastrarVendedor(nome,email,cpf);
        //Comparando os resultados
        verify(registros).cadastrarVendedor(nome,email,cpf);
    }
    @Test
    public void deveLancarUmaExecaoQuandoONomeDoVendedorForInvalido(){
        //Criando cenario de teste
        String nome="an3a";
        String email="ana@nunes";
        String cpf="12345";
        //Realizando ação de teste
        //Comparando os resultados
      var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarVendedor(nome,email,cpf));
      assertEquals("Valor informado não é uma string, digite seu nome com uma String valida e sem espaço!",response.getMessage());
    }
    @Test
    public void deveLancarUmaExecaoQuandoOEmailDoVendedorForInvalido(){
        //Criando cenario de teste
        String nome="ana";
        String email="ananunes";
        String cpf="12345";
        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarVendedor(nome,email,cpf));
        assertEquals("O email precisa conter o @",response.getMessage());
    }
    @Test
    public void deveLancarUmaExecaoQuandoOEmailJaEstiverCadastradoParaOutroVendedor(){
        //Criando cenario de teste
        String nome="ana";
        String email="Ana@nunes";
        String cpf="12345";
        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarVendedor(nome,email,cpf));
        assertEquals("E-mail já cadastrados para outro vendedor!",response.getMessage());
    }
    @Test
    public void deveLancarUmaExecaoQuandoOCpfJaEstiverCadastradoParaOutroVendedor(){
        //Criando cenario de teste
        String nome="ana";
        String email="ana@nunes";
        String cpf="123";
        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarVendedor(nome,email,cpf));
        assertEquals("CPF já cadastrados para outro vendedor!",response.getMessage());
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    //Teste do metodo cadastrar cliente
    @Test
    public void deveCadastraClienteComSucesso(){
        //Criando cenario de teste
        String nome="Ana";
        String email="ana@nunes";
        String cpf="12345";
        //Realizando ação de teste
        registros.cadastrarCliente(nome,email,cpf);
        //Comparando os resultados
        verify(registros).cadastrarCliente(nome,email,cpf);
    }
    @Test
    public void deveLancarUmaExecaoQuandoONomeDoClienteForInvalido(){
        //Criando cenario de teste
        String nome="Ana3";
        String email="ana@nunes";
        String cpf="12345";
        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarCliente(nome,email,cpf));
        assertEquals("Valor informado não é uma string, digite seu nome com uma String valida e sem espaço!",response.getMessage());
    }
    @Test
    public void deveLancarUmaExecaoQuandoOEmailDoClienteForInvalido(){
        //Criando cenario de teste
        String nome="ana";
        String email="ananunes";
        String cpf="12345";
        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarCliente(nome,email,cpf));
        assertEquals("O email precisa conter o @",response.getMessage());
    }
    @Test
    public void deveLancarUmaExecaoQuandoOEmailJaEstiverCadastradoParaOutroCliente(){
        //Criando cenario de teste
        String nome="ana";
        String email="Ruboia@";
        String cpf="12345";
        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarCliente(nome,email,cpf));
        assertEquals("E-mail já cadastrados para outro cliente!",response.getMessage());
    }
    @Test
    public void deveLancarUmaExecaoQuandoOCpfJaEstiverCadastradoParaOutroCliente(){
        //Criando cenario de teste
        String nome="ana";
        String email="ana@nunes";
        String cpf="111";
        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarCliente(nome,email,cpf));
        assertEquals("CPF já cadastrados para outro Cliente!",response.getMessage());
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    //Teste do metodo cadastrar produto
    @Test
    public void deveCadastraProdutoComSucesso(){
        //Criando cenario de teste
        int cpfVendedor=123;
        int cpfCliente=111;
        int codigoProduto=12;
        int quantidadeProduto=5;
        //Realizando ação de teste
        registros.cadastrarProdutos(cpfVendedor,cpfCliente,codigoProduto,quantidadeProduto);
        //Comparando os resultados
        verify(registros).cadastrarProdutos(cpfVendedor,cpfCliente,codigoProduto,quantidadeProduto);
    }
    @Test
    public void deveLancarUmaExecaoQuandoOVendedorNaoForCadastrado(){
        int cpfVendedor=12309;
        int cpfCliente=111;
        int codigoProduto=12;
        int quantidadeProduto=5;

        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarProdutos(cpfVendedor,cpfCliente,codigoProduto,quantidadeProduto));
        assertEquals("Vendedor não cadastrado!",response.getMessage());
    }
    @Test
    public void deveLancarUmaExecaoQuandoOClienteNaoForCadastrado(){
        int cpfVendedor=123;
        int cpfCliente=11122;
        int codigoProduto=12;
        int quantidadeProduto=5;

        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarProdutos(cpfVendedor,cpfCliente,codigoProduto,quantidadeProduto));
        assertEquals("Cliente não cadastrado!",response.getMessage());
    }
    @Test
    public void deveLancarUmaExecaoQuandoOCodigoDoProdutoNaoEstiverCadastrado(){
        int cpfVendedor=123;
        int cpfCliente=111;
        int codigoProduto=20;
        int quantidadeProduto=5;

        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.cadastrarProdutos(cpfVendedor,cpfCliente,codigoProduto,quantidadeProduto));
        assertEquals("Codigo não encontrado",response.getMessage());
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    //pesquisarComprasPorCliente
    @Test
    public void deveRetornarAListaDeComprasSeOClienteForCadastrado(){
        //Criando cenario de teste
        int cpfCliente=111;
        //Realizando ação de teste
        registros.pesquisarComprasPorCliente(cpfCliente);
        //Comparando os resultados
        verify(registros).pesquisarComprasPorCliente(cpfCliente);
    }
    @Test
    public void deveLancarUmaExecaoQuandoOCpfDoClienteNaoForEncontrado(){

        int cpfCliente=11100;

        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.pesquisarComprasPorCliente(cpfCliente));
        assertEquals("Cliente não encontrado!",response.getMessage());
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    //pesquisarVendasPorVendedor
    @Test
    public void deveRetornarAsVendasDoVendedor(){
        //Criando cenario de teste
        int cpfVendedor=789;
        //Realizando ação de teste
        registros.pesquisarVendasPorVendedor(cpfVendedor);
        //Comparando os resultados
        verify(registros).pesquisarVendasPorVendedor(cpfVendedor);
    }
    @Test
    public void deveLancarUmaExecaoQuandoOCpfDoVendedorNãoForEncontrado(){

        int cpfVendedor=78901;

        //Realizando ação de teste
        //Comparando os resultados
        var response= Assertions.assertThrows(IllegalArgumentException.class,()-> registros.pesquisarVendasPorVendedor(cpfVendedor));
        assertEquals("Vendedor não encontrado!",response.getMessage());
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////

    //teste do metodo listar vendedor
    

}
