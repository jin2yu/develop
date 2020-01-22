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
		Long memberId = dfMgrService.createMember(params);
		
		if(memberId != null) {
			return "success";
		}else {
			return "already exist";
		}
	}
	
	@RequestMapping(value=UrlMap.USER_UPDATE_URL, method = RequestMethod.POST)
	public void userUpdate(@RequestBody Map<Object, String> params) {
		log.info("DfMgrController.userUpdate()");
	}
	
	@RequestMapping(value=UrlMap.USER_DELETE_URL, method = RequestMethod.POST)
	public void userDelete(@RequestBody Map<Object, String> params) {
		log.info("DfMgrController.userDelete()");
	}
	
	@RequestMapping(value=UrlMap.KEYWORD_CREATE_URL, method = RequestMethod.POST)
	public void keyCreate(@RequestBody Map<Object, String> params) {
		log.info("DfMgrController.keyCreate()");
	}
	
	@RequestMapping(value=UrlMap.KEYWORD_UPDATE_URL, method = RequestMethod.POST)
	public void keyUpdate(@RequestBody Map<Object, String> params) {
		log.info("DfMgrController.keyUpdate()");
	}
	
	@RequestMapping(value=UrlMap.KEYWORD_DELETE_URL, method = RequestMethod.POST)
	public void keyDelete(@RequestBody Map<Object, String> params) {
		log.info("DfMgrController.keyDelete()");
	}
}
