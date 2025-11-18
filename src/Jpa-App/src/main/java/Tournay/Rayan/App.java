package Tournay.Rayan;
import Tournay.Rayan.dao.BibliothequeDAO;
import Tournay.Rayan.model.Auteur;
import Tournay.Rayan.model.Editeur;
import Tournay.Rayan.model.Livre;

public class App{
    public static void main( String[] args ){
        BibliothequeDAO biblioDAO = new BibliothequeDAO();

        // Créer les objets
        Auteur auteur1 = new Auteur(1, "Hugo", "Victor");
        Editeur editeur1 = new Editeur(1, "Penguin Classics");
        
        // SAUVEGARDER d'abord l'auteur et l'éditeur
        biblioDAO.ajouterAuteur(auteur1);
        biblioDAO.ajouterEditeur(editeur1);
        
        // Maintenant créer et sauvegarder le livre
        Livre livre1 = new Livre("Les Misérables", auteur1, editeur1, false);
        biblioDAO.ajouterLivre(livre1);

        Livre livreRecherche = biblioDAO.getLivreParId(livre1.getId());
        System.out.println("Livre recherché: " + livreRecherche.getTitre());
        
        livre1.setLu(true);

        Livre livre2 = new Livre("Les Travailleurs de la mer", auteur1, editeur1, true);
        biblioDAO.ajouterLivre(livre2);

        System.out.println("Tous les livres dans la bibliothèque: " + biblioDAO.getTousLesLivres());

        biblioDAO.deleteLivre(livre2.getId());
        biblioDAO.close();
    }
}