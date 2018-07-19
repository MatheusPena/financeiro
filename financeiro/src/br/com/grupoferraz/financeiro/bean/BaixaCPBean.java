package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.BaixaCPDAO;
import br.com.grupoferraz.financeiro.entity.BaixaCP;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BaixaCPBean implements Serializable {
	private BaixaCP Baixa;
	private List<BaixaCP> Listabaixa;

	public BaixaCPBean() {
		Baixa = new BaixaCP();
		listarBaixa();
	}

	public String cadastraBaixa() {

		ConexaoBD.getConexao();
		BaixaCPDAO BaixaCPDAO = new BaixaCPDAO();
		if (BaixaCPDAO.insertBaixaCP(Baixa)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Baixa de conta cadastrada com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da Baixa!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		Baixa = new BaixaCP();

		return "";
	}

	public void listarBaixa() {
		BaixaCPDAO BaixaCPDAO = new BaixaCPDAO();
		setListabaixa(BaixaCPDAO.listBaixa());
	}

	public BaixaCP getBaixa() {
		return Baixa;
	}

	public void setBaixa(BaixaCP baixa) {
		Baixa = baixa;
	}

	public List<BaixaCP> getListabaixa() {
		return Listabaixa;
	}

	public void setListabaixa(List<BaixaCP> listabaixa) {
		Listabaixa = listabaixa;
	}


}
