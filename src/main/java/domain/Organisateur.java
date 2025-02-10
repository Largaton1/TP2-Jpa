package domain;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("Organisateur")
public class Organisateur extends Personne {
    private long id;
    private List<Evenement> evenements;

    protected Organisateur() {
    }

    public Organisateur(long id, List<Evenement> evenements) {
        super();
        this.id = id;
        this.evenements = evenements;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "organisateur")
    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }

   

    
}
