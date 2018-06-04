package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.grupoferraz.financeiro.dao.VendedoresDAO;
import br.com.grupoferraz.financeiro.entity.Vendedores;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class VendedoresBean implements Serializable {
	private Vendedores vendedores = new Vendedores();
	private List<Vendedores> vendedor = new ArrayList<>();

	public void cadastrar() {
		vendedor.add(vendedores);
		new VendedoresDAO().salvar(vendedores);
		vendedores = new Vendedores();
	}

	public Vendedores getVendedores() {
		return vendedores;
	}

	public void setVendedores(Vendedores vendedores) {
		this.vendedores = vendedores;
	}

	public List<Vendedores> getVendedor() {
		return vendedor;
	}

	public void setVendedor(List<Vendedores> vendedor) {
		this.vendedor = vendedor;
	}

}
