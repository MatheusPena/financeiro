package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.VencimentoPagarDAO;
import br.com.grupoferraz.financeiro.entity.VencimentoPagar;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class VencimentoPagarBean implements Serializable {

	private VencimentoPagar vencimento;
	private List<VencimentoPagar> vencimentolista;

	public VencimentoPagarBean() {
		vencimento = new VencimentoPagar();
		listarVencimento();
	}

	public String cadastraVencimento() {

		ConexaoBD.getConexao();
		VencimentoPagarDAO vencimento = new VencimentoPagarDAO();
		if (vencimento.insertVencimento(this.vencimento)) {

			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Vencimento de conta cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do vencimento!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		this.vencimento = new VencimentoPagar();

		return "";
	}
	
	
	public void listarVencimento() {
		VencimentoPagarDAO vencimento = new VencimentoPagarDAO();
		setVencimento(vencimento.listVencimento());
	}

	
	public List<VencimentoPagar> getVencimento() {
		return vencimentolista;
	}

	public void setVencimento(List<VencimentoPagar> vencimento) {
		this.vencimentolista = vencimento;
	}

	public VencimentoPagar getVencimentoPagar() {
		return vencimento;
	}

	public void setVencimentoPagar(VencimentoPagar vencimento) {
		this.vencimento = vencimento;
	}


}