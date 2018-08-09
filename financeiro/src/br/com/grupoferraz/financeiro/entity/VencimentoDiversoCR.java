package br.com.grupoferraz.financeiro.entity;

import java.math.BigDecimal;
import java.util.Date;

public class VencimentoDiversoCR {
	private int codigo;
	private Date vencimento;
	private BigDecimal valor;
	private int titulo;
	private int boleto;
	private BigDecimal desconto;
	private String empresa_cnpj;
	private int documento_codigo;
	private Empresa empresa;
	private Documento documento;

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

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public int getTitulo() {
		return titulo;
	}

	public void setTitulo(int titulo) {
		this.titulo = titulo;
	}

	public int getBoleto() {
		return boleto;
	}

	public void setBoleto(int boleto) {
		this.boleto = boleto;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public String getEmpresa_cnpj() {
		return empresa_cnpj;
	}

	public void setEmpresa_cnpj(String empresa_cnpj) {
		this.empresa_cnpj = empresa_cnpj;
	}

	public int getDocumento_codigo() {
		return documento_codigo;
	}

	public void setDocumento_codigo(int documento_codigo) {
		this.documento_codigo = documento_codigo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

}
