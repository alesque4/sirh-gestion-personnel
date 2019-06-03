package dev.sgp.util;

import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.service.StatService;

public interface Constantes {
	
	// constante a ajouter
	final CollaborateurService COLLAB_SERVICE = new CollaborateurService();
	final DepartementService DEPARTEMENT_SERVICE = new DepartementService();
	final StatService STAT_SERVICE = new StatService();

}
