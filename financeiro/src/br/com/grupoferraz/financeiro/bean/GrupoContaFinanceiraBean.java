package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoContaFinanceiraDAO;
import br.com.grupoferraz.financeiro.entity.GrupoContaFinanceira;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoContaFinanceiraBean implements Serializable {
	private GrupoContaFinanceira GrupoContaFinanceira;
	private List<GrupoContaFinanceira> listaGrupoContasFinanceiras;

	public GrupoContaFinanceiraBean() {
		GrupoContaFinanceira = new GrupoContaFinanceira();
		listarGrupoContasFinanceiras();
	}

	public String cadastraGrupoContasFinanceiras() {

		GrupoContaFinanceiraDAO GrupoContasFinanceiras = new GrupoContaFinanceiraDAO ();
		if (GrupoContasFinanceiras.insertGrupoContasFinanceiras(this.GrupoContaFinanceira)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo cadastrado com sucesso!");
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));
			return "";
			}

		return "grupo_contafinanceira?faces-redirect=true";
	}

	public void listarGrupoContasFinanceiras()  {
		GrupoContaFinanceiraDAO GrupoContasFinanceirasDAO = new GrupoContaFinanceiraDAO ();
		listaGrupoContasFinanceiras = GrupoContasFinanceirasDAO.listGrupoContasFinanceiras();
	}

	public GrupoContaFinanceira getGrupoContaFinanceira() {
		return GrupoContaFinanceira;
	}

	public void setGrupoContaFinanceira(GrupoContaFinanceira GrupoContaFinanceira) {
		this.GrupoContaFinanceira = GrupoContaFinanceira;
	}

	public List<GrupoContaFinanceira> getListaGrupoContasFinanceiras() {
		return listaGrupoContasFinanceiras;
	}

	public void setListaGrupoContasFinanceiras(List<GrupoContaFinanceira> listaGrupoContasFinanceiras) {
		this.listaGrupoContasFinanceiras = listaGrupoContasFinanceiras;
	}
}
