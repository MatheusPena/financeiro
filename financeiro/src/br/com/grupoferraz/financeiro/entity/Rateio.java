package br.com.grupoferraz.financeiro.entity;

public class Rateio {
	private int codigo;
	private String receita;
	private int estabelecimento;
	private int centro_resultados;
	private float percentual;

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

	public int getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(int estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public int getCentro_resultados() {
		return centro_resultados;
	}

	public void setCentro_resultados(int centro_resultados) {
		this.centro_resultados = centro_resultados;
	}

	public float getPercentual() {
		return percentual;
	}

	public void setPercentual(float percentual) {
		this.percentual = percentual;
	}

}
