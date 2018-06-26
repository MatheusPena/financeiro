package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class CentroResultados implements Serializable {
	private int codigo;
	private String nome;
	private Integer grupocentroresultados_codigo;
	private String atividade;
	private String crcontabil;
	private float peso;
	private GrupoCResultados gruporesultados;
	
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
	public Integer getGrupocentroresultados_codigo() {
		return grupocentroresultados_codigo;
	}
	public void setGrupocentroresultados_codigo(Integer grupocentroresultados_codigo) {
		this.grupocentroresultados_codigo = grupocentroresultados_codigo;
	}
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public String getCrcontabil() {
		return crcontabil;
	}
	public void setCrcontabil(String crcontabil) {
		this.crcontabil = crcontabil;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public GrupoCResultados getGruporesultados() {
		return gruporesultados;
	}
	public void setGruporesultados(GrupoCResultados gruporesultados) {
		this.gruporesultados = gruporesultados;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome;
	}
}
