package br.com.grupoferraz.financeiro.entity;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class Estabelecimento implements Serializable {
 
	//private int id;
	private int codigo;
	private String nome;
	private int grupoestabelecimento_codigo;
	private GrupoEstabelecimento grupoestabalecimento;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getGrupoestabelecimento_codigo() {
		return grupoestabelecimento_codigo;
	}
	public void setGrupoestabelecimento_codigo(int grupoestabelecimento_codigo) {
		this.grupoestabelecimento_codigo = grupoestabelecimento_codigo;
	}
	public GrupoEstabelecimento getGrupoestabalecimento() {
		return grupoestabalecimento;
	}
	public void setGrupoestabalecimento(GrupoEstabelecimento grupoestabalecimento) {
		this.grupoestabalecimento = grupoestabalecimento;
	}
	
}