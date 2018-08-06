package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.grupoferraz.financeiro.dao.AdiantamentoDAO;
import br.com.grupoferraz.financeiro.dao.DespesaReceitaDAO;
import br.com.grupoferraz.financeiro.dao.EstabelecimentoDAO;
import br.com.grupoferraz.financeiro.entity.Adiantamento;
import br.com.grupoferraz.financeiro.entity.DespesaReceita;
import br.com.grupoferraz.financeiro.entity.Estabelecimento;
import br.com.grupoferraz.financeiro.util.ConexaoBD;

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

		ConexaoBD.getConexao();
		AdiantamentoDAO Adiantamento = new AdiantamentoDAO();
		if (Adiantamento.insertAdiantamento(this.adiantamento)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Adiantamento cadastrado com sucesso!", "Sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do Adiantamento!", "Erro!"));

		}
		ConexaoBD.fecharConexao();

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
		
//		Autocomplete referente à Despesas
		public List<DespesaReceita> completeText(String query) {
			DespesaReceitaDAO despesareceitaDAO = new DespesaReceitaDAO();

			return despesareceitaDAO.listadespesareceitas(query);
		}


		public void selecionarDespesa() {
			
			DespesaReceita despesa = adiantamento.getDespesareceita();
			
			if (despesa != null) {
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
