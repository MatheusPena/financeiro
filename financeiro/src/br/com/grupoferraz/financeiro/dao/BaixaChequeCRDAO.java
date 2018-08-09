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
import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class BaixaChequeCRDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertBaixaChequeCR(BaixaChequeCR BaixaChequeCR) {
		try {
			StringBuilder str = new StringBuilder();
			str.append(
					"INSERT INTO financeiro.baixa_cheque_cr (codigo,documento,emissao,vencimento,valor,vencimentobaixa,valorbaixa,desconto,juros,historico,contafinanceira_codigo,contareceber_codigo,contareceber_cpf,contareceber_estabelecimento_codigo,vencimentochequecr_codigo,empresa_cnpj)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?,documento = ?,emissao = ?,vencimento = ?,valor = ?,vencimentobaixa = ?,valorbaixa = ?,desconto = ?,juros = ?,historico = ?,contafinanceira_codigo = ?,contareceber_codigo = ?,contareceber_cpf = ?,contareceber_estabelecimento_codigo = ?,vencimentochequecr_codigo = ?,empresa_cnpj = ?");
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
			preparedStatement.setBigDecimal(5, BaixaChequeCR.getValor());
			Date data3 = BaixaChequeCR.getVencimentobaixa();
			long t3 = 0;
			if (data3 != null) {
				t3 = data3.getTime();
			}
			preparedStatement.setDate(6, new java.sql.Date(t3));
			preparedStatement.setBigDecimal(7, BaixaChequeCR.getValorbaixa());
			preparedStatement.setBigDecimal(8, BaixaChequeCR.getDesconto());
			preparedStatement.setBigDecimal(9, BaixaChequeCR.getJuros());
			preparedStatement.setString(10, BaixaChequeCR.getHistorico());
			preparedStatement.setInt(11, BaixaChequeCR.getContafinanceira_codigo());
			if (BaixaChequeCR.getContareceber_codigo() != null) {
				preparedStatement.setInt(12, BaixaChequeCR.getContareceber_codigo());
			} else {
				preparedStatement.setNull(12, Types.INTEGER);
			}
			preparedStatement.setString(13, BaixaChequeCR.getContareceber_cpf());
			preparedStatement.setInt(14, BaixaChequeCR.getContareceber_estabelecimento_codigo());
			if (BaixaChequeCR.getVencimentodiversocr_codigo() != null) {
				preparedStatement.setInt(15, BaixaChequeCR.getVencimentodiversocr_codigo());
			} else {
				preparedStatement.setNull(15, Types.INTEGER);
			}
			preparedStatement.setString(16, BaixaChequeCR.getEmpresa_cnpj());

			preparedStatement.setInt(17, BaixaChequeCR.getCodigo());
			preparedStatement.setInt(18, BaixaChequeCR.getDocumento());
			preparedStatement.setDate(19, new java.sql.Date(t));
			preparedStatement.setDate(20, new java.sql.Date(t2));
			preparedStatement.setBigDecimal(21, BaixaChequeCR.getValor());
			preparedStatement.setDate(22, new java.sql.Date(t3));
			preparedStatement.setBigDecimal(23, BaixaChequeCR.getValorbaixa());
			preparedStatement.setBigDecimal(24, BaixaChequeCR.getDesconto());
			preparedStatement.setBigDecimal(25, BaixaChequeCR.getJuros());
			preparedStatement.setString(26, BaixaChequeCR.getHistorico());
			preparedStatement.setInt(27, BaixaChequeCR.getContafinanceira_codigo());
			if (BaixaChequeCR.getContareceber_codigo() != null) {
				preparedStatement.setInt(28, BaixaChequeCR.getContareceber_codigo());
			} else {
				preparedStatement.setNull(28, Types.INTEGER);
			}
			preparedStatement.setString(29, BaixaChequeCR.getContareceber_cpf());
			preparedStatement.setInt(30, BaixaChequeCR.getContareceber_estabelecimento_codigo());
			if (BaixaChequeCR.getVencimentodiversocr_codigo() != null) {
				preparedStatement.setInt(31, BaixaChequeCR.getVencimentodiversocr_codigo());
			} else {
				preparedStatement.setNull(31, Types.INTEGER);
			}
			preparedStatement.setString(32, BaixaChequeCR.getEmpresa_cnpj());

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
			String sql = "select * from baixa_cheque_cr ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				BaixaChequeCR BaixaChequeCR = new BaixaChequeCR();
				BaixaChequeCR.setCodigo(rs.getInt("codigo"));
				BaixaChequeCR.setContareceber_cpf(rs.getString("contareceber_cpf"));
				BaixaChequeCR.setDocumento(rs.getInt("documento"));
				BaixaChequeCR.setEmissao(rs.getDate("emissao"));
				BaixaChequeCR.setVencimento(rs.getDate("vencimento"));
				BaixaChequeCR.setContareceber_codigo(rs.getInt("contareceber_codigo"));
				BaixaChequeCR.setValor(rs.getBigDecimal("valor"));
				BaixaChequeCR.setVencimentobaixa(rs.getDate("vencimentobaixa"));
				BaixaChequeCR.setValorbaixa(rs.getBigDecimal("valorbaixa"));
				BaixaChequeCR.setDesconto(rs.getBigDecimal("desconto"));
				BaixaChequeCR.setJuros(rs.getBigDecimal("juros"));
				BaixaChequeCR.setContafinanceira_codigo(rs.getInt("contafinanceira_codigo"));
				int obj1 = BaixaChequeCR.getContafinanceira_codigo();
				ContaFinanceira contafinanceira = getContaFinanceira(obj1);
				BaixaChequeCR.setContafinanceira(contafinanceira);
				BaixaChequeCR.setEmpresa_cnpj(rs.getString("empresa_cnpj"));
				String emp = BaixaChequeCR.getEmpresa_cnpj();
				Empresa empresa = getEmpresa(emp);
				BaixaChequeCR.setEmpresa(empresa);
				BaixaChequeCR.setContareceber_estabelecimento_codigo(rs.getInt("contareceber_estabelecimento_codigo"));
				int obj2 = BaixaChequeCR.getContareceber_estabelecimento_codigo();
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

	// lista os estabelecimentos
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

	// lista as contas financeiras
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
