package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class Historico implements Serializable {

	private int codigo;
	private String descricao;
	private int despesa_codigo;
	private Despesas Despesa;

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

	
	public int getDespesa_codigo() {
		return despesa_codigo;
	}

	public void setDespesa_codigo(int despesa_codigo) {
		this.despesa_codigo = despesa_codigo;
	}

	public Despesas getDespesa() {
		return Despesa;
	}

	public void setDespesa(Despesas despesa) {
		Despesa = despesa;
	}

	@Override
	public String toString() {
		return descricao;
	}
}