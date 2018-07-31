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

import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.BaixaDiversosCR;
import br.com.grupoferraz.financeiro.entity.ContaFinanceira;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class BaixaDiversosCRDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertBaixaDiversosCR(BaixaDiversosCR BaixaDiversosCR) {
		try {
			StringBuilder str = new StringBuilder();
			str.append(
					"INSERT INTO financeiro.baixadiversoscr (codigo,documento,emissao,vencimento,valor,vencimentobaixa,valorbaixa,desconto,juros,multa,historico,contasfinanceiras_codigo,contasreceber_codigo,contasreceber_cpf,contasreceber_estabelecimentos_codigo,vencimentodiversoscr_codigo)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?,documento = ?,emissao = ?,vencimento = ?,valor = ?,vencimentobaixa = ?,valorbaixa = ?,desconto = ?,juros = ?,multa = ?,historico = ?,contasfinanceiras_codigo = ?,contasreceber_codigo = ?,contasreceber_cpf = ?,contasreceber_estabelecimentos_codigo = ?,vencimentodiversoscr_codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, BaixaDiversosCR.getCodigo());
			preparedStatement.setInt(2, BaixaDiversosCR.getDocumento());
			Date data = BaixaDiversosCR.getEmissao();
			long t = 0;
			if (data != null) {
				t = data.getTime();
			}
			preparedStatement.setDate(3, new java.sql.Date(t));
			Date data2 = BaixaDiversosCR.getVencimento();
			long t2 = 0;
			if (data != null) {
				t2 = data2.getTime();
			}
			preparedStatement.setDate(4, new java.sql.Date(t2));
			preparedStatement.setFloat(5, BaixaDiversosCR.getValor());
			Date data3 = BaixaDiversosCR.getVencimentobaixa();
			long t3 = 0;
			if (data3 != null) {
				t3 = data3.getTime();
			}
			preparedStatement.setDate(6, new java.sql.Date(t3));
			preparedStatement.setFloat(7, BaixaDiversosCR.getValorbaixa());
			preparedStatement.setFloat(8, BaixaDiversosCR.getDesconto());
			preparedStatement.setFloat(9, BaixaDiversosCR.getJuros());
			preparedStatement.setFloat(10, BaixaDiversosCR.getMulta());
			preparedStatement.setString(11, BaixaDiversosCR.getHistorico());
			preparedStatement.setInt(12, BaixaDiversosCR.getContasfinanceiras_codigo());
			if (BaixaDiversosCR.getContasreceber_codigo() != null) {
			preparedStatement.setInt(13, BaixaDiversosCR.getContasreceber_codigo());
			}
			else {
				preparedStatement.setNull(13, Types.INTEGER);
			}
			preparedStatement.setString(14, BaixaDiversosCR.getContasreceber_cpf());
			preparedStatement.setInt(15, BaixaDiversosCR.getContasreceber_estabelecimentos_codigo());
			if (BaixaDiversosCR.getVencimentosdiversoscr_codigo() != null) {
			preparedStatement.setInt(16, BaixaDiversosCR.getVencimentosdiversoscr_codigo());
			}
			else {
				preparedStatement.setNull(16, Types.INTEGER);
			}
			preparedStatement.setInt(17, BaixaDiversosCR.getCodigo());
			preparedStatement.setInt(18, BaixaDiversosCR.getDocumento());
			preparedStatement.setDate(19, new java.sql.Date(t));
			preparedStatement.setDate(20, new java.sql.Date(t2));
			preparedStatement.setFloat(21, BaixaDiversosCR.getValor());
			preparedStatement.setDate(22, new java.sql.Date(t3));
			preparedStatement.setFloat(23, BaixaDiversosCR.getValorbaixa());
			preparedStatement.setFloat(24, BaixaDiversosCR.getDesconto());
			preparedStatement.setFloat(25, BaixaDiversosCR.getJuros());
			preparedStatement.setFloat(26, BaixaDiversosCR.getMulta());
			preparedStatement.setString(27, BaixaDiversosCR.getHistorico());
			preparedStatement.setInt(28, BaixaDiversosCR.getContasfinanceiras_codigo());
			if (BaixaDiversosCR.getContasreceber_codigo() != null) {
				preparedStatement.setInt(29, BaixaDiversosCR.getContasreceber_codigo());
				}
				else {
					preparedStatement.setNull(29, Types.INTEGER);
				}
			preparedStatement.setString(30, BaixaDiversosCR.getContasreceber_cpf());
			preparedStatement.setInt(31, BaixaDiversosCR.getContasreceber_estabelecimentos_codigo());
			if (BaixaDiversosCR.getVencimentosdiversoscr_codigo() != null) {
				preparedStatement.setInt(32, BaixaDiversosCR.getVencimentosdiversoscr_codigo());
				}
				else {
					preparedStatement.setNull(32, Types.INTEGER);
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
	public List<BaixaDiversosCR> listBaixaDiversosCR() {

		ArrayList<BaixaDiversosCR> lista = new ArrayList<BaixaDiversosCR>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from baixadiversoscr ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				BaixaDiversosCR BaixaDiversosCR = new BaixaDiversosCR();
				BaixaDiversosCR.setCodigo(rs.getInt("codigo"));
				BaixaDiversosCR.setContasreceber_cpf(rs.getString("contasreceber_cpf"));
				BaixaDiversosCR.setDocumento(rs.getInt("documento"));
				BaixaDiversosCR.setEmissao(rs.getDate("emissao"));
				BaixaDiversosCR.setVencimento(rs.getDate("vencimento"));
				BaixaDiversosCR.setContasreceber_codigo(rs.getInt("contasreceber_codigo"));
				BaixaDiversosCR.setValor(rs.getFloat("valor"));
				BaixaDiversosCR.setVencimentobaixa(rs.getDate("vencimentobaixa"));
				BaixaDiversosCR.setValorbaixa(rs.getFloat("valorbaixa"));
				BaixaDiversosCR.setDesconto(rs.getFloat("desconto"));
				BaixaDiversosCR.setJuros(rs.getFloat("juros"));
				BaixaDiversosCR.setMulta(rs.getFloat("multa"));
				int obj1 = BaixaDiversosCR.getContasfinanceiras_codigo();
				ContaFinanceira contasfinanceiras = getContasFinanceiras(obj1);
				BaixaDiversosCR.setContasfinanceiras(contasfinanceiras);
				int obj2 = BaixaDiversosCR.getContasreceber_estabelecimentos_codigo();
				Estabelecimento estabelecimento = getEstabelecimento(obj2);
				BaixaDiversosCR.setEstabelecimento(estabelecimento);
				BaixaDiversosCR.setHistorico(rs.getString("historico"));
				
				lista.add(BaixaDiversosCR);
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
			preparedStatement = conexao
					.prepareStatement ("select * from estabelecimentos where codigo = ?");
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
			preparedStatement = conexao
					.prepareStatement ("select * from contafinanceira where codigo = ?");
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
