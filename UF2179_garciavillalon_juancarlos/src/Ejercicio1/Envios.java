package Ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Envios extends JFrame {

	private JPanel contentPane;
	private JTextField textOrigen;
	private JTextField textDestino;
	private final ButtonGroup GrupoOrigen = new ButtonGroup();
	private final ButtonGroup GrupoDestino = new ButtonGroup();
	private JTextField textPeso;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Envios frame = new Envios();
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
	public Envios() {
		setTitle("Calculadora envios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow][][][][]", "[][][][][][][][][]"));
		
		JLabel lblTitulo = new JLabel("Calculadora de Envíos");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setOpaque(true);
		lblTitulo.setBackground(Color.GRAY);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblTitulo, "cell 0 0 8 1,alignx center,aligny baseline");
		
		JLabel lblOrigen = new JLabel("Ciudad Origen:");
		contentPane.add(lblOrigen, "cell 2 2,alignx trailing");
		
		textOrigen = new JTextField();
		contentPane.add(textOrigen, "cell 3 2,growx");
		textOrigen.setColumns(10);
		
		JRadioButton rdbtNacional1 = new JRadioButton("Nacional");
		rdbtNacional1.setSelected(true);
		GrupoOrigen.add(rdbtNacional1);
		contentPane.add(rdbtNacional1, "flowx,cell 3 3");
		
		JLabel lblDestino = new JLabel("Ciudad Destino:");
		contentPane.add(lblDestino, "cell 2 4,alignx trailing");
		
		textDestino = new JTextField();
		contentPane.add(textDestino, "cell 3 4,growx");
		textDestino.setColumns(10);
		
		JRadioButton rdbtExtranjero1 = new JRadioButton("Extranjero");
		GrupoOrigen.add(rdbtExtranjero1);
		contentPane.add(rdbtExtranjero1, "cell 3 3");
		
		JRadioButton rdbtNacional2 = new JRadioButton("Nacional");
		rdbtNacional2.setSelected(true);
		GrupoDestino.add(rdbtNacional2);
		contentPane.add(rdbtNacional2, "flowx,cell 3 5");
		
		JRadioButton rdbtExtranjero2 = new JRadioButton("Extanjero");
		GrupoDestino.add(rdbtExtranjero2);
		contentPane.add(rdbtExtranjero2, "cell 3 5");
		
		JLabel lblTipoenvio = new JLabel("Tipo de envío:");
		contentPane.add(lblTipoenvio, "cell 2 6,alignx trailing");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Paq 10 - Antes de las 10 h", "Paq 14 - Antes de las 14 h", "Paq 24 - Al días siguiente"}));
		contentPane.add(comboBox, "cell 3 6,growx");
		
		JLabel lblPeso = new JLabel("Peso:");
		contentPane.add(lblPeso, "cell 2 7,alignx trailing");
		
		textPeso = new JTextField();
		contentPane.add(textPeso, "flowx,cell 3 7");
		textPeso.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular Precio");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		contentPane.add(btnCalcular, "cell 3 8");
		
		JLabel lblKg = new JLabel("Kg");
		contentPane.add(lblKg, "cell 3 7");
	}

	protected void calcular() {
		if (textOrigen.getText()==null || textOrigen.getText().isBlank() ||
				textDestino.getText()==null || textDestino.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Debe introducir los datos.", 
						"Error", JOptionPane.WARNING_MESSAGE);
					return;
			}
		String corigen = textOrigen.getText();
		String cdestino = textDestino.getText();
		String tipo = (String) comboBox.getSelectedItem();
		String peso = textPeso.getText();
		int tipo2 = comboBox.getSelectedIndex();

		int importebase =0, recargo=0;
		
//		if (GrupoOrigen.getSelection().getActionCommand().equals(
//				GrupoDestino.getSelection().getActionCommand())) {
//			importebase=4;
//		} else {
//			importebase=7;
//		}
		
		if (tipo2==0) {
			recargo = 5;
		} else if (tipo2 ==1) {
			recargo = 2;
		}
		
		int importe=importebase+recargo;
		JOptionPane.showMessageDialog(null,"Origen: "+corigen+"\n"+"Destino: "+
				cdestino+"\n"+"Tipo: "+tipo+"\n"+"Peso: "+peso+"\n"+"Importe: "+importe, "Cálculo", 1);
		
	}

}
