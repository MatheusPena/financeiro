package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.util.ConexaoBD;
import br.com.grupoferraz.financeiro.dao.ClientesDAO;
import br.com.grupoferraz.financeiro.entity.Clientes;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClientesBean implements Serializable {

	private Clientes usuario;

	public ClientesBean() {
		usuario = new Clientes();
	}

	public String cadastraUsuario() {

		ConexaoBD.getConexao();
		ClientesDAO usuarios = new ClientesDAO ();
		if (usuarios.insertUsuario(usuario)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente cadastrado com sucesso", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do cliente!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

		return "";
	}

	public List<Clientes> getUsuarios() throws SQLException {
		ClientesDAO usuarios = new ClientesDAO ();
		List<Clientes> listaUsuarios = usuarios.listUsuarios();

		return listaUsuarios;
	}

	public Clientes getUsuario() {
		return usuario;
	}

	public void setUsuario(Clientes usuario) {
		this.usuario = usuario;
	}
}