package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {
    
    private long id;
    private double prix;
    private int numPlace;
    private boolean estValide;

    
    protected Ticket() {
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
}
 