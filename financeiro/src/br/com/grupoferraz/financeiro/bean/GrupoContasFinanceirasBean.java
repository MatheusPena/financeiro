package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoContasFinanceirasDAO;
import br.com.grupoferraz.financeiro.entity.GrupoContasFinanceiras;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoContasFinanceirasBean implements Serializable {
	private GrupoContasFinanceiras GrupoContasFinanceiras;
	private List<GrupoContasFinanceiras> listaGrupoContasFinanceiras;

	public GrupoContasFinanceirasBean() {
		GrupoContasFinanceiras = new GrupoContasFinanceiras();
		listarGrupoContasFinanceiras();
	}

	public String cadastraGrupoContasFinanceiras() {

		ConexaoBD.getConexao();
		GrupoContasFinanceirasDAO GrupoContasFinanceiras = new GrupoContasFinanceirasDAO ();
		if (GrupoContasFinanceiras.insertGrupoContasFinanceiras(this.GrupoContasFinanceiras)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo de Conta Financeira cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public void listarGrupoContasFinanceiras()  {
		GrupoContasFinanceirasDAO GrupoContasFinanceirasDAO = new GrupoContasFinanceirasDAO ();
		listaGrupoContasFinanceiras = GrupoContasFinanceirasDAO.listGrupoContasFinanceiras();
	}

	public GrupoContasFinanceiras getGrupoContasFinanceiras() {
		return GrupoContasFinanceiras;
	}

	public void setGrupoContasFinanceiras(GrupoContasFinanceiras GrupoContasFinanceiras) {
		this.GrupoContasFinanceiras = GrupoContasFinanceiras;
	}

	public List<GrupoContasFinanceiras> getListaGrupoContasFinanceiras() {
		return listaGrupoContasFinanceiras;
	}

	public void setListaGrupoContasFinanceiras(List<GrupoContasFinanceiras> listaGrupoContasFinanceiras) {
		this.listaGrupoContasFinanceiras = listaGrupoContasFinanceiras;
	}
}
