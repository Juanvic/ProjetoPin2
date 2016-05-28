package br.unifor.ads.AssistantPatient;

//import java.util.*;

public class Medico {
	
	private long id;
	private String nome;
	private String login;
	private String senha;
	private int crm;
	private String telefone;
	private String especialidades;
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Medico(long id, String nome, int crm, String telefone, String especialidades) {	
		this(nome, crm, telefone, especialidades);
		this.id = id;
	}
	
	public Medico(String nome, int crm, String telefone, String especialidades) {
		super();
		this.nome = nome;
		this.crm = crm;
		this.telefone = telefone;
		this.especialidades = especialidades;
	}

	public Medico() {
		super();
	}

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
	public int getCrm() {
		return crm;
	}
	public void setCrm(int crm) {
		this.crm = crm;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(String especialidades) {
		this.especialidades = especialidades;
	}

}
