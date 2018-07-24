package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoVendedorDAO;
import br.com.grupoferraz.financeiro.entity.GrupoVendedor;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoVendedorBean implements Serializable {

	private GrupoVendedor grupovendedor;
	private List<GrupoVendedor> listagrupovendedor;

	public GrupoVendedorBean() {
		grupovendedor = new GrupoVendedor();
		listargrupovendedor();
	}
	
	//cadastra um grupo exibindo uma mensagem
	public String cadastragrupovendedor() {

		ConexaoBD.getConexao();
		GrupoVendedorDAO grupovendedor = new GrupoVendedorDAO ();
		if (grupovendedor.insertGrupoVendedor(this.grupovendedor)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo de Vendedores cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}
	
	//lista os grupos existentes na tabela
	public void listargrupovendedor()  {
		GrupoVendedorDAO grupovendedorDAO = new GrupoVendedorDAO ();
		listagrupovendedor = grupovendedorDAO.listGrupoVendedores();
	}

	public GrupoVendedor getgrupovendedor() {
		return grupovendedor;
	}

	public void setgrupovendedor(GrupoVendedor grupovendedor) {
		this.grupovendedor = grupovendedor;
	}

	public List<GrupoVendedor> getListagrupovendedor() {
		return listagrupovendedor;
	}

	public void setListagrupovendedor(List<GrupoVendedor> listagrupovendedor) {
		this.listagrupovendedor = listagrupovendedor;
	}


	
}