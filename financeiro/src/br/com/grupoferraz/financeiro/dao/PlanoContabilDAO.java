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

import br.com.grupoferraz.financeiro.entity.PlanoContabil;
import br.com.grupoferraz.financeiro.entity.GrupoPlanoContabil;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public final class PlanoContabilDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertPlanoContabil(PlanoContabil PlanoContabil) {
		try {
			StringBuilder str = new StringBuilder();
			str.append("INSERT INTO financeiro.planocontabil (codigo,nome,banco,agenciabanco,"
					+ "digagencia,conta,digconta,conta_contabil,observacao,grupoplanocontabil_codigo) "
					+ "values (?,?,?,?,?,?,?,?,?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?, banco = ?, agenciabanco = ?, digagencia = ?,"
					+ "conta = ?, digconta = ?, conta_contabil = ?, observacao = ?, grupoplanocontabil_codigo = ? ");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, PlanoContabil.getCodigo());
			preparedStatement.setString(2, PlanoContabil.getNome());
			preparedStatement.setString(3, PlanoContabil.getBanco());
			preparedStatement.setInt(4, PlanoContabil.getAgenciabanco());
			preparedStatement.setInt(5, PlanoContabil.getDigagencia());
			preparedStatement.setInt(6, PlanoContabil.getConta());
			preparedStatement.setInt(7, PlanoContabil.getDigconta());
			preparedStatement.setString(8, PlanoContabil.getConta_contabil());
			preparedStatement.setString(9, PlanoContabil.getObservacao());
			preparedStatement.setInt(10, PlanoContabil.getGrupoplanocontabil_codigo());

			preparedStatement.setInt(11, PlanoContabil.getCodigo());
			preparedStatement.setString(12, PlanoContabil.getNome());
			preparedStatement.setString(13, PlanoContabil.getBanco());
			preparedStatement.setInt(14, PlanoContabil.getAgenciabanco());
			preparedStatement.setInt(15, PlanoContabil.getDigagencia());
			preparedStatement.setInt(16, PlanoContabil.getConta());
			preparedStatement.setInt(17, PlanoContabil.getDigconta());
			preparedStatement.setString(18, PlanoContabil.getConta_contabil());
			preparedStatement.setString(19, PlanoContabil.getObservacao());
			preparedStatement.setInt(20, PlanoContabil.getGrupoplanocontabil_codigo());

			preparedStatement.execute();

			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os Planos Contabéis cadastrados no banco de dados
	public List<PlanoContabil> listPlanoContabil() {

		ArrayList<PlanoContabil> lista = new ArrayList<PlanoContabil>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from PlanoContabil ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				PlanoContabil PlanoContabil = new PlanoContabil();
				PlanoContabil.setCodigo(rs.getInt("codigo"));
				PlanoContabil.setNome(rs.getString("nome"));
				PlanoContabil.setGrupoplanocontabil_codigo(rs.getInt("grupoplanocontabil_codigo"));
				GrupoPlanoContabil obj2 = getGrupoContaContabil(PlanoContabil.getGrupoplanocontabil_codigo());
				PlanoContabil.setGrupoplanocontabil(obj2);
				PlanoContabil.setBanco(rs.getString("banco"));
				PlanoContabil.setAgenciabanco(rs.getInt("agenciabanco"));
				PlanoContabil.setDigagencia(rs.getInt("digagencia"));
				PlanoContabil.setConta(rs.getInt("conta"));
				PlanoContabil.setDigconta(rs.getInt("digconta"));
				PlanoContabil.setConta_contabil(rs.getString("conta_contabil"));
				PlanoContabil.setObservacao(rs.getString("observacao"));

				lista.add(PlanoContabil);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// Exibe o nome do grupo em vez do código na tela
	public GrupoPlanoContabil getGrupoContaContabil(int idGrupo) throws SQLException {
		GrupoPlanoContabil grupo = new GrupoPlanoContabil();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao
				.prepareStatement("select codigo, nome from grupoplanocontabil where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
		}
		return grupo;
	}	
}
