package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.HistoricoDAO;
import br.com.grupoferraz.financeiro.entity.Historico;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class HistoricoBean implements Serializable {

	private Historico historico;
	private List<Historico> listahistorico;

	public HistoricoBean() {
		historico = new Historico();
		listarHistoricos();
	}

	public String cadastraHistoricos() {

		ConexaoBD.getConexao();
		HistoricoDAO historicos = new HistoricoDAO();
		if (historicos.insertHistorico(this.historico)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Historico cadastrado com sucesso!", "Sucesso!"));
			// JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Estabelecimento
			// cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do historico!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		historico = new Historico();

		return "";
	}

	public void listarHistoricos() {
		HistoricoDAO historicos = new HistoricoDAO();
		setListahistorico(historicos.listHistoricos());
	}

	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	public List<Historico> getListahistorico() {
		return listahistorico;
	}

	public void setListahistorico(List<Historico> listahistorico) {
		this.listahistorico = listahistorico;
	}

	
}