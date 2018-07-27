package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.AdiantamentoDAO;
import br.com.grupoferraz.financeiro.entity.Adiantamento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AdiantamentoBean implements Serializable {
	private Adiantamento adiantamento;
	private List<Adiantamento> listaAdiantamentos;

	public AdiantamentoBean() {
		adiantamento = new Adiantamento();
		listarAdiantamento();
	}

	private void listarAdiantamento() {
		AdiantamentoDAO AdiantamentoDAO = new AdiantamentoDAO();
		listaAdiantamentos = AdiantamentoDAO.listAdiantamento();

	}

	public String cadastraAdiantamento() {

		ConexaoBD.getConexao();
		AdiantamentoDAO Adiantamento = new AdiantamentoDAO();
		if (Adiantamento.insertAdiantamento(this.adiantamento)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Adiantamento cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do Adiantamento!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public Adiantamento getAdiantamento() {
		return adiantamento;
	}

	public void setAdiantamento(Adiantamento Adiantamento) {
		this.adiantamento = Adiantamento;
	}

	public List<Adiantamento> getListaAdiantamento() {
		return listaAdiantamentos;
	}

	public void setListaAdiantamento(List<Adiantamento> listaAdiantamento) {
		this.listaAdiantamentos = listaAdiantamento;
	}

}
