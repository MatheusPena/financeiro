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

import br.com.grupoferraz.financeiro.entity.CentroResultado;
import br.com.grupoferraz.financeiro.entity.ContaFinanceira;
import br.com.grupoferraz.financeiro.entity.DespesaReceita;
import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.Historico;
import br.com.grupoferraz.financeiro.entity.Adiantamento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class AdiantamentoDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertAdiantamento(Adiantamento Adiantamento) {

		try {

			StringBuilder str = new StringBuilder();
			str.append(
					"insert into adiantamento (codigo, data, valor, observacao, estabelecimento_codigo, empresa_cnpj, "
					+ "estabelecimento_nome, despesa_nome, fornecedorcpf, contafinanceira_codigo,"
					+ "centroresultado_codigo, despesa_codigo, historicopadrao_codigo)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?, data = ?, valor = ?, observacao = ?, estabelecimento_codigo = ?, "
					+ "empresa_cnpj = ?, estabelecimento_nome = ?, despesa_nome = ?, fornecedorcpf = ?, "
					+ "contafinanceira_codigo = ?, centroresultado_codigo = ?, despesa_codigo = ?, historicopadrao_codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, Adiantamento.getCodigo());
			Date data = Adiantamento.getData();
			long t = 0;
			if (data != null) {
				t = data.getTime();
			}
			preparedStatement.setDate(2, new java.sql.Date(t));
			preparedStatement.setFloat(3, Adiantamento.getValor());
			preparedStatement.setString(4, Adiantamento.getObservacao());
			preparedStatement.setInt(5, Adiantamento.getEstabelecimento_codigo());
			preparedStatement.setString(6, Adiantamento.getEmpresa_cnpj());
			preparedStatement.setString(7, Adiantamento.getEstabelecimento_nome());
			preparedStatement.setString(8, Adiantamento.getDespesa_nome());
			preparedStatement.setString(9, Adiantamento.getFornecedorcpf());
			preparedStatement.setInt(10, Adiantamento.getContafinanceira_codigo());
			preparedStatement.setInt(11, Adiantamento.getCentroresultado_codigo());
			preparedStatement.setInt(12, Adiantamento.getDespesa_codigo());
			if (Adiantamento.getHistoricopadrao_codigo() != null) {
				preparedStatement.setInt(13, Adiantamento.getHistoricopadrao_codigo());
			} else {
				preparedStatement.setNull(13, Types.INTEGER);
			}

			preparedStatement.setInt(14, Adiantamento.getCodigo());
			preparedStatement.setDate(15, new java.sql.Date(t));
			preparedStatement.setFloat(16, Adiantamento.getValor());
			preparedStatement.setString(17, Adiantamento.getObservacao());
			preparedStatement.setInt(18, Adiantamento.getEstabelecimento_codigo());
			preparedStatement.setString(19, Adiantamento.getEmpresa_cnpj());
			preparedStatement.setString(20, Adiantamento.getEstabelecimento_nome());
			preparedStatement.setString(21, Adiantamento.getDespesa_nome());
			preparedStatement.setString(22, Adiantamento.getFornecedorcpf());
			preparedStatement.setInt(23, Adiantamento.getContafinanceira_codigo());
			preparedStatement.setInt(24, Adiantamento.getCentroresultado_codigo());
			preparedStatement.setInt(25, Adiantamento.getDespesa_codigo());
			if (Adiantamento.getHistoricopadrao_codigo() != null) {
				preparedStatement.setInt(26, Adiantamento.getHistoricopadrao_codigo());
			} else {
				preparedStatement.setNull(26, Types.INTEGER);
			}

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os adiantamentos cadastrados no banco de dados
	public List<Adiantamento> listAdiantamento() {

		ArrayList<Adiantamento> lista = new ArrayList<Adiantamento>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from adiantamento";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Adiantamento Adiantamento = new Adiantamento();
				Adiantamento.setCodigo(rs.getInt("codigo"));
				Adiantamento.setData(rs.getDate("data"));
				Adiantamento.setEstabelecimento_codigo(rs.getInt("estabelecimento_codigo"));
				Estabelecimento obj1 = getEstabelecimento(Adiantamento.getEstabelecimento_codigo());
				Adiantamento.setEstabelecimento(obj1);
				Adiantamento.setEmpresa_cnpj(rs.getString("empresa_cnpj"));
				Empresa obj6 = getEmpresa(Adiantamento.getEmpresa_cnpj());
				Adiantamento.setEmpresa(obj6);
				Adiantamento.setEstabelecimento_nome(rs.getString("estabelecimento_nome"));
				Adiantamento.setDespesa_nome(rs.getString("despesa_nome"));
				Adiantamento.setFornecedorcpf(rs.getString("fornecedorcpf"));
				Adiantamento.setContafinanceira_codigo(rs.getInt("contafinanceira_codigo"));
				ContaFinanceira obj2 = getContaFinanceira(Adiantamento.getContafinanceira_codigo());
				Adiantamento.setContafinanceira(obj2);
				Adiantamento.setCentroresultado_codigo(rs.getInt("centroresultado_codigo"));
				CentroResultado obj3 = getCentroResultados(Adiantamento.getCentroresultado_codigo());
				Adiantamento.setCentroresultado(obj3);
				Adiantamento.setDespesa_codigo(rs.getInt("despesa_codigo"));
				DespesaReceita obj4 = getDespesa(Adiantamento.getDespesa_codigo());
				Adiantamento.setDespesa(obj4);
				Adiantamento.setValor(rs.getFloat("valor"));
				Adiantamento.setHistoricopadrao_codigo(rs.getInt("historicopadrao_codigo"));
				Historico obj5 = getHistoricoPadrao(Adiantamento.getHistoricopadrao_codigo());
				Adiantamento.setHistorico(obj5);
				Adiantamento.setObservacao(rs.getString("observacao"));

				lista.add(Adiantamento);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	//Método para mostrar o nome das despesas na tabela de Adiantamentos, ao invés do Código
	public DespesaReceita getDespesa(int idGrupo) throws SQLException {
		DespesaReceita grupo = new DespesaReceita();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from despesa where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
			grupo.setGrupodespesareceita_codigo(rs.getInt("grupodespesareceita_codigo"));
		}
		return grupo;
	}

	// Exibe o nome da agência em vez do código na tela
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

	//Método para mostrar o nome do Contas Financeiras na tabela de Adiantamentos, ao invés do Código	
	public ContaFinanceira getContaFinanceira(int idGrupo) throws SQLException {
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
	
	//Método para mostrar o nome do centro de resultados na tabela de Adiantamentos, ao invés do Código
	public CentroResultado getCentroResultados(int idGrupo) throws SQLException {
		CentroResultado grupo = new CentroResultado();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from centroresultado where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
			grupo.setAtividade(rs.getString("atividade"));
			grupo.setCrcontabil(rs.getString("crcontabil"));
			grupo.setPeso(rs.getBigDecimal("peso"));
			grupo.setGrupocentroresultado_codigo(rs.getInt("grupocentroresultados_codigo"));
		}
		return grupo;
	}
	
	//Método para mostrar o nome do histórico na tabela de Adiantamentos, ao invés do Código
	public Historico getHistoricoPadrao(int idGrupo) throws SQLException {
		Historico grupo = new Historico();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from historico where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setDescricao(rs.getString("descricao"));
			grupo.setDespesa_codigo(rs.getInt("despesa_codigo"));
		}
		return grupo;
	}
	
	//Método para mostrar o nome da empresa na tabela de Adiantamentos, ao invés do CNPJ
	public Empresa getEmpresa(String idGrupo) throws SQLException {
		Empresa grupo = new Empresa();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao
				.prepareStatement("select cnpj, nome from empresa where cnpj = ?");
		preparedStatement.setString(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCnpj(rs.getString("cnpj"));
			grupo.setNome(rs.getString("nome"));
		}
		return grupo;
	}

}
