package Telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TelaAdicionar extends JFrame {
	private static final long serialVersionUID = 1L;
	protected static final boolean Admin = false;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdicionar frame = new TelaAdicionar(TelaBiblioteca.dados, Admin);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param admin 
	 */
	    public TelaAdicionar(ArrayList<ArrayList<String>> dados, boolean admin) {
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 259, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50, 30, 142, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(50, 175, 142, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(69, 206, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Livro\r\n");
		lblNewLabel.setBounds(50, 11, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDataCriao = new JLabel("Data Criação");
		lblDataCriao.setBounds(50, 61, 89, 14);
		contentPane.add(lblDataCriao);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(50, 150, 61, 14);
		contentPane.add(lblEstado);
		
		JSlider slider = new JSlider(1900, 2000, 1900);
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(20);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBounds(10, 87, 223, 42);
		contentPane.add(slider);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> linha = new ArrayList<>();
				linha.add(textField.getText());
				linha.add(String.valueOf(slider.getValue()));
				linha.add(textField_1.getText());
				TelaBiblioteca.dados.add(linha);
				
				textField.setText("");
				textField_1.setText("");
				slider.setValue(2000);
	
				new TelaBiblioteca(true).setVisible(true);
				dispose();
			}
		});
		
		
		
	}
}
