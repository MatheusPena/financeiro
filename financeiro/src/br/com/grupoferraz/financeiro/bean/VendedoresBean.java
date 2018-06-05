package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.VendedoresDAO;
import br.com.grupoferraz.financeiro.entity.Vendedores;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class VendedoresBean implements Serializable {
	private Vendedores vendedores = new Vendedores();
	private List<Vendedores> vendedor = new ArrayList<>();

	public VendedoresBean() {
		vendedores = new Vendedores();
	}

	public String cadastrar() {
		vendedor.add(vendedores);
		ConexaoBD.getConexao();
		VendedoresDAO vendedoresDAO = new VendedoresDAO();
		if (vendedoresDAO.salvar(vendedores)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro de usuário!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public Vendedores getVendedores() {
		return vendedores;
	}

	public void setVendedores(Vendedores vendedores) {
		this.vendedores = vendedores;
	}

	public List<Vendedores> getVendedor() {
		return vendedor;
	}

	public void setVendedor(List<Vendedores> vendedor) {
		this.vendedor = vendedor;
	}

}
