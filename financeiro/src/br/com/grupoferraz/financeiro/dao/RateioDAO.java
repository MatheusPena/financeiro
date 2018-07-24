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

import br.com.grupoferraz.financeiro.entity.CentroResultados;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.PlanoContas;
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
					"insert into rateio (codigo, percentual, planocontas_codigo, estabelecimentos_codigo, centroresultados_codigo)"
							+ "values (?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?, percentual = ?, planocontas_codigo = ?, estabelecimentos_codigo = ?, centroresultados_codigo = ?");
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
			String sql = "select *" + "from rateio";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Rateio Rateio = new Rateio();
				Rateio.setCodigo(rs.getInt(1));
				Rateio.setPercentual(rs.getFloat(2));
				Rateio.setReceita(rs.getString(3));
				String idGrupo = Rateio.getReceita();
				PlanoContas planocontas = getPlanoContas(idGrupo);
				Rateio.setPlanocontas(planocontas);
				Rateio.setEstabelecimento(rs.getInt(4));
				Estabelecimento obj2 = getEstabelecimento(Rateio.getEstabelecimento());
				Rateio.setEstabelecimentos(obj2);
				Rateio.setCentro_resultados(rs.getInt(5));
				CentroResultados obj3 = getCentroResultados(Rateio.getCentro_resultados());
				Rateio.setCentroresultados(obj3);
				lista.add(Rateio);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	public PlanoContas getPlanoContas(String idGrupo) throws SQLException {
		PlanoContas grupo = new PlanoContas();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao
				.prepareStatement("select codigo, nome, tipo, natureza, iss, conta_contabil, contabil_estoque, \"\r\n"
						+ "					+ \"inss, irpf, pis, conta, atividade, icms, observacao, grupoplanodecontas_codigo from planocontas where codigo = ?");
		preparedStatement.setString(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getString("codigo"));
			grupo.setNome(rs.getInt("nome"));
			grupo.setTipo(rs.getString("tipo"));
			grupo.setNatureza(rs.getString("natureza"));
			grupo.setInss(rs.getString("iss"));
			grupo.setConta_contabil(rs.getString("conta_contabil"));
			grupo.setContabil_estoque(rs.getString("contabil_estoque"));
			grupo.setInss(rs.getString("inss"));
			grupo.setIrpf(rs.getString("irpf"));
			grupo.setPis(rs.getString("pis"));
			grupo.setConta(rs.getString("conta"));
			grupo.setAtividade(rs.getString("atividade"));
			grupo.setIcms(rs.getInt("icms"));
			grupo.setObservacao(rs.getString("observacao"));
			grupo.setGrupoplanocontas_codigo(rs.getInt("grupoplanodecontas_codigo"));
		}
		return grupo;
	}
	
	//Exibe o nome da agência em vez do código na tela
		public Estabelecimento getEstabelecimento(int idGrupo) throws SQLException {
			Estabelecimento grupo = new Estabelecimento();
			PreparedStatement preparedStatement;
			ResultSet rs = null;
				preparedStatement = conexao
						.prepareStatement ("select * from estabelecimentos where codigo = ?");
				preparedStatement.setInt(1, idGrupo);
				rs = preparedStatement.executeQuery();

			while (rs.next()) {
				grupo.setCodigo(rs.getInt("codigo"));
				grupo.setNome(rs.getString("nome"));
				grupo.setGrupoestabelecimento_codigo(rs.getInt("grupoestabelecimento_codigo"));
			}
			return grupo;
		}
		
		public CentroResultados getCentroResultados(int idGrupo) throws SQLException {
			CentroResultados grupo = new CentroResultados();
			PreparedStatement preparedStatement;
			ResultSet rs = null;
				preparedStatement = conexao
						.prepareStatement ("select * from centroresultados where codigo = ?");
				preparedStatement.setInt(1, idGrupo);
				rs = preparedStatement.executeQuery();

			while (rs.next()) {
				grupo.setCodigo(rs.getInt("codigo"));
				grupo.setNome(rs.getString("nome"));
				grupo.setAtividade(rs.getString("atividade"));
				grupo.setCrcontabil(rs.getString("crcontabil"));
				grupo.setPeso(rs.getBigDecimal("peso"));
				grupo.setGrupocentroresultados_codigo(rs.getInt("grupocentroresultados_codigo"));
			}
			return grupo;
		}
}
