package graficos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import service.ClientesService;
import service.ClientesServiceFactory;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfUsuario;
	private JTextField jtfPassword;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;

	

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(48, 44, 74, 14);
		contentPane.add(lblNewLabel);
		
		jtfUsuario = new JTextField();
		jtfUsuario.setBounds(144, 41, 86, 20);
		contentPane.add(jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(48, 97, 74, 14);
		contentPane.add(lblPassword);
		
		jtfPassword = new JTextField();
		jtfPassword.setColumns(10);
		jtfPassword.setBounds(144, 94, 86, 20);
		contentPane.add(jtfPassword);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(48, 146, 74, 14);
		contentPane.add(lblEmail);
		
		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		jtfEmail.setBounds(144, 143, 86, 20);
		contentPane.add(jtfEmail);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setBounds(48, 192, 74, 14);
		contentPane.add(lblTelfono);
		
		jtfTelefono = new JTextField();
		jtfTelefono.setColumns(10);
		jtfTelefono.setBounds(144, 189, 86, 20);
		contentPane.add(jtfTelefono);
		
		JButton jbtRegistrar = new JButton("Registrar");
		jbtRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensaje;
				ClientesService service=ClientesServiceFactory.getClientesService();
				Cliente cliente=new Cliente(0, 
						jtfUsuario.getText(), 
						jtfPassword.getText(),
						jtfEmail.getText(),
						Integer.parseInt(jtfTelefono.getText()));
				if(service.registrar(cliente)) {
					mensaje="Registro realizado!";
				}else {
					mensaje="Usuario repetido, no se ha registrado!";
				}
				JOptionPane.showMessageDialog(VentanaRegistro.this, mensaje);
				VentanaRegistro.this.dispose();
			}
		});
		jbtRegistrar.setBounds(191, 227, 89, 23);
		contentPane.add(jbtRegistrar);
		this.setVisible(true);
	}
}
