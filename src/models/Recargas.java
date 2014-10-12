package models;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.annotations.Expose;

public class Recargas implements Serializable {

	private static final long serialVersionUID = 2045171404580713397L;

	@Expose
	public Long id;

	@Expose
	public Date data;

	@Expose
	public Double valor;
}
