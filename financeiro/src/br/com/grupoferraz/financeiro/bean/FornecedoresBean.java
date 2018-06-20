package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.FornecedoresDAO;
import br.com.grupoferraz.financeiro.entity.Fornecedores;
import br.com.grupoferraz.financeiro.util.ConexaoBD;



@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class FornecedoresBean implements Serializable {
	private Fornecedores fornecedores = new Fornecedores();
	private List<Fornecedores> fornecedor = new ArrayList<>();

	public FornecedoresBean() {
		fornecedores = new Fornecedores();
		getFornecedorr();
	}
	
	public String cadastrar() {
		fornecedor.add(fornecedores);
		ConexaoBD.getConexao();
		FornecedoresDAO fornecedoresDAO = new FornecedoresDAO();
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
		FornecedoresDAO vendedoresDAO = new FornecedoresDAO ();
		fornecedor = vendedoresDAO.listFornecedores();
	}

	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<Fornecedores> getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(List<Fornecedores> fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
}
	
