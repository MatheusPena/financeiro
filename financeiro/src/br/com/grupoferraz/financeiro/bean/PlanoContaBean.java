package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.DespesaDAO;
import br.com.grupoferraz.financeiro.dao.PlanoContaDAO;
import br.com.grupoferraz.financeiro.entity.Despesa;
import br.com.grupoferraz.financeiro.entity.PlanoConta;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
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

		ConexaoBD.getConexao();
		PlanoContaDAO PlanoContass = new PlanoContaDAO();
		if (PlanoContass.insertPlanoContas(this.planoConta)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Plano de Conta cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do Plano de Conta!", "Erro!"));
			return "";

		}
		ConexaoBD.fecharConexao();

		this.planoConta = new PlanoConta();
		return "";
	}

	// lista a lista do autocomplete no campo despesas
	public List<Despesa> completeText(String query) {
		DespesaDAO despesasDAO = new DespesaDAO();

		return despesasDAO.listadespesas(query);
	}

	// seleciona um dos objetos da lista no campo despesas
	public void selecionar() {

		Despesa despesa = planoConta.getDespesa();

		if (despesa != null) {
			planoConta.setNome(despesa.getCodigo());
			planoConta.setGrupodespesa_codigo(despesa.getGrupodespesa_codigo());
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
