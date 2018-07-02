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
import br.com.grupoferraz.financeiro.dao.VendedoresDAO;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.Vendedores;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class VendedoresBean implements Serializable {

	private Vendedores vendedores, vendedorSelecionado;
	private List<Vendedores> vendedor;
	private List<Estabelecimento> estabelecimentos;
	private String cnpj;

	public VendedoresBean() {
		vendedores = new Vendedores();
		listarVendedor();
	}

	public String cadastraVendedor() {

		System.out.println("EST COD " + vendedores.getEstabelecimentos_codigo());
		System.out.println("EST NOME " + vendedores.getNome());
		
		ConexaoBD.getConexao();
		VendedoresDAO vendedor = new VendedoresDAO();
		if (vendedor.insertVendedores(this.vendedores)) {

			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_INFO, "Vendedor cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do vendedor!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		vendedores = new Vendedores();

		return "";
	}
	
	public void setarVendedor() {listarEstabelecimentos();
	this.vendedores = vendedorSelecionado;
	listarEstabelecimentos();
	this.vendedores.setEstabelecimentos_codigo(vendedorSelecionado.getEstabelecimentos_codigo());
}
	
	
	public void listarVendedor() {
		VendedoresDAO vendedor = new VendedoresDAO();
		setVendedor(vendedor.listVendedores());
	}

	public void listarEstabelecimentos() {
		EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
		cnpj = vendedores.getEmpresa_cnpj();
		System.out.println("EST " + vendedores.getEstabelecimentos_codigo());

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
	
	public List<Vendedores> getVendedor() {
		return vendedor;
	}

	public void setVendedor(List<Vendedores> vendedor) {
		this.vendedor = vendedor;
	}

	public Vendedores getVendedores() {
		return vendedores;
	}

	public void setVendedores(Vendedores vendedores) {
		this.vendedores = vendedores;
	}

	public Vendedores getVendedorSelecionado() {
		return vendedorSelecionado;
	}

	public void setVendedorSelecionado(Vendedores vendedorSelecionado) {
		this.vendedorSelecionado = vendedorSelecionado;
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