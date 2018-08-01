package br.com.grupoferraz.financeiro.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ContaReceber {
	private int codigo;
	private int estabelecimento_codigo;
	private String cpf;
	private int receita_codigo;
	private int documento;
	private Date emissao;
	private BigDecimal valor;
	private String observacao;
	private String empresa_cnpj;
	private Integer centroresultado_codigo;
	private String nomereceita;
	private Estabelecimento estabelecimento;
	private CentroResultado centroresultado;
	private Empresa empresa;
	private Despesa receita;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getEstabelecimento_codigo() {
		return estabelecimento_codigo;
	}

	public void setEstabelecimento_codigo(int estabelecimento_codigo) {
		this.estabelecimento_codigo = estabelecimento_codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getReceita_codigo() {
		return receita_codigo;
	}

	public void setReceita_codigo(int receita_codigo) {
		this.receita_codigo = receita_codigo;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getEmpresa_cnpj() {
		return empresa_cnpj;
	}

	public void setEmpresa_cnpj(String empresa_cnpj) {
		this.empresa_cnpj = empresa_cnpj;
	}

	public Integer getCentroresultado_codigo() {
		return centroresultado_codigo;
	}

	public void setCentroresultado_codigo(Integer centroresultado_codigo) {
		this.centroresultado_codigo = centroresultado_codigo;
	}

	public String getNomereceita() {
		return nomereceita;
	}

	public void setNomereceita(String nomereceita) {
		this.nomereceita = nomereceita;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public CentroResultado getCentroresultado() {
		return centroresultado;
	}

	public void setCentroresultado(CentroResultado centroresultado) {
		this.centroresultado = centroresultado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Despesa getReceita() {
		return receita;
	}

	public void setReceita(Despesa receita) {
		this.receita = receita;
	}

}
