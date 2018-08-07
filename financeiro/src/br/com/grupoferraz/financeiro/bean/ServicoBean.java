package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.ServicoDAO;
import br.com.grupoferraz.financeiro.entity.Servico;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ServicoBean implements Serializable {

	private Servico servico;
	private List<Servico> listaservico;

	public ServicoBean() {
		servico = new Servico();
		getServicoDAO();
	}

	// cadastra o grupo de serviços
	public String cadastraServico() {

		ConexaoBD.getConexao();
		ServicoDAO servico = new ServicoDAO();
		if (servico.insertServico(this.servico)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Serviço cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));
			return "";

		}
		ConexaoBD.fecharConexao();
		this.servico = new Servico();
		return "";
	}

	public void getServicoDAO() {
		ServicoDAO modalidade = new ServicoDAO();
		listaservico = modalidade.listServico();
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<Servico> getListaservico() {
		return listaservico;
	}

	public void setListaservico(List<Servico> listaservico) {
		this.listaservico = listaservico;
	}

}
