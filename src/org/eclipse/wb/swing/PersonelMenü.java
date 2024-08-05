package org.eclipse.wb.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import proje.Main;
import proje.Personel;

public class PersonelMenü extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PersonelMenü() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 580);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PERSONEL EKRANI");
		lblNewLabel.setBounds(5, 5, 816, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(221, 70, 281, 463);
		contentPane.add(scrollPane);
		
		JList blokeler = new JList();
		scrollPane.setViewportView(blokeler);
		blokeler.setFont(new Font("Tahoma", Font.BOLD, 10));
		blokeler.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.RED));
		blokeler.setModel(new DefaultComboBoxModel(Personel.blokeKartlar()));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(535, 70, 281, 463);
		contentPane.add(scrollPane_1);
		
		JList limitist = new JList();
		limitist.setFont(new Font("Tahoma", Font.BOLD, 10));
		scrollPane_1.setViewportView(limitist);
		limitist.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.GREEN));
		limitist.setModel(new DefaultComboBoxModel(Personel.krediKartıLimitIstekleri()));
		
		JLabel lblNewLabel_1 = new JLabel("Bloke Kartlar");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(221, 48, 281, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Limit Arttırma Talepleri");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(535, 48, 281, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JButton geri = new JButton("ÇIKIŞ YAP");
		geri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login window=new Login();
				window.frame.setVisible(true);
			}
		});
		geri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		geri.setBackground(Color.YELLOW);
		geri.setBounds(10, 477, 191, 56);
		contentPane.add(geri);
		
		JButton btnlimitdegis = new JButton("KART LİMİTİ DEĞİŞTİR");
		btnlimitdegis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int onay=JOptionPane.showConfirmDialog(null,"Limit değişikliğini onaylıyor musunuz?","Onaylandı",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(onay==JOptionPane.YES_OPTION) {
					Long kart=Long.parseLong(limitist.getSelectedValue().toString());
					Main.kartdatabase.get(kart).limit=Main.kartdatabase.get(kart).istenenLimit;
					Main.kartdatabase.get(kart).istenenLimit=0;
				}
			}
		});
		btnlimitdegis.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnlimitdegis.setBackground(Color.YELLOW);
		btnlimitdegis.setBounds(10, 70, 191, 56);
		contentPane.add(btnlimitdegis);
		
		JButton btnKartBlokeA = new JButton("KART BLOKE AÇ");
		btnKartBlokeA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int onay=JOptionPane.showConfirmDialog(null,"Blokeyi kaldırmayı onaylıyor musunuz?","Onaylandı",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(onay==JOptionPane.YES_OPTION) {
					Long kart=Long.parseLong(blokeler.getSelectedValue().toString());
					Main.kartdatabase.get(kart).blokemi=false;
				}
			}
		});
		btnKartBlokeA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKartBlokeA.setBackground(Color.YELLOW);
		btnKartBlokeA.setBounds(10, 136, 191, 56);
		contentPane.add(btnKartBlokeA);
		
		JButton btnYeniMteriKayd = new JButton("YENİ MÜŞTERİ KAYDI");
		btnYeniMteriKayd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new YeniMüşteri();
			}
		});
		btnYeniMteriKayd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnYeniMteriKayd.setBackground(Color.YELLOW);
		btnYeniMteriKayd.setBounds(10, 202, 191, 56);
		contentPane.add(btnYeniMteriKayd);
	}
}
