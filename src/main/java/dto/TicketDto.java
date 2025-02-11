package dto;

import domain.Evenement;

public class TicketDto {
    
    private long id;
    private double prix;
    private int numPlace;
    private boolean estValide;
    
    private EvenementDto evenement;
    private ClientDto client;

    public TicketDto() {
    }

    public TicketDto(long id, double prix, int numPlace, boolean estValide, EvenementDto evenement, ClientDto client) {
        this.id = id;
        this.prix = prix;
        this.numPlace = numPlace;
        this.estValide = estValide;
        this.evenement = evenement;
        this.client = client;
    }

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
    public EvenementDto getEvenement() {
        return evenement;
    }
    public void setEvenement(EvenementDto evenement) {
        this.evenement = evenement;
    }
    public ClientDto getClient() {
        return client;
    }
    public void setClient(ClientDto client) {
        this.client = client;
    }
}
