package br.unifor.ads.AssistantPatient;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private static TelaPrincipal p;
	
	public static TelaPrincipal getInstancia(){
		if (p == null){
			p = new TelaPrincipal();
		}
		return p;
	}

	private String nomeMedico;
	private int idMedico;
	
	
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JInternalFrame subWindow;
	private JMenu mnConsultas;
	private JMenuItem mntmListaConsultas;
	private JMenu mnMedicos;
	private JMenuItem mntmPerfil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getInstancia().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 597);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnConsultas = new JMenu("Consultas");

		mnConsultas.setEnabled(false);
		menuBar.add(mnConsultas);
		
		mntmListaConsultas = new JMenuItem("Lista Consultas");
		mntmListaConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLista tLista = new TelaLista();
				centerWindow(tLista);
				desktopPane.add(tLista);
				tLista.setVisible(true);
				subWindow = tLista;
			}
		});
		mnConsultas.add(mntmListaConsultas);
		
		mnMedicos = new JMenu("Médico");
		
		mnMedicos.setEnabled(false);
		menuBar.add(mnMedicos);
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPerfil tPerfil = new TelaPerfil();
				centerWindow(tPerfil);
				desktopPane.add(tPerfil);
				tPerfil.setVisible(true);
				subWindow = tPerfil;
			}
		});
		mntmPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		mnMedicos.add(mntmPerfil);
		contentPane = new JPanel();
		contentPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				centerWindow(subWindow);
			}
		});
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBorder(null);
		desktopPane.setBackground(SystemColor.scrollbar);
		this.getContentPane().add(desktopPane);
		
		TelaDeLogin tLogin = new TelaDeLogin();
		centerWindow(tLogin);
		desktopPane.add(tLogin);
		tLogin.setVisible(true);
		
		subWindow = tLogin;
		
		//contentPane.add((desktopPane, BorderLayout.EAST);
	}

	public void centerWindow(JInternalFrame window){
		Dimension desktopSize = this.getSize();
		Dimension windowSize = window.getSize();
		int wPos = (desktopSize.width - windowSize.width)/2;
		int hPos = (desktopSize.height - windowSize.height)/2;
		window.setLocation(wPos,hPos);
	}
	
	public void fecharJanela() {
		//desktopPane.remove(0);
		desktopPane.getSelectedFrame().dispose();
	}
	
	public void habilitaMenus(){
		mnConsultas.setEnabled(true);
		mnMedicos.setEnabled(true);
	}
	
	public void dadosMedico(String nome, int id){
		mnMedicos.setText(nome);
		nomeMedico = nome;
		idMedico = id;
	}
	
}
