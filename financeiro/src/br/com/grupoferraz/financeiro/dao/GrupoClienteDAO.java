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

import br.com.grupoferraz.financeiro.entity.GrupoCliente;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoClienteDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoCliente(GrupoCliente grupocliente) {

		try {

			StringBuilder str = new StringBuilder();	
			str.append("insert into grupocliente (codigo, nome)"
					+ " values (?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupocliente.getCodigo());
			preparedStatement.setString(2, grupocliente.getNome());
			
			preparedStatement.setInt(3, grupocliente.getCodigo());
			preparedStatement.setString(4, grupocliente.getNome());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<GrupoCliente> listGrupoCliente() {

		ArrayList<GrupoCliente> lista = new ArrayList<GrupoCliente>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from grupocliente";
			
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoCliente grupocliente = new GrupoCliente();
				grupocliente.setCodigo(rs.getInt(1));
				grupocliente.setNome(rs.getString(2));
				lista.add(grupocliente);
			}
			

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}
