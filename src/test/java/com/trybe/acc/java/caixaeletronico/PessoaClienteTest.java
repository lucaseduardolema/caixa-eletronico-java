package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {

  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");

    assertEquals("Cliente: Nome Cliente, Cpf: 123.456.789-43", cliente.toString());
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");

    assertEquals(0, cliente.retornaNumeroDeContas());

    Conta conta = new Conta("Corrente", cliente);
    cliente.adicionarConta(conta);

    assertEquals(1, cliente.retornaNumeroDeContas());
  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");
    Conta conta = new Conta("Corrente", cliente);
    cliente.adicionarConta(conta);

    assertEquals(0.0, cliente.retornarSaldoContaEspecifica(0));
  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");
    Conta conta = new Conta("Corrente", cliente);
    cliente.adicionarConta(conta);

    assertTrue(cliente.retornarIdContaEspecifica(0).length() == 10);
  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");
    Conta conta = new Conta("Corrente", cliente);
    cliente.adicionarConta(conta);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    cliente.retornarExtratoContaEspecifica(0);

    String[] linha = baos.toString().split(System.lineSeparator());
    String saida = linha[linha.length - 1];

    assertEquals("Nenhuma transação", saida);
  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");
    Conta conta = new Conta("Corrente", cliente);
    cliente.adicionarConta(conta);

    cliente.adicionarTransacaoContaEspecifica(0, 1000, "test");

    assertEquals(1000.0, cliente.retornarSaldoContaEspecifica(0));
  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");

    assertFalse(cliente.validarSenha("senha errada"));

    assertTrue(cliente.validarSenha("Senha Forte"));
  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");
    Conta conta = new Conta("Corrente", cliente);
    cliente.adicionarConta(conta);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    cliente.retornarResumoContas();

    String[] linha = baos.toString().split(System.lineSeparator());
    String saida = linha[linha.length - 1];

    assertTrue(saida.contains("Tipo: Corrente"));
  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");

    assertEquals("123.456.789-43", cliente.getCpf());
  }

}
