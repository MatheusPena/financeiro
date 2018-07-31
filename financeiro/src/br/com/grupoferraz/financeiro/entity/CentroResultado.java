package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class CentroResultado implements Serializable {
	private int codigo;
	private String nome;
	private Integer grupocentroresultado_codigo;
	private String atividade;
	private String crcontabil;
	private BigDecimal peso;
	private GrupoCResultado gruporesultado;

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

	public Integer getGrupocentroresultado_codigo() {
		return grupocentroresultado_codigo;
	}

	public void setGrupocentroresultado_codigo(Integer grupocentroresultado_codigo) {
		this.grupocentroresultado_codigo = grupocentroresultado_codigo;
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

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public GrupoCResultado getGruporesultado() {
		return gruporesultado;
	}

	public void setGruporesultado(GrupoCResultado gruporesultado) {
		this.gruporesultado = gruporesultado;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome;
	}
}
