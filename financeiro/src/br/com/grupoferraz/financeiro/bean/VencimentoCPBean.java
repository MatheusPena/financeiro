package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.VencimentoCPDAO;
import br.com.grupoferraz.financeiro.entity.VencimentoCP;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class VencimentoCPBean implements Serializable {

	private VencimentoCP vencimento;
	private List<VencimentoCP> vencimentolista;

	public VencimentoCPBean() {
		vencimento = new VencimentoCP();
		listarVencimento();
	}

	public String cadastraVencimento() {

		ConexaoBD.getConexao();
		VencimentoCPDAO vencimento = new VencimentoCPDAO();
		if (vencimento.insertVencimento(this.vencimento)) {

			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Vencimento de conta cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do vencimento!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		this.vencimento = new VencimentoCP();

		return "";
	}
	
	
	public void listarVencimento() {
		VencimentoCPDAO vencimento = new VencimentoCPDAO();
		setVencimento(vencimento.listVencimento());
	}

	
	public List<VencimentoCP> getVencimento() {
		return vencimentolista;
	}

	public void setVencimento(List<VencimentoCP> vencimento) {
		this.vencimentolista = vencimento;
	}

	public VencimentoCP getVencimentoPagar() {
		return vencimento;
	}

	public void setVencimentoPagar(VencimentoCP vencimento) {
		this.vencimento = vencimento;
	}


}