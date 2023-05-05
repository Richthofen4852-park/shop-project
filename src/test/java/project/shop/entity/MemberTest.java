package project.shop.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import project.shop.repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
@SpringBootTest
class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @PersistenceContext
    EntityManager em;

    @DisplayName("Auditing 테스트")
    @WithMockUser(username = "gildong", roles = "USER")
    @Test
    public void auditingTest() {
        Member member = new Member();
        memberRepository.save(member);

        em.flush();
        em.clear();

        Member findMember = memberRepository.findById(member.getId()).orElseThrow(EntityNotFoundException::new);

        System.out.println("findMember.getRegTime() = " + findMember.getRegTime());
        System.out.println("findMember.getUpdateTime() = " + findMember.getUpdateTime());
        System.out.println("findMember.getCreatedBy() = " + findMember.getCreatedBy());
        System.out.println("findMember.getModifiedBy() = " + findMember.getModifiedBy());
    }
}