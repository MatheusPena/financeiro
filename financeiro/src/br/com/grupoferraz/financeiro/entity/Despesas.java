package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class Despesas implements Serializable {

	// private int id;
	private int codigo;
	private String nome;
	private String valor;
	private String nomeempresa;
	private String empresas_cnpj ;
	private int grupodespesas_codigo;
	private GrupoDespesas grupodespesas;

	

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



	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}



	public int getGrupodespesas_codigo() {
		return grupodespesas_codigo;
	}



	public void setGrupodespesas_codigo(int grupodespesas_codigo) {
		this.grupodespesas_codigo = grupodespesas_codigo;
	}



	public GrupoDespesas getGrupodespesas() {
		return grupodespesas;
	}



	public void setGrupodespesas(GrupoDespesas grupodespesas) {
		this.grupodespesas = grupodespesas;
	}




	/**
	 * @return the nomeempresa
	 */
	public String getNomeempresa() {
		return nomeempresa;
	}



	/**
	 * @param nomeempresa the nomeempresa to set
	 */
	public void setNomeempresa(String nomeempresa) {
		this.nomeempresa = nomeempresa;
	}



	/**
	 * @return the empresas_cnpj
	 */
	public String getEmpresas_cnpj() {
		return empresas_cnpj;
	}



	/**
	 * @param empresas_cnpj the empresas_cnpj to set
	 */
	public void setEmpresas_cnpj(String empresas_cnpj) {
		this.empresas_cnpj = empresas_cnpj;
	}



	@Override
	public String toString() {

		return nome;
	}
}