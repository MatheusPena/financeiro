package br.com.grupoferraz.financeiro.entity;

public class GrupoDespesaReceita {
	private int codigo;
	private String nome;
	private int grupodespesareceita_codigo;
	private GrupoDespesaReceita subgrupo;

	public GrupoDespesaReceita() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public GrupoDespesaReceita getSubgrupo() {
		return subgrupo;
	}

	public void setSubgrupo(GrupoDespesaReceita subgrupo) {
		this.subgrupo = subgrupo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getGrupodespesareceita_codigo() {
		return grupodespesareceita_codigo;
	}

	public void setGrupodespesareceita_codigo(int grupodespesareceita_codigo) {
		this.grupodespesareceita_codigo = grupodespesareceita_codigo;
	}

	@Override
	public String toString() {
		return nome;
	}

}
