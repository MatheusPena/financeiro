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
			str.append("insert into despesas (codigo, nome, valor, "
					+ "grupodespesas_codigo, estabelecimentos_codigo, "
					+ "empresa_cnpj, emissao, validade ) values (?,?,?,?,?,?,?,?) ");
			str.append("on duplicate key update codigo = ?, nome = ?, valor = ?,"
					+ "grupodespesas_codigo = ?, estabelecimentos_codigo = ?,"
					+ "empresa_cnpj = ?, emissao = ?, validade = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, despesa.getCodigo());
			preparedStatement.setString(2, despesa.getNome());
			preparedStatement.setString(3, despesa.getValor());
			preparedStatement.setInt(4, despesa.getGrupodespesas_codigo());
			preparedStatement.setInt(5, despesa.getEstabelecimentos_codigo());
			preparedStatement.setString(6, despesa.getEmpresa_cnpj());
			Date dataEmissao = despesa.getEmissao();
			long t = 0;
			if (dataEmissao != null ) {
				t = dataEmissao.getTime();	
			}
			preparedStatement.setDate(7, new java.sql.Date(t));
			
			Date dataValidade = despesa.getValidade();
			long j = 0;
			if (dataValidade != null ) {
				j = dataValidade.getTime();	
			}
			preparedStatement.setDate(8, new java.sql.Date(j));

			preparedStatement.setInt(9, despesa.getCodigo());
			preparedStatement.setString(10, despesa.getNome());
			preparedStatement.setString(11, despesa.getValor());
			preparedStatement.setInt(12, despesa.getGrupodespesas_codigo());
			preparedStatement.setInt(13, despesa.getEstabelecimentos_codigo());
			preparedStatement.setString(14, despesa.getEmpresa_cnpj());
			preparedStatement.setDate(15, new java.sql.Date(t));
			preparedStatement.setDate(16, new java.sql.Date(j));

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
			String sql = "select codigo, nome, valor, grupodespesas_codigo, "
					+ "estabelecimentos_codigo, empresa_cnpj, emissao, validade from despesas";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Despesas despesa = new Despesas();
				despesa.setCodigo(rs.getInt("codigo"));
				despesa.setNome(rs.getString("nome"));
				despesa.setValor(rs.getString("valor"));
				despesa.setGrupodespesas_codigo(rs.getInt("grupodespesas_codigo"));
				int idGrupo = despesa.getGrupodespesas_codigo();
				String idEmpresa = rs.getString("empresa_cnpj");
				GrupoDespesas grupoDespesas = getGrupoDespesas(idGrupo);
				Empresa empresa = getEmpresa(idEmpresa);
				despesa.setEmpresa(empresa);
				despesa.setGrupodespesas(grupoDespesas);
				despesa.setEstabelecimentos_codigo(rs.getInt("estabelecimentos_codigo"));
				Estabelecimento estabelecimento = getEstabelecimento(despesa.getEstabelecimentos_codigo());
				despesa.setEstabelecimento(estabelecimento);
				despesa.setEmpresa_cnpj(idEmpresa);
				despesa.setEmissao(rs.getDate("emissao"));
				despesa.setValidade(rs.getDate("validade"));
				lista.add(despesa);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	public List<Integer> listadespesa(String codigo) {

		ArrayList<Integer> lista = new ArrayList<Integer>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, valor, grupodespesas_codigo, "
				+ "estabelecimentos_codigo, empresa_cnpj, emissao, validade from despesas where "
				+ "cast(codigo as char) like '%"+codigo+"%'";
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			//preparedStatement.setString(1, codigo);
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Despesas despesa = new Despesas();
				despesa.setCodigo(rs.getInt("codigo"));
//				despesa.setNome(rs.getString("nome"));
//				despesa.setValor(rs.getString("valor"));
//				despesa.setGrupodespesas_codigo(rs.getInt("grupodespesas_codigo"));
//				int idGrupo = despesa.getGrupodespesas_codigo();
//				String idEmpresa = rs.getString("empresa_cnpj");
//				GrupoDespesas grupoDespesas = getGrupoDespesas(idGrupo);
//				Empresa empresa = getEmpresa(idEmpresa);
//				despesa.setEmpresa(empresa);
//				despesa.setGrupodespesas(grupoDespesas);
//				despesa.setEstabelecimentos_codigo(rs.getInt("estabelecimentos_codigo"));
//				Estabelecimento estabelecimento = getEstabelecimento(despesa.getEstabelecimentos_codigo());
//				despesa.setEstabelecimento(estabelecimento);
//				despesa.setEmpresa_cnpj(idEmpresa);
//				despesa.setEmissao(rs.getDate("emissao"));
//				despesa.setValidade(rs.getDate("validade"));
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
		String sql = "select codigo, nome, valor, grupodespesas_codigo, "
				+ "estabelecimentos_codigo, empresa_cnpj, emissao, validade from despesas where "
				+ "codigo = ?";
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			preparedStatement.setInt(1, codigo);
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Despesas despesa = new Despesas();
				despesa.setCodigo(rs.getInt("codigo"));
				despesa.setNome(rs.getString("nome"));
				despesa.setValor(rs.getString("valor"));
				despesa.setGrupodespesas_codigo(rs.getInt("grupodespesas_codigo"));
				int idGrupo = despesa.getGrupodespesas_codigo();
				String idEmpresa = rs.getString("empresa_cnpj");
				GrupoDespesas grupoDespesas = getGrupoDespesas(idGrupo);
				Empresa empresa = getEmpresa(idEmpresa);
				despesa.setEmpresa(empresa);
				despesa.setGrupodespesas(grupoDespesas);
				despesa.setEstabelecimentos_codigo(rs.getInt("estabelecimentos_codigo"));
				Estabelecimento estabelecimento = getEstabelecimento(despesa.getEstabelecimentos_codigo());
				despesa.setEstabelecimento(estabelecimento);
				despesa.setEmpresa_cnpj(idEmpresa);
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
