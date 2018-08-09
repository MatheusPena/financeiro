package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.BaixaDiversoCRDAO;
import br.com.grupoferraz.financeiro.dao.EstabelecimentoDAO;
import br.com.grupoferraz.financeiro.entity.BaixaDiversoCR;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BaixaDiversoCRBean implements Serializable {
	private BaixaDiversoCR BaixaDiversoCR;
	private List<BaixaDiversoCR> listaBaixaDiversosCR;

	public BaixaDiversoCRBean() {
		BaixaDiversoCR = new BaixaDiversoCR();
		getBaixaDiverso();
	}

	// cadastra baixa diversos CR
	public String cadastraBaixaDiversoCR() {

		ConexaoBD.getConexao();
		BaixaDiversoCRDAO BaixaDiversoCRDAO = new BaixaDiversoCRDAO();
		if (BaixaDiversoCRDAO.insertBaixaDiversoCR(BaixaDiversoCR)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Baixa cadastrada com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da baixa!", "Erro!"));
			return "";
		}
		ConexaoBD.fecharConexao();
		this.BaixaDiversoCR = new BaixaDiversoCR();

		return "";
	}

	public void getBaixaDiverso() {
		BaixaDiversoCRDAO BaixaDiversosCRs = new BaixaDiversoCRDAO();
		listaBaixaDiversosCR = BaixaDiversosCRs.listBaixaDiversoCR();
	}

	// lista a lista do autocomplete no campo estabelecimento
	public List<Estabelecimento> completeText(String query) {

		List<Estabelecimento> lista = new ArrayList<>();
		String cnpj = BaixaDiversoCR.getEmpresa_cnpj();
		System.out.println(cnpj);
		if (cnpj != null) {
			EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
			lista.addAll(estabelecimentoDAO.listaestabelecimento(query, cnpj));
		}

		return lista;
	}

	// seleciona um dos objetos da lista no campo estabelecimento
	public void selecionar() {

		Estabelecimento estabelecimento = BaixaDiversoCR.getEstabelecimento();

		if (estabelecimento != null) {
			BaixaDiversoCR.setContareceber_estabelecimento_codigo(estabelecimento.getCodigo());
		}

	}

	public BaixaDiversoCR getBaixaDiversoCR() {
		return BaixaDiversoCR;
	}

	public void setBaixaDiversoCR(BaixaDiversoCR baixaDiversoCR) {
		BaixaDiversoCR = baixaDiversoCR;
	}

	public List<BaixaDiversoCR> getListaBaixaDiversosCR() {
		return listaBaixaDiversosCR;
	}

	public void setListaBaixaDiversosCR(List<BaixaDiversoCR> listaBaixaDiversosCR) {
		this.listaBaixaDiversosCR = listaBaixaDiversosCR;
	}

}
