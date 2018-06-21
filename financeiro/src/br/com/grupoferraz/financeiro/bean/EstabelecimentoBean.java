package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.EstabelecimentoDAO;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstabelecimentoBean implements Serializable {

	private Estabelecimento estabelecimento;
	private List<Estabelecimento> estabelecimentos;

	public EstabelecimentoBean() {
		estabelecimento = new Estabelecimento();
		listarEstabelecimentos();
	}

	public String cadastraEstabelecimentos() {

		ConexaoBD.getConexao();
		EstabelecimentoDAO estabelecimentos = new EstabelecimentoDAO();
		if (estabelecimentos.insertEstabelecimentos(this.estabelecimento)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Estabelecimento cadastrado com sucesso!", "Sucesso!"));
			// JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Estabelecimento
			// cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do estabelecimento!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		estabelecimento = new Estabelecimento();

		return "";
	}

	public void listarEstabelecimentos() {
		EstabelecimentoDAO estabelecimentos = new EstabelecimentoDAO();
		setEstabelecimentos(estabelecimentos.listEstabelecimentos());
	}

	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

}