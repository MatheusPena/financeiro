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

import br.com.grupoferraz.financeiro.entity.GrupoContasFinanceiras;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoContasFinanceirasDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoContasFinanceiras(GrupoContasFinanceiras grupoContasFinanceiras) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();
			str.append("insert into grupocontasfinanceiras (codigo, nome)" + " values (?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupoContasFinanceiras.getCodigo());
			preparedStatement.setString(2, grupoContasFinanceiras.getNome());

			preparedStatement.setInt(3, grupoContasFinanceiras.getCodigo());
			preparedStatement.setString(4, grupoContasFinanceiras.getNome());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<GrupoContasFinanceiras> listGrupoContasFinanceiras() {

		ArrayList<GrupoContasFinanceiras> lista = new ArrayList<GrupoContasFinanceiras>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" + "from grupocontasfinanceiras";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoContasFinanceiras grupoContasFinanceiras = new GrupoContasFinanceiras();
				grupoContasFinanceiras.setCodigo(rs.getInt(1));
				grupoContasFinanceiras.setNome(rs.getString(2));
				lista.add(grupoContasFinanceiras);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}
