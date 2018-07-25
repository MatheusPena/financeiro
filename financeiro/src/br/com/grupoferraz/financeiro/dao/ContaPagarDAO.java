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
import br.com.grupoferraz.financeiro.entity.ContaPagar;
import br.com.grupoferraz.financeiro.entity.CentroResultados;
import br.com.grupoferraz.financeiro.entity.ContasFinanceiras;
import br.com.grupoferraz.financeiro.entity.Despesa;
import br.com.grupoferraz.financeiro.entity.Documento;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ContaPagarDAO { 
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertContasPagar(ContaPagar pagarconta) {

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();
			str.append("insert into contapagar (codigocp, estabelecimento_codigo, "
					+ "cpf, codigodp, emissaocp, valor, "
					+ "centroresultados_codigo, documento_codigo, emissaodp, nomecp, "
					+ "estabelecimento_nome, nomedp, observacao, empresa_cnpj, validadedp, contafinanceira_codigo ) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			str.append("on duplicate key update codigocp = ?, estabelecimento_codigo = ?, cpf = ?, "
					+ "codigodp = ?, emissaocp = ?, valor = ?, centroresultados_codigo = ?, "
					+ "documento_codigo = ?, emissaodp = ?, nomecp = ?, estabelecimento_nome = ?, "
					+ "nomedp = ?, observacao = ?, empresa_cnpj = ?, validadedp = ?, contafinanceira_codigo = ? ");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, pagarconta.getCodigocp());
			preparedStatement.setInt(2, pagarconta.getEstabelecimento_codigo());
			preparedStatement.setString(3, pagarconta.getCpf());
			preparedStatement.setInt(4, pagarconta.getCodigodp());
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
			Date dataValidadedp = pagarconta.getValidadedp();
			long k = 0;
			if (dataValidadedp != null ) {
				k = dataValidadedp.getTime();	
			}
			preparedStatement.setDate(15, new java.sql.Date(k));
			preparedStatement.setInt(16, pagarconta.getContafinanceira_codigo());
			
			preparedStatement.setInt(17, pagarconta.getCodigocp());
			preparedStatement.setInt(18, pagarconta.getEstabelecimento_codigo());
			preparedStatement.setString(19, pagarconta.getCpf());
			preparedStatement.setInt(20, pagarconta.getCodigodp());
			preparedStatement.setDate(21, new java.sql.Date(t));
			preparedStatement.setString(22, pagarconta.getValor());
			preparedStatement.setInt(23, pagarconta.getCentroresultados_codigo());
			preparedStatement.setInt(24, pagarconta.getDocumento_codigo());
			preparedStatement.setDate(25, new java.sql.Date(j));
			preparedStatement.setString(26, pagarconta.getNomecp());
			preparedStatement.setString(27, pagarconta.getEstabelecimento_nome());
			preparedStatement.setString(28, pagarconta.getNomedp());
			preparedStatement.setString(29, pagarconta.getObservacao());
			preparedStatement.setString(30, pagarconta.getEmpresa_cnpj());
			preparedStatement.setDate(31, new java.sql.Date(k));
			preparedStatement.setInt(32, pagarconta.getContafinanceira_codigo());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<ContaPagar> listapagar() {

		ArrayList<ContaPagar> lista = new ArrayList<ContaPagar>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigocp, estabelecimento_codigo, "
					+ "cpf, codigodp, emissaocp, valor, " 
					+ "centroresultados_codigo, documento_codigo, emissaodp, "
					+ "nomecp, estabelecimento_nome, nomedp, observacao, "
					+ "empresa_cnpj, validadedp, contafinanceira_codigo from contapagar";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				ContaPagar pagarconta = new ContaPagar();
				pagarconta.setCodigocp(rs.getInt("codigocp"));
				pagarconta.setEstabelecimento_codigo(rs.getInt("estabelecimento_codigo"));
				Estabelecimento estabelecimento = getEstabelecimento(pagarconta.getEstabelecimento_codigo());
				pagarconta.setEstabelecimento(estabelecimento);
				pagarconta.setCpf(rs.getString("cpf"));
				pagarconta.setCodigodp(rs.getInt("codigodp"));
				pagarconta.setEmissaocp(rs.getDate("emissaocp"));
				pagarconta.setValor(rs.getString("valor"));
				pagarconta.setCentroresultados_codigo(rs.getInt("centroresultados_codigo"));
				CentroResultados centroresultados = getCentroresultados(pagarconta.getCentroresultados_codigo());
				pagarconta.setCentroresultados(centroresultados);
				pagarconta.setDocumento_codigo(rs.getInt("documento_codigo"));
				Documento documento = getDocumentos(pagarconta.getDocumento_codigo());
				pagarconta.setDocumento(documento);
				pagarconta.setCentroresultados(centroresultados);
				pagarconta.setEmissaodp(rs.getDate("emissaodp"));
				pagarconta.setNomecp(rs.getString("nomecp"));
				pagarconta.setEstabelecimento_nome(rs.getString("estabelecimento_nome"));
				pagarconta.setNomedp(rs.getString("nomedp"));
				pagarconta.setObservacao(rs.getString("observacao"));
				pagarconta.setEmpresa_cnpj(rs.getString("empresa_cnpj"));
				pagarconta.setValidadedp(rs.getDate("validadedp"));
				pagarconta.setContafinanceira_codigo(rs.getInt("contafinanceira_codigo"));
				ContasFinanceiras contafinanceira = getContafinanceira(pagarconta.getContafinanceira_codigo());
				pagarconta.setContafinanceira(contafinanceira);
				Despesa despesa = new DespesaDAO().listadespesa(pagarconta.getCodigodp());
				pagarconta.setDespesa(despesa);
				lista.add(pagarconta);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	//Lista os Centro de Resultados cadastrados e exibe-os na tela de Contas à Pagar.
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
	
	//Lista as Contas Financeiras cadastradas e exibe-as na tela de Contas à Pagar.
	public ContasFinanceiras getContafinanceira(int idContafinanceira) throws SQLException {
		ContasFinanceiras contafinanceira = new ContasFinanceiras();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select codigo, nome from contasfinanceiras where codigo = ?");
		preparedStatement.setInt(1, idContafinanceira);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			contafinanceira.setCodigo(rs.getInt("codigo"));
			contafinanceira.setNome(rs.getString("nome"));
		}
		return contafinanceira;
	}
	
	//Lista os Documentos cadastrados e exibe-os na tela de Contas à Pagar.
	public Documento getDocumentos(int idDocumentos) throws SQLException {
		Documento documento = new Documento();
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
	
	//Lista os Estabelecimentos cadastrados e exibe-os na tela de Contas à Pagar.
	public Estabelecimento getEstabelecimento(int idEstabelecimento) throws SQLException {
		Estabelecimento estabelecimento = new Estabelecimento();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select codigo, nome from estabelecimento where codigo = ?");
		preparedStatement.setInt(1, idEstabelecimento);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			estabelecimento.setCodigo(rs.getInt("codigo"));
			estabelecimento.setNome(rs.getString("nome"));
		}
		return estabelecimento;
	}

	
	//Lista de Autocomplete referente à despesas.
	public List<Integer> listadespesa(String codigo) {

		ArrayList<Integer> lista = new ArrayList<Integer>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigocp, estabelecimento_codigo, "
				+ "cpf, codigodp, emissaocp, valor, "
				+ "centroresultados_codigo, documento_codigo, emissaodp, "
				+ "nomecp, estabelecimento_nome, nomedp, observacao, empresa_cnpj from contapagar from contapagar where "
				+ "cast(codigocp as char) like '%"+codigo+"%'";
		
		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				ContaPagar pagarconta = new ContaPagar();
				pagarconta.setCodigodp(rs.getInt("codigodp"));
				lista.add(rs.getInt("codigo"));
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	public ContaPagar listapagar(Integer codigo) {

		ArrayList<ContaPagar> lista = new ArrayList<ContaPagar>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigocp, estabelecimento_codigo, " + 
				"cpf, codigodp, emissaocp, valor, " + 
				"centroresultados_codigo, documento_codigo, emissaodp, " + 
				"nomecp, estabelecimento_nome, nomedp, observacao, empresa_cnpj from contapagar from contapagar where " + 
				"codigo = ?";
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			preparedStatement.setInt(1, codigo);
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				ContaPagar pagarconta = new ContaPagar();
				pagarconta.setCodigocp(rs.getInt("codigocp"));
				pagarconta.setEstabelecimento_codigo(rs.getInt("estabelecimento_codigo"));
				pagarconta.setCpf(rs.getString("cpf"));
				pagarconta.setCodigodp(rs.getInt("codigodp"));
				pagarconta.setEmissaocp(rs.getDate("emissaocp"));
				pagarconta.setValor(rs.getString("valor"));
				pagarconta.setCentroresultados_codigo(rs.getInt("centroresultados_codigo"));
				CentroResultados centroresultados = getCentroresultados(pagarconta.getCentroresultados_codigo());
				pagarconta.setCentroresultados(centroresultados);
				pagarconta.setDocumento_codigo(rs.getInt("documento_codigo"));
				Documento documento = getDocumentos(pagarconta.getDocumento_codigo());
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
		ContaPagar pagarconta = null;
		if (lista != null && !lista.isEmpty()) {
			pagarconta = lista.get(0);
		}
		return pagarconta;
	}
	
}