package Controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produtos;
import model.ProdutosDAO;
import model.Usuario;
import model.UsuarioDAO;
import view.ComprarProdutos;
import view.Janelas;
import view.ListarProdutos;
import view.Pagamento;

public class PagamentoController {

	private ProdutosDAO model;
	private Pagamento view;
	private Usuario model2;
	private UsuarioDAO usuarioDAO;
	private Carrinho carrinho; 
	private Navegador navegador;
	private ListarProdutos view3;

	public PagamentoController(ProdutosDAO model, Pagamento view, Usuario model2, UsuarioDAO usuarioDAO,
			Carrinho carrinho, Navegador navegador, ListarProdutos view3) {
		this.model = model;
		this.view = view;
		this.model2 = model2;
		this.usuarioDAO = usuarioDAO;
		this.carrinho = carrinho;
		this.navegador = navegador;
		this.view3 = view3;

		this.view.Pagar(e -> realizarPagamento());
		this.view.Voltar(e -> {
			this.navegador.navegarPara(Janelas.LISTAR_PANEL);
		});
	}

	public void realizarPagamento() {
		double totalPago = 0.0;
		DefaultTableModel modelo = (DefaultTableModel) view.getTable().getModel();
		if (modelo.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum produto para pagar.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		for (int i = 0; i < modelo.getRowCount(); i++) {
			Object valorObj = modelo.getValueAt(i, 1);

			if (valorObj != null) {
				try {
					double valor = Double.parseDouble(valorObj.toString());
					totalPago += valor;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Erro ao processar valor do produto na linha " + (i + 1),
							"Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		}
		String valorDigitadoStr = view.getValor();
		double valorDigitado;
		try {
			valorDigitado = Double.parseDouble(valorDigitadoStr.trim());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inserido deve ser numérico.", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		double tolerance = 0.01;
		if (Math.abs(valorDigitado - totalPago) > tolerance) {
			JOptionPane.showMessageDialog(null,
					"Valor digitado (R$ " + String.format("%.2f", valorDigitado)
							+ ") não corresponde ao total da compra (R$ " + String.format("%.2f", totalPago) + ").",
					"Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (model2 == null || model2.getNome() == null || model2.getSenha() == null) {
			JOptionPane.showMessageDialog(null, "Usuário não definido. Faça login novamente.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		Usuario usuario = usuarioDAO.buscarPorUsuarios(model2.getNome(), model2.getSenha());
		if (usuario != null) {
			JOptionPane.showMessageDialog(null,
					"Pagamento realizado com sucesso!\n" + "Nome: " + usuario.getNome() + "\n" + "CPF: "
							+ usuario.getCPF() + "\n" + "Total pago: R$ " + String.format("%.2f", valorDigitado),
					"Pagamento", JOptionPane.INFORMATION_MESSAGE);
			modelo.setRowCount(0);
			try {
				view.clearValorField();
			} catch (Exception ex) {
			}
			try {
				if (carrinho != null) {
					
					carrinho.limparCarrinho();
				}
			} catch (Exception ex) {
			}
		} else {
			JOptionPane.showMessageDialog(null, "Erro: usuário não encontrado ou dados incorretos.", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void carregarProdutosComprados(List<Produtos> produtosComprados) {
		DefaultTableModel modelo = (DefaultTableModel) view.getTable().getModel();
		modelo.setRowCount(0);

		for (Produtos produto : produtosComprados) {
			modelo.addRow(new Object[] { produto.getNomeProduto(), produto.getValor() });
		}
	}

	public void setUsuario(Usuario usuario) {
		this.model2 = usuario;
	}

	
	public Carrinho getCarrinho() {
		return this.carrinho;
	}
}