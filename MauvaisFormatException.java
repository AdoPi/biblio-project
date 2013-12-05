public class MauvaisFormatException extends Exception {
	
	//Chaine permettant de tester si l'affichage de l'exception est correct
	public static String test_exception;
	// numéro de la ligne qui a déclenché l'exception
	private int numero;
	/**
	* Constructeur de MauvaisFormatException qui prend la ligne
	* ayant déclenché l'exception en paramètre 
	*
	* @param num numéro de la ligne ayant déclenché l'exception
	**/
	public MauvaisFormatException(int num) {
		numero=num;
	}
	/**
	* Méthode permettant de retourner une chaine de caractère
	* contenant la la ligne qui va déclencher l'exception
	*
	* @return numero de ligne qui a déclenché MauvaisFormatException
	**/
	public String toString() {
		test_exception=("Erreur ligne : "+numero);
		return ("Erreur ligne : "+numero);
	}


}