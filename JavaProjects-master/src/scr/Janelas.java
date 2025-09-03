package scr;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Janelas extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private CardLayout cardLayout;
	
	private Login  login;
	private CadastroProdutos cadastroProdutos;
	private ComprarProdutos  comprarProdutos;
	
	public static final String LOGIN_PANEL = "telaLogin";
	public static final String CADASTROPRODUTOS_PANEL = "telaCadastroProdutos";
	public static final String COMPRAR_PANEL = "telaCompra";
	
    private String currentUser;
	
    public Janelas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		cardLayout = new CardLayout();
	    
		contentPane = new JPanel(cardLayout);
	    contentPane.setPreferredSize(new Dimension(500, 200));
	    
	   login = new Login(this);
	   cadastroProdutos = new CadastroProdutos(this);
	   comprarProdutos = new ComprarProdutos(this);
	   
	   contentPane.add(login, LOGIN_PANEL);
	   contentPane.add(cadastroProdutos, CADASTROPRODUTOS_PANEL);
	   contentPane.add(comprarProdutos, COMPRAR_PANEL);
	   
		setContentPane(contentPane);
	   
		mostrarTela(LOGIN_PANEL);
	   
	}
    public void mostrarTela(String panelName) {
        cardLayout.show(contentPane, panelName);
    }

}
