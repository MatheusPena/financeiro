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

import br.com.grupoferraz.financeiro.entity.GrupoModalidade;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoModalidadeDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoModalidade(GrupoModalidade grupoModalidade) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into grupo_modalidade (codigo, nome)" + " values (?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupoModalidade.getCodigo());
			preparedStatement.setString(2, grupoModalidade.getNome());

			preparedStatement.setInt(3, grupoModalidade.getCodigo());
			preparedStatement.setString(4, grupoModalidade.getNome());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os grupos cadastrados no banco de dados
	public List<GrupoModalidade> listGrupoModalidade() {

		ArrayList<GrupoModalidade> lista = new ArrayList<GrupoModalidade>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from grupo_modalidade";

			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoModalidade grupomodalidade = new GrupoModalidade();
				grupomodalidade.setCodigo(rs.getInt(1));
				grupomodalidade.setNome(rs.getString(2));
				lista.add(grupomodalidade);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}
