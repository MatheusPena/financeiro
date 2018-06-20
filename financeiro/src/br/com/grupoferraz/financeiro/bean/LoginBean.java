package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.com.grupoferraz.financeiro.dao.LoginDAO;
import br.com.grupoferraz.financeiro.entity.Login;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private Login login;
	private boolean ok = false;
	
	public LoginBean() {
		if(login==null) {
			login = new Login();
		}
	}

	public void onload() {
		if(login!=null) {
			logOut();
		}
		login = new Login();
	}

	public String logar() {
		LoginDAO dao = new LoginDAO();
		if (dao.ok(login)) {
			ok = true;
			login = dao.getLogin(login.getUsuario());
			return "";
		} else {
			login = new Login();
			System.out.println("ERRO AO LOGAR");
			ok = false;
			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_WARN, "Dados incorretos");
			return "";
		}
	}

	public String logar(ActionEvent event) {
		LoginDAO dao = new LoginDAO();
		if (dao.ok(login)) {
			ok = true;
			login = dao.getLogin(login.getUsuario());			
			return "index?faces-redirect=true";
		} else {
			login = new Login();
			System.out.println("ERRO AO LOGAR");
			ok = false;
			JSFUtil.mostraMensagemSemFlash(FacesMessage.SEVERITY_WARN, "Dados incorretos");
			return "";
		}
	}

	public String logOut() {
		login = new Login();
		return "acesso?faces-redirect=true";
	}

	public boolean isLogado() {
		return login.getUsuario() != null && ok;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Login getLogin() {
		return login;
	}

}
