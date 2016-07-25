package photoapplication.config;

public class Constants{
	public static final String FILE = "file";

	public static final String RESOURCES = "/resourses/";
	public static final String BOOTSTRAP = RESOURCES + "bootstrap/";
	public static final String BOOTSTRAP_CSS = BOOTSTRAP + "css/";
	public static final String BOOTSTRAP_JS = BOOTSTRAP + "js/";
	public static final String BOOTSTRAP_MIN_JS = BOOTSTRAP_JS + "bootstrap.min.js";
	public static final String JQUERY = RESOURCES + "jquery/";
	public static final String JQUERY_JS = JQUERY + "jquery.js";
	public static final String BOOTSTRAP_MIN_CSS = BOOTSTRAP_CSS + "bootstrap.min.css";
	public static final String VIEWS = RESOURCES + "views/";
	public static final String FILENAME = "fileName";
	public static final String GALERY_PAGE = "gallery/index";
	public static final String LOGIN_URL = "login";
	/**
	 * 
	 */
	private static final long serialVersionUID = -3369945285761308314L;
	public static final String UPLOAD_URL = "upload";
	public static final String USER = "user";
	public static final String USER_PAGE_URL = "userPage/userPage";
	public static final String WORKING_AREA = "working_area";
	
	public static void main(String ...args){
		System.out.println(RESOURCES);
		System.out.println(BOOTSTRAP);
		System.out.println(BOOTSTRAP_MIN_CSS);
		System.out.println(VIEWS);
		System.out.println(BOOTSTRAP_CSS);
	}
	
}
