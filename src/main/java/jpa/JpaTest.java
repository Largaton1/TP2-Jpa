package jpa;

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

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			EntityManager manager = EntityManagerHelper.getEntityManager();

		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			//Personne user = new Personne();
			Administrateur admin = new Administrateur();
			Organisateur organisateur = new Organisateur();
			Client client = new Client();
			Evenement event = new Evenement();
			Ticket ticket = new Ticket();
			EntityManagerHelper.getEntityManager().persist(admin);
			EntityManagerHelper.getEntityManager().persist(organisateur);
			EntityManagerHelper.getEntityManager().persist(event);
			EntityManagerHelper.getEntityManager().persist(ticket);
			EntityManagerHelper.getEntityManager().persist(client);

			// TODO create and persist entity
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

			
   	 manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}




}
