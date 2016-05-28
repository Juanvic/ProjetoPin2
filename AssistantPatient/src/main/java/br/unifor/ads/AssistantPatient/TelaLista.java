package br.unifor.ads.AssistantPatient;

//import java.awt.BorderLayout;
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

public class TelaLista extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable tabelaLista;
	
	List<String> item;
	List<List<String>> listOfLists;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLista frame = new TelaLista();
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
	public TelaLista() {
		setClosable(true);
		setBounds(100, 100, 739, 433);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(73, 61, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(6, 66, 61, 16);
		getContentPane().add(lblNewLabel);
		
		tabelaLista = new JTable();
		DefaultTableModel model = new DefaultTableModel(){

			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		model.addColumn("Médico");
		model.addColumn("Login");

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
	        	
	        	model.addRow(new Object[] {bdNome,bdLogin});
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}

		tabelaLista.setModel(model);
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(6, 108, 703, 279);
		scroll.setViewportView(tabelaLista);
		getContentPane().add(scroll);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 1, 800, 53);
		getContentPane().add(menuBar);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Teste 1");
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Teste 2");
		mntmNewMenuItem.setIcon(new ImageIcon(TelaLista.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		menuBar.add(mntmNewMenuItem);
		

	}
}
