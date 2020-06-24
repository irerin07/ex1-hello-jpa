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
//      데이터 추가
//      Member member = new Member();
//      member.setId(2l);
//      member.setName("HelloB");
//      em.persist(member);
//      데이터 조회
//      Member member = em.find(Member.class, 1l);
//      System.out.println(member.getId());
//      System.out.println(member.getName());

//      데이터 변경
//      Member member = em.find(Member.class, 1l);
//      member.setName("helloJPA");
//      System.out.println(member.getId());
//      System.out.println(member.getName());

      List<Member> allMember = em.createQuery("select m from Member as m ", Member.class)
          .setFirstResult(5)
          .setMaxResults(10)
          .getResultList();

      for(Member m: allMember){
        System.out.println("member.id= " + m.getId());
        System.out.println("member.name= " + m.getName());
      }

      tx.commit();



    }catch(Exception e){
      tx.rollback();
    }finally {
      em.close();
    }
    emf.close();
  }

}
