package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.ComissaoItemCRDAO;
import br.com.grupoferraz.financeiro.entity.ComissaoItemCR;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ComissaoItemCRBean implements Serializable {
	private ComissaoItemCR ComissaoItemCR;
	private List<ComissaoItemCR> listComissaoItemCR;

	public ComissaoItemCRBean() {
		ComissaoItemCR = new ComissaoItemCR();
		getComissaoItemCR1();
	}

	public String cadastraComissaoItemCR() {

		ConexaoBD.getConexao();
		ComissaoItemCRDAO ComissaoItemCRs = new ComissaoItemCRDAO();
		if (ComissaoItemCRs.insertComissaoItemCR(ComissaoItemCR)) {
			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Comissão do item cadastrada com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da comissão do item!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		ComissaoItemCR = new ComissaoItemCR();

		return "";
	}

	public void getComissaoItemCR1() {
		ComissaoItemCRDAO ComissaoItemCRs = new ComissaoItemCRDAO();
		listComissaoItemCR = ComissaoItemCRs.listComissaoItemCR();
	}

	public ComissaoItemCR getComissaoItemCR() {
		return ComissaoItemCR;
	}

	public void setComissaoItemCR(ComissaoItemCR ComissaoItemCR) {
		this.ComissaoItemCR = ComissaoItemCR;
	}

	public List<ComissaoItemCR> getListComissaoItemCR() {
		return listComissaoItemCR;
	}

	public void setListComissaoItemCR(List<ComissaoItemCR> listComissaoItemCR) {
		this.listComissaoItemCR = listComissaoItemCR;
	}
}
