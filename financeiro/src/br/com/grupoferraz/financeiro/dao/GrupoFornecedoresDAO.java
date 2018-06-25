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

import br.com.grupoferraz.financeiro.entity.GrupoFornecedores;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoFornecedoresDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoFornecedores(GrupoFornecedores grupofornecedores) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();	
			str.append("insert into grupofornecedores (codigo, nome)"
					+ " values (?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupofornecedores.getCodigo());
			preparedStatement.setString(2, grupofornecedores.getNome());
			
			preparedStatement.setInt(3, grupofornecedores.getCodigo());
			preparedStatement.setString(4, grupofornecedores.getNome());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<GrupoFornecedores> listGrupoFornecedores() {

		ArrayList<GrupoFornecedores> lista = new ArrayList<GrupoFornecedores>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" 
			+  "from grupofornecedores";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoFornecedores grupofornecedor = new GrupoFornecedores();
				grupofornecedor.setCodigo(rs.getInt(1));
				grupofornecedor.setNome(rs.getString(2));
				lista.add(grupofornecedor);
			}
			

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

}
