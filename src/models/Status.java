package models;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class Status implements Serializable {

	private static final long serialVersionUID = 754156631647946797L;

	@Expose
	public Boolean status;

	@Expose
	public Long id;

	@Expose
	public String mensagem;

}
