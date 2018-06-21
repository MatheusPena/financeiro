package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.entity.Unidade;
import br.com.grupoferraz.financeiro.dao.UnidadeDAO;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UnidadeBean implements Serializable {
	private Unidade Unidade;
	private List<Unidade> listaUnidade;

	public UnidadeBean() {
		Unidade = new Unidade();
		listarUnidade();
	}

	private void listarUnidade() {
		UnidadeDAO UnidadeDAO = new UnidadeDAO();
		listaUnidade = UnidadeDAO.listUnidade();

	}

	public String cadastraUnidade() {

		ConexaoBD.getConexao();
		UnidadeDAO Unidade = new UnidadeDAO();
		if (Unidade.insertUnidade(this.Unidade)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Unidade cadastrada com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da unidade!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public Unidade getUnidade() {
		return Unidade;
	}

	public void setUnidade(Unidade Unidade) {
		this.Unidade = Unidade;
	}

	public List<Unidade> getListaUnidade() {
		return listaUnidade;
	}

	public void setListaUnidade(List<Unidade> listaUnidade) {
		this.listaUnidade = listaUnidade;
	}
	
}
