package br.com.grupoferraz.financeiro.entity;

public class Rateio {
	private int codigo;
	private String receita;
	private int estabelecimento;
	private int centro_resultados;
	private float percentual;
	private PlanoContas planocontas;
	private Estabelecimento estabelecimentos;
	private CentroResultados centroresultados;

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

	public PlanoContas getPlanocontas() {
		return planocontas;
	}

	public void setPlanocontas(PlanoContas planocontas) {
		this.planocontas = planocontas;
	}

	public Estabelecimento getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(Estabelecimento estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	public CentroResultados getCentroresultados() {
		return centroresultados;
	}

	public void setCentroresultados(CentroResultados centroresultados) {
		this.centroresultados = centroresultados;
	}

}
