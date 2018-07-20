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

import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.GrupoEstabelecimento;
import br.com.grupoferraz.financeiro.entity.Unidade;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class EstabelecimentoDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertEstabelecimentos(Estabelecimento estabelecimentos) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();
			str.append("insert into estabelecimentos (codigo, nome, grupoestabelecimento_codigo) values (?,?,?) ");
			str.append("on duplicate key update codigo = ?, nome = ?, grupoestabelecimento_codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, estabelecimentos.getCodigo());
			preparedStatement.setString(2, estabelecimentos.getNome());
			preparedStatement.setInt(3, estabelecimentos.getGrupoestabelecimento_codigo());

			preparedStatement.setInt(4, estabelecimentos.getCodigo());
			preparedStatement.setString(5, estabelecimentos.getNome());
			preparedStatement.setInt(6, estabelecimentos.getGrupoestabelecimento_codigo());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Estabelecimento> listEstabelecimentos() {

		ArrayList<Estabelecimento> lista = new ArrayList<Estabelecimento>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigo, nome, grupoestabelecimento_codigo from estabelecimentos ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Estabelecimento estabelecimentos = new Estabelecimento();
				estabelecimentos.setCodigo(rs.getInt("codigo"));
				estabelecimentos.setNome(rs.getString("nome"));
				estabelecimentos.setGrupoestabelecimento_codigo(rs.getInt("grupoestabelecimento_codigo"));
				int idGrupo = estabelecimentos.getGrupoestabelecimento_codigo();
				GrupoEstabelecimento grupoEstabelecimento = getGrupoEstabelecimento(idGrupo);
				estabelecimentos.setGrupoestabalecimento(grupoEstabelecimento);
				lista.add(estabelecimentos);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
////////////////////////////LISTA DO AUTOCOMPLETE DO ESTABELECIMENTO COM INNERJOIN /////////////////////////	
	public List<Estabelecimento> listaestabelecimento(String query, String cnpj) {	

		ArrayList<Estabelecimento> lista = new ArrayList<>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		
		StringBuilder str = new StringBuilder();
		str.append("select e.codigo, e.nome, e.grupoestabelecimento_codigo from estabelecimentos e");
		str.append(" inner join grupoestabelecimento ge on ge.codigo = e.grupoestabelecimento_codigo");
		str.append(" inner join unidade u on ge.unidade_codigo = u.codigo");
		str.append(" inner join empresas emp on emp.cnpj = u.empresas_cnpj");
		str.append(" where u.empresas_cnpj = '"+cnpj+"'");
		str.append(" and e.nome like '%"+query+"%'");
		
		
		
		String sql = str.toString();
		
		System.out.println("SQL GERADA "+sql);
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			System.out.println("CNPJ "+cnpj);
			
			
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Estabelecimento estabelecimento = new Estabelecimento();
				estabelecimento.setCodigo(rs.getInt("codigo"));
				estabelecimento.setNome(rs.getString("nome"));
				estabelecimento.setGrupoestabelecimento_codigo(rs.getInt("grupoestabelecimento_codigo"));
				lista.add(estabelecimento);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

////////////////////////////LISTA DO AUTOCOMPLETE DO ESTABELECIMENTO COM INNERJOIN /////////////////////////	
	
	public Estabelecimento listaestabelecimento(Integer codigo) {

		ArrayList<Estabelecimento> lista = new ArrayList<Estabelecimento>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select codigo, nome, grupoestabelecimento_codigo from estabelecimentos where "
				+ "codigo = ?";
		

		try {

			preparedStatement = conexao.prepareStatement(sql);
			
			preparedStatement.setInt(1, codigo);
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Estabelecimento estabelecimentos = new Estabelecimento();
				estabelecimentos.setCodigo(rs.getInt("codigo"));
				estabelecimentos.setNome(rs.getString("nome"));
				estabelecimentos.setGrupoestabelecimento_codigo(rs.getInt("grupoestabelecimento_codigo"));
				int idGrupo = estabelecimentos.getGrupoestabelecimento_codigo();
				GrupoEstabelecimento grupoEstabelecimento = getGrupoEstabelecimento(idGrupo);
				estabelecimentos.setGrupoestabalecimento(grupoEstabelecimento);
				lista.add(estabelecimentos);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		Estabelecimento estabelecimentos = null;
		if (lista != null && !lista.isEmpty()) {
			estabelecimentos = lista.get(0);
		}
		return estabelecimentos;
	}

	public GrupoEstabelecimento getGrupoEstabelecimento(int idGrupo) throws SQLException {
		GrupoEstabelecimento grupo = new GrupoEstabelecimento();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select codigo, nomegrupoestabelecimento, unidade_codigo from grupoestabelecimento where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNomegrupoestabelecimento(rs.getString("nomegrupoestabelecimento"));
			grupo.setUnidade_codigo(rs.getInt("unidade_codigo"));
			grupo.setUnidade(getUnidade(grupo.getUnidade_codigo()));
		}
		return grupo;
	}
	
	
	public Unidade getUnidade(int idUnidade) throws SQLException {

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		
		StringBuilder str = new StringBuilder();
		str.append("select codigo, nome, empresas_cnpj from unidade where codigo = ?");
		
		ArrayList<Unidade> lista = new ArrayList<Unidade>();

		preparedStatement = conexao.prepareStatement(
				str.toString());
		preparedStatement.setInt(1, idUnidade);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			
			Unidade u = new Unidade();
			u.setCodigo(rs.getInt("codigo"));
			u.setNome(rs.getString("nome"));
			u.setEmpresas_cnpj(rs.getString("empresas_cnpj"));
			String cnpj = u.getEmpresas_cnpj();
			Empresa empresa = new UnidadeDAO().getEmpresa(cnpj);
			u.setEmpresa(empresa);
			lista.add(u);
		}
		
		if(!lista.isEmpty()) {
			return lista.get(0);
		}
		
		return null;
	}
	
	
	
	
	
	public List<Estabelecimento> getEstabelecimento(String idEmpresa) throws SQLException {

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		
		StringBuilder str = new StringBuilder();
		str.append("select e.codigo, e.nome, e.grupoestabelecimento_codigo from estabelecimentos e");
		str.append(" inner join grupoestabelecimento ge on ge.codigo = e.grupoestabelecimento_codigo");
		str.append(" inner join unidade u on ge.unidade_codigo = u.nome");
		str.append(" inner join empresas emp on emp.cnpj = u.empresas_cnpj");
		str.append(" and emp.cnpj = ?");
		
		List<Estabelecimento> lista = new ArrayList<>();
		preparedStatement = conexao.prepareStatement(
				str.toString());
		preparedStatement.setString(1, idEmpresa);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			Estabelecimento estabelecimentos = new Estabelecimento();
			estabelecimentos.setCodigo(rs.getInt("codigo"));
			estabelecimentos.setNome(rs.getString("nome"));
			estabelecimentos.setGrupoestabelecimento_codigo(rs.getInt("grupoestabelecimento_codigo"));
			int idGrupo = estabelecimentos.getGrupoestabelecimento_codigo();
			GrupoEstabelecimento grupoEstabelecimento = getGrupoEstabelecimento(idGrupo);
			estabelecimentos.setGrupoestabalecimento(grupoEstabelecimento);
			lista.add(estabelecimentos);
		}
		return lista;
	}
}
