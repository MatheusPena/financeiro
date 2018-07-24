package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoCResultadosDAO;
import br.com.grupoferraz.financeiro.entity.GrupoCResultados;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoCResultadosBean implements Serializable {
	private GrupoCResultados grupoCResultados;
	private List<GrupoCResultados> listagrupoCResultados;

	public GrupoCResultadosBean() {
		grupoCResultados = new GrupoCResultados();
		listarGrupoCResultados();
	}

	//lista os grupos de centro de resultados na tabela
	private void listarGrupoCResultados() {
		GrupoCResultadosDAO grupoCResultadosDAO = new GrupoCResultadosDAO();
		listagrupoCResultados = grupoCResultadosDAO.listGrupoCResultado();

	}

	//cadastra os grupos de resultados exibindo uma mensagem
	public String cadastraGrupoCResultados() {

		ConexaoBD.getConexao();
		GrupoCResultadosDAO grupoCResultados = new GrupoCResultadosDAO();
		if (grupoCResultados.insertGrupoCResultado(this.grupoCResultados)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Grupo de Centro de Resultados cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public GrupoCResultados getGrupoCResultados() {
		return grupoCResultados;
	}

	public void setGrupoCResultados(GrupoCResultados grupoCResultados) {
		this.grupoCResultados = grupoCResultados;
	}

	public List<GrupoCResultados> getListagrupoCResultados() {
		return listagrupoCResultados;
	}

	public void setListagrupoCResultados(List<GrupoCResultados> listagrupoCResultados) {
		this.listagrupoCResultados = listagrupoCResultados;
	}

}
