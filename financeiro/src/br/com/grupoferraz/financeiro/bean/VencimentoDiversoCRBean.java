package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.VencimentoDiversoCRDAO;
import br.com.grupoferraz.financeiro.entity.VencimentoDiversoCR;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VencimentoDiversoCRBean implements Serializable {
	private VencimentoDiversoCR vencimentoDiversoCR;
	private List<VencimentoDiversoCR> listaVencimentoDiversosCR;

	public VencimentoDiversoCRBean() {
		vencimentoDiversoCR = new VencimentoDiversoCR();
		getVencimentoDiversosCRs();
	}
	
	//cadastra o vencimento no banco de dados
	public String cadastraVencimentoDiversoCR() {

		ConexaoBD.getConexao();
		VencimentoDiversoCRDAO vencimentoDiversoCRDAO = new VencimentoDiversoCRDAO();
		if (vencimentoDiversoCRDAO.insertVencimentoDiversoCR(vencimentoDiversoCR)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Vencimento cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do vencimento!", "Erro!"));
			return "";
		}
		ConexaoBD.fecharConexao();
		this.vencimentoDiversoCR = new VencimentoDiversoCR();

		return "";
	}

	public void getVencimentoDiversosCRs() {
		VencimentoDiversoCRDAO VencimentoDiversoCR = new VencimentoDiversoCRDAO();
		listaVencimentoDiversosCR = VencimentoDiversoCR.listVencimentoDiversosCR();
	}

	public VencimentoDiversoCR getVencimentoDiversoCR() {
		return vencimentoDiversoCR;
	}

	public void setVencimentoDiversoCR(VencimentoDiversoCR vencimentoDiversoCR) {
		this.vencimentoDiversoCR = vencimentoDiversoCR;
	}

	public List<VencimentoDiversoCR> getListaVencimentoDiversosCR() {
		return listaVencimentoDiversosCR;
	}

	public void setListaVencimentoDiversosCR(List<VencimentoDiversoCR> listaVencimentoDiversosCR) {
		this.listaVencimentoDiversosCR = listaVencimentoDiversosCR;
	}

}
