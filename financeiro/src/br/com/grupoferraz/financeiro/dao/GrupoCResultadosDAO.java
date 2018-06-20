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

import br.com.grupoferraz.financeiro.entity.GrupoCResultados;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoCResultadosDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoCResultado(GrupoCResultados grupoCResultado) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"insert into grupocentroresultados (codigo, nome)" + "values (?,?)");
			preparedStatement.setInt(1, grupoCResultado.getCodigo());
			preparedStatement.setString(2, grupoCResultado.getNome());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<GrupoCResultados> listGrupoCResultado() {

		ArrayList<GrupoCResultados> lista = new ArrayList<GrupoCResultados>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" + "from grupocentroresultados";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoCResultados grupoCResultado = new GrupoCResultados();
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
}
