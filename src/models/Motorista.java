package models;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Motorista implements Serializable {

	private static final long serialVersionUID = -7741672407549723569L;

	@Expose
	public Long id;
	
	@Expose
	public String user;
	
	@Expose
	public String password;
	
	@Expose
	public String nome;
	
	@Expose
	public Double creditos;
	
	@Expose
	public List<Carro> carros;
	
	@Expose
	public List<Recargas> recargas;
	
	@Expose
	public List<Estacionamento> estacionamentos;

}
