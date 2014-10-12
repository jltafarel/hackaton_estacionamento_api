package test;

import internet.ServiceError;
import internet.WSClient;

public class Test {

	public static void main(String[] args) {

		try {
			WSClient.consultaCarro("AAA1111");
		} catch (ServiceError e) {
			e.printStackTrace();
		}
	}
}
