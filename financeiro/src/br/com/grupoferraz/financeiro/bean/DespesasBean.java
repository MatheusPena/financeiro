package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.DespesasDAO;
import br.com.grupoferraz.financeiro.entity.Despesas;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DespesasBean implements Serializable {

	private Despesas despesas;
	private List<Despesas> listadespesa;

	public DespesasBean() {
		despesas = new Despesas();
		listarDespesas();
	}

	public String cadastraDespesa() {

		ConexaoBD.getConexao();
		DespesasDAO despesa = new DespesasDAO();
		if (despesa.insertDespesas(this.despesas)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Despesa cadastrada com sucesso!", "Sucesso!"));
			// JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Estabelecimento
			// cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da despesa!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		despesas = new Despesas();

		return "";
	}

	public void listarDespesas() {
		DespesasDAO despesa = new DespesasDAO();
		setDespesa(despesa.listadespesa());
	}

	public Despesas getDespesas() {
		return despesas;
	}

	public List<Despesas> getListadespesa() {
		return listadespesa;
	}

	public void setDespesa(List<Despesas> despesa) {
		this.listadespesa = despesa;
	}

	public void setListadespesa(List<Despesas> listadespesa) {
		this.listadespesa = listadespesa;
	}

	
}