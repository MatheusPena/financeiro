package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.DespesaDAO;
import br.com.grupoferraz.financeiro.entity.Despesa;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DespesaBean implements Serializable {

	private Despesa despesa;
	private List<Despesa> listadespesa;

	public DespesaBean() {
		despesa = new Despesa();
		listarDespesas();
	}

	public String cadastraDespesa() {

		ConexaoBD.getConexao();
		DespesaDAO despesa = new DespesaDAO();
		if (despesa.insertDespesas(this.despesa)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Despesa cadastrada com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da despesa!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		this.despesa = new Despesa();

		return "";
	}

	public void listarDespesas() {
		DespesaDAO despesa = new DespesaDAO();
		setListadespesa(despesa.listadespesa());
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

	public List<Despesa> getListadespesa() {
		return listadespesa;
	}

	public void setListadespesa(List<Despesa> listadespesa) {
		this.listadespesa = listadespesa;
	}


}