package test;

import internet.ServiceError;
import internet.WSClient;

public class Test {

	public static void main(String[] args) {

		try {
			WSClient.setAuth("jltafarel@gmail.com:1123581321fibo");
			WSClient.consultaCarro("AAA1111");
		} catch (ServiceError e) {
			e.printStackTrace();
		}
	}
}
