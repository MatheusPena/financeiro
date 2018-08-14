package br.com.grupoferraz.financeiro.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BaixaChequeCR {
	private int codigo;
	private int documento;
	private Date emissao;
	private Date vencimento;
	private BigDecimal valor;
	private Date vencimentobaixa;
	private BigDecimal valorbaixa;
	private BigDecimal desconto;
	private BigDecimal juros;
	private String historico;
	private int contafinanceira_codigo;
	private int contareceber_codigo;
	private String contareceber_cpf;
	private int contareceber_estabelecimento_codigo;
	private String empresa_cnpj;
	private int cheque;
	private ContaFinanceira contafinanceira;
	private Estabelecimento estabelecimento;
	private Empresa empresa;
	private ContaReceber conta;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getVencimentobaixa() {
		return vencimentobaixa;
	}

	public void setVencimentobaixa(Date vencimentobaixa) {
		this.vencimentobaixa = vencimentobaixa;
	}

	public BigDecimal getValorbaixa() {
		return valorbaixa;
	}

	public void setValorbaixa(BigDecimal valorbaixa) {
		this.valorbaixa = valorbaixa;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getJuros() {
		return juros;
	}

	public void setJuros(BigDecimal juros) {
		this.juros = juros;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public int getContafinanceira_codigo() {
		return contafinanceira_codigo;
	}

	public void setContafinanceira_codigo(int contafinanceira_codigo) {
		this.contafinanceira_codigo = contafinanceira_codigo;
	}

	public int getContareceber_codigo() {
		return contareceber_codigo;
	}

	public void setContareceber_codigo(int contareceber_codigo) {
		this.contareceber_codigo = contareceber_codigo;
	}

	public String getContareceber_cpf() {
		return contareceber_cpf;
	}

	public void setContareceber_cpf(String contareceber_cpf) {
		this.contareceber_cpf = contareceber_cpf;
	}

	public int getContareceber_estabelecimento_codigo() {
		return contareceber_estabelecimento_codigo;
	}

	public void setContareceber_estabelecimento_codigo(int contareceber_estabelecimento_codigo) {
		this.contareceber_estabelecimento_codigo = contareceber_estabelecimento_codigo;
	}

	public String getEmpresa_cnpj() {
		return empresa_cnpj;
	}

	public void setEmpresa_cnpj(String empresa_cnpj) {
		this.empresa_cnpj = empresa_cnpj;
	}

	public int getCheque() {
		return cheque;
	}

	public void setCheque(int cheque) {
		this.cheque = cheque;
	}

	public ContaFinanceira getContafinanceira() {
		return contafinanceira;
	}

	public void setContafinanceira(ContaFinanceira contafinanceira) {
		this.contafinanceira = contafinanceira;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public ContaReceber getConta() {
		return conta;
	}

	public void setConta(ContaReceber conta) {
		this.conta = conta;
	}

}
