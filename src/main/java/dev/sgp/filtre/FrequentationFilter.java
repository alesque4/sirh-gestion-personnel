package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.util.Constantes;


public class FrequentationFilter extends HttpFilter{

	private static final long serialVersionUID = 9135815725548275718L;

	public void doFilter(HttpServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		long before = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();
		int duration = (int) (after-before);

		String path = req.getRequestURI();
		Constantes.STAT_SERVICE.addVisite(new VisiteWeb(path, duration));
	}

}
