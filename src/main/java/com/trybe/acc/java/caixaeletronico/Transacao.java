package com.trybe.acc.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * .
 */
public class Transacao {
  private double quantia;
  private String instante;
  private String descricao;
  private Conta conta;

  /**
   * .
   */
  public Transacao(double quantia, String descricao) {
    this.quantia = quantia;
    this.descricao = descricao;
    this.instante = this.retornarInstante();
  }

  public double getQuantia() {
    return this.quantia;
  }

  public String retornarResumoTransacao() {
    return this.descricao + ", valor total da operação: " + this.quantia + ", momento da operação: "
        + this.instante;
  }

  /**
   * .
   */
  public String retornarInstante() {
    LocalDateTime dateTime = LocalDateTime.now();
    final String datePattern = "dd/MM/yyyy HH:mm:ss";
    return DateTimeFormatter.ofPattern(datePattern).format(dateTime);
  }

  @Override
  public String toString() {
    return String.format("Descrição: %s, Instante: %s", this.descricao, this.instante);
  }
}

