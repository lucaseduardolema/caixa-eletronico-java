package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    assertTrue(Banco.gerarNumeroNovaConta().length() == 10);
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    Banco banco = new Banco();
    assertTrue(banco.adicionarPessoaCliente("teste", "12345678987",
        "senhaForte") instanceof PessoaCliente);
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Banco banco = new Banco();
    banco.adicionarPessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");
    assertTrue(banco.pessoaClienteLogin("433.892.200-11", "senha invalida") == null);
    assertTrue(banco.pessoaClienteLogin("433.892.200-11", "1234") instanceof PessoaCliente);
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente cliente =
        banco.adicionarPessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");
    banco.adicionarConta("Poupança", cliente);
    banco.adicionarConta("Corrente", cliente);
    banco.depositar(cliente, 0, 2000);

    assertTrue(cliente.retornarSaldoContaEspecifica(0) == 2000);

    banco.transferirFundos(cliente, 0, 1, 1000);

    assertTrue(cliente.retornarSaldoContaEspecifica(0) == 1000);
    assertTrue(cliente.retornarSaldoContaEspecifica(1) == 1000);
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente cliente =
        banco.adicionarPessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");
    banco.adicionarConta("Poupança", cliente);
    banco.depositar(cliente, 0, 2000);

    assertTrue(cliente.retornarSaldoContaEspecifica(0) == 2000);

    banco.sacar(cliente, 0, 1000);

    assertTrue(cliente.retornarSaldoContaEspecifica(0) == 1000);
  }
}
