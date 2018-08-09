package br.com.grupoferraz.financeiro.entity;

import java.math.BigDecimal;
import java.util.Date;

public class VencimentoChequeCR {
	private int codigo;
	private Date vencimento;
	private BigDecimal valor;
	private String banco;
	private String tipoconta;
	private int agencia;
	private int digagencia;
	private int conta;
	private int digconta;
	private int cheque;
	private String titular;
	private int febraban;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getTipoconta() {
		return tipoconta;
	}

	public void setTipoconta(String tipoconta) {
		this.tipoconta = tipoconta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getDigagencia() {
		return digagencia;
	}

	public void setDigagencia(int digagencia) {
		this.digagencia = digagencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getDigconta() {
		return digconta;
	}

	public void setDigconta(int digconta) {
		this.digconta = digconta;
	}

	public int getCheque() {
		return cheque;
	}

	public void setCheque(int cheque) {
		this.cheque = cheque;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getFebraban() {
		return febraban;
	}

	public void setFebraban(int febraban) {
		this.febraban = febraban;
	}

}
