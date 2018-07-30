package br.com.grupoferraz.financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.grupoferraz.financeiro.entity.CentroResultado;
import br.com.grupoferraz.financeiro.entity.ContasFinanceiras;
import br.com.grupoferraz.financeiro.entity.Despesa;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.Historico;
import br.com.grupoferraz.financeiro.entity.Adiantamento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class AdiantamentoDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertAdiantamento(Adiantamento Adiantamento) {

		try {

			StringBuilder str = new StringBuilder();
			str.append(
					"insert into adiantamento (codigo,data,valor,observacao,estabelecimentos_codigo,fornecedores_cpf,contasfinanceiras_codigo,centroresultados_codigo,despesas_codigo,historico_codigo)"
							+ "values (?,?,?,?,?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?,data = ?,valor = ?,observacao = ?,estabelecimentos_codigo = ?,fornecedores_cpf = ?,contasfinanceiras_codigo = ?,centroresultados_codigo = ?,despesas_codigo = ?,historico_codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, Adiantamento.getCodigo());
			Date data = Adiantamento.getData();
			long t = 0;
			if (data != null) {
				t = data.getTime();
			}
			preparedStatement.setDate(2, new java.sql.Date(t));
			preparedStatement.setFloat(3, Adiantamento.getValor());
			preparedStatement.setString(4, Adiantamento.getObservacao());
			preparedStatement.setInt(5, Adiantamento.getEstabelecimento_codigo());
			preparedStatement.setString(6, Adiantamento.getFornecedorcpf());
			preparedStatement.setInt(7, Adiantamento.getContafinanceira_codigo());
			preparedStatement.setInt(8, Adiantamento.getCentroresultado_codigo());
			preparedStatement.setInt(9, Adiantamento.getDespesa_codigo());
			if (Adiantamento.getHistoricopadrao_codigo() != null) {
				preparedStatement.setInt(10, Adiantamento.getHistoricopadrao_codigo());
			} else {
				preparedStatement.setNull(10, Types.INTEGER);
			}

			preparedStatement.setInt(11, Adiantamento.getCodigo());
			preparedStatement.setDate(12, new java.sql.Date(t));
			preparedStatement.setFloat(13, Adiantamento.getValor());
			preparedStatement.setString(14, Adiantamento.getObservacao());
			preparedStatement.setInt(15, Adiantamento.getEstabelecimento_codigo());
			preparedStatement.setString(16, Adiantamento.getFornecedorcpf());
			preparedStatement.setInt(17, Adiantamento.getContafinanceira_codigo());
			preparedStatement.setInt(18, Adiantamento.getCentroresultado_codigo());
			preparedStatement.setInt(19, Adiantamento.getDespesa_codigo());
			if (Adiantamento.getHistoricopadrao_codigo() != null) {
				preparedStatement.setInt(20, Adiantamento.getHistoricopadrao_codigo());
			} else {
				preparedStatement.setNull(20, Types.INTEGER);
			}

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Adiantamento> listAdiantamento() {

		ArrayList<Adiantamento> lista = new ArrayList<Adiantamento>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from adiantamento";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Adiantamento Adiantamento = new Adiantamento();
				Adiantamento.setCodigo(rs.getInt(1));
				Adiantamento.setEstabelecimento_codigo(rs.getInt(5));
				Estabelecimento obj1 = getEstabelecimento(Adiantamento.getEstabelecimento_codigo());
				Adiantamento.setEstabelecimento(obj1);
				Adiantamento.setData(rs.getDate(2));
				Adiantamento.setFornecedorcpf(rs.getString(6));
				Adiantamento.setContafinanceira_codigo(rs.getInt(7));
				ContasFinanceiras obj2 = getContaFinanceira(Adiantamento.getContafinanceira_codigo());
				Adiantamento.setContafinanceira(obj2);
				Adiantamento.setCentroresultado_codigo(rs.getInt(8));
				CentroResultado obj3 = getCentroResultados(Adiantamento.getCentroresultado_codigo());
				Adiantamento.setCentroresultado(obj3);
				Adiantamento.setDespesa_codigo(rs.getInt(9));
				Despesa obj4 = getDespesa(Adiantamento.getDespesa_codigo());
				Adiantamento.setDespesa(obj4);
				Adiantamento.setValor(rs.getFloat(3));
				Adiantamento.setHistoricopadrao_codigo(rs.getInt(10));
				Historico obj5 = getHistoricoPadrao(Adiantamento.getHistoricopadrao_codigo());
				Adiantamento.setHistorico(obj5);
				Adiantamento.setObservacao(rs.getString(4));

				lista.add(Adiantamento);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	public Despesa getDespesa(int idGrupo) throws SQLException {
		Despesa grupo = new Despesa();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from despesa where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
			grupo.setGrupodespesa_codigo(rs.getInt("grupodespesa_codigo"));
		}
		return grupo;
	}

	// Exibe o nome da agência em vez do código na tela
	public Estabelecimento getEstabelecimento(int idGrupo) throws SQLException {
		Estabelecimento grupo = new Estabelecimento();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from estabelecimento where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
			grupo.setGrupoestabelecimento_codigo(rs.getInt("grupoestabelecimento_codigo"));
		}
		return grupo;
	}

	public ContasFinanceiras getContaFinanceira(int idGrupo) throws SQLException {
		ContasFinanceiras grupo = new ContasFinanceiras();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from contasfinanceira where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
			grupo.setBanco(rs.getString("banco"));
			grupo.setAgenciabanco(rs.getInt("agenciabanco"));
			grupo.setDigagencia(rs.getInt("digagencia"));
			grupo.setConta(rs.getInt("conta"));
			grupo.setDigconta(rs.getInt("digconta"));
			grupo.setConta_contabil(rs.getString("conta_contabil"));
			grupo.setObservacao(rs.getString("observacao"));
			grupo.setGrupocontasfinanceiras_codigo(rs.getInt("grupocontasfinanceiras_codigo"));
		}
		return grupo;
	}

	public CentroResultado getCentroResultados(int idGrupo) throws SQLException {
		CentroResultado grupo = new CentroResultado();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from centroresultado where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
			grupo.setAtividade(rs.getString("atividade"));
			grupo.setCrcontabil(rs.getString("crcontabil"));
			grupo.setPeso(rs.getBigDecimal("peso"));
			grupo.setGrupocentroresultados_codigo(rs.getInt("grupocentroresultados_codigo"));
		}
		return grupo;
	}

	public Historico getHistoricoPadrao(int idGrupo) throws SQLException {
		Historico grupo = new Historico();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from historico where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setDescricao(rs.getString("descricao"));
			grupo.setDespesa_codigo(rs.getInt("despesa_codigo"));
		}
		return grupo;
	}

}
