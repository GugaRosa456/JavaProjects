package Telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class TelaBiblioteca extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table;
	static ArrayList<ArrayList<String>> dados = new ArrayList<>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBiblioteca frame = new TelaBiblioteca(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	public TelaBiblioteca(boolean Admin) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(0, 23, 106, 22);
		contentPane.add(comboBox);

		if (Admin) {
			comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Biblioteca", "Adicionar", "Sair" }));
		} else {
			comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Biblioteca", "Sair" }));
		}
		
		String[] colunas = { "Biblioteca", "Data Criação", "Estados" };
		DefaultTableModel model = new DefaultTableModel(colunas, 0);
 
		
		
		if (dados != null) {
			for (ArrayList<String> linha : dados) {
				model.addRow(linha.toArray());
			}
		}

		table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 56, 414, 194);
		contentPane.add(scrollPane);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selecionado = (String) comboBox.getSelectedItem();
				if ("Sair".equals(selecionado)) {
					new TelaLogin().setVisible(true);
					dispose();
				} else if ("Adicionar".equals(selecionado)) {
					new TelaAdicionar(dados, true).setVisible(true);
					dispose();
				}
			}
		});
	}
}