package br.com.grupoferraz.financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.grupoferraz.financeiro.entity.DespesaReceita;
import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.GrupoDespesaReceita;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class DespesaReceitaDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertDespesaReceitas(DespesaReceita despesareceita) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into despesa_receita (codigo, nome, grupodespesareceita_codigo) values (?,?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?, grupodespesareceita_codigo = ?");

			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());

			preparedStatement.setInt(1, despesareceita.getCodigo());
			preparedStatement.setString(2, despesareceita.getNome());
			if (despesareceita.getGrupodespesareceita_codigo() != null) {
				preparedStatement.setInt(3, despesareceita.getGrupodespesareceita_codigo());
			} else {
				preparedStatement.setNull(3, Types.INTEGER);
			}

			preparedStatement.setInt(4, despesareceita.getCodigo());
			preparedStatement.setString(5, despesareceita.getNome());
			if (despesareceita.getGrupodespesareceita_codigo() != null) {
				preparedStatement.setInt(6, despesareceita.getGrupodespesareceita_codigo());
			} else {
				preparedStatement.setNull(6, Types.INTEGER);
			}

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<DespesaReceita> listadespesareceitas() {

		ArrayList<DespesaReceita> lista = new ArrayList<DespesaReceita>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigo, nome, grupodespesareceita_codigo from despesa_receita";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				DespesaReceita despesareceita = new DespesaReceita();
				despesareceita.setCodigo(rs.getInt("codigo"));
				despesareceita.setNome(rs.getString("nome"));
				despesareceita.setGrupodespesareceita_codigo(rs.getInt("grupodespesareceita_codigo"));
				int idGrupo = despesareceita.getGrupodespesareceita_codigo();
				GrupoDespesaReceita grupoDespesa = getGrupoDespesa(idGrupo);
				despesareceita.setGrupodespesareceita(grupoDespesa);
				lista.add(despesareceita);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// Lista o auto complete de despesas na página do conta a pagar (pela chave
	// primária)
	public List<Integer> listadespesa(String codigo) {

		ArrayList<Integer> lista = new ArrayList<Integer>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, grupodespesareceita_codigo " + " from despesa_receita where "
				+ "cast(codigo as char) like '%" + codigo + "%'";

		try {

			preparedStatement = conexao.prepareStatement(sql);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {

				DespesaReceita despesareceita = new DespesaReceita();
				despesareceita.setCodigo(rs.getInt("codigo"));
				lista.add(rs.getInt("codigo"));
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
<<<<<<< Upstream, based on branch 'master' of https://github.com/MatheusPena/financeiro.git
	
	//Lista o auto complete de despesas na página do plano de contas (pelo objeto) 
	public List<DespesaReceita> listadespesareceitas(String codigo) {
=======

	// Lista o auto complete de despesas na página do plano de contas (pelo objeto)
	public List<DespesaReceita> listadespesas(String codigo) {
>>>>>>> a2b7178 Atualizacao do contas a receber, receita/despesa e grupo cliente

		ArrayList<DespesaReceita> lista = new ArrayList<DespesaReceita>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, grupodespesareceita_codigo " + " from despesa_receita where "
				+ "nome like '%" + codigo + "%'";

		try {

			preparedStatement = conexao.prepareStatement(sql);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {

				DespesaReceita despesareceita = new DespesaReceita();
				despesareceita.setCodigo(rs.getInt("codigo"));
				despesareceita.setNome(rs.getString("nome"));
				despesareceita.setGrupodespesareceita_codigo(rs.getInt("grupodespesareceita_codigo"));
				lista.add(despesareceita);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// Lista o auto complete de despesas na página do Plano de Contas
	public List<DespesaReceita> listanomedespesa(String nome) {

		ArrayList<DespesaReceita> lista = new ArrayList<>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, grupodespesareceita_codigo from despesa_receita where " + "nome like '%"
				+ nome + "%'";

		try {

			preparedStatement = conexao.prepareStatement(sql);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {

				DespesaReceita despesareceita = new DespesaReceita();
				despesareceita.setCodigo(rs.getInt("codigo"));
				despesareceita.setNome(rs.getString("nome"));
				despesareceita.setGrupodespesareceita_codigo(rs.getInt("grupodespesareceita_codigo"));
				lista.add(despesareceita);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	public DespesaReceita listadespesa(Integer codigo) {

		ArrayList<DespesaReceita> lista = new ArrayList<DespesaReceita>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, grupodespesareceita_codigo from despesa_receita where codigo = ?";

		try {

			preparedStatement = conexao.prepareStatement(sql);

			preparedStatement.setInt(1, codigo);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {

				DespesaReceita despesareceita = new DespesaReceita();
				despesareceita.setCodigo(rs.getInt("codigo"));
				despesareceita.setNome(rs.getString("nome"));
				despesareceita.setGrupodespesareceita_codigo(rs.getInt("grupodespesareceita_codigo"));
				int idGrupo = despesareceita.getGrupodespesareceita_codigo();
				GrupoDespesaReceita grupoDespesa = getGrupoDespesa(idGrupo);
				despesareceita.setGrupodespesareceita(grupoDespesa);

				lista.add(despesareceita);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		DespesaReceita despesareceita = null;
		if (lista != null && !lista.isEmpty()) {
			despesareceita = lista.get(0);
		}
		return despesareceita;
	}

	// Listagem de Grupos
	public GrupoDespesaReceita getGrupoDespesa(int idGrupo) throws SQLException {
		GrupoDespesaReceita grupo = new GrupoDespesaReceita();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select codigo, nome from grupo_despesa_receita where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
		}
		return grupo;
	}

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

	public Estabelecimento getEstabelecimento(int idEstabelecimento) throws SQLException {
		Estabelecimento estabelecimento = new Estabelecimento();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select codigo, nome from estabelecimento where codigo = ?");
		preparedStatement.setInt(1, idEstabelecimento);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			estabelecimento.setCodigo(rs.getInt("codigo"));
			estabelecimento.setNome(rs.getString("nome"));
		}
		return estabelecimento;
	}
}
