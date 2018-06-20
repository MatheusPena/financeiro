package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.CentroResultadosDAO;
import br.com.grupoferraz.financeiro.entity.CentroResultados;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CentroResultadosBean implements Serializable {
	private CentroResultados CentroResultados;
	private List<CentroResultados> CentroResultadoss;

	public CentroResultadosBean() {
		CentroResultados = new CentroResultados();
		listarCentroResultadoss();
	}

	public String cadastraCentroResultadoss() {

		ConexaoBD.getConexao();
		CentroResultadosDAO CentroResultadoss = new CentroResultadosDAO();
		if (CentroResultadoss.insertCentroResultadoss(this.CentroResultados)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Centro de Resultados cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do CentroResultados!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public void listarCentroResultadoss() {
		CentroResultadosDAO CentroResultadoss = new CentroResultadosDAO();
		setCentroResultadoss(CentroResultadoss.listCentroResultadoss());
	}

	public List<CentroResultados> getCentroResultadoss() {
		return CentroResultadoss;
	}

	public void setCentroResultadoss(List<CentroResultados> CentroResultadoss) {
		this.CentroResultadoss = CentroResultadoss;
	}

	public CentroResultados getCentroResultados() {
		return CentroResultados;
	}

	public void setCentroResultados(CentroResultados CentroResultados) {
		this.CentroResultados = CentroResultados;
	}

}
