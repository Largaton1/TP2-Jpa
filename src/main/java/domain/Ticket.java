package domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {
    
    private long id;
    private double prix;
    private int numPlace;
    private boolean estValide;
    
    private Evenement evenement;
    private Client client;

    

    public Ticket() {
    }

    public Ticket(long id, double prix, int numPlace, boolean estValide) {
        this.id = id;
        this.prix = prix;
        this.numPlace = numPlace;
        this.estValide = estValide;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public int getNumPlace() {
        return numPlace;
    }
    public void setNumPlace(int numPlace) {
        this.numPlace = numPlace;
    }
    public boolean isEstValide() {
        return estValide;
    }
    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }



    @ManyToOne
    @JoinColumn(name = "evenement_id", nullable = false)  // Clé étrangère
    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }


    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
 