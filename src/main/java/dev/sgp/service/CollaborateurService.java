package dev.sgp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Collaborateur;

public class CollaborateurService {

	List<Collaborateur> listeCollaborateurs;

	public CollaborateurService() {
		listeCollaborateurs = new ArrayList<>();
		listeCollaborateurs.add(
				new Collaborateur("La Bricole", "Gégé", LocalDate.of(1991, 04, 18), "22 rue du pommier", "123412341234123"));
		listeCollaborateurs
				.add(new Collaborateur("To", "To", LocalDate.of(1980, 04, 9), "12 toto land", "456745674567897"));
	}

	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}
}
