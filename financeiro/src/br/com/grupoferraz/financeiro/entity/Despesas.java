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



	@Override
	public String toString() {

		return nome;
	}
}