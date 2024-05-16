package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtf1;
	private JTextField jtf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCalculadora frame = new JCalculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JCalculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número 1:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(84, 47, 99, 20);
		contentPane.add(lblNewLabel);
		
		jtf1 = new JTextField();
		jtf1.setBounds(253, 44, 117, 31);
		contentPane.add(jtf1);
		jtf1.setColumns(10);
		
		JLabel txtNum2 = new JLabel("Número 2: ");
		txtNum2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNum2.setBounds(84, 135, 84, 14);
		contentPane.add(txtNum2);
		
		jtf2 = new JTextField();
		jtf2.setBounds(253, 132, 117, 31);
		contentPane.add(jtf2);
		jtf2.setColumns(10);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setBounds(226, 305, 129, 31);
		contentPane.add(lblResultado);
		
		JButton jbtSumar = new JButton("Sumar");
		jbtSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int suma = Integer.parseInt(jtf1.getText()) + Integer.parseInt(jtf2.getText());
				lblResultado.setText("suma: " + suma);
			}
		});
		jbtSumar.setBounds(94, 224, 122, 31);
		contentPane.add(jbtSumar);
		
		JButton jbtMultiplicar = new JButton("Multiplicar");
		jbtMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int producto = Integer.parseInt(jtf1.getText()) * Integer.parseInt(jtf2.getText());
				lblResultado.setText("producto: " + producto);
			}
		});
		jbtMultiplicar.setBounds(273, 224, 137, 31);
		contentPane.add(jbtMultiplicar);
		
		JButton jbtCerrar = new JButton("Salir");
		jbtCerrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		jbtCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCalculadora.this.dispose();
			}
		});
		jbtCerrar.setBounds(524, 284, 99, 31);
		contentPane.add(jbtCerrar);
		
		
	}
}
