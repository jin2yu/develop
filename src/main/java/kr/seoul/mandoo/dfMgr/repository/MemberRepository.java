package kr.seoul.mandoo.dfMgr.repository;

import org.springframework.data.repository.CrudRepository;

import kr.seoul.mandoo.dfMgr.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {

	public Member findByUserIdAndPassword(String userId, String password);
	public Member findByUserId(String UserId);
}
