package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.GrupoDespesaReceitaDAO;
import br.com.grupoferraz.financeiro.entity.GrupoDespesaReceita;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoDespesaReceitaBean implements Serializable {

	private GrupoDespesaReceita grupodespesareceita;
	private List<GrupoDespesaReceita> listagrupodespesareceitas;

	public GrupoDespesaReceitaBean() {
		grupodespesareceita = new GrupoDespesaReceita();
		listarGrupoDespesaReceita();
	}

	// método que lista os grupos de receitas/despesas
	private void listarGrupoDespesaReceita() {
		GrupoDespesaReceitaDAO grupoDespesaReceitaDAO = new GrupoDespesaReceitaDAO();
		listagrupodespesareceitas = grupoDespesaReceitaDAO.listGrupoDespesaReceita();

	}

	// método que cadastra os grupos de despesas/receitas
	public String cadastraGrupoDespesaReceita() {

		GrupoDespesaReceitaDAO grupodespesareceitaDAO = new GrupoDespesaReceitaDAO();
		if (grupodespesareceitaDAO.insertGrupoDespesaReceita(this.grupodespesareceita)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));
			return "";
		}

		this.grupodespesareceita = new GrupoDespesaReceita();
		listarGrupoDespesaReceita();
		return "";
	}

	// método que deleta os grupos de despesas/receitas
	public String deletaGrupoDespesaReceita() {

		// ConexaoBD.getConexao();
		GrupoDespesaReceitaDAO grupoDespesaReceita = new GrupoDespesaReceitaDAO();
		try {
			if (grupoDespesaReceita.deleteGrupoDespesaReceita(grupodespesareceita.getCodigo())) {
				listagrupodespesareceitas.remove(grupodespesareceita);
				JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo de Despesa/Receita deletado com sucesso!");
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro ao deletar, esse grupo pode estar vinculado à uma despesa/receita.", "Erro!"));
				return "";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ConexaoBD.fecharConexao();
		this.grupodespesareceita = new GrupoDespesaReceita();
		listarGrupoDespesaReceita();
		return "";
	}

	public GrupoDespesaReceita getGrupodespesareceita() {
		return grupodespesareceita;
	}

	public void setGrupodespesareceita(GrupoDespesaReceita grupodespesareceita) {
		this.grupodespesareceita = grupodespesareceita;
	}

	public List<GrupoDespesaReceita> getListagrupodespesareceitas() {
		return listagrupodespesareceitas;
	}

	public void setListagrupodespesareceitas(List<GrupoDespesaReceita> listagrupodespesareceitas) {
		this.listagrupodespesareceitas = listagrupodespesareceitas;
	}

}