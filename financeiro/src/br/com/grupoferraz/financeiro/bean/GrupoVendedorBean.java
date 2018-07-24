package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoVendedoresDAO;
import br.com.grupoferraz.financeiro.entity.GrupoVendedor;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoVendedorBean implements Serializable {

	private GrupoVendedor grupovendedores;
	private List<GrupoVendedor> listagrupovendedores;

	public GrupoVendedorBean() {
		grupovendedores = new GrupoVendedor();
		listarGrupoVendedores();
	}

	public String cadastraGrupoVendedores() {

		ConexaoBD.getConexao();
		GrupoVendedoresDAO grupovendedores = new GrupoVendedoresDAO ();
		if (grupovendedores.insertGrupoVendedores(this.grupovendedores)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo de Vendedores cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public void listarGrupoVendedores()  {
		GrupoVendedoresDAO grupovendedoresDAO = new GrupoVendedoresDAO ();
		listagrupovendedores = grupovendedoresDAO.listGrupoVendedores();
	}

	public GrupoVendedor getGrupovendedores() {
		return grupovendedores;
	}

	public void setGrupovendedores(GrupoVendedor grupovendedores) {
		this.grupovendedores = grupovendedores;
	}

	public List<GrupoVendedor> getListagrupovendedores() {
		return listagrupovendedores;
	}

	public void setListagrupovendedores(List<GrupoVendedor> listagrupovendedores) {
		this.listagrupovendedores = listagrupovendedores;
	}


	
}