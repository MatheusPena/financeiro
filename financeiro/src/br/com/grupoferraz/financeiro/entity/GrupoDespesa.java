package br.com.grupoferraz.financeiro.entity;

public class GrupoDespesa {
	private int codigo;
	private String nomegrupodespesa;
	
	public GrupoDespesa() {
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNomegrupodespesa() {
		return nomegrupodespesa;
	}

	public void setNomegrupodespesa(String nomegrupodespesa) {
		this.nomegrupodespesa = nomegrupodespesa;
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
		if (!(obj instanceof GrupoDespesa)) {
			return false;
		}
		GrupoDespesa other = (GrupoDespesa) obj;
		if (codigo != other.codigo) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nomegrupodespesa;
	}
	
}
