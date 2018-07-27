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
import br.com.grupoferraz.financeiro.dao.VendedorDAO;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.Vendedor;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class VendedorBean implements Serializable {

	private Vendedor vendedor, vendedorSelecionado;
	private List<Vendedor> listavendedor;
	private List<Estabelecimento> estabelecimentos;
	private String cnpj;

	public VendedorBean() {
		vendedor = new Vendedor();
		listarVendedor();
	}

	// cadastra um vendedor exibindo uma mensagem na tela
	public String cadastraVendedor() {
		ConexaoBD.getConexao();
		VendedorDAO vendedor = new VendedorDAO();
		if (vendedor.insertVendedor(this.vendedor)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Vendedor cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do Vendedor!", "Erro!"));
			return "";

		}
		ConexaoBD.fecharConexao();
		
		this.vendedor = new Vendedor();
		return "";
	}

	// seleciona o vendedor desejado
	public void setarVendedor() {
		listarEstabelecimentos();
		this.vendedor = vendedorSelecionado;
		listarEstabelecimentos();
		this.vendedor.setEstabelecimento_codigo(vendedorSelecionado.getEstabelecimento_codigo());
	}

	// lista os vendedores existentes no banco
	public void listarVendedor() {
		VendedorDAO vendedor = new VendedorDAO();
		setListavendedor(vendedor.listvendedor());
	}

	// lista a lista do autocomplete dos vendedores existentes no banco
	public void listarEstabelecimentos() {
		EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
		cnpj = vendedor.getEmpresa_cnpj();
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

		String cnpj = vendedor.getEmpresa_cnpj();
		return EstabelecimentoDAO.listaestabelecimento(query, cnpj);
	}

	// seleciona um dos objetos da lista no campo despesas
	public void selecionar() {

		Estabelecimento estabelecimento = vendedor.getEstabelecimento();

		if (estabelecimento != null) {
			vendedor.setEstabelecimento_codigo(estabelecimento.getCodigo());
		}

	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Vendedor getVendedorSelecionado() {
		return vendedorSelecionado;
	}

	public void setVendedorSelecionado(Vendedor vendedorSelecionado) {
		this.vendedorSelecionado = vendedorSelecionado;
	}

	public List<Vendedor> getListavendedor() {
		return listavendedor;
	}

	public void setListavendedor(List<Vendedor> listavendedor) {
		this.listavendedor = listavendedor;
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