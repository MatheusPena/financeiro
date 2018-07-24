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

import br.com.grupoferraz.financeiro.entity.GrupoVendedor;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoVendedoresDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoVendedores(GrupoVendedor grupovendedores) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();	
			str.append("insert into grupovendedores (codigo, nomegrupovendedores)"
					+ " values (?,?)");
			str.append("on duplicate key update codigo = ?, nomegrupovendedores = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupovendedores.getCodigo());
			preparedStatement.setString(2, grupovendedores.getNomegrupovendedores());
			
			preparedStatement.setInt(3, grupovendedores.getCodigo());
			preparedStatement.setString(4, grupovendedores.getNomegrupovendedores());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<GrupoVendedor> listGrupoVendedores() {

		ArrayList<GrupoVendedor> lista = new ArrayList<GrupoVendedor>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" 
			+  "from grupovendedores";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoVendedor grupovendedores = new GrupoVendedor();
				grupovendedores.setCodigo(rs.getInt(1));
				grupovendedores.setNomegrupovendedores(rs.getString(2));
				lista.add(grupovendedores);
			}
			

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}
