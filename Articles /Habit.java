[6:46 PM, 06/01/2024] .: package mainClasses;

public class DenreesAlimentaires extends Article {
	
	static int denreesAlimentairesDisponibles = 0;

	public DenreesAlimentaires(int idArticle) {
		super(idArticle);
		denreesAlimentairesDisponibles++;
	}

}
[6:46 PM, 06/01/2024] .: package mainClasses;

public class Habit extends Article {
	
	private String genre; // f ou m
	private String categorie; 
	/*
	 * Enfants : 0 à 12 ans
	 * Adolescents : 13 à 17 ans
	 * Jeunes adultes : 18 à 24 ans
	 * Adultes : 25 à 64 ans
	 * Personnes âgées : 65 ans et plus
	 */
	private String taille;
	static int habitsDisponibles = 0;

	public Habit(int idArticle, String genre, String categorie, String taille) {
		super(idArticle);
		this.genre = genre;
		this.categorie = categorie;
		this.taille = taille;
		habitsDisponibles++;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}
	
	/*
	 * il est inutile mettre les vetements d'un enfant dans le paquet d'une famille
	 * qui ne contient pas des enfants.
	 */
	
	@Override
	public void setPaquet(Paquet paquet) throws UselessArticleException {
		if ("enfant".equals(this.categorie)) {
			if (!paquet.getFamille().contientEnfants()) 
				throw new UselessArticleException("il n'y a aucun enfant dans cette famille qui peut bénéficier de cet article");
			super.paquet = paquet;
			paquet.listeArticles.add(this);
		}
	}
	
}
