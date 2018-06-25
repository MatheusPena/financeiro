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
<<<<<<< Upstream, based on branch 'master' of https://github.com/MatheusPena/financeiro.git
			StringBuilder str = new StringBuilder();
			str.append("insert into vendedores (`pessoa`,`cpfcnpj`,`nome`,`dtnascimento`,`chave`,`rg`,`emissor`,"
					+ "`sexo`,`estadocivil`,`agencia`,`rua`,`cep`,`numero`,`bairro`,`cidade`,`uf`,`complemento`,"
					+ "`email`,`telefone`,`cel1`,`cel2`,`grupovendedores_codigo`,`banco`,`tipoconta`,`agenciabanco`,"
=======
			PreparedStatement ps = conexao.prepareCall(
					"INSERT INTO `financeiro`.`vendedores` (`pessoa`,`cpfcnpj`,`nome`,`dtnascimento`,`chave`,`rg`,`emissor`,`sexo`,`estadocivil`,"
					+ "`estabelecimentos_codigo`,`rua`,`cep`,`numero`,`bairro`,`cidade`,`uf`,`complemento`,`email`,`telefone`,"
					+ "`cel1`,`cel2`,`grupovendedores_codigo`,`banco`,`tipoconta`,`agenciabanco`,"
>>>>>>> 74f08fe Opcao editar, criacao da page rateio e modificacao da classe cliente
					+ "`digagencia`,`conta`,`digconta`,`data_cadastro`) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			str.append("on duplicate key update pessoa = ?, cpfcnpj = ?, nome = ?, dtnascimento = ?, chave = ?,"
					+ "rg = ?, emissor = ?, sexo = ?, estadocivil = ?, agencia = ?, rua = ?, cep = ?, numero = ?, "
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
<<<<<<< Upstream, based on branch 'master' of https://github.com/MatheusPena/financeiro.git
			preparedStatement.setDate(4,new java.sql.Date(t));
			preparedStatement.setString(5, vendedores.getChave());
			preparedStatement.setString(6, vendedores.getRg());
			preparedStatement.setString(7, vendedores.getEmissor());
			preparedStatement.setString(8, vendedores.getSexo());
			preparedStatement.setString(9, vendedores.getEstado_civil());
			preparedStatement.setString(10, vendedores.getAgencia());
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
=======
			ps.setDate(4,new java.sql.Date(t));
			ps.setString(5, vendedores.getChave());
			ps.setString(6, vendedores.getRg());
			ps.setString(7, vendedores.getEmissor());
			ps.setString(8, vendedores.getSexo());
			ps.setString(9, vendedores.getEstado_civil());
			ps.setInt(10, vendedores.getEstabelecimentos_codigo());
			ps.setString(11, vendedores.getRua());
			ps.setString(12, vendedores.getCep());
			ps.setInt(13, vendedores.getNumero());
			ps.setString(14, vendedores.getBairro());
			ps.setString(15, vendedores.getCidade());
			ps.setString(16, vendedores.getUf());
			ps.setString(17, vendedores.getComplemento());
			ps.setString(18, vendedores.getEmail());
			ps.setString(19, vendedores.getTelefone());
			ps.setString(20, vendedores.getCel1());
			ps.setString(21, vendedores.getCel2());
			ps.setInt(22, vendedores.getGrupovendedores_codigo());
			ps.setString(23, vendedores.getBanco());
			ps.setString(24, vendedores.getTipo_conta());
			ps.setInt(25, vendedores.getAgenciabanco());
			ps.setInt(26, vendedores.getDigagencia());
			ps.setInt(27, vendedores.getConta());
			ps.setInt(28, vendedores.getDigconta());
			ps.setDate(29, new java.sql.Date(new Date().getTime()));
			ps.execute();
			return true;
>>>>>>> 74f08fe Opcao editar, criacao da page rateio e modificacao da classe cliente
			
			preparedStatement.setString(30, vendedores.getPessoa());
			preparedStatement.setString(31, vendedores.getCpf());
			preparedStatement.setString(32, vendedores.getNome());
			preparedStatement.setDate(33,new java.sql.Date(t));
			preparedStatement.setString(34, vendedores.getChave());
			preparedStatement.setString(35, vendedores.getRg());
			preparedStatement.setString(36, vendedores.getEmissor());
			preparedStatement.setString(37, vendedores.getSexo());
			preparedStatement.setString(38, vendedores.getEstado_civil());
			preparedStatement.setString(39, vendedores.getAgencia());
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
			String sql = "select * from vendedores ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Vendedores vendedores = new Vendedores();
				vendedores.setPessoa(rs.getString(1));
				vendedores.setCpf(rs.getString(2));
				vendedores.setNome(rs.getString(3));
				vendedores.setData(rs.getDate(4));
				vendedores.setChave(rs.getString(5));
				vendedores.setRg(rs.getString(6));
				vendedores.setEmissor(rs.getString(7));
				vendedores.setSexo(rs.getString(8));
				vendedores.setEstado_civil(rs.getString(9));
				vendedores.setRua(rs.getString(10));
				vendedores.setCep(rs.getString(11));
				vendedores.setNumero(rs.getInt(12));
				vendedores.setBairro(rs.getString(13));
				vendedores.setCidade(rs.getString(14));
				vendedores.setUf(rs.getString(15));
				vendedores.setComplemento(rs.getString(16));
				vendedores.setEmail(rs.getString(17));
				vendedores.setTelefone(rs.getString(18));
				vendedores.setCel1(rs.getString(19));
				vendedores.setCel2(rs.getString(20));
				vendedores.setBanco(rs.getString(21));
				vendedores.setTipo_conta(rs.getString(22));
				vendedores.setAgenciabanco(rs.getInt(23));
				vendedores.setDigagencia(rs.getInt(24));
				vendedores.setConta(rs.getInt(25));
				vendedores.setDigconta(rs.getInt(26));
				vendedores.setDataCadastro(rs.getDate(27));
				vendedores.setGrupovendedores_codigo(rs.getInt(28));
				GrupoVendedores obj = getGrupoVendedor(vendedores.getGrupovendedores_codigo());
				vendedores.setGrupovendedores(obj);
				vendedores.setEstabelecimentos_codigo(rs.getInt(29));
				Estabelecimento obj2 = getEstabelecimento(vendedores.getEstabelecimentos_codigo());
				vendedores.setEstabelecimento(obj2);
				lista.add(vendedores);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
	
<<<<<<< Upstream, based on branch 'master' of https://github.com/MatheusPena/financeiro.git
	
=======
	//Exibe o nome do grupo em vez do código na tela
>>>>>>> 74f08fe Opcao editar, criacao da page rateio e modificacao da classe cliente
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
