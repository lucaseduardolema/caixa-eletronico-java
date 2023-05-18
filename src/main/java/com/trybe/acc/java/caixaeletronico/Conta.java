package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

/**
 * .
 */
public class Conta {
  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private ArrayList<Transacao> trasacoes;

  /**
   * .
   */
  public Conta(String tipoConta, PessoaCliente pessoaCliente) {
    this.idConta = Banco.gerarNumeroNovaConta();
    this.pessoaCliente = pessoaCliente;
    this.tipoConta = tipoConta;
    this.trasacoes = new ArrayList<Transacao>();
  }

  public void adicionarTransacao(double quantia, String descricao) {
    Transacao novaTransacao = new Transacao(quantia, descricao);
    trasacoes.add(novaTransacao);
  }

  /**
   * .
   */
  public double retornarSaldo() {
    double response = 0;

    for (Transacao transacao : this.trasacoes) {
      response += transacao.getQuantia();
    }

    return response;
  }

  public String retornarResumoConta() {
    return "ID: " + this.idConta + " Tipo: " + this.tipoConta + " Saldo: " + this.retornarSaldo();
  }

  /**
   * .
   */
  public void retornarExtrato() {
    if (this.trasacoes.size() == 0) {
      System.out.println("Nenhuma transação");
      return;
    }

    this.trasacoes.forEach(transacao -> {
      System.out.println(transacao.retornarResumoTransacao() + "\n");
    });
  }

  public String getIdConta() {
    return this.idConta;
  }

  public PessoaCliente getPessoaCliente() {
    return this.pessoaCliente;
  }
}
