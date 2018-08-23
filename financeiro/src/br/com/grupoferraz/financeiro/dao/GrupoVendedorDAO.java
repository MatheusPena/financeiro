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

	// método que insere um grupo de vendedor
	public boolean insertGrupoVendedor(GrupoVendedor grupovendedor) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into grupo_vendedor (codigo, nome) values (?,?)");
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

	// método que lista o(s) grupo(s) de vendedor(es) cadastrado(s) no banco na
	// tabela
	public List<GrupoVendedor> listGrupoVendedores() {

		ArrayList<GrupoVendedor> lista = new ArrayList<GrupoVendedor>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from grupo_vendedor";
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

	// método que deleta um grupo de vendedor(es) na tabela
	public boolean deleteGrupoVendedor(int idGrupo) throws SQLException {
		boolean resposta;

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conexao.prepareStatement("delete from grupo_vendedor where codigo = ?");
			preparedStatement.setInt(1, idGrupo);
			preparedStatement.executeUpdate();
			resposta = true;
		} catch (Exception ex) {
			ex.printStackTrace();
			resposta = false;
		}
		return resposta;
	}
}
