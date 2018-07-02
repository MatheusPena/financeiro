package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class Despesas implements Serializable {

	private int codigo;
	private String nome;
	private String valor;
	private int estabelecimentos_codigo ;
	private int grupodespesas_codigo;
	private GrupoDespesas grupodespesas;
	private String empresa_cnpj;
	private Empresa empresa;
	private Estabelecimento estabelecimento;
	
	public Despesas() {
		
	}

	
	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @return the estabelecimentos_codigo
	 */
	public int getEstabelecimentos_codigo() {
		return estabelecimentos_codigo;
	}

	/**
	 * @param estabelecimentos_codigo the estabelecimentos_codigo to set
	 */
	public void setEstabelecimentos_codigo(int estabelecimentos_codigo) {
		this.estabelecimentos_codigo = estabelecimentos_codigo;
	}

	/**
	 * @return the grupodespesas_codigo
	 */
	public int getGrupodespesas_codigo() {
		return grupodespesas_codigo;
	}

	/**
	 * @param grupodespesas_codigo the grupodespesas_codigo to set
	 */
	public void setGrupodespesas_codigo(int grupodespesas_codigo) {
		this.grupodespesas_codigo = grupodespesas_codigo;
	}

	/**
	 * @return the grupodespesas
	 */
	public GrupoDespesas getGrupodespesas() {
		return grupodespesas;
	}

	/**
	 * @param grupodespesas the grupodespesas to set
	 */
	public void setGrupodespesas(GrupoDespesas grupodespesas) {
		this.grupodespesas = grupodespesas;
	}

	/**
	 * @return the empresa_cnpj
	 */
	public String getEmpresa_cnpj() {
		return empresa_cnpj;
	}

	/**
	 * @param empresa_cnpj the empresa_cnpj to set
	 */
	public void setEmpresa_cnpj(String empresa_cnpj) {
		this.empresa_cnpj = empresa_cnpj;
	}

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the estabelecimento
	 */
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}


	/**
	 * @param estabelecimento the estabelecimento to set
	 */
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Despesas)) {
			return false;
		}
		Despesas other = (Despesas) obj;
		if (codigo != other.codigo) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}
}