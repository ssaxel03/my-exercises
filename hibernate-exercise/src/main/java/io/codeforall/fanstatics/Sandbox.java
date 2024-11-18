package io.codeforall.fanstatics;

import javax.persistence.*;
public class Sandbox {

    public static void main(String[] args) {

        // Use the test persistence unit to configure a new
        // entity manager factory and start up JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        // Open a new database connection by getting a new
        // entity manager from the entity manager factory
        EntityManager em = emf.createEntityManager();

        Cadet cadet = new Cadet();
        cadet.setId(1);
        cadet.setName("Andersão");
        cadet.setAge(18);

        em.getTransaction().begin();
        em.persist(cadet);
        em.getTransaction().commit();





        // Close the database connection
        em.close();

        // Shutdown JPA
        emf.close();

    }

}
