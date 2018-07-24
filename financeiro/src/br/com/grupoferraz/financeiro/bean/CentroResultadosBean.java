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
	private CentroResultados centroResultados;
	private List<CentroResultados> centroResultadoss;

	public CentroResultadosBean() {
		centroResultados = new CentroResultados();
		listarCentroResultadoss();
	}

	//cadastra os centros de resultados exibindo uma mensagem na tela
	public String cadastraCentroResultadoss() {

		ConexaoBD.getConexao();
		CentroResultadosDAO CentroResultadoss = new CentroResultadosDAO();
		if (CentroResultadoss.insertCentroResultadoss(this.centroResultados)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Centro de Resultados cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do Centro de Resultados!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	//lista na tabela os centros de resultados
	public void listarCentroResultadoss() {
		CentroResultadosDAO CentroResultadoss = new CentroResultadosDAO();
		setCentroResultadoss(CentroResultadoss.listCentroResultados());
	}

	public CentroResultados getCentroResultados() {
		return centroResultados;
	}

	public void setCentroResultados(CentroResultados centroResultados) {
		this.centroResultados = centroResultados;
	}

	public List<CentroResultados> getCentroResultadoss() {
		return centroResultadoss;
	}

	public void setCentroResultadoss(List<CentroResultados> centroResultadoss) {
		this.centroResultadoss = centroResultadoss;
	}

	

}
