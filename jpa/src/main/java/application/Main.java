package application;

import domain.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person(null, "Davi Cristian Mariano", "davi.fakedomain.com");
        Person p2 = new Person(null, "James Smith", "james@fakedomain.com");
        Person p3 = new Person(null, "Ana Morgan", "ana@fakedomain.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_project");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();

    }
}