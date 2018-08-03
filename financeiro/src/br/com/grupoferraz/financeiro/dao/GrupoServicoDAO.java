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

import br.com.grupoferraz.financeiro.entity.GrupoServico;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoServicoDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoServico(GrupoServico grupoServico) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into grupo_servico (codigo, nome)" + " values (?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupoServico.getCodigo());
			preparedStatement.setString(2, grupoServico.getNome());

			preparedStatement.setInt(3, grupoServico.getCodigo());
			preparedStatement.setString(4, grupoServico.getNome());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os grupos cadastrados no banco de dados
	public List<GrupoServico> listGrupoServico() {

		ArrayList<GrupoServico> lista = new ArrayList<GrupoServico>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from grupo_servico";

			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoServico gruposervico = new GrupoServico();
				gruposervico.setCodigo(rs.getInt(1));
				gruposervico.setNome(rs.getString(2));
				lista.add(gruposervico);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
}
