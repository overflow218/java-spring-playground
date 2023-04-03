package com.overflow218.my_first_spring.repository;

import com.overflow218.my_first_spring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    /**
     * 이제 jpa를 활용할때는 모든 쿼리를 다 em을 통해서 할거임
     */
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        // persist가 영속하다 그런뜻이잖아
        // 디비에 넣어준다는 의미임
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long Id) {
        /*
         * 이게 초 강력한 기능임.
         * find, findById, findByIdAndName 약간 이런식으로
         * 기본적인게 다 구현이 되어있음.
         * 나중에는 규칙에 맞게 확장해나갈수도 있고 없으면
         * 그때가서 sql 쿼리 날리면 됨.
         */
        Member member = em.find(Member.class, Id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 직접 쿼리쓸때도 완전 sql은 아니고 객체를 기준으로 쿼리를 걸수있음. 되게 신기하다
        List<Member> result = em.createQuery("select m from Member m where m.name = :name",
                Member.class).setParameter("name", name).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}

