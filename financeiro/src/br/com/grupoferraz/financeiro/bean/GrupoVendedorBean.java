package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.GrupoVendedorDAO;
import br.com.grupoferraz.financeiro.entity.GrupoVendedor;
import br.com.grupoferraz.financeiro.util.JSFUtil;

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

	// cadastra um grupo exibindo uma mensagem
	public String cadastragrupovendedor() {

		GrupoVendedorDAO grupovendedor = new GrupoVendedorDAO();
		if (grupovendedor.insertGrupoVendedor(this.grupovendedor)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo vendedor cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));
			return "";
		}

		this.grupovendedor = new GrupoVendedor();

		return "grupo_vendedor?faces-redirect=true";

	}

	// lista os grupos existentes na tabela
	public void listargrupovendedor() {
		GrupoVendedorDAO grupovendedorDAO = new GrupoVendedorDAO();
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