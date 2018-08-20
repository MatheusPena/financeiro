package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoContaFinanceiraDAO;
import br.com.grupoferraz.financeiro.entity.GrupoContaFinanceira;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoContaFinanceiraBean implements Serializable {
	private GrupoContaFinanceira grupoContaFinanceira;
	private List<GrupoContaFinanceira> listaGrupoContasFinanceiras;

	public GrupoContaFinanceiraBean() {
		grupoContaFinanceira = new GrupoContaFinanceira();
		listaGrupoContaFinanceira();
	}

	// método que cadastra os grupos de contas financeiras
	public String cadastraGrupoContaFinanceira() {

		GrupoContaFinanceiraDAO GrupoContasFinanceiras = new GrupoContaFinanceiraDAO();
		if (GrupoContasFinanceiras.insertGrupoContaFinanceira(this.grupoContaFinanceira)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));
			return "";
		}

		this.grupoContaFinanceira = new GrupoContaFinanceira();
		listaGrupoContaFinanceira();
		return "";
	}

	// método que lista os grupos de contas financeiras
	public void listaGrupoContaFinanceira() {
		GrupoContaFinanceiraDAO GrupoContasFinanceirasDAO = new GrupoContaFinanceiraDAO();
		listaGrupoContasFinanceiras = GrupoContasFinanceirasDAO.listGrupoContasFinanceiras();
	}

	// método que deleta os grupos de contas financeiras
	public String deletaGrupoContaFinanceira() {

		// ConexaoBD.getConexao();
		GrupoContaFinanceiraDAO grupocontafinanceiraDAO = new GrupoContaFinanceiraDAO();
		try {
			if (grupocontafinanceiraDAO.deleteGrupoContaFinanceira(grupoContaFinanceira.getCodigo())) {
				listaGrupoContasFinanceiras.remove(grupoContaFinanceira);
				JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO,
						"Grupo de Conta Financeira deletado com sucesso!");
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na deleção do grupo!", "Erro!"));
				return "";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ConexaoBD.fecharConexao();
		this.grupoContaFinanceira = new GrupoContaFinanceira();
		listaGrupoContaFinanceira();
		return "";
	}

	public GrupoContaFinanceira getGrupoContaFinanceira() {
		return grupoContaFinanceira;
	}

	public void setGrupoContaFinanceira(GrupoContaFinanceira GrupoContaFinanceira) {
		this.grupoContaFinanceira = GrupoContaFinanceira;
	}

	public List<GrupoContaFinanceira> getListaGrupoContasFinanceiras() {
		return listaGrupoContasFinanceiras;
	}

	public void setListaGrupoContasFinanceiras(List<GrupoContaFinanceira> listaGrupoContasFinanceiras) {
		this.listaGrupoContasFinanceiras = listaGrupoContasFinanceiras;
	}
}
