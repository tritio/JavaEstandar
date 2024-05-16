package graficos;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JCalculadora extends JFrame {
	public JCalculadora() {
		super("Calculadora");
		this.setBounds(100,  80,  800,  400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// creación y configuración de controles:
		initComponents();
		this.setVisible(true);
	}
	
	private void initComponents() {
		this.setLayout(null);
		JLabel num1 = new JLabel("Número 1:");	
		num1.setBounds(50, 80, 150, 25);
		JLabel num2 = new JLabel("Número 2:");	
		num2.setBounds(50,120, 150, 25);
		JTextField tex1 = new JTextField();
		tex1.setBounds(150,80,150, 25);
		JTextField tex2 = new JTextField();
		tex2.setBounds(150,120,150, 25);
		JButton btnSumar = new JButton("Sumar");		
		btnSumar.setBounds(220, 170, 120, 40);
		JButton btnMultiplicar = new JButton("Multiplicar");		
		btnMultiplicar.setBounds(360, 170, 120, 40);
		JLabel resultado = new JLabel("");
		resultado.setBounds(240, 240, 100, 50);
		this.add(num1);
		this.add(num2);
		this.add(tex1);
		this.add(tex2);
		this.add(btnSumar);
		this.add(btnMultiplicar);
		this.add(resultado);
		
		// Gestión de e:ventos
		ActionListener sumar = e->resultado
				.setText(String.valueOf(Double.parseDouble(tex1.getText()) + Double.parseDouble(tex2.getText()))); // crear la instancia del manejador
		btnSumar.addActionListener(sumar); // asociar la instancia del manejador al objeto fuente
		
		
		btnMultiplicar.addActionListener(e-> 
		{
			double multiplicar = Double.parseDouble(tex1.getText()) * Double.parseDouble(tex2.getText());
			resultado.setText("Suma " + multiplicar);
			tex1.setText("");
			tex2.setText("");
		});
		
		FocusListener listener1 = new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField jtf = (JTextField)e.getSource(); // devuelve un objet pero como sabemos que debe ser un JTextField pues lo casteamos. obtiene una referencia a la caja en la que se ha producido el evento
				if(jtf.getText().isEmpty()) {
					jtf.setText("0");
					return;
				}
				try {
					Integer.parseInt(jtf.getText()); // si no consigue parsearlo da error 
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(JCalculadora.this ,  "debes escribir un número");
					jtf.requestFocus(); // si da error (si no hemos metido un número) mantiene el foco en la caja
					jtf.selectAll(); // selecciona el texto introducido
				}
				
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		// asociamos el listener a las dos cajas
		tex1.addFocusListener(listener1);
		tex2.addFocusListener(listener1);				
	}
}
