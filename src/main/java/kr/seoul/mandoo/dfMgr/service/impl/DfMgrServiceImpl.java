package kr.seoul.mandoo.dfMgr.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.seoul.mandoo.dfMgr.entity.Member;
import kr.seoul.mandoo.dfMgr.repository.MemberRepository;
import kr.seoul.mandoo.dfMgr.service.DfMgrService;

@Service
public class DfMgrServiceImpl implements DfMgrService{

	@Resource
	MemberRepository memberRepository;
	
	@Override
	public Member getMember(Map<Object, String> param) {
		
		String userId = param.get("userId").toString();
		String password = param.get("password").toString();
		
		Member findMember = new Member();
		findMember = memberRepository.findByUserIdAndPassword(userId, password);
		
		if(findMember == null) {
			return null;
		}else {
			return findMember;
		}
	}
	
	@Override
	public Long createMember(Map<Object, String> param) {
		
		String userId = param.get("userId").toString();
		String firstName = param.get("firstName").toString();
		String lastName = param.get("lastName").toString();
		String email = param.get("email").toString();
		String password = param.get("password").toString();

		Member newMember = new Member();
		
		Member existMember = memberRepository.findByUserId(userId);
		if(existMember == null) {
			newMember.setUserId(userId);
			newMember.setFirstname(firstName);
			newMember.setLastname(lastName);
			newMember.setEmail(email);
			newMember.setPassword(password);

			memberRepository.save(newMember);
		}else {
			return null;
		}
		
		return newMember.getId();
	}

	@Override
	public Long updateMember(Map<Object, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long deleteMember(Map<Object, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long createKeyword(Map<Object, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long updateKeyword(Map<Object, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long deleteKeyword(Map<Object, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

}
