[6:32 PM, 06/01/2024] .: package mainClasses;
import java.util.Date;

public class Habitant extends Personne {
	
	private int idHabitant;
	private Famille famille;
	private Character genre; // f ou m
	private String profession; 
	private String etatSanitaire; // sain ou malade

	public Habitant(int idHabitant, String nom, String prenom, String dateNaissance, int numTelephone, Famille famille, Character genre, String profession, String etatSanitaire) {
		super(nom, prenom, dateNaissance, numTelephone);
		this.setIdHabitant(idHabitant);
		this.famille = famille;
		this.genre = genre;
		this.setProfession(profession);
		this.etatSanitaire = etatSanitaire;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
		famille.membresFamille.add(this);
	}

	public Character getGenre() {
		return genre;
	}

	public void setGenre(Character genre) {
		this.genre = genre;
	}

	public String getEtatSanitaire() {
		return etatSanitaire;
	}

	public void setEtatSanitaire(String etatSanitaire) {
		this.etatSanitaire = etatSanitaire;
	}

	public int getIdHabitant() {
		return idHabitant;
	}

	public void setIdHabitant(int idHabitant) {
		this.idHabitant = idHabitant;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	
}
[6:34 PM, 06/01/2024] .: package mainClasses;
import java.util.ArrayList;

public class Famille {
	
	private int idFamille;
	public ArrayList<Habitant> membresFamille = new ArrayList<Habitant>();
	public ArrayList<Paquet> paquets = new ArrayList<Paquet>();
	Village village;
	
	public Famille(int idFamille, Village village) {
		this.idFamille = idFamille;
		this.village = village;
	}

	public int getIdFamille() {
		return idFamille;
	}

	public void setIdFamille(int idFamille) {
		this.idFamille = idFamille;
	}

	// fonction qui vérifie si une famille ne contient pas une persone qui appartient a une categorie d'age
	public boolean estSansMembresDansCategorie(int ageMin, int ageMax) {
	    for (Beneficiaire membre : this.membresFamille) {
	        if (membre.getAge() >= ageMin && membre.getAge() <= ageMax) {
	            return false;  // Il y a au moins un membre dans la catégorie d'âge spécifiée
	        }
	    }
	    return true;  // Aucun membre dans la catégorie d'âge spécifiée
	}
	
	public boolean estSansEnfants() { //famille sans enfants
	    return estSansMembresDansCategorie(0, 12);
	}

	public boolean estSansAdolescent() { //famille sans adolescent
	    return estSansMembresDansCategorie(13, 17);
	}

	public boolean estSansJeuneAdulte() {//famille sans jeune adulte
	    return estSansMembresDansCategorie(18, 24);
	}

	public boolean estSansAdulte() {//famille sans adulte
	    return estSansMembresDansCategorie(25, 64);
	}

	public boolean estSansPersonneAgee() {//famille sans agée
	    return estSansMembresDansCategorie(65, Integer.MAX_VALUE);
	}



	
}
