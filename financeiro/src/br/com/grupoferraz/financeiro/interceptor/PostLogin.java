package br.com.grupoferraz.financeiro.interceptor;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.grupoferraz.financeiro.bean.LoginBean;

public class PostLogin implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		LoginBean login = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);

		if (login.isLogado() && "/login.xhtml".equals(context.getViewRoot().getViewId())) {
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "index?faces-redirect=true");
			// Só é preciso se o ajax estiver desabilitado
			System.out.println("FASE RETORNADA: " + this.getPhaseId());
			context.renderResponse();
		} 

	}

	@Override
	public void beforePhase(PhaseEvent event) {

	}

	@Override
	public PhaseId getPhaseId() {
		// Com o ajax desabilitado seria PhaseId.RENDER_RESPONSE
		return PhaseId.INVOKE_APPLICATION;
	}

}
