package br.com.grupoferraz.financeiro.entity;

import java.util.Date;

public class BaixaChequeCR {
	private int codigo;
	private int documento;
	private Date emissao;
	private Date vencimento;
	private float valor;
	private Date vencimentobaixa;
	private float valorbaixa;
	private float desconto;
	private float juros;
	private String historico;
	private int contasfinanceiras_codigo;
	private Integer contasreceber_codigo;
	private String contasreceber_cpf;
	private int contasreceber_estabelecimentos_codigo;
	private Integer vencimentosdiversoscr_codigo;
	private ContaFinanceira contasfinanceiras;
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
	
	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public int getContasfinanceiras_codigo() {
		return contasfinanceiras_codigo;
	}

	public void setContasfinanceiras_codigo(int contasfinanceiras_codigo) {
		this.contasfinanceiras_codigo = contasfinanceiras_codigo;
	}

	public Integer getContasreceber_codigo() {
		return contasreceber_codigo;
	}

	public void setContasreceber_codigo(Integer contasreceber_codigo) {
		this.contasreceber_codigo = contasreceber_codigo;
	}

	public String getContasreceber_cpf() {
		return contasreceber_cpf;
	}

	public void setContasreceber_cpf(String contasreceber_cpf) {
		this.contasreceber_cpf = contasreceber_cpf;
	}

	public int getContasreceber_estabelecimentos_codigo() {
		return contasreceber_estabelecimentos_codigo;
	}

	public void setContasreceber_estabelecimentos_codigo(int contasreceber_estabelecimentos_codigo) {
		this.contasreceber_estabelecimentos_codigo = contasreceber_estabelecimentos_codigo;
	}

	public Integer getVencimentosdiversoscr_codigo() {
		return vencimentosdiversoscr_codigo;
	}

	public void setVencimentosdiversoscr_codigo(Integer vencimentosdiversoscr_codigo) {
		this.vencimentosdiversoscr_codigo = vencimentosdiversoscr_codigo;
	}

	public ContaFinanceira getContasfinanceiras() {
		return contasfinanceiras;
	}

	public void setContasfinanceiras(ContaFinanceira contasfinanceiras) {
		this.contasfinanceiras = contasfinanceiras;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

}
