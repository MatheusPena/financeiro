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
import br.com.grupoferraz.financeiro.entity.ContaFinanceira;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ContaFinanceiraDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertContasFinanceiras(ContaFinanceira ContasFinanceiras) {
		try {
			StringBuilder str = new StringBuilder();
			str.append("INSERT INTO financeiro.contafinanceira (codigo,nome,banco,agenciabanco,"
					+ "digagencia,conta,digconta,conta_contabil,observacao,grupocontafinanceira_codigo) "
					+ "values (?,?,?,?,?,?,?,?,?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?, banco = ?, agenciabanco = ?, digagencia = ?,"
					+ "conta = ?, digconta = ?, conta_contabil = ?, observacao = ?, grupocontafinanceira_codigo = ? ");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, ContasFinanceiras.getCodigo());
			preparedStatement.setString(2, ContasFinanceiras.getNome());
			preparedStatement.setString(3, ContasFinanceiras.getBanco());
			preparedStatement.setInt(4, ContasFinanceiras.getAgenciabanco());
			preparedStatement.setInt(5, ContasFinanceiras.getDigagencia());
			preparedStatement.setInt(6, ContasFinanceiras.getConta());
			preparedStatement.setInt(7, ContasFinanceiras.getDigconta());
			preparedStatement.setString(8, ContasFinanceiras.getConta_contabil());
			preparedStatement.setString(9, ContasFinanceiras.getObservacao());
			preparedStatement.setInt(10, ContasFinanceiras.getGrupocontafinanceira_codigo());

			preparedStatement.setInt(11, ContasFinanceiras.getCodigo());
			preparedStatement.setString(12, ContasFinanceiras.getNome());
			preparedStatement.setString(13, ContasFinanceiras.getBanco());
			preparedStatement.setInt(14, ContasFinanceiras.getAgenciabanco());
			preparedStatement.setInt(15, ContasFinanceiras.getDigagencia());
			preparedStatement.setInt(16, ContasFinanceiras.getConta());
			preparedStatement.setInt(17, ContasFinanceiras.getDigconta());
			preparedStatement.setString(18, ContasFinanceiras.getConta_contabil());
			preparedStatement.setString(19, ContasFinanceiras.getObservacao());
			preparedStatement.setInt(20, ContasFinanceiras.getGrupocontafinanceira_codigo());

			preparedStatement.execute();

			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os ContasFinanceirass cadastrados no banco de dados
	public List<ContaFinanceira> listContasFinanceiras() {

		ArrayList<ContaFinanceira> lista = new ArrayList<ContaFinanceira>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from contafinanceira ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				ContaFinanceira ContasFinanceiras = new ContaFinanceira();
				ContasFinanceiras.setCodigo(rs.getInt("codigo"));
				ContasFinanceiras.setNome(rs.getString("nome"));
				ContasFinanceiras.setGrupocontafinanceira_codigo(rs.getInt("grupocontafinanceira_codigo"));
				GrupoContaFinanceira obj2 = getGrupoContaFinanceira(ContasFinanceiras.getGrupocontafinanceira_codigo());
				ContasFinanceiras.setGrupocontafinanceira(obj2);
				ContasFinanceiras.setBanco(rs.getString("banco"));
				ContasFinanceiras.setAgenciabanco(rs.getInt("agenciabanco"));
				ContasFinanceiras.setDigagencia(rs.getInt("digagencia"));
				ContasFinanceiras.setConta(rs.getInt("conta"));
				ContasFinanceiras.setDigconta(rs.getInt("digconta"));
				ContasFinanceiras.setConta_contabil(rs.getString("conta_contabil"));
				ContasFinanceiras.setObservacao(rs.getString("observacao"));

				lista.add(ContasFinanceiras);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// Exibe o nome do grupo em vez do código na tela
	public GrupoContaFinanceira getGrupoContaFinanceira(int idGrupo) throws SQLException {
		GrupoContaFinanceira grupo = new GrupoContaFinanceira();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao
				.prepareStatement("select codigo, nome from grupocontafinanceira where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
		}
		return grupo;
	}
}
