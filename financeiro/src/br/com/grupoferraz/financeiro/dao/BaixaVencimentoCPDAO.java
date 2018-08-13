package br.com.grupoferraz.financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.grupoferraz.financeiro.entity.BaixaVencimentoCP;
import br.com.grupoferraz.financeiro.entity.ContaFinanceira;
import br.com.grupoferraz.financeiro.entity.ContaPagar;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class BaixaVencimentoCPDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertBaixaCP(BaixaVencimentoCP baixa) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into baixa_cp (codigo, conta_codigo, conta_nome, cpf, numerodoc, emissaocp, vencimentocp,"
					+ " numerotitulo, vencimentovalor, "
					+ "baixavencimentocp, valorbaixavencimento, valordescontobaixa, valorjurusbaixa, contafinanceira_codigo, "
					+ "estfinanceira, historico) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			str.append("on duplicate key update codigo = ?, conta_codigo = ?, conta_nome = ?, cpf = ?, "
					+ "numerodoc = ?, emissaocp = ?, vencimentocp = ?, numerotitulo = ?, "
					+ "vencimentovalor = ?, baixavencimentocp = ?,  valorbaixavencimento = ?, valordescontobaixa = ?, "
					+ "valorjurusbaixa = ?, contafinanceira_codigo = ?, estfinanceira = ?, historico = ?");
			
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, baixa.getCodigo());
			preparedStatement.setInt(2, baixa.getConta_codigo());
			preparedStatement.setString(3, baixa.getConta_nome());
			preparedStatement.setString(4, baixa.getCpf());
			preparedStatement.setString(5, baixa.getNumerodoc());
			Date dataEmissaocp = baixa.getEmissaocp();
			long t = 0;
			if (dataEmissaocp != null ) {
				t = dataEmissaocp.getTime();	
			}
			preparedStatement.setDate(6, new java.sql.Date(t));
			Date dataVencimentocp = baixa.getVencimentocp();
			long j = 0;
			if (dataVencimentocp != null ) {
				j = dataVencimentocp.getTime();	
			}
			preparedStatement.setDate(7, new java.sql.Date(j));
			preparedStatement.setString(8, baixa.getNumerotitulo());
			preparedStatement.setString(9, baixa.getVencimentovalor());

			Date datagetBaixavencimentocp = baixa.getBaixavencimentocp();
			long k = 0;
			if (datagetBaixavencimentocp != null ) {
				k = datagetBaixavencimentocp.getTime();	
			}
			preparedStatement.setDate(10, new java.sql.Date(k));
			preparedStatement.setString(11, baixa.getValorbaixavencimento());
			preparedStatement.setString(12, baixa.getValordescontobaixa());
			preparedStatement.setString(13, baixa.getValorjurusbaixa());
			preparedStatement.setInt(14, baixa.getContafinanceira_codigo());
			preparedStatement.setString(15, baixa.getEstfinanceira());
			preparedStatement.setString(16, baixa.getHistorico());
			
			preparedStatement.setInt(17, baixa.getCodigo());
			preparedStatement.setInt(18, baixa.getConta_codigo());
			preparedStatement.setString(19, baixa.getConta_nome());
			preparedStatement.setString(20, baixa.getCpf());
			preparedStatement.setString(21, baixa.getNumerodoc());
			preparedStatement.setDate(22, new java.sql.Date(t));
			preparedStatement.setDate(23, new java.sql.Date(k));
			preparedStatement.setString(24, baixa.getNumerotitulo());
			preparedStatement.setString(25, baixa.getVencimentovalor());
			preparedStatement.setDate(26, new java.sql.Date(k));
			preparedStatement.setString(27, baixa.getValorbaixavencimento());
			preparedStatement.setString(28, baixa.getValordescontobaixa());
			preparedStatement.setString(29, baixa.getValorjurusbaixa());
			preparedStatement.setInt(30, baixa.getContafinanceira_codigo());
			preparedStatement.setString(31, baixa.getEstfinanceira());
			preparedStatement.setString(32, baixa.getHistorico());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<BaixaVencimentoCP> listBaixa() {

		ArrayList<BaixaVencimentoCP> lista = new ArrayList<BaixaVencimentoCP>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigo, conta_codigo, conta_nome, cpf, numerodoc, emissaocp,"
					+ 	"vencimentocp, numerotitulo, vencimentovalor, "
					+ 	"baixavencimentocp, valorbaixavencimento, valordescontobaixa, valorjurusbaixa, contafinanceira_codigo, "
					+ 	"estfinanceira, historico from baixa_cp";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				BaixaVencimentoCP baixa = new BaixaVencimentoCP();
				baixa.setCodigo(rs.getInt("codigo"));
				baixa.setConta_codigo(rs.getInt("conta_codigo"));
				ContaPagar contapagar = getContapagar(baixa.getConta_codigo());
				baixa.setContapagar(contapagar);
				baixa.setConta_nome(rs.getString("conta_nome"));
				baixa.setCpf(rs.getString("cpf"));
				baixa.setNumerodoc(rs.getString("numerodoc"));
				baixa.setEmissaocp(rs.getDate("emissaocp"));
				baixa.setVencimentocp(rs.getDate("vencimentocp"));
				baixa.setNumerotitulo(rs.getString("numerotitulo"));
				baixa.setVencimentovalor(rs.getString("vencimentovalor"));
				baixa.setBaixavencimentocp(rs.getDate("baixavencimentocp"));
				baixa.setValorbaixavencimento(rs.getString("valorbaixavencimento"));
				baixa.setValordescontobaixa(rs.getString("valordescontobaixa"));
				baixa.setValorjurusbaixa(rs.getString("valorjurusbaixa"));
				baixa.setContafinanceira_codigo(rs.getInt("contafinanceira_codigo"));
				ContaFinanceira contafinanceira = getContafinanceira(baixa.getContafinanceira_codigo());	
				baixa.setContafinanceira(contafinanceira);
				baixa.setEstfinanceira(rs.getString("estfinanceira"));
				baixa.setHistorico(rs.getString("historico"));
				lista.add(baixa);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
//	Lista as Contas Financeiras cadastradas e exibe-as na tela de Contas à Pagar.
	public ContaFinanceira getContafinanceira(int idContafinanceira) throws SQLException {
		ContaFinanceira contafinanceira = new ContaFinanceira();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select codigo, nome from conta_financeira where codigo = ?");
		preparedStatement.setInt(1, idContafinanceira);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			contafinanceira.setCodigo(rs.getInt("codigo"));
			contafinanceira.setNome(rs.getString("nome"));
		}
		return contafinanceira;
	}
	
//	Lista as Contas a Pagar cadastradas e exibe-as na tela de Contas à Pagar.
	public ContaPagar getContapagar(int idContapagar) throws SQLException {
		ContaPagar contapagar = new ContaPagar();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select codigocp, contapagar_nome from conta_pagar where codigocp = ?");
		preparedStatement.setInt(1, idContapagar);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			contapagar.setCodigocp(rs.getInt("codigocp"));
			contapagar.setContapagar_nome(rs.getString("contapagar_nome"));
		}
		return contapagar;
	}	

}
