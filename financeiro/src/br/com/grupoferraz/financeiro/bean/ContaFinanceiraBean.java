package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.ContaFinanceiraDAO;
import br.com.grupoferraz.financeiro.entity.ContaFinanceira;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class ContaFinanceiraBean implements Serializable {
	private ContaFinanceira ContaFinanceira;
	private List<ContaFinanceira> listacontasfinanceiras;

	public ContaFinanceiraBean() {
		ContaFinanceira = new ContaFinanceira();
		listarcontafinanceira();
	}

	public String cadastracontafinanceira() {

		ContaFinanceiraDAO contafinanceira = new ContaFinanceiraDAO();
		if (contafinanceira.insertContasFinanceiras(this.ContaFinanceira)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Conta financeira cadastrada com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da conta financeira!", "Erro!"));

			new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!");
			
			return "";
		}

		ContaFinanceira = new ContaFinanceira();
		return "cadastro_contafinanceira?faces-redirect=true";
		
	}

	public void listarcontafinanceira() {
		ContaFinanceiraDAO contafinanceira = new ContaFinanceiraDAO();
		listacontasfinanceiras = contafinanceira.listContasFinanceiras();
	}

	public ContaFinanceira getContaFinanceira() {
		return ContaFinanceira;
	}

	public void setContaFinanceira(ContaFinanceira ContasFinanceiras) {
		ContaFinanceira = ContasFinanceiras;
	}

	public List<ContaFinanceira> getListacontasfinanceiras() {
		return listacontasfinanceiras;
	}

	public void setListacontasfinanceiras(List<ContaFinanceira> listacontasfinanceiras) {
		this.listacontasfinanceiras = listacontasfinanceiras;
	}

}
