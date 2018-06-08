package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoClientesDAO;
import br.com.grupoferraz.financeiro.entity.GrupoClientes;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoClientesBean implements Serializable {

	private GrupoClientes grupocliente;
	private List<GrupoClientes> grupoclientes;

	public GrupoClientesBean() {
		grupocliente = new GrupoClientes();
		getGrupoClientes();
	}

	public String cadastraGrupoCliente() {

		ConexaoBD.getConexao();
		GrupoClientesDAO grupoclientes = new GrupoClientesDAO ();
		if (grupoclientes.insertGrupoCliente(grupocliente)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo de Cliente cadastrado com sucesso", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public void getGrupoClientes()  {
		GrupoClientesDAO grupoclientesDAO = new GrupoClientesDAO ();
		grupoclientes = grupoclientesDAO.listGrupoClientes();
	}


	public GrupoClientes getGrupocliente() {
		return grupocliente;
	}

	public void setGrupocliente(GrupoClientes grupocliente) {
		this.grupocliente = grupocliente;
	}

	public List<GrupoClientes> getGrupoclientes() {
		return grupoclientes;
	}

	public void setGrupoclientes(List<GrupoClientes> grupoclientes) {
		this.grupoclientes = grupoclientes;
	}

}