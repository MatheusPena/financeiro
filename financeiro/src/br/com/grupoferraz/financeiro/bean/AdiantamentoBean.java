package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.AdiantamentoDAO;
import br.com.grupoferraz.financeiro.dao.DespesaReceitaDAO;
import br.com.grupoferraz.financeiro.dao.EstabelecimentoDAO;
import br.com.grupoferraz.financeiro.dao.GrupoClienteDAO;
import br.com.grupoferraz.financeiro.dao.HistoricoDAO;
import br.com.grupoferraz.financeiro.entity.Adiantamento;
import br.com.grupoferraz.financeiro.entity.DespesaReceita;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.entity.GrupoCliente;
import br.com.grupoferraz.financeiro.entity.Historico;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AdiantamentoBean implements Serializable {
	private Adiantamento adiantamento;
	private List<Adiantamento> listaAdiantamentos;

	public AdiantamentoBean() {
		adiantamento = new Adiantamento();
		listarAdiantamento();
	}

	private void listarAdiantamento() {
		AdiantamentoDAO AdiantamentoDAO = new AdiantamentoDAO();
		listaAdiantamentos = AdiantamentoDAO.listAdiantamento();

	}

	public String cadastraAdiantamento() {

		AdiantamentoDAO Adiantamento = new AdiantamentoDAO();
		if (Adiantamento.insertAdiantamento(this.adiantamento)) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Adiantamento cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do adiantamento", "Erro!"));
		return "";
		}

		this.adiantamento = new Adiantamento();
		listarAdiantamento();
		return "";
	}
	
	// m�todo que deleta os adiantamentos
		public String deletaAdiantamento() {

			// ConexaoBD.getConexao();
			AdiantamentoDAO Adiantamento = new AdiantamentoDAO();
			try {
				if (Adiantamento.deleteAdiantamento(adiantamento.getCodigo())) {
					listaAdiantamentos.remove(adiantamento);
					JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Adiantamento deletado com sucesso!");
				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							"Erro ao deletar adiantamento, ele pode estar vinculado � outro formul�rio.", "Erro!"));
					return "";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ConexaoBD.fecharConexao();
			this.adiantamento = new Adiantamento();
			listarAdiantamento();
			return "";
		}

	// Autocomplete referente ao estabelecimento
		public List<Estabelecimento> completeText2(String query) {
			
			List<Estabelecimento> lista = new ArrayList<>();
			String cnpj = null;
			if (adiantamento != null) {
				cnpj = adiantamento.getEmpresa_cnpj();
				EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
				lista.addAll(estabelecimentoDAO.listaestabelecimento(query, cnpj));
			}

	        return lista; 
	    }
		
		public void selecionar() {
			Estabelecimento estabelecimento = adiantamento.getEstabelecimento();
			EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
			if (estabelecimento != null) {
				Estabelecimento estabelecimentos = estabelecimentoDAO.listaestabelecimento(estabelecimento.getCodigo());
				if (estabelecimentos != null) {
					adiantamento.setEstabelecimento_nome(estabelecimentos.getNome());
					adiantamento.setEstabelecimento_codigo(estabelecimentos.getCodigo());
				}
			}

		}	
		
//		Autocomplete referente � Despesas
		public List<DespesaReceita> completeText(String query) {
			DespesaReceitaDAO despesareceitaDAO = new DespesaReceitaDAO();

			return despesareceitaDAO.listadespesareceitas(query);
		}


		public void selecionarDespesaReceita() {
			
			DespesaReceita despesa = adiantamento.getDespesareceita();
			
			if (despesa != null) {
				HistoricoDAO historicoDAO = new HistoricoDAO();
				Historico historico = historicoDAO.historico(despesa);
				if (historico != null) {
					adiantamento.setHistoricopadrao_codigo(historico.getCodigo());
				}
				
				adiantamento.setDespesa_codigo(despesa.getCodigo());
				adiantamento.setDespesa_nome(despesa.getNome());
			}
	
		}
	
//	Getters e Setters do Adiantamento	
	public Adiantamento getAdiantamento() {
		return adiantamento;
	}

	public void setAdiantamento(Adiantamento Adiantamento) {
		this.adiantamento = Adiantamento;
	}

	public List<Adiantamento> getListaAdiantamento() {
		return listaAdiantamentos;
	}

	public void setListaAdiantamento(List<Adiantamento> listaAdiantamento) {
		this.listaAdiantamentos = listaAdiantamento;
	}

}
