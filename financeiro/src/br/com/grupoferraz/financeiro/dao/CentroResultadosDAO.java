package br.com.grupoferraz.financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.grupoferraz.financeiro.entity.CentroResultados;
import br.com.grupoferraz.financeiro.entity.GrupoCResultados;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class CentroResultadosDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertCentroResultadoss(CentroResultados CentroResultadoss) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"insert into centroresultados (codigo, nome, atividade, crcontabil, peso, grupocentroresultados_codigo) "
							+ "values (?,?,?,?,?,?)");
			preparedStatement.setInt(1, CentroResultadoss.getCodigo());
			preparedStatement.setString(2, CentroResultadoss.getNome());
			preparedStatement.setString(3, CentroResultadoss.getAtividade());
			preparedStatement.setString(4, CentroResultadoss.getCrcontabil());
			preparedStatement.setFloat(5, CentroResultadoss.getPeso());
			if (CentroResultadoss.getGrupocentroresultados_codigo() != null) {
				preparedStatement.setInt(6, CentroResultadoss.getGrupocentroresultados_codigo());
			}
			else {
				preparedStatement.setNull(6, Types.INTEGER);
			}

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<CentroResultados> listCentroResultadoss() {

		ArrayList<CentroResultados> lista = new ArrayList<CentroResultados>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigo, nome, atividade, crcontabil, peso, grupocentroresultados_codigo from centroresultados ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				CentroResultados CentroResultadoss = new CentroResultados();
				CentroResultadoss.setCodigo(rs.getInt("codigo"));
				CentroResultadoss.setNome(rs.getString("nome"));
				CentroResultadoss.setAtividade(rs.getString("atividade"));
				CentroResultadoss.setCrcontabil(rs.getString("crcontabil"));
				CentroResultadoss.setPeso(rs.getFloat("peso"));
				CentroResultadoss.setGrupocentroresultados_codigo(rs.getInt("grupocentroresultados_codigo"));
				int idGrupo = CentroResultadoss.getGrupocentroresultados_codigo();
				GrupoCResultados gcentroResultados = getGrupoCentroResultados(idGrupo);
				CentroResultadoss.setGruporesultados(gcentroResultados);
				lista.add(CentroResultadoss);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	public GrupoCResultados getGrupoCentroResultados(int idGrupo) throws SQLException {
		GrupoCResultados grupo = new GrupoCResultados();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select * from grupocentroresultados where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
		}
		return grupo;
	}
}
