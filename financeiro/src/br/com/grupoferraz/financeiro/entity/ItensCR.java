package br.com.grupoferraz.financeiro.entity;

import java.math.BigDecimal;

public class ItensCR {
	private int codigo;
	private int quantidade;
	private float valor;
	private int cfop;
	private int tributoa;
	private int tributob;
	private BigDecimal icms;
	private BigDecimal ipi;
	private String unidade;
	private BigDecimal icmssubstituto;
	private BigDecimal calculoicms;
	private BigDecimal valoricms;
	private String descricao;
	private int tributosimples;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getCfop() {
		return cfop;
	}

	public void setCfop(int cfop) {
		this.cfop = cfop;
	}

	public int getTributoa() {
		return tributoa;
	}

	public void setTributoa(int tributoa) {
		this.tributoa = tributoa;
	}

	public int getTributob() {
		return tributob;
	}

	public void setTributob(int tributob) {
		this.tributob = tributob;
	}

	public BigDecimal getIcms() {
		return icms;
	}

	public void setIcms(BigDecimal icms) {
		this.icms = icms;
	}

	public BigDecimal getIpi() {
		return ipi;
	}

	public void setIpi(BigDecimal ipi) {
		this.ipi = ipi;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getIcmssubstituto() {
		return icmssubstituto;
	}

	public void setIcmssubstituto(BigDecimal icmssubstituto) {
		this.icmssubstituto = icmssubstituto;
	}

	public BigDecimal getCalculoicms() {
		return calculoicms;
	}

	public void setCalculoicms(BigDecimal calculoicms) {
		this.calculoicms = calculoicms;
	}

	public BigDecimal getValoricms() {
		return valoricms;
	}

	public void setValoricms(BigDecimal valoricms) {
		this.valoricms = valoricms;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTributosimples() {
		return tributosimples;
	}

	public void setTributosimples(int tributosimples) {
		this.tributosimples = tributosimples;
	}

}
