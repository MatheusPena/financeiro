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

import br.com.grupoferraz.financeiro.entity.GrupoDespesas;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoDespesasDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoDespesas(GrupoDespesas grupodespesas) {


		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into grupodespesas (codigo, nomegrupodespesa)"
					+ "values (?,?)");
			str.append("on duplicate key update codigo = ?, nomegrupodespesa = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupodespesas.getCodigo());
			preparedStatement.setString(2, grupodespesas.getNomegrupodespesas());

			preparedStatement.setInt(3, grupodespesas.getCodigo());
			preparedStatement.setString(4, grupodespesas.getNomegrupodespesas());
			preparedStatement.execute();
			return true;
	
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<GrupoDespesas> listGrupoDespesas() {

		ArrayList<GrupoDespesas> lista = new ArrayList<GrupoDespesas>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" + "from grupodespesas";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoDespesas grupodespesas = new GrupoDespesas();
				grupodespesas.setCodigo(rs.getInt(1));
				grupodespesas.setNomegrupodespesas(rs.getString(2));
				lista.add(grupodespesas);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}
