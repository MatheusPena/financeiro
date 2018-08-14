package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.BaixaDiversoCRDAO;
import br.com.grupoferraz.financeiro.dao.ContaReceberDAO;
import br.com.grupoferraz.financeiro.entity.BaixaDiversoCR;
import br.com.grupoferraz.financeiro.entity.ContaReceber;
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

	// lista a lista do autocomplete no campo despesas
	public List<ContaReceber> complete(String query) {
		ContaReceberDAO conta = new ContaReceberDAO();

		return conta.listContasReceber(query);
	}

	// seleciona um dos objetos da lista no campo despesas
	public void selecionarNome() {
		ContaReceber conta = BaixaDiversoCR.getConta();

		if (conta != null) {
			BaixaDiversoCR.setContareceber_codigo(conta.getCodigo());
			BaixaDiversoCR.setContareceber_cpf(conta.getCpf());
			BaixaDiversoCR.setEmissao(conta.getEmissao());
			BaixaDiversoCR.setEmpresa_cnpj(conta.getEmpresa_cnpj());
			BaixaDiversoCR.setContareceber_estabelecimento_codigo(conta.getEstabelecimento_codigo());
			BaixaDiversoCR.setDocumento(conta.getDocumento());
			BaixaDiversoCR.setVencimento(conta.getVencimentodiverso().getVencimento());
			BaixaDiversoCR.setTitulo(conta.getVencimentodiverso().getTitulo());
			BaixaDiversoCR.setValor(conta.getVencimentodiverso().getValor());
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
