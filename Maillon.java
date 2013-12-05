import java.io.*;
public class Maillon implements Serializable {
	// la valeur du maillon est un Livre
	private Livre valeur;
	// Le maillon suivant le maillon actuel et qui permettra de lier tous les maillons entre eux
	private Maillon suc;
	

	/**
	* Constructeur permettant de construire un maillon en fonction de 
	* sa valeur et du maillon qui suivra le maillon actuel
	*
	* @param livre la valeur sur laquelle pointe le maillon
	* @param suivant le maillon suivant le maillon actuel
	**/
	public Maillon(Livre livre, Maillon suivant) {
		valeur=livre;
		suc=suivant;
	}

	/** 
	* Méthode permettant de retourner le successeur d'un Maillon
	*
	* @return le maillon suivant le maillon actuel
	**/
	public Maillon getMaillon() {
		return suc;
	}

	/**
	* Méthode permettant de retourner la valeur d'un Maillon
	*
	* @return le livre correspondant au maillon
	**/
	public Livre getValeur() {
		return valeur;
	}


	/** 
	* Méthode utilisée dans la classe Liste lors de la suppression 
	* d'un maillon dans une liste
	* Cette méthode permet de modifier le successeur d'un maillon
	* 
	* @param maillon nouveau successeur du maillon actuel
	**/
	public void setMaillon(Maillon maillon) {
		suc=maillon;
	}
}
