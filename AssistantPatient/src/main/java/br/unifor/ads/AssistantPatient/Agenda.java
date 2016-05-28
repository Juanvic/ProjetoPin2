package br.unifor.ads.AssistantPatient;

//import java.util.*;

public class Agenda {

	private double data;
	private double horario;
	private String sala; 	//private boolean status;

	public Agenda(double data, double horario, String sala) {
		super();
		this.data = data;
		this.horario = horario;
		this.sala = sala;
	}
	
	public Agenda() {
		super();
	}

	public double getData() {
		return data;
	}
	public void setData(double data) {
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
