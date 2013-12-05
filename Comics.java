public class Comics extends BD {
	
	/** 
	* Constructeur permettant de construire un Comics
	* en fonction du titre, du scenariste et du dessinateur
	* @param titre, scenariste, dessinateur
	**/
	public Comics(String titre, String scenariste, String dessinateur) {
		super(titre,scenariste,dessinateur);
	}
	/**
	* Méthode permettant de retourner la catégorie de
	* la BD ( ici Comics)
	* @return la catégorie de la BD ( Comics)
	**/
	public String categorie() {
		return "Comics";
	}
}