package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class Estabelecimento implements Serializable {

	private Integer codigo;
	private String nome;
	private int grupoestabelecimento_codigo;
	private GrupoEstabelecimento grupoestabalecimento;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getGrupoestabelecimento_codigo() {
		return grupoestabelecimento_codigo;
	}

	public void setGrupoestabelecimento_codigo(int grupoestabelecimento_codigo) {
		this.grupoestabelecimento_codigo = grupoestabelecimento_codigo;
	}

	public GrupoEstabelecimento getGrupoestabalecimento() {
		return grupoestabalecimento;
	}

	public void setGrupoestabalecimento(GrupoEstabelecimento grupoestabalecimento) {
		this.grupoestabalecimento = grupoestabalecimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + grupoestabelecimento_codigo;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Estabelecimento)) {
			return false;
		}
		Estabelecimento other = (Estabelecimento) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		if (grupoestabelecimento_codigo != other.grupoestabelecimento_codigo) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}
}