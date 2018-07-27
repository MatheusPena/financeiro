package br.com.grupoferraz.financeiro.entity;

import java.math.BigDecimal;

public class RateioCR {
	private int codigo;
	private String receita;
	private int estabelecimento_codigo;
	private int centro_resultados;
	private BigDecimal percentual;
	private String empresa_cnpj;
	private Empresa empresa;
	private PlanoContas planocontas;
	private Estabelecimento estabelecimento;
	private CentroResultado centroresultados;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getReceita() {
		return receita;
	}

	public void setReceita(String receita) {
		this.receita = receita;
	}

	public int getEstabelecimento_codigo() {
		return estabelecimento_codigo;
	}

	public void setEstabelecimento_codigo(int estabelecimento_codigo) {
		this.estabelecimento_codigo = estabelecimento_codigo;
	}

	public int getCentro_resultados() {
		return centro_resultados;
	}

	public void setCentro_resultados(int centro_resultados) {
		this.centro_resultados = centro_resultados;
	}

	public BigDecimal getPercentual() {
		return percentual;
	}

	public void setPercentual(BigDecimal percentual) {
		this.percentual = percentual;
	}

	public String getEmpresa_cnpj() {
		return empresa_cnpj;
	}

	public void setEmpresa_cnpj(String empresa_cnpj) {
		this.empresa_cnpj = empresa_cnpj;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public PlanoContas getPlanocontas() {
		return planocontas;
	}

	public void setPlanocontas(PlanoContas planocontas) {
		this.planocontas = planocontas;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public CentroResultado getCentroresultados() {
		return centroresultados;
	}

	public void setCentroresultados(CentroResultado centroresultados) {
		this.centroresultados = centroresultados;
	}

}
