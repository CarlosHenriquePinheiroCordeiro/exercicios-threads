package exercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;

public class Exercicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercicio frame = new Exercicio();
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
	public Exercicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel valorA = DefaultComponentFactory.getInstance().createLabel("0");
		valorA.setFont(new Font("Tahoma", Font.BOLD, 28));
		valorA.setBounds(266, 34, 92, 46);
		contentPane.add(valorA);
		
		JLabel valorB = DefaultComponentFactory.getInstance().createLabel("0");
		valorB.setFont(new Font("Tahoma", Font.BOLD, 28));
		valorB.setBounds(266, 91, 92, 38);
		contentPane.add(valorB);
		
		final Marcador m1 = new Marcador(valorA);
		final Marcador m2 = new Marcador(valorB);
		
		JButton btnStartA = new JButton("Start A");
		btnStartA.setBounds(11, 46, 79, 23);
		btnStartA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!m1.isIniciado()) {
					m1.start();
				}
				m1.retomaContagem();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnStartA);
		
		JButton btnStartB = new JButton("Start B");
		btnStartB.setBounds(10, 102, 80, 23);
		btnStartB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!m2.isIniciado()) {
					m2.start();
				}
				m2.retomaContagem();
			}
		});
		contentPane.add(btnStartB);
		
		JButton btnPauseA = new JButton("Pause A");
		btnPauseA.setBounds(92, 46, 85, 23);
		btnPauseA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m1.pausaContagem();
			}
		});
		contentPane.add(btnPauseA);
		
		JButton btnPauseB = new JButton("Pause B");
		btnPauseB.setBounds(92, 102, 85, 23);
		btnPauseB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m2.pausaContagem();
			}
		});
		contentPane.add(btnPauseB);
		
		JButton btnStopA = new JButton("Stop A");
		btnStopA.setBounds(180, 46, 76, 23);
		btnStopA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m1.paraContagem();
			}
		});
		contentPane.add(btnStopA);
		
		JButton btnStopB = new JButton("Stop B");
		btnStopB.setBounds(180, 102, 76, 23);
		btnStopB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m2.paraContagem();
			}
		});
		contentPane.add(btnStopB);
	}
}
