package br.unifor.ads.AssistantPatient;

//import java.util.*;

public class Consulta {

	private long id;
	private String especialidade;
	private String diagnostico;
	private String plano_saude;
	private long valor;
	private String consultorio;

	public Consulta(long id, String especialidade, String diagnostico, String plano_saude, long valor,
			String consultorio) {
		super();
		this.id = id;
		this.especialidade = especialidade;
		this.diagnostico = diagnostico;
		this.plano_saude = plano_saude;
		this.valor = valor;
		this.consultorio = consultorio;
	}
	
	public Consulta(String especialidade, String diagnostico, String plano_saude, long valor, String consultorio) {
		super();
		this.especialidade = especialidade;
		this.diagnostico = diagnostico;
		this.plano_saude = plano_saude;
		this.valor = valor;
		this.consultorio = consultorio;
	}
	
	public Consulta() {
		super();
	}

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
