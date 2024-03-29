package br.com.grupoferraz.financeiro.entity;

import java.math.BigDecimal;

public class PlanoConta {
	private String codigo;
	private int despesareceita_codigo;
	private String tipo;
	private String natureza;
	private String iss;
	private String inss;
	private String irpf;
	private String pis;
	private String conta;
	private String atividade;
	private BigDecimal icms;
	private String observacao;
	private Integer grupodespesareceita_codigo;
	private GrupoDespesaReceita grupodespesareceita;
	private DespesaReceita despesareceita;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
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

	public int getDespesareceita_codigo() {
		return despesareceita_codigo;
	}

	public void setDespesareceita_codigo(int despesareceita_codigo) {
		this.despesareceita_codigo = despesareceita_codigo;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public BigDecimal getIcms() {
		return icms;
	}

	public void setIcms(BigDecimal icms) {
		this.icms = icms;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getGrupodespesareceita_codigo() {
		return grupodespesareceita_codigo;
	}

	public void setGrupodespesareceita_codigo(Integer grupodespesareceita_codigo) {
		this.grupodespesareceita_codigo = grupodespesareceita_codigo;
	}

	public GrupoDespesaReceita getGrupodespesareceita() {
		return grupodespesareceita;
	}

	public void setGrupodespesareceita(GrupoDespesaReceita grupodespesareceita) {
		this.grupodespesareceita = grupodespesareceita;
	}

	public DespesaReceita getDespesareceita() {
		return despesareceita;
	}

	public void setDespesareceita(DespesaReceita despesareceita) {
		this.despesareceita = despesareceita;
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
		if (!(obj instanceof PlanoConta)) {
			return false;
		}
		PlanoConta other = (PlanoConta) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		if (despesareceita != null) {
			return despesareceita.getNome();
		}
		return null;
	}
}
