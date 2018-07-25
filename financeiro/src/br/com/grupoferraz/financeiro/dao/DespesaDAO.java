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
import br.com.grupoferraz.financeiro.entity.Despesa;
import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.GrupoDespesa;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class DespesaDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertDespesas(Despesa despesa) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into despesa (codigo, nome, grupodespesa_codigo) values (?,?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?, grupodespesa_codigo = ?");
	
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, despesa.getCodigo());
			preparedStatement.setString(2, despesa.getNome());
			preparedStatement.setInt(3, despesa.getGrupodespesa_codigo());
			
			preparedStatement.setInt(4, despesa.getCodigo());
			preparedStatement.setString(5, despesa.getNome());
			preparedStatement.setInt(6, despesa.getGrupodespesa_codigo());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Despesa> listadespesa() {

		ArrayList<Despesa> lista = new ArrayList<Despesa>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigo, nome, grupodespesa_codigo from despesa";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Despesa despesa = new Despesa();
				despesa.setCodigo(rs.getInt("codigo"));
				despesa.setNome(rs.getString("nome"));
				despesa.setGrupodespesa_codigo(rs.getInt("grupodespesa_codigo"));
				int idGrupo = despesa.getGrupodespesa_codigo();		
				GrupoDespesa grupoDespesa = getGrupoDespesa(idGrupo);
				despesa.setGrupodespesa(grupoDespesa);		
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
		String sql = "select codigo, nome, grupodespesa_codigo "
				+ " from despesa where "
				+ "cast(codigo as char) like '%"+codigo+"%'";
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Despesa despesa = new Despesa();
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
	public List<Despesa> listadespesas(String codigo) {

		ArrayList<Despesa> lista = new ArrayList<Despesa>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, grupodespesa_codigo "
				+ " from despesa where "
				+ "nome like '%"+codigo+"%'";
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Despesa despesa = new Despesa();
				despesa.setCodigo(rs.getInt("codigo"));
				despesa.setNome(rs.getString("nome"));
				despesa.setGrupodespesa_codigo(rs.getInt("grupodespesa_codigo"));
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
	public List<Despesa> listanomedespesa(String nome) {

		ArrayList<Despesa> lista = new ArrayList<>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, grupodespesa_codigo from despesa where "
				+ "nome like '%"+nome+"%'";
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Despesa despesa = new Despesa();
				despesa.setCodigo(rs.getInt("codigo"));
				despesa.setNome(rs.getString("nome"));
				despesa.setGrupodespesa_codigo(rs.getInt("grupodespesa_codigo"));
				lista.add(despesa);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	
	
	public Despesa listadespesa(Integer codigo) {

		ArrayList<Despesa> lista = new ArrayList<Despesa>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, grupodespesa_codigo from despesa where codigo = ?";
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			preparedStatement.setInt(1, codigo);
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Despesa despesa = new Despesa();
				despesa.setCodigo(rs.getInt("codigo"));
				despesa.setNome(rs.getString("nome"));
				despesa.setGrupodespesa_codigo(rs.getInt("grupodespesa_codigo"));
				int idGrupo = despesa.getGrupodespesa_codigo();		
				GrupoDespesa grupoDespesa= getGrupoDespesa(idGrupo);
				despesa.setGrupodespesa(grupoDespesa);

				lista.add(despesa);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		Despesa despesa = null;
		if (lista != null && !lista.isEmpty()) {
			despesa = lista.get(0);
		}
		return despesa;
	}


//Listagem de Grupos
	public GrupoDespesa getGrupoDespesa(int idGrupo) throws SQLException {
		GrupoDespesa grupo = new GrupoDespesa();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select codigo, nomegrupodespesa from grupodespesa where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNomegrupodespesa(rs.getString("nomegrupodespesa"));
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
