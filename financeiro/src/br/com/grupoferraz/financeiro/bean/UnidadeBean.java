package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.UnidadeDAO;
import br.com.grupoferraz.financeiro.entity.Unidade;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UnidadeBean implements Serializable {
	private Unidade unidade;
	private List<Unidade> listaunidades;
	private UnidadeDAO unidadeDAO;

	public UnidadeBean() {
		unidade = new Unidade();
		listarUnidade();
	}

	private void listarUnidade() {
		unidadeDAO = new UnidadeDAO();
		listaunidades = unidadeDAO.listUnidade();
		
	}

	public String cadastraUnidade() {

		UnidadeDAO unidadeDAO = new UnidadeDAO();
		if (unidadeDAO.insertUnidade(this.unidade)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Unidade cadastrada com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da unidade!", "Erro!"));

		}

		return "";
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public List<Unidade> getListaunidades() {
		return listaunidades;
	}

	public void setListaunidades(List<Unidade> listaunidades) {
		this.listaunidades = listaunidades;
	}
	
}
