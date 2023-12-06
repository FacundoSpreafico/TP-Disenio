package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DTO.ClienteDTO;
import constantes.Images;
import gestores.GestorCliente;

public class InterfazBuscarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNroCliente;
	private JTextField textFieldNroDoc;
	private JTextField textFieldApellido;
	private JTextField textFieldNombre;
	private JTable tablaClientes;
	private JComboBox comboBoxTipoDoc;
	private ClienteDTO clienteBuscado= new ClienteDTO();
	private InterfazDarAltaPoliza interfazDarAltaPoliza;
	private String[] optionsTipoDocumento = {"<Seleccione>","DNI", "Libreta civica", "Libreta de enrolamiento"};
	List<ClienteDTO> listaClientes = new ArrayList<ClienteDTO>();
	
	
	public InterfazBuscarCliente(InterfazDarAltaPoliza interfazDarAltaPoliza)  throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		this.interfazDarAltaPoliza = interfazDarAltaPoliza;
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setTitle("Productor de seguro - Buscar cliente");
		setIconImage(Images.MILEI.getImage());
		setResizable(false);
		setBounds(100, 100, 869, 547);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		inicializarPaneles();
		
	}
	
	public void inicializarPaneles() {
		JLabel lblNroCliente = new JLabel("Nro. Cliente");
		lblNroCliente.setBounds(60, 70, 65, 14);
		lblNroCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.add(lblNroCliente);
		
		JLabel lblTipoDoc = new JLabel("Tipo documento");
		lblTipoDoc.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTipoDoc.setBounds(60, 110, 107, 14);
		contentPane.add(lblTipoDoc);
		
		JLabel lblNroDoc = new JLabel("Nro Documento");
		lblNroDoc.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNroDoc.setBounds(60, 150, 87, 14);
		contentPane.add(lblNroDoc);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellido.setBounds(450, 70, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(450, 110, 46, 14);
		contentPane.add(lblNombre);
		
		textFieldNroCliente = new JTextField();
		textFieldNroCliente.setBounds(180, 67, 180, 20);
		contentPane.add(textFieldNroCliente);
		textFieldNroCliente.setColumns(10);
		
		textFieldNroDoc = new JTextField();
		textFieldNroDoc.setBounds(180, 147, 180, 20);
		contentPane.add(textFieldNroDoc);
		textFieldNroDoc.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(565, 67, 180, 20);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(565, 107, 180, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		comboBoxTipoDoc = new JComboBox();
		comboBoxTipoDoc.setBounds(180, 107, 180, 20);
		for (String opcion: optionsTipoDocumento) {
			comboBoxTipoDoc.addItem(opcion);
		}
		
		
		contentPane.add(comboBoxTipoDoc);
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	ClienteDTO cliente = new ClienteDTO();
		        if (!textFieldNombre.getText().isEmpty()) {
		            cliente.setNombre(textFieldNombre.getText().trim());
		        }
		        if (!textFieldApellido.getText().isEmpty()) {
		            cliente.setApellido(textFieldApellido.getText().trim());
		        }
		        if (comboBoxTipoDoc.getSelectedItem() != null && !comboBoxTipoDoc.getSelectedItem().toString().equals("<Seleccione>")) {
		            cliente.setTipoDocumento(comboBoxTipoDoc.getSelectedItem().toString());
		        }
		        if (!textFieldNroDoc.getText().isEmpty()) {
		            cliente.setNroDocumento(textFieldNroDoc.getText());
		        }
		        if (!textFieldNroCliente.getText().isEmpty()) {
		           cliente.setNroCliente(textFieldNroCliente.getText().trim());
		        }
		        if (todosNulos()) {
		        	JOptionPane.showMessageDialog(null, "No se ha ingresado ningún parámetro de búsqueda", "Advertencia", JOptionPane.WARNING_MESSAGE);
		        }
		        else {
		        listaClientes = GestorCliente.getInstance().buscar(cliente);
		        configuracionTabla(listaClientes);
		        }
		    }
		});
		
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnBuscar.setBounds(60, 190, 89, 23);
		contentPane.add(btnBuscar);
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setBackground(Color.WHITE);
		panelBusqueda.setBorder(new TitledBorder(null, "B\u00FAsqueda de cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBusqueda.setBounds(28, 28, 780, 210);
		contentPane.add(panelBusqueda);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 281, 717, 137);
		contentPane.add(scrollPane);
		
		JButton btnConfirmar = new JButton();
		btnConfirmar.setText("Confirmar");
		btnConfirmar.setBackground(Color.WHITE);
		btnConfirmar.setEnabled(false);
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConfirmar.setBounds(28, 460, 89, 23);
		contentPane.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		            int fila = tablaClientes.getSelectedRow();
		            ClienteDTO clienteSeleccionado = new ClienteDTO();  
		            String nroCliente = tablaClientes.getValueAt(fila, 0).toString();
		            
		            for (ClienteDTO cliente: listaClientes) {
		            	if (cliente.getNroCliente().equals(nroCliente)) {
		            		clienteSeleccionado = cliente;
		            	}
		            }

		            if (interfazDarAltaPoliza != null) {
		                interfazDarAltaPoliza.actualizarCamposCliente(clienteSeleccionado);
		            }
		            
		            dispose();
		        
		    }
		});
		

		
		
		tablaClientes = new JTable();
		scrollPane.setViewportView(tablaClientes);
		tablaClientes.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				"Nro. cliente", "Apellido", "Nombre", "Tipo documento", "Nro. documento"
				}
			));
		tablaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        int filaSeleccionada = tablaClientes.getSelectedRow();
		        if (filaSeleccionada != -1) {
		            btnConfirmar.setEnabled(true);
		        }
		        else {
		        	btnConfirmar.setEnabled(false);
		        }
		    }
		});

		JPanel panelResultado = new JPanel();
		panelResultado.setBackground(Color.WHITE);
		panelResultado.setBorder(new TitledBorder(null, "Resultado de b\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelResultado.setBounds(28, 249, 780, 190);
		contentPane.add(panelResultado);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(116, 460, 89, 23);
		contentPane.add(btnCancelar);

	}
	public boolean todosNulos() {
		if (textFieldNombre.getText().isEmpty() && textFieldApellido.getText().isEmpty() && comboBoxTipoDoc.getSelectedItem()==null && textFieldNroDoc.getText().isEmpty() 
				&& textFieldNroCliente.getText().isEmpty()) {
        return true;
        }
		return false;
	}
	public void configuracionTabla(List<ClienteDTO> listaClientes) {
	    String[] titulos = {"Nro. cliente", "Apellido", "Nombre", "Tipo documento", "Nro. documento"};
	    DefaultTableModel dtmDatos = new DefaultTableModel();
	    TableRowSorter<TableModel> trs;
	    int contador = listaClientes.size();
	    String[][] datosClientes = cargarDatosClientes(listaClientes);

	    dtmDatos = new DefaultTableModel(datosClientes, titulos) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
	    };
	    
	    tablaClientes.setModel(dtmDatos);
	    
	    trs = new TableRowSorter<>(dtmDatos);
	    tablaClientes.setRowSorter(trs);
	}
    private String[][] cargarDatosClientes(List<ClienteDTO> listaClientes) {
	    int cantidadClientes = listaClientes.size();
	    String[][] datosClientes = new String[cantidadClientes][5];

	    for (int i = 0; i < cantidadClientes; i++) {
	        ClienteDTO clienteDTO = listaClientes.get(i);
	        datosClientes[i][0] = String.valueOf(clienteDTO.getNroCliente());
	        datosClientes[i][1] = clienteDTO.getApellido();
	        datosClientes[i][2] = clienteDTO.getNombre();
	        datosClientes[i][3] = clienteDTO.getTipoDocumento();
	        datosClientes[i][4] = String.valueOf(clienteDTO.getNroDocumento());
	    }
	    return datosClientes;
	}

}