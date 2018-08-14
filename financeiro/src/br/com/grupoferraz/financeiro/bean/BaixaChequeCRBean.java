package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.BaixaChequeCRDAO;
import br.com.grupoferraz.financeiro.dao.ContaReceberDAO;
import br.com.grupoferraz.financeiro.entity.BaixaChequeCR;
import br.com.grupoferraz.financeiro.entity.ContaReceber;
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

	public void getBaixaChequeCRs() {
		BaixaChequeCRDAO BaixaChequeCRs = new BaixaChequeCRDAO();
		listaBaixaChequeCR = BaixaChequeCRs.listBaixaChequeCR();
	}

	// lista a lista do autocomplete no campo despesas
	public List<ContaReceber> complete(String query) {
		ContaReceberDAO conta = new ContaReceberDAO();

		return conta.listContasReceber(query);
	}

	// seleciona um dos objetos da lista no campo despesas
	public void selecionarNome() {
		ContaReceber conta = BaixaChequeCR.getConta();

		if (conta != null) {
			BaixaChequeCR.setContareceber_codigo(conta.getCodigo());
			BaixaChequeCR.setContareceber_cpf(conta.getCpf());
			BaixaChequeCR.setEmissao(conta.getEmissao());
			BaixaChequeCR.setEmpresa_cnpj(conta.getEmpresa_cnpj());
			BaixaChequeCR.setContareceber_estabelecimento_codigo(conta.getEstabelecimento_codigo());
			BaixaChequeCR.setDocumento(conta.getDocumento());
			BaixaChequeCR.setVencimento(conta.getVencimentodiverso().getVencimento());
			BaixaChequeCR.setCheque(conta.getVencimentodiverso().getTitulo());
			BaixaChequeCR.setValor(conta.getVencimentodiverso().getValor());
		}

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
