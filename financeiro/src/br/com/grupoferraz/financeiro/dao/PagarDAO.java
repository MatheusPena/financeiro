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
import br.com.grupoferraz.financeiro.entity.Pagar;
import br.com.grupoferraz.financeiro.entity.CentroResultados;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class PagarDAO { 
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertContasPagar(Pagar pagarconta) {

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();
			str.append("insert into contapagar (codigocp, estabelecimentos_codigo, "
					+ "cpf, codigo, emissaocp, valor, "
					+ "centroresultados_codigo, tipodocumento, emissaodp ) values (?,?,?,?,?,?,?,?,?) ");
			str.append("on duplicate key update codigocp = ?, estabelecimentos_codigo = ?, cpf = ?,"
					+ "codigo = ?, emissaocp = ?, valor = ?, centroresultados_codigo = ?,"
					+ "tipodocumento = ?, emissaodp = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, pagarconta.getCodigocp());
			preparedStatement.setInt(2, pagarconta.getEstabelecimentos_codigo());
			preparedStatement.setString(3, pagarconta.getCpf());
			preparedStatement.setInt(4, pagarconta.getCodigo());
			Date dataEmissaocp = pagarconta.getEmissaocp();
			long t = 0;
			if (dataEmissaocp != null ) {
				t = dataEmissaocp.getTime();	
			}
			preparedStatement.setDate(5, new java.sql.Date(t));
			preparedStatement.setString(6, pagarconta.getValor());
			preparedStatement.setInt(7, pagarconta.getCentroresultados_codigo());
			preparedStatement.setString(8, pagarconta.getTipodocumento());
			Date dataEmissaodp = pagarconta.getEmissaodp();
			long j = 0;
			if (dataEmissaodp != null ) {
				j = dataEmissaodp.getTime();	
			}
			preparedStatement.setDate(9, new java.sql.Date(j));
			
			preparedStatement.setInt(10, pagarconta.getCodigocp());
			preparedStatement.setInt(11, pagarconta.getEstabelecimentos_codigo());
			preparedStatement.setString(12, pagarconta.getCpf());
			preparedStatement.setInt(13, pagarconta.getCodigo());
			preparedStatement.setDate(14, new java.sql.Date(t));
			preparedStatement.setString(15, pagarconta.getValor());
			preparedStatement.setInt(16, pagarconta.getCentroresultados_codigo());
			preparedStatement.setString(17, pagarconta.getTipodocumento());
			preparedStatement.setDate(18, new java.sql.Date(j));

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Pagar> listapagar() {

		ArrayList<Pagar> lista = new ArrayList<Pagar>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigocp, estabelecimentos_codigo, "
					+ "cpf, codigo, emissaocp, valor, " 
					+ "centroresultados_codigo, tipodocumento, emissaodp from contapagar";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Pagar pagarconta = new Pagar();
				pagarconta.setCodigocp(rs.getInt("codigocp"));
				pagarconta.setEstabelecimentos_codigo(rs.getInt("estabelecimentos_codigo"));
				pagarconta.setCpf(rs.getString("cpf"));
				pagarconta.setCodigo(rs.getInt("codigo"));
				pagarconta.setEmissaocp(rs.getDate("emissaocp"));
				pagarconta.setValor(rs.getString("valor"));
				//pagarconta.setCentroresultados(rs.getString("centroresultados"));
				pagarconta.setCentroresultados_codigo(rs.getInt("centroresultados_codigo"));
				CentroResultados centroresultados = getCentroresultados(pagarconta.getCentroresultados_codigo());
				pagarconta.setCentroresultados(centroresultados);
				pagarconta.setTipodocumento(rs.getString("tipodocumento"));
				pagarconta.setEmissaodp(rs.getDate("emissaodp"));
				lista.add(pagarconta);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	public CentroResultados getCentroresultados(int idCentroresultados) throws SQLException {
		CentroResultados centroresultados = new CentroResultados();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select codigo, nome from centroresultados where codigo = ?");
		preparedStatement.setInt(1, idCentroresultados);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			centroresultados.setCodigo(rs.getInt("codigo"));
			centroresultados.setNome(rs.getString("nome"));
		}
		return centroresultados;
	}
	
	
}
