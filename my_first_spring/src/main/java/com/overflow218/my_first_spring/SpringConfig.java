package com.overflow218.my_first_spring;

import com.overflow218.my_first_spring.aop.TimeTraceAop;
import com.overflow218.my_first_spring.repository.*;
import com.overflow218.my_first_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
//    private final DataSource dataSource;
//    private final EntityManager em;

    private final MemberRepository memberRepository;
    private final TimeTraceAop timeTraceAop;

    public SpringConfig(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
        this.timeTraceAop = new TimeTraceAop();
    }


//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }

//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
