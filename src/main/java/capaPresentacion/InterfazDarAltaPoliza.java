package capaPresentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import constants.Images;

import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class InterfazDarAltaPoliza extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane,buscarCliente, panelPrincipal, crearPoliza,confirmarPoliza, datosHijos, datosVehiculo, tipoPoliza, generacionPoliza;
	private JTabbedPane tabbedPrincipal, tabbedCrearPoliza, tabbedConfirmarPoliza;
	private JButton btnSiguiente,btnCancelar,btnBuscarCliente,btnDarAltaCliente;
	private JLabel lblMarcoCliente,lblNroCliente,lblTipoDni,lblNroDni,lblApellido,lblNombre,lblDomicilio;
	private JTextField textFieldNroCliente;
	private JTextField textFieldTipoDNI;
	private JTextField textFieldNroDNI;
	private JTextField textFieldApellido;
	private JTextField textFieldNombre;
	private JTextField textFieldDomicilio;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;

	public InterfazDarAltaPoliza() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		inicializarPaneles();
		tabbedPrincipal.setFocusable(false);
		pestaniaCrearPoliza();
		
		

	}
	public void botonSiguiente() {
		
	}
	
	public void botonCancelar() {
		
	}
	
	public void configuracionTextFieldBuscarCliente(JTextField textField) {
		textField.setBorder(null);
		textField.setFocusable(false);
		textField.setEnabled(false);
		textField.setBackground(Color.WHITE);
	}
	
	
	public void pestaniaBuscarCliente() {
		tabbedPrincipal.setSelectedIndex(0);
		
		separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setBackground(Color.BLACK);
		separator_5.setBounds(492, 187, 123, 2);
		buscarCliente.add(separator_5);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(492, 154, 123, 2);
		buscarCliente.add(separator_4);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(492, 121, 123, 2);
		buscarCliente.add(separator_3);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(171, 187, 123, 2);
		buscarCliente.add(separator_2);
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(171, 121, 123, 2);
		buscarCliente.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(171, 154, 123, 2);
		buscarCliente.add(separator_1);
		
		lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDomicilio.setBounds(428, 175, 72, 14);
		buscarCliente.add(lblDomicilio);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellido.setBounds(428, 108, 72, 14);
		buscarCliente.add(lblApellido);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(428, 142, 72, 14);
		buscarCliente.add(lblNombre);
		
		lblNroDni = new JLabel("Nro. DNI");
		lblNroDni.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNroDni.setBounds(89, 175, 72, 14);
		buscarCliente.add(lblNroDni);
		
		lblTipoDni = new JLabel("Tipo DNI");
		lblTipoDni.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTipoDni.setBounds(89, 142, 72, 14);
		buscarCliente.add(lblTipoDni);
		
		lblNroCliente = new JLabel("Nro. Cliente");
		lblNroCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNroCliente.setBounds(89, 108, 72, 14);
		buscarCliente.add(lblNroCliente);
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(58, 401, 80, 27);
		buscarCliente.add(btnSiguiente);
		btnSiguiente.setFocusable(false);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(138, 401, 80, 27);
		buscarCliente.add(btnCancelar);
		btnCancelar.setFocusable(false);
			
		btnBuscarCliente = new JButton("Buscar cliente");
		btnBuscarCliente.setBounds(58, 233, 104, 27);
		buscarCliente.add(btnBuscarCliente);
		btnBuscarCliente.setFocusable(false);
			
		btnDarAltaCliente = new JButton("Dar de alta cliente");
		btnDarAltaCliente.setBounds(161, 233, 134, 27);
		buscarCliente.add(btnDarAltaCliente);
		btnDarAltaCliente.setFocusable(false);
		
		textFieldNroCliente = new JTextField();
		textFieldNroCliente.setBounds(171, 103, 123, 20);
		textFieldNroCliente.setColumns(10);
		buscarCliente.add(textFieldNroCliente);
		configuracionTextFieldBuscarCliente(textFieldNroCliente);
		
		textFieldTipoDNI = new JTextField();
		textFieldTipoDNI.setColumns(10);
		textFieldTipoDNI.setBounds(171, 136, 123, 20);
		buscarCliente.add(textFieldTipoDNI);
		configuracionTextFieldBuscarCliente(textFieldTipoDNI);
		
		textFieldNroDNI = new JTextField();
		textFieldNroDNI.setColumns(10);
		textFieldNroDNI.setBounds(171, 169, 123, 20);
		buscarCliente.add(textFieldNroDNI);
		configuracionTextFieldBuscarCliente(textFieldNroDNI);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(492, 103, 123, 20);
		buscarCliente.add(textFieldApellido);
		configuracionTextFieldBuscarCliente(textFieldApellido);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(492, 136, 123, 20);
		buscarCliente.add(textFieldNombre);
		configuracionTextFieldBuscarCliente(textFieldNombre);
		
		textFieldDomicilio = new JTextField();
		textFieldDomicilio.setColumns(10);
		textFieldDomicilio.setBounds(492, 169, 123, 20);
		buscarCliente.add(textFieldDomicilio);
		configuracionTextFieldBuscarCliente(textFieldDomicilio);
		
		lblMarcoCliente = new JLabel("");
		lblMarcoCliente.setIcon(Images.MARCO_CLIENTE);
		lblMarcoCliente.setBounds(44, 57, 725, 168);
		buscarCliente.add(lblMarcoCliente);
	}
	
	
	public void pestaniaCrearPoliza() {
		tabbedPrincipal.setEnabledAt(1, false);
		pestaniaBuscarCliente();
		
		
		
		
	}
	public void pestaniaConfirmarPoliza() {
		tabbedPrincipal.setEnabledAt(0, false);
		
	}
	
	
	public void inicializarPaneles () {
		setTitle("Productor de seguro- Dar de alta poliza");
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 853, 508);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		tabbedPrincipal = new JTabbedPane(JTabbedPane.TOP);
		tabbedPrincipal.setFont(new Font("Arial", Font.PLAIN, 13));
		tabbedPrincipal.setBounds(0, 0, 853, 508);
		panelPrincipal.add(tabbedPrincipal);
		tabbedPrincipal.setFocusable(false);
		
		crearPoliza = new JPanel();
		crearPoliza.setBackground(new Color(255, 255, 255));
		tabbedPrincipal.addTab("Crear poliza", null, crearPoliza, null);
		crearPoliza.setLayout(null);
		
		tabbedCrearPoliza = new JTabbedPane(JTabbedPane.TOP);
		tabbedCrearPoliza.setFont(new Font("Arial", Font.PLAIN, 13));
		tabbedCrearPoliza.setBounds(0, 0, 860, 480);
		tabbedCrearPoliza.setFocusable(false);
		crearPoliza.add(tabbedCrearPoliza);
		
		buscarCliente = new JPanel();
		buscarCliente.setBackground(new Color(255, 255, 255));
		tabbedCrearPoliza.addTab("Buscar cliente", null, buscarCliente, null);
		buscarCliente.setLayout(null);
		
		datosHijos = new JPanel();
		datosHijos.setBackground(new Color(255, 255, 255));
		tabbedCrearPoliza.addTab("Datos del vehiculo", null, datosHijos, null);
		
		datosVehiculo = new JPanel();
		datosVehiculo.setBackground(new Color(255, 255, 255));
		tabbedCrearPoliza.addTab("Datos de hijos", null, datosVehiculo, null);
		
		confirmarPoliza = new JPanel();
		confirmarPoliza.setBackground(new Color(255, 255, 255));
		tabbedPrincipal.addTab("Confirmar poliza", null, confirmarPoliza, null);
		confirmarPoliza.setLayout(null);
		
		tabbedConfirmarPoliza = new JTabbedPane(JTabbedPane.TOP);
		tabbedConfirmarPoliza.setFont(new Font("Arial", Font.PLAIN, 13));
		tabbedConfirmarPoliza.setBounds(0, 0, 848, 478);
		tabbedConfirmarPoliza.setFocusable(false);
		confirmarPoliza.add(tabbedConfirmarPoliza);
		
		tipoPoliza = new JPanel();
		tipoPoliza.setBackground(Color.WHITE);
		tabbedConfirmarPoliza.addTab("Tipo de poliza", null, tipoPoliza, null);
		
		generacionPoliza = new JPanel();
		generacionPoliza.setBackground(Color.WHITE);
		tabbedConfirmarPoliza.addTab("Generacion de poliza", null, generacionPoliza, null);
	}
}
