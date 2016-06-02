package br.unifor.ads.AssistantPatient;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class TelaPerfil extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPerfil frame = new TelaPerfil();
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
	public TelaPerfil() {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setBounds(0, 0, 434, 17);
		lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPerfil);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(25, 41, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(25, 67, 46, 14);
		getContentPane().add(lblId);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(25, 101, 46, 14);
		getContentPane().add(lblLogin);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(116, 41, 46, 14);
		getContentPane().add(lblNome_1);
		
		JLabel lblIdmedico = new JLabel("Id_Medico");
		lblIdmedico.setBounds(116, 67, 81, 14);
		getContentPane().add(lblIdmedico);
		
		JLabel lblLogin_1 = new JLabel("Login");
		lblLogin_1.setBounds(116, 101, 46, 14);
		getContentPane().add(lblLogin_1);

		Connection con = new ConnectionFactory().getConnection();
        Statement stmt;
		try {
			stmt = con.createStatement();
	        String sql = "SELECT medico, login, senha FROM medicos";
	        System.out.println(sql);
	        ResultSet rs = stmt.executeQuery(sql);
	        while (rs.next()) {
	        	String bdNome = rs.getString("medico");
	        	String bdLogin = rs.getString("login");
	        
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
}
