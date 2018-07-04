package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class Pagar implements Serializable {

	private int codigocp;
	private int estabelecimentos_codigo ;
	private Estabelecimento estabelecimento;
	private String cpf;
	private int codigo;
	private Date emissaocp;
	private String valor;
	private CentroResultados centroresultados;
	private int centroresultados_codigo;
	private String tipodocumento;
	private Date emissaodp;
	
	
	public Pagar() {
		
	}

	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	
	public String getValor() {
		return valor;
	}

	
	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getEstabelecimentos_codigo() {
		return estabelecimentos_codigo;
	}

	public void setEstabelecimentos_codigo(int estabelecimentos_codigo) {
		this.estabelecimentos_codigo = estabelecimentos_codigo;
	}


	
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}


	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}



	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public int getCodigocp() {
		return codigocp;
	}


	public void setCodigocp(int codigocp) {
		this.codigocp = codigocp;
	}


	public Date getEmissaocp() {
		return emissaocp;
	}


	public void setEmissaocp(Date emissaocp) {
		this.emissaocp = emissaocp;
	}


	


	public String getTipodocumento() {
		return tipodocumento;
	}


	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}


	public Date getEmissaodp() {
		return emissaodp;
	}


	public void setEmissaodp(Date emissaodp) {
		this.emissaodp = emissaodp;
	}


	public CentroResultados getCentroresultados() {
		return centroresultados;
	}


	public void setCentroresultados(CentroResultados centroresultados) {
		this.centroresultados = centroresultados;
	}


	public int getCentroresultados_codigo() {
		return centroresultados_codigo;
	}


	public void setCentroresultados_codigo(int centroresultados_codigo) {
		this.centroresultados_codigo = centroresultados_codigo;
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
		if (!(obj instanceof Pagar)) {
			return false;
		}
		Pagar other = (Pagar) obj;
		if (codigo != other.codigo) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return cpf;
	}
}