package kr.seoul.mandoo.dfMgr.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.seoul.mandoo.dfMgr.common.UrlMap;
import kr.seoul.mandoo.dfMgr.entity.Member;
import kr.seoul.mandoo.dfMgr.service.DfMgrService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DfMgrController {

	@Resource
	DfMgrService dfMgrService;
	
	@RequestMapping(value=UrlMap.USER_LOGIN_URL, method = RequestMethod.POST)
	public String login(@RequestBody Map<Object, String> params) {
		log.info("DfMgrController.login()");
		Member findMember = dfMgrService.getMember(params);
		String result = "";
		if(findMember != null) {
			result = "login success";
		}else {
			result = "not exist member or not matched password";
		}
		return result;
	}
	
	@RequestMapping(value=UrlMap.USER_CREATE_URL, method = RequestMethod.POST)
	public String signup(@RequestBody Map<Object, String> params) {
		log.info("DfMgrController.signup()");
		String userId = dfMgrService.createMember(params);
		
		if(userId != null) {
			return userId + " success";
		}else {
			return userId + "already exist";
		}
	}
	
	@RequestMapping(value=UrlMap.USER_UPDATE_URL, method = RequestMethod.POST)
	public String userUpdate(@RequestBody Map<Object, String> params) {
		log.info("DfMgrController.userUpdate()");
		String userId = dfMgrService.updateMember(params);
		
		return userId + " info update success";
		
	}
	
	@RequestMapping(value=UrlMap.USER_DELETE_URL, method = RequestMethod.POST)
	public String userDelete(@RequestBody Map<Object, String> params) {
		log.info("DfMgrController.userDelete()");
		
		return dfMgrService.deleteMember(params);
	}
	
	@RequestMapping(value=UrlMap.KEYWORD_CREATE_URL, method = RequestMethod.POST)
	public String keyCreate(@RequestBody Map<Object, String> params) {
		log.info("DfMgrController.keyCreate()");
		return dfMgrService.createKeyword(params);
	}
	
	@RequestMapping(value=UrlMap.KEYWORD_UPDATE_URL, method = RequestMethod.POST)
	public Long keyUpdate(@RequestBody Map<Object, String> params) {
		log.info("DfMgrController.keyUpdate()");
		return dfMgrService.updateKeyword(params);
	}
	
	@RequestMapping(value=UrlMap.KEYWORD_DELETE_URL, method = RequestMethod.POST)
	public void keyDelete(@RequestBody Map<Object, String> params) {
		log.info("DfMgrController.keyDelete()");
		dfMgrService.deleteKeyword(params);
		
	}
}
