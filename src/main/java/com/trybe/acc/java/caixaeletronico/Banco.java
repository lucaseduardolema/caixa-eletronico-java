package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Random;

/**
 * .
 */
public class Banco {
  private ArrayList<PessoaCliente> pessoasClientes = new ArrayList<PessoaCliente>();
  private static ArrayList<Conta> contas = new ArrayList<Conta>();

  /**
   * .
   */
  public static String gerarNumeroNovaConta() {
    String numConta = "";

    while (numConta.length() < 10) {
      Random rnd = new Random();
      int num = rnd.nextInt(10);
      numConta += String.valueOf(num);
    }

    for (Conta conta : Banco.contas) {
      if (conta.getIdConta().equals(numConta)) {
        numConta = Banco.gerarNumeroNovaConta();
      }
    }

    return numConta;
  }

  /**
   * .
   */
  public PessoaCliente adicionarPessoaCliente(String nome, String cpf, String senha) {
    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
    pessoasClientes.add(pessoaCliente);
    return pessoaCliente;
  }

  /**
   * .
   */
  public void adicionarConta(String tipoConta, PessoaCliente cliente) {
    Conta conta = new Conta(tipoConta, cliente);
    Banco.contas.add(conta);
    cliente.adicionarConta(conta);
  }

  /**
   * .
   */
  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    PessoaCliente response = null;

    for (PessoaCliente cliente : this.pessoasClientes) {
      if (cliente.getCpf().equals(cpf) && cliente.validarSenha(senha)) {
        response = cliente;
      }
    }
    return response;
  }

  /**
   * .
   */
  public void transferirFundos(PessoaCliente pessoaCliente, int daConta, int paraConta,
      double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, (quantia * -1),
        "Transferencia de " + quantia + " para conta " + paraConta);

    pessoaCliente.adicionarTransacaoContaEspecifica(paraConta, quantia,
        "Entrada de " + quantia + " da conta " + daConta);
  }

  public void sacar(PessoaCliente pessoaCliente, int daConta, double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, (quantia * -1), "Saque de " + quantia);
  }

  public void depositar(PessoaCliente pessoaCliente, int paraConta, double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(paraConta, quantia, "Deposito de " + quantia);
  }

  public void mostrarExtrato(PessoaCliente pessoaCliente, int conta) {
    pessoaCliente.retornarExtratoContaEspecifica(conta);
  }
}
