package br.com.grupoferraz.financeiro.entity;

public class ContasFinanceiras {
	private int codigo;
	private String nome;
	private String banco;
	private int agenciabanco;
	private int digagencia;
	private int conta;
	private int digconta;
	private String conta_contabil;
	private String observacao;
	private int grupocontasfinanceiras_codigo;
	private GrupoContasFinanceiras grupocontasfinanceiras;

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

	public int getDigconta() {
		return digconta;
	}

	public void setDigconta(int digconta) {
		this.digconta = digconta;
	}

	public String getConta_contabil() {
		return conta_contabil;
	}

	public void setConta_contabil(String conta_contabil) {
		this.conta_contabil = conta_contabil;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getGrupocontasfinanceiras_codigo() {
		return grupocontasfinanceiras_codigo;
	}

	public void setGrupocontasfinanceiras_codigo(int grupocontasfinanceiras_codigo) {
		this.grupocontasfinanceiras_codigo = grupocontasfinanceiras_codigo;
	}

	public GrupoContasFinanceiras getGrupocontasfinanceiras() {
		return grupocontasfinanceiras;
	}

	public void setGrupocontasfinanceiras(GrupoContasFinanceiras grupocontasfinanceiras) {
		this.grupocontasfinanceiras = grupocontasfinanceiras;
	}

}
