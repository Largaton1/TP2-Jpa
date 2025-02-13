package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.domain.Evenement;

public class EvenementDao extends AbstractJpaDao<Long, Evenement> {
    public EvenementDao() {
        super(Evenement.class);
    }
    
}
