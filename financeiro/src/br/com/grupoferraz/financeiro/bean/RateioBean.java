package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.RateioDAO;
import br.com.grupoferraz.financeiro.entity.Rateio;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RateioBean implements Serializable {
	private Rateio Rateio;
	private List<Rateio> listaRateio;

	public RateioBean() {
		Rateio = new Rateio();
		listarRateio();
	}

	private void listarRateio() {
		RateioDAO RateioDAO = new RateioDAO();
		listaRateio = RateioDAO.listRateio();

	}

	public String cadastraRateio() {

		ConexaoBD.getConexao();
		RateioDAO Rateio = new RateioDAO();
		if (Rateio.insertRateio(this.Rateio)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Rateio cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do Rateio!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public Rateio getRateio() {
		return Rateio;
	}

	public void setRateio(Rateio Rateio) {
		this.Rateio = Rateio;
	}

	public List<Rateio> getListaRateio() {
		return listaRateio;
	}

	public void setListaRateio(List<Rateio> listaRateio) {
		this.listaRateio = listaRateio;
	}

}
