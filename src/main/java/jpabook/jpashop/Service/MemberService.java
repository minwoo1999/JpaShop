package jpabook.jpashop.Service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor// 이게 autowired 까지 해주는구나 생성자 까지 만드니까
public class MemberService {


    private final MemberRepository memberRepository;



    //회원가입,
    @Transactional
    public Long join(Member member){
        validateDuplidateMember(member);
        memberRepository.save(member);
        return member.getId();
    }


    //중복확인
    private void validateDuplidateMember(Member member){

        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()){
            throw  new IllegalStateException("이미 존재하는 회원입니다");
        }


    }



    // 회원전체조회

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //한건조회
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }


    @Transactional
    public void update(Long id,String name){
        Member member=memberRepository.findOne(id);
        member.setName(name);
    }



}
