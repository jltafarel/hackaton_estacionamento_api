package models;


import java.io.Serializable;

import json.GsonParser;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;


public class Retorno implements Serializable{

	private static final long serialVersionUID = 8699873314425442180L;

	@Expose
	private String tipo = "ERRO";
	
	@Expose
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Retorno(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public static String create(String msg){
		final Gson gson = GsonParser.newInstance();
		return gson.toJson(new Retorno(msg));
	}
	
	public static Retorno fromJSON(String json){
		final Gson gson = GsonParser.newInstance();
		return gson.fromJson(json, Retorno.class);
	}
	
}
