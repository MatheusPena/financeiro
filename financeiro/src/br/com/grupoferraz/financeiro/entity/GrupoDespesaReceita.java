package br.com.grupoferraz.financeiro.entity;

public class GrupoDespesaReceita {
	private int codigo;
	private String nome;
	private int grupodespesareceita_codigo;
	private GrupoDespesaReceita grupopai;

	public GrupoDespesaReceita() {

	}

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

	public int getGrupodespesareceita_codigo() {
		return grupodespesareceita_codigo;
	}

	public void setGrupodespesareceita_codigo(int grupodespesareceita_codigo) {
		this.grupodespesareceita_codigo = grupodespesareceita_codigo;
	}

	public GrupoDespesaReceita getGrupopai() {
		return grupopai;
	}

	public void setGrupopai(GrupoDespesaReceita grupopai) {
		this.grupopai = grupopai;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GrupoDespesaReceita)) {
			return false;
		}
		GrupoDespesaReceita other = (GrupoDespesaReceita) obj;
		if (codigo != other.codigo) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}

}
