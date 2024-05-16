package graficos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import adaptadores.ComboBoxModelComunidadesImpl;
import adaptadores.ComboBoxModelProvinciasImpl;
import adaptadores.TableModelMunicipiosImpl;
import model.Provincia;

public class VentanaComunidades extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableMunicipios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaComunidades frame = new VentanaComunidades();
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
	public VentanaComunidades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComunidad = new JLabel("Selecciona una comunidad");
		lblComunidad.setBounds(233, 11, 196, 19);
		lblComunidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblComunidad);
		
		JComboBox comboComunidades = new JComboBox();
		comboComunidades.setBounds(189, 60, 319, 22);
		contentPane.add(comboComunidades);
		comboComunidades.setModel(new ComboBoxModelComunidadesImpl());		
		
		JComboBox<Provincia> comboProvincias = new JComboBox<>();
		comboProvincias.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Provincia prov = (Provincia) comboProvincias.getSelectedItem();
			//	String provincia = (String)comboProvincias.getSelectedItem();
				  if(e.getStateChange() == ItemEvent.SELECTED) {									
					// volcamos el adapatador con los países en el JTable:
					var adaptador = new TableModelMunicipiosImpl(prov.getCodigoProvincia());
					tableMunicipios.setModel(adaptador);
				}
				
			}
		});
		comboProvincias.setBounds(189, 157, 319, 22);
		contentPane.add(comboProvincias);
		
		
		comboComunidades.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String comunidad = (String)comboComunidades.getSelectedItem();
					// volcamos el adapatador con las provincias de la comunidad seleccionada en 
					// el combobox de provincias:
					var adaptador = new ComboBoxModelProvinciasImpl(comunidad);
					comboProvincias.setModel(adaptador);	
					// para borrar la tabla de municipios de selecciones previas:
					 tableMunicipios.setModel(new DefaultTableModel());
				}				
			
		});
		
		JLabel lblNewLabel = new JLabel("Selecciona provincia");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(244, 110, 241, 22);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Municipios");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(272, 199, 202, 33);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 243, 611, 181);
		contentPane.add(scrollPane);
		
		tableMunicipios = new JTable();
		scrollPane.setViewportView(tableMunicipios);
		
		JButton jbtSalir = new JButton("Salir");
		jbtSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaComunidades.this.dispose();
			}
		});
		jbtSalir.setBounds(322, 445, 89, 23);
		contentPane.add(jbtSalir);
		
		JLabel jlblReloj = new JLabel("");
		jlblReloj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jlblReloj.setBounds(589, 31, 127, 33);
		contentPane.add(jlblReloj);
		
		// hilo reloj
		ExecutorService service = Executors.newCachedThreadPool();
		service.submit(()-> {
			while(true) {
				// actualizar reloj cada medio segundo
				LocalTime hora = LocalTime.now();
				jlblReloj.setText(hora.toString());
				Thread.sleep(500);
			}			
		});
		service.shutdown();
	}
}
