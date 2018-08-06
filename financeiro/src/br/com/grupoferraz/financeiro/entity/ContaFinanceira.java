package br.com.grupoferraz.financeiro.entity;

public class ContaFinanceira {
	private int codigo;
	private String nome;
	private String banco;
	private int agenciabanco;
	private int digagencia;
	private int conta;
	private int digconta;
	private String observacao;
	private int grupocontafinanceira_codigo;
	private GrupoContaFinanceira grupocontafinanceira;

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

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public int getAgenciabanco() {
		return agenciabanco;
	}

	public void setAgenciabanco(int agenciabanco) {
		this.agenciabanco = agenciabanco;
	}

	public int getDigagencia() {
		return digagencia;
	}

	public void setDigagencia(int digagencia) {
		this.digagencia = digagencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getGrupocontafinanceira_codigo() {
		return grupocontafinanceira_codigo;
	}

	public void setGrupocontafinanceira_codigo(int grupocontafinanceira_codigo) {
		this.grupocontafinanceira_codigo = grupocontafinanceira_codigo;
	}

	public GrupoContaFinanceira getGrupocontafinanceira() {
		return grupocontafinanceira;
	}

	public void setGrupocontafinanceira(GrupoContaFinanceira grupocontafinanceira) {
		this.grupocontafinanceira = grupocontafinanceira;
	}

	public int getDigconta() {
		return digconta;
	}

	public void setDigconta(int digconta) {
		this.digconta = digconta;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return nome;
	}

}
