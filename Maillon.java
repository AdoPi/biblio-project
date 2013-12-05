import java.io.*;
public class Maillon implements Serializable {
	private Livre valeur;
	private Maillon suc;
	public Maillon(Livre livre, Maillon suivant) {
		valeur=livre;
		suc=suivant;
	}

	/** Méthode permettant de retourner le successeur d'un Maillon
	* @return suc
	**/
	public Maillon getMaillon() {
		return suc;
	}

	/**
	* Méthode permettant de retourner la valeur d'un Maillon
	**/
	public Livre getValeur() {
		return valeur;
	}


	/** Méthode utilisée dans la classe Liste lors de la suppression 
	* d'un maillon dans une liste
	* Cette méthode permet de modifier le successeur d'un maillon
	**/
	public void setMaillon(Maillon m) {
		suc=m;
	}
}
