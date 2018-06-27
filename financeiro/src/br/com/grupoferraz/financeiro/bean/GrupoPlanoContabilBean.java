package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoPlanoContabilDAO;
import br.com.grupoferraz.financeiro.entity.GrupoPlanoContabil;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoPlanoContabilBean implements Serializable {
	private GrupoPlanoContabil GrupoPlanoContabil;
	private List<GrupoPlanoContabil> listaGrupoPlanoContabil;

	public GrupoPlanoContabilBean() {
		GrupoPlanoContabil = new GrupoPlanoContabil();
		listarGrupoPlanoContabil();
	}

	public String cadastraGrupoPlanoContabil() {

		ConexaoBD.getConexao();
		GrupoPlanoContabilDAO GrupoPlanoContabil = new GrupoPlanoContabilDAO ();
		if (GrupoPlanoContabil.insertGrupoPlanoContabil(this.GrupoPlanoContabil)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo de Plano Contábil cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public void listarGrupoPlanoContabil()  {
		GrupoPlanoContabilDAO GrupoPlanoContabilDAO = new GrupoPlanoContabilDAO ();
		listaGrupoPlanoContabil = GrupoPlanoContabilDAO.listGrupoPlanoContabil();
	}

	public GrupoPlanoContabil getGrupoPlanoContabil() {
		return GrupoPlanoContabil;
	}

	public void setGrupoPlanoContabil(GrupoPlanoContabil GrupoPlanoContabil) {
		this.GrupoPlanoContabil = GrupoPlanoContabil;
	}

	public List<GrupoPlanoContabil> getListaGrupoPlanoContabil() {
		return listaGrupoPlanoContabil;
	}

	public void setListaGrupoPlanoContabil(List<GrupoPlanoContabil> listaGrupoPlanoContabil) {
		this.listaGrupoPlanoContabil = listaGrupoPlanoContabil;
	}
}
