package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

public class Collaborateur {
	
	private static Integer compteur = 0;
	private final static String SUFFIXE_MAIL = ResourceBundle.getBundle("application").getString("suffixe_mail");
	
	private String matricule;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String adresse;
	private String numSecu;
	private String emailPro;
	private String photo;
	private ZonedDateTime heureCreation;
	private boolean actif;
	//TP4
	private String intitulePoste;
	private Departement departement;
	
	public Collaborateur(String nom, String prenom, LocalDate dateNaissance, String adresse, String numSecu) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.numSecu = numSecu;
		this.matricule = ""+nom.charAt(0)+prenom.charAt(0)+compteur.toString();
		compteur++;
		this.emailPro = nom+"."+prenom+"@"+SUFFIXE_MAIL;
		this.photo = "FAKE_PHOTO";
		this.heureCreation = ZonedDateTime.now();
		this.actif = true;
	}
	
	
	@Override
	public String toString() {
		return "Collaborateur [matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", adresse=" + adresse + ", numSecu=" + numSecu + ", emailPro=" + emailPro
				+ ", photo=" + photo + ", heureCreation=" + heureCreation + ", actif=" + actif + "]";
	}
	
	/* Getters
	 * 	&
	 * Setters
	 */
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumSecu() {
		return numSecu;
	}
	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}
	public String getEmailPro() {
		return emailPro;
	}
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public ZonedDateTime getHeureCreation() {
		return heureCreation;
	}
	public void setHeureCreation(ZonedDateTime heureCreation) {
		this.heureCreation = heureCreation;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}


	public String getIntitulePoste() {
		return intitulePoste;
	}


	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

}
