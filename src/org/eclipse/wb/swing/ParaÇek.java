package org.eclipse.wb.swing;
import proje.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ParaÇek extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField tutar;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ParaÇek() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ÇEKİLECEK TUTAR:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(124, 143, 186, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("HESAP NUMARASI:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(124, 205, 186, 21);
		contentPane.add(lblNewLabel_1);
		
		tutar = new JFormattedTextField();
		tutar.setFont(new Font("Tahoma", Font.BOLD, 17));
		tutar.setBounds(320, 143, 186, 21);
		contentPane.add(tutar);
		tutar.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(551, 208, 186, 21);
		contentPane.add(lblNewLabel_5);
		
		
		JComboBox sec = new JComboBox();
		sec.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Integer bak=Integer.parseInt(sec.getSelectedItem().toString());
				lblNewLabel_5.setText("Bakiye: "+Hesap.bakiye(bak));
			}
		});
		sec.setFont(new Font("Tahoma", Font.BOLD, 10));
		sec.setBounds(320, 208, 186, 21);
		sec.setModel(new DefaultComboBoxModel(Main.müşteridatabase.get(MüşteriMenü.id).toArrayhesap()));
		contentPane.add(sec);
		
		JLabel sonucEkranı = new JLabel("");
		sonucEkranı.setFont(new Font("Tahoma", Font.PLAIN, 17));
		sonucEkranı.setForeground(Color.ORANGE);
		sonucEkranı.setBounds(124, 304, 635, 35);
		contentPane.add(sonucEkranı);
		
		JButton onay = new JButton("ONAYLA");
		onay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double t=Double.parseDouble(tutar.getText());
				int n=Integer.parseInt(sec.getSelectedItem().toString());
				if(t<=Hesap.bakiye(n)) {
				sonucEkranı.setText(t+" tutarındaki para "+n+"'nolu hesaptan çekildi.");
				Hesap.cek(n,t);
				}
				else {
					sonucEkranı.setText("Yetersiz bakiye");
				}
			}
		});
		onay.setFont(new Font("Tahoma", Font.BOLD, 17));
		onay.setBounds(363, 396, 172, 78);
		contentPane.add(onay);
		
		JButton geri = new JButton("GERİ");
		geri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MüşteriMenü(MüşteriMenü.id);
			}
		});
		geri.setFont(new Font("Tahoma", Font.BOLD, 17));
		geri.setBounds(587, 396, 172, 78);
		contentPane.add(geri);
		

	}

}
