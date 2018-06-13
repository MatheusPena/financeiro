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

import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class EstabelecimentoDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertEstabelecimentos(Estabelecimento estabelecimentos) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();

			PreparedStatement preparedStatement = conexao
					.prepareStatement("insert into estabelecimentos (codigo, nome, grupoestabelecimento_codigo) "
							+ "values (?,?,?)");
			preparedStatement.setString(1, estabelecimentos.getCodigo());
			preparedStatement.setString(2, estabelecimentos.getNome());
			preparedStatement.setString(3, estabelecimentos.getGrupoestabelecimento_codigo());
			

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
				estabelecimentos.setCodigo(rs.getString("codigo"));
				estabelecimentos.setNome(rs.getString("nome"));
				estabelecimentos.setGrupoestabelecimento_codigo(rs.getString("grupoestabelecimento_codigo"));
				
				lista.add(estabelecimentos);
			}
			

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}
