package br.com.grupoferraz.financeiro.entity;

public class RateioCP {
	private int codigo;
	private int estabelecimento_codigo;
	private Estabelecimento estabelecimento;
	private String estabelecimento_nome;
	private String empresa_cnpj;
	private Empresa empresa;
	private CentroResultado centroresultados;
	private int centroresultados_codigo;
	private String despesa;
	private String despesa_codigo;
	private String valor;
	private String historico;

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

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String getEstabelecimento_nome() {
		return estabelecimento_nome;
	}

	public void setEstabelecimento_nome(String estabelecimento_nome) {
		this.estabelecimento_nome = estabelecimento_nome;
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

	public String getDespesa() {
		return despesa;
	}

	public void setDespesa(String despesa) {
		this.despesa = despesa;
	}

	public String getDespesa_codigo() {
		return despesa_codigo;
	}

	public void setDespesa_codigo(String despesa_codigo) {
		this.despesa_codigo = despesa_codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	@Override
	public String toString() {
		return String.valueOf(codigo);
	}

}
