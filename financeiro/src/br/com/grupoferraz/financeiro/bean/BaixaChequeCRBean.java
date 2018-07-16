package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.BaixaChequeCRDAO;
import br.com.grupoferraz.financeiro.entity.BaixaChequeCR;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BaixaChequeCRBean implements Serializable {
	private BaixaChequeCR BaixaChequeCR;
	private List<BaixaChequeCR> listaBaixaChequeCR;

	public BaixaChequeCRBean() {
		BaixaChequeCR = new BaixaChequeCR();
		getBaixaChequeCRs();
	}

	public String cadastraBaixaChequeCR() {

		ConexaoBD.getConexao();
		BaixaChequeCRDAO BaixaChequeCRs = new BaixaChequeCRDAO();
		if (BaixaChequeCRs.insertBaixaChequeCR(BaixaChequeCR)) {
			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Baixa cadastrada com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da baixa!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		BaixaChequeCR = new BaixaChequeCR();

		return "";
	}

	public void getBaixaChequeCRs() {
		BaixaChequeCRDAO BaixaChequeCRs = new BaixaChequeCRDAO();
		listaBaixaChequeCR = BaixaChequeCRs.listBaixaChequeCR();
	}

	public BaixaChequeCR getBaixaChequeCR() {
		return BaixaChequeCR;
	}

	public void setBaixaChequeCR(BaixaChequeCR baixaChequeCR) {
		BaixaChequeCR = baixaChequeCR;
	}

	public List<BaixaChequeCR> getListaBaixaChequeCR() {
		return listaBaixaChequeCR;
	}

	public void setListaBaixaChequeCR(List<BaixaChequeCR> listaBaixaChequeCR) {
		this.listaBaixaChequeCR = listaBaixaChequeCR;
	}
}
