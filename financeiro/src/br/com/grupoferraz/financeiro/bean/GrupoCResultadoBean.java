package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.SQLException;
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
		listaGrupoCResultados();
	}

	// método que lista os grupos de centro de resultados
	private void listaGrupoCResultados() {
		GrupoCResultadoDAO grupoCResultadosDAO = new GrupoCResultadoDAO();
		listagrupoCResultados = grupoCResultadosDAO.listGrupoCResultado();

	}

	// método que cadastra os grupos de centro de resultados
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
		listaGrupoCResultados();
		return "";
	}

	// método que deleta os grupos de centro de resultados
	public String deletaGrupoCResultado() {

		// ConexaoBD.getConexao();
		GrupoCResultadoDAO grupocresultadoDAO = new GrupoCResultadoDAO();
		try {
			if (grupocresultadoDAO.deleteGrupoCResultado(grupoCResultado.getCodigo())) {
				listagrupoCResultados.remove(grupoCResultado);
				JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO,
						"Grupo de Centro de Resultados deletado com sucesso!");
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro ao deletar, esse grupo pode estar vinculado à um cliente.", "Erro!"));
				return "";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ConexaoBD.fecharConexao();
		this.grupoCResultado = new GrupoCResultado();
		listaGrupoCResultados();
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
