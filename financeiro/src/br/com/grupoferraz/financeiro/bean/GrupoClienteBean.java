package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoClienteDAO;
import br.com.grupoferraz.financeiro.entity.GrupoCliente;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoClienteBean implements Serializable {

	private GrupoCliente grupocliente;
	private List<GrupoCliente> listagrupoclientes;

	public GrupoClienteBean() {
		grupocliente = new GrupoCliente();
		getGrupoCliente();
	}

	public String cadastraGrupoCliente() {

		//ConexaoBD.getConexao();
		GrupoClienteDAO grupoclienteDAO = new GrupoClienteDAO ();
		if (grupoclienteDAO.insertGrupoCliente(grupocliente)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo de Cliente cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));
			return "";
		}
		//ConexaoBD.fecharConexao();
		this.grupocliente = new GrupoCliente();
		return "";
	}

	public void getGrupoCliente()  {
		GrupoClienteDAO grupoclientesDAO = new GrupoClienteDAO ();
		listagrupoclientes = grupoclientesDAO.listGrupoCliente();
	}


	public GrupoCliente getGrupocliente() {
		return grupocliente;
	}

	public void setGrupocliente(GrupoCliente grupocliente) {
		this.grupocliente = grupocliente;
	}

	public List<GrupoCliente> getListagrupoclientes() {
		return listagrupoclientes;
	}

	public void setListagrupoclientes(List<GrupoCliente> listagrupoclientes) {
		this.listagrupoclientes = listagrupoclientes;
	}

}