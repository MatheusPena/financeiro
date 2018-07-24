package br.com.grupoferraz.financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class EmpresaDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertEmpresas(Empresa Empresas) {

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();
			str.append("insert into empresas (cnpj, nome) values (?,?) ");
			str.append("on duplicate key update cnpj = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setString(1, Empresas.getCnpj());
			preparedStatement.setString(2, Empresas.getNome());

			preparedStatement.setString(3, Empresas.getCnpj());
			preparedStatement.setString(4, Empresas.getNome());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Empresa> listEmpresas() {

		ArrayList<Empresa> lista = new ArrayList<Empresa>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select cnpj, nome from empresa ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Empresa Empresas = new Empresa();
				Empresas.setCnpj(rs.getString("cnpj"));
				Empresas.setNome(rs.getString("nome"));
				lista.add(Empresas);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}
