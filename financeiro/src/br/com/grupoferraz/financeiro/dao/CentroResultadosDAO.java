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

	public boolean insertCentroResultadoss(CentroResultados CentroResultados) {

		try {
			
			StringBuilder str = new StringBuilder();
			str.append("insert into centroresultados (codigo, nome, atividade, crcontabil, peso, grupocentroresultados_codigo)"
					+ "values (?,?,?,?,?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?, atividade = ?, "
					+ "crcontabil = ?, peso = ?, grupocentroresultados_codigo = ? ");
			
			
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, CentroResultados.getCodigo());
			preparedStatement.setString(2, CentroResultados.getNome());
			preparedStatement.setString(3, CentroResultados.getAtividade());
			preparedStatement.setString(4, CentroResultados.getCrcontabil());
			preparedStatement.setBigDecimal(5, CentroResultados.getPeso());
			if (CentroResultados.getGrupocentroresultados_codigo() != null) {
				preparedStatement.setInt(6, CentroResultados.getGrupocentroresultados_codigo());
			}
			else {
				preparedStatement.setNull(6, Types.INTEGER);
			}
			preparedStatement.setInt(7, CentroResultados.getCodigo());
			preparedStatement.setString(8, CentroResultados.getNome());
			preparedStatement.setString(9, CentroResultados.getAtividade());
			preparedStatement.setString(10, CentroResultados.getCrcontabil());
			preparedStatement.setBigDecimal(11, CentroResultados.getPeso());
			if (CentroResultados.getGrupocentroresultados_codigo() != null) {
				preparedStatement.setInt(12, CentroResultados.getGrupocentroresultados_codigo());
			}
			else {
				preparedStatement.setNull(12, Types.INTEGER);
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
	public List<CentroResultados> listCentroResultados() {

		ArrayList<CentroResultados> lista = new ArrayList<CentroResultados>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigo, nome, atividade, crcontabil, peso, grupocentroresultados_codigo from centroresultados ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				CentroResultados CentroResultados = new CentroResultados();
				CentroResultados.setCodigo(rs.getInt("codigo"));
				CentroResultados.setNome(rs.getString("nome"));
				CentroResultados.setAtividade(rs.getString("atividade"));
				CentroResultados.setCrcontabil(rs.getString("crcontabil"));
				CentroResultados.setPeso(rs.getBigDecimal("peso"));
				CentroResultados.setGrupocentroresultados_codigo(rs.getInt("grupocentroresultados_codigo"));
				int idGrupo = CentroResultados.getGrupocentroresultados_codigo();
				GrupoCResultados gcentroResultados = getGrupoCentroResultados(idGrupo);
				CentroResultados.setGruporesultados(gcentroResultados);
				lista.add(CentroResultados);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	
	//exibe o nome do grupo do centro de resultados
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
