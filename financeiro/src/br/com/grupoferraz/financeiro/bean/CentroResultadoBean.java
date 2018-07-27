package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.CentroResultadoDAO;
import br.com.grupoferraz.financeiro.entity.CentroResultado;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CentroResultadoBean implements Serializable {
	private CentroResultado centroResultado;
	private List<CentroResultado> centroResultados;

	public CentroResultadoBean() {
		centroResultado = new CentroResultado();
		listarCentroResultados();
	}

	// cadastra os centros de resultados exibindo uma mensagem na tela
	public String cadastraCentroResultado() {

		ConexaoBD.getConexao();
		CentroResultadoDAO CentroResultadoss = new CentroResultadoDAO();
		if (CentroResultadoss.insertCentroResultadoss(this.centroResultado)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Centro de Resultados cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro no cadastro do Centro de Resultados!", "Erro!"));
			return "";
		}
		ConexaoBD.fecharConexao();
		
		this.centroResultado = new CentroResultado();
		return "";
	}

	// lista na tabela os centros de resultados
	public void listarCentroResultados() {
		CentroResultadoDAO CentroResultado = new CentroResultadoDAO();
		setCentroResultados(CentroResultado.listCentroResultados());
	}

	public CentroResultado getCentroResultado() {
		return centroResultado;
	}

	public void setCentroResultado(CentroResultado centroResultado) {
		this.centroResultado = centroResultado;
	}

	public List<CentroResultado> getCentroResultados() {
		return centroResultados;
	}

	public void setCentroResultados(List<CentroResultado> centroResultados) {
		this.centroResultados = centroResultados;
	}

}
