package kr.seoul.mandoo.dfMgr.service;

import java.util.Map;

import kr.seoul.mandoo.dfMgr.entity.Member;

public interface DfMgrService {

	public Member getMember(Map<Object, String> param);
	
	public Long createMember(Map<Object, String> param);
	public Long updateMember(Map<Object, String> param);
	public Long deleteMember(Map<Object, String> param);
	
	public Long createKeyword(Map<Object, String> param);
	public Long updateKeyword(Map<Object, String> param);
	public Long deleteKeyword(Map<Object, String> param);
	
}
