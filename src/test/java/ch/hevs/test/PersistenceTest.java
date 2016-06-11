package ch.hevs.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import ch.hevs.businessobject.*;




public class PersistenceTest {

	@Test
	public void test() {
		EntityTransaction tx = null;

		try
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("travelPU");
			EntityManager em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Passenger p1 = new Passenger("Yannick","Romailler");
			Passenger p2 = new Passenger("Marlène","Duc");
			Passenger p3 = new Passenger("Suzanne","Huuu");
			Passenger p4 = new Passenger("Charlotte","AuFraise");
			/*-----------------------------------------------------------------------------------*/
			Flight f1 = new Flight("KLM", "KL 1963", 150);
			Flight f2 = new Flight("Lufthansa", "LH 1198", 150);
			Flight f3 = new Flight("SWISS", "LX 3611", 100);
			Flight f4 = new Flight("Air France", "AF 1314", 100);
			
			/*-----------------------------------------------------------------------------------*/
			Departure d1 = new Departure("LHR", "England", "London","21.06.2016", "18:00");
			Departure d2 = new Departure("BIA", "France", "Bastia","18.08.2016", "12:00");
			Departure d3 = new Departure("JKF", "USA", "New York","23.10.2016", "22:00");

			/*-----------------------------------------------------------------------------------*/
			Destination des1 = new Destination("EDI", "Scotland", "Edinburgh","22.06.2016", "05:00");
			Destination des2 = new Destination("BIA", "France", "Bastia","19.08.2016", "16:00");
			Destination des3 = new Destination("JKF", "USA", "New York","24.10.2016", "05:00");
			
			/*-----------------------------------------------------------------------------------*/
			
			p1.addFlight(f1);
			p1.addFlight(f4);
			p2.addFlight(f2);
			p3.addFlight(f3);
			p4.addFlight(f4);
			p4.addFlight(f2);
			
			
			/*-----------------------------------------------------------------------------------*/

			d1.addFlight(f3);
			d3.addFlight(f4);
			d3.addFlight(f2);
			d2.addFlight(f1);
			
			/*-----------------------------------------------------------------------------------*/
			
			des1.addFlight(f3);
			des2.addFlight(f4);
			des3.addFlight(f2);
			des2.addFlight(f1);
			
			/*-----------------------------------------------------------------------------------*/
			
			f1.addPassenger(p2);
			f2.addPassenger(p2);
			f3.addPassenger(p4);
			f4.addPassenger(p3);
			f4.addPassenger(p1);
			f4.addPassenger(p2);
			
			/*-----------------------------------------------------------------------------------*/
			
			
			em.persist(des1);
			em.persist(des2);
			em.persist(des3);
			
			em.persist(d1);
			em.persist(d2);
			em.persist(d3);
			
			em.persist(f1);
			em.persist(f2);
			em.persist(f3);
			em.persist(f4);
			
			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.persist(p4);
			

			
			em.flush();
				
			
			tx.commit();

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}



	}
}