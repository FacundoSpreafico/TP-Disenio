package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class CreacionPoliza extends JFrame {

	private JPanel contentPane;

	
	
	
	
	public CreacionPoliza(String numero) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setTitle("Póliza generada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 395, 169);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Poliza generada correctamente!");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBounds(47, 22, 182, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNroDePoliza = new JLabel("Nro de poliza: ");
		lblNroDePoliza.setForeground(Color.BLACK);
		lblNroDePoliza.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNroDePoliza.setBounds(47, 63, 87, 14);
		panel.add(lblNroDePoliza);
		
		JButton btnDescargar = new JButton("Descargar póliza");
		btnDescargar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDescargar.setBounds(253, 96, 132, 23);
		panel.add(btnDescargar);
		btnDescargar.setFocusable(false);
		
		JLabel nroPoliza = new JLabel("");
		nroPoliza.setBackground(Color.WHITE);
		nroPoliza.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nroPoliza.setBounds(129, 62, 152, 14);
		panel.add(nroPoliza);
		nroPoliza.setText(numero);
		
		
	}
}
