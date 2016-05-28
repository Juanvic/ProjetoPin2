package br.unifor.ads.AssistantPatient;

//import java.util.*;

public class Paciente {
	
	private long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String nome_acompanhante;
	private String ficha_medica;
	
	
	public Paciente(long id, String nome, String cpf, String telefone, String nome_acompanhante, String ficha_medica) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.nome_acompanhante = nome_acompanhante;
		this.ficha_medica = ficha_medica;
	}
	
	
	public Paciente(String nome, String cpf, String telefone, String nome_acompanhante, String ficha_medica) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.nome_acompanhante = nome_acompanhante;
		this.ficha_medica = ficha_medica;
	}

	public Paciente() {
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((ficha_medica == null) ? 0 : ficha_medica.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nome_acompanhante == null) ? 0 : nome_acompanhante.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (ficha_medica == null) {
			if (other.ficha_medica != null)
				return false;
		} else if (!ficha_medica.equals(other.ficha_medica))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nome_acompanhante == null) {
			if (other.nome_acompanhante != null)
				return false;
		} else if (!nome_acompanhante.equals(other.nome_acompanhante))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Paciente [id=").append(id).append(", nome=").append(nome).append(", cpf=").append(cpf)
				.append(", telefone=").append(telefone).append(", nome_acompanhante=").append(nome_acompanhante)
				.append(", ficha_medica=").append(ficha_medica).append("]");
		return builder.toString();
	}
	
	
	
}
