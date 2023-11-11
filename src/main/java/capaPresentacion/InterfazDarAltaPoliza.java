package capaPresentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;

public class InterfazDarAltaPoliza extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel buscarCliente;

	public InterfazDarAltaPoliza() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 853, 508);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPrincipal = new JTabbedPane(JTabbedPane.TOP);
		tabbedPrincipal.setFont(new Font("Arial", Font.PLAIN, 13));
		tabbedPrincipal.setBounds(0, 0, 853, 508);
		panel.add(tabbedPrincipal);
		
		JPanel crearPoliza = new JPanel();
		crearPoliza.setBackground(new Color(255, 255, 255));
		tabbedPrincipal.addTab("Crear poliza", null, crearPoliza, null);
		crearPoliza.setLayout(null);
		
		JTabbedPane tabbedCrearPoliza = new JTabbedPane(JTabbedPane.TOP);
		tabbedCrearPoliza.setFont(new Font("Arial", Font.PLAIN, 13));
		tabbedCrearPoliza.setBounds(0, 0, 848, 478);
		crearPoliza.add(tabbedCrearPoliza);
		
		buscarCliente = new JPanel();
		buscarCliente.setBackground(new Color(255, 255, 255));
		tabbedCrearPoliza.addTab("Buscar cliente", null, buscarCliente, null);
		
		JPanel datosHijos = new JPanel();
		datosHijos.setBackground(new Color(255, 255, 255));
		tabbedCrearPoliza.addTab("Datos del vehiculo", null, datosHijos, null);
		
		JPanel datosVehiculo = new JPanel();
		datosVehiculo.setBackground(new Color(255, 255, 255));
		tabbedCrearPoliza.addTab("Datos de hijos", null, datosVehiculo, null);
		
		JPanel confirmarPoliza = new JPanel();
		confirmarPoliza.setBackground(new Color(255, 255, 255));
		tabbedPrincipal.addTab("Confirmar poliza", null, confirmarPoliza, null);
		confirmarPoliza.setLayout(null);
		
		JTabbedPane tabbedConfirmarPoliza = new JTabbedPane(JTabbedPane.TOP);
		tabbedConfirmarPoliza.setFont(new Font("Arial", Font.PLAIN, 13));
		tabbedConfirmarPoliza.setBounds(0, 0, 848, 478);
		confirmarPoliza.add(tabbedConfirmarPoliza);
		
		JPanel tipoPoliza = new JPanel();
		tabbedConfirmarPoliza.addTab("Tipo de poliza", null, tipoPoliza, null);
		
		JPanel generacionPoliza = new JPanel();
		tabbedConfirmarPoliza.addTab("Generacion de poliza", null, generacionPoliza, null);
		
		
		
		
		
		
	}
}
