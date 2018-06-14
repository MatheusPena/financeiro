package br.com.grupoferraz.financeiro.entity;

public class GrupoEstabelecimento {
	private int codigo;
	private String nomegrupoestabelecimento;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNomegrupoestabelecimento() {
		return nomegrupoestabelecimento;
	}
	public void setNomegrupoestabelecimento(String nomegrupoestabelecimento) {
		this.nomegrupoestabelecimento = nomegrupoestabelecimento;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nomegrupoestabelecimento;
	}
	
}
