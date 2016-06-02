package br.unifor.ads.AssistantPatient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.Font;

public class TelaPaciente extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTable tabelaPaciente;
	
	List<String> item;
	List<List<String>> listOfLists;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPaciente frame = new TelaPaciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPaciente() {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 34, 434, 236);
		getContentPane().add(scrollPane);
		
		tabelaPaciente = new JTable();
		scrollPane.setViewportView(tabelaPaciente);
		
		DefaultTableModel model = new DefaultTableModel(){
			
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		model.addColumn("IdPaciente");
		model.addColumn("Paciente");
		model.addColumn("CPF");
		model.addColumn("Telefone");
		model.addColumn("Acompanhante");
		
		Connection con = new ConnectionFactory().getConnection();
        Statement stmt;
		try {
			stmt = con.createStatement();
	        String sql = "SELECT id_paciente, paciente, cpf, telefone, acompanhante FROM pacientes";
	        System.out.println(sql);
	        ResultSet rs = stmt.executeQuery(sql);
	        while (rs.next()) {
	        	int bdIdPaciente = rs.getInt("id_paciente");
	        	String bdPaciente = rs.getString("paciente");
	        	String bdCpf = rs.getString("cpf");
	        	String bdAcompanhante = rs.getString("acompanhante");
	        	String bdTelefone = rs.getString("telefone");
	        	
	        	model.addRow(new Object[] {bdIdPaciente,bdPaciente,bdCpf,bdTelefone,bdAcompanhante});
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		tabelaPaciente.setModel(model);
		
		JLabel lblPacientesCadastrados = new JLabel("Pacientes Cadastrados");
		lblPacientesCadastrados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPacientesCadastrados.setBounds(124, 9, 165, 14);
		getContentPane().add(lblPacientesCadastrados);
		
		
	}
}
