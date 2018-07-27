package br.com.grupoferraz.financeiro.entity;

public class GrupoDespesa {
	private Integer codigo;
	private String nomegrupodespesa;
	private Integer grupodespesa_codigo;
	private GrupoDespesa subgrupo;
	
	public GrupoDespesa() {
		
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNomegrupodespesa() {
		return nomegrupodespesa;
	}

	public void setNomegrupodespesa(String nomegrupodespesa) {
		this.nomegrupodespesa = nomegrupodespesa;
	}

	public Integer getGrupodespesa_codigo() {
		return grupodespesa_codigo;
	}

	public void setGrupodespesa_codigo(Integer grupodespesa_codigo) {
		this.grupodespesa_codigo = grupodespesa_codigo;
	}

	public GrupoDespesa getSubgrupo() {
		return subgrupo;
	}

	public void setSubgrupo(GrupoDespesa subgrupo) {
		this.subgrupo = subgrupo;
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
