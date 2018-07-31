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

import br.com.grupoferraz.financeiro.entity.BaixaChequeCR;
import br.com.grupoferraz.financeiro.entity.ContaFinanceira;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class BaixaChequeCRDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertBaixaChequeCR(BaixaChequeCR BaixaChequeCR) {
		try {
			StringBuilder str = new StringBuilder();
			str.append(
					"INSERT INTO financeiro.BaixaChequeCR (codigo,documento,emissao,vencimento,valor,vencimentobaixa,valorbaixa,desconto,juros,historico,contasfinanceiras_codigo,contasreceber_codigo,contasreceber_cpf,contasreceber_estabelecimentos_codigo,vencimentodiversoscr_codigo)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?,documento = ?,emissao = ?,vencimento = ?,valor = ?,vencimentobaixa = ?,valorbaixa = ?,desconto = ?,juros = ?,historico = ?,contasfinanceiras_codigo = ?,contasreceber_codigo = ?,contasreceber_cpf = ?,contasreceber_estabelecimentos_codigo = ?,vencimentodiversoscr_codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, BaixaChequeCR.getCodigo());
			preparedStatement.setInt(2, BaixaChequeCR.getDocumento());
			Date data = BaixaChequeCR.getEmissao();
			long t = 0;
			if (data != null) {
				t = data.getTime();
			}
			preparedStatement.setDate(3, new java.sql.Date(t));
			Date data2 = BaixaChequeCR.getVencimento();
			long t2 = 0;
			if (data != null) {
				t2 = data2.getTime();
			}
			preparedStatement.setDate(4, new java.sql.Date(t2));
			preparedStatement.setFloat(5, BaixaChequeCR.getValor());
			Date data3 = BaixaChequeCR.getVencimentobaixa();
			long t3 = 0;
			if (data3 != null) {
				t3 = data3.getTime();
			}
			preparedStatement.setDate(6, new java.sql.Date(t3));
			preparedStatement.setFloat(7, BaixaChequeCR.getValorbaixa());
			preparedStatement.setFloat(8, BaixaChequeCR.getDesconto());
			preparedStatement.setFloat(9, BaixaChequeCR.getJuros());
			preparedStatement.setString(10, BaixaChequeCR.getHistorico());
			preparedStatement.setInt(11, BaixaChequeCR.getContasfinanceiras_codigo());
			if (BaixaChequeCR.getContasreceber_codigo() != null) {
				preparedStatement.setInt(12, BaixaChequeCR.getContasreceber_codigo());
			} else {
				preparedStatement.setNull(12, Types.INTEGER);
			}
			preparedStatement.setString(13, BaixaChequeCR.getContasreceber_cpf());
			preparedStatement.setInt(14, BaixaChequeCR.getContasreceber_estabelecimentos_codigo());
			if (BaixaChequeCR.getVencimentosdiversoscr_codigo() != null) {
				preparedStatement.setInt(15, BaixaChequeCR.getVencimentosdiversoscr_codigo());
			} else {
				preparedStatement.setNull(15, Types.INTEGER);
			}
			preparedStatement.setInt(16, BaixaChequeCR.getCodigo());
			preparedStatement.setInt(17, BaixaChequeCR.getDocumento());
			preparedStatement.setDate(18, new java.sql.Date(t));
			preparedStatement.setDate(19, new java.sql.Date(t2));
			preparedStatement.setFloat(20, BaixaChequeCR.getValor());
			preparedStatement.setDate(21, new java.sql.Date(t3));
			preparedStatement.setFloat(22, BaixaChequeCR.getValorbaixa());
			preparedStatement.setFloat(23, BaixaChequeCR.getDesconto());
			preparedStatement.setFloat(24, BaixaChequeCR.getJuros());
			preparedStatement.setString(25, BaixaChequeCR.getHistorico());
			preparedStatement.setInt(26, BaixaChequeCR.getContasfinanceiras_codigo());
			if (BaixaChequeCR.getContasreceber_codigo() != null) {
				preparedStatement.setInt(27, BaixaChequeCR.getContasreceber_codigo());
			} else {
				preparedStatement.setNull(27, Types.INTEGER);
			}
			preparedStatement.setString(28, BaixaChequeCR.getContasreceber_cpf());
			preparedStatement.setInt(29, BaixaChequeCR.getContasreceber_estabelecimentos_codigo());
			if (BaixaChequeCR.getVencimentosdiversoscr_codigo() != null) {
				preparedStatement.setInt(30, BaixaChequeCR.getVencimentosdiversoscr_codigo());
			} else {
				preparedStatement.setNull(30, Types.INTEGER);
			}

			preparedStatement.execute();

			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todas os vencimentos diversos cadastrados no banco de dados
	public List<BaixaChequeCR> listBaixaChequeCR() {

		ArrayList<BaixaChequeCR> lista = new ArrayList<BaixaChequeCR>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from BaixaChequeCR ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				BaixaChequeCR BaixaChequeCR = new BaixaChequeCR();
				BaixaChequeCR.setCodigo(rs.getInt("codigo"));
				BaixaChequeCR.setContasreceber_cpf(rs.getString("contasreceber_cpf"));
				BaixaChequeCR.setDocumento(rs.getInt("documento"));
				BaixaChequeCR.setEmissao(rs.getDate("emissao"));
				BaixaChequeCR.setVencimento(rs.getDate("vencimento"));
				BaixaChequeCR.setContasreceber_codigo(rs.getInt("contasreceber_codigo"));
				BaixaChequeCR.setValor(rs.getFloat("valor"));
				BaixaChequeCR.setVencimentobaixa(rs.getDate("vencimentobaixa"));
				BaixaChequeCR.setValorbaixa(rs.getFloat("valorbaixa"));
				BaixaChequeCR.setDesconto(rs.getFloat("desconto"));
				BaixaChequeCR.setJuros(rs.getFloat("juros"));
				int obj1 = BaixaChequeCR.getContasfinanceiras_codigo();
				ContaFinanceira contasfinanceiras = getContasFinanceiras(obj1);
				BaixaChequeCR.setContasfinanceiras(contasfinanceiras);
				int obj2 = BaixaChequeCR.getContasreceber_estabelecimentos_codigo();
				Estabelecimento estabelecimento = getEstabelecimento(obj2);
				BaixaChequeCR.setEstabelecimento(estabelecimento);
				BaixaChequeCR.setHistorico(rs.getString("historico"));

				lista.add(BaixaChequeCR);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

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

	public ContaFinanceira getContasFinanceiras(int idGrupo) throws SQLException {
		ContaFinanceira grupo = new ContaFinanceira();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from contafinanceira where codigo = ?");
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
			grupo.setGrupocontafinanceira_codigo(rs.getInt("grupocontafinanceira_codigo"));
		}
		return grupo;
	}
}
