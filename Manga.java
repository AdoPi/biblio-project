public class Manga extends BD {
	/** 
	* Constructeur permettant de construire un Manga
	* en fonction du titre, du scenariste et du dessinateur
	* @param titre
	* @param scenariste
	* @param dessinateur
	**/
	public Manga(String titre, String scenariste, String dessinateur) {
		super(titre,scenariste,dessinateur);
	}

	/**
	* Méthode permettant de retourner la catégorie de
	* la BD ( ici Manga)
	*
	* @return la catégorie de la BD (Manga)
	**/
	public String categorie() {
		return "Manga";
	}
}