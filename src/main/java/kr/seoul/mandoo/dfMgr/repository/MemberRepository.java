package kr.seoul.mandoo.dfMgr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.seoul.mandoo.dfMgr.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	public Member findByIdAndPassword(String userId, String password);
}
