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

import br.com.grupoferraz.financeiro.entity.GrupoVendedores;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoVendedoresDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoVendedores(GrupoVendedores grupovendedores) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();

			PreparedStatement preparedStatement = conexao
					.prepareStatement("insert into grupovendedores (codigo, nomegrupovendedores)"
							+ "values (?,?)");
			preparedStatement.setInt(1, grupovendedores.getCodigo());
			preparedStatement.setString(2, grupovendedores.getnomegrupovendedores());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<GrupoVendedores> listGrupoVendedores() {

		ArrayList<GrupoVendedores> lista = new ArrayList<GrupoVendedores>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" 
			+  "from grupovendedores";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoVendedores grupovendedores = new GrupoVendedores();
				grupovendedores.setCodigo(rs.getInt(1));
				grupovendedores.setnomegrupovendedores(rs.getString(2));
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
