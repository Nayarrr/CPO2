package Tournay.Rayan.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livres")
public class Livre{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "titre")
    private String titre;
    @ManyToOne
    @JoinColumn(name = "auteur_id")
    private Auteur auteur;
    @ManyToOne
    @JoinColumn(name = "editeur_id")
    private Editeur editeur;
    @Column(name = "lu")
    private boolean lu;

    public Livre() {}

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