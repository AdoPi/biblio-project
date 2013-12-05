public abstract class BD extends Livre {
	// dessinateur de la BD
	private String dessinateur;
	
	/**
	* Constructeur de BD qui initialise l'attribut dessinateur
	* et les attributs titre et auteur grâce à l'appel de super,
	* les instances de BD sont donc aussi dotées de l'identifiant 
	* unique "numero"
	*
	* @param titre titre de la BD
	* @param scenariste auteur de la BD
	* @param dess dessinateur de la BD
	**/
	public BD(String titre, String scenariste, String dess) {
		super(titre,scenariste);
		dessinateur = dess;
	}


	/**
	* Méthode permettant de retourner le dessinateur d'une BD
	*
	* @return dessinateur de la BD
	**/
	public String getDessinateur() {
		return dessinateur;
	}


	/**
	* Méthode permettant de renvoyer une chaine de caractère
	* permettant l'affichage d'un objet BD 
	*
	* @return chaine permettant l'affichage
	**/
	public String toString() {
		return(super.toString()+";"+dessinateur);
	}

}