package Tournay.Rayan.model;
import jakarta.persistence.*;

@Entity
@Table(name = "livres")
public class Livre{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "titre")
    private String titre;
    @Column(name = "auteur")
    private Auteur auteur;
    @Column(name = "editeur")
    private Editeur editeur;
    @Column(name = "lu")
    private boolean lu;

    public Livre(String titre, Auteur auteur, Editeur editeur, boolean lu) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.lu = lu;
    }

    public String getTitre() {
        return this.titre;
    }

    public Auteur getAuteur() {
        return this.auteur;
    }

    public Editeur getEditeur() {
        return this.editeur;
    }

    public boolean isLu() {
        return this.lu;
    }

    public int getId() {
        return this.id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public void setLu(boolean lu) {
        this.lu = lu;
    }
}