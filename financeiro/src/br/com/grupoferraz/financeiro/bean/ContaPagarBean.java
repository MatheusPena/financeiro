package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.DespesaDAO;
import br.com.grupoferraz.financeiro.dao.EstabelecimentoDAO;
import br.com.grupoferraz.financeiro.dao.ContaPagarDAO;
import br.com.grupoferraz.financeiro.dao.VencimentoPagarDAO;
import br.com.grupoferraz.financeiro.entity.Despesa;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.ContaPagar;
import br.com.grupoferraz.financeiro.entity.VencimentoPagar;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ContaPagarBean implements Serializable {

	private ContaPagar contapagar;
	private List<ContaPagar> listapagar;
	private VencimentoPagar vencimento;
	private List<VencimentoPagar> listavencimentos;
	

	public ContaPagarBean() {
		contapagar = new ContaPagar();
		getListapagar();
		listapagar();
		vencimento = new VencimentoPagar();
		listarVencimento();
	}

//	Cadastro do Contas a Pagar
	public String cadastraPagar() {
		
		ContaPagarDAO pagarconta = new ContaPagarDAO ();
		if (pagarconta.insertContasPagar(contapagar)) {
			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Conta cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da conta!", "Erro!"));
		return "";
		}
		contapagar = new ContaPagar();
		
		cadastraVencimento();
		return "";
	}
	
	public void listapagar() {
		ContaPagarDAO pagarconta = new ContaPagarDAO();
		setListapagar(pagarconta.listapagar());
	}
	
// Autocomplete referente ao estabelecimento
	public List<Estabelecimento> completeText2(String query) {
		
		List<Estabelecimento> lista = new ArrayList<>();
		String cnpj = null;
		if (contapagar != null) {
			cnpj = contapagar.getEmpresa_cnpj();
			EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
			lista.addAll(estabelecimentoDAO.listaestabelecimento(query, cnpj));
		}

        return lista; 
    }
	
	public void selecionar() {
		Estabelecimento estabelecimento = contapagar.getEstabelecimento();
		EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
		if (estabelecimento != null) {
			Estabelecimento estabelecimentos = estabelecimentoDAO.listaestabelecimento(estabelecimento.getCodigo());
			if (estabelecimentos != null) {
				contapagar.setEstabelecimento_nome(estabelecimentos.getNome());
				contapagar.setEstabelecimento_codigo(estabelecimentos.getCodigo());
			}
		}

	}
	
	
//	Autocomplete referente à Despesas
	public List<Despesa> completeText(String query) {
		DespesaDAO despesasDAO = new DespesaDAO();

		return despesasDAO.listadespesas(query);
	}


	public void selecionarDespesa() {
		
		Despesa despesa = contapagar.getDespesa();
		
		if (despesa != null) {
			contapagar.setCodigodp(despesa.getCodigo());
			contapagar.setNomedp(despesa.getNome());
		}
		System.out.println("despesa "+despesa.getNome());
	}
	
	
// 	Getters e Setters do Conta a Pagar
	public ContaPagar getPagarconta() {
		return contapagar;
	}

	public void setPagarconta(ContaPagar pagarconta) {
		this.contapagar = pagarconta;
	}

	public List<ContaPagar> getListapagar() {
		return listapagar;
	}

	public void setListapagar(List<ContaPagar> listapagar) {
		this.listapagar = listapagar;
	}


//	Cadastro do Vencimento
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
		setListavencimento(vencimento.listVencimento());
	}

	
// 	Getters e Setters do Vencimento
	public VencimentoPagar getVencimentoPagar() {
		return vencimento;
	}

	public void setVencimentoPagar(VencimentoPagar vencimento) {
		this.vencimento = vencimento;
	}

	public List<VencimentoPagar> getListavencimentos() {
		return listavencimentos;
	}

	public void setListavencimento(List<VencimentoPagar> listavencimento) {
		this.listavencimentos = listavencimento;
	}


}
