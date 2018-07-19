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
import br.com.grupoferraz.financeiro.entity.BaixaCP;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class BaixaCPDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertBaixaCP(BaixaCP baixa) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into baixa_cp (codigo, cpf, numerodoc, emissaocp, vencimentocp, numerotitulo, vencimentovalor, "
					+ "baixavencimentocp, valorbaixavencimento, valordescontobaixa, valorjurusbaixa, contafinanceira, "
					+ "estfinanceira, historico) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			str.append("on duplicate key update codigo = ?, cpf = ?, numerodoc = ?, emissaocp = ?, vencimentocp = ?, numerotitulo = ?, "
					+ "vencimentovalor = ?, baixavencimentocp = ?,  valorbaixavencimento = ?, valordescontobaixa = ?, "
					+ "valorjurusbaixa = ?, contafinanceira = ?, estfinanceira = ?, historico = ?");
			
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, baixa.getCodigo());
			preparedStatement.setString(2, baixa.getCpf());
			preparedStatement.setString(3, baixa.getNumerodoc());
			Date dataEmissaocp = baixa.getEmissaocp();
			long t = 0;
			if (dataEmissaocp != null ) {
				t = dataEmissaocp.getTime();	
			}
			preparedStatement.setDate(4, new java.sql.Date(t));
			Date dataVencimentocp = baixa.getVencimentocp();
			long j = 0;
			if (dataVencimentocp != null ) {
				j = dataVencimentocp.getTime();	
			}
			preparedStatement.setDate(5, new java.sql.Date(j));
			preparedStatement.setString(6, baixa.getNumerotitulo());
			preparedStatement.setString(7, baixa.getVencimentovalor());

			Date datagetBaixavencimentocp = baixa.getBaixavencimentocp();
			long k = 0;
			if (datagetBaixavencimentocp != null ) {
				k = datagetBaixavencimentocp.getTime();	
			}
			preparedStatement.setDate(8, new java.sql.Date(k));
			preparedStatement.setString(9, baixa.getValorbaixavencimento());
			preparedStatement.setString(10, baixa.getValordescontobaixa());
			preparedStatement.setString(11, baixa.getValorjurusbaixa());
			preparedStatement.setString(12, baixa.getContafinanceira());
			preparedStatement.setString(13, baixa.getEstfinanceira());
			preparedStatement.setString(14, baixa.getHistorico());
			
			preparedStatement.setInt(15, baixa.getCodigo());
			preparedStatement.setString(16, baixa.getCpf());
			preparedStatement.setString(17, baixa.getNumerodoc());
			preparedStatement.setDate(18, new java.sql.Date(t));
			preparedStatement.setDate(19, new java.sql.Date(k));
			preparedStatement.setString(20, baixa.getNumerotitulo());
			preparedStatement.setString(21, baixa.getVencimentovalor());
			preparedStatement.setDate(22, new java.sql.Date(k));
			preparedStatement.setString(23, baixa.getValorbaixavencimento());
			preparedStatement.setString(24, baixa.getValordescontobaixa());
			preparedStatement.setString(25, baixa.getValorjurusbaixa());
			preparedStatement.setString(26, baixa.getContafinanceira());
			preparedStatement.setString(27, baixa.getEstfinanceira());
			preparedStatement.setString(28, baixa.getHistorico());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<BaixaCP> listBaixa() {

		ArrayList<BaixaCP> lista = new ArrayList<BaixaCP>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigo, cpf, numerodoc, emissaocp, vencimentocp, numerotitulo, vencimentovalor, "
					+ 	"baixavencimentocp, valorbaixavencimento, valordescontobaixa, valorjurusbaixa, contafinanceira, "
					+ 	"estfinanceira, historico from baixa_cp";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				BaixaCP baixa = new BaixaCP();
				baixa.setCodigo(rs.getInt("codigo"));
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
				baixa.setContafinanceira(rs.getString("contafinanceira"));
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

}
