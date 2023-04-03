package com.overflow218.my_first_spring.service;

import com.overflow218.my_first_spring.domain.Member;
import com.overflow218.my_first_spring.repository.MemberRepository;
import com.overflow218.my_first_spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // 일단 저렇게 memberRepository 넣어주는걸 dependency injectino이라고 부름
    // 매번 테스트실행마다 초기화된 환경에서 실행하는 것을 보장해줌
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    /**
     * 테스트에 한해서만 밖으로 나가는거 아니니까 직관적으로 한국어로 써도 좋음
     * 또한 given (주어진 상황에서) when (어떤 실행을 했을때) then (어떤 결과가 나온다)
     * 위와 같은 3단으로 작성하는 습관을 들여주면 좋음
     * */

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberRepository.findById(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() throws Exception{
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}