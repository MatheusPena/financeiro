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

import br.com.grupoferraz.financeiro.entity.CentroResultado;
import br.com.grupoferraz.financeiro.entity.DespesaReceita;
import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.PlanoConta;
import br.com.grupoferraz.financeiro.entity.RateioCR;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class RateioCRDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertRateio(RateioCR Rateio) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();
			StringBuilder str = new StringBuilder();
			str.append(
					"insert into rateiocr (codigo, percentual, planoconta_codigo, estabelecimento_codigo, centroresultado_codigo, empresa_cnpj)"
							+ "values (?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?, percentual = ?, planoconta_codigo = ?, estabelecimento_codigo = ?, centroresultado_codigo = ?, empresa_cnpj = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, Rateio.getCodigo());
			preparedStatement.setBigDecimal(2, Rateio.getPercentual());
			preparedStatement.setString(3, Rateio.getPlanoconta_codigo());
			preparedStatement.setInt(4, Rateio.getEstabelecimento_codigo());
			preparedStatement.setInt(5, Rateio.getCentroresultado_codigo());
			preparedStatement.setString(6, Rateio.getEmpresa_cnpj());

			preparedStatement.setInt(7, Rateio.getCodigo());
			preparedStatement.setBigDecimal(8, Rateio.getPercentual());
			preparedStatement.setString(9, Rateio.getPlanoconta_codigo());
			preparedStatement.setInt(10, Rateio.getEstabelecimento_codigo());
			preparedStatement.setInt(11, Rateio.getCentroresultado_codigo());
			preparedStatement.setString(12, Rateio.getEmpresa_cnpj());
			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os rateios cadastrados no banco de dados
	public List<RateioCR> listRateio() {

		ArrayList<RateioCR> lista = new ArrayList<RateioCR>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select *" + "from rateiocr";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				RateioCR Rateio = new RateioCR();
				Rateio.setCodigo(rs.getInt(1));
				Rateio.setPercentual(rs.getBigDecimal(2));
				Rateio.setPlanoconta_codigo(rs.getString(3));
				String idGrupo = Rateio.getPlanoconta_codigo();
				PlanoConta planocontas = getPlanoConta(idGrupo);
				Rateio.setPlanoconta(planocontas);
				Rateio.setEmpresa_cnpj(rs.getString(6));
				Empresa emp = getEmpresa(Rateio.getEmpresa_cnpj());
				Rateio.setEmpresa(emp);
				Rateio.setEstabelecimento_codigo(rs.getInt(4));
				Estabelecimento obj2 = getEstabelecimento(Rateio.getEstabelecimento_codigo());
				Rateio.setEstabelecimento(obj2);
				Rateio.setCentroresultado_codigo(rs.getInt(5));
				CentroResultado obj3 = getCentroResultado(Rateio.getCentroresultado_codigo());
				Rateio.setCentroresultado(obj3);
				lista.add(Rateio);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// Exibe o nome do plano de contas
	public PlanoConta getPlanoConta(String idGrupo) throws SQLException {
		PlanoConta grupo = new PlanoConta();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select codigo, nome, tipo, natureza, iss, \"\r\n"
				+ "					+ \"inss, irpf, pis, conta, atividade, icms, observacao, grupodespesa_codigo from planoconta where codigo = ?");
		preparedStatement.setString(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getString("codigo"));
			grupo.setNome(rs.getInt("nome"));
			int idGrup = grupo.getNome();
			DespesaReceita desp = getDespesa(idGrup);
			grupo.setDespesareceita(desp);
			grupo.setTipo(rs.getString("tipo"));
			grupo.setNatureza(rs.getString("natureza"));
			grupo.setInss(rs.getString("iss"));
			grupo.setInss(rs.getString("inss"));
			grupo.setIrpf(rs.getString("irpf"));
			grupo.setPis(rs.getString("pis"));
			grupo.setConta(rs.getString("conta"));
			grupo.setAtividade(rs.getString("atividade"));
			grupo.setIcms(rs.getBigDecimal("icms"));
			grupo.setObservacao(rs.getString("observacao"));
			grupo.setGrupodespesareceita_codigo(rs.getInt("grupodespesareceita_codigo"));
		}
		return grupo;
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

	// Exibe o nome da empresa em vez do cnpj na tela
	public Empresa getEmpresa(String idEmpresa) throws SQLException {
		Empresa empresa = new Empresa();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select cnpj, nome from empresa where cnpj = ?");
		preparedStatement.setString(1, idEmpresa);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			empresa.setCnpj(rs.getString("cnpj"));
			empresa.setNome(rs.getString("nome"));
		}
		return empresa;
	}

	// Exibe o nome da agência em vez do código na tela
	public Estabelecimento getEstabelecimento(int idGrupo) throws SQLException {
		Estabelecimento grupo = new Estabelecimento();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from estabelecimento where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
			grupo.setGrupoestabelecimento_codigo(rs.getInt("grupoestabelecimento_codigo"));
		}
		return grupo;
	}

	// Exibe o centro de resultados
	public CentroResultado getCentroResultado(int idGrupo) throws SQLException {
		CentroResultado grupo = new CentroResultado();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from centroresultado where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
			grupo.setAtividade(rs.getString("atividade"));
			grupo.setPeso(rs.getBigDecimal("peso"));
			grupo.setGrupocentroresultado_codigo(rs.getInt("grupocentroresultado_codigo"));
		}
		return grupo;
	}
}
