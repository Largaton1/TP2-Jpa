package domain;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("Administrateur")
public class Administrateur extends Personne implements Serializable {

    private long id;
    private List<Evenement> evenement;
    
    public Administrateur() {
    }

    public Administrateur(long id, List<Evenement> evenement) {
        super();
        this.id = id;
        this.evenement = evenement;
    }
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "administrateur", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Evenement> getEvenement() {
        return evenement;
    }
    public void setEvenement(List<Evenement> evenement) {
        this.evenement = evenement;
    }
    
}
