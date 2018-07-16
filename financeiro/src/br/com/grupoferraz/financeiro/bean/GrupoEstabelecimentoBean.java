package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoEstabelecimentoDAO;
import br.com.grupoferraz.financeiro.dao.UnidadeDAO;
import br.com.grupoferraz.financeiro.entity.GrupoEstabelecimento;
import br.com.grupoferraz.financeiro.entity.Unidade;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoEstabelecimentoBean implements Serializable {

	private GrupoEstabelecimento grupoestabelecimento;
	private List<GrupoEstabelecimento> listagrupoestabelecimento;
	private List<Unidade> listaunidade; 

	public GrupoEstabelecimentoBean() {
		grupoestabelecimento = new GrupoEstabelecimento();
		listarGrupoEstabelecimento();
		//listarUnidade();
	}
	
	public void listarUnidade() {
		String cnpj = grupoestabelecimento.getEmpresa();
		Connection conexao = ConexaoBD.getConexao();
		UnidadeDAO UnidadeDAO = new UnidadeDAO();
		listaunidade = UnidadeDAO.listUnidade(cnpj);
		System.out.println("CNPJ "+cnpj);
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void listarGrupoEstabelecimento()  {
		GrupoEstabelecimentoDAO grupoestabelecimentoDAO = new GrupoEstabelecimentoDAO ();
		listagrupoestabelecimento = grupoestabelecimentoDAO.listGrupoEstabelecimento();
	}

	public String cadastraGrupoEstabelecimento() {

		//ConexaoBD.getConexao();
		GrupoEstabelecimentoDAO grupoestabelecimento = new GrupoEstabelecimentoDAO ();
		if (grupoestabelecimento.insertGrupoEstabelecimento(this.grupoestabelecimento)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo de Estabelecimento cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));

		}
		//ConexaoBD.fecharConexao();

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

	public List<Unidade> getListaunidade() {
		return listaunidade;
	}

	public void setListaunidade(List<Unidade> listaunidade) {
		this.listaunidade = listaunidade;
	}

}