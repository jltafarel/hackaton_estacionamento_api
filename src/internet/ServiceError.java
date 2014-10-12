package internet;

public class ServiceError extends Throwable{
	
	private static final long serialVersionUID = -6756441957224604750L;
	
	private String responseCode;

	public String getResponseCode() {
		return responseCode;
	}

	public ServiceError(String responseCode, String message) {
		super(message);
		this.responseCode = responseCode;
	}
	
	public ServiceError(Throwable throwable) {
		super(throwable);
		this.responseCode = "-1";
	}

	public ServiceError(String responseCode, String message, Throwable throwable) {
		super(message, throwable);
		this.responseCode = responseCode;
	}

}
