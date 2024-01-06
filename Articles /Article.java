package mainClasses;

abstract class Article {
	
	private int idArticle; 
	protected Paquet paquet;
		
	public Article(int idArticle) {
		this.idArticle = idArticle;
		this.paquet = null;
	}
	
	public int getIdArticle() {
		return idArticle;
	}
	
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	
	public Paquet getPaquet() {
		return paquet;
	}
	
	public void setPaquet(Paquet paquet) throws UselessArticleException {
		this.paquet = paquet;
		paquet.listeArticles.add(this);
	}
			
}
