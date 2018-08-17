package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
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

	private List<GrupoDespesaReceita> subgrupos;
	private GrupoDespesaReceita grupodespesareceita;
	private List<GrupoDespesaReceita> listagrupodespesareceitas;

	public GrupoDespesaReceitaBean() {
		subgrupos = new ArrayList<>();
		grupodespesareceita = new GrupoDespesaReceita();
		listarGrupoDespesaReceita();
	}

	public void addSubgrupo() {
		GrupoDespesaReceita sdr = grupodespesareceita.getGrupopai();
		if(!subgrupos.contains(sdr)) {
			subgrupos.add(sdr);
		}
		System.out.println(subgrupos);
	}

	public void removerSubgrupo() {
		getSubgrupos().remove(grupodespesareceita.getGrupopai());
		System.out.println(getSubgrupos());
	}

	private void listarGrupoDespesaReceita() {
		GrupoDespesaReceitaDAO grupoDespesaReceitaDAO = new GrupoDespesaReceitaDAO();
		listagrupodespesareceitas = grupoDespesaReceitaDAO.listGrupoDespesaReceita();

	}

	public String cadastraGrupoDespesaReceita() {

		GrupoDespesaReceitaDAO grupodespesareceitaDAO = new GrupoDespesaReceitaDAO();
		if (grupodespesareceitaDAO.insertGrupoDespesaReceita(this.grupodespesareceita)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Grupo cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do grupo!", "Erro!"));
			return "";
		}
		try {
			Integer m = grupodespesareceitaDAO.getMax();
			System.out.println("MAX "+m);
			// m++;
			for (GrupoDespesaReceita g : subgrupos) {
				g.setGrupodespesareceita_codigo(m);
				grupodespesareceitaDAO.insertGrupoDespesaReceita(g);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		this.grupodespesareceita = new GrupoDespesaReceita();

		return "grupo_despesareceita?faces-redirect=true";
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

	public List<GrupoDespesaReceita> getSubgrupos() {
		return subgrupos;
	}

	public void setSubgrupos(List<GrupoDespesaReceita> subgrupos) {
		this.subgrupos = subgrupos;
	}

}