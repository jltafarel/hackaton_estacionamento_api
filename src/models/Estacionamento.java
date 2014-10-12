package models;

import java.io.Serializable;
import java.security.Timestamp;

import com.google.gson.annotations.Expose;

public class Estacionamento implements Serializable {

	private static final long serialVersionUID = 9155279136710191011L;
	
	@Expose
	private Long id;
	
	@Expose
	private Timestamp data_inicio;
	
	@Expose 
	private Timestamp data_final;

}
