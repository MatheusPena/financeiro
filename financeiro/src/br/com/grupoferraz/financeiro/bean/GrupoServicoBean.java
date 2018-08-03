package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
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
		getGrupoServicoDAO();
	}

	// cadastra o grupo de servico
	public String cadastraGrupoServico() {

		ConexaoBD.getConexao();
		GrupoServicoDAO gruposervico = new GrupoServicoDAO();
		if (gruposervico.insertGrupoServico(this.gruposervico)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo de Serviço cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));
			return "";

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public void getGrupoServicoDAO() {
		GrupoServicoDAO grupomodalidade = new GrupoServicoDAO();
		listagruposervico = grupomodalidade.listGrupoServico();
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
