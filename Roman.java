public class Roman extends Livre  {
	/** 
	* Constructeur permettant de construire un Roman
	* en fonction du titre et de l'auteur
	*
	* @param titre, auteur
	**/
	public Roman(String titre,String auteur) {
		super(titre,auteur);
	}
	/**
	* Méthode permettant de retourner la catégorie
	* du livre (ici Roman)
	*
	* @return la catégorie du livre (Roman)
	**/
	public String categorie() {
		return "Roman";
	}
}