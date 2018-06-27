package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.ContasFinanceirasDAO;
import br.com.grupoferraz.financeiro.entity.ContasFinanceiras;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class ContasFinanceirasBean implements Serializable {
	private ContasFinanceiras ContasFinanceiras;
	private List<ContasFinanceiras> contafinanceira;

	public ContasFinanceirasBean() {
		ContasFinanceiras = new ContasFinanceiras();
		listarcontafinanceira();
	}

	public String cadastracontafinanceira() {

		ConexaoBD.getConexao();
		ContasFinanceirasDAO contafinanceira = new ContasFinanceirasDAO();
		if (contafinanceira.insertContasFinanceiras(this.ContasFinanceiras)) {

			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Conta financeira cadastrada com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da conta financeira!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		ContasFinanceiras = new ContasFinanceiras();

		return "";
	}

	public void listarcontafinanceira() {
		ContasFinanceirasDAO contafinanceira = new ContasFinanceirasDAO();
		setcontafinanceira(contafinanceira.listContasFinanceiras());
	}

	public List<ContasFinanceiras> getcontafinanceira() {
		return contafinanceira;
	}

	public void setcontafinanceira(List<ContasFinanceiras> contafinanceira) {
		this.contafinanceira = contafinanceira;
	}

	public ContasFinanceiras getContasFinanceiras() {
		return ContasFinanceiras;
	}

	public void setContasFinanceiras(ContasFinanceiras ContasFinanceiras) {
		this.ContasFinanceiras = ContasFinanceiras;
	}
}
