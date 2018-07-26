package br.com.grupoferraz.financeiro.entity;

public class PlanoContas {
	private String codigo;
	private int nome;
	private String tipo;
	private String natureza;
	private String grupo;
	private String iss;
	private String conta_contabil;
	private String contabil_estoque;
	private String inss;
	private String irpf;
	private String pis;
	private String conta;
	private String atividade;
	private int icms;
	private String observacao;
	private Integer grupoplanocontas_codigo;
	private Despesa despesa;
	private GrupoPlanoContas grupoplanocontas;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getNome() {
		return nome;
	}

	public void setNome(int nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public String getConta_contabil() {
		return conta_contabil;
	}

	public void setConta_contabil(String conta_contabil) {
		this.conta_contabil = conta_contabil;
	}

	public String getContabil_estoque() {
		return contabil_estoque;
	}

	public void setContabil_estoque(String contabil_estoque) {
		this.contabil_estoque = contabil_estoque;
	}

	public String getInss() {
		return inss;
	}

	public void setInss(String inss) {
		this.inss = inss;
	}

	public String getIrpf() {
		return irpf;
	}

	public void setIrpf(String irpf) {
		this.irpf = irpf;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public int getIcms() {
		return icms;
	}

	public void setIcms(int icms) {
		this.icms = icms;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getGrupoplanocontas_codigo() {
		return grupoplanocontas_codigo;
	}

	public void setGrupoplanocontas_codigo(Integer grupoplanocontas_codigo) {
		this.grupoplanocontas_codigo = grupoplanocontas_codigo;
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public GrupoPlanoContas getGrupoplanocontas() {
		return grupoplanocontas;
	}

	public void setGrupoplanocontas(GrupoPlanoContas grupoplanocontas) {
		this.grupoplanocontas = grupoplanocontas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		if (!(obj instanceof PlanoContas)) {
			return false;
		}
		PlanoContas other = (PlanoContas) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		return true;
	}
	
}
