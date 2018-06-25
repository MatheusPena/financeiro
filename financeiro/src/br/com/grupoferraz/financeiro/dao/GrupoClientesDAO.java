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

import br.com.grupoferraz.financeiro.entity.GrupoClientes;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoClientesDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoCliente(GrupoClientes grupoclientes) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();	
			str.append("insert into grupoclientes (codigo, nome)"
					+ " values (?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupoclientes.getCodigo());
			preparedStatement.setString(2, grupoclientes.getNome());
			
			preparedStatement.setInt(3, grupoclientes.getCodigo());
			preparedStatement.setString(4, grupoclientes.getNome());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<GrupoClientes> listGrupoClientes() {

		ArrayList<GrupoClientes> lista = new ArrayList<GrupoClientes>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" 
			+  "from grupoclientes";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoClientes grupocliente = new GrupoClientes();
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
