package br.com.grupoferraz.financeiro.entity;

public class GrupoEstabelecimento {
	private int codigo;
	private String nomegrupoestabelecimento;
	private String unidade_nome;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getUnidade_nome() {
		return unidade_nome;
	}
	public void setUnidade_nome(String unidade_nome) {
		this.unidade_nome = unidade_nome;
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
