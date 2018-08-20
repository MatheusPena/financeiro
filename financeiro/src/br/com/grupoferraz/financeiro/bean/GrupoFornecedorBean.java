package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoFornecedorDAO;
import br.com.grupoferraz.financeiro.entity.GrupoFornecedor;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoFornecedorBean implements Serializable {

	private GrupoFornecedor grupofornecedor;
	private List<GrupoFornecedor> grupofornecedores;

	public GrupoFornecedorBean() {
		grupofornecedor = new GrupoFornecedor();
		listaGrupoFornecedores();
	}

	// método que cadastra os grupos de fornecedores
	public String cadastraGrupofornecedor() {

		GrupoFornecedorDAO grupofornecedores = new GrupoFornecedorDAO();
		if (grupofornecedores.insertGrupoFornecedor(grupofornecedor)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo fornecedor cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo", "Erro!"));
			return "";
		}

		this.grupofornecedor = new GrupoFornecedor();
		listaGrupoFornecedores();
		return "";
	}

	// método que lista os grupos de fornecedores
	public void listaGrupoFornecedores() {
		GrupoFornecedorDAO grupofornecedoresDAO = new GrupoFornecedorDAO();
		grupofornecedores = grupofornecedoresDAO.listGrupoFornecedores();
	}

	// método que deleta os grupos de fornecedores
	public String deletaGrupoFornecedor() {

		// ConexaoBD.getConexao();
		GrupoFornecedorDAO grupoFornecedorDAO = new GrupoFornecedorDAO();
		try {
			if (grupoFornecedorDAO.deleteGrupoFornecedor(grupofornecedor.getCodigo())) {
				grupofornecedores.remove(grupofornecedor);
				JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo de Fornecedor deletado com sucesso!");
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro ao deletar, esse grupo pode estar vinculado à um fornecedor.", "Erro!"));
				return "";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ConexaoBD.fecharConexao();
		this.grupofornecedor = new GrupoFornecedor();
		listaGrupoFornecedores();
		return "";
	}

	public GrupoFornecedor getGrupofornecedor() {
		return grupofornecedor;
	}

	public void setGrupofornecedor(GrupoFornecedor grupofornecedor) {
		this.grupofornecedor = grupofornecedor;
	}

	public List<GrupoFornecedor> getGrupofornecedores() {
		return grupofornecedores;
	}

	public void setGrupofornecedores(List<GrupoFornecedor> grupofornecedores) {
		this.grupofornecedores = grupofornecedores;
	}

}