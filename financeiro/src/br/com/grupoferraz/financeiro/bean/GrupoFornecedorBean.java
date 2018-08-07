package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.GrupoFornecedorDAO;
import br.com.grupoferraz.financeiro.entity.GrupoFornecedor;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoFornecedorBean implements Serializable {

	private GrupoFornecedor grupofornecedor;
	private List<GrupoFornecedor> grupofornecedores;

	public GrupoFornecedorBean() {
		grupofornecedor = new GrupoFornecedor();
		getGrupoFornecedores();
	}

	public String cadastraGrupofornecedor() {

		GrupoFornecedorDAO grupofornecedores = new GrupoFornecedorDAO ();
		if (grupofornecedores.insertGrupoFornecedores(grupofornecedor)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo fornecedor cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo", "Erro!"));
			return "";
		}

		this.grupofornecedor = new GrupoFornecedor();

		return "grupo_fornecedor?faces-redirect=true";
	}

	public void getGrupoFornecedores()  {
		GrupoFornecedorDAO grupofornecedoresDAO = new GrupoFornecedorDAO ();
		grupofornecedores = grupofornecedoresDAO.listGrupoFornecedores();
	}


	public GrupoFornecedor getGrupofornecedor() {
		return grupofornecedor;
	}

	public void setGrupofornecedor(GrupoFornecedor grupofornecedor) {
		this.grupofornecedor = grupofornecedor;
	}

	public List<GrupoFornecedor> getGrupofornecedores() {
		return grupofornecedores;
	}

	public void setGrupofornecedores(List<GrupoFornecedor> grupofornecedores) {
		this.grupofornecedores = grupofornecedores;
	}

}