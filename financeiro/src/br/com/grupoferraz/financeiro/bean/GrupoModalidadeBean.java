package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
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
		getGrupoModalidadeDAO();
	}

	//cadastra o grupo da modalidade
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

		return "";
	}

	public void getGrupoModalidadeDAO() {
		GrupoModalidadeDAO grupomodalidade = new GrupoModalidadeDAO();
		listagrupomodalidade = grupomodalidade.listGrupoModalidade();
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
