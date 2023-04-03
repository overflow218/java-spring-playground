package com.overflow218.my_first_spring.service;

import com.overflow218.my_first_spring.domain.Member;
import com.overflow218.my_first_spring.repository.MemberRepository;
import com.overflow218.my_first_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     *회원가입
     * option + command + v를 누르면 리팩토링을 해서 바로 결과를 뽑아낼 수 잇음
     * ctl + t 누르면 메쏘드 뽑아낼 수 있음
     */

    public Long join(Member member){

        validate(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validate(Member member) {
        memberRepository.findByName(member.getName())
        .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}