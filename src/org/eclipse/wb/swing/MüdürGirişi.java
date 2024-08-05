package org.eclipse.wb.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import proje.Hesap;
import proje.KrediKartı;
import proje.Main;
import proje.Personel;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MüdürGirişi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MüdürGirişi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 580);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MÜDÜR EKRANI");
		lblNewLabel.setBounds(5, 5, 816, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(221, 70, 281, 188);
		contentPane.add(scrollPane);
		
		JList blokeler = new JList();
		scrollPane.setViewportView(blokeler);
		blokeler.setFont(new Font("Tahoma", Font.BOLD, 10));
		blokeler.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.RED));
		blokeler.setModel(new DefaultComboBoxModel(Personel.blokeKartlar()));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(535, 70, 281, 188);
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
		
		JLabel lblNewLabel_1_2 = new JLabel("Kredi Kartı İstekleri");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(221, 277, 281, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Kredi İstekleri");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(535, 278, 281, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JList kartistek = new JList();
		kartistek.setFont(new Font("Tahoma", Font.BOLD, 10));
		kartistek.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLUE));
		kartistek.setBounds(221, 300, 279, 186);
		kartistek.setModel(new DefaultComboBoxModel(Personel.krediKartıIstekleri()));
		contentPane.add(kartistek);
		
		JList kredistek = new JList();
		kredistek.setFont(new Font("Tahoma", Font.BOLD, 10));
		kredistek.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.MAGENTA));
		kredistek.setBounds(535, 301, 279, 186);
		kredistek.setModel(new DefaultComboBoxModel(Personel.krediIstekleri()));
		contentPane.add(kredistek);
		
		JButton btnKrediOnayla = new JButton("KREDİ ONAYLA");
		btnKrediOnayla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int onay=JOptionPane.showConfirmDialog(null,"Krediyi onaylıyor musunuz?","Onaylandı",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(onay==JOptionPane.YES_OPTION) {
					String id=kredistek.getSelectedValue().toString();
					new Hesap("TL",id).bakiye=Main.müşteridatabase.get(id).kreditalebi;
					Main.müşteridatabase.get(id).kreditalebi=0;
				}
			}
		});
		btnKrediOnayla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKrediOnayla.setBackground(Color.YELLOW);
		btnKrediOnayla.setBounds(10, 268, 191, 56);
		contentPane.add(btnKrediOnayla);
		
		JButton btnKrediKartOnayla = new JButton("KREDİ KARTI ONAYLA");
		btnKrediKartOnayla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int onay=JOptionPane.showConfirmDialog(null,"Kredi kartını onaylıyor musunuz?","Onaylandı",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(onay==JOptionPane.YES_OPTION) {
					String id=kartistek.getSelectedValue().toString();
					new KrediKartı(id,50000);
					Main.müşteridatabase.get(id).kredikartıOnayı=false;
				}
			}
		});
		btnKrediKartOnayla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKrediKartOnayla.setBackground(Color.YELLOW);
		btnKrediKartOnayla.setBounds(10, 334, 191, 56);
		contentPane.add(btnKrediKartOnayla);
		
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
