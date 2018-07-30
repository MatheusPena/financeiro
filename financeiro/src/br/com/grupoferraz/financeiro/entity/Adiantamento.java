package br.com.grupoferraz.financeiro.entity;

import java.util.Date;

public class Adiantamento {
	private int codigo;
	private Date data;
	private int estabelecimento_codigo;
	private String fornecedorcpf;
	private int contafinanceira_codigo;
	private int centroresultado_codigo;
	private int despesa_codigo;
	private float valor;
	private Integer historicopadrao_codigo;
	private String observacao;
	private ContasFinanceiras contafinanceira;
	private Estabelecimento estabelecimento;
	private CentroResultado centroresultado;
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


	public int getEstabelecimento_codigo() {
		return estabelecimento_codigo;
	}

	public void setEstabelecimento_codigo(int estabelecimento_codigo) {
		this.estabelecimento_codigo = estabelecimento_codigo;
	}

	public String getFornecedorcpf() {
		return fornecedorcpf;
	}

	public void setFornecedorcpf(String fornecedorcpf) {
		this.fornecedorcpf = fornecedorcpf;
	}

	public int getContafinanceira_codigo() {
		return contafinanceira_codigo;
	}

	public void setContafinanceira_codigo(int contafinanceira_codigo) {
		this.contafinanceira_codigo = contafinanceira_codigo;
	}

	public int getCentroresultado_codigo() {
		return centroresultado_codigo;
	}

	public void setCentroresultado_codigo(int centroresultado_codigo) {
		this.centroresultado_codigo = centroresultado_codigo;
	}

	public int getDespesa_codigo() {
		return despesa_codigo;
	}

	public void setDespesa_codigo(int despesa_codigo) {
		this.despesa_codigo = despesa_codigo;
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

	public CentroResultado getCentroresultado() {
		return centroresultado;
	}

	public void setCentroresultado(CentroResultado centroresultado) {
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
