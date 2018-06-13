package br.com.grupoferraz.financeiro.entity;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SuppressWarnings("serial")
public class Estabelecimento implements Serializable {
 
	//private int id;
	private String codigo;
	private String nome;
	private String grupoestabelecimento_codigo;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGrupoestabelecimento_codigo() {
		return grupoestabelecimento_codigo;
	}
	public void setGrupoestabelecimento_codigo(String grupoestabelecimento_codigo) {
		this.grupoestabelecimento_codigo = grupoestabelecimento_codigo;
	}

}