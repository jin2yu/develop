package kr.seoul.mandoo.dfMgr.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.seoul.mandoo.dfMgr.entity.Keyword;
import kr.seoul.mandoo.dfMgr.entity.Member;
import kr.seoul.mandoo.dfMgr.repository.KeywordRepository;
import kr.seoul.mandoo.dfMgr.repository.MemberRepository;
import kr.seoul.mandoo.dfMgr.service.DfMgrService;

@Service
public class DfMgrServiceImpl implements DfMgrService{

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	KeywordRepository keywordRepository;
	
	
	@Override
	public Member getMember(Map<Object, String> param) {
		
		String userId = param.get("userId").toString();
		String password = param.get("password").toString();
		
		Member findMember = new Member();
		findMember = memberRepository.findByIdAndPassword(userId, password);
		
		if(findMember == null) {
			return null;
		}else {
			return findMember;
		}
	}
	
	@Override
	public String createMember(Map<Object, String> param) {
		
		String userId = param.get("userId").toString();
		String firstName = param.get("firstName").toString();
		String lastName = param.get("lastName").toString();
		String email = param.get("email").toString();
		String password = param.get("password").toString();

		Member newMember = new Member();
		
		Member existMember = memberRepository.getOne(userId);
		if(existMember == null) {
			newMember.setId(userId);
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
	public String updateMember(Map<Object, String> param) {
		String userId = param.get("userId").toString();
		String firstName = param.get("firstName").toString();
		String lastName = param.get("lastName").toString();
		String email = param.get("email").toString();
		String password = param.get("password").toString();

		Member member = memberRepository.getOne(userId);
		
		member.setFirstname(firstName);
		member.setLastname(lastName);
		member.setEmail(email);
		member.setPassword(password);
		
		return member.getId();
	}

	@Override
	public String deleteMember(Map<Object, String> param) {
		
		String userId = param.get("userId").toString();
		String password = param.get("password").toString();

		Member member = memberRepository.findByIdAndPassword(userId, password);
		
		memberRepository.delete(member);
		
		return "delete success";
	}

	@Override
	public String createKeyword(Map<Object, String> param) {
		String userId = param.get("userId").toString();
		String keyword = param.get("keyword").toString();
		
		Member member = memberRepository.getOne(userId);
		
		Keyword key = new Keyword();
		key.setKeyword(keyword);
		key.setMember(member);
		
		return "success : " + keyword;
	}

	@Override
	public Long updateKeyword(Map<Object, String> param) {
		Long keyId = Long.valueOf(param.get("id"));
		String keyword = param.get("keyword").toString();
		
		Keyword key = keywordRepository.getOne(keyId);
		key.setKeyword(keyword);
		
		return key.getId();
	}

	@Override
	public Long deleteKeyword(Map<Object, String> param) {
		Long keyId = Long.valueOf(param.get("id"));
		keywordRepository.deleteById(keyId);
		return keyId;
	}

}
