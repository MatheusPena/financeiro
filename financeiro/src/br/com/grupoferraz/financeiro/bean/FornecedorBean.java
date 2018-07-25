package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.FornecedorDAO;
import br.com.grupoferraz.financeiro.entity.Fornecedor;
import br.com.grupoferraz.financeiro.util.ConexaoBD;



@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class FornecedorBean implements Serializable {
	private Fornecedor fornecedores = new Fornecedor();
	private List<Fornecedor> fornecedor = new ArrayList<>();

	public FornecedorBean() {
		fornecedores = new Fornecedor();
		getFornecedorr();
	}
	
	public void editar(Fornecedor fornecedores) {
		this.fornecedores = fornecedores;
		System.out.println(fornecedores);
	}
	
	public String cadastrar() {
		fornecedor.add(fornecedores);
		ConexaoBD.getConexao();
		FornecedorDAO fornecedoresDAO = new FornecedorDAO();
		if (fornecedoresDAO.insertFornecedores(fornecedores)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornecedor cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do fornecedor !", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}
	
	public void getFornecedorr()  {
		FornecedorDAO vendedoresDAO = new FornecedorDAO ();
		fornecedor = vendedoresDAO.listFornecedores();
	}

	public Fornecedor getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedor fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<Fornecedor> getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(List<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
}
	
