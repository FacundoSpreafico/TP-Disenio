package capaPresentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import constants.Images;

import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class InterfazDarAltaPoliza extends JFrame {

	private static final long serialVersionUID = 1L;
	// JPanels
	private JPanel contentPane, buscarCliente, panelPrincipal, crearPoliza, confirmarPoliza, datosVehiculo, datosHijos, tipoPoliza, generacionPoliza;
	// JTabbedPanes
	private JTabbedPane tabbedPrincipal, tabbedCrearPoliza, tabbedConfirmarPoliza;
	// JButtons
	private JButton btnSiguiente_1, btnCancelar_1, btnBuscarCliente, btnDarAltaCliente, btnSiguiente_3, btnVolver_3, btnCancelar_3, btnSiguiente_2, btnCancelar_2, btnVolver_2, btnAgregarHijo;
	// JLabels
	private JLabel lblMarcoCliente, lblNroCliente, lblTipoDni, lblNroDni, lblApellido, lblNombre, lblDomicilio, lblMarcoClienteContexto, lblNombre_1, lblApellido_1;
	private JLabel lblMarcoPoliza, lblModeloVehiculo, lblSimbolo, lblSimbolo_2, lblSimbolo_3, lblMarcoPoliza_1;
	private JLabel lblSumaAsegurada, lblChasis, lblKmsAnio, lblNroSiniestros, lblSimbolo_1, lblMarcaDelVehiculo, lblSimbolo_4;
	private JLabel lblAoDelVehiculo, lblSimbolo_5, lblMotor, lblSimbolo_6, lblPatenteDelVehiculo, lblSimbolo_7, lblMedidasDeSeguridad;
	private JLabel lblNewLabel_1, lblMarcoClienteContexto_1, lblApellido_3, lblNombre_2, lblAgregarHijo, lblContadorHijos;
	// JTextFields
	private JTextField textFieldNroCliente, textFieldTipoDNI, textFieldNroDNI, textFieldApellido, textFieldNombre, textFieldDomicilio, textFieldNombre_1, textFieldApellido_1;
	private JTextField textFieldSumaAsegurada, textFieldChasis, textFieldPatenteVehiculo, textFieldMotor, textFieldApellido_3, textFieldNombre_3, textFieldContadorHijos;
	// JSeparators
	private JSeparator separator_1, separator_2, separator_3, separator_4, separator_5, separator_6, separator_7, separator_8, separator_9, separator_10;
	// JComboBoxes
	private JComboBox comboBoxKmsPorAnio, comboBoxSiniestrosUltAnio, comboBoxAnioVehiculo, comboBoxMarcaVehiculo;
	
	private int contadorHijos = 0;
	private JLabel lblSexo;
	private Map<Integer, List<Component>> componentesPorHijo = new HashMap<>();
	
	
	
	
	
	
	
	public InterfazDarAltaPoliza() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		setResizable(false);
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

	public void pestaniaDatosHijos() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 170, 789, 211);
		datosHijos.add(scrollPane);
		
		scrollPane.setBorder(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		
		lblAgregarHijo = new JLabel("Agregar");
		lblAgregarHijo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAgregarHijo.setBounds(40, 150, 56, 14);
		datosHijos.add(lblAgregarHijo);
		
		btnAgregarHijo = new JButton("");
		btnAgregarHijo.setBackground(Color.WHITE);
		btnAgregarHijo.setBounds(96, 145, 38, 23);
		datosHijos.add(btnAgregarHijo);
		btnAgregarHijo.setIcon(Images.ICONO_AGREGAR_HIJO);
		btnAgregarHijo.setBorder(null);
		btnAgregarHijo.setFocusable(false);
		
		 btnAgregarHijo.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                int modulo = contadorHijos % 2;

	                int posY = 11 + (contadorHijos / 2) * 150;
	                int posX = modulo * 280;

	                JLabel lblSexo = new JLabel("Sexo");
	                lblSexo.setBounds(20 + posX, 48 + posY, 33, 14);
	                lblSexo.setFont(new Font("Arial", Font.PLAIN, 12));

	                JLabel lblEstadoCivil = new JLabel("Estado civil");
	                lblEstadoCivil.setFont(new Font("Arial", Font.PLAIN, 12));
	                lblEstadoCivil.setBounds(20 + posX, 79 + posY, 68, 14);

	                JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
	                lblFechaDeNacimiento.setFont(new Font("Arial", Font.PLAIN, 12));
	                lblFechaDeNacimiento.setBounds(20 + posX, 17 + posY, 115, 14);
	                panel.add(lblFechaDeNacimiento);

	                JComboBox<String> comboBoxEstadoCivil = new JComboBox<>();
	                comboBoxEstadoCivil.setBounds(143 + posX, 75 + posY, 140, 22);

	                JComboBox<String> comboBoxSexo = new JComboBox<>();
	                comboBoxSexo.setBounds(143 + posX, 42 + posY, 140, 22);

	                JDateChooser dateChooser = new JDateChooser();
	                dateChooser.setBounds(143 + posX, 11 + posY, 140, 20);
	                panel.add(dateChooser);

	                JButton btnEliminarHijo = new JButton("");
	                btnEliminarHijo.setBackground(Color.WHITE);
	                btnEliminarHijo.setBounds(20 + posX, 116 + posY, 33, 23);
	                panel.add(btnEliminarHijo);
	                btnEliminarHijo.setIcon(Images.ICONO_ELIMINAR_HIJO);
	                btnEliminarHijo.setBorder(null);
	                btnEliminarHijo.setFocusable(false);

	                btnEliminarHijo.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    }
	                });

	                panel.add(lblSexo);
	                panel.add(lblEstadoCivil);
	                panel.add(lblFechaDeNacimiento);
	                panel.add(comboBoxEstadoCivil);
	                panel.add(comboBoxSexo);
	                panel.add(btnEliminarHijo);

	                int panelHeight = posY + 150;
	                panel.setPreferredSize(new Dimension(panel.getWidth(), panelHeight));

	                panel.revalidate();
	                panel.repaint();
	                contadorHijos++;
	                textFieldContadorHijos.setText(String.valueOf(contadorHijos));
	            }
	        });
    








		textFieldContadorHijos = new JTextField();
		textFieldContadorHijos.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldContadorHijos.setColumns(10);
		textFieldContadorHijos.setBounds(205, 109, 20, 20);
		datosHijos.add(textFieldContadorHijos);
		configuracionTextField(textFieldContadorHijos);
		textFieldContadorHijos.setEnabled(true);
		textFieldContadorHijos.setText("0");
		
		
		JSeparator separator_10_1 = new JSeparator();
		separator_10_1.setForeground(Color.BLACK);
		separator_10_1.setBackground(Color.BLACK);
		separator_10_1.setBounds(200, 129, 29, 2);
		datosHijos.add(separator_10_1);
		
		separator_9 = new JSeparator();
		separator_9.setForeground(Color.BLACK);
		separator_9.setBackground(Color.BLACK);
		separator_9.setBounds(454, 45, 123, 2);
		datosHijos.add(separator_9);
		
		separator_10 = new JSeparator();
		separator_10.setForeground(Color.BLACK);
		separator_10.setBackground(Color.BLACK);
		separator_10.setBounds(96, 45, 123, 2);
		datosHijos.add(separator_10);
		
		lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre_2.setBounds(40, 33, 46, 14);
		datosHijos.add(lblNombre_2);
		
		textFieldNombre_3 = new JTextField();
		textFieldNombre_3.setColumns(10);
		textFieldNombre_3.setBounds(96, 25, 123, 20);
		datosHijos.add(textFieldNombre_3);
		configuracionTextField(textFieldNombre_3);
		
		lblApellido_3 = new JLabel("Apellido");
		lblApellido_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellido_3.setBounds(398, 33, 46, 14);
		datosHijos.add(lblApellido_3);
		
		textFieldApellido_3 = new JTextField();
		textFieldApellido_3.setColumns(10);
		textFieldApellido_3.setBounds(454, 25, 123, 20);
		datosHijos.add(textFieldApellido_3);
		configuracionTextField(textFieldApellido_3);
	
		JLabel lblContadorHijos = new JLabel("Hijos (entre 18 y 30 años)");
		lblContadorHijos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblContadorHijos.setBounds(40, 115, 161, 14);
		datosHijos.add(lblContadorHijos);
		
		JButton btnSiguiente_3 = new JButton("Siguiente");
		btnSiguiente_3.setFocusable(false);
		btnSiguiente_3.setBounds(20, 404, 80, 27);
		datosHijos.add(btnSiguiente_3);
		
		JButton btnVolver_3 = new JButton("Volver");
		btnVolver_3.setFocusable(false);
		btnVolver_3.setBounds(100, 404, 80, 27);
		datosHijos.add(btnVolver_3);
		
		JButton btnCancelar_3 = new JButton("Cancelar");
		btnCancelar_3.setFocusable(false);
		btnCancelar_3.setBounds(180, 404, 80, 27);
		datosHijos.add(btnCancelar_3);
		
		lblMarcoClienteContexto_1 = new JLabel("");
		lblMarcoClienteContexto_1.setBounds(15, 8, 815, 67);
		datosHijos.add(lblMarcoClienteContexto_1);
		lblMarcoClienteContexto_1.setIcon(Images.MARCO_CLIENTE_CONTEXTO);
		
		JLabel lblMarcoPoliza_1 = new JLabel("");
		lblMarcoPoliza_1.setBounds(15, 86, 835, 307);
		datosHijos.add(lblMarcoPoliza_1);
		lblMarcoPoliza_1.setIcon(Images.MARCO_POLIZA);
	}
	public void pestaniaDatosDelVehiculo() {
		comboBoxMarcaVehiculo = new JComboBox();
		comboBoxMarcaVehiculo.setBackground(Color.WHITE);
		comboBoxMarcaVehiculo.setBounds(541, 150, 154, 22);
		datosVehiculo.add(comboBoxMarcaVehiculo);
		
		comboBoxAnioVehiculo = new JComboBox();
		comboBoxAnioVehiculo.setBackground(Color.WHITE);
		comboBoxAnioVehiculo.setBounds(541, 181, 154, 22);
		datosVehiculo.add(comboBoxAnioVehiculo);
		
		textFieldMotor = new JTextField();
		textFieldMotor.setColumns(10);
		textFieldMotor.setBounds(541, 212, 154, 20);
		datosVehiculo.add(textFieldMotor);
		
		textFieldPatenteVehiculo = new JTextField();
		textFieldPatenteVehiculo.setColumns(10);
		textFieldPatenteVehiculo.setBounds(541, 237, 154, 20);
		datosVehiculo.add(textFieldPatenteVehiculo);
		
		comboBoxSiniestrosUltAnio = new JComboBox();
		comboBoxSiniestrosUltAnio.setBackground(Color.WHITE);
		comboBoxSiniestrosUltAnio.setBounds(178, 284, 154, 22);
		datosVehiculo.add(comboBoxSiniestrosUltAnio);
		
		comboBoxKmsPorAnio = new JComboBox();
		comboBoxKmsPorAnio.setBackground(Color.WHITE);
		comboBoxKmsPorAnio.setBounds(178, 251, 154, 22);
		datosVehiculo.add(comboBoxKmsPorAnio);
		
		textFieldChasis = new JTextField();
		textFieldChasis.setBounds(178, 220, 154, 20);
		datosVehiculo.add(textFieldChasis);
		textFieldChasis.setColumns(10);
		
		separator_8 = new JSeparator();
		separator_8.setForeground(Color.BLACK);
		separator_8.setBackground(Color.BLACK);
		separator_8.setBounds(178, 201, 154, 2);
		datosVehiculo.add(separator_8);
		
		textFieldSumaAsegurada = new JTextField();
		textFieldSumaAsegurada.setBounds(178, 183, 154, 17);
		datosVehiculo.add(textFieldSumaAsegurada);
		textFieldSumaAsegurada.setColumns(10);
		configuracionTextField(textFieldSumaAsegurada);
		
		JComboBox comboBoxModeloVehiculo = new JComboBox();
		comboBoxModeloVehiculo.setBackground(Color.WHITE);
		comboBoxModeloVehiculo.setBounds(178, 150, 154, 22);
		datosVehiculo.add(comboBoxModeloVehiculo);
		
		JCheckBox chckbxTuercasAntirrobos = new JCheckBox("¿Posee tuercas antirrobo en las cuatro ruedas?");
		chckbxTuercasAntirrobos.setBackground(Color.WHITE);
		chckbxTuercasAntirrobos.setBounds(398, 355, 251, 23);
		datosVehiculo.add(chckbxTuercasAntirrobos);
		
		JCheckBox chckbxRastreoVehicular = new JCheckBox("¿Posee dispositivo de rastreo vehicular?");
		chckbxRastreoVehicular.setBackground(Color.WHITE);
		chckbxRastreoVehicular.setBounds(398, 331, 228, 23);
		datosVehiculo.add(chckbxRastreoVehicular);
		
		JCheckBox chckbxtieneAlarma = new JCheckBox("¿Tiene alarma?");
		chckbxtieneAlarma.setBackground(Color.WHITE);
		chckbxtieneAlarma.setBounds(398, 307, 154, 23);
		datosVehiculo.add(chckbxtieneAlarma);
		
		JCheckBox chckbxGuardaGarage = new JCheckBox("¿Se guarda en garage?");
		chckbxGuardaGarage.setBackground(Color.WHITE);
		chckbxGuardaGarage.setBounds(398, 283, 154, 23);
		datosVehiculo.add(chckbxGuardaGarage);
		
		lblMedidasDeSeguridad = new JLabel("Medidas de seguridad");
		lblMedidasDeSeguridad.setFont(new Font("Arial", Font.BOLD, 12));
		lblMedidasDeSeguridad.setBounds(398, 265, 133, 14);
		datosVehiculo.add(lblMedidasDeSeguridad);
		
		lblSimbolo_7 = new JLabel("(*)");
		lblSimbolo_7.setForeground(Color.RED);
		lblSimbolo_7.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSimbolo_7.setBounds(512, 240, 19, 14);
		datosVehiculo.add(lblSimbolo_7);
		
		lblPatenteDelVehiculo = new JLabel("Patente del vehiculo");
		lblPatenteDelVehiculo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPatenteDelVehiculo.setBounds(398, 240, 113, 14);
		datosVehiculo.add(lblPatenteDelVehiculo);
		
		lblSimbolo_6 = new JLabel("(*)");
		lblSimbolo_6.setForeground(Color.RED);
		lblSimbolo_6.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSimbolo_6.setBounds(512, 215, 19, 14);
		datosVehiculo.add(lblSimbolo_6);
		
		lblMotor = new JLabel("Motor");
		lblMotor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMotor.setBounds(398, 215, 40, 14);
		datosVehiculo.add(lblMotor);
		
		lblSimbolo_5 = new JLabel("(*)");
		lblSimbolo_5.setForeground(Color.RED);
		lblSimbolo_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSimbolo_5.setBounds(512, 184, 19, 14);
		datosVehiculo.add(lblSimbolo_5);
		
		lblAoDelVehiculo = new JLabel("Año del vehiculo");
		lblAoDelVehiculo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAoDelVehiculo.setBounds(398, 186, 94, 14);
		datosVehiculo.add(lblAoDelVehiculo);
		
		lblSimbolo_4 = new JLabel("(*)");
		lblSimbolo_4.setForeground(Color.RED);
		lblSimbolo_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSimbolo_4.setBounds(512, 154, 19, 14);
		datosVehiculo.add(lblSimbolo_4);
		
		lblMarcaDelVehiculo = new JLabel("Marca del vehiculo");
		lblMarcaDelVehiculo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMarcaDelVehiculo.setBounds(398, 154, 107, 14);
		datosVehiculo.add(lblMarcaDelVehiculo);
		
		lblSimbolo_1 = new JLabel("(*)");
		lblSimbolo_1.setForeground(Color.RED);
		lblSimbolo_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSimbolo_1.setBounds(152, 288, 19, 14);
		datosVehiculo.add(lblSimbolo_1);
		
		lblNroSiniestros = new JLabel("Nro. Siniestros / ult. año");
		lblNroSiniestros.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNroSiniestros.setBounds(40, 288, 113, 14);
		datosVehiculo.add(lblNroSiniestros);
		
		lblKmsAnio = new JLabel("Kilometros por año");
		lblKmsAnio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblKmsAnio.setBounds(40, 255, 113, 14);
		datosVehiculo.add(lblKmsAnio);
		
		lblChasis = new JLabel("Chasis");
		lblChasis.setFont(new Font("Arial", Font.PLAIN, 12));
		lblChasis.setBounds(40, 220, 46, 14);
		datosVehiculo.add(lblChasis);
		
		lblSumaAsegurada = new JLabel("Suma asegurada");
		lblSumaAsegurada.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSumaAsegurada.setBounds(40, 186, 113, 14);
		datosVehiculo.add(lblSumaAsegurada);
		
		lblSimbolo_3 = new JLabel("(*)");
		lblSimbolo_3.setForeground(Color.RED);
		lblSimbolo_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSimbolo_3.setBounds(152, 255, 19, 14);
		datosVehiculo.add(lblSimbolo_3);
		
		lblSimbolo_2 = new JLabel("(*)");
		lblSimbolo_2.setForeground(Color.RED);
		lblSimbolo_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSimbolo_2.setBounds(152, 223, 19, 14);
		datosVehiculo.add(lblSimbolo_2);
		
		lblSimbolo = new JLabel("(*)");
		lblSimbolo.setForeground(Color.RED);
		lblSimbolo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSimbolo.setBounds(152, 154, 19, 14);
		datosVehiculo.add(lblSimbolo);
		
		lblModeloVehiculo = new JLabel("Modelo del vehiculo");
		lblModeloVehiculo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblModeloVehiculo.setBounds(40, 154, 113, 14);
		datosVehiculo.add(lblModeloVehiculo);
		
		separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		separator_7.setBackground(Color.BLACK);
		separator_7.setBounds(454, 45, 123, 2);
		datosVehiculo.add(separator_7);
		
		separator_6 = new JSeparator();
		separator_6.setForeground(Color.BLACK);
		separator_6.setBackground(Color.BLACK);
		separator_6.setBounds(96, 45, 123, 2);
		datosVehiculo.add(separator_6);
		
		lblApellido_1 = new JLabel("Apellido");
		lblApellido_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellido_1.setBounds(398, 33, 46, 14);
		datosVehiculo.add(lblApellido_1);
		
		lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre_1.setBounds(40, 33, 46, 14);
		datosVehiculo.add(lblNombre_1);
		
		textFieldApellido_1 = new JTextField();
		textFieldApellido_1.setColumns(10);
		textFieldApellido_1.setBounds(454, 25, 123, 20);
		datosVehiculo.add(textFieldApellido_1);
		configuracionTextField(textFieldApellido_1);
		
		textFieldNombre_1 = new JTextField();
		textFieldNombre_1.setBounds(96, 25, 123, 20);
		datosVehiculo.add(textFieldNombre_1);
		textFieldNombre_1.setColumns(10);
		configuracionTextField(textFieldNombre_1);
		lblMarcoClienteContexto = new JLabel("");
		lblMarcoClienteContexto.setIcon(Images.MARCO_CLIENTE_CONTEXTO);
		lblMarcoClienteContexto.setBounds(15, 8, 815, 67);
		datosVehiculo.add(lblMarcoClienteContexto);
		
		lblMarcoPoliza = new JLabel("");
		lblMarcoPoliza.setIcon(Images.MARCO_POLIZA);
		lblMarcoPoliza.setBounds(15, 86, 835, 307);
		datosVehiculo.add(lblMarcoPoliza);
		
		btnSiguiente_2 = new JButton("Siguiente");
		btnSiguiente_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<tabbedCrearPoliza.getComponentCount(); i++) {
					tabbedCrearPoliza.setEnabledAt(i, true);
					 if (i != 2) {
					        tabbedCrearPoliza.setEnabledAt(i, false);
					    }
				}
				tabbedCrearPoliza.setSelectedIndex(2);
			}
		});
		btnSiguiente_2.setFocusable(false);
		btnSiguiente_2.setBounds(20, 404, 80, 27);
		datosVehiculo.add(btnSiguiente_2);
		
		btnCancelar_2 = new JButton("Cancelar");
		btnCancelar_2.setFocusable(false);
		btnCancelar_2.setBounds(180, 404, 80, 27);
		datosVehiculo.add(btnCancelar_2);
		
		btnVolver_2 = new JButton("Volver");
		btnVolver_2.setFocusable(false);
		btnVolver_2.setBounds(100, 404, 80, 27);
		datosVehiculo.add(btnVolver_2);
		
		
	}
	public void configuracionTextField(JTextField textField) {
		textField.setBorder(null);
		textField.setFocusable(false);
		textField.setBackground(Color.WHITE);
		textField.setEnabled(false);
	}
	public void pestaniaBuscarCliente() {
		tabbedPrincipal.setSelectedIndex(0);
		for (int i=1; i<tabbedCrearPoliza.getComponentCount(); i++) {
			tabbedCrearPoliza.setEnabledAt(i, false);
		}
		separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setBackground(Color.BLACK);
		separator_5.setBounds(449, 186, 123, 2);
		buscarCliente.add(separator_5);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(449, 153, 123, 2);
		buscarCliente.add(separator_4);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(449, 120, 123, 2);
		buscarCliente.add(separator_3);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(128, 186, 123, 2);
		buscarCliente.add(separator_2);
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(128, 120, 123, 2);
		buscarCliente.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(128, 153, 123, 2);
		buscarCliente.add(separator_1);
		
		lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDomicilio.setBounds(385, 174, 72, 14);
		buscarCliente.add(lblDomicilio);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellido.setBounds(385, 107, 72, 14);
		buscarCliente.add(lblApellido);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(385, 141, 72, 14);
		buscarCliente.add(lblNombre);
		
		lblNroDni = new JLabel("Nro. DNI");
		lblNroDni.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNroDni.setBounds(46, 174, 72, 14);
		buscarCliente.add(lblNroDni);
		
		lblTipoDni = new JLabel("Tipo DNI");
		lblTipoDni.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTipoDni.setBounds(46, 141, 72, 14);
		buscarCliente.add(lblTipoDni);
		
		lblNroCliente = new JLabel("Nro. Cliente");
		lblNroCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNroCliente.setBounds(46, 107, 72, 14);
		buscarCliente.add(lblNroCliente);
		
		btnSiguiente_1 = new JButton("Siguiente");
		btnSiguiente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<tabbedCrearPoliza.getComponentCount(); i++) {
					tabbedCrearPoliza.setEnabledAt(i, true);
					 if (i != 1) {
					        tabbedCrearPoliza.setEnabledAt(i, false);
					    }
				}
				tabbedCrearPoliza.setSelectedIndex(1);
			}
		});
		btnSiguiente_1.setBounds(20, 404, 80, 27);
		buscarCliente.add(btnSiguiente_1);
		btnSiguiente_1.setFocusable(false);
		
		btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.setBounds(100, 404, 80, 27);
		buscarCliente.add(btnCancelar_1);
		btnCancelar_1.setFocusable(false);
			
		btnBuscarCliente = new JButton("Buscar cliente");
		btnBuscarCliente.setBounds(20, 220, 104, 27);
		buscarCliente.add(btnBuscarCliente);
		btnBuscarCliente.setFocusable(false);
			
		btnDarAltaCliente = new JButton("Dar de alta cliente");
		btnDarAltaCliente.setBounds(124, 220, 134, 27);
		buscarCliente.add(btnDarAltaCliente);
		btnDarAltaCliente.setFocusable(false);
		
		textFieldNroCliente = new JTextField();
		textFieldNroCliente.setBounds(128, 102, 123, 20);
		textFieldNroCliente.setColumns(10);
		buscarCliente.add(textFieldNroCliente);
		configuracionTextField(textFieldNroCliente);
		
		textFieldTipoDNI = new JTextField();
		textFieldTipoDNI.setColumns(10);
		textFieldTipoDNI.setBounds(128, 135, 123, 20);
		buscarCliente.add(textFieldTipoDNI);
		configuracionTextField(textFieldTipoDNI);
		
		textFieldNroDNI = new JTextField();
		textFieldNroDNI.setColumns(10);
		textFieldNroDNI.setBounds(128, 168, 123, 20);
		buscarCliente.add(textFieldNroDNI);
		configuracionTextField(textFieldNroDNI);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(449, 102, 123, 20);
		buscarCliente.add(textFieldApellido);
		configuracionTextField(textFieldApellido);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(449, 135, 123, 20);
		buscarCliente.add(textFieldNombre);
		configuracionTextField(textFieldNombre);
		
		textFieldDomicilio = new JTextField();
		textFieldDomicilio.setColumns(10);
		textFieldDomicilio.setBounds(449, 168, 123, 20);
		buscarCliente.add(textFieldDomicilio);
		configuracionTextField(textFieldDomicilio);
		
		lblMarcoCliente = new JLabel("");
		lblMarcoCliente.setIcon(Images.MARCO_CLIENTE);
		lblMarcoCliente.setBounds(5, 55, 725, 168);
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
		
		datosVehiculo = new JPanel();
		datosVehiculo.setBackground(new Color(255, 255, 255));
		tabbedCrearPoliza.addTab("Datos del vehiculo", null, datosVehiculo, null);
		datosVehiculo.setLayout(null);
	    pestaniaDatosDelVehiculo();
		
		datosHijos = new JPanel();
		datosHijos.setBackground(new Color(255, 255, 255));
		tabbedCrearPoliza.addTab("Datos de hijos", null, datosHijos, null);
		datosHijos.setLayout(null);
	
		pestaniaDatosHijos();
		
		
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
