public class MauvaisFormatException extends Throwable {
	// throwable ou Exception?
	

	private int numero;
	
	public MauvaisFormatException(int num) {
		numero=num;
	}
	/**
	* Méthode permettant de retourner une chaine de caractère
	* contenant la la ligne qui va déclencher l'exception
	* @return numero de ligne qui a déclenché MauvaisFormatException
	**/
	public String toString() {
		return ("Erreur ligne : "+numero);
	}

}