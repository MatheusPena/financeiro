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

import br.com.grupoferraz.financeiro.entity.GrupoPlanoContabil;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoPlanoContabilDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoPlanoContabil(GrupoPlanoContabil GrupoPlanoContabil) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();
			str.append("insert into grupoplanocontabil (codigo, nome)" + " values (?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, GrupoPlanoContabil.getCodigo());
			preparedStatement.setString(2, GrupoPlanoContabil.getNome());

			preparedStatement.setInt(3, GrupoPlanoContabil.getCodigo());
			preparedStatement.setString(4, GrupoPlanoContabil.getNome());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<GrupoPlanoContabil> listGrupoPlanoContabil() {

		ArrayList<GrupoPlanoContabil> lista = new ArrayList<GrupoPlanoContabil>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" + "from grupoplanocontabil";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoPlanoContabil GrupoPlanoContabil = new GrupoPlanoContabil();
				GrupoPlanoContabil.setCodigo(rs.getInt(1));
				GrupoPlanoContabil.setNome(rs.getString(2));
				lista.add(GrupoPlanoContabil);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
}
