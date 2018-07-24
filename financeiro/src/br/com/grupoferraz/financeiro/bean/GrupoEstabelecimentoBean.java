package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoEstabelecimentoDAO;
import br.com.grupoferraz.financeiro.dao.UnidadeDAO;
import br.com.grupoferraz.financeiro.entity.GrupoEstabelecimento;
import br.com.grupoferraz.financeiro.entity.Unidade;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoEstabelecimentoBean implements Serializable {

	private GrupoEstabelecimento grupoestabelecimento;
	private List<GrupoEstabelecimento> listagrupoestabelecimentos;
	private List<Unidade> listaunidades; 

	public GrupoEstabelecimentoBean() {
		grupoestabelecimento = new GrupoEstabelecimento();
		listarGrupoEstabelecimento();
	}
	
	//Inicia o método listar unidade
	public void setarGrupoEstabelecimento(GrupoEstabelecimento ge) {
		listarUnidade();
	}
	
	//Lista as unidades na página de Grupo de Estabelecimento
	public void listarUnidade() {
		String cnpj = grupoestabelecimento.getEmpresa();
		
		UnidadeDAO unidadeDAO = new UnidadeDAO();
		
		if(cnpj!=null) {
			setListaunidades(unidadeDAO.listUnidade(cnpj));
		}
		
	}

	private void listarGrupoEstabelecimento()  {
		GrupoEstabelecimentoDAO grupoestabelecimentoDAO = new GrupoEstabelecimentoDAO ();
		listagrupoestabelecimentos = grupoestabelecimentoDAO.listGrupoEstabelecimento();
	}

	public String cadastraGrupoEstabelecimento() {

		GrupoEstabelecimentoDAO grupoestabelecimento = new GrupoEstabelecimentoDAO ();
		if (grupoestabelecimento.insertGrupoEstabelecimento(this.grupoestabelecimento)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo de Estabelecimento cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));

		}

		return "";
	}

	public GrupoEstabelecimento getGrupoestabelecimento() {
		return grupoestabelecimento;
	}

	public void setGrupoestabelecimento(GrupoEstabelecimento grupoestabelecimento) {
		this.grupoestabelecimento = grupoestabelecimento;
	}

	public List<GrupoEstabelecimento> getListagrupoestabelecimentos() {
		return listagrupoestabelecimentos;
	}

	public void setListagrupoestabelecimentos(List<GrupoEstabelecimento> listagrupoestabelecimentos) {
		this.listagrupoestabelecimentos = listagrupoestabelecimentos;
	}

	public List<Unidade> getListaunidades() {
		return listaunidades;
	}

	public void setListaunidades(List<Unidade> listaunidades) {
		this.listaunidades = listaunidades;
	}

	
}