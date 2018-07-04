package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.ItensCRDAO;
import br.com.grupoferraz.financeiro.entity.ItensCR;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ItensCRBean implements Serializable {
	private ItensCR itenscr;
	private List<ItensCR> listitenscr;

	public ItensCRBean() {
		itenscr = new ItensCR();
		getItensCR();
	}

	public String cadastraitenscr() {

		ConexaoBD.getConexao();
		ItensCRDAO itenscrs = new ItensCRDAO();
		if (itenscrs.insertItensCR(itenscr)) {
			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Item cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do item!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		itenscr = new ItensCR();

		return "";
	}

	public void getItensCR() {
		ItensCRDAO itenscrs = new ItensCRDAO();
		listitenscr = itenscrs.listItensCR();
	}

	public ItensCR getItenscr() {
		return itenscr;
	}

	public void setItenscr(ItensCR itenscr) {
		this.itenscr = itenscr;
	}

	public List<ItensCR> getListitenscr() {
		return listitenscr;
	}

	public void setListitenscr(List<ItensCR> listitenscr) {
		this.listitenscr = listitenscr;
	}

}
