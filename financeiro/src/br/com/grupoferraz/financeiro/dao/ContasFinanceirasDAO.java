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

import br.com.grupoferraz.financeiro.entity.GrupoContasFinanceiras;
import br.com.grupoferraz.financeiro.entity.ContasFinanceiras;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ContasFinanceirasDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertContasFinanceiras(ContasFinanceiras ContasFinanceiras) {
		try {
			StringBuilder str = new StringBuilder();
			str.append("INSERT INTO financeiro.contasfinanceiras (codigo,nome,banco,agenciabanco,"
					+ "digagencia,conta,digconta,conta_contabil,observacao,grupocontasfinanceiras_codigo) "
					+ "values (?,?,?,?,?,?,?,?,?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?, banco = ?, agenciabanco = ?, digagencia = ?,"
					+ "conta = ?, digconta = ?, conta_contabil = ?, observacao = ?, grupocontasfinanceiras_codigo = ? ");
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
			preparedStatement.setInt(10, ContasFinanceiras.getGrupocontasfinanceiras_codigo());

			preparedStatement.setInt(11, ContasFinanceiras.getCodigo());
			preparedStatement.setString(12, ContasFinanceiras.getNome());
			preparedStatement.setString(13, ContasFinanceiras.getBanco());
			preparedStatement.setInt(14, ContasFinanceiras.getAgenciabanco());
			preparedStatement.setInt(15, ContasFinanceiras.getDigagencia());
			preparedStatement.setInt(16, ContasFinanceiras.getConta());
			preparedStatement.setInt(17, ContasFinanceiras.getDigconta());
			preparedStatement.setString(18, ContasFinanceiras.getConta_contabil());
			preparedStatement.setString(19, ContasFinanceiras.getObservacao());
			preparedStatement.setInt(20, ContasFinanceiras.getGrupocontasfinanceiras_codigo());

			preparedStatement.execute();

			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os ContasFinanceirass cadastrados no banco de dados
	public List<ContasFinanceiras> listContasFinanceiras() {

		ArrayList<ContasFinanceiras> lista = new ArrayList<ContasFinanceiras>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from contasfinanceiras ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				ContasFinanceiras ContasFinanceiras = new ContasFinanceiras();
				ContasFinanceiras.setCodigo(rs.getInt("codigo"));
				ContasFinanceiras.setNome(rs.getString("nome"));
				ContasFinanceiras.setGrupocontasfinanceiras_codigo(rs.getInt("grupocontasfinanceiras_codigo"));
				GrupoContasFinanceiras obj2 = getGrupoContaFinanceira(ContasFinanceiras.getGrupocontasfinanceiras_codigo());
				ContasFinanceiras.setGrupocontasfinanceiras(obj2);
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
	public GrupoContasFinanceiras getGrupoContaFinanceira(int idGrupo) throws SQLException {
		GrupoContasFinanceiras grupo = new GrupoContasFinanceiras();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao
				.prepareStatement("select codigo, nome from grupocontasfinanceiras where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
		}
		return grupo;
	}
}
