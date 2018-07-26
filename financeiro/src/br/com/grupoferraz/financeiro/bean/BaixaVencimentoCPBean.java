package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.BaixaVencimentoCPDAO;
import br.com.grupoferraz.financeiro.entity.BaixaVencimentoCP;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BaixaVencimentoCPBean implements Serializable {
	private BaixaVencimentoCP Baixa;
	private List<BaixaVencimentoCP> Listabaixas;

	public BaixaVencimentoCPBean() {
		Baixa = new BaixaVencimentoCP();
		listarBaixa();
	}

	public String cadastraBaixa() {

		BaixaVencimentoCPDAO BaixaCPDAO = new BaixaVencimentoCPDAO();
		if (BaixaCPDAO.insertBaixaCP(Baixa)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Baixa de conta cadastrada com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da Baixa!", "Erro!"));

		}
		Baixa = new BaixaVencimentoCP();

		return "";
	}

	public void listarBaixa() {
		BaixaVencimentoCPDAO BaixaCPDAO = new BaixaVencimentoCPDAO();
		setListabaixas(BaixaCPDAO.listBaixa());
	}

	public BaixaVencimentoCP getBaixa() {
		return Baixa;
	}

	public void setBaixa(BaixaVencimentoCP baixa) {
		Baixa = baixa;
	}

	public List<BaixaVencimentoCP> getListabaixas() {
		return Listabaixas;
	}

	public void setListabaixas(List<BaixaVencimentoCP> listabaixas) {
		Listabaixas = listabaixas;
	}


}
