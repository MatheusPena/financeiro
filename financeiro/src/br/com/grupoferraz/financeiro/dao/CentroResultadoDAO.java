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

import br.com.grupoferraz.financeiro.entity.CentroResultado;
import br.com.grupoferraz.financeiro.entity.GrupoCResultado;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class CentroResultadoDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertCentroResultadoss(CentroResultado CentroResultado) {

		try {
			
			StringBuilder str = new StringBuilder();
			str.append("insert into centroresultado (codigo, nome, atividade, peso, grupocentroresultado_codigo)"
					+ "values (?,?,?,?,?)");
			str.append("insert into centroresultado (codigo, nome, atividade, crcontabil, peso, grupocentroresultados_codigo)"
					+ "values (?,?,?,?,?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?, atividade = ?, "
					+ "peso = ?, grupocentroresultado_codigo = ? ");
			
			
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, CentroResultado.getCodigo());
			preparedStatement.setString(2, CentroResultado.getNome());
			preparedStatement.setString(3, CentroResultado.getAtividade());
			preparedStatement.setBigDecimal(4, CentroResultado.getPeso());
			if (CentroResultado.getGrupocentroresultado_codigo() != null) {
				preparedStatement.setInt(5, CentroResultado.getGrupocentroresultado_codigo());
			}
			else {
				preparedStatement.setNull(5, Types.INTEGER);
			}
			preparedStatement.setInt(6, CentroResultado.getCodigo());
			preparedStatement.setString(7, CentroResultado.getNome());
			preparedStatement.setString(8, CentroResultado.getAtividade());
			preparedStatement.setBigDecimal(9, CentroResultado.getPeso());
			if (CentroResultado.getGrupocentroresultado_codigo() != null) {
				preparedStatement.setInt(10, CentroResultado.getGrupocentroresultado_codigo());
			}
			else {
				preparedStatement.setNull(10, Types.INTEGER);
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
	public List<CentroResultado> listCentroResultados() {

		ArrayList<CentroResultado> lista = new ArrayList<CentroResultado>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
<<<<<<< Upstream, based on branch 'master' of https://github.com/MatheusPena/financeiro.git
			String sql = "select codigo, nome, atividade, peso, grupocentroresultado_codigo from centroresultado ";
=======
			String sql = "select codigo, nome, atividade, crcontabil, peso, grupocentroresultados_codigo from centroresultado ";
>>>>>>> 3f93441 Grupo/cadastro contafinanceira, adiantamento, contapagar etc editados
			rs = st.executeQuery(sql);

			while (rs.next()) {

				CentroResultado CentroResultado = new CentroResultado();
				CentroResultado.setCodigo(rs.getInt("codigo"));
				CentroResultado.setNome(rs.getString("nome"));
				CentroResultado.setAtividade(rs.getString("atividade"));
				CentroResultado.setPeso(rs.getBigDecimal("peso"));
				CentroResultado.setGrupocentroresultado_codigo(rs.getInt("grupocentroresultado_codigo"));
				int idGrupo = CentroResultado.getGrupocentroresultado_codigo();
				GrupoCResultado gcentroResultados = getGrupoCentroResultado(idGrupo);
				CentroResultado.setGruporesultado(gcentroResultados);
				lista.add(CentroResultado);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	
	//exibe o nome do grupo do centro de resultados
	public GrupoCResultado getGrupoCentroResultado(int idGrupo) throws SQLException {
		GrupoCResultado grupo = new GrupoCResultado();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select * from grupocentroresultado where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
		}
		return grupo;
	}
}
