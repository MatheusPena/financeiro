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

import br.com.grupoferraz.financeiro.entity.DespesaReceita;
import br.com.grupoferraz.financeiro.entity.GrupoDespesaReceita;
import br.com.grupoferraz.financeiro.entity.PlanoConta;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class PlanoContaDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertPlanoContas(PlanoConta PlanoConta) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into planoconta (codigo, nome, tipo, natureza, iss,"
					+ "inss, irpf, pis, conta, atividade, icms, observacao, grupodespesa_codigo)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			str.append("on duplicate key update codigo = ?, nome = ?, tipo = ?, "
					+ "natureza = ?, iss = ?, inss = ?, irpf = ?, pis = ?, "
					+ "conta = ?, atividade = ?, icms = ?, observacao = ?,  " + "grupodespesa_codigo = ? ");

			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setString(1, PlanoConta.getCodigo());
			preparedStatement.setInt(2, PlanoConta.getNome());
			preparedStatement.setString(3, PlanoConta.getTipo());
			preparedStatement.setString(4, PlanoConta.getNatureza());
			preparedStatement.setString(5, PlanoConta.getIss());
			preparedStatement.setString(6, PlanoConta.getInss());
			preparedStatement.setString(7, PlanoConta.getIrpf());
			preparedStatement.setString(8, PlanoConta.getPis());
			preparedStatement.setString(9, PlanoConta.getConta());
			preparedStatement.setString(10, PlanoConta.getAtividade());
			preparedStatement.setBigDecimal(11, PlanoConta.getIcms());
			preparedStatement.setString(12, PlanoConta.getObservacao());
			if (PlanoConta.getGrupodespesa_codigo() != null) {
				preparedStatement.setInt(13, PlanoConta.getGrupodespesa_codigo());
			} else {
				preparedStatement.setNull(13, Types.INTEGER);
			}
			preparedStatement.setString(14, PlanoConta.getCodigo());
			preparedStatement.setInt(15, PlanoConta.getNome());
			preparedStatement.setString(16, PlanoConta.getTipo());
			preparedStatement.setString(17, PlanoConta.getNatureza());
			preparedStatement.setString(18, PlanoConta.getIss());
			preparedStatement.setString(19, PlanoConta.getInss());
			preparedStatement.setString(20, PlanoConta.getIrpf());
			preparedStatement.setString(21, PlanoConta.getPis());
			preparedStatement.setString(22, PlanoConta.getConta());
			preparedStatement.setString(23, PlanoConta.getAtividade());
			preparedStatement.setBigDecimal(24, PlanoConta.getIcms());
			preparedStatement.setString(25, PlanoConta.getObservacao());
			preparedStatement.setInt(26, PlanoConta.getGrupodespesa_codigo());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os planos de contas cadastrados no banco de dados
	public List<PlanoConta> listPlanoContas() {

		ArrayList<PlanoConta> lista = new ArrayList<PlanoConta>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select codigo, nome, tipo, natureza, iss, inss, " + "irpf, pis, conta, atividade, icms, "
					+ "observacao, grupodespesa_codigo from planoconta";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				PlanoConta PlanoConta = new PlanoConta();
				PlanoConta.setCodigo(rs.getString(1));
				PlanoConta.setNome(rs.getInt(2));
				int idGrupo0 = PlanoConta.getNome();
				DespesaReceita despesa = getDespesa(idGrupo0);
				PlanoConta.setDespesa(despesa);
				PlanoConta.setTipo(rs.getString(3));
				PlanoConta.setNatureza(rs.getString(4));
				PlanoConta.setIss(rs.getString(5));
				PlanoConta.setInss(rs.getString(6));
				PlanoConta.setIrpf(rs.getString(7));
				PlanoConta.setPis(rs.getString(8));
				PlanoConta.setConta(rs.getString(9));
				PlanoConta.setAtividade(rs.getString(10));
				PlanoConta.setIcms(rs.getBigDecimal(11));
				PlanoConta.setObservacao(rs.getString(12));
				PlanoConta.setGrupodespesa_codigo(rs.getInt(13));
				int id = PlanoConta.getGrupodespesa_codigo();
				GrupoDespesaReceita grupodespesa = getGrupoDespesa(id);
				PlanoConta.setGrupodespesa(grupodespesa);
				lista.add(PlanoConta);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// Lista o auto complete de plano de contas na página do plano de contas (pelo
	// objeto)
	public List<PlanoConta> listaplano(String nomeDespesa) {

		ArrayList<PlanoConta> lista = new ArrayList<PlanoConta>();

		PreparedStatement preparedStatement;
		ResultSet rs = null;
		String sql = "select * from planoconta p join despesa d on p.nome = d.codigo where d.nome like '%" + nomeDespesa + "%'";

		try {

			preparedStatement = conexao.prepareStatement(sql);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {

				PlanoConta plano = new PlanoConta();
				plano.setCodigo(rs.getString("codigo"));
				plano.setNome(rs.getInt("nome"));
				int idGrup = plano.getNome();
				DespesaReceita desp = getDespesa(idGrup);
				plano.setDespesa(desp);
				plano.setTipo(rs.getString("tipo"));
				plano.setNatureza(rs.getString("natureza"));
				plano.setIss(rs.getString("iss"));
				plano.setInss(rs.getString("inss"));
				plano.setIrpf(rs.getString("irpf"));
				plano.setPis(rs.getString("pis"));
				plano.setConta(rs.getString("conta"));
				plano.setAtividade(rs.getString("atividade"));
				plano.setIcms(rs.getBigDecimal("icms"));
				plano.setObservacao(rs.getString("observacao"));
				plano.setGrupodespesa_codigo(rs.getInt("grupodespesa_codigo"));
				lista.add(plano);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// lista todos as despesas cadastradas no banco de dados
	public DespesaReceita getDespesa(int idGrupo) throws SQLException {
		DespesaReceita grupo = new DespesaReceita();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from despesa where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
			grupo.setGrupodespesareceita_codigo(rs.getInt("grupodespesareceita_codigo"));
		}
		return grupo;
	}

	// lista todos os grupo de despesas cadastradas no banco de dados
	public GrupoDespesaReceita getGrupoDespesa(int idGrupo) throws SQLException {
		GrupoDespesaReceita grupo = new GrupoDespesaReceita();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao
				.prepareStatement("select codigo, nomegrupodespesa from grupodespesa where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
		}
		return grupo;
	}

}
