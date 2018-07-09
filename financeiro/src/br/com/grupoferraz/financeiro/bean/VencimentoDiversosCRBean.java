package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.VencimentoDiversosCRDAO;
import br.com.grupoferraz.financeiro.entity.VencimentoDiversosCR;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VencimentoDiversosCRBean implements Serializable {
	private VencimentoDiversosCR VencimentoDiversosCR;
	private List<VencimentoDiversosCR> listaVencimentoDiversosCR;

	public VencimentoDiversosCRBean() {
		VencimentoDiversosCR = new VencimentoDiversosCR();
		getVencimentoDiversosCRs();
	}

	public String cadastraVencimentoDiversosCR() {

		ConexaoBD.getConexao();
		VencimentoDiversosCRDAO VencimentoDiversosCRs = new VencimentoDiversosCRDAO();
		if (VencimentoDiversosCRs.insertVencimentoDiversosCR(VencimentoDiversosCR)) {
			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Vencimento cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do vencimento!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		VencimentoDiversosCR = new VencimentoDiversosCR();

		return "";
	}

	public void getVencimentoDiversosCRs() {
		VencimentoDiversosCRDAO VencimentoDiversosCRs = new VencimentoDiversosCRDAO();
		listaVencimentoDiversosCR = VencimentoDiversosCRs.listVencimentoDiversosCR();
	}

	public VencimentoDiversosCR getVencimentoDiversosCR() {
		return VencimentoDiversosCR;
	}

	public void setVencimentoDiversosCR(VencimentoDiversosCR VencimentoDiversosCR) {
		this.VencimentoDiversosCR = VencimentoDiversosCR;
	}

	public List<VencimentoDiversosCR> getListaVencimentoDiversosCR() {
		return listaVencimentoDiversosCR;
	}

	public void setListaVencimentoDiversosCR(List<VencimentoDiversosCR> listaVencimentoDiversosCR) {
		this.listaVencimentoDiversosCR = listaVencimentoDiversosCR;
	}

}
