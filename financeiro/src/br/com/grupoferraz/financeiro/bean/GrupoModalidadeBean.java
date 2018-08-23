package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoModalidadeDAO;
import br.com.grupoferraz.financeiro.entity.GrupoModalidade;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoModalidadeBean implements Serializable {

	private GrupoModalidade grupomodalidade;
	private List<GrupoModalidade> listagrupomodalidade;

	public GrupoModalidadeBean() {
		grupomodalidade = new GrupoModalidade();
		listaGrupoModalidade();
	}

	// método que cadastra os grupos das modalidades
	public String cadastraGrupoModalidade() {

		ConexaoBD.getConexao();
		GrupoModalidadeDAO grupomodalidade = new GrupoModalidadeDAO();
		if (grupomodalidade.insertGrupoModalidade(this.grupomodalidade)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo de Modalidade cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));
			return "";

		}
		ConexaoBD.fecharConexao();
		this.grupomodalidade = new GrupoModalidade();
		listaGrupoModalidade();
		return "";
	}

	// método que lista os grupos de modalidades
	public void listaGrupoModalidade() {
		GrupoModalidadeDAO grupomodalidade = new GrupoModalidadeDAO();
		listagrupomodalidade = grupomodalidade.listGrupoModalidade();
	}

	// método que deleta os grupos de modalidades
	public String deletaGrupoModalidade() {

		// ConexaoBD.getConexao();
		GrupoModalidadeDAO grupoModalidadeDAO = new GrupoModalidadeDAO();
		try {
			if (grupoModalidadeDAO.deleteGrupoModalidade(grupomodalidade.getCodigo())) {
				listagrupomodalidade.remove(grupomodalidade);
				JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo de Modalidade deletado com sucesso!");
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro ao deletar, esse grupo pode estar vinculado à uma modalidade.", "Erro!"));
				return "";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ConexaoBD.fecharConexao();
		this.grupomodalidade = new GrupoModalidade();
		listaGrupoModalidade();
		return "";
	}

	public GrupoModalidade getGrupomodalidade() {
		return grupomodalidade;
	}

	public void setGrupomodalidade(GrupoModalidade grupomodalidade) {
		this.grupomodalidade = grupomodalidade;
	}

	public List<GrupoModalidade> getListagrupomodalidade() {
		return listagrupomodalidade;
	}

	public void setListagrupomodalidade(List<GrupoModalidade> listagrupomodalidade) {
		this.listagrupomodalidade = listagrupomodalidade;
	}

}
