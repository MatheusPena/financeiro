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
import br.com.grupoferraz.financeiro.util.ConexaoBD;

public class ClientesDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertUsuario(Clientes usuario) {

		// Statement st = null;
		// ResultSet rs = null;

		try {
			// st = con.createStatement();

			PreparedStatement preparedStatement = conexao
					.prepareStatement("insert into usuario (id, nome, cpf, nascimento, descricao,"
							+ "data_cadastro, logradouro, num, com, bairro, cep,"
							+ "cidade, estado, ie, telefone, celular, fax, email, "
							+ "site, contato, codigorec, codigogc, codigoac, codigorep, nomefantasia, rg, cpfcp, exterior,"
							+ "contabil, debito, nf, ident, docidex, insc, codigopais, iseninscr, inss, iss, indicadorie)"
							+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, usuario.getId());
			preparedStatement.setString(2, usuario.getNome());
			preparedStatement.setString(3, usuario.getCpf());
			Date dataNascimento = usuario.getNascimento();
			long t = 0;
			if (dataNascimento != null ) {
				t = dataNascimento.getTime();	
			}
			preparedStatement.setDate(4, new java.sql.Date(t));
			preparedStatement.setString(5, "" + usuario.getDescricao());
			preparedStatement.setDate(6, new java.sql.Date(new Date().getTime()));
			preparedStatement.setString(7, usuario.getLogradouro());
			preparedStatement.setString(8, usuario.getNum());
			preparedStatement.setString(9, usuario.getCom());
			preparedStatement.setString(10, usuario.getBairro());
			preparedStatement.setString(11, usuario.getCep());
			preparedStatement.setString(12, usuario.getCidade());
			preparedStatement.setString(13, usuario.getEstado());
			preparedStatement.setString(14, usuario.getIe());
			preparedStatement.setString(15, usuario.getTelefone());
			preparedStatement.setString(16, usuario.getCelular());
			preparedStatement.setString(17, usuario.getFax());
			preparedStatement.setString(18, usuario.getEmail());
			preparedStatement.setString(19, usuario.getSite());
			preparedStatement.setString(20, usuario.getContato());
			preparedStatement.setString(21, usuario.getCodigorec());
			preparedStatement.setString(22, usuario.getCodigogc());
			preparedStatement.setString(23, usuario.getCodigoac());
			preparedStatement.setString(24, usuario.getCodigorep());
			preparedStatement.setString(25, usuario.getNomefantasia());
			preparedStatement.setString(26, usuario.getRg());
			preparedStatement.setString(27, usuario.getCpfcp());
			preparedStatement.setByte(28, usuario.getExterior());
			preparedStatement.setString(29, usuario.getContabil());
			preparedStatement.setString(30, usuario.getDebito());
			preparedStatement.setString(31, usuario.getNf());
			preparedStatement.setString(32, usuario.getIdent());
			preparedStatement.setString(33, usuario.getDocidex());
			preparedStatement.setString(34, usuario.getInsc());
			preparedStatement.setString(35, usuario.getCodigopais());
			preparedStatement.setString(36, usuario.getIseninscr());
			preparedStatement.setString(37, usuario.getInss());
			preparedStatement.setString(38, usuario.getIss());
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
			String sql = "select id, nome, cpf, nascimento, descricao," 
			+ "data_cadastro, logradouro, num, com, bairro, cep,"  
			+ "cidade, estado, ie, telefone, celular, fax, email,"  
			+ "site, contato, codigorec, codigogc, codigoac, codigorep, nomefantasia, rg, cpfcp, exterior,"  
			+ "contabil, debito, nf, ident, docidex, insc, codigopais, iseninscr, inss, iss, indicadorie from usuario ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Clientes usuario = new Clientes();
				usuario.setId(rs.getInt("id"));
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
				usuario.setCodigogc(rs.getString("codigogc"));
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

}
