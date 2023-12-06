package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import DTO.ClienteDTO;
import DTO.CoberturaDTO;
import DTO.DomicilioRiesgoDTO;
import DTO.HijoClienteDTO;
import DTO.MedidaDeSeguridadDTO;
import DTO.ModeloDTO;
import DTO.PolizaDTO;
import DTO.VehiculoDTO;
import constantes.Images;
import entidades.Cobertura;
import entidades.Localidad;
import entidades.Marca;
import entidades.Modelo;
import entidades.Pais;
import entidades.Provincia;
import excepciones.DatosNoIngresadosException;
import excepciones.FechaInicioInvalidaException;
import gestores.GestorCliente;
import gestores.GestorCobertura;
import gestores.GestorHijoCliente;
import gestores.GestorLocalidad;
import gestores.GestorPoliza;
import gestores.GestorSumaAsegurada;
import gestores.GestorVehiculo;

public class InterfazDarAltaPoliza extends JFrame {
	// JPanels
	private JPanel contentPane, buscarCliente, panelPrincipal, crearPoliza, confirmarPoliza, datosVehiculo, datosHijos, tipoPoliza, generacionPoliza;
	private JPanel panelContextoCliente, panelPoliza, panelContextoCliente_1, panelPoliza_2, panel;

	// JTabbedPanes
	private JTabbedPane tabbedPrincipal, tabbedCrearPoliza, tabbedConfirmarPoliza;

	// JButtons
	private JButton btnSiguiente_1, btnCancelar_1, btnBuscarCliente, btnDarAltaCliente, btnSiguiente_3, btnVolver_3, btnCancelar_3, btnSiguiente_2, btnCancelar_2, btnVolver_2, btnEditar,btnAgregar;

	// JLabels
	private JLabel lblNroCliente, lblTipoDocumento, lblNroDni, lblApellido, lblNombre, lblDomicilio, lblNombre_1, lblApellido_1;
	private JLabel lblModeloVehiculo, lblSimbolo, lblSimbolo_2, lblSimbolo_3, lblMarcoPoliza_1;
	private JLabel lblSumaAsegurada, lblChasis, lblKmsAnio, lblNroSiniestros, lblSimbolo_1, lblMarcaDelVehiculo, lblSimbolo_4;
	private JLabel lblAoDelVehiculo, lblSimbolo_5, lblMotor, lblSimbolo_6, lblPatenteDelVehiculo, lblSimbolo_7, lblMedidasDeSeguridad;
	private JLabel lblNewLabel_1, lblContadorHijos;
	private JLabel lblSexo, lblApellido_2, lblNombre_2, lblFechaNacimiento, lblEstadoCivil, lblSex, lblAgregarHijo;

	// JTextFields
	private JTextField textFieldNroCliente, textFieldTipoDocumento, textFieldNroDNI, textFieldApellido, textFieldNombre, textFieldDomicilio, textFieldNombre_1, textFieldApellido_1;
	private JTextField textFieldApellido_2, textFieldNombre_2, textFieldHijos;

	// JSeparators
	private JSeparator separator_1, separator_2, separator_3, separator_4, separator_5, separator_6, separator_7, separator_8, separator_9, separator_10, separator_10_1;

	// JComboBoxes
	private JComboBox comboBoxEstadoCivil, comboBoxSexo;

	// JScrollPane
	private JScrollPane scrollPane, scrollPaneHijos;

	// JCheckBoxes
	private JCheckBox chckbxGuardaGarage, chckbxtieneAlarma, chckbxRastreoVehicular, chckbxTuercasAntirrobos;

	// JDateChooser
	private JDateChooser fechaNacimiento;

	// Arrays de opciones
	private String[] optionsEstadoCivil = {"<Seleccione>","Soltero/a", "Casado/a", "Divorciado/a", "Separado/A", "Viudo/A"};
	private String[] optionsSexo = {"<Seleccione>","Masculino", "Femenino"};

	// JTable
	private JTable tablaHijos;
	private JButton btnEliminar;
	
	private JFormattedTextField formattedTextField;

	
	
	
	//Campos datos de vehiculo
	private JComboBox<Object> comboBoxPaisRiesgo, comboBoxLocalidadRiesgo, comboBoxProvinciaRiesgo,
	comboBoxKmsPorAnio, comboBoxSiniestrosUltAnio, comboBoxAnioVehiculo, comboBoxModeloVehiculo, comboBoxMarcaVehiculo;
	private JTextField textFieldSumaAsegurada, textFieldChasis = new JTextField(), textFieldPatenteVehiculo, textFieldMotor;
	JDateChooser fechaInicio;
	private JTextField textFieldApellido_3;
	private JTextField textFieldNombre_3;
	private JPanel panelTipoPoliza;
	private JLabel lblFechaInicio;
	private JLabel lblTipoCobertura;
	private JTabbedPane tabbedPaneDatosPoliza;
	private JPanel panelCuotasSemestral;
	private JTextField textFieldTitularSeguro;
	private JTextField textField_Marca;
	private JTextField textField_Modelo;
	private JTextField textFieldChasis_1;
	private JTextField textField_Motor;
	private JTextField textField_Patente;
	private JPanel panelGeneracionPoliza_1;
	private JTextField textField_SumaAsegurada;
	private JSeparator separatorTitularSeguro_1;
	private JDateChooser fechaUltDiaPago;
	private JLabel lblSumaAsegurada_1;
	private JTextField textField_Premio;
	private JTextField textField_ImportePDesc;
	private JTextField textFieldMontoTotal;
	private JSeparator separatorTitularSeguro_2;
	private JLabel lblSumaAsegurada_2;
	private JPanel panelCuotasMensuales;
	private JPanel panelGeneracionPoliza_2;
	private JTextField textField_SumaAsegurada_2;
    private JSeparator separatorSumaAsegurada;
    private JLabel lblSumaAsegurada_3;
    private JTextField textField_Premio_2;
    private JLabel lblPremio;
    private JSeparator separatorPremio;
    private JTextField textField_ImportePDesc_1;
    private JSeparator separatorImportePDesc;
    private JLabel lblImportePorDesc;
    private JTextField textFieldCuota1;
    private JTextField textFieldCuota2;
    private JTextField textFieldCuota3;
    private JTextField textFieldCuota4;
    private JTextField textFieldCuota5;
    private JTextField textFieldCuota6;
    private JTextField textFieldMontoTotalAPagar;
    private JLabel lblProvinciaDeRiesgo;
    private JLabel lblSimbolo_9;
    private JLabel lblLocalidadDeRiesgo;
    private JLabel lblSimbolo_10;
    
    private VehiculoDTO vehiculoDTO;
    private ClienteDTO clienteDTO;
    private PolizaDTO polizaDTO;
    private JDateChooser fechaInicio_1, fechaFin;
    JComboBox<String> comboBoxTipoCobertura;
    private JButton btnNewButton;
    
	public InterfazDarAltaPoliza() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ParseException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Images.MILEI.getImage());
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
	@SuppressWarnings("serial")
	public void pestaniaDatosHijos() {
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(
		                InterfazDarAltaPoliza.this,
		                "¿Estás seguro de que deseas confirmar la generación de la póliza?",
		                "Confirmar Generación de Póliza",
		                JOptionPane.YES_NO_OPTION);
				
				if (respuesta == JOptionPane.YES_OPTION) {
					textField_Marca.setText(vehiculoDTO.getModelo().getNombreMarca());
					textField_Modelo.setText(vehiculoDTO.getModelo().getNombreModelo());
					textFieldChasis_1.setText(vehiculoDTO.getChasis());
					textField_Motor.setText(vehiculoDTO.getMotor());
					textField_Patente.setText(vehiculoDTO.getPatente());
					int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
			        int yearVehicle = Integer.parseInt(comboBoxAnioVehiculo.getSelectedItem().toString());
					
					if ((yearCurrent - yearVehicle) > 10) {
						comboBoxTipoCobertura.addItem("Responsabilidad Civil");
					}
					else {
						for (Cobertura coberturas: GestorCobertura.getInstance().recuperarCoberturas()) {
							comboBoxTipoCobertura.addItem(coberturas.getNombreCobertura());	
							}
					}
					List<HijoClienteDTO> hijosCliente = new ArrayList<HijoClienteDTO>();
					int cantFilas = tablaHijos.getRowCount();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					
					for(int i = 0; i < cantFilas; i++) {
						
						try {
							Date fechaNacimiento = dateFormat.parse(tablaHijos.getValueAt(i, 0).toString());
							String estadoCivil = tablaHijos.getValueAt(i, 1).toString();
							String sexo = tablaHijos.getValueAt(i,2).toString();
							hijosCliente.add(new HijoClienteDTO(fechaNacimiento, estadoCivil, sexo));
						} catch (ParseException e1) {
							
							e1.printStackTrace();
						}
					}
					polizaDTO.setHijos(hijosCliente);
					
                  
                    
					pestaniaConfirmarPoliza();
		        } 
			}
		});
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConfirmar.setFocusable(false);
		btnConfirmar.setBounds(20, 404, 89, 23);
		datosHijos.add(btnConfirmar);
		
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
		separator_9.setBounds(441, 42, 123, 2);
		panelContextoCliente_1.add(separator_9);
		
		separator_10 = new JSeparator();
		separator_10.setForeground(Color.BLACK);
		separator_10.setBackground(Color.BLACK);
		separator_10.setBounds(80, 42, 123, 2);
		panelContextoCliente_1.add(separator_10);
		
		lblApellido_2 = new JLabel("Apellido");
		lblApellido_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellido_2.setBounds(385, 30, 46, 14);
		panelContextoCliente_1.add(lblApellido_2);
		
		lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre_2.setBounds(24, 30, 46, 14);
		panelContextoCliente_1.add(lblNombre_2);
		
		//campo apellido
		textFieldApellido_2 = new JTextField();
		textFieldApellido_2.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldApellido_2.setColumns(10);
		textFieldApellido_2.setBounds(441, 24, 123, 20);
		panelContextoCliente_1.add(textFieldApellido_2);
		configuracionTextField(textFieldApellido_2);
		
		//campo nombre
		textFieldNombre_2 = new JTextField();
		textFieldNombre_2.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldNombre_2.setColumns(10);
		textFieldNombre_2.setBounds(80, 24, 123, 20);
		panelContextoCliente_1.add(textFieldNombre_2);
		configuracionTextField(textFieldNombre_2);
		
		panelPoliza_2 = new JPanel();
		panelPoliza_2.setBackground(Color.WHITE);
		panelPoliza_2.setBounds(15, 86, 797, 305);
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
		        new Object[][]{},
		        new String[]{"Fecha nacimiento", "Estado civil", "Sexo"}) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		}
		);
		
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
		
		btnAgregar = new JButton("Agregar");
		configuracionBotonAgregarHijo();
		btnEliminar = new JButton("Eliminar");
		configuracionBotonEliminarHijo();
		btnEditar = new JButton("Editar");
        configuracionBotonEditarHijo();
		
		textFieldHijos = new JTextField();
		textFieldHijos.setFont(new Font("Arial", Font.BOLD, 12));
		textFieldHijos.setEnabled(true);
		textFieldHijos.setColumns(10);
		textFieldHijos.setBounds(182, 21, 20, 20);
		textFieldHijos.setText("0");
		panelPoliza_2.add(textFieldHijos);
		configuracionTextField(textFieldHijos);
		
		separator_10_1 = new JSeparator();
		separator_10_1.setForeground(Color.BLACK);
		separator_10_1.setBackground(Color.BLACK);
		separator_10_1.setBounds(177, 41, 29, 2);
		panelPoliza_2.add(separator_10_1);
			
	}
    public void pestaniaDatosDelVehiculo() throws ParseException {
		
		btnSiguiente_2 = new JButton("Siguiente");
		btnSiguiente_2.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSiguiente_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					if(comboBoxCorrectos() && camposIngresados()) {
						polizaDTO = new PolizaDTO();
						
						List<MedidaDeSeguridadDTO> listaMedidas = new ArrayList<>();
						agregarMedida(chckbxGuardaGarage.isSelected(), "Guarda en garage", listaMedidas);
			            agregarMedida(chckbxtieneAlarma.isSelected(), "Tiene alarma", listaMedidas);
			            agregarMedida(chckbxRastreoVehicular.isSelected(), "Posee dispositivo de rastreo vehicular", listaMedidas);
			            agregarMedida(chckbxTuercasAntirrobos.isSelected(), "Posee tuercas antirrobo en las cuatro ruedas", listaMedidas);
					
			            polizaDTO.setMedidasDeclaradas(listaMedidas);
			            polizaDTO.setKmsUltAnio(comboBoxKmsPorAnio.getSelectedItem().toString());
			            polizaDTO.setNroSiniestros(comboBoxSiniestrosUltAnio.getSelectedItem().toString());
			            
			            
						vehiculoDTO = new VehiculoDTO();
						vehiculoDTO.setMotor(textFieldMotor.getText());
						vehiculoDTO.setChasis(formattedTextField.getText());
						vehiculoDTO.setPatente(textFieldPatenteVehiculo.getText());
						vehiculoDTO.setModelo(new ModeloDTO(comboBoxMarcaVehiculo.getSelectedItem().toString(),
								                         comboBoxModeloVehiculo.getSelectedItem().toString(),
								                         Integer.parseInt(comboBoxAnioVehiculo.getSelectedItem().toString())));
						
						vehiculoDTO.setDomicilio(new DomicilioRiesgoDTO(comboBoxPaisRiesgo.getSelectedItem().toString(),
					                                                    comboBoxProvinciaRiesgo.getSelectedItem().toString(),
					                                                    comboBoxLocalidadRiesgo.getSelectedItem().toString()));
						
						vehiculoDTO.setIdModelo(GestorVehiculo.getInstance().recuperarModeloPorNombre(vehiculoDTO.getModelo().getNombreModelo()).getIdModelo());
						
						for (int i=0; i<tabbedCrearPoliza.getComponentCount(); i++) {
							tabbedCrearPoliza.setEnabledAt(i, true);
							 if (i != 2) {
							        tabbedCrearPoliza.setEnabledAt(i, false);
							    }
						}
						tabbedCrearPoliza.setSelectedIndex(2);				
					}
					else {
						throw(new DatosNoIngresadosException());
					}
				} catch(DatosNoIngresadosException e1) {
					JOptionPane.showMessageDialog(InterfazDarAltaPoliza.this, "Alguno/s de los datos (*) no fueron ingresados. Por favor, ingréselo/s", "Datos no rellenados", JOptionPane.WARNING_MESSAGE);
				}
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
		separator_7.setBounds(441, 42, 123, 2);
		panelContextoCliente.add(separator_7);
		separator_7.setForeground(Color.BLACK);
		separator_7.setBackground(Color.BLACK);
		
		separator_6 = new JSeparator();
		separator_6.setBounds(80, 42, 123, 2);
		panelContextoCliente.add(separator_6);
		separator_6.setForeground(Color.BLACK);
		separator_6.setBackground(Color.BLACK);
		
		lblApellido_1 = new JLabel("Apellido");
		lblApellido_1.setBounds(385, 30, 46, 14);
		panelContextoCliente.add(lblApellido_1);
		lblApellido_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(24, 30, 46, 14);
		panelContextoCliente.add(lblNombre_1);
		lblNombre_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		//campo Apellido
		textFieldApellido_1 = new JTextField();
		textFieldApellido_1.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldApellido_1.setBounds(441, 24, 123, 20);
		panelContextoCliente.add(textFieldApellido_1);
		textFieldApellido_1.setColumns(10);
		configuracionTextField(textFieldApellido_1);
		
		//campo Nombre
		textFieldNombre_1 = new JTextField();
		textFieldNombre_1.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldNombre_1.setBounds(80, 24, 123, 20);
		panelContextoCliente.add(textFieldNombre_1);
		textFieldNombre_1.setColumns(10);
		configuracionTextField(textFieldNombre_1);
		
		panelPoliza = new JPanel();
		panelPoliza.setBackground(Color.WHITE);
		panelPoliza.setBounds(15, 86, 797, 305);
		datosVehiculo.add(panelPoliza);
		panelPoliza.setBorder(new TitledBorder(null, "Poliza", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPoliza.setLayout(null);
		
		
		//campo motor
		textFieldMotor = new JTextField();
		textFieldMotor.setBounds(158, 105, 154, 20);
		panelPoliza.add(textFieldMotor);
		textFieldMotor.setColumns(10);
		
		chckbxGuardaGarage = new JCheckBox("¿Se guarda en garage?");
		chckbxGuardaGarage.setBounds(378, 188, 174, 23);
		panelPoliza.add(chckbxGuardaGarage);
		chckbxGuardaGarage.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxGuardaGarage.setBackground(Color.WHITE);
		
		chckbxtieneAlarma = new JCheckBox("¿Tiene alarma?");
		chckbxtieneAlarma.setBounds(378, 212, 154, 23);
		panelPoliza.add(chckbxtieneAlarma);
		chckbxtieneAlarma.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxtieneAlarma.setBackground(Color.WHITE);
		
		chckbxRastreoVehicular = new JCheckBox("¿Posee dispositivo de rastreo vehicular?");
		chckbxRastreoVehicular.setBounds(378, 236, 256, 23);
		panelPoliza.add(chckbxRastreoVehicular);
		chckbxRastreoVehicular.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxRastreoVehicular.setBackground(Color.WHITE);
		
		chckbxTuercasAntirrobos = new JCheckBox("¿Posee tuercas antirrobo en las cuatro ruedas?");
		chckbxTuercasAntirrobos.setBounds(378, 260, 297, 23);
		panelPoliza.add(chckbxTuercasAntirrobos);
		chckbxTuercasAntirrobos.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxTuercasAntirrobos.setBackground(Color.WHITE);
		
		lblMedidasDeSeguridad = new JLabel("Medidas de seguridad");
		lblMedidasDeSeguridad.setBounds(378, 167, 133, 14);
		panelPoliza.add(lblMedidasDeSeguridad);
		lblMedidasDeSeguridad.setFont(new Font("Arial", Font.BOLD, 12));
		
		lblPatenteDelVehiculo = new JLabel("Patente del vehiculo");
		lblPatenteDelVehiculo.setBounds(378, 138, 113, 14);
		panelPoliza.add(lblPatenteDelVehiculo);
		lblPatenteDelVehiculo.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo_7 = new JLabel("(*)");
		lblSimbolo_7.setBounds(501, 53, 19, 14);
		panelPoliza.add(lblSimbolo_7);
		lblSimbolo_7.setForeground(Color.RED);
		lblSimbolo_7.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo_6 = new JLabel("(*)");
		lblSimbolo_6.setBounds(501, 138, 19, 14);
		panelPoliza.add(lblSimbolo_6);
		lblSimbolo_6.setForeground(Color.RED);
		lblSimbolo_6.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo_5 = new JLabel("(*)");
		lblSimbolo_5.setBounds(138, 107, 19, 14);
		panelPoliza.add(lblSimbolo_5);
		lblSimbolo_5.setForeground(Color.RED);
		lblSimbolo_5.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo_4 = new JLabel("(*)");
		lblSimbolo_4.setBounds(501, 80, 19, 14);
		panelPoliza.add(lblSimbolo_4);
		lblSimbolo_4.setForeground(Color.RED);
		lblSimbolo_4.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo = new JLabel("(*)");
		lblSimbolo.setBounds(501, 25, 19, 14);
		panelPoliza.add(lblSimbolo);
		lblSimbolo.setForeground(Color.RED);
		lblSimbolo.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo_2 = new JLabel("(*)");
		lblSimbolo_2.setBounds(138, 139, 19, 14);
		panelPoliza.add(lblSimbolo_2);
		lblSimbolo_2.setForeground(Color.RED);
		lblSimbolo_2.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo_3 = new JLabel("(*)");
		lblSimbolo_3.setBounds(138, 167, 19, 14);
		panelPoliza.add(lblSimbolo_3);
		lblSimbolo_3.setForeground(Color.RED);
		lblSimbolo_3.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblSimbolo_1 = new JLabel("(*)");
		lblSimbolo_1.setBounds(138, 196, 19, 14);
		panelPoliza.add(lblSimbolo_1);
		lblSimbolo_1.setForeground(Color.RED);
		lblSimbolo_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblPais = new JLabel("Pais de riesgo");
		lblPais.setBounds(20, 25, 113, 14);
		lblPais.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPoliza.add(lblPais);
		
		JLabel lblSimbolo_8 = new JLabel("(*)");
		lblSimbolo_8.setBounds(138, 25, 19, 14);
		lblSimbolo_8.setForeground(Color.RED);
		lblSimbolo_8.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPoliza.add(lblSimbolo_8);
		
		//Campo pais de riesgo
		comboBoxPaisRiesgo = new JComboBox<Object>();
		comboBoxPaisRiesgo.setBounds(158, 21, 154, 22);
		comboBoxPaisRiesgo.setBackground(Color.WHITE);
		comboBoxPaisRiesgo.addItem("<Seleccione>");
		panelPoliza.add(comboBoxPaisRiesgo);
		
		for (Pais pais : GestorLocalidad.getInstance().obtenerPaises()) {
			comboBoxPaisRiesgo.addItem(pais.getNombrePais());
		}

		comboBoxPaisRiesgo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        comboBoxProvinciaRiesgo.removeAllItems();
		        comboBoxLocalidadRiesgo.removeAllItems();
		        
		        comboBoxProvinciaRiesgo.addItem("<Seleccione>");
		        comboBoxLocalidadRiesgo.addItem("<Seleccione>");
		        
		       Pais pais = GestorLocalidad.getInstance().recuperarPaisPorNombre(comboBoxPaisRiesgo.getSelectedItem().toString());
		        if (pais!=null) {
		        	List<Provincia> provincias  = GestorLocalidad.getInstance().obtenerProvincias(pais);
		            comboBoxProvinciaRiesgo.setEnabled(true);
		            comboBoxLocalidadRiesgo.setEnabled(false);
		           for (Provincia provincia : provincias) {
		                comboBoxProvinciaRiesgo.addItem(provincia.getNombreProvincia());
		            }
		        }
		    }
		});
		
		
		lblNroSiniestros = new JLabel("Nro. Siniestros / ult. año");
		lblNroSiniestros.setBounds(20, 196, 113, 14);
		panelPoliza.add(lblNroSiniestros);
		lblNroSiniestros.setFont(new Font("Arial", Font.PLAIN, 10));
		
		//campo Siniestros ultimo año
		String[] opcionesSiniestros = {"Ninguno", "Uno", "Dos", "Mas de dos"};
		comboBoxSiniestrosUltAnio = new JComboBox<>(opcionesSiniestros);
		comboBoxSiniestrosUltAnio.setBounds(158, 189, 154, 22);
		panelPoliza.add(comboBoxSiniestrosUltAnio);
		comboBoxSiniestrosUltAnio.setBackground(Color.WHITE);
		
		lblKmsAnio = new JLabel("Kilometros por año");
		lblKmsAnio.setBounds(20, 167, 113, 14);
		panelPoliza.add(lblKmsAnio);
		lblKmsAnio.setFont(new Font("Arial", Font.PLAIN, 12));
		
		//campo KMs por anio
		String[] opcionesKMs = {"<Seleccione>", "Menos de 10.000", "10.000 - 15.000", "15.000 - 20.000", "20.000 - 25.000", "Mas de 25.000"};
		comboBoxKmsPorAnio = new JComboBox<>(opcionesKMs);
		comboBoxKmsPorAnio.setBounds(158, 161, 154, 22);
		panelPoliza.add(comboBoxKmsPorAnio);
		comboBoxKmsPorAnio.setBackground(Color.WHITE);
		
		lblAoDelVehiculo = new JLabel("Año del vehiculo");
		lblAoDelVehiculo.setBounds(378, 81, 94, 14);
		panelPoliza.add(lblAoDelVehiculo);
		lblAoDelVehiculo.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblMarcaDelVehiculo = new JLabel("Modelo del vehiculo");
		lblMarcaDelVehiculo.setBounds(378, 53, 113, 14);
		panelPoliza.add(lblMarcaDelVehiculo);
		lblMarcaDelVehiculo.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblChasis = new JLabel("Chasis");
		lblChasis.setBounds(20, 138, 46, 14);
		panelPoliza.add(lblChasis);
		lblChasis.setFont(new Font("Arial", Font.PLAIN, 12));
		
		MaskFormatter maskFormatter = new MaskFormatter("#UU-******-********");

        formattedTextField = new JFormattedTextField(maskFormatter);
        formattedTextField.setBounds(158, 133, 154, 20);
		panelPoliza.add(formattedTextField);
		formattedTextField.setColumns(10);
		
		
		separator_8 = new JSeparator();
		separator_8.setBounds(526, 122, 154, 2);
		panelPoliza.add(separator_8);
		separator_8.setForeground(Color.BLACK);
		separator_8.setBackground(Color.BLACK);
		
		textFieldSumaAsegurada = new JTextField();
		textFieldSumaAsegurada.setBounds(526, 105, 154, 17);
		panelPoliza.add(textFieldSumaAsegurada);
		textFieldSumaAsegurada.setColumns(10);
		configuracionTextField(textFieldSumaAsegurada);
		
		lblSumaAsegurada = new JLabel("Suma asegurada");
		lblSumaAsegurada.setBounds(378, 109, 113, 14);
		panelPoliza.add(lblSumaAsegurada);
		lblSumaAsegurada.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblModeloVehiculo = new JLabel("Marca del vehiculo");
		lblModeloVehiculo.setBounds(378, 25, 113, 14);
		panelPoliza.add(lblModeloVehiculo);
		lblModeloVehiculo.setFont(new Font("Arial", Font.PLAIN, 12));
		
		//campo vehiculo
		comboBoxMarcaVehiculo = new JComboBox<>();
		comboBoxMarcaVehiculo.setBounds(525, 21, 154, 22);
		comboBoxMarcaVehiculo.addItem("<Seleccione>");
		panelPoliza.add(comboBoxMarcaVehiculo);
		comboBoxMarcaVehiculo.setBackground(Color.WHITE);
		
		for (Marca marca: GestorVehiculo.getInstance().recuperarMarcas()) {
			comboBoxMarcaVehiculo.addItem(marca.getNombreMarca());
		}

		comboBoxMarcaVehiculo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        String selectedItem = comboBoxMarcaVehiculo.getSelectedItem() != null
		                ? comboBoxMarcaVehiculo.getSelectedItem().toString()
		                : "";
		        comboBoxModeloVehiculo.removeAllItems();
		        textFieldSumaAsegurada.setText("");
		        comboBoxModeloVehiculo.addItem("<Seleccione>");

		        Marca marca = GestorVehiculo.getInstance().recuperarMarcaPorNombre(selectedItem);
		        if (marca != null) {
		        	textFieldSumaAsegurada.setText("");
		            comboBoxModeloVehiculo.removeAllItems();
		            comboBoxAnioVehiculo.removeAllItems();

		            List<Modelo> modelos = GestorVehiculo.getInstance().recuperarModelosPorMarca(marca);
		            comboBoxModeloVehiculo.addItem("<Seleccione>");
		            comboBoxModeloVehiculo.setEnabled(true);
		            comboBoxAnioVehiculo.setEnabled(false);

		            for (Modelo modelo : modelos) {
		                comboBoxModeloVehiculo.addItem(modelo.getNombreModelo());
		            }

		            comboBoxModeloVehiculo.setSelectedIndex(0);
		        }
		    }
		});


		lblProvinciaDeRiesgo = new JLabel("Provincia de riesgo");
		lblProvinciaDeRiesgo.setBounds(20, 53, 113, 14);
		lblProvinciaDeRiesgo.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPoliza.add(lblProvinciaDeRiesgo);
		
		lblSimbolo_9 = new JLabel("(*)");
		lblSimbolo_9.setBounds(138, 53, 19, 14);
		lblSimbolo_9.setForeground(Color.RED);
		lblSimbolo_9.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPoliza.add(lblSimbolo_9);
		
		comboBoxProvinciaRiesgo = new JComboBox<Object>();
		comboBoxProvinciaRiesgo.setBounds(158, 49, 154, 22);
		comboBoxProvinciaRiesgo.setBackground(Color.WHITE);
		comboBoxProvinciaRiesgo.addItem("<Seleccione>");
		comboBoxProvinciaRiesgo.setEnabled(false);
		panelPoliza.add(comboBoxProvinciaRiesgo);
		
		comboBoxProvinciaRiesgo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			     comboBoxLocalidadRiesgo.removeAllItems();
			     comboBoxLocalidadRiesgo.addItem("<Seleccione>");
			     
			       if(comboBoxProvinciaRiesgo.getSelectedItem() != null) {
			    	   Provincia provincia = GestorLocalidad.getInstance().recuperarProvinciaPorNombre(comboBoxProvinciaRiesgo.getSelectedItem().toString());
				        if (provincia!=null) {
				        	List<Localidad> localidades  = GestorLocalidad.getInstance().obtenerLocalidades(provincia);
				            comboBoxLocalidadRiesgo.setEnabled(true);
				           for (Localidad localidad : localidades) {
				                comboBoxLocalidadRiesgo.addItem(localidad.getNombreLocalidad());
				           }
				        }
			       }
			       
			  }
		}
		    );
		
		lblLocalidadDeRiesgo = new JLabel("Localidad de riesgo");
		lblLocalidadDeRiesgo.setBounds(20, 81, 113, 14);
		lblLocalidadDeRiesgo.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPoliza.add(lblLocalidadDeRiesgo);
		
		lblSimbolo_10 = new JLabel("(*)");
		lblSimbolo_10.setBounds(138, 81, 19, 14);
		lblSimbolo_10.setForeground(Color.RED);
		lblSimbolo_10.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPoliza.add(lblSimbolo_10);
		
		comboBoxLocalidadRiesgo = new JComboBox<Object>();
		comboBoxLocalidadRiesgo.setBounds(158, 77, 154, 22);
		comboBoxLocalidadRiesgo.setBackground(Color.WHITE);
		comboBoxLocalidadRiesgo.addItem("<Seleccione>");
		comboBoxLocalidadRiesgo.setEnabled(false);
		panelPoliza.add(comboBoxLocalidadRiesgo);
		
		lblMotor = new JLabel("Motor");
		lblMotor.setBounds(20, 109, 40, 14);
		panelPoliza.add(lblMotor);
		lblMotor.setFont(new Font("Arial", Font.PLAIN, 12));
		//campo modelo

    	comboBoxModeloVehiculo = new JComboBox<>();
    	comboBoxModeloVehiculo.setBounds(525, 49, 154, 22);
    	panelPoliza.add(comboBoxModeloVehiculo);
    	comboBoxModeloVehiculo.setBackground(Color.WHITE);
    	comboBoxModeloVehiculo.addItem("<Seleccione>");
    	comboBoxModeloVehiculo.setEnabled(false);
    	//campo anio
    	comboBoxAnioVehiculo = new JComboBox<>();
    	comboBoxAnioVehiculo.setBounds(525, 77, 154, 22);
    	panelPoliza.add(comboBoxAnioVehiculo);
    	comboBoxAnioVehiculo.setBackground(Color.WHITE);
    	comboBoxAnioVehiculo.addItem("<Seleccione>");
    	comboBoxAnioVehiculo.setEnabled(false);
    	
    	//campo patente
    	textFieldPatenteVehiculo = new JTextField();
    	textFieldPatenteVehiculo.setBounds(525, 133, 154, 20);
    	panelPoliza.add(textFieldPatenteVehiculo);
    	textFieldPatenteVehiculo.setColumns(10);
    	
    	JLabel lblSimbolo_4_1 = new JLabel("$");
    	lblSimbolo_4_1.setForeground(Color.BLACK);
    	lblSimbolo_4_1.setFont(new Font("Arial", Font.PLAIN, 12));
    	lblSimbolo_4_1.setBounds(513, 108, 19, 14);
    	panelPoliza.add(lblSimbolo_4_1);
    	
    	comboBoxAnioVehiculo.addActionListener(new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
    					ModeloDTO modelo = new ModeloDTO();
    	                  if (comboBoxAnioVehiculo.getSelectedItem() != null && !comboBoxAnioVehiculo.getSelectedItem().toString().equals("<Seleccione>")) {
    	                	modelo.setNombreModelo(comboBoxModeloVehiculo.getSelectedItem().toString()); 
    	                	modelo.setAnioFabricacion(Integer.parseInt(comboBoxAnioVehiculo.getSelectedItem().toString()));
    	                	modelo.setIdModelo(GestorVehiculo.getInstance().recuperarModeloPorNombre(modelo.getNombreModelo()).getIdModelo());
    	                	GestorSumaAsegurada.getInstance().devolverSumaAsegurada(modelo);
    	                	
    	                	
    	                	if (GestorSumaAsegurada.getInstance().devolverSumaAsegurada(modelo) == 0) {
    	                		textFieldSumaAsegurada.setText("");
    	                	}
    	                	else {
    	                	DecimalFormat formatoPesos = new DecimalFormat("###,###,##0.00");
        	                String valorEnPesos = formatoPesos.format(GestorSumaAsegurada.getInstance().devolverSumaAsegurada(modelo));
    	                    textFieldSumaAsegurada.setText(valorEnPesos);
    	                	}
    	                  }
    	                  else {
    	                	  textFieldSumaAsegurada.setText("");
    	                  }
    					  }
    			});
    	
    	comboBoxModeloVehiculo.addActionListener(new ActionListener() {
    			    public void actionPerformed(ActionEvent e) {
    			        String selectedItem = comboBoxModeloVehiculo.getSelectedItem() != null
    			                ? comboBoxModeloVehiculo.getSelectedItem().toString()
    			                : "";
    			        textFieldSumaAsegurada.setText("");
    			        comboBoxAnioVehiculo.removeAllItems();
    			        comboBoxAnioVehiculo.addItem("<Seleccione>");
    	
    			        if (!"<Seleccione>".equals(selectedItem)) {
    			            Modelo modelo = GestorVehiculo.getInstance().recuperarModeloPorNombre(selectedItem);
    			            textFieldSumaAsegurada.setText("");
    			            if (modelo != null) {
    	
    				            comboBoxAnioVehiculo.setEnabled(true);
    			                for (int i = modelo.getAniofabricacionDesde(); i <= modelo.getAniofabricacionHasta(); i++) {
    			                    comboBoxAnioVehiculo.addItem(i);
    			                }
    			            }
    			        }
    			    }
    			});
		
		
	}
    public void pestaniaBuscarCliente() {
		configuracionBuscarCliente();
		btnSiguiente_1 = new JButton("Siguiente");
		btnSiguiente_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSiguiente_1.setEnabled(true);
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
		
		btnDarAltaCliente = new JButton("Dar de alta cliente");
		btnDarAltaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(InterfazDarAltaPoliza.this,
					    "Funcion no implementada :(",
					    "Proximamente",
					    JOptionPane.WARNING_MESSAGE
					);
			}
		});
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
		
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InterfazBuscarCliente buscarCliente = new InterfazBuscarCliente(InterfazDarAltaPoliza.this);
					buscarCliente.setVisible(true);
				} catch (Exception e1) {
				}
			}
		});
		
	
		btnSiguiente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
				if (!clienteDTO.getNombre().isEmpty()) {
				clienteDTO.setIdCliente(GestorCliente.getInstance().recuperarID(clienteDTO.getNroCliente()));
				
			
				for (int i=0; i<tabbedCrearPoliza.getComponentCount(); i++) {
					if (i==1) {
						tabbedCrearPoliza.setEnabledAt(i,true);
					}
					else {
						tabbedCrearPoliza.setEnabledAt(i,false);
					}
				}
				tabbedCrearPoliza.setSelectedIndex(1);
			    
				}
				}
				catch (Exception e1) {
					  JOptionPane.showMessageDialog(InterfazDarAltaPoliza.this, "No se encontró ningún cliente. Por favor, realice una búsqueda e inténtelo nuevamente.", "Cliente no encontrado", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
				JSeparator separator_0 = new JSeparator();
				separator_0.setBounds(136, 68, 123, 2);
				
				panelCliente.add(separator_0);
				separator_0.setBackground(Color.BLACK);
				separator_0.setForeground(Color.BLACK);
				
				separator_1 = new JSeparator();
				separator_1.setBounds(136, 101, 123, 2);
				panelCliente.add(separator_1);
				separator_1.setForeground(Color.BLACK);
				separator_1.setBackground(Color.BLACK);
		
				separator_2 = new JSeparator();
				separator_2.setBounds(136, 134, 123, 2);
				panelCliente.add(separator_2);
				separator_2.setForeground(Color.BLACK);
				separator_2.setBackground(Color.BLACK);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(469, 68, 123, 2);
		panelCliente.add(separator_3);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		
		separator_4 = new JSeparator();
		separator_4.setBounds(469, 101, 123, 2);
		panelCliente.add(separator_4);
		separator_4.setForeground(Color.BLACK);
		separator_4.setBackground(Color.BLACK);
		
		separator_5 = new JSeparator();
		separator_5.setBounds(469, 134, 123, 2);
		panelCliente.add(separator_5);
		separator_5.setForeground(Color.BLACK);
		separator_5.setBackground(Color.BLACK);
		
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
		textFieldApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldApellido.setBounds(469, 48, 123, 20);
		panelCliente.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		configuracionTextField(textFieldApellido);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldNombre.setBounds(469, 81, 123, 20);
		panelCliente.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		configuracionTextField(textFieldNombre);

		
		textFieldDomicilio = new JTextField();
		textFieldDomicilio.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldDomicilio.setBounds(469, 114, 123, 20);
		panelCliente.add(textFieldDomicilio);
		textFieldDomicilio.setColumns(10);
		configuracionTextField(textFieldDomicilio);
		
		lblNroDni = new JLabel("Nro. DNI");
		lblNroDni.setBounds(29, 120, 72, 14);
		panelCliente.add(lblNroDni);
		lblNroDni.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblTipoDocumento = new JLabel("Tipo documento");
		lblTipoDocumento.setBounds(29, 87, 97, 14);
		panelCliente.add(lblTipoDocumento);
		lblTipoDocumento.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblNroCliente = new JLabel("Nro. Cliente");
		lblNroCliente.setBounds(29, 53, 72, 14);
		panelCliente.add(lblNroCliente);
		lblNroCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		
		textFieldNroCliente = new JTextField();
		textFieldNroCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldNroCliente.setBounds(136, 48, 123, 20);
		panelCliente.add(textFieldNroCliente);
		textFieldNroCliente.setColumns(10);
		configuracionTextField(textFieldNroCliente);
	
		textFieldTipoDocumento = new JTextField();
		textFieldTipoDocumento.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldTipoDocumento.setBounds(136, 81, 123, 20);
		panelCliente.add(textFieldTipoDocumento);
		textFieldTipoDocumento.setColumns(10);
		configuracionTextField(textFieldTipoDocumento);
		
		textFieldNroDNI = new JTextField();	
		textFieldNroDNI.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldNroDNI.setBounds(136, 114, 123, 20);
		panelCliente.add(textFieldNroDNI);
		textFieldNroDNI.setColumns(10);
		configuracionTextField(textFieldNroDNI);
		
		btnNewButton = new JButton("Probar dialogo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(null, panel, "Póliza generada", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(20, 316, 89, 23);
		buscarCliente.add(btnNewButton);
	}
	public void pestaniaCrearPoliza() {
		tabbedPrincipal.setEnabledAt(1, false);
		//tabbedCrearPoliza.setSelectedIndex(0);
		pestaniaBuscarCliente();
	}
	public void pestaniaConfirmarPoliza() {
		tabbedPrincipal.setEnabledAt(0, false);
		tabbedPrincipal.setEnabledAt(1, true);
		tabbedPrincipal.setSelectedIndex(1);
		tabbedConfirmarPoliza.setSelectedIndex(0);
		//pestaniaTipoPoliza();	
	}
	public void pestaniaTipoPoliza() {
		configuracionTipoPoliza();

		JPanel panelContextoCliente_2 = new JPanel();
		panelContextoCliente_2.setLayout(null);
		panelContextoCliente_2.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelContextoCliente_2.setBackground(Color.WHITE);
		panelContextoCliente_2.setBounds(15, 11, 797, 64);
		tipoPoliza.add(panelContextoCliente_2);
		
		JSeparator separator_7_1 = new JSeparator();
		separator_7_1.setForeground(Color.BLACK);
		separator_7_1.setBackground(Color.BLACK);
		separator_7_1.setBounds(441, 42, 123, 2);
		panelContextoCliente_2.add(separator_7_1);
		
		JSeparator separator_6_1 = new JSeparator();
		separator_6_1.setForeground(Color.BLACK);
		separator_6_1.setBackground(Color.BLACK);
		separator_6_1.setBounds(80, 42, 123, 2);
		panelContextoCliente_2.add(separator_6_1);
		
		JLabel lblApellido_1_1 = new JLabel("Apellido");
		lblApellido_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellido_1_1.setBounds(385, 30, 46, 14);
		panelContextoCliente_2.add(lblApellido_1_1);
		
		JLabel lblNombre_1_1 = new JLabel("Nombre");
		lblNombre_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre_1_1.setBounds(24, 30, 46, 14);
		panelContextoCliente_2.add(lblNombre_1_1);
		
		
		textFieldNombre_3 = new JTextField();
		textFieldNombre_3.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldNombre_3.setBounds(80, 24, 123, 20);
		panelContextoCliente_2.add(textFieldNombre_3);
		textFieldNombre_3.setColumns(10);
		configuracionTextField(textFieldNombre_3);
			
		textFieldApellido_3 = new JTextField();
		textFieldApellido_3.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldApellido_3.setColumns(10);
		textFieldApellido_3.setBounds(441, 24, 123, 20);
		panelContextoCliente_2.add(textFieldApellido_3);
		configuracionTextField(textFieldApellido_3);
			
		panelTipoPoliza = new JPanel();
		panelTipoPoliza.setLayout(null);
		panelTipoPoliza.setBorder(new TitledBorder(null, "Tipo de póliza", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTipoPoliza.setBackground(Color.WHITE);
		panelTipoPoliza.setBounds(15, 86, 797, 148);
		tipoPoliza.add(panelTipoPoliza);
		
		lblFechaInicio = new JLabel("Fecha de inicio");
		lblFechaInicio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFechaInicio.setBounds(397, 36, 91, 14);
		panelTipoPoliza.add(lblFechaInicio);
		
		lblTipoCobertura = new JLabel("Tipo de cobertura");
		lblTipoCobertura.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTipoCobertura.setBounds(23, 36, 103, 14);
		panelTipoPoliza.add(lblTipoCobertura);
		
		JLabel lblFormaDePago = new JLabel("Forma de pago");
		lblFormaDePago.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFormaDePago.setBounds(23, 80, 91, 14);
		panelTipoPoliza.add(lblFormaDePago);
		
		JLabel lblSimbolo_12 = new JLabel("(*)");
		lblSimbolo_12.setForeground(Color.RED);
		lblSimbolo_12.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSimbolo_12.setBounds(145, 36, 18, 14);
		panelTipoPoliza.add(lblSimbolo_12);
		
		JLabel lblSimbolo_12_1 = new JLabel("(*)");
		lblSimbolo_12_1.setForeground(Color.RED);
		lblSimbolo_12_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSimbolo_12_1.setBounds(145, 80, 18, 14);
		panelTipoPoliza.add(lblSimbolo_12_1);
		
		JLabel lblSimbolo_12_2 = new JLabel("(*)");
		lblSimbolo_12_2.setForeground(Color.RED);
		lblSimbolo_12_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSimbolo_12_2.setBounds(505, 36, 18, 14);
		panelTipoPoliza.add(lblSimbolo_12_2);
		
		comboBoxTipoCobertura = new JComboBox<String>();
		comboBoxTipoCobertura.setBounds(173, 32, 154, 22);
		comboBoxTipoCobertura.addItem("<Seleccione>");
		panelTipoPoliza.add(comboBoxTipoCobertura);
		
		JComboBox<String> comboBoxFormaDePago = new JComboBox<String>();
		comboBoxFormaDePago.setBounds(173, 76, 154, 22);
		panelTipoPoliza.add(comboBoxFormaDePago);
		comboBoxFormaDePago.addItem("<Seleccione>");
		comboBoxFormaDePago.addItem("Mensual");
		comboBoxFormaDePago.addItem("Semestral");
		

		fechaInicio = new JDateChooser();
		fechaInicio.setBounds(533, 32, 154, 20);
		panelTipoPoliza.add(fechaInicio);
		Calendar calendar = Calendar.getInstance();
		//Date dateToday = calendar.getTime();
        // Sumar un día
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date dateTomorrow = calendar.getTime();
		fechaInicio.setDate(dateTomorrow);
		
		
		
		
		
		JButton btnSiguiente_1_1 = new JButton("Siguiente");
		btnSiguiente_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSiguiente_1_1.setFocusable(false);
		btnSiguiente_1_1.setBounds(20, 404, 89, 23);
		tipoPoliza.add(btnSiguiente_1_1);
		
		btnSiguiente_1_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        JPanel panelCuotas = null;
		        try {
		        	if(comboBoxTipoCobertura.getSelectedItem().toString() != "<Seleccione>"
		        	&& comboBoxFormaDePago.getSelectedItem().toString() != "<Seleccione>"
		        	&& fechaInicioEsValida(fechaInicio.getDate())) {
				        String formaDePagoSeleccionada = comboBoxFormaDePago.getSelectedItem().toString();
				        tabbedConfirmarPoliza.setSelectedIndex(1);
				        configuracionGeneracionPoliza();
		        		if ("Semestral".equals(formaDePagoSeleccionada)) {
				        	configuracionPanelCuotasSemestrales();
				            panelCuotas = panelCuotasSemestral;
				        } else if ("Mensual".equals(formaDePagoSeleccionada)){
				        	configuracionPanelCuotasMensuales();
				            panelCuotas = panelCuotasMensuales;
				        }
		            	rellenarFechas();
		            	
		            	polizaDTO.setFechaInicio(fechaInicio.getDate());
		            	polizaDTO.setFechaFin(fechaFin.getDate());
		            	polizaDTO.setFormaPago(formaDePagoSeleccionada);
		            	polizaDTO.setRenovar(false);
		            	polizaDTO.setEstadoPoliza("Generada");
		            	CoberturaDTO cobertura = new CoberturaDTO();
		            	cobertura.setNombreCobertura(comboBoxTipoCobertura.getSelectedItem().toString());
		            	polizaDTO.setCobertura(cobertura);
		            	
		        		tabbedPaneDatosPoliza.addTab("Cuotas de la póliza", panelCuotas);
		        		 
		        	} else
						try {
							if(!fechaInicioEsValida(fechaInicio.getDate())){
								throw(new FechaInicioInvalidaException());
							} else {
								throw(new DatosNoIngresadosException());
							}
						} catch (ParseException e1) {
						}
		        } catch(DatosNoIngresadosException e1) {
					JOptionPane.showMessageDialog(InterfazDarAltaPoliza.this, "Alguno/s de los datos (*) no fueron ingresados. Por favor, ingréselo/s", "Datos no rellenados", JOptionPane.WARNING_MESSAGE);
				} catch(FechaInicioInvalidaException e2) {
					JOptionPane.showMessageDialog(InterfazDarAltaPoliza.this, "La fecha de inicio debe ser a partir de mañana(inclusive) ", "Fecha de inicio inválida", JOptionPane.WARNING_MESSAGE);
				} catch (ParseException e1) {
				}
		    }
		});
		
		JButton btnCancelar_1_1 = new JButton("Cancelar");
		btnCancelar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogoCancelar();
			}
		});
		btnCancelar_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar_1_1.setFocusable(false);
		btnCancelar_1_1.setBounds(108, 404, 89, 23);
		tipoPoliza.add(btnCancelar_1_1);
		
	}
	public void pestaniaGeneracionPoliza(){
		configuracionGeneracionPoliza();
	}
	
    //funciones de configuracion
	public void inicializarPaneles () throws ParseException {
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
		tipoPoliza.setLayout(null);
		
		generacionPoliza = new JPanel();
		generacionPoliza.setBackground(Color.WHITE);
		tabbedConfirmarPoliza.addTab("Generacion de poliza", null, generacionPoliza, null);
		generacionPoliza.setLayout(null);
		
		tabbedPaneDatosPoliza = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneDatosPoliza.setFont(new Font("Arial", Font.PLAIN, 12));
		tabbedPaneDatosPoliza.setBounds(0, 0, 843, 448);
		generacionPoliza.add(tabbedPaneDatosPoliza);
		tabbedPaneDatosPoliza.setFocusable(false);
	
		configuracionPanelDatosPoliza();
		pestaniaGeneracionPoliza();
		pestaniaTipoPoliza();
        
	}
	public void agregarMedida(boolean isSelected, String medida, List<MedidaDeSeguridadDTO> listaMedidas) {
	        if (isSelected) {
	            listaMedidas.add(new MedidaDeSeguridadDTO(medida));
	        }
	    }
    public void configuracionPanelDatosPoliza() {
    	JPanel panelDatosPoliza = new JPanel();
		panelDatosPoliza.setBackground(Color.WHITE);
		tabbedPaneDatosPoliza.addTab("Datos de póliza", null, panelDatosPoliza, null);
		panelDatosPoliza.setLayout(null);
    	JButton btnCancelar_3_1 = new JButton("Cancelar");
    	btnCancelar_3_1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			dialogoCancelar();
    		}
    	});
    	
		btnCancelar_3_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar_3_1.setFocusable(false);
		btnCancelar_3_1.setBounds(184, 380, 89, 23);
		panelDatosPoliza.add(btnCancelar_3_1);
		
		JButton btnVolver_3_1 = new JButton("Volver");
		btnVolver_3_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVolver_3_1.setFocusable(false);
		btnVolver_3_1.setBounds(103, 380, 82, 23);
		panelDatosPoliza.add(btnVolver_3_1);
		configuracionBotonVolverDatosPoliza(btnVolver_3_1);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPaneDatosPoliza.setSelectedIndex(1);
			}
		});
		
		btnSiguiente.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSiguiente.setFocusable(false);
		btnSiguiente.setBounds(15, 380, 89, 23);
		panelDatosPoliza.add(btnSiguiente);
		
		JPanel panelGeneracionPoliza = new JPanel();
		panelGeneracionPoliza.setLayout(null);
		panelGeneracionPoliza.setBorder(new TitledBorder(null, "Generación de póliza", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGeneracionPoliza.setBackground(Color.WHITE);
		panelGeneracionPoliza.setBounds(15, 11, 800, 354);
		panelDatosPoliza.add(panelGeneracionPoliza);
		
		JLabel lblTitularSeguro = new JLabel("Titular del seguro");
		lblTitularSeguro.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTitularSeguro.setBounds(15, 42, 101, 14);
		panelGeneracionPoliza.add(lblTitularSeguro);
		
		textFieldTitularSeguro = new JTextField();
		textFieldTitularSeguro.setColumns(10);
		textFieldTitularSeguro.setBounds(126, 38, 170, 20);
		panelGeneracionPoliza.add(textFieldTitularSeguro);
		configuracionTextField(textFieldTitularSeguro);
		
		JSeparator separatorTitularSeguro = new JSeparator();
		separatorTitularSeguro.setForeground(Color.BLACK);
		separatorTitularSeguro.setBackground(Color.BLACK);
		separatorTitularSeguro.setBounds(127, 58, 169, 2);
		panelGeneracionPoliza.add(separatorTitularSeguro);
		
		JLabel lblDatosDelVehiculo = new JLabel("Datos del vehiculo");
		lblDatosDelVehiculo.setFont(new Font("Arial", Font.BOLD, 14));
		lblDatosDelVehiculo.setBounds(15, 84, 142, 14);
		panelGeneracionPoliza.add(lblDatosDelVehiculo);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMarca.setBounds(15, 124, 52, 14);
		panelGeneracionPoliza.add(lblMarca);
		
		textField_Marca = new JTextField();
		textField_Marca.setColumns(10);
		textField_Marca.setBounds(126, 119, 170, 20);
		panelGeneracionPoliza.add(textField_Marca);
		configuracionTextField(textField_Marca);
		
		JSeparator separatorMarca = new JSeparator();
		separatorMarca.setForeground(Color.BLACK);
		separatorMarca.setBackground(Color.BLACK);
		separatorMarca.setBounds(127, 139, 170, 2);
		panelGeneracionPoliza.add(separatorMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblModelo.setBounds(331, 124, 52, 14);
		panelGeneracionPoliza.add(lblModelo);
		
		textField_Modelo = new JTextField();
		textField_Modelo.setColumns(10);
		textField_Modelo.setBounds(434, 119, 170, 20);
		panelGeneracionPoliza.add(textField_Modelo);
		configuracionTextField(textField_Modelo);
		
		JSeparator separatorModelo = new JSeparator();
		separatorModelo.setForeground(Color.BLACK);
		separatorModelo.setBackground(Color.BLACK);
		separatorModelo.setBounds(434, 139, 170, 2);
		panelGeneracionPoliza.add(separatorModelo);
		
		JLabel lblChasis_1 = new JLabel("Chasis");
		lblChasis_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblChasis_1.setBounds(15, 159, 52, 14);
		panelGeneracionPoliza.add(lblChasis_1);
		
		textFieldChasis_1 = new JTextField();
		textFieldChasis_1.setColumns(10);
		textFieldChasis_1.setBounds(126, 154, 170, 20);
		panelGeneracionPoliza.add(textFieldChasis_1);
		configuracionTextField(textFieldChasis_1);
		
		JSeparator separatorChasis = new JSeparator();
		separatorChasis.setForeground(Color.BLACK);
		separatorChasis.setBackground(Color.BLACK);
		separatorChasis.setBounds(127, 174, 169, 2);
		panelGeneracionPoliza.add(separatorChasis);
		
		JLabel lblMotor_1 = new JLabel("Motor");
		lblMotor_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMotor_1.setBounds(331, 159, 52, 14);
		panelGeneracionPoliza.add(lblMotor_1);
		
		textField_Motor = new JTextField();
		textField_Motor.setColumns(10);
		textField_Motor.setBounds(434, 154, 170, 20);
		panelGeneracionPoliza.add(textField_Motor);
		configuracionTextField(textField_Motor);
		
		JSeparator separatorMotor = new JSeparator();
		separatorMotor.setForeground(Color.BLACK);
		separatorMotor.setBackground(Color.BLACK);
		separatorMotor.setBounds(434, 174, 170, 2);
		panelGeneracionPoliza.add(separatorMotor);
		
		JLabel lblPatente = new JLabel("Patente");
		lblPatente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPatente.setBounds(15, 194, 52, 14);
		panelGeneracionPoliza.add(lblPatente);
		
		//campo Patente
		textField_Patente = new JTextField();
		textField_Patente.setColumns(10);
		textField_Patente.setBounds(126, 190, 170, 20);
		panelGeneracionPoliza.add(textField_Patente);
		configuracionTextField(textField_Patente);
		
		JSeparator separatorPatente = new JSeparator();
		separatorPatente.setForeground(Color.BLACK);
		separatorPatente.setBackground(Color.BLACK);
		separatorPatente.setBounds(127, 210, 169, 2);
		panelGeneracionPoliza.add(separatorPatente);
		
		JLabel lblVigencia = new JLabel("Vigencia");
		lblVigencia.setFont(new Font("Arial", Font.BOLD, 14));
		lblVigencia.setBounds(15, 234, 79, 20);
		panelGeneracionPoliza.add(lblVigencia);
		
		JLabel lblFechaInicio_1 = new JLabel("Fecha inicio");
		lblFechaInicio_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFechaInicio_1.setBounds(15, 274, 79, 14);
		panelGeneracionPoliza.add(lblFechaInicio_1);
		
	    fechaInicio_1 = new JDateChooser();
		fechaInicio_1.setEnabled(false);
		fechaInicio_1.setBounds(126, 269, 170, 20);
		panelGeneracionPoliza.add(fechaInicio_1);
		
		JLabel lblFechaInicio_1_1 = new JLabel("Fecha fin");
		lblFechaInicio_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFechaInicio_1_1.setBounds(331, 274, 79, 14);
		panelGeneracionPoliza.add(lblFechaInicio_1_1);
		
		fechaFin = new JDateChooser();
		fechaFin.setEnabled(false);
		fechaFin.setBounds(434, 269, 170, 20);
		panelGeneracionPoliza.add(fechaFin);

    }
    public void actualizarCamposCliente(ClienteDTO cliente) {
        textFieldApellido.setText(cliente.getApellido());
        textFieldNombre.setText(cliente.getNombre());
        textFieldNroCliente.setText(cliente.getNroCliente());
        textFieldNroDNI.setText(cliente.getNroDocumento());
        textFieldTipoDocumento.setText(cliente.getTipoDocumento());
        textFieldNombre_1.setText(cliente.getNombre());
        textFieldApellido_1.setText(cliente.getApellido());
        textFieldNombre_2.setText(cliente.getNombre());
        textFieldApellido_2.setText(cliente.getApellido());
        textFieldNombre_3.setText(cliente.getNombre());
        textFieldApellido_3.setText(cliente.getApellido());
        textFieldTitularSeguro.setText(cliente.getNombre() + " " + cliente.getApellido());
        clienteDTO = cliente;
    }
    public void configuracionBotonVolverDatosPoliza(JButton btnVolver) {
    	btnVolver.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        tabbedConfirmarPoliza.setSelectedIndex(0);
                //pestaniaTipoPoliza();
		        int indexCuotasSemestral = tabbedPaneDatosPoliza.indexOfTab("Cuotas de la póliza");
		        if (indexCuotasSemestral != -1) {
		            tabbedPaneDatosPoliza.removeTabAt(indexCuotasSemestral);
		        }
		        int indexCuotasMensual = tabbedPaneDatosPoliza.indexOfTab("Cuotas de la póliza");
		        if (indexCuotasMensual != -1) {
		            tabbedPaneDatosPoliza.removeTabAt(indexCuotasMensual);
		        }
		        tabbedConfirmarPoliza.setEnabledAt(1, false);
		        tabbedConfirmarPoliza.setEnabledAt(0, true);
		    }
		});
    }
	public void configuracionPanelCuotasSemestrales() {
    	panelCuotasSemestral = new JPanel();
		panelCuotasSemestral.setBackground(Color.WHITE);
		panelCuotasSemestral.setLayout(null);
    	panelGeneracionPoliza_1 = new JPanel();
    	
		panelGeneracionPoliza_1.setLayout(null);
		panelGeneracionPoliza_1.setBorder(new TitledBorder(null, "Generación de póliza", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGeneracionPoliza_1.setBackground(Color.WHITE);
		panelGeneracionPoliza_1.setBounds(15, 11, 783, 344);
		panelCuotasSemestral.add(panelGeneracionPoliza_1);
		
		textField_SumaAsegurada = new JTextField();
		textField_SumaAsegurada.setColumns(10);
		textField_SumaAsegurada.setBounds(160, 19, 170, 20);
		panelGeneracionPoliza_1.add(textField_SumaAsegurada);
		configuracionTextField(textField_SumaAsegurada);
		
		separatorTitularSeguro_1 = new JSeparator();
		separatorTitularSeguro_1.setForeground(Color.BLACK);
		separatorTitularSeguro_1.setBackground(Color.BLACK);
		separatorTitularSeguro_1.setBounds(160, 39, 169, 2);
		panelGeneracionPoliza_1.add(separatorTitularSeguro_1);
		
		fechaUltDiaPago = new JDateChooser();
		fechaUltDiaPago.setEnabled(false);
		fechaUltDiaPago.setBounds(506, 61, 170, 20);
		panelGeneracionPoliza_1.add(fechaUltDiaPago);
		
		lblSumaAsegurada_1 = new JLabel("Suma asegurada");
		lblSumaAsegurada_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSumaAsegurada_1.setBounds(15, 27, 101, 14);
		panelGeneracionPoliza_1.add(lblSumaAsegurada_1);
		
		textField_Premio = new JTextField();
		textField_Premio.setColumns(10);
		textField_Premio.setBounds(506, 19, 170, 20);
		panelGeneracionPoliza_1.add(textField_Premio);
		configuracionTextField(textField_Premio);
		
		JSeparator separatorTitularSeguro_1_1 = new JSeparator();
		separatorTitularSeguro_1_1.setForeground(Color.BLACK);
		separatorTitularSeguro_1_1.setBackground(Color.BLACK);
		separatorTitularSeguro_1_1.setBounds(507, 39, 169, 2);
		panelGeneracionPoliza_1.add(separatorTitularSeguro_1_1);
		
		JLabel lblSumaAsegurada_1_1 = new JLabel("Premio");
		lblSumaAsegurada_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSumaAsegurada_1_1.setBounds(385, 27, 50, 14);
		panelGeneracionPoliza_1.add(lblSumaAsegurada_1_1);
		
		textField_ImportePDesc = new JTextField();
		textField_ImportePDesc.setColumns(10);
		textField_ImportePDesc.setBounds(160, 62, 170, 20);
		panelGeneracionPoliza_1.add(textField_ImportePDesc);
		configuracionTextField(textField_ImportePDesc);
		
		JSeparator separatorTitularSeguro_1_2 = new JSeparator();
		separatorTitularSeguro_1_2.setForeground(Color.BLACK);
		separatorTitularSeguro_1_2.setBackground(Color.BLACK);
		separatorTitularSeguro_1_2.setBounds(160, 82, 169, 2);
		panelGeneracionPoliza_1.add(separatorTitularSeguro_1_2);
		
		JLabel lblSumaAsegurada_1_2 = new JLabel("Importe por descuentos");
		lblSumaAsegurada_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSumaAsegurada_1_2.setBounds(15, 67, 151, 14);
		panelGeneracionPoliza_1.add(lblSumaAsegurada_1_2);
		
		JLabel lblSumaAsegurada_1_3 = new JLabel("Ultimo dia de pago");
		lblSumaAsegurada_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSumaAsegurada_1_3.setBounds(385, 68, 112, 14);
		panelGeneracionPoliza_1.add(lblSumaAsegurada_1_3);
		
		textFieldMontoTotal = new JTextField();
		textFieldMontoTotal.setColumns(10);
		textFieldMontoTotal.setBounds(160, 306, 170, 20);
		panelGeneracionPoliza_1.add(textFieldMontoTotal);
		configuracionTextField(textFieldMontoTotal);
		
		separatorTitularSeguro_2 = new JSeparator();
		separatorTitularSeguro_2.setForeground(Color.BLACK);
		separatorTitularSeguro_2.setBackground(Color.BLACK);
		separatorTitularSeguro_2.setBounds(160, 326, 169, 2);
		panelGeneracionPoliza_1.add(separatorTitularSeguro_2);
		
		lblSumaAsegurada_2 = new JLabel("Monto total a abonar       $");
		lblSumaAsegurada_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSumaAsegurada_2.setBounds(15, 309, 151, 14);
		panelGeneracionPoliza_1.add(lblSumaAsegurada_2);
		
		JButton btnConfirmar_1 = new JButton("Confirmar");
		btnConfirmar_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConfirmar_1.setFocusable(false);
		btnConfirmar_1.setBounds(15, 380, 89, 23);
		panelCuotasSemestral.add(btnConfirmar_1);
		btnConfirmar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorPoliza.getInstance().darAltaPoliza(polizaDTO, clienteDTO, vehiculoDTO);
			}
		});
		
		JButton btnVolver_3_1_1 = new JButton("Volver");
		btnVolver_3_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVolver_3_1_1.setFocusable(false);
		btnVolver_3_1_1.setBounds(103, 380, 82, 23);
		panelCuotasSemestral.add(btnVolver_3_1_1);
		btnVolver_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPaneDatosPoliza.setSelectedIndex(0);
			}
		});
		
		JButton btnCancelar_3_1_1 = new JButton("Cancelar");
		btnCancelar_3_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar_3_1_1.setFocusable(false);
		btnCancelar_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogoCancelar();
			}
		});
		btnCancelar_3_1_1.setBounds(184, 380, 89, 23);
		panelCuotasSemestral.add(btnCancelar_3_1_1);
    }
    public void configuracionPanelCuotasMensuales(){
    	panelCuotasMensuales = new JPanel();
		panelCuotasMensuales.setBackground(Color.WHITE);
		panelCuotasMensuales.setLayout(null);
		
		panelGeneracionPoliza_2 = new JPanel();
		panelGeneracionPoliza_2.setLayout(null);
		panelGeneracionPoliza_2.setBorder(new TitledBorder(null, "Generación de póliza", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGeneracionPoliza_2.setBackground(Color.WHITE);
		panelGeneracionPoliza_2.setBounds(15, 11, 800, 354);
		panelCuotasMensuales.add(panelGeneracionPoliza_2);
		
		textField_SumaAsegurada_2 = new JTextField();
		textField_SumaAsegurada_2.setColumns(10);
		textField_SumaAsegurada_2.setBounds(160, 19, 170, 20);
		panelGeneracionPoliza_2.add(textField_SumaAsegurada_2);
		configuracionTextField(textField_SumaAsegurada_2);
		
		separatorSumaAsegurada = new JSeparator();
		separatorSumaAsegurada.setForeground(Color.BLACK);
		separatorSumaAsegurada.setBackground(Color.BLACK);
		separatorSumaAsegurada.setBounds(160, 39, 169, 2);
		panelGeneracionPoliza_2.add(separatorSumaAsegurada);
		
	    
		lblSumaAsegurada_3 = new JLabel("Suma asegurada");
		lblSumaAsegurada_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSumaAsegurada_3.setBounds(15, 27, 101, 14);
		panelGeneracionPoliza_2.add(lblSumaAsegurada_3);
		
		textField_Premio_2 = new JTextField();
		textField_Premio_2.setColumns(10);
		textField_Premio_2.setBounds(479, 19, 170, 20);
		panelGeneracionPoliza_2.add(textField_Premio_2);
		configuracionTextField(textField_Premio_2);

		separatorPremio = new JSeparator();
		separatorPremio.setForeground(Color.BLACK);
		separatorPremio.setBackground(Color.BLACK);
		separatorPremio.setBounds(479, 39, 169, 2);
		panelGeneracionPoliza_2.add(separatorPremio);
		
		lblPremio = new JLabel("Premio");
		lblPremio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPremio.setBounds(394, 22, 50, 14);
		panelGeneracionPoliza_2.add(lblPremio);
		
		textField_ImportePDesc_1 = new JTextField();
		textField_ImportePDesc_1.setColumns(10);
		textField_ImportePDesc_1.setBounds(160, 62, 170, 20);
		panelGeneracionPoliza_2.add(textField_ImportePDesc_1);
		configuracionTextField(textField_ImportePDesc_1);
		
		separatorImportePDesc = new JSeparator();
		separatorImportePDesc.setForeground(Color.BLACK);
		separatorImportePDesc.setBackground(Color.BLACK);
		separatorImportePDesc.setBounds(160, 82, 169, 2);
		panelGeneracionPoliza_2.add(separatorImportePDesc);
		
		lblImportePorDesc = new JLabel("Importe por descuentos");
		lblImportePorDesc.setFont(new Font("Arial", Font.PLAIN, 12));
		lblImportePorDesc.setBounds(15, 67, 151, 14);
		panelGeneracionPoliza_2.add(lblImportePorDesc);
		
		JLabel lblCuotas = new JLabel("Cuotas");
		lblCuotas.setFont(new Font("Arial", Font.BOLD, 14));
		lblCuotas.setBounds(15, 104, 61, 14);
		panelGeneracionPoliza_2.add(lblCuotas);
		
		JLabel lblCuota1 = new JLabel("Cuota 1");
		lblCuota1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCuota1.setBounds(15, 138, 61, 14);
		panelGeneracionPoliza_2.add(lblCuota1);
		
		JLabel lblCuota2 = new JLabel("Cuota 2");
		lblCuota2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCuota2.setBounds(15, 164, 61, 14);
		panelGeneracionPoliza_2.add(lblCuota2);
		
		JLabel lblCuota3 = new JLabel("Cuota 3");
		lblCuota3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCuota3.setBounds(15, 189, 61, 14);
		panelGeneracionPoliza_2.add(lblCuota3);
		
		JLabel lblCuota4 = new JLabel("Cuota 4");
		lblCuota4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCuota4.setBounds(15, 214, 61, 14);
		panelGeneracionPoliza_2.add(lblCuota4);
		
		JLabel lblCuota5 = new JLabel("Cuota 5");
		lblCuota5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCuota5.setBounds(15, 239, 61, 14);
		panelGeneracionPoliza_2.add(lblCuota5);
		
		JLabel lblCuota6 = new JLabel("Cuota 6");
		lblCuota6.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCuota6.setBounds(15, 264, 61, 14);
		panelGeneracionPoliza_2.add(lblCuota6);
		
		JLabel lblVencimiento = new JLabel("Vencimiento");
		lblVencimiento.setFont(new Font("Arial", Font.BOLD, 14));
		lblVencimiento.setBounds(394, 104, 94, 14);
		panelGeneracionPoliza_2.add(lblVencimiento);
		
		textFieldCuota1 = new JTextField();
		textFieldCuota1.setColumns(10);
		textFieldCuota1.setBounds(132, 130, 170, 20);
		panelGeneracionPoliza_2.add(textFieldCuota1);
		configuracionTextField(textFieldCuota1);
		
		JSeparator separatorCuota1 = new JSeparator();
		separatorCuota1.setForeground(Color.BLACK);
		separatorCuota1.setBackground(Color.BLACK);
		separatorCuota1.setBounds(132, 150, 169, 2);
		panelGeneracionPoliza_2.add(separatorCuota1);
		
		textFieldCuota2 = new JTextField();
		textFieldCuota2.setColumns(10);
		textFieldCuota2.setBounds(132, 156, 170, 20);
		panelGeneracionPoliza_2.add(textFieldCuota2);
		configuracionTextField(textFieldCuota2);
		
		JSeparator separatorCuota2 = new JSeparator();
		separatorCuota2.setForeground(Color.BLACK);
		separatorCuota2.setBackground(Color.BLACK);
		separatorCuota2.setBounds(132, 176, 169, 2);
		panelGeneracionPoliza_2.add(separatorCuota2);
		
		textFieldCuota3 = new JTextField();
		textFieldCuota3.setColumns(10);
		textFieldCuota3.setBounds(132, 181, 170, 20);
		panelGeneracionPoliza_2.add(textFieldCuota3);
		configuracionTextField(textFieldCuota3);
		
		JSeparator separatorCuota3 = new JSeparator();
		separatorCuota3.setForeground(Color.BLACK);
		separatorCuota3.setBackground(Color.BLACK);
		separatorCuota3.setBounds(132, 201, 169, 2);
		panelGeneracionPoliza_2.add(separatorCuota3);
		
		textFieldCuota4 = new JTextField();
		textFieldCuota4.setColumns(10);
		textFieldCuota4.setBounds(132, 206, 170, 20);
		panelGeneracionPoliza_2.add(textFieldCuota4);
		configuracionTextField(textFieldCuota4);
		
		JSeparator separatorCuota4 = new JSeparator();
		separatorCuota4.setForeground(Color.BLACK);
		separatorCuota4.setBackground(Color.BLACK);
		separatorCuota4.setBounds(132, 226, 169, 2);
		panelGeneracionPoliza_2.add(separatorCuota4);
		
		textFieldCuota5 = new JTextField();
		textFieldCuota5.setColumns(10);
		textFieldCuota5.setBounds(132, 231, 170, 20);
		panelGeneracionPoliza_2.add(textFieldCuota5);
		configuracionTextField(textFieldCuota5);
		
		JSeparator separatorCuota5 = new JSeparator();
		separatorCuota5.setForeground(Color.BLACK);
		separatorCuota5.setBackground(Color.BLACK);
		separatorCuota5.setBounds(132, 251, 169, 2);
		panelGeneracionPoliza_2.add(separatorCuota5);
		
		textFieldCuota6 = new JTextField();
		textFieldCuota6.setColumns(10);
		textFieldCuota6.setBounds(132, 256, 170, 20);
		panelGeneracionPoliza_2.add(textFieldCuota6);
		configuracionTextField(textFieldCuota6);
		
		JSeparator separatorCuota6 = new JSeparator();
		separatorCuota6.setForeground(Color.BLACK);
		separatorCuota6.setBackground(Color.BLACK);
		separatorCuota6.setBounds(132, 276, 169, 2);
		panelGeneracionPoliza_2.add(separatorCuota6);
		
		JDateChooser vencimientoCuota1 = new JDateChooser();
		vencimientoCuota1.setBounds(395, 132, 170, 20);
		panelGeneracionPoliza_2.add(vencimientoCuota1);
		vencimientoCuota1.setEnabled(false);
		
		
		JDateChooser vencimientoCuota2 = new JDateChooser();
		vencimientoCuota2.setBounds(395, 158, 170, 20);
		panelGeneracionPoliza_2.add(vencimientoCuota2);
		vencimientoCuota2.setEnabled(false);
		
		JDateChooser vencimientoCuota3 = new JDateChooser();
		vencimientoCuota3.setBounds(395, 183, 170, 20);
		panelGeneracionPoliza_2.add(vencimientoCuota3);
		vencimientoCuota3.setEnabled(false);
		
		JDateChooser vencimientoCuota4 = new JDateChooser();
		vencimientoCuota4.setBounds(395, 208, 170, 20);
		panelGeneracionPoliza_2.add(vencimientoCuota4);
		vencimientoCuota4.setEnabled(false);
		
		JDateChooser vencimientoCuota5 = new JDateChooser();
		vencimientoCuota5.setBounds(395, 233, 170, 20);
		panelGeneracionPoliza_2.add(vencimientoCuota5);
		vencimientoCuota5.setEnabled(false);
		
		JDateChooser vencimientoCuota6 = new JDateChooser();
		vencimientoCuota6.setBounds(395, 258, 170, 20);
		panelGeneracionPoliza_2.add(vencimientoCuota6);
		vencimientoCuota6.setEnabled(false);
		
		textFieldMontoTotalAPagar = new JTextField();
		textFieldMontoTotalAPagar.setColumns(10);
		textFieldMontoTotalAPagar.setBounds(132, 309, 170, 20);
		panelGeneracionPoliza_2.add(textFieldMontoTotalAPagar);
		configuracionTextField(textFieldMontoTotalAPagar);
		
		JSeparator separatorMontoTotal = new JSeparator();
		separatorMontoTotal.setForeground(Color.BLACK);
		separatorMontoTotal.setBackground(Color.BLACK);
		separatorMontoTotal.setBounds(132, 329, 169, 2);
		panelGeneracionPoliza_2.add(separatorMontoTotal);
		
		JLabel lblMontoTotalA = new JLabel("Monto total a pagar  $");
		lblMontoTotalA.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMontoTotalA.setBounds(15, 316, 125, 14);
		panelGeneracionPoliza_2.add(lblMontoTotalA);
		
		JButton btnConfirmar_1 = new JButton("Confirmar");
		btnConfirmar_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConfirmar_1.setFocusable(false);
		btnConfirmar_1.setBounds(15, 380, 89, 23);
		panelCuotasMensuales.add(btnConfirmar_1);
		btnConfirmar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            
			}
		});
		
		JButton btnVolver_3_1_1 = new JButton("Volver");
		btnVolver_3_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVolver_3_1_1.setFocusable(false);
		btnVolver_3_1_1.setBounds(103, 380, 82, 23);
		panelCuotasMensuales.add(btnVolver_3_1_1);
		btnVolver_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPaneDatosPoliza.setSelectedIndex(0);
			}
		});
		
		JButton btnCancelar_3_1_1 = new JButton("Cancelar");
		btnCancelar_3_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar_3_1_1.setFocusable(false);
		btnCancelar_3_1_1.setBounds(184, 380, 89, 23);
		panelCuotasMensuales.add(btnCancelar_3_1_1);
		btnCancelar_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogoCancelar();
			}
		});
		
    }
    public void mostrarPanelCuotas(JPanel panel) {
	     tabbedPaneDatosPoliza.addTab("Cuotas de la póliza", panel);
	}
    public void configuracionTextField(JTextField textField) {
		textField.setBorder(null);
		textField.setFocusable(false);
		textField.setBackground(Color.WHITE);
		textField.setEnabled(true);
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
    public void configuracionTipoPoliza() {
    	tabbedConfirmarPoliza.setSelectedIndex(0);
    	tabbedConfirmarPoliza.setEnabledAt(1, false);
    	tabbedConfirmarPoliza.setEnabledAt(0, true);
    }
    public void configuracionGeneracionPoliza() {
    	tabbedConfirmarPoliza.setEnabledAt(0, false);
    	tabbedConfirmarPoliza.setEnabledAt(1,true);
    }
    public void configuracionBotonAgregarHijo() {
    	btnAgregar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregar.setFocusable(false);
		btnAgregar.setBounds(15, 259, 89, 23);
		panelPoliza_2.add(btnAgregar);
		DefaultTableModel modelo = (DefaultTableModel) tablaHijos.getModel();
		btnAgregar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Obtener valores seleccionados
		        	if(comboBoxSexo.getSelectedItem().toString() != "<Seleccione>" 
		            && comboBoxEstadoCivil.getSelectedItem().toString() != "<Seleccione>"
		        		 && fechaNacimiento.getDate() != null) {
		        		
		        		
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
		        	}else {
				       throw(new DatosNoIngresadosException());
				            }
		        	
		        } catch (DatosNoIngresadosException ex) {
		        	JOptionPane.showMessageDialog(InterfazDarAltaPoliza.this, "Alguno/s de los datos (*) no fueron ingresados. Por favor, ingréselo/s", "Datos no rellenados", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});
    }
    public void configuracionBotonEditarHijo(){
    	btnEditar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditar.setFocusable(false);
		btnEditar.setBounds(299, 259, 89, 23);
		btnEditar.setEnabled(false);
		panelPoliza_2.add(btnEditar);
		
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
	         
	         String[] optionsEstadoCivilEdicion = {"Soltero/a", "Casado/a", "Divorciado/a", "Separado/A", "Viudo/A"};
	     	 String[] optionsSexoEdicion = {"Masculino", "Femenino"};
	         
	     	 JComboBox sexo_editar = new JComboBox(optionsSexoEdicion);
	         sexo_editar.setSelectedItem(sexo_seleccionado);
	         JComboBox estadoCivil_editar = new JComboBox(optionsEstadoCivilEdicion);
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
		btnEliminar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        	int opcion = JOptionPane.showConfirmDialog(
		                    null,
		                    "¿Estás seguro que desea eliminar este hijo?",
		                    "Confirmación",
		                    JOptionPane.YES_NO_OPTION,
		                    JOptionPane.QUESTION_MESSAGE
		                );
		            if (opcion == JOptionPane.YES_OPTION) {
		            	DefaultTableModel model = (DefaultTableModel) tablaHijos.getModel();
		                int filaSeleccionada = tablaHijos.getSelectedRow();	

		                model.removeRow(filaSeleccionada);
		                model.fireTableDataChanged();

		                textFieldHijos.setText(String.valueOf(Integer.parseInt(textFieldHijos.getText()) - 1));
		            }
		    }
		});

    	
    }
    public void limpiarCamposVehiculo() {
		comboBoxMarcaVehiculo.setSelectedItem(null);
		textFieldSumaAsegurada.setText(null);
		textFieldChasis.setText(null);
		comboBoxKmsPorAnio.setSelectedItem(null);
		comboBoxSiniestrosUltAnio.setSelectedItem(null);
		comboBoxModeloVehiculo.setSelectedItem(null);
	    comboBoxAnioVehiculo.setSelectedItem(null);	
	    textFieldMotor.setText(null);
	    textFieldPatenteVehiculo.setText(null);
	    chckbxGuardaGarage.setSelected(false);
	    chckbxtieneAlarma.setSelected(false);
	    chckbxRastreoVehicular.setSelected(false);
	    chckbxTuercasAntirrobos.setSelected(false);
	}
    public void limpiarCamposHijos() {
    	textFieldHijos.setText("0");
    	fechaNacimiento.setDate(null);
    	comboBoxEstadoCivil.setSelectedIndex(0);
    	comboBoxSexo.setSelectedIndex(0);
    	DefaultTableModel model = (DefaultTableModel) tablaHijos.getModel();
    	model.setRowCount(0);
    }
    public void dialogoVolver(int index) {
		switch (index) {
		case 1:
			switch(JOptionPane.showConfirmDialog(null,"Los datos ingresados se eliminarán, ¿está seguro que desea volver? ","Alerta",JOptionPane.YES_NO_OPTION)) {
			case JOptionPane.YES_OPTION:
			tabbedCrearPoliza.setSelectedIndex(index-1);
			configuracionBuscarCliente();
			limpiarCamposVehiculo();
			limpiarCamposHijos();
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
    public boolean comboBoxCorrectos() {
    	if(comboBoxPaisRiesgo.getSelectedItem().toString() != "<Seleccione>"
    	   && comboBoxLocalidadRiesgo.getSelectedItem().toString() != "<Seleccione>" 
    	   && comboBoxProvinciaRiesgo.getSelectedItem().toString() != "<Seleccione>"
    	   && comboBoxKmsPorAnio.getSelectedItem().toString() != "<Seleccione>"
    	   && comboBoxMarcaVehiculo.getSelectedItem().toString() != "<Seleccione>"
    	   && comboBoxModeloVehiculo.getSelectedItem().toString() != "<Seleccione>"
    	   && comboBoxAnioVehiculo.getSelectedItem().toString() != "<Seleccione>") {
    		return true;
    	}
    	else
    		return false;
    }
    public boolean camposIngresados() {
    	if(formattedTextField.getText().isEmpty() ||  textFieldPatenteVehiculo.getText().isEmpty()  || textFieldMotor.getText().isEmpty()) {
    		
    		return false;
    	}
    	else
    		return true;
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
    public boolean fechaInicioEsValida(Date fechaInicio) throws ParseException {
    	if (fechaInicio == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha de inicio válida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false; 
        }
    	Calendar fechaCalendar = Calendar.getInstance();
		Date dateToday = fechaCalendar.getTime();

    	if (fechaInicio.compareTo(dateToday) > 0) {
    		return true; 
    	} else {
    	    return false;
    	}


    }
    public void rellenarFechas() {
    	fechaInicio_1.setDate(fechaInicio.getDate());
    	Calendar cal = Calendar.getInstance();
        cal.setTime(fechaInicio.getDate());
        // Agregar 6 meses
        cal.add(Calendar.MONTH, 6);
        // Establecer la fecha de fechaFin
        fechaFin.setDate(cal.getTime());
    }
    public void dialogoCancelar() {

    	int opcion = JOptionPane.showConfirmDialog(null,"¿Está seguro de que desea cancelar el alta de la poliza?","Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
        	System.exit(0);
        }
    }
}
