package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.GrupoDespesaDAO;
import br.com.grupoferraz.financeiro.entity.GrupoDespesa;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GrupoDespesaBean implements Serializable {

	private GrupoDespesa grupodespesa;
	private List<GrupoDespesa> listagrupodespesas;


	public GrupoDespesaBean() {
		grupodespesa = new GrupoDespesa();
		listarGrupoDespesas();
	}

	private void listarGrupoDespesas()  {
		GrupoDespesaDAO grupoDespesaDAO = new GrupoDespesaDAO ();
		listagrupodespesas = grupoDespesaDAO.listGrupoDespesas();
		
		
	}

	public String cadastraGrupoDespesa() {

		ConexaoBD.getConexao();
		GrupoDespesaDAO grupodespesa = new GrupoDespesaDAO ();
		if (grupodespesa.insertGrupoDespesa(this.grupodespesa)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo de Despesas cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public GrupoDespesa getGrupodespesa() {
		return grupodespesa;
	}

	public void setGrupodespesa(GrupoDespesa grupodespesa) {
		this.grupodespesa = grupodespesa;
	}

	public List<GrupoDespesa> getListagrupodespesas() {
		return listagrupodespesas;
	}

	public void setListagrupodespesas(List<GrupoDespesa> listagrupodespesas) {
		this.listagrupodespesas = listagrupodespesas;
	}

}