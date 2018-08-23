package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoServicoDAO;
import br.com.grupoferraz.financeiro.entity.GrupoServico;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoServicoBean implements Serializable {

	private GrupoServico gruposervico;
	private List<GrupoServico> listagruposervico;

	public GrupoServicoBean() {
		gruposervico = new GrupoServico();
		listaGrupoServico();
	}

	// m�todo que cadastra os grupos de servi�os
	public String cadastraGrupoServico() {

		ConexaoBD.getConexao();
		GrupoServicoDAO gruposervico = new GrupoServicoDAO();
		if (gruposervico.insertGrupoServico(this.gruposervico)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo de Servi�o cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));
			return "";

		}
		ConexaoBD.fecharConexao();
		this.gruposervico = new GrupoServico();
		listaGrupoServico();
		return "";
	}

	// m�todo que lista os grupos de servi�os
	public void listaGrupoServico() {
		GrupoServicoDAO grupomodalidade = new GrupoServicoDAO();
		listagruposervico = grupomodalidade.listGrupoServico();
	}

	// m�todo que deleta os grupos de servi�os
	public String deletaGrupoServico() {

		// ConexaoBD.getConexao();
		GrupoServicoDAO grupoServico = new GrupoServicoDAO();
		try {
			if (grupoServico.deleteGrupoServico(gruposervico.getCodigo())) {
				listagruposervico.remove(gruposervico);
				JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo de Servi�o deletado com sucesso!");
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro ao deletar, esse grupo pode estar vinculado � um servi�o.", "Erro!"));
				return "";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ConexaoBD.fecharConexao();
		this.gruposervico = new GrupoServico();
		listaGrupoServico();
		return "";
	}

	public GrupoServico getGruposervico() {
		return gruposervico;
	}

	public void setGruposervico(GrupoServico gruposervico) {
		this.gruposervico = gruposervico;
	}

	public List<GrupoServico> getListagruposervico() {
		return listagruposervico;
	}

	public void setListagruposervico(List<GrupoServico> listagruposervico) {
		this.listagruposervico = listagruposervico;
	}

}
