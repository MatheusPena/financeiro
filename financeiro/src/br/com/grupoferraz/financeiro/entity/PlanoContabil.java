package br.com.grupoferraz.financeiro.entity;

public class PlanoContabil {
	private int codigo;
	private String nome;
	private String banco;
	private int agenciabanco;
	private int digagencia;
	private int conta;
	private int digconta;
	private String conta_contabil;
	private String observacao;
	private int grupoplanocontabil_codigo;
	private GrupoPlanoContabil grupoplanocontabil;

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

	public int getGrupoplanocontabil_codigo() {
		return grupoplanocontabil_codigo;
	}

	public void setGrupoplanocontabil_codigo(int grupoplanocontabil_codigo) {
		this.grupoplanocontabil_codigo = grupoplanocontabil_codigo;
	}

	public GrupoPlanoContabil getGrupoplanocontabil() {
		return grupoplanocontabil;
	}

	public void setGrupoplanocontabil(GrupoPlanoContabil grupoplanocontabil) {
		this.grupoplanocontabil = grupoplanocontabil;
	}

}
