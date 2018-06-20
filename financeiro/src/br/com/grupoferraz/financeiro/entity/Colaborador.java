package br.com.grupoferraz.financeiro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="colaborador")
public class Colaborador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column (length=20, name="numPessoa")
	private String numPessoa;
	
	@Column (length=10)
	private String tipoPessoa;
	
	@Column (length=150)
	private String nome;
	
	@Column (length=15, unique=true)
	private String chaveJ;
	
	@OneToOne 
	@JoinColumn(name="login")
	private Login login;

	public Colaborador() {
		
	}
	
	public String getNumPessoa() {
		return numPessoa;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public String getChaveJ() {
		return chaveJ;
	}

	public Login getLogin() {
		return login;
	}

	public void setNumPessoa(String numPessoa) {
		this.numPessoa = numPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setChaveJ(String chaveJ) {
		this.chaveJ = chaveJ;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return nome;
	}
	
}
