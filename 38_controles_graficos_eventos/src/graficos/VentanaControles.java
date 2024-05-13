package graficos;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaControles extends JFrame {
	public VentanaControles() {
		super("Ventana controles");
		this.setBounds(100,  80,  800,  400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// creación y configuración de controles:
		initComponents();
		this.setVisible(true);
	}
	
	private void initComponents() {
		this.setLayout(null);
		JButton jbt1 = new JButton("Pulsar aquí");	
		JLabel jlabel1 = new JLabel();
		JButton jbt2 = new JButton("Colorear");
		jbt2.setBounds(400, 50, 120, 50);
		jlabel1.setBounds(100, 150, 150, 40);
		jbt1.setBounds(50, 50, 300, 50);
		this.add(jbt1);
		this.add(jlabel1);
		this.add(jbt2);
		// gestión de eventos:
		ActionListener listener = e->jlabel1.setText("has pulsado"); // crear la instancia del manejador
		jbt1.addActionListener(listener); // asociar la instancia del manejador al objeto fuente
		
		ActionListener listener2 = e-> VentanaControles.this.getContentPane().setBackground(Color.CYAN);
		jbt2.addActionListener(listener2);
	}
}
