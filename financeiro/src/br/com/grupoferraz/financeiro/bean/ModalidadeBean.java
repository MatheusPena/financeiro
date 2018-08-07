package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.ModalidadeDAO;
import br.com.grupoferraz.financeiro.entity.Modalidade;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ModalidadeBean implements Serializable {

	private Modalidade modalidade;
	private List<Modalidade> listamodalidade;

	public ModalidadeBean() {
		modalidade = new Modalidade();
		getModalidadeDAO();
	}

	// cadastra o grupo da modalidade
	public String cadastraModalidade() {

		ConexaoBD.getConexao();
		ModalidadeDAO modalidade = new ModalidadeDAO();
		if (modalidade.insertModalidade(this.modalidade)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Modalidade cadastrada com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));
			return "";

		}
		ConexaoBD.fecharConexao();
		this.modalidade = new Modalidade();
		return "";
	}

	public void getModalidadeDAO() {
		ModalidadeDAO modalidade = new ModalidadeDAO();
		listamodalidade = modalidade.listModalidade();
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public List<Modalidade> getListamodalidade() {
		return listamodalidade;
	}

	public void setListamodalidade(List<Modalidade> listamodalidade) {
		this.listamodalidade = listamodalidade;
	}

}
