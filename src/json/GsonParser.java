package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonParser {

	public static GsonBuilder newInstanceBuilder() {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("dd/MM/yyyy");
		gsonBuilder.excludeFieldsWithoutExposeAnnotation();

		//		IDENTACAO
		//		gsonBuilder.setPrettyPrinting();

		return gsonBuilder;
	}

	public static Gson newInstance() {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("dd/MM/yyyy");

		Gson gson = gsonBuilder.excludeFieldsWithoutExposeAnnotation().create();

		return gson;
	}

}
