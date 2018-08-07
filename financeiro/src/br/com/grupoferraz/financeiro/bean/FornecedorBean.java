package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.FornecedorDAO;
import br.com.grupoferraz.financeiro.entity.Fornecedor;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class FornecedorBean implements Serializable {
	
	private Fornecedor fornecedor;
	private List<Fornecedor> fornecedores;
	
	public FornecedorBean() {
		listarfornecedores();
	}
	
	public String cadastrar() {
		
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		if (fornecedorDAO.insertFornecedores(fornecedor)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Fornecedor cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do fornecedor", "Erro!"));
			return "";
		}

		this.fornecedor = new Fornecedor();

		return "cadastro_fornecedor?faces-redirect=true";
	}
	
	public void listarfornecedores()  {
		FornecedorDAO fornecedorDAO = new FornecedorDAO ();
		fornecedores = fornecedorDAO.listFornecedores();
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
	
