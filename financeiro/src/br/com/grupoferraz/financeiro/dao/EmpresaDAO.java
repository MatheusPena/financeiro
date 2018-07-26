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

	public boolean insertEmpresas(Empresa Empresa) {

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();
			str.append("insert into empresa (cnpj, nome) values (?,?) ");
			str.append("on duplicate key update cnpj = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setString(1, Empresa.getCnpj());
			preparedStatement.setString(2, Empresa.getNome());

			preparedStatement.setString(3, Empresa.getCnpj());
			preparedStatement.setString(4, Empresa.getNome());
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

				Empresa Empresa = new Empresa();
				Empresa.setCnpj(rs.getString("cnpj"));
				Empresa.setNome(rs.getString("nome"));
				lista.add(Empresa);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}
