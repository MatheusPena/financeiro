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

public class GrupoVendedorDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoVendedor(GrupoVendedor grupovendedor) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();
			str.append("insert into grupovendedor (codigo, nome)" + " values (?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupovendedor.getCodigo());
			preparedStatement.setString(2, grupovendedor.getNome());

			preparedStatement.setInt(3, grupovendedor.getCodigo());
			preparedStatement.setString(4, grupovendedor.getNome());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os grupos cadastrados no banco de dados
	public List<GrupoVendedor> listGrupoVendedores() {

		ArrayList<GrupoVendedor> lista = new ArrayList<GrupoVendedor>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" + "from grupovendedor";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoVendedor grupovendedor = new GrupoVendedor();
				grupovendedor.setCodigo(rs.getInt(1));
				grupovendedor.setNome(rs.getString(2));
				lista.add(grupovendedor);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}
