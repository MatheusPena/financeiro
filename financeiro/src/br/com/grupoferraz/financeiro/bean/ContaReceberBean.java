package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.ContaReceberDAO;
import br.com.grupoferraz.financeiro.dao.EstabelecimentoDAO;
import br.com.grupoferraz.financeiro.dao.PlanoContaDAO;
import br.com.grupoferraz.financeiro.entity.ContaReceber;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.PlanoConta;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ContaReceberBean implements Serializable {
	private ContaReceber contaReceber;
	private List<ContaReceber> ContasReceber;
	private List<Estabelecimento> estabelecimentos;
	private String cnpj;

	public ContaReceberBean() {
		contaReceber = new ContaReceber();
		getcontaReceber();
	}

	// cadastra uma conta no banco de dados
	public String cadastraContaReceber() {

		ConexaoBD.getConexao();
		ContaReceberDAO contasrecebers = new ContaReceberDAO();
		if (contasrecebers.insertContaReceber(contaReceber)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Conta cadastrada com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da conta!", "Erro!"));
			return "";
		}
		ConexaoBD.fecharConexao();
		contaReceber = new ContaReceber();

		return "";
	}

	public void getcontaReceber() {
		ContaReceberDAO contareceber = new ContaReceberDAO();
		ContasReceber = contareceber.listContasReceber();
	}

	// lista a lista do autocomplete dos estabelecimentos existentes no banco
	public void listarEstabelecimentos() {
		EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
		cnpj = contaReceber.getEmpresa_cnpj();
		if (cnpj != null) {
			try {
				estabelecimentos = estabelecimentoDAO.getEstabelecimento(cnpj);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			estabelecimentos = new ArrayList<>();
		}

		// estabelecimentos = estabelecimentoDAO.listEstabelecimentos();
	}

	// lista a lista do autocomplete no campo estabelecimento
	public List<Estabelecimento> completeText(String query) {
		EstabelecimentoDAO EstabelecimentoDAO = new EstabelecimentoDAO();

		String cnpj = contaReceber.getEmpresa_cnpj();
		return EstabelecimentoDAO.listaestabelecimento(query, cnpj);
	}

	// seleciona um dos objetos da lista no campo estabelecimento
	public void selecionar() {

		Estabelecimento estabelecimento = contaReceber.getEstabelecimento();

		if (estabelecimento != null) {
			contaReceber.setEstabelecimento_codigo(estabelecimento.getCodigo());
		}

	}

	// lista a lista do autocomplete no campo despesas
	public List<PlanoConta> completeReceita(String query) {
		PlanoContaDAO planoConta = new PlanoContaDAO();

		return planoConta.listaplano(query);
	}

	// seleciona um dos objetos da lista no campo despesas
	public void selecionarReceita() {
		PlanoConta plano = contaReceber.getPlanoconta();

		if (plano != null) {
			contaReceber.setReceita_codigo(plano.getCodigo());
		}

	}

	public ContaReceber getContaReceber() {
		return contaReceber;
	}

	public void setContaReceber(ContaReceber contaReceber) {
		this.contaReceber = contaReceber;
	}

	public List<ContaReceber> getContasReceber() {
		return ContasReceber;
	}

	public void setContasReceber(List<ContaReceber> contasReceber) {
		ContasReceber = contasReceber;
	}

	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
