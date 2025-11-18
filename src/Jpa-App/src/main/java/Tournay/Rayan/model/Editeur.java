package Tournay.Rayan.model;
import jakarta.persistence.*;

@Entity
@Table(name = "editeurs")
public class Editeur{
    @Id
    private int id;
    @Column(name = "nom_edition")
    private String nomEdition;

    public Editeur(int id, String nomEdition) {
        this.id = id;
        this.nomEdition = nomEdition;
    }

    public String getNomEdition() {
        return this.nomEdition;
    }

    public int getId() {
        return this.id;
    }

    public void setNomEdition(String nomEdition) {
        this.nomEdition = nomEdition;
    }
}