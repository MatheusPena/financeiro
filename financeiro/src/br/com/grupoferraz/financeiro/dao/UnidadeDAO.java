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

import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.entity.Unidade;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class UnidadeDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertUnidade(Unidade Unidade) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();	
			str.append("insert into unidade (nome, empresas_cnpj)" + "values (?,?)");
			str.append("on duplicate key update nome = ?, empresas_cnpj = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setString(1, Unidade.getNome());
			preparedStatement.setString(2, Unidade.getEmpresas_cnpj());
			
			preparedStatement.setString(3, Unidade.getNome());
			preparedStatement.setString(4, Unidade.getEmpresas_cnpj());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Unidade> listUnidade() {

		ArrayList<Unidade> lista = new ArrayList<Unidade>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" + "from unidade";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Unidade Unidade = new Unidade();
				Unidade.setNome(rs.getString(1));
				Unidade.setEmpresas_cnpj(rs.getString(2));
				String idGrupo = Unidade.getEmpresas_cnpj();
				Empresa empresa = getEmpresa(idGrupo);
				Unidade.setEmpresa(empresa);
				lista.add(Unidade);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	public Empresa getEmpresa(String idGrupo) throws SQLException {
		Empresa grupo = new Empresa();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao
				.prepareStatement("select cnpj, nome from empresas where cnpj = ?");
		preparedStatement.setString(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCnpj(rs.getString("cnpj"));
			grupo.setNome(rs.getString("nome"));
		}
		return grupo;
	}
}
