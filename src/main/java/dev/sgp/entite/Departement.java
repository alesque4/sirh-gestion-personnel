package dev.sgp.entite;

public class Departement {

	private static int idCompteur = 0;
	
	private Integer id;
	private String nom;
	
	public Departement(String nom) {
		id = idCompteur;
		idCompteur++;
		this.nom = nom;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + "]";
	}
}
