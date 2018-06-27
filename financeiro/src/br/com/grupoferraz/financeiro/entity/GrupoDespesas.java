package br.com.grupoferraz.financeiro.entity;

public class GrupoDespesas {
	private int codigo;
	private String nomegrupodespesas;
	
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nomegrupodespesas;
	}
	
}
