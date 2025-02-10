package jpa;

import dao.EvenementDao;
import domain.Administrateur;
import domain.Evenement;
import domain.Organisateur;
import domain.Personne;
import domain.Ticket;
import domain.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JpaTest {


	private EntityManager manager;

	/* public JpaTest(EntityManager manager) {
		this.manager = manager;
	} */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* 	EntityManager manager = EntityManagerHelper.getEntityManager();

		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin(); */

		
		try {
		
			Evenement event = new Evenement();
			EvenementDao dao = new EvenementDao();
			event.setNomEvent("Concert Geant");
			event.setCapacite(10);
			event.setAdministrateur(null);
			event.setOrganisateur(null);
			EntityManagerHelper.getEntityManager().persist(event);
			dao.save(event);
			/* Administrateur admin = new Administrateur();
			Organisateur organisateur = new Organisateur();
			Client client = new Client();
			Evenement event = new Evenement();
			Ticket ticket = new Ticket(); */
			/* EntityManagerHelper.getEntityManager().persist(admin);
			EntityManagerHelper.getEntityManager().persist(organisateur);
			EntityManagerHelper.getEntityManager().persist(event);
			EntityManagerHelper.getEntityManager().persist(ticket);
			EntityManagerHelper.getEntityManager().persist(client); */

			// TODO create and persist entity
		} catch (Exception e) {
			e.printStackTrace();
		}
		/* tx.commit();

			
   	 manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done"); */
	}




}
