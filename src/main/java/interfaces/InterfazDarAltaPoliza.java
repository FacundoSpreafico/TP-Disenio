package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.toedter.calendar.JDateChooser;

import constantes.Images;
import entidades.HijoCliente;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InterfazDarAltaPoliza extends JFrame {
	// JPanels
	private JPanel contentPane, buscarCliente, panelPrincipal, crearPoliza, confirmarPoliza, datosVehiculo, datosHijos, tipoPoliza, generacionPoliza;
	private JPanel panelContextoCliente, panelPoliza, panelContextoCliente_1, panelPoliza_2, panel;

	// JTabbedPanes
	private JTabbedPane tabbedPrincipal, tabbedCrearPoliza, tabbedConfirmarPoliza;

	// JButtons
	private JButton btnSiguiente_1, btnCancelar_1, btnBuscarCliente, btnDarAltaCliente, btnSiguiente_3, btnVolver_3, btnCancelar_3, btnSiguiente_2, btnCancelar_2, btnVolver_2, btnEditar;

	// JLabels
	private JLabel lblNroCliente, lblTipoDni, lblNroDni, lblApellido, lblNombre, lblDomicilio, lblNombre_1, lblApellido_1;
	private JLabel lblModeloVehiculo, lblSimbolo, lblSimbolo_2, lblSimbolo_3, lblMarcoPoliza_1;
	private JLabel lblSumaAsegurada, lblChasis, lblKmsAnio, lblNroSiniestros, lblSimbolo_1, lblMarcaDelVehiculo, lblSimbolo_4;
	private JLabel lblAoDelVehiculo, lblSimbolo_5, lblMotor, lblSimbolo_6, lblPatenteDelVehiculo, lblSimbolo_7, lblMedidasDeSeguridad;
	private JLabel lblNewLabel_1, lblContadorHijos;
	private JLabel lblSexo, lblApellido_2, lblNombre_2, lblFechaNacimiento, lblEstadoCivil, lblSex, lblAgregarHijo;

	// JTextFields
	private JTextField textFieldNroCliente, textFieldTipoDNI, textFieldNroDNI, textFieldApellido, textFieldNombre, textFieldDomicilio, textFieldNombre_1, textFieldApellido_1;
	private JTextField textFieldSumaAsegurada, textFieldChasis, textFieldPatenteVehiculo, textFieldMotor, textField_1, textField_2, textFieldHijos;

	// JSeparators
	private JSeparator separator_1, separator_2, separator_3, separator_4, separator_5, separator_6, separator_7, separator_8, separator_9, separator_10, separator_10_1;

	// JComboBoxes
	private JComboBox comboBoxKmsPorAnio, comboBoxSiniestrosUltAnio, comboBoxAnioVehiculo, comboBoxMarcaVehiculo, comboBoxModeloVehiculo;
	private JComboBox comboBoxEstadoCivil, comboBoxSexo;

	// JScrollPane
	private JScrollPane scrollPane, scrollPaneHijos;

	// JCheckBoxes
	private JCheckBox chckbxGuardaGarage, chckbxtieneAlarma, chckbxRastreoVehicular, chckbxTuercasAntirrobos;

	// JDateChooser
	private JDateChooser fechaNacimiento;

	// Arrays de opciones
	private String[] optionsEstadoCivil = {"Soltero/a", "Casado/a", "Divorciado/a", "Separado/A", "Viudo/A"};
	private String[] optionsSexo = {"Masculino", "Femenino"};

	// JTable
	private JTable tablaHijos;
	private JButton btnEliminar;

	public InterfazDarAltaPoliza() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Images.LOGO.getImage());
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

	//pestañas de la interfaz
	public void pestaniaDatosHijos() {
		List<HijoCliente> listaHijos = new ArrayList<>();
		
		JButton btnSiguiente_3 = new JButton("Siguiente");
		btnSiguiente_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSiguiente_3.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSiguiente_3.setFocusable(false);
		btnSiguiente_3.setBounds(20, 404, 89, 23);
		datosHijos.add(btnSiguiente_3);
		
		JButton btnVolver_3 = new JButton("Volver");
		btnVolver_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dialogoVolver(tabbedCrearPoliza.getSelectedIndex());
			}
		});
		btnVolver_3.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVolver_3.setFocusable(false);
		btnVolver_3.setBounds(108, 404, 82, 23);
		datosHijos.add(btnVolver_3);
		
		JButton btnCancelar_3 = new JButton("Cancelar");
		btnCancelar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogoCancelar();
			}
		});
		btnCancelar_3.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar_3.setFocusable(false);
		btnCancelar_3.setBounds(190, 404, 89, 23);
		datosHijos.add(btnCancelar_3);
		
		panelContextoCliente_1 = new JPanel();
		panelContextoCliente_1.setLayout(null);
		panelContextoCliente_1.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelContextoCliente_1.setBackground(Color.WHITE);
		panelContextoCliente_1.setBounds(15, 11, 797, 64);
		datosHijos.add(panelContextoCliente_1);
		
		separator_9 = new JSeparator();
		separator_9.setForeground(Color.BLACK);
		separator_9.setBackground(Color.BLACK);
		separator_9.setBounds(441, 39, 123, 2);
		panelContextoCliente_1.add(separator_9);
		
		separator_10 = new JSeparator();
		separator_10.setForeground(Color.BLACK);
		separator_10.setBackground(Color.BLACK);
		separator_10.setBounds(80, 39, 123, 2);
		panelContextoCliente_1.add(separator_10);
		
		lblApellido_2 = new JLabel("Apellido");
		lblApellido_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellido_2.setBounds(385, 27, 46, 14);
		panelContextoCliente_1.add(lblApellido_2);
		
		lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre_2.setBounds(24, 27, 46, 14);
		panelContextoCliente_1.add(lblNombre_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(441, 19, 123, 20);
		panelContextoCliente_1.add(textField_1);
		configuracionTextField(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(80, 19, 123, 20);
		panelContextoCliente_1.add(textField_2);
		configuracionTextField(textField_2);
		
		panelPoliza_2 = new JPanel();
		panelPoliza_2.setBackground(Color.WHITE);
		panelPoliza_2.setBounds(20, 86, 798, 305);
		datosHijos.add(panelPoliza_2);
		panelPoliza_2.setBorder(new TitledBorder(null, "Poliza", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPoliza_2.setLayout(null);
		
		
		
		lblAgregarHijo = new JLabel("Agregar hijo");
		lblAgregarHijo.setFont(new Font("Arial", Font.BOLD, 12));
		lblAgregarHijo.setBounds(15, 71, 94, 14);
		panelPoliza_2.add(lblAgregarHijo);
		
		lblFechaNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaNacimiento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFechaNacimiento.setBounds(15, 116, 118, 14);
		panelPoliza_2.add(lblFechaNacimiento);
		
		fechaNacimiento = new JDateChooser();
		fechaNacimiento.setBounds(143, 110, 111, 20);
		panelPoliza_2.add(fechaNacimiento);
		
		lblEstadoCivil = new JLabel("Estado civil");
		lblEstadoCivil.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEstadoCivil.setBounds(15, 158, 77, 14);
		panelPoliza_2.add(lblEstadoCivil);
		
		comboBoxEstadoCivil = new JComboBox(optionsEstadoCivil);
		comboBoxEstadoCivil.setBounds(143, 154, 111, 22);
		
		panelPoliza_2.add(comboBoxEstadoCivil);
		
		lblSex = new JLabel("Sexo");
		lblSex.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSex.setBounds(15, 202, 77, 14);
		panelPoliza_2.add(lblSex);
		
		comboBoxSexo = new JComboBox(optionsSexo);
		comboBoxSexo.setBounds(142, 198, 112, 22);
		panelPoliza_2.add(comboBoxSexo);
		
		JLabel lblContadorHijos_1 = new JLabel("Hijos (entre 18 y 30 años)");
		lblContadorHijos_1.setBounds(15, 30, 161, 14);
		panelPoliza_2.add(lblContadorHijos_1);
		lblContadorHijos_1.setFont(new Font("Arial", Font.PLAIN, 12));
			
		scrollPaneHijos = new JScrollPane();
		scrollPaneHijos.setBorder(null);
		scrollPaneHijos.setBounds(299, 21, 477, 227);
		panelPoliza_2.add(scrollPaneHijos);
			
		tablaHijos = new JTable();
		scrollPaneHijos.setViewportView(tablaHijos);
		tablaHijos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				"Fecha nacimiento", "Estado civil", "Sexo"
				}
		));
		tablaHijos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        int filaSeleccionada = tablaHijos.getSelectedRow();
		        if (filaSeleccionada != -1) {
		            btnEditar.setEnabled(true);
		            btnEliminar.setEnabled(true);
		        } else {
		            btnEditar.setEnabled(false);
		            btnEliminar.setEnabled(false);
		        }
		    }
		});
		JButton btnAgregar = new JButton("Agregar");
		DefaultTableModel modelo = (DefaultTableModel) tablaHijos.getModel();
		btnAgregar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Obtener valores seleccionados
		            String sexo = comboBoxSexo.getSelectedItem().toString();
		            String estadoCivil = comboBoxEstadoCivil.getSelectedItem().toString();
		            Date fechaSeleccionada = fechaNacimiento.getDate();
		            if (verificarEdad(fechaSeleccionada)){
		            	 // Ajustamos el formato de la fecha para pasarlo a string
			            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			            String fechaString = dateFormat.format(fechaSeleccionada);
			            Object[] nuevaFila = { fechaString, estadoCivil, sexo };

			            modelo.addRow(nuevaFila);
			            modelo.fireTableDataChanged();
			            textFieldHijos.setText(String.valueOf(modelo.getRowCount()));
			            comboBoxSexo.setSelectedIndex(0);
			            comboBoxEstadoCivil.setSelectedIndex(0);
			            fechaNacimiento.setDate(null);
			            fechaNacimiento.requestFocus();
		            }
		          
                   

		        } catch (Exception ex) {
		            
		        }
		    }
		});

		btnAgregar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregar.setFocusable(false);
		btnAgregar.setBounds(15, 259, 89, 23);
		panelPoliza_2.add(btnAgregar);
		
		
		
		btnEditar = new JButton("Editar");
        configuracionBotonEditarHijo();

		panelPoliza_2.add(btnEditar);
		
		
		textFieldHijos = new JTextField();
		textFieldHijos.setFont(new Font("Arial", Font.BOLD, 12));
		textFieldHijos.setEnabled(true);
		textFieldHijos.setColumns(10);
		textFieldHijos.setBounds(182, 21, 20, 20);
		panelPoliza_2.add(textFieldHijos);
		configuracionTextField(textFieldHijos);
		
		
		separator_10_1 = new JSeparator();
		separator_10_1.setForeground(Color.BLACK);
		separator_10_1.setBackground(Color.BLACK);
		separator_10_1.setBounds(177, 41, 29, 2);
		panelPoliza_2.add(separator_10_1);
		
		btnEliminar = new JButton("Eliminar");
		configuracionBotonEliminarHijo();
			
			
	}
    public void pestaniaDatosDelVehiculo() {
		comboBoxMarcaVehiculo = new JComboBox<>();
		comboBoxMarcaVehiculo.setBackground(Color.WHITE);
		comboBoxMarcaVehiculo.setBounds(541, 150, 154, 22);
		datosVehiculo.add(comboBoxMarcaVehiculo);
		
		comboBoxAnioVehiculo = new JComboBox<>();
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
		
		comboBoxSiniestrosUltAnio = new JComboBox<>();
		comboBoxSiniestrosUltAnio.setBackground(Color.WHITE);
		comboBoxSiniestrosUltAnio.setBounds(178, 284, 154, 22);
		datosVehiculo.add(comboBoxSiniestrosUltAnio);
		
		comboBoxKmsPorAnio = new JComboBox<>();
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
		
		comboBoxModeloVehiculo = new JComboBox<>();
		comboBoxModeloVehiculo.setBackground(Color.WHITE);
		comboBoxModeloVehiculo.setBounds(178, 150, 154, 22);
		datosVehiculo.add(comboBoxModeloVehiculo);
		
		lblMotor = new JLabel("Motor");
		lblMotor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMotor.setBounds(398, 215, 40, 14);
		datosVehiculo.add(lblMotor);
		
		lblAoDelVehiculo = new JLabel("Año del vehiculo");
		lblAoDelVehiculo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAoDelVehiculo.setBounds(398, 186, 94, 14);
		datosVehiculo.add(lblAoDelVehiculo);
		
		lblMarcaDelVehiculo = new JLabel("Marca del vehiculo");
		lblMarcaDelVehiculo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMarcaDelVehiculo.setBounds(398, 154, 107, 14);
		datosVehiculo.add(lblMarcaDelVehiculo);
		
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
		
		lblModeloVehiculo = new JLabel("Modelo del vehiculo");
		lblModeloVehiculo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblModeloVehiculo.setBounds(40, 154, 113, 14);
		datosVehiculo.add(lblModeloVehiculo);
		
		btnSiguiente_2 = new JButton("Siguiente");
		btnSiguiente_2.setFont(new Font("Arial", Font.PLAIN, 12));
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
		btnSiguiente_2.setBounds(20, 404, 89, 23);
		datosVehiculo.add(btnSiguiente_2);
		
		btnCancelar_2 = new JButton("Cancelar");
		btnCancelar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogoCancelar();
			}
		});
		btnCancelar_2.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar_2.setFocusable(false);
		btnCancelar_2.setBounds(190, 404, 89, 23);
		datosVehiculo.add(btnCancelar_2);
		
		btnVolver_2 = new JButton("Volver");
		btnVolver_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogoVolver(tabbedCrearPoliza.getSelectedIndex());
			}
		});
		btnVolver_2.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVolver_2.setFocusable(false);
		btnVolver_2.setBounds(108, 404, 82, 23);
		datosVehiculo.add(btnVolver_2);
		
		
		
		panelContextoCliente = new JPanel();
		panelContextoCliente.setBackground(Color.WHITE);
		panelContextoCliente.setBounds(15, 11, 797, 64);
		datosVehiculo.add(panelContextoCliente);
		panelContextoCliente.setLayout(null);
		panelContextoCliente.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		separator_7 = new JSeparator();
		separator_7.setBounds(441, 39, 123, 2);
		panelContextoCliente.add(separator_7);
		separator_7.setForeground(Color.BLACK);
		separator_7.setBackground(Color.BLACK);
		
		separator_6 = new JSeparator();
		separator_6.setBounds(80, 39, 123, 2);
		panelContextoCliente.add(separator_6);
		separator_6.setForeground(Color.BLACK);
		separator_6.setBackground(Color.BLACK);
		
		lblApellido_1 = new JLabel("Apellido");
		lblApellido_1.setBounds(385, 27, 46, 14);
		panelContextoCliente.add(lblApellido_1);
		lblApellido_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(24, 27, 46, 14);
		panelContextoCliente.add(lblNombre_1);
		lblNombre_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		textFieldApellido_1 = new JTextField();
		textFieldApellido_1.setBounds(441, 19, 123, 20);
		panelContextoCliente.add(textFieldApellido_1);
		textFieldApellido_1.setColumns(10);
		configuracionTextField(textFieldApellido_1);
		
		textFieldNombre_1 = new JTextField();
		textFieldNombre_1.setBounds(80, 19, 123, 20);
		panelContextoCliente.add(textFieldNombre_1);
		textFieldNombre_1.setColumns(10);
		configuracionTextField(textFieldNombre_1);
		
		panelPoliza = new JPanel();
		panelPoliza.setBackground(Color.WHITE);
		panelPoliza.setBounds(20, 86, 798, 305);
		datosVehiculo.add(panelPoliza);
		panelPoliza.setBorder(new TitledBorder(null, "Poliza", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPoliza.setLayout(null);
		
		chckbxGuardaGarage = new JCheckBox("¿Se guarda en garage?");
		chckbxGuardaGarage.setBounds(378, 203, 174, 23);
		panelPoliza.add(chckbxGuardaGarage);
		chckbxGuardaGarage.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxGuardaGarage.setBackground(Color.WHITE);
		
		chckbxtieneAlarma = new JCheckBox("¿Tiene alarma?");
		chckbxtieneAlarma.setBounds(378, 227, 154, 23);
		panelPoliza.add(chckbxtieneAlarma);
		chckbxtieneAlarma.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxtieneAlarma.setBackground(Color.WHITE);
		
		chckbxRastreoVehicular = new JCheckBox("¿Posee dispositivo de rastreo vehicular?");
		chckbxRastreoVehicular.setBounds(378, 251, 256, 23);
		panelPoliza.add(chckbxRastreoVehicular);
		chckbxRastreoVehicular.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxRastreoVehicular.setBackground(Color.WHITE);
		
		chckbxTuercasAntirrobos = new JCheckBox("¿Posee tuercas antirrobo en las cuatro ruedas?");
		chckbxTuercasAntirrobos.setBounds(378, 275, 297, 23);
		panelPoliza.add(chckbxTuercasAntirrobos);
		chckbxTuercasAntirrobos.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxTuercasAntirrobos.setBackground(Color.WHITE);
		
		lblMedidasDeSeguridad = new JLabel("Medidas de seguridad");
		lblMedidasDeSeguridad.setBounds(380, 182, 133, 14);
		panelPoliza.add(lblMedidasDeSeguridad);
		lblMedidasDeSeguridad.setFont(new Font("Arial", Font.BOLD, 12));
		
		lblPatenteDelVehiculo = new JLabel("Patente del vehiculo");
		lblPatenteDelVehiculo.setBounds(378, 157, 113, 14);
		panelPoliza.add(lblPatenteDelVehiculo);
		lblPatenteDelVehiculo.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo_7 = new JLabel("(*)");
		lblSimbolo_7.setBounds(501, 157, 19, 14);
		panelPoliza.add(lblSimbolo_7);
		lblSimbolo_7.setForeground(Color.RED);
		lblSimbolo_7.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo_6 = new JLabel("(*)");
		lblSimbolo_6.setBounds(501, 128, 19, 14);
		panelPoliza.add(lblSimbolo_6);
		lblSimbolo_6.setForeground(Color.RED);
		lblSimbolo_6.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo_5 = new JLabel("(*)");
		lblSimbolo_5.setBounds(501, 98, 19, 14);
		panelPoliza.add(lblSimbolo_5);
		lblSimbolo_5.setForeground(Color.RED);
		lblSimbolo_5.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo_4 = new JLabel("(*)");
		lblSimbolo_4.setBounds(501, 67, 19, 14);
		panelPoliza.add(lblSimbolo_4);
		lblSimbolo_4.setForeground(Color.RED);
		lblSimbolo_4.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo = new JLabel("(*)");
		lblSimbolo.setBounds(138, 67, 19, 14);
		panelPoliza.add(lblSimbolo);
		lblSimbolo.setForeground(Color.RED);
		lblSimbolo.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo_2 = new JLabel("(*)");
		lblSimbolo_2.setBounds(138, 138, 19, 14);
		panelPoliza.add(lblSimbolo_2);
		lblSimbolo_2.setForeground(Color.RED);
		lblSimbolo_2.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo_3 = new JLabel("(*)");
		lblSimbolo_3.setBounds(138, 169, 19, 14);
		panelPoliza.add(lblSimbolo_3);
		lblSimbolo_3.setForeground(Color.RED);
		lblSimbolo_3.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo_1 = new JLabel("(*)");
		lblSimbolo_1.setBounds(138, 203, 19, 14);
		panelPoliza.add(lblSimbolo_1);
		lblSimbolo_1.setForeground(Color.RED);
		lblSimbolo_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		
	}
    public void pestaniaBuscarCliente() {
		configuracionBuscarCliente();
		
		btnSiguiente_1 = new JButton("Siguiente");
		btnSiguiente_1.setFont(new Font("Arial", Font.PLAIN, 12));
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
		btnSiguiente_1.setBounds(20, 404, 89, 23);
		buscarCliente.add(btnSiguiente_1);
		btnSiguiente_1.setFocusable(false);
		
		btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogoCancelar();
			}
		});
		btnCancelar_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar_1.setBounds(108, 404, 89, 23);
		buscarCliente.add(btnCancelar_1);
		btnCancelar_1.setFocusable(false);
			
		btnBuscarCliente = new JButton("Buscar cliente");
		btnBuscarCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		btnBuscarCliente.setBounds(20, 220, 111, 23);
		buscarCliente.add(btnBuscarCliente);
		btnBuscarCliente.setFocusable(false);
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InterfazBuscarCliente buscarCliente = new InterfazBuscarCliente();
					buscarCliente.setVisible(true);
				} catch (Exception e1) {
				}

			}
		});
		
			
		btnDarAltaCliente = new JButton("Dar de alta cliente");
		btnDarAltaCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDarAltaCliente.setBounds(129, 220, 134, 23);
		buscarCliente.add(btnDarAltaCliente);
		btnDarAltaCliente.setFocusable(false);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBackground(Color.WHITE);
		panelCliente.setBounds(20, 58, 759, 157);
		buscarCliente.add(panelCliente);
		panelCliente.setLayout(null);
		panelCliente.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		separator_5 = new JSeparator();
		separator_5.setBounds(469, 132, 123, 2);
		panelCliente.add(separator_5);
		separator_5.setForeground(Color.BLACK);
		separator_5.setBackground(Color.BLACK);
		
		separator_4 = new JSeparator();
		separator_4.setBounds(469, 99, 123, 2);
		panelCliente.add(separator_4);
		separator_4.setForeground(Color.BLACK);
		separator_4.setBackground(Color.BLACK);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(469, 66, 123, 2);
		panelCliente.add(separator_3);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		
		lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(405, 120, 72, 14);
		panelCliente.add(lblDomicilio);
		lblDomicilio.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(405, 53, 72, 14);
		panelCliente.add(lblApellido);
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(405, 87, 72, 14);
		panelCliente.add(lblNombre);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(469, 48, 123, 20);
		panelCliente.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		configuracionTextField(textFieldApellido);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(469, 81, 123, 20);
		panelCliente.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		configuracionTextField(textFieldNombre);
		
		textFieldDomicilio = new JTextField();
		textFieldDomicilio.setBounds(469, 114, 123, 20);
		panelCliente.add(textFieldDomicilio);
		textFieldDomicilio.setColumns(10);
		configuracionTextField(textFieldDomicilio);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(111, 132, 123, 2);
		panelCliente.add(separator_2);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		JSeparator separator = new JSeparator();
		separator.setBounds(111, 66, 123, 2);
		panelCliente.add(separator);
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(111, 99, 123, 2);
		panelCliente.add(separator_1);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		
		lblNroDni = new JLabel("Nro. DNI");
		lblNroDni.setBounds(29, 120, 72, 14);
		panelCliente.add(lblNroDni);
		lblNroDni.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblTipoDni = new JLabel("Tipo DNI");
		lblTipoDni.setBounds(29, 87, 72, 14);
		panelCliente.add(lblTipoDni);
		lblTipoDni.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblNroCliente = new JLabel("Nro. Cliente");
		lblNroCliente.setBounds(29, 53, 72, 14);
		panelCliente.add(lblNroCliente);
		lblNroCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		
		textFieldNroCliente = new JTextField();
		textFieldNroCliente.setBounds(111, 48, 123, 20);
		panelCliente.add(textFieldNroCliente);
		textFieldNroCliente.setColumns(10);
		configuracionTextField(textFieldNroCliente);
		
		textFieldTipoDNI = new JTextField();
		textFieldTipoDNI.setBounds(111, 81, 123, 20);
		panelCliente.add(textFieldTipoDNI);
		textFieldTipoDNI.setColumns(10);
		configuracionTextField(textFieldTipoDNI);
		
		textFieldNroDNI = new JTextField();
		textFieldNroDNI.setBounds(111, 114, 123, 20);
		panelCliente.add(textFieldNroDNI);
		textFieldNroDNI.setColumns(10);
		configuracionTextField(textFieldNroDNI);
	}
	public void pestaniaCrearPoliza() {
		tabbedPrincipal.setEnabledAt(1, false);
		pestaniaBuscarCliente();
	}
	public void pestaniaConfirmarPoliza() {
		tabbedPrincipal.setEnabledAt(0, false);
	}
	
    //funciones de configuracion
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
	public void configuracionTextField(JTextField textField) {
		textField.setBorder(null);
		textField.setFocusable(false);
		textField.setBackground(Color.WHITE);
		textField.setEnabled(false);
	}
	public void configuracionBuscarCliente() {
		tabbedCrearPoliza.setSelectedIndex(0);
		tabbedCrearPoliza.setEnabledAt(0,true);
		for (int i=1; i<tabbedCrearPoliza.getComponentCount(); i++) {
			tabbedCrearPoliza.setEnabledAt(i, false);
		}
	}
    public void configuracionDatosVehiculo() {
		tabbedCrearPoliza.setSelectedIndex(1);
		tabbedCrearPoliza.setEnabledAt(1,true);
		for (int i=0; i<tabbedCrearPoliza.getComponentCount(); i++) {
			if (i!=1) {
			tabbedCrearPoliza.setEnabledAt(i, false);
			}
		}
    }
    public void configuracionBotonEditarHijo(){
    	btnEditar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditar.setFocusable(false);
		btnEditar.setBounds(299, 259, 89, 23);
		btnEditar.setEnabled(false);
    	
		
		btnEditar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		   
		    int filaSeleccionada = tablaHijos.getSelectedRow();
		    if (filaSeleccionada != -1) {
			 String fechaNacimiento_seleccionada = tablaHijos.getValueAt(filaSeleccionada, 0).toString();
			 String estadoCivil_seleccionado = tablaHijos.getValueAt(filaSeleccionada, 1).toString();
			 String sexo_seleccionado = tablaHijos.getValueAt(filaSeleccionada, 2).toString();
			 
			 Object[] nuevoDatos = new Object[3];
	         JPanel panel = new JPanel();
	         panel.setLayout(new GridLayout(6, 2));
	         
	         JDateChooser fechaNacimiento_editar = new JDateChooser();
	         
	         try {
	         Date fechaSeleccionadaDate = new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento_seleccionada);
	         fechaNacimiento_editar.setDate(fechaSeleccionadaDate);
	            } 
	         catch (Exception ex) { 
	            }
	         JComboBox sexo_editar = new JComboBox(optionsSexo);
	         sexo_editar.setSelectedItem(sexo_seleccionado);
	         JComboBox estadoCivil_editar = new JComboBox(optionsEstadoCivil);
	         estadoCivil_editar.setSelectedItem(estadoCivil_seleccionado);
	            
	         panel.add(new JLabel("Fecha de nacimiento: "));
	         panel.add(fechaNacimiento_editar);
	         panel.add(new JLabel("Estado civil: "));
	         panel.add(estadoCivil_editar);
	         panel.add(new JLabel("Sexo: "));
	         panel.add(sexo_editar);
	            
	         int result = JOptionPane.showOptionDialog(null,panel,"Editar hijo",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,new Object[]{"Aceptar", "Cancelar"},null);

	        		if (result == JOptionPane.YES_OPTION) {
	        			if(verificarEdad(fechaNacimiento_editar.getDate())){
	        				String nuevaFechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").format(fechaNacimiento_editar.getDate());
		                    String nuevoEstadoCivil = estadoCivil_editar.getSelectedItem().toString();
		                    String nuevoSexo = sexo_editar.getSelectedItem().toString();
		                    // Actualizar los valores en el modelo de la tabla
		                    DefaultTableModel model = (DefaultTableModel) tablaHijos.getModel();
		                    model.setValueAt(nuevaFechaNacimiento, filaSeleccionada, 0);
		                    model.setValueAt(nuevoEstadoCivil, filaSeleccionada, 1);
		                    model.setValueAt(nuevoSexo, filaSeleccionada, 2);
		                    // Refrescar la vista de la tabla
		                    model.fireTableDataChanged();
	        			}
	        		}
			 
			 
        } else {
            System.out.println("No hay fila seleccionada. Deshabilitando el botón.");
            btnEditar.setEnabled(false);
        }
		}});

    }
    public void configuracionBotonEliminarHijo() {
    	btnEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminar.setFocusable(false);
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(388, 259, 89, 23);
		panelPoliza_2.add(btnEliminar);

    	
    }
    public void limpiarCamposVehiculo() {
		comboBoxModeloVehiculo.setSelectedItem(null);
		textFieldSumaAsegurada.setText(null);
		textFieldChasis.setText(null);
		comboBoxKmsPorAnio.setSelectedItem(null);
		comboBoxSiniestrosUltAnio.setSelectedItem(null);
		comboBoxMarcaVehiculo.setSelectedItem(null);
	    comboBoxAnioVehiculo.setSelectedItem(null);	
	    textFieldMotor.setText(null);
	    textFieldPatenteVehiculo.setText(null);
	    chckbxGuardaGarage.setSelected(false);
	    chckbxtieneAlarma.setSelected(false);
	    chckbxRastreoVehicular.setSelected(false);
	    chckbxTuercasAntirrobos.setSelected(false);
	}
    public void dialogoVolver(int index) {
		switch (index) {
		case 1:
			switch(JOptionPane.showConfirmDialog(null,"Los datos ingresados se eliminarán, ¿está seguro que desea volver? ","Alerta",JOptionPane.YES_NO_OPTION)) {
			case JOptionPane.YES_OPTION:
			tabbedCrearPoliza.setSelectedIndex(index-1);
			configuracionBuscarCliente();
			limpiarCamposVehiculo();
			break;
			case JOptionPane.NO_OPTION:
			break;
			}
		break;
		case 2:
		tabbedCrearPoliza.setSelectedIndex(index-1);
		configuracionDatosVehiculo();
		break;
		
		
		}
	}
    public boolean verificarEdad(Date fechaNacimiento) {
    	  // Verificar que se haya seleccionado una fecha
        if (fechaNacimiento == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha de nacimiento válida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false; 
        }

        // Calcular la edad
        Calendar fechaNacimientoCal = Calendar.getInstance();
        fechaNacimientoCal.setTime(fechaNacimiento);
        Calendar fechaActual = Calendar.getInstance();

        int edad = fechaActual.get(Calendar.YEAR) - fechaNacimientoCal.get(Calendar.YEAR);

        // Ajustar la edad si aún no ha pasado el cumpleaños de este año
        
        if (fechaActual.get(Calendar.DAY_OF_YEAR) < fechaNacimientoCal.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }

        // Verificar que la edad esté entre 18 y 30 años
        if (edad < 18 || edad > 30) {
            JOptionPane.showMessageDialog(null, "El hijo no cumple con la edad requerida (entre 18 y 30 años).", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    public void dialogoCancelar() {
    	int opcion = JOptionPane.showConfirmDialog(null,"¿Está seguro de que desea cancelar el alta de la poliza?","Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
        	System.exit(0);
        }
    }
}
