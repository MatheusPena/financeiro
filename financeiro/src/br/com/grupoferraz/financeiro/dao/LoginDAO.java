package br.com.grupoferraz.financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.grupoferraz.financeiro.entity.Login;
import br.com.grupoferraz.financeiro.util.JPAUtilAux;
public class LoginDAO {

	private EntityManager em = new JPAUtilAux().getEntityManager();

	public LoginDAO() {

	}

	public boolean ok(Login login) {

		boolean ok = false;
		try {

			String senhaAux = login.getSenha();
			
			String usuario = login.getUsuario();
					
			Login loginAux = em.find(Login.class, usuario);
			
			if(loginAux==null) {
				return false;
			}
			
			String senhaUsuario = loginAux.getSenha();
			ok = senhaUsuario.equals(senhaAux);

		} catch (Exception ex) {
			em = new JPAUtilAux().getEntityManager();
			ok = ok(login);
			ex.printStackTrace();
		}
		return ok;
	}

	public Login getLogin(String usuario) {
		Query query = em.createQuery("from Login l where l.usuario = :usuario").setParameter("usuario", usuario);
		Login login = (Login) query.getSingleResult();
		em.merge(login);
		return login;
	}

	@SuppressWarnings("unchecked")
	public List<String> listarUsuarios() {
		Query query = em.createQuery("select l.usuario from Login l");
		return query.getResultList();
	}

	public boolean salvarLogin(Connection con, Login l) throws Exception {

		boolean ok = false;

		String queryInserir = "insert into login (usuario, senha) values (?, ?) "
				+ "on duplicate key update usuario = ?, senha = ?";

		PreparedStatement preparedStatement = null;

		String usuario;
		String senha;
		

		try {

			preparedStatement = con.prepareStatement(queryInserir);

			if (l != null) {

				usuario = l.getUsuario();
				senha = l.getSenha();
					

				preparedStatement.setString(1, usuario);
				preparedStatement.setString(2, senha);
				
				preparedStatement.setString(3, usuario);
				preparedStatement.setString(4, senha);
				
			}

			preparedStatement.executeUpdate();
			ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
			ok = false;
		}catch (Exception e) {
			con.rollback();
			ok = false;
		} 
		
		
		finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
		return ok;
	}

}
