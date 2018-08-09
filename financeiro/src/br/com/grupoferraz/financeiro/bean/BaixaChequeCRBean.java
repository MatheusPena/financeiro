package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.BaixaChequeCRDAO;
import br.com.grupoferraz.financeiro.dao.EstabelecimentoDAO;
import br.com.grupoferraz.financeiro.entity.BaixaChequeCR;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
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

	// cadastra a baixa
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

	// lista a lista do autocomplete no campo estabelecimento
	public List<Estabelecimento> completeText(String query) {

		List<Estabelecimento> lista = new ArrayList<>();
		String cnpj = BaixaChequeCR.getEmpresa_cnpj();
		System.out.println(cnpj);
		if (cnpj != null) {
			EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
			lista.addAll(estabelecimentoDAO.listaestabelecimento(query, cnpj));
		}

		return lista;
	}

	// seleciona um dos objetos da lista no campo estabelecimento
	public void selecionar() {

		Estabelecimento estabelecimento = BaixaChequeCR.getEstabelecimento();

		if (estabelecimento != null) {
			BaixaChequeCR.setContareceber_estabelecimento_codigo(estabelecimento.getCodigo());
		}

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
