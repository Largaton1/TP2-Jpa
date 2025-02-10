package domain;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("Administrateur")
public class Administrateur extends Personne {

    private long id;
    private List<Evenement> evenement;
    
    protected Administrateur() {
    }

    public Administrateur(long id, List<Evenement> evenement) {
        super();
        this.id = id;
        this.evenement = evenement;
    }
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "administrateur")
    public List<Evenement> getEvenement() {
        return evenement;
    }
    public void setEvenement(List<Evenement> evenement) {
        this.evenement = evenement;
    }
    
}
