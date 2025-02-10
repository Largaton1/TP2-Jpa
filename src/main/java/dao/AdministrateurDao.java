package dao;

import domain.Administrateur;

public class AdministrateurDao extends AbstractJpaDao<Long, Administrateur> {
    public AdministrateurDao() {
        super(Administrateur.class);
    }
    
}
