package br.com.grupoferraz.financeiro.entity;

import java.util.Date;

public class Adiantamento {
	private int codigo;
	private Date data;
	private int estabelecimentos_codigo;
	private String fornecedores_cpf;
	private int contasfinanceiras_codigo;
	private int centroresultados_codigo;
	private int despesas_codigo;
	private float valor;
	private Integer historicopadrao_codigo;
	private String observacao;
	private ContasFinanceiras contafinanceira;
	private Estabelecimento estabelecimento;
	private CentroResultados centroresultado;
	private Despesa despesa;
	private Historico historico;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getEstabelecimentos_codigo() {
		return estabelecimentos_codigo;
	}

	public void setEstabelecimentos_codigo(int estabelecimentos_codigo) {
		this.estabelecimentos_codigo = estabelecimentos_codigo;
	}

	public String getFornecedores_cpf() {
		return fornecedores_cpf;
	}

	public void setFornecedores_cpf(String fornecedores_cpf) {
		this.fornecedores_cpf = fornecedores_cpf;
	}

	public int getContasfinanceiras_codigo() {
		return contasfinanceiras_codigo;
	}

	public void setContasfinanceiras_codigo(int contasfinanceiras_codigo) {
		this.contasfinanceiras_codigo = contasfinanceiras_codigo;
	}

	public int getCentroresultados_codigo() {
		return centroresultados_codigo;
	}

	public void setCentroresultados_codigo(int centroresultados_codigo) {
		this.centroresultados_codigo = centroresultados_codigo;
	}

	public int getDespesas_codigo() {
		return despesas_codigo;
	}

	public void setDespesas_codigo(int despesas_codigo) {
		this.despesas_codigo = despesas_codigo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Integer getHistoricopadrao_codigo() {
		return historicopadrao_codigo;
	}

	public void setHistoricopadrao_codigo(Integer historicopadrao_codigo) {
		this.historicopadrao_codigo = historicopadrao_codigo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ContasFinanceiras getContafinanceira() {
		return contafinanceira;
	}

	public void setContafinanceira(ContasFinanceiras contafinanceira) {
		this.contafinanceira = contafinanceira;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public CentroResultados getCentroresultado() {
		return centroresultado;
	}

	public void setCentroresultado(CentroResultados centroresultado) {
		this.centroresultado = centroresultado;
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

}
