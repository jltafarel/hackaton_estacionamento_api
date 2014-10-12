package models;

import java.io.Serializable;
import java.sql.Timestamp;

import com.google.gson.annotations.Expose;

public class Estacionamento implements Serializable {

	private static final long serialVersionUID = 9155279136710191011L;
	
	@Expose
	public Long id;
	
	@Expose
	public String data_inicio;
	
	@Expose 
	public String data_final;

}
