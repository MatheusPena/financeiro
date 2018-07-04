package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.grupoferraz.financeiro.dao.DespesasDAO;
import br.com.grupoferraz.financeiro.dao.PagarDAO;
import br.com.grupoferraz.financeiro.entity.Despesas;
import br.com.grupoferraz.financeiro.entity.Pagar;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PagarBean implements Serializable {

	private Pagar contapagar;
	private List<Pagar> listapagar;

	public PagarBean() {
		contapagar = new Pagar();
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
	
	public List<Integer> completeText(String query) {
		DespesasDAO despesasDAO = new DespesasDAO();
		
		
        //List<String> results = new ArrayList<String>();
        //for(int i = 0; i < 10; i++) {
//            results.add(query + i);
//        }
         
        return despesasDAO.listadespesa(query); 
    }
	
	public void onItemSelect(SelectEvent event) {
        String obj = event.getObject().toString();
    	DespesasDAO despesasDAO = new DespesasDAO();
    	Despesas despesa = despesasDAO .listadespesa(Integer.valueOf(obj));
    	if (despesa != null) {
    		contapagar.setValor(despesa.getValor());
    		contapagar.setEmissaodp(despesa.getEmissao());
    	}
    	
    }
	
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

}