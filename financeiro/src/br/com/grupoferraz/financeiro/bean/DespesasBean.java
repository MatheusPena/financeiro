package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.DespesasDAO;
import br.com.grupoferraz.financeiro.dao.EstabelecimentoDAO;
import br.com.grupoferraz.financeiro.entity.Despesas;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DespesasBean implements Serializable {

	private Despesas despesas, despesaSelecionada;
	private List<Despesas> listadespesa;
	private List<Estabelecimento> estabelecimentos;
	private String cnpj;

	public DespesasBean() {
		despesas = new Despesas();
		listarDespesas();
		//listarEstabelecimentos();
	}

	public String cadastraDespesa() {

		System.out.println("EST COD " + despesas.getEstabelecimentos_codigo());
		System.out.println("EST NOME " + despesas.getNome());

		ConexaoBD.getConexao();
		DespesasDAO despesa = new DespesasDAO();
		if (despesa.insertDespesas(this.despesas)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Despesa cadastrada com sucesso!", "Sucesso!"));
			// JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Estabelecimento
			// cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da despesa!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		despesas = new Despesas();

		return "";
	}

	public void setarDespesa() {listarEstabelecimentos();
		this.despesas = despesaSelecionada;
		listarEstabelecimentos();
		this.despesas.setEstabelecimentos_codigo(despesaSelecionada.getEstabelecimentos_codigo());
	}

	public void listarDespesas() {
		DespesasDAO despesa = new DespesasDAO();
		setDespesa(despesa.listadespesa());
	}

	public void listarEstabelecimentos() {
		EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
		cnpj = despesas.getEmpresa_cnpj();
		System.out.println("EST " + despesas.getEstabelecimentos_codigo());

		System.out.println("CNPJ " + cnpj);

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
		
		//estabelecimentos = estabelecimentoDAO.listEstabelecimentos();
	}

	public Despesas getDespesas() {
		return despesas;
	}

	public List<Despesas> getListadespesa() {
		return listadespesa;
	}

	public void setDespesa(List<Despesas> despesa) {
		this.listadespesa = despesa;
	}

	public void setListadespesa(List<Despesas> listadespesa) {
		this.listadespesa = listadespesa;
	}

	public void setDespesas(Despesas despesas) {
		this.despesas = despesas;
	}

	/**
	 * @return the estabelecimentos
	 */
	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	/**
	 * @param estabelecimentos
	 *            the estabelecimentos to set
	 */
	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj
	 *            the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the despesaSelecionada
	 */
	public Despesas getDespesaSelecionada() {
		return despesaSelecionada;
	}

	/**
	 * @param despesaSelecionada
	 *            the despesaSelecionada to set
	 */
	public void setDespesaSelecionada(Despesas despesaSelecionada) {
		this.despesaSelecionada = despesaSelecionada;
	}

}