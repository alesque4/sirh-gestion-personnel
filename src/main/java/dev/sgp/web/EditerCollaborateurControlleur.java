package dev.sgp.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class EditerCollaborateurControlleur extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String matricule = "";
		
		//lecture des paramètres
		matricule = req.getParameter("matricule");
		
		//écriture de la réponse
		resp.setContentType("text/html");
		if(matricule == null) {
			resp.setStatus(400);
			resp.getWriter().write("Un matricule est attendu");
		}else {
			resp.setStatus(200);
			resp.getWriter().write("<h1>Edition de collaborateur</h1>"
					+ "<p>Matricule : "+matricule+"</p>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String matricule = "";	String titre = "";
		String nom = "";		String prenom = "";
		String infoManquantes = "";
		
		//lecture des paramètres
		matricule =	req.getParameter("matricule");
		titre = req.getParameter("titre");
		nom = req.getParameter("nom");
		prenom = req.getParameter("prenom");
		
		//Réponse
		resp.setContentType("text/html");
		if(Arrays.asList(matricule, titre, nom, prenom).stream().allMatch(atr -> atr != null)) {
			resp.setStatus(201);
			resp.getWriter().write("<p>Creation d’un collaborateur avec les informations suivantes :"
					+ "<br/>Matricule : "+matricule+
					"<br/>Titre : "+titre+
					"<br/>Nom : "+nom+
					"<br/>Prenom : "+prenom+"</p>");
		}else {
			resp.setStatus(400);
			infoManquantes += (matricule == null)?"Matricule ":"";
			infoManquantes += (titre == null)?"Titre ":"";
			infoManquantes += (nom == null)?"Nom ":"";
			infoManquantes += (prenom == null)?"Prenom ":"";
			resp.getWriter().write("<p>Les paramètres suivants sont incorrects : <br/>"+infoManquantes+"</p>");		
		}
		
	}

}
