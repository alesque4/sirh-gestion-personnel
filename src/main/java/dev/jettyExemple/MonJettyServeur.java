package dev.jettyExemple;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.*;

public class MonJettyServeur {
	
	public static void main(String[] args) throws Exception {
		Server server = new Server();
		ServerConnector connector = new ServerConnector(server);
		
		connector.setPort(8080);
		server.setConnectors(new Connector[] { connector });
		
		ServletContextHandler context = new ServletContextHandler();
		context.setContextPath("/monAppli");
		context.addServlet(HelloServlet.class, "/hello");
		
		HandlerCollection handlers = new HandlerCollection();
		handlers.setHandlers(new Handler[] { context, new DefaultHandler() });
		server.setHandler(handlers);
		server.start();
		server.join();
	}
}
