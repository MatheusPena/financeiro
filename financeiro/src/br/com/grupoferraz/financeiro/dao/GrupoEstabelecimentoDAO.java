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
import br.com.grupoferraz.financeiro.entity.GrupoEstabelecimento;
import br.com.grupoferraz.financeiro.entity.Unidade;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class GrupoEstabelecimentoDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertGrupoEstabelecimento(GrupoEstabelecimento grupoestabelecimento) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into grupoestabelecimento (codigo, nomegrupoestabelecimento, unidade_codigo, empresa)"
					+ "values (?,?,?,?)");
			str.append("on duplicate key update codigo = ?, nomegrupoestabelecimento = ?, unidade_codigo = ?, empresa = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, grupoestabelecimento.getCodigo());
			preparedStatement.setString(2, grupoestabelecimento.getNomegrupoestabelecimento());
			preparedStatement.setInt(3, grupoestabelecimento.getUnidade_codigo());
			preparedStatement.setString(4, grupoestabelecimento.getEmpresa());
			
			preparedStatement.setInt(5, grupoestabelecimento.getCodigo());
			preparedStatement.setString(6, grupoestabelecimento.getNomegrupoestabelecimento());
			preparedStatement.setInt(7, grupoestabelecimento.getUnidade_codigo());
			preparedStatement.setString(8, grupoestabelecimento.getEmpresa());

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
			String sql = "select * from grupoestabelecimento";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				GrupoEstabelecimento grupoestabelecimento = new GrupoEstabelecimento();
				grupoestabelecimento.setCodigo(rs.getInt(1));
				grupoestabelecimento.setNomegrupoestabelecimento(rs.getString(2));
				grupoestabelecimento.setUnidade_codigo(rs.getInt(3));
				grupoestabelecimento.setEmpresa(rs.getString(4));
				Empresa empresa = new UnidadeDAO().getEmpresa(grupoestabelecimento.getEmpresa());
				grupoestabelecimento.setEmp(empresa);
				Unidade unidade = new UnidadeDAO().getUnidade(grupoestabelecimento.getUnidade_codigo());
				grupoestabelecimento.setUnidade(unidade);
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
