package br.com.grupoferraz.financeiro.entity;

public class Unidade {
	private int codigo;
	private String nome;
	private String empresas_cnpj;
	private Empresa empresa;
	

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

	public String getEmpresas_cnpj() {
		return empresas_cnpj;
	}

	public void setEmpresas_cnpj(String empresas_cnpj) {
		this.empresas_cnpj = empresas_cnpj;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
