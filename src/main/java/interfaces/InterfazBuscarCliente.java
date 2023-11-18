package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;


import DTO.ClienteDTO;
import entidades.Cliente;
import gestores.GestorCliente;

public class InterfazBuscarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNroCliente;
	private JTextField textFieldNroDoc;
	private JTextField textFieldApellido;
	private JTextField textFieldNombre;
	private JTable tablaClientes;
	private JComboBox comboBoxTipoDoc;
	
	public InterfazBuscarCliente()  throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setTitle("Productor de seguro - Buscar cliente");
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
		        if (comboBoxTipoDoc.getSelectedItem() != null) {
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
		        List<ClienteDTO> listaClientes = GestorCliente.getInstance().buscar(cliente);
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
		scrollPane.setBounds(60, 290, 685, 120);
		contentPane.add(scrollPane);
		
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
		
		JPanel panelResultado = new JPanel();
		panelResultado.setBackground(Color.WHITE);
		panelResultado.setBorder(new TitledBorder(null, "Resultado de b\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelResultado.setBounds(28, 249, 780, 190);
		contentPane.add(panelResultado);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(Color.WHITE);
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(3);
				cliente.setNombre("Santi");
				cliente.setApellido("Wangher");
				cliente.setNroCliente("12312312");
				GestorCliente.getInstance().create(cliente);
			}
		});
		btnConfirmar.setBounds(28, 460, 89, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnCancelar.setBounds(125, 460, 89, 23);
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