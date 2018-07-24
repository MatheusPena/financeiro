package br.com.grupoferraz.financeiro.dao;

import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.Empresa;
import br.com.grupoferraz.financeiro.entity.GrupoVendedor;
import br.com.grupoferraz.financeiro.entity.Vendedor;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendedorDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertVendedor(Vendedor vendedor) {
		try {
			StringBuilder str = new StringBuilder();
			str.append("INSERT INTO financeiro.vendedor (pessoa,cpfcnpj,nome,dtnascimento,chave,"
					+ "rg,emissor,sexo,estadocivil,rua,cep,numero,bairro,cidade,uf,complemento,email,telefone,"
					+ "cel1,cel2,banco,tipoconta,agenciabanco,"
					+ "digagencia,conta,digconta,data_cadastro, grupovendedor_codigo, estabelecimento_codigo, empresas_cnpj) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			str.append("on duplicate key update pessoa = ?, cpfcnpj = ?, nome = ?, dtnascimento = ?, chave = ?,"
					+ "rg = ?, emissor = ?, sexo = ?, estadocivil = ?, " + "rua = ?, cep = ?, numero = ?, "
					+ "bairro = ?, cidade = ?, uf = ?, complemento = ?, email = ?, telefone = ?, cel1 = ?, cel2 = ?,"
					+ "banco = ?, tipoconta = ?, agenciabanco = ?, digagencia = ?,"
					+ "conta = ?, digconta = ?, data_cadastro = ?, grupovendedor_codigo = ?, estabelecimento_codigo = ?, empresas_cnpj = ? ");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setString(1, vendedor.getPessoa());
			preparedStatement.setString(2, vendedor.getCpf());
			preparedStatement.setString(3, vendedor.getNome());
			Date data = vendedor.getData();
			long t = 0;
			if (data != null) {
				t = data.getTime();
			}
			preparedStatement.setDate(4, new java.sql.Date(t));
			preparedStatement.setString(5, vendedor.getChave());
			preparedStatement.setString(6, vendedor.getRg());
			preparedStatement.setString(7, vendedor.getEmissor());
			preparedStatement.setString(8, vendedor.getSexo());
			preparedStatement.setString(9, vendedor.getEstado_civil());
			preparedStatement.setString(10, vendedor.getRua());
			preparedStatement.setString(11, vendedor.getCep());
			preparedStatement.setInt(12, vendedor.getNumero());
			preparedStatement.setString(13, vendedor.getBairro());
			preparedStatement.setString(14, vendedor.getCidade());
			preparedStatement.setString(15, vendedor.getUf());
			preparedStatement.setString(16, vendedor.getComplemento());
			preparedStatement.setString(17, vendedor.getEmail());
			preparedStatement.setString(18, vendedor.getTelefone());
			preparedStatement.setString(19, vendedor.getCel1());
			preparedStatement.setString(20, vendedor.getCel2());
			preparedStatement.setString(21, vendedor.getBanco());
			preparedStatement.setString(22, vendedor.getTipo_conta());
			preparedStatement.setInt(23, vendedor.getAgenciabanco());
			preparedStatement.setInt(24, vendedor.getDigagencia());
			preparedStatement.setInt(25, vendedor.getConta());
			preparedStatement.setInt(26, vendedor.getDigconta());
			preparedStatement.setDate(27, new java.sql.Date(new Date().getTime()));
			preparedStatement.setInt(28, vendedor.getGrupovendedor_codigo());
			preparedStatement.setInt(29, vendedor.getEstabelecimento_codigo());
			preparedStatement.setString(30, vendedor.getEmpresa_cnpj());

			preparedStatement.setString(31, vendedor.getPessoa());
			preparedStatement.setString(32, vendedor.getCpf());
			preparedStatement.setString(33, vendedor.getNome());
			preparedStatement.setDate(34, new java.sql.Date(t));
			preparedStatement.setString(35, vendedor.getChave());
			preparedStatement.setString(36, vendedor.getRg());
			preparedStatement.setString(37, vendedor.getEmissor());
			preparedStatement.setString(38, vendedor.getSexo());
			preparedStatement.setString(39, vendedor.getEstado_civil());
			preparedStatement.setString(40, vendedor.getRua());
			preparedStatement.setString(41, vendedor.getCep());
			preparedStatement.setInt(42, vendedor.getNumero());
			preparedStatement.setString(43, vendedor.getBairro());
			preparedStatement.setString(44, vendedor.getCidade());
			preparedStatement.setString(45, vendedor.getUf());
			preparedStatement.setString(46, vendedor.getComplemento());
			preparedStatement.setString(47, vendedor.getEmail());
			preparedStatement.setString(48, vendedor.getTelefone());
			preparedStatement.setString(49, vendedor.getCel1());
			preparedStatement.setString(50, vendedor.getCel2());
			preparedStatement.setString(51, vendedor.getBanco());
			preparedStatement.setString(52, vendedor.getTipo_conta());
			preparedStatement.setInt(53, vendedor.getAgenciabanco());
			preparedStatement.setInt(54, vendedor.getDigagencia());
			preparedStatement.setInt(55, vendedor.getConta());
			preparedStatement.setInt(56, vendedor.getDigconta());
			preparedStatement.setDate(57, new java.sql.Date(new Date().getTime()));
			preparedStatement.setInt(58, vendedor.getGrupovendedor_codigo());
			preparedStatement.setInt(59, vendedor.getEstabelecimento_codigo());
			preparedStatement.setString(60, vendedor.getEmpresa_cnpj());

			preparedStatement.execute();

			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os vendedores cadastrados no banco de dados
	public List<Vendedor> listvendedor() {

		ArrayList<Vendedor> lista = new ArrayList<Vendedor>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select * from vendedor";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Vendedor vendedor = new Vendedor();
				vendedor.setPessoa(rs.getString("pessoa"));
				vendedor.setCpf(rs.getString("cpfcnpj"));
				vendedor.setNome(rs.getString("nome"));
				vendedor.setData(rs.getDate("dtnascimento"));
				vendedor.setChave(rs.getString("chave"));
				vendedor.setRg(rs.getString("rg"));
				vendedor.setEmissor(rs.getString("emissor"));
				vendedor.setSexo(rs.getString("sexo"));
				vendedor.setEstado_civil(rs.getString("estadocivil"));
				vendedor.setEmpresa_cnpj(rs.getString("empresas_cnpj"));
				Empresa emp = getEmpresa(vendedor.getEmpresa_cnpj());
				vendedor.setEmpresa(emp);
				vendedor.setEstabelecimento_codigo(rs.getInt("estabelecimentos_codigo"));
				Estabelecimento obj2 = getEstabelecimento(vendedor.getEstabelecimento_codigo());
				vendedor.setEstabelecimento(obj2);
				vendedor.setRua(rs.getString("rua"));
				vendedor.setCep(rs.getString("cep"));
				vendedor.setNumero(rs.getInt("numero"));
				vendedor.setBairro(rs.getString("bairro"));
				vendedor.setCidade(rs.getString("cidade"));
				vendedor.setUf(rs.getString("uf"));
				vendedor.setComplemento(rs.getString("complemento"));
				vendedor.setEmail(rs.getString("email"));
				vendedor.setTelefone(rs.getString("telefone"));
				vendedor.setCel1(rs.getString("cel1"));
				vendedor.setCel2(rs.getString("cel2"));
				vendedor.setGrupovendedor_codigo(rs.getInt("grupovendedor_codigo"));
				GrupoVendedor obj = getGrupoVendedor(vendedor.getGrupovendedor_codigo());
				vendedor.setGrupovendedor(obj);
				vendedor.setBanco(rs.getString("banco"));
				vendedor.setTipo_conta(rs.getString("tipoconta"));
				vendedor.setAgenciabanco(rs.getInt("agenciabanco"));
				vendedor.setDigagencia(rs.getInt("digagencia"));
				vendedor.setConta(rs.getInt("conta"));
				vendedor.setDigconta(rs.getInt("digconta"));
				vendedor.setDataCadastro(rs.getDate("data_cadastro"));

				lista.add(vendedor);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
	// Exibe o nome do grupo dos vendedores em vez do código na tela
	public GrupoVendedor getGrupoVendedor(int idGrupo) throws SQLException {
		GrupoVendedor grupo = new GrupoVendedor();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao
				.prepareStatement("select codigo, nomegrupovendedor from grupovendedor where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNomegrupovendedores(rs.getString("nomegrupovendedor"));
		}
		return grupo;
	}

	// Exibe o nome da empresa em vez do cnpj na tela
	public Empresa getEmpresa(String idEmpresa) throws SQLException {
		Empresa empresa = new Empresa();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		preparedStatement = conexao.prepareStatement("select cnpj, nome from empresas where cnpj = ?");
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
		preparedStatement = conexao.prepareStatement("select * from estabelecimentos where codigo = ?");
		preparedStatement.setInt(1, idGrupo);
		rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNome(rs.getString("nome"));
			grupo.setGrupoestabelecimento_codigo(rs.getInt("grupoestabelecimento_codigo"));
		}
		return grupo;
	}
}
