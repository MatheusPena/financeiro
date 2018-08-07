package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DespesaReceita implements Serializable {

	private int codigo;
	private String nome;
	private Integer grupodespesareceita_codigo;
	private GrupoDespesaReceita grupodespesareceita;
	private String empresa_cnpj;

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

	public Integer getGrupodespesareceita_codigo() {
		return grupodespesareceita_codigo;
	}

	public void setGrupodespesareceita_codigo(Integer grupodespesareceita_codigo) {
		this.grupodespesareceita_codigo = grupodespesareceita_codigo;
	}

	public GrupoDespesaReceita getGrupodespesareceita() {
		return grupodespesareceita;
	}

	public void setGrupodespesareceita(GrupoDespesaReceita grupodespesareceita) {
		this.grupodespesareceita = grupodespesareceita;
	}

	public String getEmpresa_cnpj() {
		return empresa_cnpj;
	}

	public void setEmpresa_cnpj(String empresa_cnpj) {
		this.empresa_cnpj = empresa_cnpj;
	}

	@Override
	public String toString() {
		return nome;
	}
}