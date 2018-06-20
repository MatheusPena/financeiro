package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoPlanoContasDAO;
import br.com.grupoferraz.financeiro.entity.GrupoPlanoContas;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoPlanoContasBean implements Serializable {
	private GrupoPlanoContas grupoPlanoContas;
	private List<GrupoPlanoContas> listagrupoPlanoContas;

	public GrupoPlanoContasBean() {
		grupoPlanoContas = new GrupoPlanoContas();
		listarGrupoPlanoContas();
	}

	private void listarGrupoPlanoContas() {
		GrupoPlanoContasDAO grupoPlanoContasDAO = new GrupoPlanoContasDAO();
		listagrupoPlanoContas = grupoPlanoContasDAO.listGrupoPlanoContas();

	}

	public String cadastraGrupoPlanoContas() {

		ConexaoBD.getConexao();
		GrupoPlanoContasDAO grupoPlanoContas = new GrupoPlanoContasDAO();
		if (grupoPlanoContas.insertGrupoPlanoContas(this.grupoPlanoContas)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Grupo de Plano de Contas cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public GrupoPlanoContas getGrupoPlanoContas() {
		return grupoPlanoContas;
	}

	public void setGrupoPlanoContas(GrupoPlanoContas grupoPlanoContas) {
		this.grupoPlanoContas = grupoPlanoContas;
	}

	public List<GrupoPlanoContas> getListagrupoPlanoContas() {
		return listagrupoPlanoContas;
	}

	public void setListagrupoPlanoContas(List<GrupoPlanoContas> listagrupoPlanoContas) {
		this.listagrupoPlanoContas = listagrupoPlanoContas;
	}

}
