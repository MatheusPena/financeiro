package br.com.grupoferraz.financeiro.dao;

import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.GrupoVendedores;
import br.com.grupoferraz.financeiro.entity.Vendedores;
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

public class VendedoresDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertVendedores(Vendedores vendedores) {
		try {
			StringBuilder str = new StringBuilder();
			str.append(
					"INSERT INTO `financeiro`.`vendedores` (`pessoa`,`cpfcnpj`,`nome`,`dtnascimento`,`chave`,"
					+ "`rg`,`emissor`,`sexo`,`estadocivil`,"
					+ "`estabelecimentos_codigo`,`rua`,`cep`,`numero`,`bairro`,`cidade`,`uf`,`complemento`,`email`,`telefone`,"
					+ "`cel1`,`cel2`,`grupovendedores_codigo`,`banco`,`tipoconta`,`agenciabanco`,"
					+ "`digagencia`,`conta`,`digconta`,`data_cadastro`) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			str.append("on duplicate key update pessoa = ?, cpfcnpj = ?, nome = ?, dtnascimento = ?, chave = ?,"
					+ "rg = ?, emissor = ?, sexo = ?, estadocivil = ?, estabelecimentos_codigo = ?, "
					+ "rua = ?, cep = ?, numero = ?, "
					+ "bairro = ?, cidade = ?, uf = ?, complemento = ?, email = ?, telefone = ?, cel1 = ?, cel2 = ?,"
					+ "grupovendedores_codigo = ?, banco = ?, tipoconta = ?, agenciabanco = ?, digagencia = ?,"
					+ "conta = ?, digconta = ?, data_cadastro = ? ");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setString(1, vendedores.getPessoa());
			preparedStatement.setString(2, vendedores.getCpf());
			preparedStatement.setString(3, vendedores.getNome());
			Date data = vendedores.getData();
			long t = 0;
			if (data != null ) {
				t = data.getTime();	
			}
			preparedStatement.setDate(4,new java.sql.Date(t));
			preparedStatement.setString(5, vendedores.getChave());
			preparedStatement.setString(6, vendedores.getRg());
			preparedStatement.setString(7, vendedores.getEmissor());
			preparedStatement.setString(8, vendedores.getSexo());
			preparedStatement.setString(9, vendedores.getEstado_civil());
			preparedStatement.setInt(10, vendedores.getEstabelecimentos_codigo());
			preparedStatement.setString(11, vendedores.getRua());
			preparedStatement.setString(12, vendedores.getCep());
			preparedStatement.setInt(13, vendedores.getNumero());
			preparedStatement.setString(14, vendedores.getBairro());
			preparedStatement.setString(15, vendedores.getCidade());
			preparedStatement.setString(16, vendedores.getUf());
			preparedStatement.setString(17, vendedores.getComplemento());
			preparedStatement.setString(18, vendedores.getEmail());
			preparedStatement.setString(19, vendedores.getTelefone());
			preparedStatement.setString(20, vendedores.getCel1());
			preparedStatement.setString(21, vendedores.getCel2());
			preparedStatement.setInt(22, vendedores.getGrupovendedores_codigo());
			preparedStatement.setString(23, vendedores.getBanco());
			preparedStatement.setString(24, vendedores.getTipo_conta());
			preparedStatement.setInt(25, vendedores.getAgenciabanco());
			preparedStatement.setInt(26, vendedores.getDigagencia());
			preparedStatement.setInt(27, vendedores.getConta());
			preparedStatement.setInt(28, vendedores.getDigconta());
			preparedStatement.setDate(29, new java.sql.Date(new Date().getTime()));
			
			preparedStatement.setString(30, vendedores.getPessoa());
			preparedStatement.setString(31, vendedores.getCpf());
			preparedStatement.setString(32, vendedores.getNome());
			preparedStatement.setDate(33,new java.sql.Date(t));
			preparedStatement.setString(34, vendedores.getChave());
			preparedStatement.setString(35, vendedores.getRg());
			preparedStatement.setString(36, vendedores.getEmissor());
			preparedStatement.setString(37, vendedores.getSexo());
			preparedStatement.setString(38, vendedores.getEstado_civil());
			preparedStatement.setInt(39, vendedores.getEstabelecimentos_codigo());
			preparedStatement.setString(40, vendedores.getRua());
			preparedStatement.setString(41, vendedores.getCep());
			preparedStatement.setInt(42, vendedores.getNumero());
			preparedStatement.setString(43, vendedores.getBairro());
			preparedStatement.setString(44, vendedores.getCidade());
			preparedStatement.setString(45, vendedores.getUf());
			preparedStatement.setString(46, vendedores.getComplemento());
			preparedStatement.setString(47, vendedores.getEmail());
			preparedStatement.setString(48, vendedores.getTelefone());
			preparedStatement.setString(49, vendedores.getCel1());
			preparedStatement.setString(50, vendedores.getCel2());
			preparedStatement.setInt(51, vendedores.getGrupovendedores_codigo());
			preparedStatement.setString(52, vendedores.getBanco());
			preparedStatement.setString(53, vendedores.getTipo_conta());
			preparedStatement.setInt(54, vendedores.getAgenciabanco());
			preparedStatement.setInt(55, vendedores.getDigagencia());
			preparedStatement.setInt(56, vendedores.getConta());
			preparedStatement.setInt(57, vendedores.getDigconta());
			preparedStatement.setDate(58, new java.sql.Date(new Date().getTime()));
			
			preparedStatement.execute();
			
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os vendedoress cadastrados no banco de dados
	public List<Vendedores> listVendedores() {

		ArrayList<Vendedores> lista = new ArrayList<Vendedores>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select `pessoa`,`cpfcnpj`,`nome`,`dtnascimento`,`chave`,`rg`,`emissor`,`sexo`,`estadocivil`, "
					+ "`estabelecimentos_codigo`,`rua`,`cep`,`numero`,`bairro`,`cidade`,`uf`,`complemento`,`email`,`telefone`," 
					+ "`cel1`,`cel2`,`grupovendedores_codigo`,`banco`,`tipoconta`,`agenciabanco`,"
					+ "`digagencia`,`conta`,`digconta`,`data_cadastro`   from vendedores ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Vendedores vendedores = new Vendedores();
				vendedores.setPessoa(rs.getString("pessoa"));
				vendedores.setCpf(rs.getString("cpfcnpj"));
				vendedores.setNome(rs.getString("nome"));
				vendedores.setData(rs.getDate("dtnascimento"));
				vendedores.setChave(rs.getString("chave"));
				vendedores.setRg(rs.getString("rg"));
				vendedores.setEmissor(rs.getString("emissor"));
				vendedores.setSexo(rs.getString("sexo"));
				vendedores.setEstado_civil(rs.getString("estadocivil"));
				vendedores.setEstabelecimentos_codigo(rs.getInt("estabelecimentos_codigo"));
				Estabelecimento obj2 = getEstabelecimento(vendedores.getEstabelecimentos_codigo());
				vendedores.setEstabelecimento(obj2);
				vendedores.setRua(rs.getString("rua"));
				vendedores.setCep(rs.getString("cep"));
				vendedores.setNumero(rs.getInt("numero"));
				vendedores.setBairro(rs.getString("bairro"));
				vendedores.setCidade(rs.getString("cidade"));
				vendedores.setUf(rs.getString("uf"));
				vendedores.setComplemento(rs.getString("complemento"));
				vendedores.setEmail(rs.getString("email"));
				vendedores.setTelefone(rs.getString("telefone"));
				vendedores.setCel1(rs.getString("cel1"));
				vendedores.setCel2(rs.getString("cel2"));
				vendedores.setGrupovendedores_codigo(rs.getInt("grupovendedores_codigo"));
				GrupoVendedores obj = getGrupoVendedor(vendedores.getGrupovendedores_codigo());
				vendedores.setGrupovendedores(obj);
				vendedores.setBanco(rs.getString("banco"));
				vendedores.setTipo_conta(rs.getString("tipoconta"));
				vendedores.setAgenciabanco(rs.getInt("agenciabanco"));
				vendedores.setDigagencia(rs.getInt("digagencia"));
				vendedores.setConta(rs.getInt("conta"));
				vendedores.setDigconta(rs.getInt("digconta"));
				vendedores.setDataCadastro(rs.getDate("data_cadastro"));
				
				
				lista.add(vendedores);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	//Exibe o nome do grupo em vez do código na tela
	public GrupoVendedores getGrupoVendedor(int idGrupo) throws SQLException {
		GrupoVendedores grupo = new GrupoVendedores();
		PreparedStatement preparedStatement;
		ResultSet rs = null;
			preparedStatement = conexao
					.prepareStatement ("select codigo, nomegrupovendedores from grupovendedores where codigo = ?");
			preparedStatement.setInt(1, idGrupo);
			rs = preparedStatement.executeQuery();

		while (rs.next()) {
			grupo.setCodigo(rs.getInt("codigo"));
			grupo.setNomegrupovendedores(rs.getString("nomegrupovendedores"));
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
}
