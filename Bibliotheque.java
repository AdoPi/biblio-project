import java.io.*;
public class Bibliotheque implements Serializable {
	

	private Liste listeLivres;
	/**
	* Ce constructeur permet de créer une Bibliothèque,
	* en initialisant une nouvelle Liste
	**/
	

	public Bibliotheque() {
		listeLivres = new Liste();
	}


	/**
	* Méthode permettant d'ajouter un Roman à la bibliothèque
	* en utilisant la méthode ajouter sur la liste de livres
	**/
	public void ajouteRoman(String auteur,String titre) {
		listeLivres.ajouter(new Roman(auteur,titre));
	}


	/**
	* Méthode permettant d'ajouter un Manga à la bibliothèque
	* en utilisant la méthode ajouter sur la liste de livres
	**/
	public void ajouteManga(String auteur, String dessinateur,String titre) {
		listeLivres.ajouter(new Manga(auteur,dessinateur,titre));
	}


	/**
	* Méthode permettant d'ajouter un Comics à la bibliothèque
	* en utilisant la méthode ajouter sur la liste de livres
	**/
	public void ajouteComics(String auteur, String dessinateur,String titre) {
		listeLivres.ajouter(new Comics(auteur,dessinateur,titre));
	}


	/**
	* Méthode permettant de rechercher une liste de livres 
	* écrits par un auteur donné en paramètre
	* (Pour les BD le scénariste représente l'auteur du livre)
	* @param auteur auteur recherché 
	**/
	public void rechercheAuteur(String auteur) {
		System.out.println(listeLivres.rechercheAuteur(auteur));
	}


	/**
	* Méthode permettant de rechercher une liste de BD
	* dessinées par un dessinateur donné en paramètre
	* @param dessinateur dessinateur recherché 
	**/
	public void rechercheDessinateur(String dessinateur) {
		System.out.println(listeLivres.rechercheDessinateur(dessinateur));
	}


	/**
	* Méthode permettant d'afficher toutes les BD de la bibliothèque
	**/
	public void afficheBD() {
		System.out.println(listeLivres.afficheBD());
	}

	
	/**
	* Méthode permettant d'afficher tous les livres de la bibliothèque
	**/
	public void afficheLivres() {
		System.out.println(listeLivres);
	}

	/**
	* Méthode permettant de sauvegarder la bibliothèque dans un fichier
	* binaire dont le nom est passé en paramètre
	* @param nom nom du fichier binaire
	**/
	public void sauve(String nom) {
		try {
			ObjectOutputStream biblio=new ObjectOutputStream(new FileOutputStream(nom));
			biblio.writeObject(this);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Méthode permettant de charger une bibliothèque à partir d'un
	* binaire dont le nom est passé en paramètre
	* une fois chargée l'objet Bibliotheque est retourné par la méthode
	* @param nom nom du fichier binaire
	* @return la bibliothèque chargée à partir du fichier
	* @throws Exception
	**/

	public static Bibliotheque charge(String nom) throws Exception {
		
			ObjectInputStream fichier=new ObjectInputStream(new FileInputStream(nom));
	
			// pas de test si instanceof Biblio ...
			Bibliotheque b= (Bibliotheque)(fichier.readObject());
			fichier.close();
			return b;
	}




	/**
	* Méthode permettant de sauvegarder la bibliothèque dans un fichier
	* d'extension .csv dont le nom est passé en paramètre
	* <p>
	* l'extension du .csv est ajouté automatiquement au nom passé en paramètre
	* @param nom nom du fichier à enregistrer au format csv
	**/


	public void exporte(String nom) {
		
		try {
			BufferedWriter fichier = new BufferedWriter(new FileWriter(nom+".csv"));
				fichier.write(""+listeLivres);
				fichier.close();
		} catch(Exception e) {}
	}

	/**
	* méthode permettant le parcours d'un fichier .csv passé en paramètre
	* et qui récupère une bibliothèque si le fichier est au bon format
	* Une fois la bibliothèque récupérée, elle est retournée par la méthode
	* Si la bibliothèque est au mauvais format on déclenche l'Exception
	* MauvaisFormatException
	* <p>
	* l'extension .csv est ajouté automatiquement au nom passé en paramètre
	*
	* @param nom nom du fichier à enregistrer au format csv
	* @throws Exception
	* @return la bibliothèque importée à partir du fichier nom.csv
	**/

	public static Bibliotheque importe(String nom) throws Exception {
		BufferedReader fichier = new BufferedReader(new FileReader(nom+".csv"));
		Bibliotheque biblio = new Bibliotheque();
		try {
			String ligne;
			String mots[];
			int numeroLigne=0;

			Liste liste=biblio.listeLivres;
			// première ligne qui contient un numéro correspondant au nombre de livres
			int nb_livres=Integer.parseInt(fichier.readLine());
			// on parcourt le fichier tant qu'on a pas déclenché EOFException
			while(nb_livres>0) { // vérifier si nb_livres + grand ?

				numeroLigne++;
				ligne=fichier.readLine();
				mots=ligne.split(";");
				System.out.println(mots.length);

				// si on a une BD la taille du tableau est de 5
				if (mots.length==5)
					if (mots[0].compareTo("Manga")==0) {
						Manga manga= new Manga(mots[2],mots[3],mots[4]);
						manga.setNumero(Integer.parseInt(mots[1]));
						liste.ajouter(manga);
					}
					else if (mots[0].compareTo("Comics")==0) {
						Comics comics= new Comics(mots[2],mots[3],mots[4]);
						comics.setNumero(Integer.parseInt(mots[1]));
						liste.ajouter(comics);
					}
					else
						throw new MauvaisFormatException(numeroLigne);
				
				// sinon on a un roman
				else if(mots.length==4)
					if (mots[0].compareTo("Roman")==0) {
						Roman roman= new Roman(mots[2],mots[3]);
						roman.setNumero(Integer.parseInt(mots[1]));
						liste.ajouter(roman);
					}
					else
						throw new MauvaisFormatException(numeroLigne);
				// sinon le format n'est pas respecté
				else
					throw new MauvaisFormatException(numeroLigne);
				nb_livres--;
			}
		} catch (MauvaisFormatException e ) {
			System.out.println(e);
			// si le format n'est pas bon j'ai choisi de ne pas charger la liste même partiellement
			biblio.listeLivres=new Liste();
		} catch(EOFException e) {
		} catch (Exception e) {}
		fichier.close();
		return biblio;
	}

}