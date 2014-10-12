package models;

import java.io.Serializable;
import java.security.Timestamp;

import com.google.gson.annotations.Expose;

public class Estacionamento implements Serializable {

	private static final long serialVersionUID = 9155279136710191011L;
	
	@Expose
	public Long id;
	
	@Expose
	public Timestamp data_inicio;
	
	@Expose 
	public Timestamp data_final;

}
