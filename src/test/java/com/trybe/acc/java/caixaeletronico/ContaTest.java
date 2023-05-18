package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste da classe Conta")
class ContaTest {

  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");
    Conta conta = new Conta("Corrente", cliente);
    assertTrue(conta.getIdConta().length() == 10);
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");
    Conta conta = new Conta("Corrente", cliente);
    conta.adicionarTransacao(100, "teste");

    assertTrue(conta.retornarSaldo() == 100);
  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");
    Conta conta = new Conta("Corrente", cliente);
    conta.adicionarTransacao(100, "teste");

    assertTrue(conta.retornarResumoConta().contains("Saldo: 100.0"));
  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");
    Conta conta = new Conta("Corrente", cliente);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    conta.retornarExtrato();

    String[] linha = baos.toString().split(System.lineSeparator());
    String saida = linha[linha.length - 1];

    assertEquals("Nenhuma transação", saida);

    conta.adicionarTransacao(1000, "test");

    baos = new ByteArrayOutputStream();
    printStream = new PrintStream(baos);
    System.setOut(printStream);

    conta.retornarExtrato();

    linha = baos.toString().split(System.lineSeparator());
    saida = linha[linha.length - 1];

    assertTrue(saida.contains("valor total da operação: 1000.0"));
  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");
    Conta conta = new Conta("Corrente", cliente);

    assertTrue(conta.getIdConta().length() == 10);
  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    PessoaCliente cliente = new PessoaCliente("Nome Cliente", "123.456.789-43", "Senha Forte");
    Conta conta = new Conta("Corrente", cliente);

    assertTrue(conta.getPessoaCliente() instanceof PessoaCliente);
  }

}
