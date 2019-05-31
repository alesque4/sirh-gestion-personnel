package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.util.Constantes;

@SuppressWarnings("serial")
public class EditerCollaborateurControlleur extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = "";
		String prenom = "";
		LocalDate dateNaissance = null;
		String adresse = "";
		String numSecu = "";
		Collaborateur newCollab = null;
		
		//Envoi du formulaire
		req.getRequestDispatcher("/WEB-INF/views/collab/createCollaborateurs.jsp").forward(req, resp);
		
		//Récupération des paramètres
		nom = req.getParameter("nom");
		prenom = req.getParameter("prenom");
		dateNaissance = LocalDate.parse(req.getParameter("dateNaissance"));
		adresse = req.getParameter("adresse");
		numSecu = req.getParameter("numSecu");
		if(Arrays.asList(nom, prenom, dateNaissance, adresse, numSecu).stream().allMatch(o -> o != null)) {
			newCollab = new Collaborateur(nom, prenom, dateNaissance, adresse, numSecu);
			Constantes.COLLAB_SERVICE.sauvegarderCollaborateur(newCollab);
		}else {
			//TODO
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		
	}

}
