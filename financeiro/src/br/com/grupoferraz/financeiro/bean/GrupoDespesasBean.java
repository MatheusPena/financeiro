package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.GrupoDespesasDAO;
import br.com.grupoferraz.financeiro.entity.GrupoDespesas;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoDespesasBean implements Serializable {

	private GrupoDespesas grupodespesas;
	private List<GrupoDespesas> listagrupodespesas;


	public GrupoDespesasBean() {
		grupodespesas = new GrupoDespesas();
		listarGrupoDespesas();
	}

	private void listarGrupoDespesas()  {
		GrupoDespesasDAO grupoDespesasDAO = new GrupoDespesasDAO ();
		listagrupodespesas = grupoDespesasDAO.listGrupoDespesas();
		
		
	}

	public String cadastraGrupoDespesa() {

		ConexaoBD.getConexao();
		GrupoDespesasDAO grupodespesas = new GrupoDespesasDAO ();
		if (grupodespesas.insertGrupoDespesas(this.grupodespesas)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo de Despesas cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public GrupoDespesas getGrupodespesas() {
		return grupodespesas;
	}

	public void setGrupodespesas(GrupoDespesas grupodespesas) {
		this.grupodespesas = grupodespesas;
	}

	public List<GrupoDespesas> getListagrupodespesas() {
		return listagrupodespesas;
	}

	public void setListagrupodespesas(List<GrupoDespesas> listagrupodespesas) {
		this.listagrupodespesas = listagrupodespesas;
	}

}