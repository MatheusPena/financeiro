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
import br.com.grupoferraz.financeiro.entity.Despesas;
import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.entity.GrupoDespesas;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class DespesasDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertDespesas(Despesas despesa) {

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();
			str.append("insert into despesas (codigo, nome, valor, grupodespesas_codigo, empresas_cnpj) values (?,?,?,?,?) ");
			str.append("on duplicate key update codigo = ?, nome = ?, valor = ?, grupodespesas_codigo = ?, empresas_cnpj = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, despesa.getCodigo());
			preparedStatement.setString(2, despesa.getNome());
			preparedStatement.setString(3, despesa.getValor());
			preparedStatement.setInt(4, despesa.getGrupodespesas_codigo());
			preparedStatement.setString(5, despesa.getEmpresas_cnpj());

			preparedStatement.setInt(6, despesa.getCodigo());
			preparedStatement.setString(7, despesa.getNome());
			preparedStatement.setString(8, despesa.getValor());
			preparedStatement.setInt(9, despesa.getGrupodespesas_codigo());
			preparedStatement.setString(10, despesa.getEmpresas_cnpj());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Despesas> listadespesa() {

		ArrayList<Despesas> lista = new ArrayList<Despesas>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigo, nome, valor, grupodespesas_codigo from despesas";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Despesas despesa = new Despesas();
				despesa.setCodigo(rs.getInt("codigo"));
				despesa.setNome(rs.getString("nome"));
				despesa.setValor(rs.getString("valor"));
				despesa.setGrupodespesas_codigo(rs.getInt("grupodespesas_codigo"));
				int idGrupo = despesa.getGrupodespesas_codigo();
				GrupoDespesas grupoDespesas = getGrupoDespesas(idGrupo);
				despesa.setGrupodespesas(grupoDespesas);
				//despesa.setEmpresas_cnpj(rs.getString("empresas_cnpj"));
				lista.add(despesa);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	public GrupoDespesas getGrupoDespesas(int idGrupo) throws SQLException {
		GrupoDespesas grupo = new GrupoDespesas();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select codigo, nomegrupodespesa from grupodespesas where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNomegrupodespesas(rs.getString("nomegrupodespesa"));
		}
		return grupo;
	}
	
	public Empresa getEmpresa(int idEmpresa) throws SQLException {
		Empresa empresa = new Empresa();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement(
				"select cnpj, nome from empresas where cnpj = ?");
		preparedStatement.setInt(1, idEmpresa);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			empresa.setCnpj(rs.getString("cnpj"));
			empresa.setNome(rs.getString("nome"));
		}
		return empresa;
	}
}
