package br.com.grupoferraz.financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.grupoferraz.financeiro.entity.GrupoPlanoContas;
import br.com.grupoferraz.financeiro.entity.PlanoContas;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class PlanoContasDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertPlanoContas(PlanoContas PlanoContas) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();

			PreparedStatement preparedStatement = conexao.prepareStatement(
					"insert into planocontas (codigo,nome,tipo,natureza,iss,conta_contabil,contabil_estoque,inss,irpf,pis,conta,atividade,icms,observacao,grupoplanodecontas_codigo)"
							+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, PlanoContas.getCodigo());
			preparedStatement.setString(2, PlanoContas.getNome());
			preparedStatement.setString(3, PlanoContas.getTipo());
			preparedStatement.setString(4, PlanoContas.getNatureza());
			preparedStatement.setString(5, PlanoContas.getIss());
			preparedStatement.setString(6, PlanoContas.getConta_contabil());
			preparedStatement.setString(7, PlanoContas.getContabil_estoque());
			preparedStatement.setString(8, PlanoContas.getInss());
			preparedStatement.setString(9, PlanoContas.getIrpf());
			preparedStatement.setString(10, PlanoContas.getPis());
			preparedStatement.setString(11, PlanoContas.getConta());
			preparedStatement.setString(12, PlanoContas.getAtividade());
			preparedStatement.setInt(13, PlanoContas.getIcms());
			preparedStatement.setString(14, PlanoContas.getObservacao());
			if (PlanoContas.getGrupoplanocontas_codigo() != null) {
				preparedStatement.setInt(15, PlanoContas.getGrupoplanocontas_codigo());
			}
			else {
				preparedStatement.setNull(15, Types.INTEGER);
			}
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<PlanoContas> listPlanoContas() {

		ArrayList<PlanoContas> lista = new ArrayList<PlanoContas>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" + "from planocontas";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				PlanoContas PlanoContas = new PlanoContas();
				PlanoContas.setCodigo(rs.getString(1));
				PlanoContas.setNome(rs.getString(2));
				PlanoContas.setTipo(rs.getString(3));
				PlanoContas.setNatureza(rs.getString(4));
				PlanoContas.setIss(rs.getString(5));
				PlanoContas.setConta_contabil(rs.getString(6));
				PlanoContas.setContabil_estoque(rs.getString(7));
				PlanoContas.setInss(rs.getString(8));
				PlanoContas.setIrpf(rs.getString(9));
				PlanoContas.setPis(rs.getString(10));
				PlanoContas.setConta(rs.getString(11));
				PlanoContas.setAtividade(rs.getString(12));
				PlanoContas.setIcms(rs.getInt(13));
				PlanoContas.setObservacao(rs.getString(14));
				PlanoContas.setGrupoplanocontas_codigo(rs.getInt(15));
				int idGrupo = PlanoContas.getGrupoplanocontas_codigo();
				GrupoPlanoContas grupoplanocontas = getGrupoPlanoContas(idGrupo);
				PlanoContas.setGrupoplanocontas(grupoplanocontas);
				lista.add(PlanoContas);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	public GrupoPlanoContas getGrupoPlanoContas(int idGrupo) throws SQLException {
		GrupoPlanoContas grupo = new GrupoPlanoContas();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao
				.prepareStatement("select codigo, nome from grupoplanodecontas where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
		}
		return grupo;
	}
}
