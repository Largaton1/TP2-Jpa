package dao;

import domain.Evenement;

public class EvenementDao extends AbstractJpaDao<Long, Evenement> {
    public EvenementDao() {
        super(Evenement.class);
    }
    
}
