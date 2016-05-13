package br.unifor.pin2.AssistantPatient;

import java.util.*;

public class Paciente {
	
	private long id;
	private String nome;
	private String cpf;
	private String contato;
	private String nome_acompanhante;
	private String ficha_medica;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getNome_acompanhante() {
		return nome_acompanhante;
	}
	public void setNome_acompanhante(String nome_acompanhante) {
		this.nome_acompanhante = nome_acompanhante;
	}
	public String getFicha_medica() {
		return ficha_medica;
	}
	public void setFicha_medica(String ficha_medica) {
		this.ficha_medica = ficha_medica;
	}
	
	
	
}
