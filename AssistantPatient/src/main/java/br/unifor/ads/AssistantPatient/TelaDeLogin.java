package br.unifor.ads.AssistantPatient;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaDeLogin extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField campoLogin;
	private JTextField campoSenha;
	private JLabel lblSenha;
	private TelaPrincipal p;
	
	private JButton btnEntrar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeLogin frame = new TelaDeLogin();
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
	public TelaDeLogin() {
		setBounds(100, 100, 305, 210);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		campoLogin = new JTextField();
		campoLogin.setBounds(100, 28, 173, 26);
		contentPane.add(campoLogin);
		campoLogin.setColumns(10);
		
		campoSenha = new JPasswordField();
		campoSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					btnEntrar.requestFocus();
					realizaLogin();
				}
			}
		});

		campoSenha.setBounds(100, 66, 173, 26);
		contentPane.add(campoSenha);
		campoSenha.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(27, 33, 61, 16);
		contentPane.add(lblLogin);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(27, 71, 61, 16);
		contentPane.add(lblSenha);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizaLogin();
			}
		});
		btnEntrar.setBounds(27, 117, 246, 45);
		contentPane.add(btnEntrar);
		
		
	}
	
	public void realizaLogin(){
		
        String txtLogin = campoLogin.getText().toString();
		String txtSenha = campoSenha.getText().toString();

		try {
			Connection con = new ConnectionFactory().getConnection();
	        Statement stmt = con.createStatement();
	        String sql = "SELECT medico, senha, id_medico FROM medicos WHERE login = '" + txtLogin + "'";
	        System.out.println(sql);
	        ResultSet rs = stmt.executeQuery(sql);
	        if (rs.next()) {
	        	String bdNome = rs.getString("medico");
	        	String bdSenha = rs.getString("senha");
	        	int bdId = rs.getInt("id_medico");
	        	System.out.println(bdNome + " (" + bdSenha + ")");
	        	if (txtSenha.equals(bdSenha)){
	        		System.out.println("Tentando fechar...");
	        		p = TelaPrincipal.getInstancia();
	        		p.dadosMedico(bdNome, bdId);
	        		p.habilitaMenus();
	        		this.dispose();
	        	} else {
	        		System.out.println("Senha incorreta!");
	        		msg("Senha incorreta!", "ERRO");
	        		campoSenha.setText("");
	        		campoSenha.requestFocus();
	        	}
	        } else {
	        	System.out.println("Falha no Login");
	        	msg("Login incorreto!", "ERRO");
        		campoLogin.setText("");
        		campoSenha.setText("");
        		campoLogin.requestFocus();
	        }
	        con.close();
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("ERRO");
		}
		
		
		
	}

	public void msg(String txt,String titulo){
		JOptionPane.showMessageDialog(null, txt, titulo, JOptionPane.PLAIN_MESSAGE);
	}
}
