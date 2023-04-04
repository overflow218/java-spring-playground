package com.overflow218;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        /**
         * persistence.xml에 persistence이름이 뭔지 정의해놨는데 그 값을 가져다가 사용함
         * jpa에서는 persistence 가 엄청나게 중요한 개념임. persistence를 생성하고 이를 활용하기 위해서
         * emf에서 em을 매번 생성해서 persistence에 접근하고 처리하는 그런 방식으로 작동할거임
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em =  emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            // insert
            Member member1 = new Member();
            member1.setId(3435L);
            member1.setName("howdoeysdofk");
            em.persist(member1);

            Member member2 = new Member();
            member2.setId(7879L);
            member2.setName("howdk");
            em.persist(member2);


            System.out.println("==============리스트로 불러와요");
            // 쿼리로 리스트 불러오기
            List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();
            for (Member member : result) {
                System.out.println("name :: " + member.getName());
            }
            tx.commit();
        } catch (Exception e)
        {
            System.out.println("exception 떳음@@");
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
        /**
         * em안에 persitence가 붙는거라는 개념은 잘 배웠지?
         * 요 안에서 1차 캐시가 많은 역할을 해줌. 사실 성능적으로 크게 이득을 보는건 없지만
         * 개념적으로 잘 알아두어야 확실한 응용이 가능함.
         * 무조건 트랜잭션 시작으로 시작해서 commit으로 끝내야 한다는점.
         * 상황에 따라 이전에 플러시가 일어날때도 있지만 기본적으로는 commit시점에
         * 한번에 sql로 쿼리를 보낸다는점 잘 알아두자!
         * 그리고 중요한 한가지 더
         * 무조건 끝날때는 entity manager factory, entity manager 다 다시 close해줘야함
         * 내부적으로 커넥션 풀같은게 들어있어서 안 끝내주면 나중에 풀이 부족해서 문제가 발생할 수도 이씀.
         *
         */

    }
}
