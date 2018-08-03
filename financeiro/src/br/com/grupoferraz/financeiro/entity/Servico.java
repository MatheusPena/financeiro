package br.com.grupoferraz.financeiro.entity;

import java.math.BigDecimal;

public class Servico {
	private int codigo;
	private String nome;
	private int modalidade_codigo;
	private BigDecimal valor;
	private int quantidade;
	private Integer gruposervico_codigo;
	private GrupoServico gruposervico;
	private Modalidade modalidade;

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

	public int getModalidade_codigo() {
		return modalidade_codigo;
	}

	public void setModalidade_codigo(int modalidade_codigo) {
		this.modalidade_codigo = modalidade_codigo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getGruposervico_codigo() {
		return gruposervico_codigo;
	}

	public void setGruposervico_codigo(Integer gruposervico_codigo) {
		this.gruposervico_codigo = gruposervico_codigo;
	}

	public GrupoServico getGruposervico() {
		return gruposervico;
	}

	public void setGruposervico(GrupoServico gruposervico) {
		this.gruposervico = gruposervico;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

}
