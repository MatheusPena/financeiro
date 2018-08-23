package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.SQLException;
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
		listagrupovendedor();
	}

	// método que cadastra os grupos de vendedores
	public String cadastragrupovendedor() {

		GrupoVendedorDAO grupovendedor = new GrupoVendedorDAO();
		if (grupovendedor.insertGrupoVendedor(this.grupovendedor)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo de Vendedor cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));
			return "";
		}

		this.grupovendedor = new GrupoVendedor();
		listagrupovendedor();
		return "";

	}

	// método que lista os grupos de vendedores
	public void listagrupovendedor() {
		GrupoVendedorDAO grupovendedorDAO = new GrupoVendedorDAO();
		listagrupovendedor = grupovendedorDAO.listGrupoVendedores();
	}

	// método que deleta os grupos de vendedores
	public String deletaGrupoVendedor() {

		// ConexaoBD.getConexao();
		GrupoVendedorDAO grupoVendedor = new GrupoVendedorDAO();
		try {
			if (grupoVendedor.deleteGrupoVendedor(grupovendedor.getCodigo())) {
				listagrupovendedor.remove(grupovendedor);
				JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo de Vendedor deletado com sucesso!");
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro ao deletar, esse grupo pode estar vinculado à um vendedor.", "Erro!"));
				return "";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ConexaoBD.fecharConexao();
		this.grupovendedor = new GrupoVendedor();
		listagrupovendedor();
		return "";
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