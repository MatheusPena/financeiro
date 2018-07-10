package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.grupoferraz.financeiro.dao.DespesasDAO;
import br.com.grupoferraz.financeiro.dao.EstabelecimentoDAO;
import br.com.grupoferraz.financeiro.dao.PagarDAO;
import br.com.grupoferraz.financeiro.entity.Despesas;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.Pagar;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PagarBean implements Serializable {

	private Pagar contapagar;
	private List<Pagar> listapagar;
	//private Estabelecimento estabelecimento;

	public PagarBean() {
		contapagar = new Pagar();
		//estabelecimento = new Estabelecimento();
		getListapagar();
		listapagar();
	}

	public String cadastraPagar() {

		ConexaoBD.getConexao();
		PagarDAO pagarconta = new PagarDAO ();
		if (pagarconta.insertContasPagar(contapagar)) {
			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Conta cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da conta!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		contapagar = new Pagar();

		return "";
	}
	
	public void listapagar() {
		PagarDAO pagarconta = new PagarDAO();
		setListapagar(pagarconta.listapagar());
	}
	
//////////////////////////// LISTA DO AUTOCOMPLETE /////////////////////////
	public List<Integer> completeText(String query) {
		DespesasDAO despesasDAO = new DespesasDAO();
		
         
        return despesasDAO.listadespesa(query); 
    }
	
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
	
	
////////////////////////////LISTA DO AUTOCOMPLETE /////////////////////////
	
////////////////////////////SELECT DO AUTOCOMPLETE /////////////////////////
	public void onItemSelect(SelectEvent event) {
        String obj = event.getObject().toString();
    	DespesasDAO despesasDAO = new DespesasDAO();
    	Despesas despesa = despesasDAO .listadespesa(Integer.valueOf(obj));
    	if (despesa != null) {
    		contapagar.setNomedp(despesa.getNome());
    	}
    	
    }	
//	public void onItemSelect2(SelectEvent event) {
//        Estabelecimento obj = (Estabelecimento) event.getObject();
//        System.out.println("OBJ "+obj);
//        
//    	EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
//    	Estabelecimento estabelecimentos = estabelecimentoDAO .listaestabelecimento(obj.getCodigo());
//    	if (estabelecimentos != null) {
//    		contapagar.setEstabelecimento_nome(estabelecimentos.getNome());
//    	}
//    	
//    }
	
	public void selecionar() {
		Estabelecimento estabelecimento = contapagar.getEstabelecimento();
		System.out.println("ESTABELECIMENTO SELECIONADO "+estabelecimento);
    	EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
    	Estabelecimento estabelecimentos = estabelecimentoDAO .listaestabelecimento(estabelecimento.getCodigo());
    	if (estabelecimentos != null) {
    		contapagar.setEstabelecimento_nome(estabelecimentos.getNome());
    		contapagar.setEstabelecimento_codigo(estabelecimentos.getCodigo());
    	}
    }
	
	
	
	
////////////////////////////SELECT DO AUTOCOMPLETE /////////////////////////
	
	
	public Pagar getPagarconta() {
		return contapagar;
	}

	public void setPagarconta(Pagar pagarconta) {
		this.contapagar = pagarconta;
	}

	public List<Pagar> getListapagar() {
		return listapagar;
	}

	public void setListapagar(List<Pagar> listapagar) {
		this.listapagar = listapagar;
	}

//	public Estabelecimento getEstabelecimento() {
//		return estabelecimento;
//	}
//
//	public void setEstabelecimento(Estabelecimento estabelecimento) {
//		this.estabelecimento = estabelecimento;
//	}

}