package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.DespesaDAO;
import br.com.grupoferraz.financeiro.entity.Despesa;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DespesaBean implements Serializable {

	private Despesa despesa;
	private List<Despesa> listadespesas;

	public DespesaBean() {
		despesa = new Despesa();
		listarDespesas();
	}

	public String cadastraDespesa() {

		DespesaDAO despesa = new DespesaDAO();
		if (despesa.insertDespesas(this.despesa)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Despesa cadastrada com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da despesa!", "Erro!"));
			return "";
		}

		this.despesa = new Despesa();

		return "cadastro_despesa?faces-redirect=true";
	}

	public void listarDespesas() {
		DespesaDAO despesa = new DespesaDAO();
		setListadespesas(despesa.listadespesa());
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public void setListadespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public List<Despesa> getListadespesas() {
		return listadespesas;
	}

	public void setListadespesas(List<Despesa> listadespesas) {
		this.listadespesas = listadespesas;
	}


}