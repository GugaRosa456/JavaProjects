package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Controller.CadastroProdutosController;
import Controller.Navegador;
import Controller.Supermercado;
import model.ProdutosDAO;

public class Janelas extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private CardLayout cardLayout;

    public Login login;
    private ListarProdutos listarProdutos;
    private ComprarProdutos comprarProdutos;
    private MostrarProdutos mostrarProdutos;
    private CadastroUsuarios cadastroUsuarios;
    private CadastroProdutos cadastroProdutos;
    private Pagamento pagamento;

    private CadastroProdutosController cadastroProdutosController;
    private ProdutosDAO produtosDAO;

    public static final String LOGIN_PANEL = "telaLogin";
    public static final String CADASTROPRODUTOS_PANEL = "cadastroProdutos";
    public static final String COMPRAR_PANEL = "comprarProdutos";
    public static final String LISTAR_PANEL = "telalistar";
    public static final String USUARIOS_PANEL = "telausuarios";
    public static final String MOSTRAR_PANEL = "mostrarProdutos";
    public static final String PAGAMENTO_PANEL = "pagamento";

    public Janelas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);
        
        
        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        contentPane.setPreferredSize(new Dimension(500, 350));
        setContentPane(contentPane);

        login = new Login(this);
        listarProdutos = new ListarProdutos(this);
        comprarProdutos = new ComprarProdutos(this);
        mostrarProdutos = new MostrarProdutos(this);
        cadastroUsuarios = new CadastroUsuarios(this);
        cadastroProdutos = new CadastroProdutos(this);
        pagamento = new Pagamento(this);
        this.produtosDAO = new ProdutosDAO();

        cadastroProdutosController = new CadastroProdutosController(cadastroProdutos, getProdutosDAO(), mostrarProdutos, new Navegador(this), new Supermercado());

        contentPane.add(login, LOGIN_PANEL);
        contentPane.add(listarProdutos, LISTAR_PANEL);
        contentPane.add(comprarProdutos, COMPRAR_PANEL);
        contentPane.add(mostrarProdutos, MOSTRAR_PANEL);
        contentPane.add(cadastroUsuarios, USUARIOS_PANEL);
        contentPane.add(cadastroProdutos, CADASTROPRODUTOS_PANEL);
        contentPane.add(pagamento, PAGAMENTO_PANEL);

        mostrarTela(LOGIN_PANEL);
    }
    
    

    public void mostrarTela(String panelName) {
        cardLayout.show(contentPane, panelName);
    }

    public void adicionarTela(String nome, JPanel tela) {
        this.contentPane.add(tela, nome);
    }

    public ListarProdutos getListarProdutos() {
        return this.listarProdutos;
    }

    public ComprarProdutos getComprarProdutos() {
        return this.comprarProdutos;
    }

    public MostrarProdutos getMostrarProdutos() {
        return this.mostrarProdutos;
    }

    public CadastroUsuarios getCadastroUsuarios() {
        return this.cadastroUsuarios;
    }

    public CadastroProdutos getCadastroProdutos() {
        return this.cadastroProdutos;
    }

    public Pagamento getPagamento() {
        return this.pagamento;
    }

    public Login getLogin() {
        return this.login;
    }

    public ProdutosDAO getProdutosDAO() {
        return this.produtosDAO;
    }

    public CadastroProdutosController getCadastroProdutosController() {
        return this.cadastroProdutosController;
    }
}