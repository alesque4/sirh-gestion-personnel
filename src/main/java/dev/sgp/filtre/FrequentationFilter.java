package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.util.Constantes;


public class FrequentationFilter implements HttpFilter{

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		ServletContext context = getServletContext();

		long before = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();
		int duration = (int) (before-after);
		String path = ((HttpServletRequest) req).getRequestURI();
		System.out.println("Ajout d'une visite : "+path+", "+duration);
		Constantes.STAT_SERVICE.addVisite(new VisiteWeb(path, duration));
	}

}
