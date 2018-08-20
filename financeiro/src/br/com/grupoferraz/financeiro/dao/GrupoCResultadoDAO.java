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

import br.com.grupoferraz.financeiro.entity.GrupoCResultado;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoCResultadoDAO {
	Connection conexao = ConexaoBD.getConexao();

	// método que insere um grupo de resultado
	public boolean insertGrupoCResultado(GrupoCResultado grupoCResultado) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into grupo_centro_resultado (codigo, nome)" + " values (?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupoCResultado.getCodigo());
			preparedStatement.setString(2, grupoCResultado.getNome());

			preparedStatement.setInt(3, grupoCResultado.getCodigo());
			preparedStatement.setString(4, grupoCResultado.getNome());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// método que lista os grupo(s) de resultado(s) cadastrado(s) no banco na tabela
	public List<GrupoCResultado> listGrupoCResultado() {

		ArrayList<GrupoCResultado> lista = new ArrayList<GrupoCResultado>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from grupo_centro_resultado";

			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoCResultado grupoCResultado = new GrupoCResultado();
				grupoCResultado.setCodigo(rs.getInt(1));
				grupoCResultado.setNome(rs.getString(2));
				lista.add(grupoCResultado);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// método que deleta um grupo de resultado na tabela
	public boolean deleteGrupoCResultado(int idGrupo) throws SQLException {
		boolean resposta;

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conexao.prepareStatement("delete from grupo_centro_resultado where codigo = ?");
			preparedStatement.setInt(1, idGrupo);
			preparedStatement.executeUpdate();
			resposta = true;
		} catch (Exception ex) {
			ex.printStackTrace();
			resposta = false;
		}
		return resposta;
	}
}
