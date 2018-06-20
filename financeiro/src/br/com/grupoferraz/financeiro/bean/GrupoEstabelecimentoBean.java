package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoEstabelecimentoDAO;
import br.com.grupoferraz.financeiro.entity.GrupoEstabelecimento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoEstabelecimentoBean implements Serializable {

	private GrupoEstabelecimento grupoestabelecimento;
	private List<GrupoEstabelecimento> listagrupoestabelecimento;


	public GrupoEstabelecimentoBean() {
		grupoestabelecimento = new GrupoEstabelecimento();
		listarGrupoEstabelecimento();
	}

	private void listarGrupoEstabelecimento()  {
		GrupoEstabelecimentoDAO grupoestabelecimentoDAO = new GrupoEstabelecimentoDAO ();
		listagrupoestabelecimento = grupoestabelecimentoDAO.listGrupoEstabelecimento();
		
		
	}

	public String cadastraGrupoEstabelecimento() {

		ConexaoBD.getConexao();
		GrupoEstabelecimentoDAO grupoestabelecimento = new GrupoEstabelecimentoDAO ();
		if (grupoestabelecimento.insertGrupoEstabelecimento(this.grupoestabelecimento)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo de Estabelecimento cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public GrupoEstabelecimento getGrupoestabelecimento() {
		return grupoestabelecimento;
	}

	public void setGrupoestabelecimento(GrupoEstabelecimento grupoestabelecimento) {
		this.grupoestabelecimento = grupoestabelecimento;
	}

	public List<GrupoEstabelecimento> getListagrupoestabelecimento() {
		return listagrupoestabelecimento;
	}

	public void setListagrupoestabelecimento(List<GrupoEstabelecimento> listagrupoestabelecimento) {
		this.listagrupoestabelecimento = listagrupoestabelecimento;
	}




	
}