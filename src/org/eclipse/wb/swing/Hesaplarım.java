package org.eclipse.wb.swing;

import proje.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;


public class Hesaplarım extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Hesaplarım(String müşteriID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		;
		
		JTextArea hesapListesi = new JTextArea();
		hesapListesi.setForeground(Color.WHITE);
		hesapListesi.setBackground(Color.DARK_GRAY);
		hesapListesi.setFont(new Font("Monospaced", Font.BOLD, 17));
		hesapListesi.setDropMode(DropMode.INSERT);
		hesapListesi.setEditable(false);
		hesapListesi.setBounds(51, 25, 486, 471);
		hesapListesi.setBorder(new LineBorder(Color.ORANGE, 5, true));
		hesapListesi.setText(Main.müşteridatabase.get(müşteriID).hesapListem());
		contentPane.add(hesapListesi);
		
		
		JButton btnNewButton = new JButton("GERİ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MüşteriMenü(müşteriID);
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(594, 426, 194, 70);
		contentPane.add(btnNewButton);
		
		JComboBox dövizseç = new JComboBox();
		dövizseç.setFont(new Font("Tahoma", Font.BOLD, 13));
		dövizseç.setModel(new DefaultComboBoxModel(new String[] {"TL", "USD", "EURO"}));
		dövizseç.setBounds(578, 65, 65, 21);
		contentPane.add(dövizseç);
		
		JLabel successtext = new JLabel("");
		successtext.setForeground(Color.ORANGE);
		successtext.setBounds(608, 96, 153, 21);
		contentPane.add(successtext);
		
		JButton oluşturtuşu = new JButton("YENİ HESAP OLUŞTUR");
		oluşturtuşu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String d=dövizseç.getSelectedItem().toString();
				new Hesap(d,MüşteriMenü.id);
				successtext.setText("Hesap Oluşturuldu");
				hesapListesi.setText(Main.müşteridatabase.get(müşteriID).hesapListem());
			}
		});
		oluşturtuşu.setFont(new Font("Tahoma", Font.BOLD, 12));
		oluşturtuşu.setBounds(647, 65, 169, 21);
		contentPane.add(oluşturtuşu);
		

		

		
	}
}
