package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.VencimentoChequeCRDAO;
import br.com.grupoferraz.financeiro.entity.VencimentoChequeCR;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VencimentoChequeCRBean implements Serializable{
	private VencimentoChequeCR VencimentoChequeCR;
	private List<VencimentoChequeCR> listaVencimentoChequeCR;

	public VencimentoChequeCRBean() {
		VencimentoChequeCR = new VencimentoChequeCR();
		getVencimentoChequeCRs();
	}

	public String cadastraVencimentoChequeCR() {

		ConexaoBD.getConexao();
		VencimentoChequeCRDAO VencimentoChequeCRs = new VencimentoChequeCRDAO();
		if (VencimentoChequeCRs.insertVencimentoChequeCR(VencimentoChequeCR)) {
			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Vencimento cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do vencimento!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		VencimentoChequeCR = new VencimentoChequeCR();

		return "";
	}

	public void getVencimentoChequeCRs() {
		VencimentoChequeCRDAO VencimentoChequeCRs = new VencimentoChequeCRDAO();
		listaVencimentoChequeCR = VencimentoChequeCRs.listVencimentoChequeCR();
	}

	public VencimentoChequeCR getVencimentoChequeCR() {
		return VencimentoChequeCR;
	}

	public void setVencimentoChequeCR(VencimentoChequeCR VencimentoChequeCR) {
		this.VencimentoChequeCR = VencimentoChequeCR;
	}

	public List<VencimentoChequeCR> getListaVencimentoChequeCR() {
		return listaVencimentoChequeCR;
	}

	public void setListaVencimentoChequeCR(List<VencimentoChequeCR> listaVencimentoChequeCR) {
		this.listaVencimentoChequeCR = listaVencimentoChequeCR;
	}

}
