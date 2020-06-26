package hellojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import jdk.nashorn.internal.codegen.MethodEmitter;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();

    tx.begin();
    try {

      Album album = new Album();
      album.setMusician("MCR");
      album.setName("Welcome to the black parade");

      em.persist(album);

      em.flush();
      em.clear();

      Album album1 = em.find(Album.class, album.getId());
      System.out.println("album1 = " + album1);

      tx.commit();



    }catch(Exception e){
      tx.rollback();
    }finally {
      em.close();
    }
    emf.close();
  }

}
