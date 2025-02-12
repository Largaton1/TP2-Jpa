package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dao.ClientDao;
import dao.TicketDao;
import domain.Administrateur;
import domain.Client;
import domain.Ticket;
import dto.ClientDto;
import dto.EvenementDto;
import dto.TicketDto;

public class ClientService {
    
    private ClientDao clientDao;
    private TicketDao ticketDao;

    public ClientService() {
        clientDao = new ClientDao();
        ticketDao = new TicketDao();
    }


    public ClientDto createClient(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setEmail(clientDto.getEmail());
        client.setPassword(clientDto.getPassword());
        clientDao.save(client);
        return new ClientDto(client.getId(), client.getNom(), client.getPrenom(), client.getEmail(), client.getPassword(), null);
    }


     public ClientDto getClientById(Long id) {
        Client client = clientDao.findOne(id);
        if (client!=null) {
            
            List<TicketDto> tickets = client.getTicket().stream()
                .map(ticket -> new TicketDto(ticket.getId(), ticket.getPrix(), ticket.getNumPlace(), ticket.isEstValide(), 
                new EvenementDto(ticket.getEvenement().getId(), 
                    ticket.getEvenement().getNomEvent(), 
                    ticket.getEvenement().getDate(), 
                    ticket.getEvenement().getLieu(), 
                    ticket.getEvenement().getDescription(), 
                    ticket.getEvenement().getCapacite(), 
                    ticket.getEvenement().getStatut(), 
                    null,  // Pas besoin de la liste des tickets ici
                    null   // Organisateur non inclus pour éviter les références circulaires
                ),  
                    new ClientDto(ticket.getClient().getId(), ticket.getClient().getNom(), ticket.getClient().getPrenom(),
                                ticket.getClient().getEmail(), ticket.getClient().getPassword(), null)
                    ))
                .collect(Collectors.toList());

            return new ClientDto(client.getId(), client.getNom(), client.getPrenom(), client.getEmail(), client.getPassword(), tickets);
        }
        return null;
    }

    public List<ClientDto> getAllClients() {
        List<Client> clients = clientDao.findAll();
        return clients.stream().map(client -> 
            new ClientDto(client.getId(), client.getNom(), client.getPrenom(), client.getEmail(), client.getPassword(), null)) 
            .collect(Collectors.toList());
    }
    

    public ClientDto updateClient(Long id, ClientDto clientDto) {
        Client client = clientDao.findOne(id);
        if (client != null) {
            client.setNom(clientDto.getNom());
            client.setPrenom(clientDto.getPrenom());
            client.setEmail(clientDto.getEmail());
            client.setPassword(clientDto.getPassword());
            clientDao.update(client);
            return new ClientDto(client.getId(), client.getNom(), client.getPrenom(),
                                 client.getEmail(), client.getPassword(),null);
        }
        return null;
    }

    // Supprimer un client
    public void deleteClient(long id) {
        Client client = clientDao.findOne(id);
        if (client != null) {
            clientDao.delete(client);
        }
    }
}
