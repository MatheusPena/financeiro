package br.com.grupoferraz.financeiro.entity;

import java.util.Date;

public class BaixaDiversoCR {
	private int codigo;
	private int documento;
	private Date emissao;
	private Date vencimento;
	private float valor;
	private Date vencimentobaixa;
	private float valorbaixa;
	private float desconto;
	private float juros;
	private float multa;
	private String historico;
	private int contafinanceira_codigo;
	private Integer contareceber_codigo;
	private String contareceber_cpf;
	private int contareceber_estabelecimento_codigo;
	private Integer vencimentodiversocr_codigo;
	private String empresa_cnpj;
	private Empresa empresa;
	private ContaFinanceira contafinanceira;
	private Estabelecimento estabelecimento;

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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getVencimentobaixa() {
		return vencimentobaixa;
	}

	public void setVencimentobaixa(Date vencimentobaixa) {
		this.vencimentobaixa = vencimentobaixa;
	}

	public float getValorbaixa() {
		return valorbaixa;
	}

	public void setValorbaixa(float valorbaixa) {
		this.valorbaixa = valorbaixa;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public float getJuros() {
		return juros;
	}

	public void setJuros(float juros) {
		this.juros = juros;
	}

	public float getMulta() {
		return multa;
	}

	public void setMulta(float multa) {
		this.multa = multa;
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

	public Integer getContareceber_codigo() {
		return contareceber_codigo;
	}

	public void setContareceber_codigo(Integer contareceber_codigo) {
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

	public Integer getVencimentodiversocr_codigo() {
		return vencimentodiversocr_codigo;
	}

	public void setVencimentodiversocr_codigo(Integer vencimentodiversocr_codigo) {
		this.vencimentodiversocr_codigo = vencimentodiversocr_codigo;
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

}
