// classe principale permettant de tester l'application Bibliothèque
public class Test {

	public static void main(String args[]) {

		/* ------- Tests sur la classe Bibliothèque -------- */

		//Création d'une bibliothèque
		Bibliotheque biblio = new Bibliotheque();

		/* Affichage des livres de la bibliothèque vide.
		 Affichage attendue : 
		 l'affichage doit comporter seulement un 0 qui indique que la bibliothèque est vide */


		biblio.afficheLivres();


		//Test d'ajout quand la bibliothèque est vide : ajout d'un livre à la bibliothèque
		biblio.ajouteRoman("auteur_roman_test","titre_roman_test");

		//on affiche de nouveau le contenu de la bibliothèque et on vérifie si on a bien le numéro 1
		// qui indique que la bibliothèque contient bien un livre 
		// et qu'elle contient le Roman que l'on vient d'ajouter 
		// l'affichage attendue est donc :
		//Roman;1;auteur_roman_test;titre_roman_test
		// ( id=1 car c'est le premier livre créé)


		biblio.afficheLivres();


		// Test d'ajouts de livres de différents types ( Roman, Manga, Comics)
		biblio = new Bibliotheque();
		biblio.ajouteRoman("auteur_roman_test","titre_roman_test");
		biblio.ajouteManga("manga_test_titre","manga_test_scenariste","manga_test_dessinateur");
		biblio.ajouteComics("comics_test_titre","comics_test_scenariste","comics_test_dessinateur");
		
		// on affiche le contenu de la bibliothèque pour vérifier que le résultat 
		// comporte bien les trois livres créés
		// Résultat attendu :
		// 3
		//Comics;4;comics_test_titre;comics_test_scenariste;comics_test_dessinateur
		//Manga;3;manga_test_titre;manga_test_scenariste;manga_test_dessinateur
		//Roman;2;auteur_roman_test;titre_roman_test
		
		biblio.afficheLivres();


		/* Test de l'affichage des BD à l'aide de la méthode afficheBD()
		 On doit donc avoir 2 BD qui s'affichent à l'écran pour cette Bibliothèque
		 Résultat attendu :
		 2
		 Comics;4;comics_test_titre;comics_test_scenariste;comics_test_dessinateur
		 Manga;3;manga_test_titre;manga_test_scenariste;manga_test_dessinateur */
		
		biblio.afficheBD();


		/* création de plusieurs livres ayant le même auteur pour pouvoir tester la
		 recherche de livres par auteur */
		 biblio.ajouteManga("manga_test_titre2","auteur_cherche","manga_test_dessinateur2");
		 biblio.ajouteRoman("titre_roman_test2","auteur_cherche");
		 biblio.ajouteComics("comics_test_titre","auteur_cherche","comics_test_dessinateur2");
		 biblio.ajouteManga("manga_test_titre3","auteur_cherche","manga_test_dessinateur3");

		/* Test de la méthode pour afficher les livres écrits par le même auteur,
		 la méthode rechercheAuteur doit afficher tous les livres écrits par l'auteur
		 en paramètre.
		 Résultat attendu : 
		 4
		 Manga;5;manga_test_titre2;auteur_cherche;manga_test_dessinateur2
		 Roman;6;titre_roman_test2;auteur_cherche
		 Comics;7;comics_test_titre;auteur_cherche;comics_test_dessinateur2
		 Manga;8;manga_test_titre3;auteur_cherche;manga_test_dessinateur3 */
		  

		  biblio.rechercheAuteur("auteur_cherche");


		/* Test de la méthode rechercheAuteur avec un auteur qui n'existe pas dans la bibliothèque 
		 Aucun livre ne doit apparaître et juste un "0" correspondant au nombre de livres trouvés
		 doit être affiché */

		  biblio.rechercheAuteur("auteur_inconnu");


		/* création de plusieurs BD ayant le même dessinateur pour pouvoir tester la
		 recherche de livres par dessinateur */
		 biblio.ajouteManga("manga_test_titre4","manga_test_scenariste2","dessinateur_cherche");
		 biblio.ajouteComics("comics_test_titre2","comics_test_scenariste2","dessinateur_cherche");
		 biblio.ajouteManga("manga_test_titre5","manga_test_scenariste3","dessinateur_cherche");

		/* Test de la méthode pour afficher les livres écrits par le même dessinateur,
		 la méthode rechercheDessinateur doit afficher tous les livres écrits par l'dessinateur
		 en paramètre.
		 Résultat attendu : 
		 3
		 Manga;9;manga_test_titre4;manga_test_scenariste2;dessinateur_cherche
		 Comics;10;comics_test_titre2;comics_test_scenariste2;dessinateur_cherche
		 Manga;11;manga_test_titre5;manga_test_scenariste3;dessinateur_cherche */

		  

		biblio.rechercheDessinateur("dessinateur_cherche");


		/* Test de la méthode rechercheDessinateur avec un dessinateur qui n'existe pas dans la bibliothèque 
		 Aucun livre ne doit apparaître et juste un "0" correspondant au nombre de livres trouvés
		 doit être affiché */

		biblio.rechercheDessinateur("dessinateur_inconnu");


		// Sauvegarde de la bibliothèque afin de tester la charge et la sauvegarde 
		biblio.sauve("fichier_sauvegarde");

		/* On efface le contenu de la bibliothèque en créant un nouvel objet Bibliothèque
		 et on affiche le contenu de la bibliothèque pour vérifier que la bibliothèque 
		 est bien vide. */
		biblio=new Bibliotheque();
		biblio.afficheLivres();
		/* Une fois le contenu de la bibliothèque effacé, on charge le fichier sauvegardé
		 précédemment pour tester si la sauvegarde a bien fonctionné (on teste la charge
		 par la même occasion) */
		
		try {
			biblio=Bibliotheque.charge("fichier_sauvegarde");
		} catch(Throwable e) { e.printStackTrace();}

		/* On affiche la bibliothèque pour vérifier si le contenu est bien le même que précedemment
		Résultat attendu :
		 10
		 Manga;11;manga_test_titre5;manga_test_scenariste3;dessinateur_cherche
		 Comics;10;comics_test_titre2;comics_test_scenariste2;dessinateur_cherche
		 Manga;9;manga_test_titre4;manga_test_scenariste2;dessinateur_cherche
		 Manga;8;manga_test_titre3;auteur_cherche;manga_test_dessinateur3
		 Comics;7;comics_test_titre;auteur_cherche;comics_test_dessinateur2
		 Roman;6;titre_roman_test2;auteur_cherche
		 Manga;5;manga_test_titre2;auteur_cherche;manga_test_dessinateur2
		 Comics;4;comics_test_titre;comics_test_scenariste;comics_test_dessinateur
		 Manga;3;manga_test_titre;manga_test_scenariste;manga_test_dessinateur
		 Roman;2;auteur_roman_test;titre_roman_test */

		biblio.afficheLivres();


		// Exportation de la bibliothèque afin de tester l'exportation et l'importation
		biblio.exporte("fichier_sauvegarde_CSV");

		/* On efface le contenu de la bibliothèque en créant un nouvel objet Bibliothèque
		 et on affiche le contenu de la bibliothèque pour vérifier que la bibliothèque 
		 est bien vide. */
		biblio=new Bibliotheque();
		biblio.afficheLivres();

		/* Une fois le contenu de la bibliothèque effacé, on importe la bibliothèque contenue
		 dans le  fichier sauvegardé précédemment pour tester si la sauvegarde a bien fonctionné
		 (on teste l'importation par la même occasion) */
		
		try {
			biblio=Bibliotheque.importe("fichier_sauvegarde_CSV");
		} catch(Throwable e) { e.printStackTrace();}

		/* On affiche la bibliothèque pour vérifier si le contenu est bien le même que précedemment
		 Résultat attendu : 
		 10
		 Roman;2;auteur_roman_test;titre_roman_test
		 Manga;3;manga_test_titre;manga_test_scenariste;manga_test_dessinateur
		 Comics;4;comics_test_titre;comics_test_scenariste;comics_test_dessinateur
		 Manga;5;manga_test_titre2;auteur_cherche;manga_test_dessinateur2
		 Roman;6;titre_roman_test2;auteur_cherche
		 Comics;7;comics_test_titre;auteur_cherche;comics_test_dessinateur2
		 Manga;8;manga_test_titre3;auteur_cherche;manga_test_dessinateur3
		 Manga;9;manga_test_titre4;manga_test_scenariste2;dessinateur_cherche
		 Comics;10;comics_test_titre2;comics_test_scenariste2;dessinateur_cherche
		 Manga;11;manga_test_titre5;manga_test_scenariste3;dessinateur_cherche */
		 
		 biblio.afficheLivres();

		 /* Création d'un fichier contenant une erreur pour tester MauvaisFormatException
		  on utilise le fichier "fichier_erreur_ligne.csv"
		  */
		try {
		  	biblio=Bibliotheque.importe("fichier_erreur_ligne");
		} catch (Exception e ) {}
		 /* Résultat attendue :
		  L'écran doit afficher une erreur dans le fichier ligne 2 */

		// créer fichier avec faux nombre de ligne, et plusieurs ;


		/* ------- Tests sur la classe Liste -------- */


		// Création d'un tableau de livre qui sera utilisé pour les différents tests
		Livre[] tableau_tests = new Livre[3];
		tableau_tests[0]=new Manga("manga_test_titre","manga_test_scenariste","manga_test_dessinateur");
		tableau_tests[1]=new Comics("comics_test_titre","comics_test_scenariste","comics_test_dessinateur");
		tableau_tests[2]=new Roman("auteur_roman_test","titre_roman_test");

		//Test de suppression d'une liste vide


		// test de suppression


	}
}