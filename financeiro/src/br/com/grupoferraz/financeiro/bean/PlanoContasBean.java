package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.DespesaDAO;
import br.com.grupoferraz.financeiro.dao.PlanoContasDAO;
import br.com.grupoferraz.financeiro.entity.Despesa;
import br.com.grupoferraz.financeiro.entity.PlanoContas;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PlanoContasBean implements Serializable {
	private PlanoContas planoContas;
	private List<PlanoContas> planoContass;

	public PlanoContasBean() {
		planoContas = new PlanoContas();
		listarPlanoContass();
	}

	// cadastro um plano de contas no banco exibindo uma mensagem
	public String cadastraPlanoContass() {

		ConexaoBD.getConexao();
		PlanoContasDAO PlanoContass = new PlanoContasDAO();
		if (PlanoContass.insertPlanoContas(this.planoContas)) {
			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Plano de Contas cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do Plano de Contas!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	// lista a lista do autocomplete no campo despesas
	public List<Despesa> completeText(String query) {
		DespesaDAO despesasDAO = new DespesaDAO();

		return despesasDAO.listadespesas(query);
	}

	// seleciona um dos objetos da lista no campo despesas
	public void selecionar() {
		
		Despesa despesa = planoContas.getDespesa();
		
		if (despesa != null) {
			planoContas.setNome(despesa.getCodigo());
		}

	}

	// lista os planos de contas existentes no banco na tabela
	public void listarPlanoContass() {
		PlanoContasDAO PlanoContass = new PlanoContasDAO();
		setPlanoContass(PlanoContass.listPlanoContas());
	}

	public PlanoContas getPlanoContas() {
		return planoContas;
	}

	public void setPlanoContas(PlanoContas planoContas) {
		this.planoContas = planoContas;
	}

	public List<PlanoContas> getPlanoContass() {
		return planoContass;
	}

	public void setPlanoContass(List<PlanoContas> planoContass) {
		this.planoContass = planoContass;
	}

}
