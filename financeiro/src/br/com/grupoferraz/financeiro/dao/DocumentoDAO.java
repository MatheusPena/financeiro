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

import br.com.grupoferraz.financeiro.entity.Documento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class DocumentoDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertDocumentos(Documento documento) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into documento (codigo, nome) values (?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, documento.getCodigo());
			preparedStatement.setString(2, documento.getNome());

			preparedStatement.setInt(3, documento.getCodigo());
			preparedStatement.setString(4, documento.getNome());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Documento> listDocumentos() {

		ArrayList<Documento> lista = new ArrayList<Documento>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigo, nome from documento ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Documento documento = new Documento();
				documento.setCodigo(rs.getInt("codigo"));
				documento.setNome(rs.getString("nome"));
				lista.add(documento);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}
