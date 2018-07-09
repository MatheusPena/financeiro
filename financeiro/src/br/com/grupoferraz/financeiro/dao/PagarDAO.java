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
import br.com.grupoferraz.financeiro.entity.Documentos;import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class PagarDAO { 
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertContasPagar(Pagar pagarconta) {

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();
			str.append("insert into contapagar (codigocp, estabelecimento_codigo, "
					+ "cpf, codigo, emissaocp, valor, "
					+ "centroresultados_codigo, documento_codigo, emissaodp, nomecp, "
					+ "estabelecimento_nome, nomedp, observacao, empresa_cnpj ) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			str.append("on duplicate key update codigocp = ?, estabelecimento_codigo = ?, cpf = ?,"
					+ "codigo = ?, emissaocp = ?, valor = ?, centroresultados_codigo = ?,"
					+ "documento_codigo = ?, emissaodp = ?, nomecp = ?, "
					+ "estabelecimento_nome = ?, nomedp = ?, observacao = ?, empresa_cnpj = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, pagarconta.getCodigocp());
			preparedStatement.setInt(2, pagarconta.getEstabelecimento_codigo());
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
			preparedStatement.setInt(8, pagarconta.getDocumento_codigo());
			Date dataEmissaodp = pagarconta.getEmissaodp();
			long j = 0;
			if (dataEmissaodp != null ) {
				j = dataEmissaodp.getTime();	
			}
			preparedStatement.setDate(9, new java.sql.Date(j));
			preparedStatement.setString(10, pagarconta.getNomecp());
			preparedStatement.setString(11, pagarconta.getEstabelecimento_nome());
			preparedStatement.setString(12, pagarconta.getNomedp());
			preparedStatement.setString(13, pagarconta.getObservacao());
			preparedStatement.setString(14, pagarconta.getEmpresa_cnpj());
			
			preparedStatement.setInt(15, pagarconta.getCodigocp());
			preparedStatement.setInt(16, pagarconta.getEstabelecimento_codigo());
			preparedStatement.setString(17, pagarconta.getCpf());
			preparedStatement.setInt(18, pagarconta.getCodigo());
			preparedStatement.setDate(19, new java.sql.Date(t));
			preparedStatement.setString(20, pagarconta.getValor());
			preparedStatement.setInt(21, pagarconta.getCentroresultados_codigo());
			preparedStatement.setInt(22, pagarconta.getDocumento_codigo());
			preparedStatement.setDate(23, new java.sql.Date(j));
			preparedStatement.setString(24, pagarconta.getNomecp());
			preparedStatement.setString(25, pagarconta.getEstabelecimento_nome());
			preparedStatement.setString(26, pagarconta.getNomedp());
			preparedStatement.setString(27, pagarconta.getObservacao());
			preparedStatement.setString(28, pagarconta.getEmpresa_cnpj());
			
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
			String sql = "select codigocp, estabelecimento_codigo, "
					+ "cpf, codigo, emissaocp, valor, " 
					+ "centroresultados_codigo, documento_codigo, emissaodp, "
					+ "nomecp, estabelecimento_nome, nomedp, observacao, empresa_cnpj from contapagar";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Pagar pagarconta = new Pagar();
				pagarconta.setCodigocp(rs.getInt("codigocp"));
				pagarconta.setEstabelecimento_codigo(rs.getInt("estabelecimento_codigo"));
				pagarconta.setCpf(rs.getString("cpf"));
				pagarconta.setCodigo(rs.getInt("codigo"));
				pagarconta.setEmissaocp(rs.getDate("emissaocp"));
				pagarconta.setValor(rs.getString("valor"));
				pagarconta.setCentroresultados_codigo(rs.getInt("centroresultados_codigo"));
				CentroResultados centroresultados = getCentroresultados(pagarconta.getCentroresultados_codigo());
				pagarconta.setCentroresultados(centroresultados);
				pagarconta.setDocumento_codigo(rs.getInt("documento_codigo"));
				Documentos documento = getDocumentos(pagarconta.getDocumento_codigo());
				pagarconta.setDocumento(documento);
				pagarconta.setCentroresultados(centroresultados);
				pagarconta.setEmissaodp(rs.getDate("emissaodp"));
				pagarconta.setNomecp(rs.getString("nomecp"));
				pagarconta.setEstabelecimento_nome(rs.getString("estabelecimento_nome"));
				pagarconta.setNomedp(rs.getString("nomedp"));
				pagarconta.setObservacao(rs.getString("observacao"));
				pagarconta.setEmpresa_cnpj(rs.getString("empresa_cnpj"));
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
	
	public Documentos getDocumentos(int idDocumentos) throws SQLException {
		Documentos documento = new Documentos();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select codigo, nome from documento where codigo = ?");
		preparedStatement.setInt(1, idDocumentos);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			documento.setCodigo(rs.getInt("codigo"));
			documento.setNome(rs.getString("nome"));
		}
		return documento;
	}
	
	
	public List<Integer> listadespesa(String codigo) {

		ArrayList<Integer> lista = new ArrayList<Integer>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigocp, estabelecimento_codigo, "
				+ "cpf, codigo, emissaocp, valor, "
				+ "centroresultados_codigo, documento_codigo, emissaodp, "
				+ "nomecp, estabelecimento_nome, nomedp, observacao, empresa_cnpj from contapagar from contapagar where "
				+ "cast(codigocp as char) like '%"+codigo+"%'";
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Pagar pagarconta = new Pagar();
				pagarconta.setCodigo(rs.getInt("codigo"));
				lista.add(rs.getInt("codigo"));
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	public Pagar listapagar(Integer codigo) {

		ArrayList<Pagar> lista = new ArrayList<Pagar>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigocp, estabelecimento_codigo, " + 
				"cpf, codigo, emissaocp, valor, " + 
				"centroresultados_codigo, documento_codigo, emissaodp, " + 
				"nomecp, estabelecimento_nome, nomedp, observacao, empresa_cnpj from contapagar from contapagar where " + 
				"codigo = ?";
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			preparedStatement.setInt(1, codigo);
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Pagar pagarconta = new Pagar();
				pagarconta.setCodigocp(rs.getInt("codigocp"));
				pagarconta.setEstabelecimento_codigo(rs.getInt("estabelecimento_codigo"));
				pagarconta.setCpf(rs.getString("cpf"));
				pagarconta.setCodigo(rs.getInt("codigo"));
				pagarconta.setEmissaocp(rs.getDate("emissaocp"));
				pagarconta.setValor(rs.getString("valor"));
				pagarconta.setCentroresultados_codigo(rs.getInt("centroresultados_codigo"));
				CentroResultados centroresultados = getCentroresultados(pagarconta.getCentroresultados_codigo());
				pagarconta.setCentroresultados(centroresultados);
				pagarconta.setDocumento_codigo(rs.getInt("documento_codigo"));
				Documentos documento = getDocumentos(pagarconta.getDocumento_codigo());
				pagarconta.setDocumento(documento);
				pagarconta.setCentroresultados(centroresultados);
				pagarconta.setEmissaodp(rs.getDate("emissaodp"));
				pagarconta.setNomecp(rs.getString("nomecp"));
				pagarconta.setEstabelecimento_nome(rs.getString("estabelecimento_nome"));
				pagarconta.setNomedp(rs.getString("nomedp"));
				pagarconta.setObservacao(rs.getString("observacao"));
				pagarconta.setEmpresa_cnpj(rs.getString("empresa_cnpj"));
				lista.add(pagarconta);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		Pagar pagarconta = null;
		if (lista != null && !lista.isEmpty()) {
			pagarconta = lista.get(0);
		}
		return pagarconta;
	}
	
}