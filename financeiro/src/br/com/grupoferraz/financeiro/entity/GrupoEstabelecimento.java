package br.com.grupoferraz.financeiro.entity;

public class GrupoEstabelecimento {
	private int codigo;
	private String empresa;
	private String nomegrupoestabelecimento;
	private String unidade_nome;
	private Unidade unidade;
	
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
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nomegrupoestabelecimento;
	}
	
}
