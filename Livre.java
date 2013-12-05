import java.io.*;
public abstract class Livre implements Serializable {
	//titre du livre
	private String titre;
	// auteur du livre
	private String auteur;
	//nombre de livres créés
	private static int nb_livre=0;
	//identifiant unique du livre
	private int numero;
	/**
	* Constructeur de livre qui initialise le titre 
	* et l'auteur du livre et qui incrémente l'identifiant
	* du livre.
	* @param t titre du livre
	* @param a auteur du livre
	**/
	public Livre(String t, String a) {
		titre=t;
		auteur=a;
		nb_livre++;
		numero=nb_livre;
	}

	/**
	* Retourne une chaine de caractères correspondant au type du livre
	*
	* @return 	le type du livre
	**/
	public abstract String categorie();
	

	/**
	* Retourne une chaine de caractères contenant toutes les informations
	* du livre (nécessaires à l'affichage de ces informations).
	* @return 	informations sur le livre
	*/
	public String toString() {
		return (categorie()+";"+numero+";"+titre+";"+auteur);
	}

	//accesseurs

	/**
	* Retourne l'auteur du livre 
	*
	* @return auteur
	**/
	public String getAuteur() {
		return auteur;
	}

	/** 
	* Retourne le titre du livre
	*
	* @return titre
	**/
	public String getTitre() {
		return titre;
	}
	/**
	* Méthode permettant de modifier l'auteur d'un livre
	*
	* @param chaine chaine contenant le nouvel auteur du livre à modifier
	**/
	public void setAuteur(String chaine) {
		auteur=chaine;
	}

	/**
	* Méthode permettant de modifier la liste d'un livre
	*
	* @param chaine chaine contenant le nouveau titre du livre à modifier
	**/
	public void setTitre(String chaine) {
		titre=chaine;
	}
	/**
	* Méthode permettant de modifier le numéro d'un livre
	*
	* @param num nouveau numéro du livre
	**/
	public void setNumero(int num) {
		numero=num;
	}
	/**
	* Méthode permettant de retourner le numéro d'un livre
	*
	* @return id d'un livre
	**/
	public int getNumero() {
		return numero;
	}


}