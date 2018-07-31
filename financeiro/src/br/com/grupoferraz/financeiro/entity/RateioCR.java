package br.com.grupoferraz.financeiro.entity;

import java.math.BigDecimal;

public class RateioCR {
	private int codigo;
	private String planoconta_codigo;
	private int estabelecimento_codigo;
	private int centroresultado_codigo;
	private BigDecimal percentual;
	private String empresa_cnpj;
	private Empresa empresa;
	private PlanoConta planoconta;
	private Estabelecimento estabelecimento;
	private CentroResultado centroresultado;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPlanoconta_codigo() {
		return planoconta_codigo;
	}

	public void setPlanoconta_codigo(String planoconta_codigo) {
		this.planoconta_codigo = planoconta_codigo;
	}

	public int getEstabelecimento_codigo() {
		return estabelecimento_codigo;
	}

	public void setEstabelecimento_codigo(int estabelecimento_codigo) {
		this.estabelecimento_codigo = estabelecimento_codigo;
	}

	public int getCentroresultado_codigo() {
		return centroresultado_codigo;
	}

	public void setCentroresultado_codigo(int centroresultado_codigo) {
		this.centroresultado_codigo = centroresultado_codigo;
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

	public PlanoConta getPlanoconta() {
		return planoconta;
	}

	public void setPlanoconta(PlanoConta planoconta) {
		this.planoconta = planoconta;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public CentroResultado getCentroresultado() {
		return centroresultado;
	}

	public void setCentroresultado(CentroResultado centroresultado) {
		this.centroresultado = centroresultado;
	}

}
