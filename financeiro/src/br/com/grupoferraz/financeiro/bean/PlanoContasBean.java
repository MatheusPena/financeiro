package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.PlanoContasDAO;
import br.com.grupoferraz.financeiro.entity.PlanoContas;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PlanoContasBean implements Serializable {
	private PlanoContas PlanoContas;
	private List<PlanoContas> PlanoContass;

	public PlanoContasBean() {
		PlanoContas = new PlanoContas();
		listarPlanoContass();
	}

	public String cadastraPlanoContass() {

		ConexaoBD.getConexao();
		PlanoContasDAO PlanoContass = new PlanoContasDAO();
		if (PlanoContass.insertPlanoContas(this.PlanoContas)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Plano de Contas cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do Plano de Contas!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public void listarPlanoContass() {
		PlanoContasDAO PlanoContass = new PlanoContasDAO();
		setPlanoContass(PlanoContass.listPlanoContas());
	}

	public List<PlanoContas> getPlanoContass() {
		return PlanoContass;
	}

	public void setPlanoContass(List<PlanoContas> PlanoContass) {
		this.PlanoContass = PlanoContass;
	}

	public PlanoContas getPlanoContas() {
		return PlanoContas;
	}

	public void setPlanoContas(PlanoContas PlanoContas) {
		this.PlanoContas = PlanoContas;
	}
}
