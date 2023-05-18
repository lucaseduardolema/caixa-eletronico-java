package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes dos métodos da classe Transacao")
class TransacaoTest {


  @Test
  @DisplayName("21 - Testa o método construtor da classe Transacao.")
  void construtorTest() {
    Transacao trasacao = new Transacao(1000, "test");

    assertTrue(trasacao.toString().contains("Descrição: test, Instante:"));
  }


  @Test
  @DisplayName("22 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    Transacao trasacao = new Transacao(1000, "test");

    assertEquals(1000, trasacao.getQuantia());
  }

  @Test
  @DisplayName("23 - Testa o método retornar resumo transacao.")
  void retornarResumoTransacaoTest() {
    Transacao trasacao = new Transacao(1000, "test");

    assertTrue(
        trasacao.retornarResumoTransacao().contains("test, valor total da operação: 1000.0"));
  }

  @Test
  @DisplayName("24 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    Transacao trasacao = new Transacao(1000, "test");

    LocalDateTime dateTime = LocalDateTime.now();
    final String datePattern = "dd/MM/yyyy HH:mm:ss";
    String formater = DateTimeFormatter.ofPattern(datePattern).format(dateTime);

    assertEquals(formater, trasacao.retornarInstante());
  }
}
