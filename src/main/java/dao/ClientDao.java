package dao;

import java.util.List;

import domain.Client;

public class ClientDao extends AbstractJpaDao<Long, Client> {
    public ClientDao() {
        super(Client.class);
    }

    
    //tout les clients qui sont proprietaire d'un ticket 
    public List<Client> getUserWithOwnerTicket() {
            
        String query = "SELECT distinc k.owner FROM Client as k";
        return this.entityManager.createQuery(query).getResultList();
        
    }
}
