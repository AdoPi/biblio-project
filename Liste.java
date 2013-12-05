import java.io.*;
public class Liste implements Serializable {
	// Maillon représentant la tête de la liste
	private Maillon tete;
	// nombre d'élément ( de maillons) de la liste
	private int nb_element;

	/**
	* Constructeur d'une liste qui initlialise le nombre d'élément à 0
	* (la tête étant automatiquement initialisée à NULL)
	**/
	public Liste() {
		nb_element=0;
	}
	/**
	* Méthode permettant de retourner le nombre d'éléments de 
	* la liste 
	*
	* @return le nombre d'élements
	**/
	public int getNbElement() {
		return nb_element;
	}

	/**
	* Méthode permettant d'ajouter un livre à une liste 
	* 
	* @param l livre à ajouter à la liste
	**/
	public void ajouter(Livre l) {
		/* on change la tête en créant un maillon qui a pour successeur
		l'ancienne tête : c'est le principe d'une liste chainée.
		(On ajoute en tête de liste) */
		tete=new Maillon(l,tete);
		//on incrémente le nombre d'éléments à chaque ajout
		nb_element++;
	}



	/**
	* Méthode permettant de supprimer un livre de la liste dont le titre
	* est donné en paramètre
	*
	* @param titre titre du livre que l'on veut supprimer
	* @return booléen qui permet de savoir si la suppression s'est bien passée 
	**/
	public boolean supprime(String titre) {
		//Initialisation des variables permettant la recherche du livre
		boolean trouve=false;
		Maillon place=tete;
		Maillon place_precedente=tete;
		int nb=nb_element;
		//recherche du livre correspondant au titre donné en paramètre
		while (nb>0 && !trouve) {
			if (titre.compareTo(place.getValeur().getTitre())==0)
				trouve=true;
			else {
				place_precedente=place;
				place=place.getMaillon();
				nb--;

			}
		}
		// si on a trouvé le livre on le supprime
		if (trouve) {
			//cas particulier de la suppression en tête 
			if (nb==nb_element)
				tete=place.getMaillon();
			else 
			/* On saute la place du livre trouvé en faisant le lien entre la 
			place précédent la place du livre trouvé et la place suivant la place 
			du livre trouvé (exactement comme les suppressions dans les listes 
			chainées en structure) */
			place_precedente.setMaillon(place.getMaillon());
			/* Le maillon contenant le livre trouvé est automatiquement supprimé
			grâce au garbage collector car plus aucune référence de cet objet n'existe */
			
			//Et on décrémente le nombre d'éléments
			nb_element--;
		}
		return trouve;
	}


	/**
	* Méthode permettant de retourner une chaine de caractère utilisée
	* lors de l'affichage de l'objet 
	*
	* @return chaine de caractère permettant d'afficher l'objet
	**/
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(nb_element+"\n");
		//variables permettant le parcours de la liste 
		int nb=nb_element;
		Maillon place=tete;
		while (nb>0) {
			sb.append(place.getValeur()+"\n");
			place=place.getMaillon();
			nb--;
		}
		return sb.toString();
	}
	/**
	* Méthode permettant de retourner une chaine de caractère contenant
	* la liste des BDs de la liste 
	*
	* @return chaine de caractère contenant la liste des BDs
	**/
	public String afficheBD() {
		//initialisation des variables nécessaires au parcours
		Maillon place=tete;
		int nb=nb_element;
		int nb_bande_dessinnees=0;
		StringBuffer sb = new StringBuffer();
		Livre livre_courant;

		// parcours de toute la liste
		while (nb>0) {
			livre_courant=place.getValeur();
			// si le livre courant est une BD on l'affiche et on incrémente le nombre de BD
			if ( livre_courant instanceof BD) {
				sb.append(livre_courant+"\n");
				nb_bande_dessinnees++;
			}
			place=place.getMaillon();
			nb--;
		}
		String resultat =(nb_bande_dessinnees+"\n"+sb);
		return resultat;
	}

	/** 
	* Méthode permettant de retourner la liste contenant les livres écrits
	* par l'auteur donné en paramètre 
	* 
	* @param l'auteur recherché dans la liste des livres
	* @return la liste contenant les livres écrits par l'auteur
	**/
	public Liste rechercheAuteur(String auteur) {
		// initialisation des variables nécessaires au parcours
		Liste liste_resultat = new Liste();
		Maillon place=tete;
		int nb=nb_element;
		Livre livre_courant;
		// parcours de toute la liste
		while(nb>0) {
			livre_courant=place.getValeur();
			if (livre_courant.getAuteur().compareTo(auteur)==0)
				liste_resultat.ajouter(livre_courant);
			place=place.getMaillon();
			nb--;
		}
		return liste_resultat;
	}
	/**
	* Méthode permettant de retourner la liste contenant les livres dessinés
	* par le dessinateur donné en paramètre 
	*
	* @param le dessinateur recherché dans la liste des livres
	* @return la liste contenant les BD trouvées 
	**/
		public Liste rechercheDessinateur(String dessinateur) {
		// initialisation des variables nécessaires au parcours
		Liste liste_resultat = new Liste();
		Maillon place=tete;
		int nb=nb_element;
		Livre livre_courant;
		//parcours de toute la liste
		while(nb>0) {
			livre_courant=place.getValeur();
			/* si le livre courant est une BD on compare son dessinateur
			 au dessinateur en paramètre */
			if (livre_courant instanceof BD)
				if ( ( (BD)(livre_courant) ).getDessinateur().compareTo(dessinateur) == 0 )
					liste_resultat.ajouter(livre_courant);
			//Sinon on n'ajoute pas le livre si ce n'est pas une BD
			place=place.getMaillon();
			nb--;
		}
		return liste_resultat;
	}




}