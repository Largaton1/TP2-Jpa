package dto;

import java.util.List;

import domain.Ticket;

public class ClientDto extends PersonneDto{
    
    //private long id;
    private List<TicketDto> ticket;



    public ClientDto() {
        super();
    }

    public ClientDto(long id,String nom, String prenom, String email, String password, List<TicketDto> ticket) {
        super(id, nom, prenom, email, password);
        
        this.ticket = ticket;
    }

   
    public List<TicketDto> getTicket() {
        return ticket;
    }
    public void setTicket(List<TicketDto> ticket) {
        this.ticket = ticket;
    }
}
