package org.eclipse.wb.swing;
import java.awt.EventQueue;
import proje.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class Login {

	public JFrame frame;
	private JTextField idgiris;
	private JPasswordField sifregiris;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Main.OrnekleriOlustur();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/org/eclipse/wb/swing/bank.png")));
		frame.setTitle("İstanbul Üniversitesi-Cerrahpaşa");
		frame.setBounds(100, 100, 840, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("İUCBANK");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("ŞİFRE:");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		idgiris = new JTextField();
		idgiris.setForeground(Color.BLACK);
		idgiris.setBackground(Color.WHITE);
		idgiris.setColumns(10);
		
		sifregiris = new JPasswordField();
		sifregiris.setForeground(Color.BLACK);
		sifregiris.setBackground(Color.WHITE);
		JButton btnNewButton = new JButton("GİRİŞ");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=idgiris.getText();
				@SuppressWarnings("deprecation")
				String sifre=sifregiris.getText();
				if(Main.müşteridatabase.containsKey(id)&&Main.müşteridatabase.get(id).getMüşteriŞifre().equals(sifre)) {
					frame.dispose();
					new MüşteriMenü(id);
					}
				else if(Main.personeldatabase.containsKey(Integer.parseInt(id))&&Main.personeldatabase.get(Integer.parseInt(id)).getSifre()==Integer.parseInt(sifre)) {
					frame.dispose();
					if(Main.personeldatabase.get(Integer.parseInt(id)) instanceof Müdür)
						new MüdürGirişi();
					else
						new PersonelMenü();
				}
				else {
					JOptionPane.showMessageDialog(null, "Hatalı giriş yaptınız,Lütfen tekrar deneyin");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBackground(Color.ORANGE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(287)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(230)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNewLabel_2)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
								.addGap(36)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(sifregiris, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
									.addComponent(idgiris, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))))
					.addGap(294))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(127)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(idgiris, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(sifregiris, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(217, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
