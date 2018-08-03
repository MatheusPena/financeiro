package br.com.grupoferraz.financeiro.entity;

import java.util.Date;

public class Adiantamento {
	private int codigo;
	private Date data;
	private int estabelecimento_codigo;
	private Empresa empresa;
	private String empresa_cnpj;
	private String estabelecimento_nome;
	private String despesa_nome;
	private String fornecedorcpf;
	private int contafinanceira_codigo;
	private int centroresultado_codigo;
	private int despesa_codigo;
	private float valor;
	private Integer historicopadrao_codigo;
	private String observacao;
	private ContaFinanceira contafinanceira;
	private Estabelecimento estabelecimento;
	private CentroResultado centroresultado;
	private DespesaReceita despesa;
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

	public String getEmpresa_cnpj() {
		return empresa_cnpj;
	}

	public void setEmpresa_cnpj(String empresa_cnpj) {
		this.empresa_cnpj = empresa_cnpj;
	}

	public String getEstabelecimento_nome() {
		return estabelecimento_nome;
	}

	public void setEstabelecimento_nome(String estabelecimento_nome) {
		this.estabelecimento_nome = estabelecimento_nome;
	}

	public String getDespesa_nome() {
		return despesa_nome;
	}

	public void setDespesa_nome(String despesa_nome) {
		this.despesa_nome = despesa_nome;
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

	public ContaFinanceira getContafinanceira() {
		return contafinanceira;
	}

	public void setContafinanceira(ContaFinanceira contafinanceira) {
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

	public DespesaReceita getDespesa() {
		return despesa;
	}

	public void setDespesa(DespesaReceita despesa) {
		this.despesa = despesa;
	}

	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
