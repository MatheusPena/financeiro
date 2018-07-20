package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;
import java.util.Date;


@SuppressWarnings("serial")
public class Despesas implements Serializable {

	private Integer codigo;
	private String nome;
	private int estabelecimentos_codigo ;
	private int grupodespesas_codigo;
	private GrupoDespesas grupodespesas;
	private String empresa_cnpj;
	private Empresa empresa;
	private Estabelecimento estabelecimento;
	private Date emissao;
	private Date validade;
	private String cpf;
	
	public Despesas() {
		
	}

	
	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getEstabelecimentos_codigo() {
		return estabelecimentos_codigo;
	}

	public void setEstabelecimentos_codigo(int estabelecimentos_codigo) {
		this.estabelecimentos_codigo = estabelecimentos_codigo;
	}

	public int getGrupodespesas_codigo() {
		return grupodespesas_codigo;
	}


	public void setGrupodespesas_codigo(int grupodespesas_codigo) {
		this.grupodespesas_codigo = grupodespesas_codigo;
	}

	
	public GrupoDespesas getGrupodespesas() {
		return grupodespesas;
	}

	
	public void setGrupodespesas(GrupoDespesas grupodespesas) {
		this.grupodespesas = grupodespesas;
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

	
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}


	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}


	public Date getEmissao() {
		return emissao;
	}


	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}


	public Date getValidade() {
		return validade;
	}


	public void setValidade(Date validade) {
		this.validade = validade;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (!(obj instanceof Despesas)) {
			return false;
		}
		Despesas other = (Despesas) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return nome;
	}
}