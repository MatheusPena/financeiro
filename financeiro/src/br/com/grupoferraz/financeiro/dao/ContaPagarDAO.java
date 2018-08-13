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
import br.com.grupoferraz.financeiro.entity.CentroResultado;
import br.com.grupoferraz.financeiro.entity.ContaFinanceira;
import br.com.grupoferraz.financeiro.entity.DespesaReceita;
import br.com.grupoferraz.financeiro.entity.Documento;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.PlanoConta;
import br.com.grupoferraz.financeiro.entity.VencimentoCP;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ContaPagarDAO { 
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertContasPagar(ContaPagar pagarconta) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into conta_pagar (codigocp, estabelecimento_codigo, "
					+ "cpf, despesa_codigo, emissaocp, valor, "
					+ "centroresultado_codigo, documento_codigo, emissaodp, contapagar_nome, "
					+ "estabelecimento_nome, despesa_plano, observacao, empresa_cnpj, "
					+ "validadedp, contafinanceira_codigo, numdocumento, valoriss, baseiss ) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			str.append("on duplicate key update codigocp = ?, estabelecimento_codigo = ?, cpf = ?, "
					+ "despesa_codigo = ?, emissaocp = ?, valor = ?, centroresultado_codigo = ?, "
					+ "documento_codigo = ?, emissaodp = ?, contapagar_nome = ?, estabelecimento_nome = ?, "
					+ "despesa_plano = ?, observacao = ?, empresa_cnpj = ?, "
					+ "validadedp = ?, contafinanceira_codigo = ?, numdocumento = ?, valoriss = ?, baseiss = ? ");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, pagarconta.getCodigocp());
			preparedStatement.setInt(2, pagarconta.getEstabelecimento_codigo());
			preparedStatement.setString(3, pagarconta.getCpf());
			preparedStatement.setInt(4, pagarconta.getDespesa_codigo());
			Date dataEmissaocp = pagarconta.getEmissaocp();
			long t = 0;
			if (dataEmissaocp != null ) {
				t = dataEmissaocp.getTime();	
			}
			preparedStatement.setDate(5, new java.sql.Date(t));
			preparedStatement.setString(6, pagarconta.getValor());
			preparedStatement.setInt(7, pagarconta.getCentroresultado_codigo());
			preparedStatement.setInt(8, pagarconta.getDocumento_codigo());
			Date dataEmissaodp = pagarconta.getEmissaodp();
			long j = 0;
			if (dataEmissaodp != null ) {
				j = dataEmissaodp.getTime();	
			}
			preparedStatement.setDate(9, new java.sql.Date(j));
			preparedStatement.setString(10, pagarconta.getContapagar_nome());
			preparedStatement.setString(11, pagarconta.getEstabelecimento_nome());
			preparedStatement.setString(12, pagarconta.getDespesa_plano());
			preparedStatement.setString(13, pagarconta.getObservacao());
			preparedStatement.setString(14, pagarconta.getEmpresa_cnpj());
			Date dataValidadedp = pagarconta.getValidadedp();
			long k = 0;
			if (dataValidadedp != null ) {
				k = dataValidadedp.getTime();	
			}
			preparedStatement.setDate(15, new java.sql.Date(k));
			preparedStatement.setInt(16, pagarconta.getContafinanceira_codigo());
			preparedStatement.setString(17, pagarconta.getNumdocumento());
			preparedStatement.setString(18, pagarconta.getValoriss());
			preparedStatement.setString(19, pagarconta.getBaseiss());
			
			preparedStatement.setInt(20, pagarconta.getCodigocp());
			preparedStatement.setInt(21, pagarconta.getEstabelecimento_codigo());
			preparedStatement.setString(22, pagarconta.getCpf());
			preparedStatement.setInt(23, pagarconta.getDespesa_codigo());
			preparedStatement.setDate(24, new java.sql.Date(t));
			preparedStatement.setString(25, pagarconta.getValor());
			preparedStatement.setInt(26, pagarconta.getCentroresultado_codigo());
			preparedStatement.setInt(27, pagarconta.getDocumento_codigo());
			preparedStatement.setDate(28, new java.sql.Date(j));
			preparedStatement.setString(29, pagarconta.getContapagar_nome());
			preparedStatement.setString(30, pagarconta.getEstabelecimento_nome());
			preparedStatement.setString(31, pagarconta.getDespesa_plano());
			preparedStatement.setString(32, pagarconta.getObservacao());
			preparedStatement.setString(33, pagarconta.getEmpresa_cnpj());
			preparedStatement.setDate(34, new java.sql.Date(k));
			preparedStatement.setInt(35, pagarconta.getContafinanceira_codigo());
			preparedStatement.setString(36, pagarconta.getNumdocumento());
			preparedStatement.setString(37, pagarconta.getValoriss());
			preparedStatement.setString(38, pagarconta.getBaseiss());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

//	lista todas as contas cadastrados no banco de dados
	public List<ContaPagar> listapagar(String query) {

		ArrayList<ContaPagar> lista = new ArrayList<ContaPagar>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigocp, estabelecimento_codigo, "
					+ "cpf, despesa_codigo, emissaocp, valor, " 
					+ "centroresultado_codigo, documento_codigo, emissaodp, "
					+ "contapagar_nome, estabelecimento_nome, despesa_plano, observacao, "
					+ "empresa_cnpj, validadedp, contafinanceira_codigo, numdocumento, valoriss, baseiss from conta_pagar "
					+ "where contapagar_nome like '%"+query+"%'";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				ContaPagar pagarconta = new ContaPagar();
				pagarconta.setCodigocp(rs.getInt("codigocp"));
				pagarconta.setEstabelecimento_codigo(rs.getInt("estabelecimento_codigo"));
				Estabelecimento estabelecimento = getEstabelecimento(pagarconta.getEstabelecimento_codigo());
				pagarconta.setEstabelecimento(estabelecimento);
				pagarconta.setCpf(rs.getString("cpf"));
				pagarconta.setDespesa_codigo(rs.getInt("despesa_codigo"));
				pagarconta.setEmissaocp(rs.getDate("emissaocp"));
				pagarconta.setValor(rs.getString("valor"));
				pagarconta.setCentroresultado_codigo(rs.getInt("centroresultado_codigo"));
				CentroResultado centroresultados = getCentroresultados(pagarconta.getCentroresultado_codigo());
				pagarconta.setCentroresultados(centroresultados);
				pagarconta.setDocumento_codigo(rs.getInt("documento_codigo"));
				Documento documento = getDocumentos(pagarconta.getDocumento_codigo());
				pagarconta.setDocumento(documento);
				pagarconta.setCentroresultados(centroresultados);
				pagarconta.setEmissaodp(rs.getDate("emissaodp"));
				pagarconta.setContapagar_nome(rs.getString("contapagar_nome"));
				pagarconta.setEstabelecimento_nome(rs.getString("estabelecimento_nome"));
				pagarconta.setDespesa_plano(rs.getString("despesa_plano"));
				PlanoConta planoconta = getPlanoConta(pagarconta.getDespesa_codigo());
				pagarconta.setPlanoconta(planoconta);
				pagarconta.setObservacao(rs.getString("observacao"));
				pagarconta.setEmpresa_cnpj(rs.getString("empresa_cnpj"));
				pagarconta.setValidadedp(rs.getDate("validadedp"));
				pagarconta.setContafinanceira_codigo(rs.getInt("contafinanceira_codigo"));
				pagarconta.setNumdocumento(rs.getString("numdocumento"));
				pagarconta.setValoriss(rs.getString("valoriss"));
				pagarconta.setBaseiss(rs.getString("baseiss"));
				ContaFinanceira contafinanceira = getContafinanceira(pagarconta.getContafinanceira_codigo());
				pagarconta.setContafinanceira(contafinanceira);
				DespesaReceita despesa = new DespesaReceitaDAO().listadespesa(pagarconta.getDespesa_codigo());
				pagarconta.setDespesa(despesa);
				pagarconta.setVencimento(getVencimentoCP(pagarconta.getCodigocp()));
				lista.add(pagarconta);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
//	lista todas as contas cadastradas para o autocomplete da página de Baixa Vencimento CP
	public List<ContaPagar> listapagar() {

		ArrayList<ContaPagar> lista = new ArrayList<ContaPagar>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigocp, estabelecimento_codigo, "
					+ "cpf, despesa_codigo, emissaocp, valor, " 
					+ "centroresultado_codigo, documento_codigo, emissaodp, "
					+ "contapagar_nome, estabelecimento_nome, despesa_plano, observacao, "
					+ "empresa_cnpj, validadedp, contafinanceira_codigo, numdocumento, valoriss, baseiss from conta_pagar";
					
			rs = st.executeQuery(sql);

			while (rs.next()) {

				ContaPagar pagarconta = new ContaPagar();
				pagarconta.setCodigocp(rs.getInt("codigocp"));
				pagarconta.setEstabelecimento_codigo(rs.getInt("estabelecimento_codigo"));
				Estabelecimento estabelecimento = getEstabelecimento(pagarconta.getEstabelecimento_codigo());
				pagarconta.setEstabelecimento(estabelecimento);
				pagarconta.setCpf(rs.getString("cpf"));
				pagarconta.setDespesa_codigo(rs.getInt("despesa_codigo"));
				pagarconta.setEmissaocp(rs.getDate("emissaocp"));
				pagarconta.setValor(rs.getString("valor"));
				pagarconta.setCentroresultado_codigo(rs.getInt("centroresultado_codigo"));
				CentroResultado centroresultados = getCentroresultados(pagarconta.getCentroresultado_codigo());
				pagarconta.setCentroresultados(centroresultados);
				pagarconta.setDocumento_codigo(rs.getInt("documento_codigo"));
				Documento documento = getDocumentos(pagarconta.getDocumento_codigo());
				pagarconta.setDocumento(documento);
				pagarconta.setCentroresultados(centroresultados);
				pagarconta.setEmissaodp(rs.getDate("emissaodp"));
				pagarconta.setContapagar_nome(rs.getString("contapagar_nome"));
				pagarconta.setEstabelecimento_nome(rs.getString("estabelecimento_nome"));
				pagarconta.setDespesa_plano(rs.getString("despesa_plano"));
				PlanoConta planoconta = getPlanoConta(pagarconta.getDespesa_codigo());
				pagarconta.setPlanoconta(planoconta);
				pagarconta.setObservacao(rs.getString("observacao"));
				pagarconta.setEmpresa_cnpj(rs.getString("empresa_cnpj"));
				pagarconta.setValidadedp(rs.getDate("validadedp"));
				pagarconta.setContafinanceira_codigo(rs.getInt("contafinanceira_codigo"));
				pagarconta.setNumdocumento(rs.getString("numdocumento"));
				pagarconta.setValoriss(rs.getString("valoriss"));
				pagarconta.setBaseiss(rs.getString("baseiss"));
				ContaFinanceira contafinanceira = getContafinanceira(pagarconta.getContafinanceira_codigo());
				pagarconta.setContafinanceira(contafinanceira);
				DespesaReceita despesa = new DespesaReceitaDAO().listadespesa(pagarconta.getDespesa_codigo());
				pagarconta.setDespesa(despesa);
				pagarconta.setVencimento(getVencimentoCP(pagarconta.getCodigocp()));
				lista.add(pagarconta);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
//	Lista os Vencimentos cadastrados para o autocomplete da página de Baixa Vencimento CP
	public VencimentoCP getVencimentoCP(int idVencimento) throws SQLException {
		VencimentoCP vencimento = new VencimentoCP();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select * from vencimento_cp where vencimento_codigo = ?");
		preparedStatement.setInt(1, idVencimento);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {

			vencimento.setVencimento_codigo(rs.getInt("vencimento_codigo"));
			vencimento.setVencimento(rs.getDate("vencimento"));
			vencimento.setTitulo(rs.getString("titulo"));
			vencimento.setValor(rs.getString("valor"));
			vencimento.setDesconto(rs.getString("desconto"));
			vencimento.setCodigoag(rs.getString("codigoag"));
			vencimento.setNomeag(rs.getString("nomeag"));
			vencimento.setLancamento(rs.getString("lancamento"));
			vencimento.setBanco(rs.getString("banco"));
			vencimento.setAgenciabanco(rs.getString("agenciabanco"));
			vencimento.setDigagencia(rs.getString("digagencia"));
			vencimento.setConta(rs.getString("conta"));
			vencimento.setDigconta(rs.getString("digconta"));
			vencimento.setAgendar(rs.getDate("agendar"));
		}
		return vencimento;
	}

//	Lista os Centro de Resultados cadastrados e exibe-os na tela de Contas à Pagar.
	public CentroResultado getCentroresultados(int idCentroresultados) throws SQLException {
		CentroResultado centroresultados = new CentroResultado();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select codigo, nome from centro_resultado where codigo = ?");
		preparedStatement.setInt(1, idCentroresultados);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			centroresultados.setCodigo(rs.getInt("codigo"));
			centroresultados.setNome(rs.getString("nome"));
		}
		return centroresultados;
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
	
//	Lista os Documentos cadastrados e exibe-os na tela de Contas à Pagar.
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
	
//	Lista os Estabelecimentos cadastrados e exibe-os na tela de Contas à Pagar.
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

	
//	Lista de Autocomplete referente à despesas.
	public List<Integer> listadespesa(String codigo) {

		ArrayList<Integer> lista = new ArrayList<Integer>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigocp, estabelecimento_codigo, "
				+ "cpf, despesa_codigo, emissaocp, valor, "
				+ "centroresultado_codigo, documento_codigo, emissaodp, "
				+ "contapagar_nome, estabelecimento_nome, despesa_plano, observacao, empresa_cnpj from conta_pagar where "
				+ "cast(codigocp as char) like '%"+codigo+"%'";
		
		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				ContaPagar pagarconta = new ContaPagar();
				pagarconta.setDespesa_codigo(rs.getInt("despesa_codigo"));
				lista.add(rs.getInt("codigo"));
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

//	eu não sei pra que esse método está sendo usado
	public ContaPagar listapagar(Integer codigo) {

		ArrayList<ContaPagar> lista = new ArrayList<ContaPagar>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigocp, estabelecimento_codigo, " + 
				"cpf, despesa_codigo, emissaocp, valor, " + 
				"centroresultado_codigo, documento_codigo, emissaodp, " + 
				"contapagar_nome, estabelecimento_nome, despesa_plano, observacao, empresa_cnpj from conta_pagar where " + 
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
				pagarconta.setDespesa_codigo(rs.getInt("despesa_codigo"));
				pagarconta.setEmissaocp(rs.getDate("emissaocp"));
				pagarconta.setValor(rs.getString("valor"));
				pagarconta.setCentroresultado_codigo(rs.getInt("centroresultado_codigo"));
				CentroResultado centroresultados = getCentroresultados(pagarconta.getCentroresultado_codigo());
				pagarconta.setCentroresultados(centroresultados);
				pagarconta.setDocumento_codigo(rs.getInt("documento_codigo"));
				Documento documento = getDocumentos(pagarconta.getDocumento_codigo());
				pagarconta.setDocumento(documento);
				pagarconta.setCentroresultados(centroresultados);
				pagarconta.setEmissaodp(rs.getDate("emissaodp"));
				pagarconta.setContapagar_nome(rs.getString("contapagar_nome"));
				pagarconta.setEstabelecimento_nome(rs.getString("estabelecimento_nome"));
				pagarconta.setDespesa_plano(rs.getString("despesa_plano"));
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
	
//		 Exibe o nome do plano de contas ao invés do código
	public PlanoConta getPlanoConta(int idGrupo) throws SQLException {
		PlanoConta grupo = new PlanoConta();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from plano_conta where despesareceita_codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getString(1));
			grupo.setDespesareceita_codigo(rs.getInt(2));
			int idGrupo0 = grupo.getDespesareceita_codigo();
			DespesaReceita despesareceita = getReceita(idGrupo0);
			grupo.setDespesareceita(despesareceita);
			grupo.setTipo(rs.getString(3));
			grupo.setNatureza(rs.getString(4));
			grupo.setIss(rs.getString(5));
			grupo.setInss(rs.getString(6));
			grupo.setIrpf(rs.getString(7));
			grupo.setPis(rs.getString(8));
			grupo.setConta(rs.getString(9));
			grupo.setAtividade(rs.getString(10));
			grupo.setIcms(rs.getBigDecimal(11));
			grupo.setObservacao(rs.getString(12));
			grupo.setGrupodespesareceita_codigo(rs.getInt(13));
		}
		return grupo;
	}

// 	lista todos as despesas cadastradas no banco de dados
	public DespesaReceita getReceita(int idGrupo) throws SQLException {
		DespesaReceita grupo = new DespesaReceita();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from despesa_receita where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
			grupo.setGrupodespesareceita_codigo(rs.getInt("grupodespesareceita_codigo"));
		}
		return grupo;
	}

}