package Controller;

	import javax.swing.JPanel;
	import view.Janelas;

	
	public class Navegador{

		private Janelas janela;

	
		
		public Navegador(Janelas janela) {
			this.janela = janela;
		}

		
		public void adicionarPainel(String nome, JPanel tela) {
			this.janela.adicionarTela( nome, tela);
		}

		
		public void navegarPara(String nome) {
			this.janela.mostrarTela(nome);
		}

		
		public void sair() {
			this.janela.dispose();
		}
	}


