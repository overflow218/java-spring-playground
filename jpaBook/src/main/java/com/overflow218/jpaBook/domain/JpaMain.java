package com.overflow218.jpaBook.domain;

import net.bytebuddy.jar.asm.TypeReference;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();
            Member member = new Member();
            member.setName("hj");
            entityManager.persist(member);

            Order order = new Order();
            order.setMember(member);
            entityManager.persist(order);

            tx.commit();
        } catch(Exception e)
        {
            System.out.println("error 발생======" + e.getMessage());
            System.out.println(e);
            tx.rollback();
        } finally {

            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
