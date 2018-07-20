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
import br.com.grupoferraz.financeiro.entity.Unidade;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class UnidadeDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertUnidade(Unidade Unidade) {

		try {
			StringBuilder str = new StringBuilder();	
			str.append("insert into unidade (nome, empresas_cnpj, codigo) values (?,?,?) ");
			str.append("on duplicate key update nome = ?, empresas_cnpj = ?, codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setString(1, Unidade.getNome());
			preparedStatement.setString(2, Unidade.getEmpresas_cnpj());
			preparedStatement.setInt(3, Unidade.getCodigo());
			
			preparedStatement.setString(4, Unidade.getNome());
			preparedStatement.setString(5, Unidade.getEmpresas_cnpj());
			preparedStatement.setInt(6, Unidade.getCodigo());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Unidade> listUnidade() {

		ArrayList<Unidade> lista = new ArrayList<Unidade>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from unidade";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Unidade unidade = new Unidade();
				unidade.setNome(rs.getString("nome"));
				unidade.setEmpresas_cnpj(rs.getString("empresas_cnpj"));
				unidade.setCodigo(rs.getInt("codigo"));
				String idEmpresa = unidade.getEmpresas_cnpj();
				Empresa empresa = getEmpresa(idEmpresa);
				unidade.setEmpresa(empresa);
				lista.add(unidade);
				empresa = null;
				idEmpresa = null;
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	public List<Unidade> listUnidade(String cnpj) {

		ArrayList<Unidade> lista = new ArrayList<Unidade>();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "select nome, empresas_cnpj, codigo from unidade where empresas_cnpj = ?";
			st = conexao.prepareStatement(sql);
			st.setString(1, cnpj);
			rs = st.executeQuery();

			while (rs.next()) {
				Unidade unidade = new Unidade();
				unidade.setNome(rs.getString("nome"));
				unidade.setEmpresas_cnpj(rs.getString("empresas_cnpj"));
				unidade.setCodigo(rs.getInt("codigo"));
				String idGrupo = unidade.getEmpresas_cnpj();
				Empresa empresa = getEmpresa(idGrupo);
				unidade.setEmpresa(empresa);
				lista.add(unidade);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	//Método para mostrar o nome da empresa na tabela de Unidades, ao invés do CNPJ
	public Empresa getEmpresa(String idGrupo) throws SQLException {
		Empresa grupo = new Empresa();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao
				.prepareStatement("select cnpj, nome from empresas where cnpj = ?");
		preparedStatement.setString(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCnpj(rs.getString("cnpj"));
			grupo.setNome(rs.getString("nome"));
		}
		return grupo;
	}

	//Método para mostrar o nome da unidade na tabela de Grupo Estabelecimento, ao invés do código
	public Unidade getUnidade(int id) throws SQLException {
		Unidade u = new Unidade();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao
				.prepareStatement("select codigo, nome, empresas_cnpj from unidade where codigo = ?");
		preparedStatement.setInt(1, id);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			u.setCodigo(rs.getInt("codigo"));
			u.setNome(rs.getString("nome"));
			u.setEmpresas_cnpj(rs.getString("empresas_cnpj"));
		}
		return u;
	}
}
