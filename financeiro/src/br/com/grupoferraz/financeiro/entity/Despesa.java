package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Despesa implements Serializable {

	private Integer codigo;
	private String nome;
	private int grupodespesa_codigo;
	private GrupoDespesa grupodespesa;
	private String empresa_cnpj;
	
	public Despesa() {
		
	}

	
	public int getGrupodespesa_codigo() {
		return grupodespesa_codigo;
	}


	public void setGrupodespesa_codigo(int grupodespesa_codigo) {
		this.grupodespesa_codigo = grupodespesa_codigo;
	}


	public GrupoDespesa getGrupodespesa() {
		return grupodespesa;
	}


	public void setGrupodespesa(GrupoDespesa grupodespesa) {
		this.grupodespesa = grupodespesa;
	}


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

	
	public String getEmpresa_cnpj() {
		return empresa_cnpj;
	}

	
	public void setEmpresa_cnpj(String empresa_cnpj) {
		this.empresa_cnpj = empresa_cnpj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		if (!(obj instanceof Despesa)) {
			return false;
		}
		Despesa other = (Despesa) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
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