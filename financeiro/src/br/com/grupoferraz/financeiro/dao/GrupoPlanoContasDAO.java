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

import br.com.grupoferraz.financeiro.entity.GrupoPlanoContas;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoPlanoContasDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoPlanoContas(GrupoPlanoContas grupoPlanoContas) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();	
			str.append("insert into grupoplanodecontas (codigo, nome)"
					+ " values (?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupoPlanoContas.getCodigo());
			preparedStatement.setString(2, grupoPlanoContas.getNome());
			
			preparedStatement.setInt(3, grupoPlanoContas.getCodigo());
			preparedStatement.setString(4, grupoPlanoContas.getNome());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<GrupoPlanoContas> listGrupoPlanoContas() {

		ArrayList<GrupoPlanoContas> lista = new ArrayList<GrupoPlanoContas>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" + "from grupoplanodecontas";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoPlanoContas grupoPlanoContas = new GrupoPlanoContas();
				grupoPlanoContas.setCodigo(rs.getInt(1));
				grupoPlanoContas.setNome(rs.getString(2));
				lista.add(grupoPlanoContas);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}
