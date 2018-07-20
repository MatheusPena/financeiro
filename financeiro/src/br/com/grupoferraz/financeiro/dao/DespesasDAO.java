package br.com.grupoferraz.financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.grupoferraz.financeiro.entity.Despesas;
import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.GrupoDespesas;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class DespesasDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertDespesas(Despesas despesa) {

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();
			str.append("insert into despesas (codigo, nome, grupodespesas_codigo) values (?,?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?, grupodespesas_codigo = ?");
	
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, despesa.getCodigo());
			preparedStatement.setString(2, despesa.getNome());
			preparedStatement.setInt(3, despesa.getGrupodespesas_codigo());
			
			preparedStatement.setInt(4, despesa.getCodigo());
			preparedStatement.setString(5, despesa.getNome());
			preparedStatement.setInt(6, despesa.getGrupodespesas_codigo());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Despesas> listadespesa() {

		ArrayList<Despesas> lista = new ArrayList<Despesas>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigo, nome, grupodespesas_codigo from despesas";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Despesas despesa = new Despesas();
				despesa.setCodigo(rs.getInt("codigo"));
				despesa.setNome(rs.getString("nome"));
				despesa.setGrupodespesas_codigo(rs.getInt("grupodespesas_codigo"));
				int idGrupo = despesa.getGrupodespesas_codigo();		
				GrupoDespesas grupoDespesas = getGrupoDespesas(idGrupo);
				despesa.setGrupodespesas(grupoDespesas);		
				lista.add(despesa);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	//Lista o auto complete de despesas na página do conta a pagar (pela chave primária)
	public List<Integer> listadespesa(String codigo) {

		ArrayList<Integer> lista = new ArrayList<Integer>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, grupodespesas_codigo "
				+ " from despesas where "
				+ "cast(codigo as char) like '%"+codigo+"%'";
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Despesas despesa = new Despesas();
				despesa.setCodigo(rs.getInt("codigo"));
				lista.add(rs.getInt("codigo"));
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	//Lista o auto complete de despesas na página do plano de contas (pelo objeto) 
	public List<Despesas> listadespesas(String codigo) {

		ArrayList<Despesas> lista = new ArrayList<Despesas>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, grupodespesas_codigo "
				+ " from despesas where "
				+ "nome like '%"+codigo+"%'";
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Despesas despesa = new Despesas();
				despesa.setCodigo(rs.getInt("codigo"));
				despesa.setNome(rs.getString("nome"));
				despesa.setGrupodespesas_codigo(rs.getInt("grupodespesas_codigo"));
				lista.add(despesa);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	//Lista o auto complete de despesas na página do Plano de Contas 
	public List<Despesas> listanomedespesa(String nome) {

		ArrayList<Despesas> lista = new ArrayList<>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, grupodespesas_codigo from despesas where "
				+ "nome like '%"+nome+"%'";
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Despesas despesa = new Despesas();
				despesa.setCodigo(rs.getInt("codigo"));
				despesa.setNome(rs.getString("nome"));
				despesa.setGrupodespesas_codigo(rs.getInt("grupodespesas_codigo"));
				lista.add(despesa);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	
	
	public Despesas listadespesa(Integer codigo) {

		ArrayList<Despesas> lista = new ArrayList<Despesas>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, grupodespesas_codigo, "
				+ " from despesas where "
				+ "codigo = ?";
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			preparedStatement.setInt(1, codigo);
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Despesas despesa = new Despesas();
				despesa.setCodigo(rs.getInt("codigo"));
				despesa.setNome(rs.getString("nome"));
				despesa.setGrupodespesas_codigo(rs.getInt("grupodespesas_codigo"));
				int idGrupo = despesa.getGrupodespesas_codigo();		
				GrupoDespesas grupoDespesas = getGrupoDespesas(idGrupo);
				despesa.setGrupodespesas(grupoDespesas);

				lista.add(despesa);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		Despesas despesa = null;
		if (lista != null && !lista.isEmpty()) {
			despesa = lista.get(0);
		}
		return despesa;
	}
////////////////////////////LISTA DO AUTOCOMPLETE /////////////////////////

////////////////////////////GRUPOS /////////////////////////	
	public GrupoDespesas getGrupoDespesas(int idGrupo) throws SQLException {
		GrupoDespesas grupo = new GrupoDespesas();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select codigo, nomegrupodespesa from grupodespesas where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNomegrupodespesas(rs.getString("nomegrupodespesa"));
		}
		return grupo;
	}
	
	public Empresa getEmpresa(String idEmpresa) throws SQLException {
		Empresa empresa = new Empresa();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select cnpj, nome from empresas where cnpj = ?");
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
		preparedStatement = conexao.prepareStatement(
				"select codigo, nome from estabelecimentos where codigo = ?");
		preparedStatement.setInt(1, idEstabelecimento);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			estabelecimento.setCodigo(rs.getInt("codigo"));
			estabelecimento.setNome(rs.getString("nome"));
		}
		return estabelecimento;
	}
}
