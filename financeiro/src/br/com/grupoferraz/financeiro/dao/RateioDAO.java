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
import br.com.grupoferraz.financeiro.entity.Rateio;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class RateioDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertRateio(Rateio Rateio) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();
			str.append(
					"insert into rateio (codigo, percentual, planocontas_codigo, estabelecimentos_codigo, centroresultado_codigo)"
							+ "values (?,?,?,?,?)");
			str.append("on duplicate key update codigo = ?, percentual = ?, planocontas_codigo = ?, estabelecimentos_codigo = ?, centroresultado_codigo = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, Rateio.getCodigo());
			preparedStatement.setFloat(2, Rateio.getPercentual());
			preparedStatement.setString(3, Rateio.getReceita());
			preparedStatement.setInt(4, Rateio.getEstabelecimento());
			preparedStatement.setInt(5, Rateio.getCentro_resultados());

			preparedStatement.setInt(6, Rateio.getCodigo());
			preparedStatement.setFloat(7, Rateio.getPercentual());
			preparedStatement.setString(8, Rateio.getReceita());
			preparedStatement.setInt(9, Rateio.getEstabelecimento());
			preparedStatement.setInt(10, Rateio.getCentro_resultados());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Rateio> listRateio() {

		ArrayList<Rateio> lista = new ArrayList<Rateio>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" + "from Rateio";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Rateio Rateio = new Rateio();
				Rateio.setCodigo(rs.getInt(1));
				Rateio.setReceita(rs.getString(2));
				
				Rateio.setEstabelecimento(rs.getInt(3));
				Rateio.setCentro_resultados(rs.getInt(4));
				Rateio.setPercentual(rs.getFloat(5));
				lista.add(Rateio);
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
		preparedStatement = conexao.prepareStatement("select cnpj, nome from empresas where cnpj = ?");
		preparedStatement.setString(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCnpj(rs.getString("cnpj"));
			grupo.setNome(rs.getString("nome"));
		}
		return grupo;
	}
}
