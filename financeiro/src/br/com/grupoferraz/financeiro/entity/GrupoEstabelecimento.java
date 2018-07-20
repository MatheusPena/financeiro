package br.com.grupoferraz.financeiro.entity;

public class GrupoEstabelecimento {
	private int codigo;
	private String empresa;
	private Empresa emp;
	private String nomegrupoestabelecimento;
	private int unidade_codigo;
	private Unidade unidade;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getUnidade_codigo() {
		return unidade_codigo;
	}
	public void setUnidade_codigo(int unidade_codigo) {
		this.unidade_codigo = unidade_codigo;
	}
	public String getNomegrupoestabelecimento() {
		return nomegrupoestabelecimento;
	}
	public void setNomegrupoestabelecimento(String nomegrupoestabelecimento) {
		this.nomegrupoestabelecimento = nomegrupoestabelecimento;
	}
	
	public Empresa getEmp() {
		return emp;
	}
	public void setEmp(Empresa emp) {
		this.emp = emp;
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
