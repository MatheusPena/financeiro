package br.com.grupoferraz.financeiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.grupoferraz.financeiro.dao.DocumentoDAO;
import br.com.grupoferraz.financeiro.entity.Documento;
import br.com.grupoferraz.financeiro.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DocumentoBean implements Serializable {
	private Documento documento;
	private List<Documento> listadocumentos;

	public DocumentoBean() {
		setDocumento(new Documento());
		listarDocumentos();
	}

	public String cadastraDocumentos() {

		DocumentoDAO Documentos = new DocumentoDAO();
		if (Documentos.insertDocumentos(this.getDocumento())) {
			JSFUtil.mostraMensagem(FacesMessage.SEVERITY_INFO, "Documento cadastrado com sucesso!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no cadastro do documento!", "Erro!"));
			return "";
		}

		setDocumento(new Documento());

		return "cadastro_documento?faces-redirect=true";
	}

	public void listarDocumentos() {
		DocumentoDAO Documentos = new DocumentoDAO();
		setDocumentos(Documentos.listDocumentos());
	}

	public List<Documento> getDocumentos() {
		return listadocumentos;
	}

	public void setDocumentos(List<Documento> Documentos) {
		this.listadocumentos = Documentos;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

}
