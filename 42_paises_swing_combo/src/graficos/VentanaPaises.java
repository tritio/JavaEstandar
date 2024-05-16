package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adaptadores.ComboBoxModelContinentesImpl;
import adaptadores.TableModelPaisesImpl;
import service.PaisesService;
import service.PaisesServiceFactory;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTable;

public class VentanaPaises extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPaises frame = new VentanaPaises();
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
	public VentanaPaises() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Continentes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(44, 41, 122, 24);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> comboContinentes = new JComboBox<>();
		comboContinentes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String seleccionado = (String)comboContinentes.getSelectedItem(); // casting porque getSelectedItem devuelve un objeto según la documentación
				//	var service = PaisesServiceFactory.getPaisesService();					
//					JOptionPane.showMessageDialog(VentanaPaises.this, "Países de: " + seleccionado + 
//							": " + service.listarPaisesPorContinente(seleccionado).size());		
					
					// volcamos el adapatador con los países en el JTable:
					var adaptador = new TableModelPaisesImpl(seleccionado);
					table.setModel(adaptador);
				}
						
			}
		});
		comboContinentes.setBounds(188, 44, 131, 22);
		contentPane.add(comboContinentes);
		comboContinentes.setModel(new ComboBoxModelContinentesImpl());
		
		JLabel lblNewLabel_1 = new JLabel("Países");
		lblNewLabel_1.setBounds(51, 146, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(146, 103, 474, 248);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
