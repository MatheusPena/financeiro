package br.com.grupoferraz.financeiro.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vendedores {
	private String pessoa;
	private List<String> pessoas;
	private String cpf;
	private String nome;
	private Date data;
	private String chave;
	private String rg;
	private String emissor;
	private Map<String, String> emissores = new HashMap<String, String>();
	private String sexo;
	private String estado_civil;
	private String agencia;
	private String rua;
	private String cep;
	private int numero;
	private String bairro;
	private String cidade;
	private String uf;
	private List<String> ufs;
	private String complemento;
	private String email;
	private String telefone;
	private String cel1;
	private String cel2;
	private Integer grupovendedores_codigo;
	private String banco;
	private String tipo_conta;
	private int agenciabanco;
	private int digagencia;
	private int conta;
	private int digconta;
	private Date dataCadastro;
	private GrupoVendedores grupovendedores;
	
	public Vendedores() {
		initPessoa();
		initEmissor();
		initUF();
	}

	public void initPessoa() {
		pessoas = new ArrayList<String>();
		pessoas.add("F�sica");
		pessoas.add("Jur�dica");
	}

	public void initEmissor() {
		emissores.put("SSP - Secretaria de Seguran�a P�blica", "SSP");
		emissores.put("COREN - Conselho Regional de Enfermagem", "COREN");
		emissores.put("CRA - Conselho Regional de Administra��o", "CRA");
		emissores.put("CRAS - Conselho Regional de Assistentes Sociais", "CRAS");
		emissores.put("CRB - Conselho Regional de Biblioteconomia", "CRB");
		emissores.put("CRC - Conselho Regional de Contabilidade", "CRC");
		emissores.put("CRE - Conselho Regional de Estat�stica", "CRE");
		emissores.put("CREA - Conselho Regional de Engenharia Arquitetura e Agronomia", "CREA");
		emissores.put("CRECI - Conselho Regional de Corretores de Im�veis", "CRECI");
		emissores.put("CREFIT - Conselho Regional de Fisioterapia e Terapia Ocupacional", "CREFIT");
		emissores.put("CRF - Conselho Regional de Farm�cia", "CRF");
		emissores.put("CRM - Conselho Regional de Medicina", "CRM");
		emissores.put("CRN - Conselho Regional de Nutri��o", "CRN");
		emissores.put("CRO - Conselho Regional de Odontologia", "CRO");
		emissores.put("CRP - Conselho Regional de Psicologia", "CRP");
		emissores.put("CRPRE - Conselho Regional de Profissionais de Rela��es P�blicas", "CRPRE");
		emissores.put("CRQ - Conselho Regional de Qu�mica", "CRQ");
		emissores.put("CRRC - Conselho Regional de Representantes Comerciais", "CRRC");
		emissores.put("CRMV - Conselho Regional de Medicina Veterin�ria", "CRMV");
		emissores.put("DPF - Pol�cia Federal", "DPF");
		emissores.put("EST - Documentos Estrangeiros", "EST");
		emissores.put("I CLA - Carteira de Identidade Classista", "I CLA");
		emissores.put("MAE - Minist�rio da Aeron�utica", "MAE");
		emissores.put("MEX - Minist�rio do Ex�rcito", "MEX");
		emissores.put("MMA - Minist�rio da Marinha", "MMA");
		emissores.put("OAB - Ordem dos Advogados do Brasil", "OAB");
		emissores.put("OMB - Ordens dos M�sicos do Brasil", "OMB");
		emissores.put("IFP - Instituto de Identifica��o F�lix Pacheco", "IFP");
		emissores.put("OUT - Outros Emissores", "OUT");
	}

	public void initUF() {
		ufs = new ArrayList<String>();
		ufs.add("AC");
		ufs.add("AL");
		ufs.add("AP");
		ufs.add("AM");
		ufs.add("BA");
		ufs.add("CE");
		ufs.add("DF");
		ufs.add("ES");
		ufs.add("GO");
		ufs.add("MA");
		ufs.add("MS");
		ufs.add("MT");
		ufs.add("MG");
		ufs.add("PA");
		ufs.add("PB");
		ufs.add("PR");
		ufs.add("PE");
		ufs.add("PI");
		ufs.add("RJ");
		ufs.add("RN");
		ufs.add("RS");
		ufs.add("RO");
		ufs.add("RR");
		ufs.add("SC");
		ufs.add("SP");
		ufs.add("SE");
		ufs.add("TO");
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	public List<String> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<String> pessoas) {
		this.pessoas = pessoas;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getEmissor() {
		return emissor;
	}

	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}

	public Map<String, String> getEmissores() {
		return emissores;
	}

	public void setEmissores(Map<String, String> emissores) {
		this.emissores = emissores;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<String> getUfs() {
		return ufs;
	}

	public void setUfs(List<String> ufs) {
		this.ufs = ufs;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCel1() {
		return cel1;
	}

	public void setCel1(String cel1) {
		this.cel1 = cel1;
	}

	public String getCel2() {
		return cel2;
	}

	public void setCel2(String cel2) {
		this.cel2 = cel2;
	}

	public Integer getGrupovendedores_codigo() {
		return grupovendedores_codigo;
	}

	public void setGrupovendedores_codigo(Integer grupovendedores_codigo) {
		this.grupovendedores_codigo = grupovendedores_codigo;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getTipo_conta() {
		return tipo_conta;
	}

	public void setTipo_conta(String tipo_conta) {
		this.tipo_conta = tipo_conta;
	}

	public int getAgenciabanco() {
		return agenciabanco;
	}

	public void setAgenciabanco(int agenciabanco) {
		this.agenciabanco = agenciabanco;
	}

	public int getDigagencia() {
		return digagencia;
	}

	public void setDigagencia(int digagencia) {
		this.digagencia = digagencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getDigconta() {
		return digconta;
	}

	public void setDigconta(int digconta) {
		this.digconta = digconta;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public GrupoVendedores getGrupovendedores() {
		return grupovendedores;
	}

	public void setGrupovendedores(GrupoVendedores grupovendedores) {
		this.grupovendedores = grupovendedores;
	}
	
}
