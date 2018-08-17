package br.com.grupoferraz.financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.grupoferraz.financeiro.entity.Login;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class LoginDAO {

	Connection conexao = ConexaoBD.getConexao();

	public LoginDAO() {

	}

	public boolean ok(Login login) {
		boolean ok = false;
		try {
			String senhaAux = login.getSenha();
			String usuario = login.getUsuario();
			Login loginAux = getLogin(usuario);
			if (loginAux == null) {
				return false;
			}
			String senhaUsuario = loginAux.getSenha();
			if(org.apache.commons.lang.StringUtils.isNotEmpty(senhaUsuario)) {
				ok = senhaUsuario.equals(senhaAux);
			}
		
		} catch (Exception ex) {
			conexao = ConexaoBD.getConexao();
			//ok = ok(login);
			ex.printStackTrace();
		}
		return ok;
	}

	public Login getLogin(String usuario) {

		PreparedStatement st = null;
		ResultSet rs = null;
		Login login = new Login();
		try {
			String sql = "select usuario, senha, tipo from login where usuario = ?";
			st = conexao.prepareStatement(sql);
			st.setString(1, usuario);
			rs = st.executeQuery();
			while (rs.next()) {
				login.setUsuario(rs.getString("usuario"));
				login.setSenha(rs.getString("senha"));
				// login.setTipo(rs.getString("tipo"));
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return login;
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
		} catch (Exception e) {
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
