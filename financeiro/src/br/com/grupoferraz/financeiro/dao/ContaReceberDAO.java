package br.com.grupoferraz.financeiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.grupoferraz.financeiro.entity.CentroResultado;
import br.com.grupoferraz.financeiro.entity.ContaReceber;
import br.com.grupoferraz.financeiro.entity.DespesaReceita;
import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.PlanoConta;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ContaReceberDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertContaReceber(ContaReceber ContaReceber) {
		try {
			StringBuilder str = new StringBuilder();
			str.append(
					"INSERT INTO financeiro.conta_receber (codigo,cliente_cpf,receita_codigo,documento,emissao,valor,observacao,estabelecimento_codigo,centroresultado_codigo, empresa_cnpj, nomereceita)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?,cliente_cpf = ?,receita_codigo = ?,documento = ?,emissao = ?,valor = ?,observacao = ?,estabelecimento_codigo = ?,centroresultado_codigo = ?, empresa_cnpj = ?,nomereceita = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, ContaReceber.getCodigo());
			preparedStatement.setString(2, ContaReceber.getCpf());
			preparedStatement.setString(3, ContaReceber.getReceita_codigo());
			preparedStatement.setInt(4, ContaReceber.getDocumento());
			Date data = ContaReceber.getEmissao();
			long t = 0;
			if (data != null) {
				t = data.getTime();
			}
			preparedStatement.setDate(5, new java.sql.Date(t));
			preparedStatement.setBigDecimal(6, ContaReceber.getValor());
			preparedStatement.setString(7, ContaReceber.getObservacao());
			preparedStatement.setInt(8, ContaReceber.getEstabelecimento_codigo());
			if (ContaReceber.getCentroresultado_codigo() != null) {
				preparedStatement.setInt(9, ContaReceber.getCentroresultado_codigo());
			} else {
				preparedStatement.setNull(9, Types.INTEGER);
			}
			preparedStatement.setString(10, ContaReceber.getEmpresa_cnpj());
			preparedStatement.setString(11, ContaReceber.getNomereceita());

			preparedStatement.setInt(12, ContaReceber.getCodigo());
			preparedStatement.setString(13, ContaReceber.getCpf());
			preparedStatement.setString(14, ContaReceber.getReceita_codigo());
			preparedStatement.setInt(15, ContaReceber.getDocumento());
			preparedStatement.setDate(16, new java.sql.Date(t));
			preparedStatement.setBigDecimal(17, ContaReceber.getValor());
			preparedStatement.setString(18, ContaReceber.getObservacao());
			preparedStatement.setInt(19, ContaReceber.getEstabelecimento_codigo());
			if (ContaReceber.getCentroresultado_codigo() != null) {
				preparedStatement.setInt(20, ContaReceber.getCentroresultado_codigo());
			} else {
				preparedStatement.setNull(20, Types.INTEGER);
			}
			preparedStatement.setString(21, ContaReceber.getEmpresa_cnpj());
			preparedStatement.setString(22, ContaReceber.getNomereceita());

			preparedStatement.execute();

			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todas as contas cadastradas no banco de dados
	public List<ContaReceber> listContasReceber() {

		ArrayList<ContaReceber> lista = new ArrayList<ContaReceber>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from conta_receber ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				ContaReceber contareceber = new ContaReceber();
				contareceber.setCodigo(rs.getInt("codigo"));
				contareceber.setEmpresa_cnpj(rs.getString("empresa_cnpj"));
				String obj = contareceber.getEmpresa_cnpj();
				Empresa empresa = getEmpresa(obj);
				contareceber.setEmpresa(empresa);
				contareceber.setEstabelecimento_codigo(rs.getInt("estabelecimento_codigo"));
				int obj1 = contareceber.getEstabelecimento_codigo();
				Estabelecimento estabelecimento = getEstabelecimento(obj1);
				contareceber.setEstabelecimento(estabelecimento);
				contareceber.setCpf(rs.getString("cliente_cpf"));
				contareceber.setNomereceita(rs.getString("nomereceita"));
				contareceber.setReceita_codigo(rs.getString("receita_codigo"));
				String obj2 = contareceber.getReceita_codigo();
				PlanoConta receita = getPlanoConta(obj2);
				contareceber.setPlanoconta(receita);
				contareceber.setDocumento(rs.getInt("documento"));
				contareceber.setEmissao(rs.getDate("emissao"));
				contareceber.setValor(rs.getBigDecimal("valor"));
				contareceber.setCentroresultado_codigo(rs.getInt("centroresultado_codigo"));
				CentroResultado obj3 = getCentroResultado(contareceber.getCentroresultado_codigo());
				contareceber.setCentroresultado(obj3);
				contareceber.setObservacao(rs.getString("observacao"));
				lista.add(contareceber);
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
				+ "					+ \"inss, irpf, pis, conta, atividade, icms, observacao, grupodespesa_codigo from plano_conta where codigo = ?");
		preparedStatement.setString(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getString("codigo"));
			grupo.setNome(rs.getInt("nome"));
			int idGrup = grupo.getNome();
			DespesaReceita desp = getReceita(idGrup);
			grupo.setDespesa(desp);
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
			grupo.setGrupodespesa_codigo(rs.getInt("grupodespesa_codigo"));
		}
		return grupo;
	}

	// lista todos as despesas/receitas cadastradas no banco de dados
	public DespesaReceita getReceita(int idGrupo) throws SQLException {
		DespesaReceita grupo = new DespesaReceita();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from despesa_receita where codigo = ?");
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

	// exibe os estabelecimentos cadastrados no banco de dados
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

	// exibe os centros de resultados cadastrados no banco de dados
	public CentroResultado getCentroResultado(int idGrupo) throws SQLException {
		CentroResultado grupo = new CentroResultado();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from centro_resultado where codigo = ?");
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
