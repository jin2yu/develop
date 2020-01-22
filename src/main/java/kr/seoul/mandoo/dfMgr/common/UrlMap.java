package kr.seoul.mandoo.dfMgr.common;

public class UrlMap {

	public static final String VERSION = "/v1";
	
	public static final String USER = VERSION + "/user";
	public static final String KEYWORD = VERSION + "/keyword";
	
	public static final String USER_LOGIN_URL = USER + "/login";
	public static final String USER_CREATE_URL = USER + "/create";
	public static final String USER_UPDATE_URL = USER + "/update";
	public static final String USER_DELETE_URL = USER + "/delete";
	
	public static final String KEYWORD_CREATE_URL = KEYWORD + "/create";
	public static final String KEYWORD_UPDATE_URL = KEYWORD + "/update";
	public static final String KEYWORD_DELETE_URL = KEYWORD + "/delete";
}
