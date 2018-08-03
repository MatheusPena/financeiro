package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.DespesaReceitaDAO;
import br.com.grupoferraz.financeiro.entity.DespesaReceita;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DespesaReceitaBean implements Serializable {

	private DespesaReceita despesareceita;
	private List<DespesaReceita> listadespesareceitas;

	public DespesaReceitaBean() {
		despesareceita = new DespesaReceita();
		listarDespesaReceitas();
	}

	public String cadastraDespesaReceita() {

		DespesaReceitaDAO despesareceitaDAO = new DespesaReceitaDAO();
		if (despesareceitaDAO.insertDespesaReceitas(this.despesareceita)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Despesa/Receita cadastrada com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da despesa/receita!", "Erro!"));
			return "";
		}

		this.despesareceita = new DespesaReceita();

		return "cadastro_despesareceita?faces-redirect=true";
	}

	public void listarDespesaReceitas() {
		DespesaReceitaDAO despesareceitaDAO = new DespesaReceitaDAO();
		setListadespesareceitas(despesareceitaDAO.listadespesareceitas());
	}

	public DespesaReceita getDespesareceita() {
		return despesareceita;
	}

	public void setDespesareceita(DespesaReceita despesareceita) {
		this.despesareceita = despesareceita;
	}

	public void setListadespesareceitas(DespesaReceita despesareceita) {
		this.despesareceita = despesareceita;
	}

	public List<DespesaReceita> getListadespesareceitas() {
		return listadespesareceitas;
	}

	public void setListadespesareceitas(List<DespesaReceita> listadespesareceitas) {
		this.listadespesareceitas = listadespesareceitas;
	}


}