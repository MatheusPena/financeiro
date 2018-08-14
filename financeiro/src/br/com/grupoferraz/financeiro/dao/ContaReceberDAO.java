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
import br.com.grupoferraz.financeiro.entity.VencimentoChequeCR;
import br.com.grupoferraz.financeiro.entity.VencimentoDiversoCR;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ContaReceberDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertContaReceber(ContaReceber ContaReceber) {
		try {
			StringBuilder str = new StringBuilder();
			str.append(
					"INSERT INTO financeiro.conta_receber (codigo,cliente_cpf,documento,emissao,valor,observacao,estabelecimento_codigo,centroresultado_codigo, empresa_cnpj, receita_codigo, nome)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			str.append(
					"on duplicate key update codigo = ?,cliente_cpf = ?,documento = ?,emissao = ?,valor = ?,observacao = ?,estabelecimento_codigo = ?,centroresultado_codigo = ?, empresa_cnpj = ?, receita_codigo = ?, nome = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setInt(1, ContaReceber.getCodigo());
			preparedStatement.setString(2, ContaReceber.getCpf());
			preparedStatement.setInt(3, ContaReceber.getDocumento());
			Date data = ContaReceber.getEmissao();
			long t = 0;
			if (data != null) {
				t = data.getTime();
			}
			preparedStatement.setDate(4, new java.sql.Date(t));
			preparedStatement.setBigDecimal(5, ContaReceber.getValor());
			preparedStatement.setString(6, ContaReceber.getObservacao());
			preparedStatement.setInt(7, ContaReceber.getEstabelecimento_codigo());
			if (ContaReceber.getCentroresultado_codigo() != null) {
				preparedStatement.setInt(8, ContaReceber.getCentroresultado_codigo());
			} else {
				preparedStatement.setNull(8, Types.INTEGER);
			}
			preparedStatement.setString(9, ContaReceber.getEmpresa_cnpj());
			if (ContaReceber.getReceita_codigo() != null) {
				preparedStatement.setString(10, ContaReceber.getReceita_codigo());
			} else {
				preparedStatement.setString(10, null);
			}
			preparedStatement.setString(11, ContaReceber.getNome());

			preparedStatement.setInt(12, ContaReceber.getCodigo());
			preparedStatement.setString(13, ContaReceber.getCpf());
			preparedStatement.setInt(14, ContaReceber.getDocumento());
			preparedStatement.setDate(15, new java.sql.Date(t));
			preparedStatement.setBigDecimal(16, ContaReceber.getValor());
			preparedStatement.setString(17, ContaReceber.getObservacao());
			preparedStatement.setInt(18, ContaReceber.getEstabelecimento_codigo());
			if (ContaReceber.getCentroresultado_codigo() != null) {
				preparedStatement.setInt(19, ContaReceber.getCentroresultado_codigo());
			} else {
				preparedStatement.setNull(19, Types.INTEGER);
			}
			preparedStatement.setString(20, ContaReceber.getEmpresa_cnpj());
			if (ContaReceber.getReceita_codigo() != null) {
				preparedStatement.setString(21, ContaReceber.getReceita_codigo());
			} else {
				preparedStatement.setString(21, null);
			}
			preparedStatement.setString(22, ContaReceber.getNome());

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
			String sql = "select * from conta_receber";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				ContaReceber contareceber = new ContaReceber();
				contareceber.setCodigo(rs.getInt("codigo"));
				contareceber.setNome(rs.getString("nome"));
				contareceber.setEmpresa_cnpj(rs.getString("empresa_cnpj"));
				String obj = contareceber.getEmpresa_cnpj();
				Empresa empresa = getEmpresa(obj);
				contareceber.setEmpresa(empresa);
				contareceber.setEstabelecimento_codigo(rs.getInt("estabelecimento_codigo"));
				int obj1 = contareceber.getEstabelecimento_codigo();
				Estabelecimento estabelecimento = getEstabelecimento(obj1);
				contareceber.setEstabelecimento(estabelecimento);
				contareceber.setCpf(rs.getString("cliente_cpf"));
				contareceber.setReceita_codigo(rs.getString("receita_codigo"));
				PlanoConta obj2 = getPlanoConta(contareceber.getReceita_codigo());
				contareceber.setPlanoconta(obj2);
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

	// lista todas as contas cadastradas do autcomplete no banco de dados
	public List<ContaReceber> listContasReceber(String query) {

		ArrayList<ContaReceber> lista = new ArrayList<ContaReceber>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from conta_receber where nome like '%" + query + "%'";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				ContaReceber contareceber = new ContaReceber();
				contareceber.setCodigo(rs.getInt("codigo"));
				contareceber.setNome(rs.getString("nome"));
				contareceber.setEmpresa_cnpj(rs.getString("empresa_cnpj"));
				String obj = contareceber.getEmpresa_cnpj();
				Empresa empresa = getEmpresa(obj);
				contareceber.setEmpresa(empresa);
				contareceber.setEstabelecimento_codigo(rs.getInt("estabelecimento_codigo"));
				int obj1 = contareceber.getEstabelecimento_codigo();
				Estabelecimento estabelecimento = getEstabelecimento(obj1);
				contareceber.setEstabelecimento(estabelecimento);
				contareceber.setCpf(rs.getString("cliente_cpf"));
				contareceber.setReceita_codigo(rs.getString("receita_codigo"));
				PlanoConta obj2 = getPlanoConta(contareceber.getReceita_codigo());
				contareceber.setPlanoconta(obj2);
				contareceber.setDocumento(rs.getInt("documento"));
				contareceber.setEmissao(rs.getDate("emissao"));
				contareceber.setValor(rs.getBigDecimal("valor"));
				contareceber.setCentroresultado_codigo(rs.getInt("centroresultado_codigo"));
				CentroResultado obj3 = getCentroResultado(contareceber.getCentroresultado_codigo());
				contareceber.setCentroresultado(obj3);
				contareceber.setObservacao(rs.getString("observacao"));
				contareceber.setVencimentodiverso(getVencimentoDiverso(contareceber.getCodigo()));
				contareceber.setVencimentocheque(getVencimentoCheque(contareceber.getCodigo()));
				lista.add(contareceber);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// exibe os vencimentos diversos do Contas a Receber
	public VencimentoDiversoCR getVencimentoDiverso(int idGrupo) throws SQLException {
		VencimentoDiversoCR grupo = new VencimentoDiversoCR();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from vencimento_diverso_cr where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setVencimento(rs.getDate("vencimento"));
			grupo.setValor(rs.getBigDecimal("valor"));
			grupo.setDocumento_codigo(rs.getInt("documento_codigo"));
			grupo.setTitulo(rs.getInt("titulo"));
			grupo.setEmpresa_cnpj(rs.getString("empresa_cnpj"));
			grupo.setBoleto(rs.getInt("boleto"));
			grupo.setDesconto(rs.getBigDecimal("desconto"));
		}
		return grupo;
	}

	// exibe os vencimentos cheque do Contas a Receber
	public VencimentoChequeCR getVencimentoCheque(int idGrupo) throws SQLException {
		VencimentoChequeCR grupo = new VencimentoChequeCR();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from vencimento_cheque_cr where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setVencimento(rs.getDate("vencimento"));
			grupo.setValor(rs.getBigDecimal("valor"));
			grupo.setBanco(rs.getString("banco"));
			grupo.setTipoconta(rs.getString("tipoconta"));
			grupo.setAgencia(rs.getInt("agenciabanco"));
			grupo.setDigagencia(rs.getInt("digagencia"));
			grupo.setConta(rs.getInt("conta"));
			grupo.setDigconta(rs.getInt("digconta"));
			grupo.setCheque(rs.getInt("cheque"));
			grupo.setTitular(rs.getString("titular"));
			grupo.setFebraban(rs.getInt("febraban"));
		}
		return grupo;
	}

	// Exibe o nome do plano de contas
	public PlanoConta getPlanoConta(String idGrupo) throws SQLException {
		PlanoConta grupo = new PlanoConta();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select * from plano_conta where codigo = ?");
		preparedStatement.setString(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getString(1));
			grupo.setDespesareceita_codigo(rs.getInt(2));
			int idGrupo0 = grupo.getDespesareceita_codigo();
			DespesaReceita despesareceita = getReceita(idGrupo0);
			grupo.setDespesareceita(despesareceita);
			grupo.setTipo(rs.getString(3));
			grupo.setNatureza(rs.getString(4));
			grupo.setIss(rs.getString(5));
			grupo.setInss(rs.getString(6));
			grupo.setIrpf(rs.getString(7));
			grupo.setPis(rs.getString(8));
			grupo.setConta(rs.getString(9));
			grupo.setAtividade(rs.getString(10));
			grupo.setIcms(rs.getBigDecimal(11));
			grupo.setObservacao(rs.getString(12));
			grupo.setGrupodespesareceita_codigo(rs.getInt(13));
		}
		return grupo;
	}

	// lista todos as despesas cadastradas no banco de dados
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
