package br.com.grupoferraz.financeiro.entity;

import java.util.Date;

public class VencimentoDiversosCR {
	private int codigo;
	private Date vencimento;
	private float valor;
	private int titulo;
	private int boleto;
	private float desconto;
	private String empresas_cnpj;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
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

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public String getEmpresas_cnpj() {
		return empresas_cnpj;
	}

	public void setEmpresas_cnpj(String empresas_cnpj) {
		this.empresas_cnpj = empresas_cnpj;
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
