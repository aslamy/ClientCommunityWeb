package beans;

import org.primefaces.context.ApplicationContext;

import javax.faces.application.Application;
import javax.faces.application.ResourceHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

public class AuthenticationFilter implements Filter{
	private FilterConfig config;


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		LoginBean userBean = (LoginBean) session.getAttribute("loginBean");


		if (userBean == null || userBean.isLoggedIn() == false) {

			res.sendRedirect(req.getContextPath() + "/login.xhtml");
		} else {
			chain.doFilter(req, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.setConfig(config);

	}

	@Override
	public void destroy() {
		setConfig(null);
	}

	public FilterConfig getConfig() {
		return config;
	}

	public void setConfig(FilterConfig config) {
		this.config = config;
	}

}


