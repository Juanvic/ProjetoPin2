package br.unifor.ads.AssistantPatient;

//import java.util.*;

public class Agenda {

	private String data;
	private double horario;
	private String sala; 	//private boolean status;

	public Agenda(String data, double horario, String sala) {
		super();
		this.data = data;
		this.horario = horario;
		this.sala = sala;
	}
	
	public Agenda() {
		super();
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public double getHorario() {
		return horario;
	}
	public void setHorario(double horario) {
		this.horario = horario;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	
}
