package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

/**
 * .
 */
public class PessoaCliente {
  private String nomeCompleto;
  private String senha;
  private String cpf;
  private ArrayList<Conta> contas;

  /**
   * .
   */
  public PessoaCliente(String nome, String cpf, String senha) {
    // TODO Auto-generated constructor stub
    this.nomeCompleto = nome;
    this.cpf = cpf;
    this.senha = senha;
    this.contas = new ArrayList<Conta>();
    // System.out.println("Nova pessoa cliente " + nome + " com CPF: " + cpf + " criada!");
  }

  public void adicionarConta(Conta conta) {
    this.contas.add(conta);
  }

  public int retornaNumeroDeContas() {
    return this.contas.size();
  }

  public double retornarSaldoContaEspecifica(int indice) {
    Conta conta = this.contas.get(indice);
    return conta.retornarSaldo();
  }

  public String retornarIdContaEspecifica(int indice) {
    Conta conta = this.contas.get(indice);
    return conta.getIdConta();
  }

  public void retornarExtratoContaEspecifica(int indice) {
    Conta conta = this.contas.get(indice);
    conta.retornarExtrato();
  }

  public void adicionarTransacaoContaEspecifica(int indice, double quantia, String descricao) {
    Conta conta = this.contas.get(indice);
    conta.adicionarTransacao(quantia, descricao);
  }

  public boolean validarSenha(String senha) {
    return this.senha.equals(senha);
  }

  /**
   * .
   */
  public void retornarResumoContas() {
    this.contas.forEach(conta -> {
      System.out.println(conta.retornarResumoConta() + "\n");
    });
  }

  public String getCpf() {
    return cpf;
  }

  @Override
  public String toString() {
    return String.format("Cliente: %s, Cpf: %s", this.nomeCompleto, this.cpf);
  }
}
