package org.eclipse.wb.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import proje.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MüşteriMenü extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static String id;
	private JTextField txtTutarGirin;
	
	/**
	 * Create the frame.
	 */
	public MüşteriMenü(String müşteriID) {
		id=müşteriID;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setVisible(true);
		
		JButton btnNewButton = new JButton("HESAPLARIM");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Hesaplarım(müşteriID);
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(15, 333, 142, 41);
		
		JButton btnNewButton_1 = new JButton("FATURA ÖDE");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FaturaOde();
			}
		});
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(15, 384, 142, 41);
		
		JButton btnNewButton_2 = new JButton("KARTLARIM");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Kartlarım();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(15, 435, 142, 41);
		
		JLabel kredibilgi = new JLabel("");
		kredibilgi.setForeground(Color.ORANGE);
		kredibilgi.setFont(new Font("Tahoma", Font.BOLD, 10));
		kredibilgi.setBounds(673, 302, 143, 21);
		contentPane.add(kredibilgi);
		
		txtTutarGirin = new JTextField();
		txtTutarGirin.setText("TUTAR GİRİN");
		txtTutarGirin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTutarGirin.setText("");
			}
		});
		
		txtTutarGirin.setBounds(673, 244, 143, 19);
		contentPane.add(txtTutarGirin);
		txtTutarGirin.setColumns(10);
		
		JButton kredituşu = new JButton("KREDİ İSTE");
		kredituşu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int k=Integer.parseInt(txtTutarGirin.getText());
				Main.müşteridatabase.get(müşteriID).krediTalebi(k);
				kredibilgi.setText("Talebiniz iletildi");
				}
				catch(NumberFormatException v) {
					kredibilgi.setText("Geçersiz tutar girdiniz");
				}	
			}
		});
		kredituşu.setFont(new Font("Tahoma", Font.BOLD, 10));
		kredituşu.setBackground(Color.ORANGE);
		kredituşu.setBounds(673, 273, 142, 21);
		
		JButton btnNewButton_4 = new JButton("PARA ÇEK");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ParaÇek();
			}
		});
		btnNewButton_4.setBackground(Color.ORANGE);
		btnNewButton_4.setBounds(673, 384, 142, 41);
		
		JButton btnNewButton_5 = new JButton("PARA YATIR");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ParaYatır();
			}
		});
		btnNewButton_5.setBackground(Color.ORANGE);
		btnNewButton_5.setBounds(673, 435, 142, 41);
		
		JButton btnNewButton_6 = new JButton("EFT/HAVALE");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ParaGönder();
			}
		});
		btnNewButton_6.setBackground(Color.ORANGE);
		btnNewButton_6.setBounds(673, 486, 142, 41);
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_4);
		contentPane.add(btnNewButton_2);
		contentPane.add(kredituşu);
		contentPane.add(btnNewButton_6);
		contentPane.add(btnNewButton_5);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_7 = new JButton("DÖVİZ AL/SAT");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Döviz_al_sat();
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_7.setBackground(Color.ORANGE);
		btnNewButton_7.setBounds(15, 486, 142, 41);
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel = new JLabel("HOŞGELDİNİZ,"+Main.müşteridatabase.get(müşteriID).ad.toUpperCase()+" "+Main.müşteridatabase.get(müşteriID).soyad.toUpperCase());
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(249, 116, 306, 41);
		contentPane.add(lblNewLabel);
		
		JButton geri = new JButton("ÇIKIŞ YAP");
		geri.setBackground(Color.ORANGE);
		geri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login window=new Login();
				window.frame.setVisible(true);
			}
		});
		geri.setFont(new Font("Tahoma", Font.BOLD, 13));
		geri.setBounds(310, 485, 197, 41);
		contentPane.add(geri);
		
		JButton btnNewButton_3 = new JButton("ŞİFREMİ DEĞİŞTİR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sifre=JOptionPane.showInputDialog("Yeni şifrenizi girin(sadece 4 rakamdan oluşmalı):");
				Main.müşteridatabase.get(müşteriID).setMüşteriŞifre(sifre);
				JOptionPane.showMessageDialog(null, "Şifreniz değiştirildi");
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3.setBounds(310, 445, 197, 31);
		contentPane.add(btnNewButton_3);
		

		

	}
}
