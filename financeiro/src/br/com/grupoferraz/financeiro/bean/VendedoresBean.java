package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.VendedoresDAO;
import br.com.grupoferraz.financeiro.entity.Vendedores;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class VendedoresBean implements Serializable {

	private Vendedores vendedores;
	private List<Vendedores> vendedor;

	public VendedoresBean() {
		vendedores = new Vendedores();
		listarVendedor();
	}

	public String cadastraVendedor() {

		ConexaoBD.getConexao();
		VendedoresDAO vendedor = new VendedoresDAO ();
		if (vendedor.insertVendedores(this.vendedores)) {

			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Vendedor cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do vendedor!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		vendedores = new Vendedores();

		return "";
	}

	public void listarVendedor()  {
		VendedoresDAO vendedor = new VendedoresDAO ();
		setVendedor(vendedor.listVendedores());
	}


	public List<Vendedores> getVendedor() {
		return vendedor;
	}

	public void setVendedor(List<Vendedores> vendedor) {
		this.vendedor = vendedor;
	}

	public Vendedores getVendedores() {
		return vendedores;
	}

	public void setVendedores(Vendedores vendedores) {
		this.vendedores = vendedores;
	}

	
}