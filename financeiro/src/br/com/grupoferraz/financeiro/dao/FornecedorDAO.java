package br.com.grupoferraz.financeiro.dao;

import br.com.grupoferraz.financeiro.entity.DespesaReceita;
import br.com.grupoferraz.financeiro.entity.Fornecedor;
import br.com.grupoferraz.financeiro.entity.GrupoFornecedor;
import br.com.grupoferraz.financeiro.util.ConexaoBD;
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

public class FornecedorDAO {
	Connection conexao = ConexaoBD.getConexao();

	public boolean insertFornecedores(Fornecedor fornecedores) {
		
		try {
			StringBuilder str = new StringBuilder();
			str.append("insert into fornecedor (nome, cpf, dtnascimento,"
					+ "logradouro, num, com, bairro, cep, "
					+ "cidade, estado, ie, telefone, celular, fax, email, "
					+ "site, contato, codigodes, nomedes, grupofornecedor_codigo,  rg,"
					+ "contabil, banco, tipoconta, agenciabanco, digagencia, conta, "
					+ "digconta, nomefantasia, febraban, inscmunicipio,"
					+ "prestadorserv, icms, ipi, codigopais, inss, aliquota, docidex, descricao, data_cadastro)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			str.append("on duplicate key update nome = ?, cpf = ?, dtnascimento = ?, "
					+ "logradouro = ?, num = ?, com = ?, bairro = ?, cep = ?, cidade = ?, estado = ?, ie = ?, "
					+ "telefone = ?, celular = ?, fax = ?, email = ?,  site = ?, contato = ?, codigodes = ?, nomedes = ?, "
					+ "grupofornecedor_codigo = ?, rg = ?, contabil = ?, banco = ?, tipoconta = ?, agenciabanco = ?, "
					+ "digagencia = ?, conta = ?, digconta = ?, nomefantasia = ?, "
					+ "febraban = ?, inscmunicipio = ?, prestadorserv = ?, "
					+ "icms = ?, ipi = ?, codigopais = ?, inss = ?, aliquota = ?, docidex = ?, descricao = ?, data_cadastro = ?");
			
			PreparedStatement PreparedStatement = conexao.prepareStatement(str.toString());
			PreparedStatement.setString(1, fornecedores.getNome());
			PreparedStatement.setString(2, fornecedores.getCpf());
			Date dataNascimento = fornecedores.getDtnascimento();
			long t = 0;
			if (dataNascimento != null ) {
				t = dataNascimento.getTime();	
				PreparedStatement.setDate(3, new java.sql.Date(t));
			}
			PreparedStatement.setString(4, fornecedores.getLogradouro());
			PreparedStatement.setString(5, fornecedores.getNum());
			PreparedStatement.setString(6, fornecedores.getCom());
			PreparedStatement.setString(7, fornecedores.getBairro());
			PreparedStatement.setString(8, fornecedores.getCep());
			PreparedStatement.setString(9, fornecedores.getCidade());
			PreparedStatement.setString(10, fornecedores.getEstado());
			PreparedStatement.setString(11, fornecedores.getIe());
			PreparedStatement.setString(12, fornecedores.getTelefone());
			PreparedStatement.setString(13, fornecedores.getCelular());
			PreparedStatement.setString(14, fornecedores.getFax());
			PreparedStatement.setString(15, fornecedores.getEmail());
			PreparedStatement.setString(16, fornecedores.getSite());
			PreparedStatement.setString(17, fornecedores.getContato());
			Integer despesaCodigo = fornecedores.getCodigodes();
			if (despesaCodigo != null) {
				PreparedStatement.setInt(18, despesaCodigo);
			}
			else {
				PreparedStatement.setNull(18, Types.INTEGER);
			}
			PreparedStatement.setString(19, fornecedores.getNomedes());
			PreparedStatement.setInt(20, fornecedores.getGrupofornecedor_codigo());
			PreparedStatement.setString(21, fornecedores.getRg());
			PreparedStatement.setString(22, fornecedores.getContabil());
			PreparedStatement.setString(23, fornecedores.getBanco());
			PreparedStatement.setString(24, fornecedores.getTipoconta());
			PreparedStatement.setInt(25, fornecedores.getAgenciabanco());
			PreparedStatement.setInt(26, fornecedores.getDigagencia());
			PreparedStatement.setInt(27, fornecedores.getConta());
			PreparedStatement.setInt(28, fornecedores.getDigconta());
			PreparedStatement.setString(29, fornecedores.getNomefantasia());
			PreparedStatement.setInt(30, fornecedores.getFebraban());
			PreparedStatement.setInt(31, fornecedores.getInscmunicipio());
			PreparedStatement.setString(32, fornecedores.getPrestadorserv());
			PreparedStatement.setString(33, fornecedores.getIcms());
			PreparedStatement.setString(34, fornecedores.getIpi());
			PreparedStatement.setInt(35, fornecedores.getCodigopais());
			PreparedStatement.setString(36, fornecedores.getInss());
			PreparedStatement.setBigDecimal(37, fornecedores.getAliquota());
			PreparedStatement.setString(38, fornecedores.getDocidex());
			PreparedStatement.setString(39, fornecedores.getDescricao());
			PreparedStatement.setDate(40, new java.sql.Date(new Date().getTime()));
			
			PreparedStatement.setString(41, fornecedores.getNome());
			PreparedStatement.setString(42, fornecedores.getCpf());
			PreparedStatement.setDate(43, new java.sql.Date(t));
			PreparedStatement.setString(44, fornecedores.getLogradouro());
			PreparedStatement.setString(45, fornecedores.getNum());
			PreparedStatement.setString(46, fornecedores.getCom());
			PreparedStatement.setString(47, fornecedores.getBairro());
			PreparedStatement.setString(48, fornecedores.getCep());
			PreparedStatement.setString(49, fornecedores.getCidade());
			PreparedStatement.setString(50, fornecedores.getEstado());
			PreparedStatement.setString(51, fornecedores.getIe());
			PreparedStatement.setString(52, fornecedores.getTelefone());
			PreparedStatement.setString(53, fornecedores.getCelular());
			PreparedStatement.setString(54, fornecedores.getFax());
			PreparedStatement.setString(55, fornecedores.getEmail());
			PreparedStatement.setString(56, fornecedores.getSite());
			PreparedStatement.setString(57, fornecedores.getContato());
			if (despesaCodigo != null) {
				PreparedStatement.setInt(58, despesaCodigo);
			}
			else {
				PreparedStatement.setNull(58, Types.INTEGER);
			}
			PreparedStatement.setString(59, fornecedores.getNomedes());
			PreparedStatement.setInt(60, fornecedores.getGrupofornecedor_codigo());
			PreparedStatement.setString(61, fornecedores.getRg());
			PreparedStatement.setString(62, fornecedores.getContabil());
			PreparedStatement.setString(63, fornecedores.getBanco());
			PreparedStatement.setString(64, fornecedores.getTipoconta());
			PreparedStatement.setInt(65, fornecedores.getAgenciabanco());
			PreparedStatement.setInt(66, fornecedores.getDigagencia());
			PreparedStatement.setInt(67, fornecedores.getConta());
			PreparedStatement.setInt(68, fornecedores.getDigconta());
			PreparedStatement.setString(69, fornecedores.getNomefantasia());
			PreparedStatement.setInt(70, fornecedores.getFebraban());
			PreparedStatement.setInt(71, fornecedores.getInscmunicipio());
			PreparedStatement.setString(72, fornecedores.getPrestadorserv());
			PreparedStatement.setString(73, fornecedores.getIcms());
			PreparedStatement.setString(74, fornecedores.getIpi());
			PreparedStatement.setInt(75, fornecedores.getCodigopais());
			PreparedStatement.setString(76, fornecedores.getInss());
			PreparedStatement.setBigDecimal(77, fornecedores.getAliquota());
			PreparedStatement.setString(78, fornecedores.getDocidex());
			PreparedStatement.setString(79, fornecedores.getDescricao());
			PreparedStatement.setDate(80, new java.sql.Date(new Date().getTime()));
			PreparedStatement.execute();
			return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		return false;

		}
	}

	// lista todos os fornecedoress cadastrados no banco de dados
	public List<Fornecedor> listFornecedores() {

		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();

		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conexao.createStatement();
			String sql = "select nome, cpf, dtnascimento,"
					+ "logradouro, num, com, bairro, cep, "
					+ "cidade, estado, ie, telefone, celular, fax, email,"
					+ "site, contato, codigodes, nomedes, grupofornecedor_codigo, rg,  "
					+ "contabil, banco, tipoconta, agenciabanco, digagencia, conta, "
					+ "digconta, nomefantasia, febraban, inscmunicipio," 
					+ "prestadorserv, icms, ipi, codigopais, inss, aliquota, "
					+ "docidex, descricao, data_cadastro from fornecedor";
			rs = st.executeQuery(sql);

			while (rs.next()) {			
				
				Fornecedor fornecedores = new Fornecedor();
				fornecedores.setNome(rs.getString(1));
				fornecedores.setCpf(rs.getString(2));
				fornecedores.setDtnascimento(rs.getDate(3));
				fornecedores.setLogradouro(rs.getString(4));
				fornecedores.setNum(rs.getString(5));
				fornecedores.setCom(rs.getString(6));
				fornecedores.setBairro(rs.getString(7));
				fornecedores.setCep(rs.getString(8));
				fornecedores.setCidade(rs.getString(9));
				fornecedores.setEstado(rs.getString(10));
				fornecedores.setIe(rs.getString(11));
				fornecedores.setTelefone(rs.getString(12));
				fornecedores.setCelular(rs.getString(13));
				fornecedores.setFax(rs.getString(14));
				fornecedores.setEmail(rs.getString(15));
				fornecedores.setSite(rs.getString(16));
				fornecedores.setContato(rs.getString(17));
				fornecedores.setCodigodes(rs.getInt(18));
				DespesaReceita despesa = new DespesaReceitaDAO().listadespesa(fornecedores.getCodigodes());
				fornecedores.setDespesa(despesa);
				fornecedores.setNomedes(rs.getString(19));			
				fornecedores.setGrupofornecedor_codigo(rs.getInt(20));
				Integer codigo = fornecedores.getGrupofornecedor_codigo();
				fornecedores.setGrupofornecedor(getFornecedores(codigo)); 
				fornecedores.setRg(rs.getString(21));
				fornecedores.setContabil(rs.getString(22));
				fornecedores.setBanco(rs.getString(23));
				fornecedores.setTipoconta(rs.getString(24));
				fornecedores.setAgenciabanco(rs.getInt(25));
				fornecedores.setDigagencia(rs.getInt(26));
				fornecedores.setConta(rs.getInt(27));
				fornecedores.setDigconta(rs.getInt(28));
				fornecedores.setNomefantasia(rs.getString(29));
				fornecedores.setFebraban(rs.getInt(30));
				fornecedores.setInscmunicipio(rs.getInt(31));
				fornecedores.setPrestadorserv(rs.getString(32));
				fornecedores.setIcms(rs.getString(33));
				fornecedores.setIpi(rs.getString(34));
				fornecedores.setCodigopais(rs.getInt(35));
				fornecedores.setInss(rs.getString(36));
				fornecedores.setAliquota(rs.getBigDecimal(37));
				fornecedores.setDocidex(rs.getString(38));
				fornecedores.setDescricao(rs.getString(39));
				fornecedores.setData_cadastro(rs.getDate(40));		
				
				lista.add(fornecedores);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Connection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
		}
		return lista;
	}
		
	
	public GrupoFornecedor getFornecedores(Integer codigo) {
		GrupoFornecedor grupoFornecedores = new GrupoFornecedor();
		
		PreparedStatement preparedStatement;
		ResultSet rs = null;
		try {
			preparedStatement = conexao
					.prepareStatement ("select codigo, nome from grupo_fornecedor where codigo = ?");
			preparedStatement.setInt(1, codigo);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Integer cod = rs.getInt("codigo");
				String nome = rs.getString("nome");
				grupoFornecedores.setCodigo(cod);
				grupoFornecedores.setNome(nome);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
							
		
		return grupoFornecedores;
	}
	
}
