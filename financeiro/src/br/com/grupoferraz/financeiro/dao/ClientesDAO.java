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

import br.com.grupoferraz.financeiro.entity.Clientes;
import br.com.grupoferraz.financeiro.entity.GrupoClientes;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ClientesDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertUsuario(Clientes usuario) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();

			PreparedStatement preparedStatement = conexao
					.prepareStatement("insert into clientes (nome, cpf, nascimento, descricao,"
							+ "data_cadastro, logradouro, num, com, bairro, cep,"
							+ "cidade, estado, ie, telefone, celular, fax, email, "
							+ "site, contato, codigorec, grupoclientes_codigo, codigoac, codigorep, nomefantasia, rg, cpfcp, exterior,"
							+ "contabil, debito, nf, ident, docidex, insc, codigopais, iseninscr, inss, iss, aliquota,indicadorie)"
							+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getCpf());
			Date dataNascimento = usuario.getNascimento();
			long t = 0;
			if (dataNascimento != null ) {
				t = dataNascimento.getTime();	
			}
			preparedStatement.setDate(3, new java.sql.Date(t));
			preparedStatement.setString(4, "" + usuario.getDescricao());
			preparedStatement.setDate(5, new java.sql.Date(new Date().getTime()));
			preparedStatement.setString(6, usuario.getLogradouro());
			preparedStatement.setString(7, usuario.getNum());
			preparedStatement.setString(8, usuario.getCom());
			preparedStatement.setString(9, usuario.getBairro());
			preparedStatement.setString(10, usuario.getCep());
			preparedStatement.setString(11, usuario.getCidade());
			preparedStatement.setString(12, usuario.getEstado());
			preparedStatement.setString(13, usuario.getIe());
			preparedStatement.setString(14, usuario.getTelefone());
			preparedStatement.setString(15, usuario.getCelular());
			preparedStatement.setString(16, usuario.getFax());
			preparedStatement.setString(17, usuario.getEmail());
			preparedStatement.setString(18, usuario.getSite());
			preparedStatement.setString(19, usuario.getContato());
			preparedStatement.setString(20, usuario.getCodigorec());
			preparedStatement.setInt(21, usuario.getGrupoclientes_codigo());
			preparedStatement.setString(22, usuario.getCodigoac());
			preparedStatement.setString(23, usuario.getCodigorep());
			preparedStatement.setString(24, usuario.getNomefantasia());
			preparedStatement.setString(25, usuario.getRg());
			preparedStatement.setString(26, usuario.getCpfcp());
			preparedStatement.setByte(27, usuario.getExterior());
			preparedStatement.setString(28, usuario.getContabil());
			preparedStatement.setString(29, usuario.getDebito());
			preparedStatement.setString(30, usuario.getNf());
			preparedStatement.setString(31, usuario.getIdent());
			preparedStatement.setString(32, usuario.getDocidex());
			preparedStatement.setString(33, usuario.getInsc());
			preparedStatement.setString(34, usuario.getCodigopais());
			preparedStatement.setString(35, usuario.getIseninscr());
			preparedStatement.setString(36, usuario.getInss());
			preparedStatement.setString(37, usuario.getIss());
			preparedStatement.setBigDecimal(38, usuario.getAliquota());
			preparedStatement.setString(39, usuario.getIndicadorie());

			preparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		}
	}

	// lista todos os usuarios cadastrados no banco de dados
	public List<Clientes> listUsuarios() {

		ArrayList<Clientes> lista = new ArrayList<Clientes>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conexao.createStatement();
			String sql = "select nome, cpf, nascimento, descricao," 
			+ "data_cadastro, logradouro, num, com, bairro, cep,"  
			+ "cidade, estado, ie, telefone, celular, fax, email,"  
			+ "site, contato, codigorec, grupoclientes_codigo, codigoac, codigorep, nomefantasia, rg, cpfcp, exterior,"  
			+ "contabil, debito, nf, ident, docidex, insc, codigopais, iseninscr, inss, iss, aliquota, indicadorie from clientes ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Clientes usuario = new Clientes();
				usuario.setNome(rs.getString("nome"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setNascimento(rs.getDate("nascimento"));
				usuario.setDescricao(rs.getString("descricao"));
				usuario.setDataCadastro(rs.getDate("data_cadastro"));
				usuario.setLogradouro(rs.getString("logradouro"));
				usuario.setNum(rs.getString("num"));
				usuario.setCom(rs.getString("com"));
				usuario.setBairro(rs.getString("bairro"));
				usuario.setCep(rs.getString("cep"));
				usuario.setCidade(rs.getString("cidade"));
				usuario.setEstado(rs.getString("estado"));
				usuario.setIe(rs.getString("ie"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setCelular(rs.getString("celular"));
				usuario.setFax(rs.getString("fax"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSite(rs.getString("site"));
				usuario.setContato(rs.getString("contato"));
				usuario.setCodigorec(rs.getString("codigorec"));
				usuario.setGrupoclientes_codigo(rs.getInt("grupoclientes_codigo"));
				Integer codigo = usuario.getGrupoclientes_codigo();
				usuario.setGrupoClientes(getGrupoCliente(codigo)); 
				usuario.setCodigoac(rs.getString("codigoac"));
				usuario.setCodigorep(rs.getString("codigorep"));
				usuario.setNomefantasia(rs.getString("nomefantasia"));
				usuario.setRg(rs.getString("rg"));
				usuario.setCpfcp(rs.getString("cpfcp"));
				usuario.setExterior(rs.getByte("exterior"));
				usuario.setContabil(rs.getString("contabil"));
				usuario.setDebito(rs.getString("debito"));
				usuario.setNf(rs.getString("nf"));
				usuario.setIdent(rs.getString("ident"));
				usuario.setDocidex(rs.getString("docidex"));
				usuario.setInsc(rs.getString("insc"));
				usuario.setCodigopais(rs.getString("codigopais"));
				usuario.setIseninscr(rs.getString("iseninscr"));
				usuario.setInss(rs.getString("inss"));
				usuario.setIss(rs.getString("iss"));
				usuario.setAliquota(rs.getBigDecimal("aliquota"));
				usuario.setIndicadorie(rs.getString("indicadorie"));
				lista.add(usuario);
			}
			

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}

	public GrupoClientes getGrupoCliente(Integer codigo) {
		GrupoClientes grupoClientes = new GrupoClientes();
		
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		try {
			preparedStatement = conexao
					.prepareStatement ("select codigo, nome from grupoclientes where codigo = ?");
			preparedStatement.setInt(1, codigo);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Integer cod = rs.getInt("codigo");
				String nome = rs.getString("nome");
				grupoClientes.setCodigo(cod);
				grupoClientes.setNome(nome);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
						
	
		
		
		
		return grupoClientes;
	}
}
