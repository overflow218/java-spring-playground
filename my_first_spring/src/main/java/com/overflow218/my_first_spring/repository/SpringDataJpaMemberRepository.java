package com.overflow218.my_first_spring.repository;

import com.overflow218.my_first_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

// 이게 자동으로 생성되어서 스프링 빈에 주입됨. 그래서 spring config 쪽에서 찾아다가 사용할 수 있음.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    Optional<Member> findByName(String name);
}
