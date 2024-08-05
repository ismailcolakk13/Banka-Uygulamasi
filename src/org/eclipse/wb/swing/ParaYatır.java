package org.eclipse.wb.swing;

import proje.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ParaYatır extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField tutar;
	private JFormattedTextField hesapNo;

	/**
	 * Create the frame.
	 */
	public ParaYatır() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("YATIRILACAK TUTAR:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(124, 131, 186, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("HESAP NUMARASI:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(124, 209, 186, 53);
		contentPane.add(lblNewLabel_1);
		
		tutar = new JFormattedTextField();
		tutar.setFont(new Font("Tahoma", Font.BOLD, 17));
		tutar.setBounds(320, 143, 186, 35);
		contentPane.add(tutar);
		tutar.setColumns(10);
		
		hesapNo = new JFormattedTextField();
		hesapNo.setFont(new Font("Tahoma", Font.BOLD, 17));
		hesapNo.setColumns(10);
		hesapNo.setBounds(320, 221, 186, 35);
		contentPane.add(hesapNo);
		
		JLabel sonucEkranı = new JLabel("");
		sonucEkranı.setFont(new Font("Tahoma", Font.PLAIN, 17));
		sonucEkranı.setForeground(Color.ORANGE);
		sonucEkranı.setBounds(124, 304, 635, 35);
		contentPane.add(sonucEkranı);
		
		JButton onay = new JButton("ONAYLA");
		onay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double t=Double.parseDouble(tutar.getText());
				int n=Integer.parseInt(hesapNo.getText());
				sonucEkranı.setText(t+" tutarındaki para "+n+"'nolu hesaba yatırıldı.");
				Hesap.yatır(n,t);
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
