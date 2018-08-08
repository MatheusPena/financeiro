package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.ClienteDAO;
import br.com.grupoferraz.financeiro.dao.DespesaReceitaDAO;
import br.com.grupoferraz.financeiro.entity.Cliente;
import br.com.grupoferraz.financeiro.entity.DespesaReceita;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private Cliente cliente;
	private List<Cliente> listaclientes;

	public ClienteBean() {
		cliente = new Cliente();
		getClientesDAO();
	}

	public String cadastraCliente() {

		ConexaoBD.getConexao();
		ClienteDAO clientesDAO = new ClienteDAO ();
		if (clientesDAO.insertCliente(cliente)) {
			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Cliente cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do cliente!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		cliente = new Cliente();

		return "";
	}

//	Autocomplete referente à Receitas
	public List<DespesaReceita> completeText(String query) {
		DespesaReceitaDAO despesareceitaDAO = new DespesaReceitaDAO();

		return despesareceitaDAO.listadespesareceitas(query);
	}


	public void selecionarReceita() {
		
		DespesaReceita receita = cliente.getReceita(); 
		
		if (receita != null) {
			cliente.setCodigorec(receita.getCodigo());
			cliente.setNomerec(receita.getNome()); 
		}

	}
	
//	Getters e Setters
	public void getClientesDAO()  {
		ClienteDAO clientesDAO = new ClienteDAO ();
		listaclientes = clientesDAO.listClientes();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaclientes() {
		return listaclientes;
	}

	public void setListaclientes(List<Cliente> listaclientes) {
		this.listaclientes = listaclientes;
	}
}