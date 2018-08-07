package br.com.grupoferraz.financeiro.dao;

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

import br.com.grupoferraz.financeiro.entity.Cliente;
import br.com.grupoferraz.financeiro.entity.GrupoCliente;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ClienteDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertCliente(Cliente cliente) {

		try {

			StringBuilder str = new StringBuilder();
			str.append("insert into cliente (nome, cpf, nascimento, descricao, data_cadastro, logradouro, num, com, bairro, cep,"
					+ "cidade, estado, ie, telefone, celular, fax, email, "
					+ "site, contato, codigorec, grupocliente_codigo, codigoac, codigorep, nomefantasia, rg, cpfcp, exterior,  "
					+ "contabil, debito, nf, ident, docidex, insc, codigopais, iseninscr, inss, iss, aliquota, indicadorie) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			str.append("on duplicate key update nome = ?, cpf = ?, nascimento = ?, descricao = ?, data_cadastro = ?, "
					+ "logradouro = ?, num = ?, com = ?, bairro = ?, cep = ?, cidade = ?, estado = ?, ie = ?, "
					+ "telefone = ?, celular = ?, fax = ?, email = ?, site = ?, contato = ?, codigorec = ?, grupocliente_codigo = ?, "
					+ "codigoac = ?, codigorep = ?, nomefantasia = ?, rg = ?, cpfcp = ?, exterior = ?, contabil = ?, "
					+ "debito = ?, nf = ?, ident = ?, docidex = ?, insc = ?, codigopais = ?, iseninscr = ?, "
					+ "inss = ?, iss = ?, aliquota = ?, indicadorie = ?");
			PreparedStatement preparedStatement = conexao.prepareStatement(str.toString());
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			Date dataNascimento = cliente.getNascimento();
			long t = 0;
			if (dataNascimento != null ) {
				t = dataNascimento.getTime();	
			}
			preparedStatement.setDate(3, new java.sql.Date(t));
			preparedStatement.setString(4, "" + cliente.getDescricao());
			preparedStatement.setDate(5, new java.sql.Date(new Date().getTime()));
			preparedStatement.setString(6, cliente.getLogradouro());
			preparedStatement.setString(7, cliente.getNum());
			preparedStatement.setString(8, cliente.getCom());
			preparedStatement.setString(9, cliente.getBairro());
			preparedStatement.setString(10, cliente.getCep());
			preparedStatement.setString(11, cliente.getCidade());
			preparedStatement.setString(12, cliente.getEstado());
			preparedStatement.setString(13, cliente.getIe());
			preparedStatement.setString(14, cliente.getTelefone());
			preparedStatement.setString(15, cliente.getCelular());
			preparedStatement.setString(16, cliente.getFax());
			preparedStatement.setString(17, cliente.getEmail());
			preparedStatement.setString(18, cliente.getSite());
			preparedStatement.setString(19, cliente.getContato());
			preparedStatement.setString(20, cliente.getCodigorec());
			preparedStatement.setInt(21, cliente.getGrupocliente_codigo());
			preparedStatement.setString(22, cliente.getCodigoac());
			preparedStatement.setString(23, cliente.getCodigorep());
			preparedStatement.setString(24, cliente.getNomefantasia());
			preparedStatement.setString(25, cliente.getRg());
			preparedStatement.setString(26, cliente.getCpfcp());
			preparedStatement.setString(27, cliente.getExterior());
			preparedStatement.setString(28, cliente.getContabil());
			preparedStatement.setString(29, cliente.getDebito());
			preparedStatement.setString(30, cliente.getNf());
			preparedStatement.setString(31, cliente.getIdent());
			preparedStatement.setString(32, cliente.getDocidex());
			preparedStatement.setString(33, cliente.getInsc());
			preparedStatement.setString(34, cliente.getCodigopais());
			preparedStatement.setString(35, cliente.getIseninscr());
			preparedStatement.setString(36, cliente.getInss());
			preparedStatement.setString(37, cliente.getIss());
			preparedStatement.setBigDecimal(38, cliente.getAliquota());
			preparedStatement.setString(39, cliente.getIndicadorie());
			
			preparedStatement.setString(40, cliente.getNome());
			preparedStatement.setString(41, cliente.getCpf());	
			preparedStatement.setDate(42, new java.sql.Date(t));
			preparedStatement.setString(43, "" + cliente.getDescricao());
			preparedStatement.setDate(44, new java.sql.Date(new Date().getTime()));
			preparedStatement.setString(45, cliente.getLogradouro());
			preparedStatement.setString(46, cliente.getNum());
			preparedStatement.setString(47, cliente.getCom());
			preparedStatement.setString(48, cliente.getBairro());
			preparedStatement.setString(49, cliente.getCep());
			preparedStatement.setString(50, cliente.getCidade());
			preparedStatement.setString(51, cliente.getEstado());
			preparedStatement.setString(52, cliente.getIe());
			preparedStatement.setString(53, cliente.getTelefone());
			preparedStatement.setString(54, cliente.getCelular());
			preparedStatement.setString(55, cliente.getFax());
			preparedStatement.setString(56, cliente.getEmail());
			preparedStatement.setString(57, cliente.getSite());
			preparedStatement.setString(58, cliente.getContato());
			preparedStatement.setString(59, cliente.getCodigorec());
			preparedStatement.setInt(60, cliente.getGrupocliente_codigo());
			preparedStatement.setString(61, cliente.getCodigoac());
			preparedStatement.setString(62, cliente.getCodigorep());
			preparedStatement.setString(63, cliente.getNomefantasia());
			preparedStatement.setString(64, cliente.getRg());
			preparedStatement.setString(65, cliente.getCpfcp());
			preparedStatement.setString(66, cliente.getExterior());
			preparedStatement.setString(67, cliente.getContabil());
			preparedStatement.setString(68, cliente.getDebito());
			preparedStatement.setString(69, cliente.getNf());
			preparedStatement.setString(70, cliente.getIdent());
			preparedStatement.setString(71, cliente.getDocidex());
			preparedStatement.setString(72, cliente.getInsc());
			preparedStatement.setString(73, cliente.getCodigopais());
			preparedStatement.setString(74, cliente.getIseninscr());
			preparedStatement.setString(75, cliente.getInss());
			preparedStatement.setString(76, cliente.getIss());
			preparedStatement.setBigDecimal(77, cliente.getAliquota());
			preparedStatement.setString(78, cliente.getIndicadorie());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os clientes cadastrados no banco de dados
	public List<Cliente> listClientes() {

		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select nome, cpf, nascimento, descricao," 
			+ "data_cadastro, logradouro, num, com, bairro, cep,"  
			+ "cidade, estado, ie, telefone, celular, fax, email,"  
			+ "site, contato, codigorec, grupocliente_codigo, codigoac, codigorep, nomefantasia, rg, cpfcp, exterior,"  
			+ "contabil, debito, nf, ident, docidex, insc, codigopais, iseninscr, inss, iss, aliquota, indicadorie from cliente ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setNascimento(rs.getDate("nascimento"));
				cliente.setDescricao(rs.getString("descricao"));
				cliente.setDataCadastro(rs.getDate("data_cadastro"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setNum(rs.getString("num"));
				cliente.setCom(rs.getString("com"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCep(rs.getString("cep"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setIe(rs.getString("ie"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setCelular(rs.getString("celular"));
				cliente.setFax(rs.getString("fax"));
				cliente.setEmail(rs.getString("email"));
				cliente.setSite(rs.getString("site"));
				cliente.setContato(rs.getString("contato"));
				cliente.setCodigorec(rs.getString("codigorec"));
				cliente.setGrupocliente_codigo(rs.getInt("grupocliente_codigo"));
				Integer codigo = cliente.getGrupocliente_codigo();
				cliente.setGrupoCliente(getGrupoCliente(codigo)); 
				cliente.setCodigoac(rs.getString("codigoac"));
				cliente.setCodigorep(rs.getString("codigorep"));
				cliente.setNomefantasia(rs.getString("nomefantasia"));
				cliente.setRg(rs.getString("rg"));
				cliente.setCpfcp(rs.getString("cpfcp"));
				cliente.setExterior(rs.getString("exterior"));
				cliente.setContabil(rs.getString("contabil"));
				cliente.setDebito(rs.getString("debito"));
				cliente.setNf(rs.getString("nf"));
				cliente.setIdent(rs.getString("ident"));
				cliente.setDocidex(rs.getString("docidex"));
				cliente.setInsc(rs.getString("insc"));
				cliente.setCodigopais(rs.getString("codigopais"));
				cliente.setIseninscr(rs.getString("iseninscr"));
				cliente.setInss(rs.getString("inss"));
				cliente.setIss(rs.getString("iss"));
				cliente.setAliquota(rs.getBigDecimal("aliquota"));
				cliente.setIndicadorie(rs.getString("indicadorie"));
				lista.add(cliente);
			}
			

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	// Exibe a lista de Grupo de Clientes cadastrados.
	public GrupoCliente getGrupoCliente(Integer codigo) {
		GrupoCliente grupoCliente = new GrupoCliente();
		
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		try {
			preparedStatement = conexao
					.prepareStatement ("select codigo, nome from grupo_cliente where codigo = ?");
			preparedStatement.setInt(1, codigo);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Integer cod = rs.getInt("codigo");
				String nome = rs.getString("nome");
				grupoCliente.setCodigo(cod);
				grupoCliente.setNome(nome);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
							
		
		return grupoCliente;
	}
}
