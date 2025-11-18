package Tournay.Rayan;
import Tournay.Rayan.model.*;
import Tournay.Rayan.dao.*;

public class App{
    public static void main( String[] args ){
        BibliothequeDAO biblioDAO = new BibliothequeDAO();

        Auteur auteur1 = new Auteur(1, "Hugo", "Victor");
        Editeur editeur1 = new Editeur(1, "Penguin Classics");
        Livre livre1 = new Livre("Les Misérables", auteur1, editeur1, false);

        Livre livreRecherche = biblioDAO.getLivreParId(livre1.getId());
        System.out.println("Livre recherché: " + livreRecherche.getTitre());
        livre1.setLu(true);

        Livre livre2 = new Livre("Les Travailleurs de la mer", auteur1 , editeur1, true);

        System.out.println("Tous les livres dans la bibliothèque:" + biblioDAO.getTousLesLivres());

        biblioDAO.deleteLivre(livre2.getId());

        biblioDAO.close();
    }
}
