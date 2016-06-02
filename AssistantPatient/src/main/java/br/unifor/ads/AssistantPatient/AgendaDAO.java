package br.unifor.ads.AssistantPatient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AgendaDAO {
	
//	  Data no mySQL
//    String dateStr = "28 June 2009";
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//    System.out.println(sdf.format(new Date(dateStr)));
	
	Connection con = new ConnectionFactory().getConnection();
    PreparedStatement stmt;

	public List<Agenda> listarTodos() {
		List<Agenda> listaObj = new ArrayList<Agenda>();
		String sql = "SELECT DATE_FORMAT(data,'%d/%m/%Y') as data_formatada, sala FROM agendas";
		System.out.println(sql);
		try {
			stmt = con.prepareStatement(sql);
			// stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	        	// Pegando as informações do banco
	        	String bdSala = rs.getString("sala");
	        	String bdData = rs.getString("data_formatada");
	        	System.out.println("Data: " + bdData + " - Sala: " + bdSala + "");
	        	// Criando o objeto com os dados
	        	Agenda agd = new Agenda();
	        	agd.setData(bdData);
	        	agd.setSala(bdSala);
	        	// Adicionando o objeto na lista
	        	listaObj.add(agd);
	        }
	        return listaObj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Quantidade de objetos: " + listaObj.size());
		return listaObj;
	}
	
	public String[][] listToArray(List<Agenda> listaObj) { // String[][]
		int qtdColunas = 2;
		int qtdObjetos = listaObj.size();
		System.out.println("Quantidade de objetos: " + qtdObjetos + " - Colunas: " + qtdColunas + "");

		String[][] meuArr = new String[qtdObjetos][qtdColunas];
		
		for (int i = 0; i < qtdObjetos; i++) {
			Agenda agd = listaObj.get(i);

			// 0-Data, 1-Sala
			meuArr[i][0] = agd.getData();
			meuArr[i][1] = agd.getSala();
		}
		return meuArr;
	}

	public void incuir(Agenda agenda) {
		String sala = agenda.getSala();
		String data = agenda.getData();
		java.sql.Date dataAgenda = java.sql.Date.valueOf(data);
		String sql = " INSERT into agenda (data, sala) values (?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, dataAgenda);
			stmt.setString (2, sala);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Agenda agenda, int id) {
		String sala = agenda.getSala();
		String data = agenda.getData();
		java.sql.Date dataAgenda = java.sql.Date.valueOf(data);
		String sql = "UPDATE agenda SET data = ?, sala = ? WHERE id_agenda = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, dataAgenda);
			stmt.setString (2, sala);
			stmt.setInt(3, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remover(int id) {
		String sql = "DELETE FROM agenda WHERE id_agenda = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
