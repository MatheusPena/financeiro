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

import br.com.grupoferraz.financeiro.entity.Historico;
import br.com.grupoferraz.financeiro.entity.DespesaReceita;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class HistoricoDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertHistorico(Historico historicos) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into historico (codigo, descricao, despesa_codigo) values (?,?,?) ");
			str.append("on duplicate key update codigo = ?, descricao = ?, despesa_codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, historicos.getCodigo());
			preparedStatement.setString(2, historicos.getDescricao());
			preparedStatement.setInt(3, historicos.getDespesa_codigo());

			preparedStatement.setInt(4, historicos.getCodigo());
			preparedStatement.setString(5, historicos.getDescricao());
			preparedStatement.setInt(6, historicos.getDespesa_codigo());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Historico> listHistoricos() {

		ArrayList<Historico> lista = new ArrayList<Historico>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigo, descricao, despesa_codigo from historico ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Historico historicos = new Historico();
				historicos.setCodigo(rs.getInt("codigo"));
				historicos.setDescricao(rs.getString("descricao"));
				historicos.setDespesa_codigo(rs.getInt("despesa_codigo"));
				int idDespesa = historicos.getDespesa_codigo();
				DespesaReceita despesas = getDespesas(idDespesa);
				historicos.setDespesa(despesas);
				lista.add(historicos);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	//Lista as despesas cadastradas na tela dos Históricos
	public DespesaReceita getDespesas(int idDespesa) throws SQLException {
		DespesaReceita despesa = new DespesaReceita();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select codigo, nome from despesa where codigo = ?");
		preparedStatement.setInt(1, idDespesa);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			despesa.setCodigo(rs.getInt("codigo"));
			despesa.setNome(rs.getString("nome"));
		}
		return despesa;
	}
}
