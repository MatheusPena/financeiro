package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class ContaPagar implements Serializable {

	private int codigocp;
	private String contapagar_nome;
	private int estabelecimento_codigo;
	private Estabelecimento estabelecimento;
	private String estabelecimento_nome;
	private String empresa_cnpj;
	private Empresa empresa;
	private String cpf;
	private int despesa_codigo;
	private String despesa_nome;
	private Date emissaocp;
	private Date emissaodp;
	private Date validadedp;
	private ContaFinanceira contafinanceira;
	private int contafinanceira_codigo;
	private String valor;
	private CentroResultado centroresultados;
	private int centroresultado_codigo;
	private Documento documento;
	private int documento_codigo;
	private String observacao;
	private DespesaReceita despesa;

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

	public ContaFinanceira getContafinanceira() {
		return contafinanceira;
	}

	public void setContafinanceira(ContaFinanceira contafinanceira) {
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


	public int getCentroresultado_codigo() {
		return centroresultado_codigo;
	}

	public void setCentroresultado_codigo(int centroresultado_codigo) {
		this.centroresultado_codigo = centroresultado_codigo;
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

	public String getEstabelecimento_nome() {
		return estabelecimento_nome;
	}

	public void setEstabelecimento_nome(String estabelecimento_nome) {
		this.estabelecimento_nome = estabelecimento_nome;
	}


	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public DespesaReceita getDespesa() {
		return despesa;
	}

	public void setDespesa(DespesaReceita despesa) {
		this.despesa = despesa;
	}

	public String getContapagar_nome() {
		return contapagar_nome;
	}

	public void setContapagar_nome(String contapagar_nome) {
		this.contapagar_nome = contapagar_nome;
	}

	public int getDespesa_codigo() {
		return despesa_codigo;
	}

	public void setDespesa_codigo(int despesa_codigo) {
		this.despesa_codigo = despesa_codigo;
	}

	public String getDespesa_nome() {
		return despesa_nome;
	}

	public void setDespesa_nome(String despesa_nome) {
		this.despesa_nome = despesa_nome;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + despesa_codigo;
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
		if (despesa_codigo != other.despesa_codigo) {
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
		if (despesa_codigo != other.despesa_codigo) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return cpf;
	}

}