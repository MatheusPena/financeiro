package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.GrupoCResultadoDAO;
import br.com.grupoferraz.financeiro.entity.GrupoCResultado;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoCResultadoBean implements Serializable {
	private GrupoCResultado grupoCResultado;
	private List<GrupoCResultado> listagrupoCResultados;

	public GrupoCResultadoBean() {
		grupoCResultado = new GrupoCResultado();
		listarGrupoCResultados();
	}

	// lista os grupos de centro de resultados na tabela
	private void listarGrupoCResultados() {
		GrupoCResultadoDAO grupoCResultadosDAO = new GrupoCResultadoDAO();
		listagrupoCResultados = grupoCResultadosDAO.listGrupoCResultado();

	}

	// cadastra os grupos de resultados exibindo uma mensagem
	public String cadastraGrupoCResultado() {

		GrupoCResultadoDAO grupoCResultados = new GrupoCResultadoDAO();
		if (grupoCResultados.insertGrupoCResultado(this.grupoCResultado)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo de Centro de Resultados cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da despesa/receita!", "Erro!"));
			return "";
		}

		this.grupoCResultado = new GrupoCResultado();
		return "";
	}

	public GrupoCResultado getGrupoCResultado() {
		return grupoCResultado;
	}

	public void setGrupoCResultado(GrupoCResultado grupoCResultado) {
		this.grupoCResultado = grupoCResultado;
	}

	public List<GrupoCResultado> getListagrupoCResultados() {
		return listagrupoCResultados;
	}

	public void setListagrupoCResultados(List<GrupoCResultado> listagrupoCResultados) {
		this.listagrupoCResultados = listagrupoCResultados;
	}

}
