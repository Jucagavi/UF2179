package Ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAutocar extends JFrame {

	private JPanel contentPane;
	private JTextField textMatricula;
	private JLabel lblMarca;
	private JTextField textMarca;
	private JLabel lblKms;
	private JTextField textKms;
	private JLabel lblModelo;
	private JLabel lblPlazas;
	private JTextField textModelo;
	private JTextField textPlazas;
	private JButton btnInsertar;
	private JButton btnMostrar;
	private JTextArea textArea;
	private List<Autocar> listaAutocares;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAutocar frame = new VentanaAutocar();
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
	public VentanaAutocar() {
		listaAutocares = new ArrayList<Autocar>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][grow]", "[][][][][][grow]"));
		
		JLabel lblTitulo = new JLabel("Gestión autocares");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBackground(Color.GRAY);
		lblTitulo.setOpaque(true);
		contentPane.add(lblTitulo, "cell 1 0 2 1,growx");
		
		JLabel lblMatricula = new JLabel("Matricula:");
		contentPane.add(lblMatricula, "cell 1 1,alignx right");
		
		textMatricula = new JTextField();
		contentPane.add(textMatricula, "flowx,cell 2 1");
		textMatricula.setColumns(10);
		
		lblMarca = new JLabel("Marca:");
		contentPane.add(lblMarca, "cell 1 2,alignx trailing");
		
		textMarca = new JTextField();
		contentPane.add(textMarca, "flowx,cell 2 2");
		textMarca.setColumns(10);
		
		lblKms = new JLabel("Kilómetros:");
		contentPane.add(lblKms, "cell 1 3,alignx trailing");
		
		textKms = new JTextField();
		contentPane.add(textKms, "cell 2 3");
		textKms.setColumns(10);
		
		lblModelo = new JLabel("Modelo:");
		contentPane.add(lblModelo, "cell 2 1");
		
		lblPlazas = new JLabel("Plazas:");
		contentPane.add(lblPlazas, "cell 2 2");
		
		textModelo = new JTextField();
		contentPane.add(textModelo, "cell 2 1");
		textModelo.setColumns(10);
		
		textPlazas = new JTextField();
		contentPane.add(textPlazas, "cell 2 2");
		textPlazas.setColumns(10);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertar();
			}
		});
		contentPane.add(btnInsertar, "flowx,cell 2 4");
		
		btnMostrar = new JButton("Mostrar Datos");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar();
			}
		});
		contentPane.add(btnMostrar, "cell 2 4");
		
		textArea = new JTextArea();
		contentPane.add(textArea, "cell 1 5 2 1,grow");
	}

	protected void mostrar() {
		textArea.setText("");
		for (Autocar autocar : listaAutocares) {
			textArea.setText(textArea.getText()+autocar+"\n");
		}
	}

	protected void insertar() {
		
		if (textMatricula.getText()==null || textMatricula.getText().isBlank() ||
				textMarca.getText()==null || textMarca.getText().isBlank() ||
				textModelo.getText()==null || textModelo.getText().isBlank() ||
				textKms.getText()==null || textKms.getText().isBlank() ||
				textPlazas.getText()==null || textPlazas.getText().isBlank()) {
					JOptionPane.showMessageDialog(this, "Debe rellenar los campos.", 
						"Error", JOptionPane.WARNING_MESSAGE);
					return;
			}
		
		String matricula = textMatricula.getText();
		String marca = textMarca.getText();
		String modelo = textModelo.getText();
		int kms = Integer.parseInt(textKms.getText());
		int plazas = Integer.parseInt(textPlazas.getText());
		
		if (plazas<1 || plazas>80) {
			JOptionPane.showMessageDialog(this, "Plazas deben ser entre 1 y 80.",
											"Error", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		Autocar a = new Autocar(matricula,marca,modelo,kms,plazas);
		if (!listaAutocares.contains(a)) {
			listaAutocares.add(a);

			textMatricula.setText("");
			textMarca.setText("");
			textModelo.setText("");
			textKms.setText("");
			textPlazas.setText("");
			
		} else {
			JOptionPane.showMessageDialog(this, "Auocar ya existe.", "Error", 2);
		}	
	}
}
