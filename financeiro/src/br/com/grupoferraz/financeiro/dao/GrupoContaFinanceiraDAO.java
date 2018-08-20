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

import br.com.grupoferraz.financeiro.entity.GrupoContaFinanceira;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoContaFinanceiraDAO {
	Connection conexao = ConexaoBD.getConexao();

	// método que insere um grupo de conta financeira
	public boolean insertGrupoContaFinanceira(GrupoContaFinanceira grupoContaFinanceira) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into grupo_conta_financeira (codigo, nome) values (?,?)");
			str.append(" on duplicate key update codigo = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupoContaFinanceira.getCodigo());
			preparedStatement.setString(2, grupoContaFinanceira.getNome());

			preparedStatement.setInt(3, grupoContaFinanceira.getCodigo());
			preparedStatement.setString(4, grupoContaFinanceira.getNome());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// método que lista os grupo(s) de conta(s) financeira(s) cadastrada(s) no banco
	// na tabela
	public List<GrupoContaFinanceira> listGrupoContasFinanceiras() {

		ArrayList<GrupoContaFinanceira> lista = new ArrayList<GrupoContaFinanceira>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from grupo_conta_financeira";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoContaFinanceira grupoContasFinanceiras = new GrupoContaFinanceira();
				grupoContasFinanceiras.setCodigo(rs.getInt(1));
				grupoContasFinanceiras.setNome(rs.getString(2));
				lista.add(grupoContasFinanceiras);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// método que deleta um grupo de resultado na tabela
	public boolean deleteGrupoContaFinanceira(int idGrupo) throws SQLException {
		boolean resposta;

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conexao.prepareStatement("delete from grupo_conta_financeira where codigo = ?");
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
