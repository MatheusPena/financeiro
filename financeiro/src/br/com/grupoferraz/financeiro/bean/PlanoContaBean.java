package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.DespesaReceitaDAO;
import br.com.grupoferraz.financeiro.dao.PlanoContaDAO;
import br.com.grupoferraz.financeiro.entity.DespesaReceita;
import br.com.grupoferraz.financeiro.entity.PlanoConta;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PlanoContaBean implements Serializable {
	private PlanoConta planoConta;
	private List<PlanoConta> planoContas;

	public PlanoContaBean() {
		planoConta = new PlanoConta();
		listarPlanoContas();
	}

	// cadastro um plano de contas no banco exibindo uma mensagem
	public String cadastraPlanoConta() {

		PlanoContaDAO PlanoContaDAO = new PlanoContaDAO();
		if (PlanoContaDAO.insertPlanoContas(this.planoConta)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Plano de Conta cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do Plano de Conta!", "Erro!"));
			return "";

		}
		
		this.planoConta = new PlanoConta();
		return "";
	}

	// lista a lista do autocomplete no campo despesas/receitas
	public List<DespesaReceita> completeText(String query) {
		DespesaReceitaDAO despesareceitaDAO = new DespesaReceitaDAO();

		return despesareceitaDAO.listadespesareceitas(query);
	}

	// seleciona um dos objetos da lista no campo despesas/receitas
	public void selecionar() {

		DespesaReceita despesareceita = planoConta.getDespesareceita();

		if (despesareceita != null) {
			planoConta.setDespesareceita_codigo(despesareceita.getCodigo());
			planoConta.setGrupodespesareceita_codigo(despesareceita.getGrupodespesareceita_codigo());
		}

	}

	// lista os planos de contas existentes no banco na tabela
	public void listarPlanoContas() {
		PlanoContaDAO PlanoConta = new PlanoContaDAO();
		setPlanoContas(PlanoConta.listPlanoContas());
	}

	public PlanoConta getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(PlanoConta planoConta) {
		this.planoConta = planoConta;
	}

	public List<PlanoConta> getPlanoContas() {
		return planoContas;
	}

	public void setPlanoContas(List<PlanoConta> planoContas) {
		this.planoContas = planoContas;
	}

}
