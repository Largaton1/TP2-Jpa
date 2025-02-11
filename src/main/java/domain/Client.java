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
@DiscriminatorValue("Client")
public class Client extends Personne implements Serializable {

    private long id;
    private List<Ticket> ticket;


    public Client() {
    }
    
    public Client(long id, List<Ticket> ticket) {
        super();
        this.id = id;
        this.ticket = ticket;
    }
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Ticket> getTicket() {
        return ticket;
    }
    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }
   
   
}
