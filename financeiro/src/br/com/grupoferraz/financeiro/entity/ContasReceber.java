package br.com.grupoferraz.financeiro.entity;

import java.util.Date;

public class ContasReceber {
	private int codigo;
	private int estabelecimentos_codigo;
	private String cpf;
	private int receita;
	private int documento;
	private Date emissao;
	private float valor;
	private String contabilidade;
	private String observacao;
	private Integer centro_resultados;
	private Estabelecimento estabelecimento;
	private CentroResultado centroresultados;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getEstabelecimentos_codigo() {
		return estabelecimentos_codigo;
	}

	public void setEstabelecimentos_codigo(int estabelecimentos_codigo) {
		this.estabelecimentos_codigo = estabelecimentos_codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getReceita() {
		return receita;
	}

	public void setReceita(int receita) {
		this.receita = receita;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getContabilidade() {
		return contabilidade;
	}

	public void setContabilidade(String contabilidade) {
		this.contabilidade = contabilidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getCentro_resultados() {
		return centro_resultados;
	}

	public void setCentro_resultados(Integer centro_resultados) {
		this.centro_resultados = centro_resultados;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public CentroResultado getCentroresultados() {
		return centroresultados;
	}

	public void setCentroresultados(CentroResultado centroresultados) {
		this.centroresultados = centroresultados;
	}

}
