package br.com.grupoferraz.financeiro.entity;

public class GrupoDespesas {
	private int codigo;
	private String nomegrupodespesas;
	
	public GrupoDespesas() {
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNomegrupodespesas() {
		return nomegrupodespesas;
	}
	public void setNomegrupodespesas(String nomegrupodespesas) {
		this.nomegrupodespesas = nomegrupodespesas;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GrupoDespesas)) {
			return false;
		}
		GrupoDespesas other = (GrupoDespesas) obj;
		if (codigo != other.codigo) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nomegrupodespesas;
	}
	
}
