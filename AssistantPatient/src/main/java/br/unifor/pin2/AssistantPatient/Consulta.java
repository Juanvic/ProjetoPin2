package br.unifor.pin2.AssistantPatient;

import java.util.*;

public class Consulta {

	private long id;
	private String especialidade;
	private String diagnostico;
	private String plano_saude;
	private long valor;
	private String consultorio;//local da consulta
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getPlano_saude() {
		return plano_saude;
	}
	public void setPlano_saude(String plano_saude) {
		this.plano_saude = plano_saude;
	}
	public long getValor() {
		return valor;
	}
	public void setValor(long valor) {
		this.valor = valor;
	}
	public String getConsultorio() {
		return consultorio;
	}
	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}
	
	
	
}
