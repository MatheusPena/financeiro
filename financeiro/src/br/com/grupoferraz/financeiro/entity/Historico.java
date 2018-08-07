package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class Historico implements Serializable {

	private int codigo;
	private String descricao;
	private int despesareceita_codigo;
	private String despesareceita_nome;
	private DespesaReceita despesareceita;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDespesareceita_codigo() {
		return despesareceita_codigo;
	}

	public void setDespesareceita_codigo(int despesareceita_codigo) {
		this.despesareceita_codigo = despesareceita_codigo;
	}

	public String getDespesareceita_nome() {
		return despesareceita_nome;
	}

	public void setDespesareceita_nome(String despesareceita_nome) {
		this.despesareceita_nome = despesareceita_nome;
	}

	public DespesaReceita getDespesareceita() {
		return despesareceita;
	}

	public void setDespesareceita(DespesaReceita despesareceita) {
		this.despesareceita = despesareceita;
	}

	@Override
	public String toString() {
		return descricao;
	}
}