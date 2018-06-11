package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoFornecedoresDAO;
import br.com.grupoferraz.financeiro.entity.GrupoFornecedores;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoFornecedoresBean implements Serializable {

	private GrupoFornecedores grupofornecedor;
	private List<GrupoFornecedores> grupofornecedores;

	public GrupoFornecedoresBean() {
		grupofornecedor = new GrupoFornecedores();
		getGrupoFornecedores();
	}

	public String cadastraGrupofornecedor() {

		ConexaoBD.getConexao();
		GrupoFornecedoresDAO grupofornecedores = new GrupoFornecedoresDAO ();
		if (grupofornecedores.insertGrupoFornecedores(grupofornecedor)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo de fornecedor cadastrado com sucesso", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public void getGrupoFornecedores()  {
		GrupoFornecedoresDAO grupofornecedoresDAO = new GrupoFornecedoresDAO ();
		grupofornecedores = grupofornecedoresDAO.listGrupoFornecedores();
	}


	public GrupoFornecedores getGrupofornecedor() {
		return grupofornecedor;
	}

	public void setGrupofornecedor(GrupoFornecedores grupofornecedor) {
		this.grupofornecedor = grupofornecedor;
	}

	public List<GrupoFornecedores> getGrupofornecedores() {
		return grupofornecedores;
	}

	public void setGrupofornecedores(List<GrupoFornecedores> grupofornecedores) {
		this.grupofornecedores = grupofornecedores;
	}

}