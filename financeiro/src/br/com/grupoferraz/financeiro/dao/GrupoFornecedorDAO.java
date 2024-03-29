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

import br.com.grupoferraz.financeiro.entity.GrupoFornecedor;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoFornecedorDAO {
	Connection conexao = ConexaoBD.getConexao();

	// m�todo que insere um grupo de fornecedores
	public boolean insertGrupoFornecedor(GrupoFornecedor grupofornecedor) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into grupo_fornecedor (codigo, nome)" + " values (?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupofornecedor.getCodigo());
			preparedStatement.setString(2, grupofornecedor.getNome());

			preparedStatement.setInt(3, grupofornecedor.getCodigo());
			preparedStatement.setString(4, grupofornecedor.getNome());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// m�todo que lista o(s) grupo(s) de fornecedor(es) cadastrado(s) no banco na tabela
	public List<GrupoFornecedor> listGrupoFornecedores() {

		ArrayList<GrupoFornecedor> lista = new ArrayList<GrupoFornecedor>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from grupo_fornecedor";

			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoFornecedor grupofornecedor = new GrupoFornecedor();
				grupofornecedor.setCodigo(rs.getInt(1));
				grupofornecedor.setNome(rs.getString(2));
				lista.add(grupofornecedor);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// m�todo que deleta um grupo de fornecedor(es) na tabela
	public boolean deleteGrupoFornecedor(int idGrupo) throws SQLException {
		boolean resposta;

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conexao.prepareStatement("delete from grupo_fornecedor where codigo = ?");
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
