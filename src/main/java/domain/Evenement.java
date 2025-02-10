package domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Evenement {

    private Long id;
    private String nomEvent;
    private Date date;
    private String lieu;
    private String description;
    private int capacite;
    private statutEvent statut;
    private List<Ticket> tickets;
    private Organisateur organisateur;


    protected Evenement() {
    }
    

    
    public Evenement(Long id, String nomEvent, Date date, String lieu, String description, int capacite,
            statutEvent statut) {
        this.id = id;
        this.nomEvent = nomEvent;
        this.date = date;
        this.lieu = lieu;
        this.description = description;
        this.capacite = capacite;
        this.statut = statut;
    }

   
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomEvent() {
        return nomEvent;
    }
    public void setNomEvent(String nomEvent) {
        this.nomEvent = nomEvent;
    }

    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getLieu() {
        return lieu;
    }
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getCapacite() {
        return capacite;
    }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Enumerated(EnumType.STRING)
	@Column(name="Statut",length = 20)
    public statutEvent getStatut() {
        return statut;
    }
    public void setStatut(statutEvent statut) {
        this.statut = statut;
    }

    @OneToMany(mappedBy = "evenement")
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @ManyToOne
    public Organisateur getOrganisateur() {
        return organisateur;
    }


    public void setOrganisateur(Organisateur organisateur) {
        this.organisateur = organisateur;
    }


    
    
}
