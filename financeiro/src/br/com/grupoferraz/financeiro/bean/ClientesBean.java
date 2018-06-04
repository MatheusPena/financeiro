package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.Connection;
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

	public String cadastraUsuario() throws SQLException {

		Connection conexao = ConexaoBD.getConexao();
		ClientesDAO usuarios = new ClientesDAO ();
		if (usuarios.insertUsuario(usuario)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Usuário cadastrado com sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro no cadastro de usuário!"));

		}
		conexao.close();

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