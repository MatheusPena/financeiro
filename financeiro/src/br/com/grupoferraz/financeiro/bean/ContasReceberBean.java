package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.ContasReceberDAO;
import br.com.grupoferraz.financeiro.entity.ContasReceber;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ContasReceberBean implements Serializable {
	private ContasReceber contasreceber;
	private List<ContasReceber> ContasReceber;

	public ContasReceberBean() {
		contasreceber = new ContasReceber();
		getcontasrecebers();
	}

	public String cadastracontasreceber() {

		ConexaoBD.getConexao();
		ContasReceberDAO contasrecebers = new ContasReceberDAO();
		if (contasrecebers.insertContasReceber(contasreceber)) {
			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Conta cadastrada com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da conta!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		contasreceber = new ContasReceber();

		return "";
	}

	public void getcontasrecebers() {
		ContasReceberDAO contasrecebers = new ContasReceberDAO();
		ContasReceber = contasrecebers.listContasReceber();
	}

	public ContasReceber getContasreceber() {
		return contasreceber;
	}

	public void setContasreceber(ContasReceber contasreceber) {
		this.contasreceber = contasreceber;
	}

	public List<ContasReceber> getContasReceber() {
		return ContasReceber;
	}

	public void setContasReceber(List<ContasReceber> contasReceber) {
		ContasReceber = contasReceber;
	}

}
