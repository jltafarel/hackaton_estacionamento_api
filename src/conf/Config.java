package conf;

public class Config {

	private static String usernameAcademia;
	private static String passwordAcademia;

	private static final String host = "http://localhost";
	private static final Integer port = 3000;

	static {
		usernameAcademia = "inventto2";
		passwordAcademia = "tablets!@#";
	}

	public static String getUsernameAcademia() {
		return usernameAcademia;
	}

	public static String getPasswordAcademia() {
		return passwordAcademia;
	}

	public static String getURLService() {
		return host + (port != null ? ":" + port : "");
		// return "http://localhost:8080" + "/academia/rest";
	}

	public static String getHost() {
		return host;
	}

}
