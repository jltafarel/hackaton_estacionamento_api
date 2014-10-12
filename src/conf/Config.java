package conf;

public class Config {

	private static String usernameAcademia;
	private static String passwordAcademia;

	private static final String host = "http://localhost";
	private static final String host2 = "http://hackatonestacionamento.herokuapp.com";
	private static final Integer port = 80;

	static {
		usernameAcademia = "jltafarel@gmail.com";
		passwordAcademia = "1123581321fibo";
	}

	public static String getUsernameAcademia() {
		return usernameAcademia;
	}

	public static String getPasswordAcademia() {
		return passwordAcademia;
	}

	public static String getURLService() {
		return host2 + (port != null ? ":" + port : "");
		// return "http://localhost:8080" + "/academia/rest";
	}

	public static String getHost() {
		return host;
	}

}
