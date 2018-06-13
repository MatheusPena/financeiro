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

import br.com.grupoferraz.financeiro.entity.GrupoEstabelecimento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoEstabelecimentoDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoEstabelecimento(GrupoEstabelecimento grupoestabelecimento) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();

			PreparedStatement preparedStatement = conexao
					.prepareStatement("insert into grupoestabelecimento (codigo, nomegrupoestabelecimento)"
							+ "values (?,?)");
			preparedStatement.setInt(1, grupoestabelecimento.getCodigo());
			preparedStatement.setString(2, grupoestabelecimento.getNomegrupoestabelecimento());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<GrupoEstabelecimento> listGrupoEstabelecimento() {

		ArrayList<GrupoEstabelecimento> lista = new ArrayList<GrupoEstabelecimento>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" 
			+  "from grupoestabelecimento";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoEstabelecimento grupoestabelecimento = new GrupoEstabelecimento();
				grupoestabelecimento.setCodigo(rs.getInt(1));
				grupoestabelecimento.setNomegrupoestabelecimento(rs.getString(2));
				lista.add(grupoestabelecimento);
			}
			

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}