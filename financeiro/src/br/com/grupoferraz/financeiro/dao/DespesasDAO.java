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
			str.append("insert into despesas (codigo, nome,"
					+ "grupodespesas_codigo,"
					+ "emissao, validade ) values (?,?,?,?,?) ");
			str.append("on duplicate key update codigo = ?, nome = ?, "
					+ "grupodespesas_codigo = ?,"
					+ "emissao = ?, validade = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, despesa.getCodigo());
			preparedStatement.setString(2, despesa.getNome());
			preparedStatement.setInt(3, despesa.getGrupodespesas_codigo());
			Date dataEmissao = despesa.getEmissao();
			long t = 0;
			if (dataEmissao != null ) {
				t = dataEmissao.getTime();	
			}
			preparedStatement.setDate(4, new java.sql.Date(t));
			
			Date dataValidade = despesa.getValidade();
			long j = 0;
			if (dataValidade != null ) {
				j = dataValidade.getTime();	
			}
			preparedStatement.setDate(5, new java.sql.Date(j));

			preparedStatement.setInt(6, despesa.getCodigo());
			preparedStatement.setString(7, despesa.getNome());
			preparedStatement.setInt(8, despesa.getGrupodespesas_codigo());
			preparedStatement.setDate(9, new java.sql.Date(t));
			preparedStatement.setDate(10, new java.sql.Date(j));

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
			String sql = "select * from despesas";
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
////////////////////////////LISTA DO AUTOCOMPLETE DA DESPESA /////////////////////////
	public List<Integer> listadespesa(String codigo) {

		ArrayList<Integer> lista = new ArrayList<Integer>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, grupodespesas_codigo, "
				+ "emissao, validade from despesas where "
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

	public Despesas listadespesa(Integer codigo) {

		ArrayList<Despesas> lista = new ArrayList<Despesas>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, grupodespesas_codigo, "
				+ "emissao, validade from despesas where "
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
				despesa.setEmissao(rs.getDate("emissao"));
				despesa.setValidade(rs.getDate("validade"));
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
