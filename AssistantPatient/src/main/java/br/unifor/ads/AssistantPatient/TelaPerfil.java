package br.unifor.ads.AssistantPatient;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

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
		lblNome.setBounds(25, 81, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(25, 119, 46, 14);
		getContentPane().add(lblId);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(25, 163, 46, 14);
		getContentPane().add(lblLogin);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(81, 81, 46, 14);
		getContentPane().add(lblNome_1);
		
		JLabel lblIdmedico = new JLabel("Id_Medico");
		lblIdmedico.setBounds(81, 119, 81, 14);
		getContentPane().add(lblIdmedico);
		
		JLabel lblLogin_1 = new JLabel("Login");
		lblLogin_1.setBounds(81, 163, 46, 14);
		getContentPane().add(lblLogin_1);

	}
}
