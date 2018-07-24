package br.com.grupoferraz.financeiro.entity;

public class GrupoVendedor {
	private int codigo;
	private String nomegrupovendedores;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomegrupovendedores() {
		return nomegrupovendedores;
	}

	public void setNomegrupovendedores(String nomegrupovendedores) {
		this.nomegrupovendedores = nomegrupovendedores;
	}

	@Override
	public String toString() {

		return nomegrupovendedores;
	}

}
