package models;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Carro implements Serializable {

	private static final long serialVersionUID = -1563801817724691986L;

	@Expose
	public Long id;

	@Expose
	public String placa;

	@Expose
	public String descricao;

	@Expose
	public List<Estacionamento> estacionamentos;

}
