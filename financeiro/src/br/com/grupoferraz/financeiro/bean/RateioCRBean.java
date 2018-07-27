package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.EstabelecimentoDAO;
import br.com.grupoferraz.financeiro.dao.RateioCRDAO;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.RateioCR;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RateioCRBean implements Serializable {
	private RateioCR Rateio, rateioSelecionado;
	private List<RateioCR> listaRateios;
	private List<Estabelecimento> estabelecimentos;
	private String cnpj;

	public RateioCRBean() {
		Rateio = new RateioCR();
		listarRateio();
	}

	// lista o rateio
	private void listarRateio() {
		RateioCRDAO RateioDAO = new RateioCRDAO();
		listaRateios = RateioDAO.listRateio();

	}

	// cadastra o rateio
	public String cadastraRateio() {

		ConexaoBD.getConexao();
		RateioCRDAO Rateio = new RateioCRDAO();
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

	// seleciona o rateio desejado
	public void setarRateio() {
		listarEstabelecimentos();
		this.Rateio = rateioSelecionado;
		listarEstabelecimentos();
		this.Rateio.setEstabelecimento_codigo(rateioSelecionado.getEstabelecimento_codigo());
	}

	// lista a lista do autocomplete dos rateios existentes no banco
	public void listarEstabelecimentos() {
		EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
		cnpj = Rateio.getEmpresa_cnpj();
		if (cnpj != null) {
			try {
				estabelecimentos = estabelecimentoDAO.getEstabelecimento(cnpj);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			estabelecimentos = new ArrayList<>();
		}

		// estabelecimentos = estabelecimentoDAO.listEstabelecimentos();
	}

	// lista a lista do autocomplete no campo despesas
	public List<Estabelecimento> completeText(String query) {
		EstabelecimentoDAO EstabelecimentoDAO = new EstabelecimentoDAO();

		String cnpj = Rateio.getEmpresa_cnpj();
		return EstabelecimentoDAO.listaestabelecimento(query, cnpj);
	}

	// seleciona um dos objetos da lista no campo despesas
	public void selecionar() {

		Estabelecimento estabelecimento = Rateio.getEstabelecimento();

		if (estabelecimento != null) {
			Rateio.setEstabelecimento_codigo(estabelecimento.getCodigo());
		}

	}

	public RateioCR getRateio() {
		return Rateio;
	}

	public void setRateio(RateioCR rateio) {
		Rateio = rateio;
	}

	public RateioCR getRateioSelecionado() {
		return rateioSelecionado;
	}

	public void setRateioSelecionado(RateioCR rateioSelecionado) {
		this.rateioSelecionado = rateioSelecionado;
	}

	public List<RateioCR> getListaRateio() {
		return listaRateios;
	}

	public void setListaRateio(List<RateioCR> listaRateio) {
		this.listaRateios = listaRateio;
	}

	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
