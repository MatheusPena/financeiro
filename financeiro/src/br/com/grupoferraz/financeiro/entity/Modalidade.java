package br.com.grupoferraz.financeiro.entity;

import java.math.BigDecimal;

public class Modalidade {

	private int codigo;
	private String nome;
	private String fatura;
	private BigDecimal iss;
	private BigDecimal irpf;
	private BigDecimal pis;
	private BigDecimal inss;
	private String atividade;
	private Integer grupomodalidade_codigo;
	private GrupoModalidade grupomodalidade;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFatura() {
		return fatura;
	}

	public void setFatura(String fatura) {
		this.fatura = fatura;
	}

	public BigDecimal getIss() {
		return iss;
	}

	public void setIss(BigDecimal iss) {
		this.iss = iss;
	}

	public BigDecimal getIrpf() {
		return irpf;
	}

	public void setIrpf(BigDecimal irpf) {
		this.irpf = irpf;
	}

	public BigDecimal getPis() {
		return pis;
	}

	public void setPis(BigDecimal pis) {
		this.pis = pis;
	}

	public BigDecimal getInss() {
		return inss;
	}

	public void setInss(BigDecimal inss) {
		this.inss = inss;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public Integer getGrupomodalidade_codigo() {
		return grupomodalidade_codigo;
	}

	public void setGrupomodalidade_codigo(Integer grupomodalidade_codigo) {
		this.grupomodalidade_codigo = grupomodalidade_codigo;
	}

	public GrupoModalidade getGrupomodalidade() {
		return grupomodalidade;
	}

	public void setGrupomodalidade(GrupoModalidade grupomodalidade) {
		this.grupomodalidade = grupomodalidade;
	}

	@Override
	public String toString() {

		return nome;
	}

}
