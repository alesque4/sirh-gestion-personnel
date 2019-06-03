package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

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
		//Envoi du formulaire
		req.getRequestDispatcher("/WEB-INF/views/collab/createCollaborateurs.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String nom = "";
		String prenom = "";
		LocalDate dateNaissance = null;
		String dateRecue;
		String adresse = "";
		String numSecu = "";
		Collaborateur newCollab = null;
		
		//Récupération des paramètres
		nom = req.getParameter("nom");
		prenom = req.getParameter("prenom");
		dateRecue = req.getParameter("dateNaissance");
		if(dateRecue != null && !dateRecue.equals("")) {
			dateNaissance = LocalDate.parse(dateRecue);
		}
		
		adresse = req.getParameter("adresse");
		numSecu = req.getParameter("numSecu");
		if(Arrays.asList(nom, prenom, dateNaissance, adresse, numSecu).stream()
				.allMatch(o -> o != null && !o.equals(""))) {
			newCollab = new Collaborateur(nom, prenom, dateNaissance, adresse, numSecu);
			Constantes.COLLAB_SERVICE.sauvegarderCollaborateur(newCollab);
			//Après la sauvegarde on redirige vers la liste des collaborateurs
			req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);
		}else {
			//Cas où on a une erreur
			String messageErreur = "";
			ArrayList<String> listErreur = new ArrayList<String>();
			
			resp.setStatus(400);
			if(nom == null || nom.equals("")) {
				listErreur.add("Nom");
			}
			if(prenom == null || prenom.equals("")) {
				listErreur.add("Prenom");
			}
			if(dateNaissance == null) {
				listErreur.add("Date de naissance");
			}
			if(adresse == null || adresse.equals("")) {
				listErreur.add("Adresse");
			}
			if(numSecu == null || numSecu.equals("")) {
				listErreur.add("n° Sécu");
			}
			messageErreur = "Erreur 400 : "+listErreur.stream().collect(Collectors.joining(", "));
			
			//Envoi du formulaire
			req.setAttribute("erreur", messageErreur);
			req.getRequestDispatcher("/WEB-INF/views/collab/createCollaborateurs.jsp").forward(req, resp);
			
		}
		
	}

}
