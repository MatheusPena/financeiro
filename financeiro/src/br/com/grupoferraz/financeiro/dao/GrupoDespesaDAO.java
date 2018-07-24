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

import br.com.grupoferraz.financeiro.entity.GrupoDespesa;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoDespesaDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoDespesa(GrupoDespesa grupodespesa) {


		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into grupodespesa (codigo, nomegrupodespesa) values (?,?)");
			str.append("on duplicate key update codigo = ?, nomegrupodespesa = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupodespesa.getCodigo());
			preparedStatement.setString(2, grupodespesa.getNomegrupodespesa());

			preparedStatement.setInt(3, grupodespesa.getCodigo());
			preparedStatement.setString(4, grupodespesa.getNomegrupodespesa());
			preparedStatement.execute();
			return true;
	
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<GrupoDespesa> listGrupoDespesas() {

		ArrayList<GrupoDespesa> lista = new ArrayList<GrupoDespesa>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from grupodespesa";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoDespesa grupodespesa = new GrupoDespesa();
				grupodespesa.setCodigo(rs.getInt(1));
				grupodespesa.setNomegrupodespesa(rs.getString(2));
				lista.add(grupodespesa);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}
