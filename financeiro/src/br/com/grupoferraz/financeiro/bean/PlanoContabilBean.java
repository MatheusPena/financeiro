package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.PlanoContabilDAO;
import br.com.grupoferraz.financeiro.entity.PlanoContabil;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PlanoContabilBean implements Serializable {
	private PlanoContabil PlanoContabil;
	private List<PlanoContabil> listaPlanoContabil;

	public PlanoContabilBean() {
		PlanoContabil = new PlanoContabil();
		listarPlanoContabil();
	}

	public String cadastraPlanoContabil() {

		ConexaoBD.getConexao();
		PlanoContabilDAO PlanoContabil = new PlanoContabilDAO ();
		if (PlanoContabil.insertPlanoContabil(this.PlanoContabil)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Plano Contábil cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public void listarPlanoContabil()  {
		PlanoContabilDAO PlanoContabilDAO = new PlanoContabilDAO ();
		listaPlanoContabil = PlanoContabilDAO.listPlanoContabil();
	}

	public PlanoContabil getPlanoContabil() {
		return PlanoContabil;
	}

	public void setPlanoContabil(PlanoContabil PlanoContabil) {
		this.PlanoContabil = PlanoContabil;
	}

	public List<PlanoContabil> getListaPlanoContabil() {
		return listaPlanoContabil;
	}

	public void setListaPlanoContabil(List<PlanoContabil> listaPlanoContabil) {
		this.listaPlanoContabil = listaPlanoContabil;
	}
}
