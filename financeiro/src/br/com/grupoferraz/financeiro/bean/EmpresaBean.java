package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.EmpresaDAO;
import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EmpresaBean implements Serializable {
	private Empresa Empresa;
	private List<Empresa> Empresas;

	public EmpresaBean() {
		Empresa = new Empresa();
		listarEmpresas();
	}

	public String cadastraEmpresas() {

		ConexaoBD.getConexao();
		EmpresaDAO Empresas = new EmpresaDAO();
		if (Empresas.insertEmpresas(this.Empresa)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Empresa cadastrada com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro da Empresa!", "Erro!"));

		}
		ConexaoBD.fecharConexao();
		Empresa = new Empresa();

		return "";
	}

	public void listarEmpresas() {
		EmpresaDAO Empresas = new EmpresaDAO();
		setEmpresas(Empresas.listEmpresas());
	}

	public List<Empresa> getEmpresas() {
		return Empresas;
	}

	public void setEmpresas(List<Empresa> Empresas) {
		this.Empresas = Empresas;
	}

	public Empresa getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(Empresa Empresa) {
		this.Empresa = Empresa;
	}
}
