package project.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.shop.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
}
