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
import br.com.grupoferraz.financeiro.entity.BaixaDiversoCR;
import br.com.grupoferraz.financeiro.entity.ContaFinanceira;
import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class BaixaDiversoCRDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertBaixaDiversoCR(BaixaDiversoCR BaixaDiversoCR) {
		try {
			StringBuilder str = new StringBuilder();
			str.append(
					"INSERT INTO financeiro.baixa_diverso_cr (codigo,documento,emissao,vencimento,valor,vencimentobaixa,valorbaixa,desconto,juros,multa,historico,contafinanceira_codigo,contareceber_codigo,contareceber_cpf,contareceber_estabelecimento_codigo,vencimentodiversocr_codigo,empresa_cnpj)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?,documento = ?,emissao = ?,vencimento = ?,valor = ?,vencimentobaixa = ?,valorbaixa = ?,desconto = ?,juros = ?,multa = ?,historico = ?,contafinanceira_codigo = ?,contareceber_codigo = ?,contareceber_cpf = ?,contareceber_estabelecimento_codigo = ?,vencimentodiversocr_codigo = ?,empresa_cnpj=?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, BaixaDiversoCR.getCodigo());
			preparedStatement.setInt(2, BaixaDiversoCR.getDocumento());
			Date data = BaixaDiversoCR.getEmissao();
			long t = 0;
			if (data != null) {
				t = data.getTime();
			}
			preparedStatement.setDate(3, new java.sql.Date(t));
			Date data2 = BaixaDiversoCR.getVencimento();
			long t2 = 0;
			if (data != null) {
				t2 = data2.getTime();
			}
			preparedStatement.setDate(4, new java.sql.Date(t2));
			preparedStatement.setBigDecimal(5, BaixaDiversoCR.getValor());
			Date data3 = BaixaDiversoCR.getVencimentobaixa();
			long t3 = 0;
			if (data3 != null) {
				t3 = data3.getTime();
			}
			preparedStatement.setDate(6, new java.sql.Date(t3));
			preparedStatement.setBigDecimal(7, BaixaDiversoCR.getValorbaixa());
			preparedStatement.setBigDecimal(8, BaixaDiversoCR.getDesconto());
			preparedStatement.setBigDecimal(9, BaixaDiversoCR.getJuros());
			preparedStatement.setBigDecimal(10, BaixaDiversoCR.getMulta());
			preparedStatement.setString(11, BaixaDiversoCR.getHistorico());
			preparedStatement.setInt(12, BaixaDiversoCR.getContafinanceira_codigo());
			if (BaixaDiversoCR.getContareceber_codigo() != null) {
				preparedStatement.setInt(13, BaixaDiversoCR.getContareceber_codigo());
			} else {
				preparedStatement.setNull(13, Types.INTEGER);
			}
			preparedStatement.setString(14, BaixaDiversoCR.getContareceber_cpf());
			preparedStatement.setInt(15, BaixaDiversoCR.getContareceber_estabelecimento_codigo());
			if (BaixaDiversoCR.getVencimentodiversocr_codigo() != null) {
				preparedStatement.setInt(16, BaixaDiversoCR.getVencimentodiversocr_codigo());
			} else {
				preparedStatement.setNull(16, Types.INTEGER);
			}
			preparedStatement.setString(17, BaixaDiversoCR.getEmpresa_cnpj());

			preparedStatement.setInt(18, BaixaDiversoCR.getCodigo());
			preparedStatement.setInt(19, BaixaDiversoCR.getDocumento());
			preparedStatement.setDate(20, new java.sql.Date(t));
			preparedStatement.setDate(21, new java.sql.Date(t2));
			preparedStatement.setBigDecimal(22, BaixaDiversoCR.getValor());
			preparedStatement.setDate(23, new java.sql.Date(t3));
			preparedStatement.setBigDecimal(24, BaixaDiversoCR.getValorbaixa());
			preparedStatement.setBigDecimal(25, BaixaDiversoCR.getDesconto());
			preparedStatement.setBigDecimal(26, BaixaDiversoCR.getJuros());
			preparedStatement.setBigDecimal(27, BaixaDiversoCR.getMulta());
			preparedStatement.setString(28, BaixaDiversoCR.getHistorico());
			preparedStatement.setInt(29, BaixaDiversoCR.getContafinanceira_codigo());
			if (BaixaDiversoCR.getContareceber_codigo() != null) {
				preparedStatement.setInt(30, BaixaDiversoCR.getContareceber_codigo());
			} else {
				preparedStatement.setNull(30, Types.INTEGER);
			}
			preparedStatement.setString(31, BaixaDiversoCR.getContareceber_cpf());
			preparedStatement.setInt(32, BaixaDiversoCR.getContareceber_estabelecimento_codigo());
			if (BaixaDiversoCR.getVencimentodiversocr_codigo() != null) {
				preparedStatement.setInt(33, BaixaDiversoCR.getVencimentodiversocr_codigo());
			} else {
				preparedStatement.setNull(33, Types.INTEGER);
			}
			preparedStatement.setString(34, BaixaDiversoCR.getEmpresa_cnpj());

			preparedStatement.execute();

			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todas os vencimentos diversos cadastrados no banco de dados
	public List<BaixaDiversoCR> listBaixaDiversoCR() {

		ArrayList<BaixaDiversoCR> lista = new ArrayList<BaixaDiversoCR>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from baixa_diverso_cr ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				BaixaDiversoCR BaixaDiversoCR = new BaixaDiversoCR();
				BaixaDiversoCR.setCodigo(rs.getInt("codigo"));
				BaixaDiversoCR.setContareceber_cpf(rs.getString("contareceber_cpf"));
				BaixaDiversoCR.setDocumento(rs.getInt("documento"));
				BaixaDiversoCR.setEmissao(rs.getDate("emissao"));
				BaixaDiversoCR.setVencimento(rs.getDate("vencimento"));
				BaixaDiversoCR.setContareceber_codigo(rs.getInt("contareceber_codigo"));
				BaixaDiversoCR.setValor(rs.getBigDecimal("valor"));
				BaixaDiversoCR.setVencimentobaixa(rs.getDate("vencimentobaixa"));
				BaixaDiversoCR.setValorbaixa(rs.getBigDecimal("valorbaixa"));
				BaixaDiversoCR.setDesconto(rs.getBigDecimal("desconto"));
				BaixaDiversoCR.setJuros(rs.getBigDecimal("juros"));
				BaixaDiversoCR.setMulta(rs.getBigDecimal("multa"));
				int obj1 = BaixaDiversoCR.getContafinanceira_codigo();
				ContaFinanceira contafinanceira = getContaFinanceira(obj1);
				BaixaDiversoCR.setContafinanceira(contafinanceira);
				String obj3 = BaixaDiversoCR.getEmpresa_cnpj();
				Empresa empresa = getEmpresa(obj3);
				BaixaDiversoCR.setEmpresa(empresa);
				int obj2 = BaixaDiversoCR.getContareceber_estabelecimento_codigo();
				Estabelecimento estabelecimento = getEstabelecimento(obj2);
				BaixaDiversoCR.setEstabelecimento(estabelecimento);
				BaixaDiversoCR.setHistorico(rs.getString("historico"));
				
				lista.add(BaixaDiversoCR);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// Exibe o nome da empresa em vez do cnpj na tela
	public Empresa getEmpresa(String idEmpresa) throws SQLException {
		Empresa empresa = new Empresa();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select cnpj, nome from empresa where cnpj = ?");
		preparedStatement.setString(1, idEmpresa);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			empresa.setCnpj(rs.getString("cnpj"));
			empresa.setNome(rs.getString("nome"));
		}
		return empresa;
	}

	// lista os estabelecimentos cadastrados no banco de dados
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

	// lista as contas financeiras cadastradas no banco de dados
	public ContaFinanceira getContaFinanceira(int idGrupo) throws SQLException {
		ContaFinanceira grupo = new ContaFinanceira();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from conta_financeira where codigo = ?");
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
			grupo.setObservacao(rs.getString("observacao"));
			grupo.setGrupocontafinanceira_codigo(rs.getInt("grupocontafinanceira_codigo"));
		}
		return grupo;
	}
}
