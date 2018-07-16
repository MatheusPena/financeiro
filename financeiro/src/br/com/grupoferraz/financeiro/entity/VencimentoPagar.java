package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class VencimentoPagar implements Serializable {
	private int vencimento_codigo;
	private Date vencimento;
	private String titulo;
	private String valor;
	private String desconto;
	private String codigoag;
	private String nomeag;
	private String lancamento;
	private String banco;
	private String agenciabanco;
	private String digagencia;
	private String conta;
	private String digconta;
	private Date agendar;

	
	
	public VencimentoPagar() {
		
	}

	


	public int getVencimento_codigo() {
		return vencimento_codigo;
	}




	public void setVencimento_codigo(int vencimento_codigo) {
		this.vencimento_codigo = vencimento_codigo;
	}




	public Date getVencimento() {
		return vencimento;
	}




	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}




	public String getValor() {
		return valor;
	}




	public void setValor(String valor) {
		this.valor = valor;
	}




	public String getDesconto() {
		return desconto;
	}




	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}




	



	public String getCodigoag() {
		return codigoag;
	}




	public void setCodigoag(String codigoag) {
		this.codigoag = codigoag;
	}




	public String getNomeag() {
		return nomeag;
	}




	public void setNomeag(String nomeag) {
		this.nomeag = nomeag;
	}




	public String getLancamento() {
		return lancamento;
	}




	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}




	public String getBanco() {
		return banco;
	}




	public void setBanco(String banco) {
		this.banco = banco;
	}




	public String getAgenciabanco() {
		return agenciabanco;
	}




	public void setAgenciabanco(String agenciabanco) {
		this.agenciabanco = agenciabanco;
	}




	public String getDigagencia() {
		return digagencia;
	}




	public void setDigagencia(String digagencia) {
		this.digagencia = digagencia;
	}




	public String getConta() {
		return conta;
	}




	public void setConta(String conta) {
		this.conta = conta;
	}




	public String getDigconta() {
		return digconta;
	}




	public Date getAgendar() {
		return agendar;
	}




	public void setAgendar(Date agendar) {
		this.agendar = agendar;
	}




	public void setDigconta(String digconta) {
		this.digconta = digconta;
	}

}