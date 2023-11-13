package capaPresentacion;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class InterfazBuscarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNroCliente;
	private JTextField textFieldNroDoc;
	private JTextField textFieldApellido;
	private JTextField textFieldNombre;
	private JTable tablaClientes;

	
	public InterfazBuscarCliente()  throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		setTitle("Productor de seguro - Buscar cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JComboBox comboBoxTipoDoc = new JComboBox();
		comboBoxTipoDoc.setBounds(180, 107, 180, 20);
		contentPane.add(comboBoxTipoDoc);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnBuscar.setBounds(60, 190, 89, 23);
		contentPane.add(btnBuscar);
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setBorder(new TitledBorder(null, "B\u00FAsqueda de cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBusqueda.setBounds(28, 28, 780, 210);
		contentPane.add(panelBusqueda);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 290, 685, 120);
		contentPane.add(scrollPane);
		
		tablaClientes = new JTable();
		tablaClientes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Nro. Cliente", "Apellido", "Nombre", "Tipo documento", "Nro. Documento"
			}
		));
		tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(90);
		tablaClientes.getColumnModel().getColumn(2).setPreferredWidth(90);
		tablaClientes.getColumnModel().getColumn(3).setPreferredWidth(90);
		tablaClientes.getColumnModel().getColumn(4).setPreferredWidth(100);
		scrollPane.setViewportView(tablaClientes);
		
		JPanel panelResultado = new JPanel();
		panelResultado.setBorder(new TitledBorder(null, "Resultado de b\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelResultado.setBounds(28, 249, 780, 190);
		contentPane.add(panelResultado);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setBounds(28, 460, 89, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(125, 460, 89, 23);
		contentPane.add(btnCancelar);

	}
}