package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class ContaPagar implements Serializable {

	private int codigocp;
	private String nomecp;
	private int estabelecimento_codigo;
	private Estabelecimento estabelecimento;
	private String estabelecimento_nome;
	private String empresa_cnpj;
	private Empresa empresa;
	private String cpf;
	private int codigodp;
	private String nomedp;
	private Date emissaocp;
	private Date emissaodp;
	public int getCodigodp() {
		return codigodp;
	}


	public void setCodigodp(int codigodp) {
		this.codigodp = codigodp;
	}

	private Date validadedp;
	private ContasFinanceiras contafinanceira;
	private int contafinanceira_codigo;
	private String valor;
	private CentroResultado centroresultados;
	private int centroresultados_codigo;
	private Documento documento;
	private int documento_codigo;
	private String observacao;
	private Despesa despesa;
	
	
	public ContaPagar() {
		
	}
	
	
	public String getValor() {
		return valor;
	}

	
	public void setValor(String valor) {
		this.valor = valor;
	}

	
	
	public String getEmpresa_cnpj() {
		return empresa_cnpj;
	}


	public void setEmpresa_cnpj(String empresa_cnpj) {
		this.empresa_cnpj = empresa_cnpj;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public int getEstabelecimento_codigo() {
		return estabelecimento_codigo;
	}


	public void setEstabelecimento_codigo(int estabelecimento_codigo) {
		this.estabelecimento_codigo = estabelecimento_codigo;
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



	public Date getEmissaodp() {
		return emissaodp;
	}


	public void setEmissaodp(Date emissaodp) {
		this.emissaodp = emissaodp;
	}


	public Date getValidadedp() {
		return validadedp;
	}


	public void setValidadedp(Date validadedp) {
		this.validadedp = validadedp;
	}


	public ContasFinanceiras getContafinanceira() {
		return contafinanceira;
	}


	public void setContafinanceira(ContasFinanceiras contafinanceira) {
		this.contafinanceira = contafinanceira;
	}


	public int getContafinanceira_codigo() {
		return contafinanceira_codigo;
	}


	public void setContafinanceira_codigo(int contafinanceira_codigo) {
		this.contafinanceira_codigo = contafinanceira_codigo;
	}


	public CentroResultado getCentroresultados() {
		return centroresultados;
	}


	public void setCentroresultados(CentroResultado centroresultados) {
		this.centroresultados = centroresultados;
	}


	public int getCentroresultados_codigo() {
		return centroresultados_codigo;
	}


	public void setCentroresultados_codigo(int centroresultados_codigo) {
		this.centroresultados_codigo = centroresultados_codigo;
	}


	public int getDocumento_codigo() {
		return documento_codigo;
	}


	public void setDocumento_codigo(int documento_codigo) {
		this.documento_codigo = documento_codigo;
	}


	public Documento getDocumento() {
		return documento;
	}


	public void setDocumento(Documento documento) {
		this.documento = documento;
	}


	public String getNomecp() {
		return nomecp;
	}


	public void setNomecp(String nomecp) {
		this.nomecp = nomecp;
	}


	public String getEstabelecimento_nome() {
		return estabelecimento_nome;
	}


	public void setEstabelecimento_nome(String estabelecimento_nome) {
		this.estabelecimento_nome = estabelecimento_nome;
	}


	public String getNomedp() {
		return nomedp;
	}


	public void setNomedp(String nomedp) {
		this.nomedp = nomedp;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public Despesa getDespesa() {
		return despesa;
	}


	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigodp;
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
		if (!(obj instanceof ContaPagar)) {
			return false;
		}
		ContaPagar other = (ContaPagar) obj;
		if (codigodp != other.codigodp) {
			return false;
		}
		return true;
	}
	
	public boolean equals2(Object ojb) {
		if (this == ojb) {
			return true;
		}
		if (ojb == null) {
			return false;
		}
		if (!(ojb instanceof ContaPagar)) {
			return false;
		}
		ContaPagar other = (ContaPagar) ojb;
		if (codigodp != other.codigodp) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return cpf;
	}

}