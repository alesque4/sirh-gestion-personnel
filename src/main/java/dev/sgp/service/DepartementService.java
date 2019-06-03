package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Departement;

public class DepartementService {
	
	private List<Departement> listDepartement;
	
	public DepartementService() {
		listDepartement = new ArrayList<>();
		listDepartement.add(new Departement("Comptabilite"));
		listDepartement.add(new Departement("Ressources Humaines"));
		listDepartement.add(new Departement("Informatique"));
		listDepartement.add(new Departement("Administratif"));
	}

	public List<Departement> getListDepartement() {
		return listDepartement;
	}
	
	
}
