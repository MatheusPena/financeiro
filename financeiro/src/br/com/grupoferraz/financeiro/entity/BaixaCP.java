package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class BaixaCP implements Serializable {

	private int codigo;
	private String cpf;
	private String numerodoc;
	private Date emissaocp;
	private Date vencimentocp;
	private String numerotitulo;
	private String vencimentovalor;
	private Date baixavencimentocp;
	private String valorbaixavencimento;
	private String valordescontobaixa;
	private String valorjurusbaixa;
	private String contafinanceira;
	private String estfinanceira;
	private String historico;
	
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNumerodoc() {
		return numerodoc;
	}


	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}


	public Date getEmissaocp() {
		return emissaocp;
	}


	public void setEmissaocp(Date emissaocp) {
		this.emissaocp = emissaocp;
	}


	public Date getVencimentocp() {
		return vencimentocp;
	}


	public void setVencimentocp(Date vencimentocp) {
		this.vencimentocp = vencimentocp;
	}


	public String getNumerotitulo() {
		return numerotitulo;
	}


	public void setNumerotitulo(String numerotitulo) {
		this.numerotitulo = numerotitulo;
	}


	public String getVencimentovalor() {
		return vencimentovalor;
	}


	public void setVencimentovalor(String vencimentovalor) {
		this.vencimentovalor = vencimentovalor;
	}


	


	public String getValorbaixavencimento() {
		return valorbaixavencimento;
	}


	public void setValorbaixavencimento(String valorbaixavencimento) {
		this.valorbaixavencimento = valorbaixavencimento;
	}


	public Date getBaixavencimentocp() {
		return baixavencimentocp;
	}


	public void setBaixavencimentocp(Date baixavencimentocp) {
		this.baixavencimentocp = baixavencimentocp;
	}


	public String getValordescontobaixa() {
		return valordescontobaixa;
	}


	public void setValordescontobaixa(String valordescontobaixa) {
		this.valordescontobaixa = valordescontobaixa;
	}


	public String getValorjurusbaixa() {
		return valorjurusbaixa;
	}


	public void setValorjurusbaixa(String valorjurusbaixa) {
		this.valorjurusbaixa = valorjurusbaixa;
	}


	public String getContafinanceira() {
		return contafinanceira;
	}


	public void setContafinanceira(String contafinanceira) {
		this.contafinanceira = contafinanceira;
	}


	public String getEstfinanceira() {
		return estfinanceira;
	}


	public void setEstfinanceira(String estfinanceira) {
		this.estfinanceira = estfinanceira;
	}


	public String getHistorico() {
		return historico;
	}


	public void setHistorico(String historico) {
		this.historico = historico;
	}


	@Override
	public String toString() {
		return String.valueOf(codigo);
	}
}