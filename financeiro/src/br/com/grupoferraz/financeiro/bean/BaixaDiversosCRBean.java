package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.BaixaDiversosCRDAO;
import br.com.grupoferraz.financeiro.entity.BaixaDiversosCR;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BaixaDiversosCRBean implements Serializable{
	private BaixaDiversosCR BaixaDiversosCR;
	private List<BaixaDiversosCR> listaBaixaDiversosCR;

	public BaixaDiversosCRBean() {
		BaixaDiversosCR = new BaixaDiversosCR();
		getBaixaDiversosCRs();
	}

	public String cadastraBaixaDiversosCR() {

		ConexaoBD.getConexao();
		BaixaDiversosCRDAO BaixaDiversosCRs = new BaixaDiversosCRDAO();
		if (BaixaDiversosCRs.insertBaixaDiversosCR(BaixaDiversosCR)) {
			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Baixa cadastrada com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da baixa!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		BaixaDiversosCR = new BaixaDiversosCR();

		return "";
	}

	public void getBaixaDiversosCRs() {
		BaixaDiversosCRDAO BaixaDiversosCRs = new BaixaDiversosCRDAO();
		listaBaixaDiversosCR = BaixaDiversosCRs.listBaixaDiversosCR();
	}

	public BaixaDiversosCR getBaixaDiversosCR() {
		return BaixaDiversosCR;
	}

	public void setBaixaDiversosCR(BaixaDiversosCR baixaDiversosCR) {
		BaixaDiversosCR = baixaDiversosCR;
	}

	public List<BaixaDiversosCR> getListaBaixaDiversosCR() {
		return listaBaixaDiversosCR;
	}

	public void setListaBaixaDiversosCR(List<BaixaDiversosCR> listaBaixaDiversosCR) {
		this.listaBaixaDiversosCR = listaBaixaDiversosCR;
	}

}
