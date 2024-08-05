package org.eclipse.wb.swing;
import proje.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Döviz_al_sat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel frame;
	private JTextField çevrilenhesap;
	private JTextField aktarılanhesap;
	private JTextField tutar;


	/**
	 * Create the frame.
	 */
	public Döviz_al_sat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 580);
		frame = new JPanel();
		frame.setBackground(Color.DARK_GRAY);
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);

		setContentPane(frame);
		frame.setLayout(null);
		



		
		JLabel lblNewLabel = new JLabel("HESAPLARIM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(10, 37, 338, 13);
		frame.add(lblNewLabel);
		
		
		JTextArea hesapListesi = new JTextArea();
		hesapListesi.setBackground(Color.DARK_GRAY);
		hesapListesi.setFont(new Font("Monospaced", Font.BOLD, 12));
		hesapListesi.setEditable(false);
		hesapListesi.setBounds(10, 60, 338, 473);
		hesapListesi.setText(Main.müşteridatabase.get(MüşteriMenü.id).hesapListem());
		frame.add(hesapListesi);
		
		JLabel lblNewLabel_2 = new JLabel("Çevrilecek Hesap: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setBounds(417, 61, 152, 43);
		frame.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Aktarılacak Hesap: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(417, 114, 152, 43);
		frame.add(lblNewLabel_1);
		
		çevrilenhesap = new JTextField();
		çevrilenhesap.setFont(new Font("Tahoma", Font.BOLD, 13));
		çevrilenhesap.setBounds(579, 73, 190, 19);
		frame.add(çevrilenhesap);
		çevrilenhesap.setColumns(10);
		
		aktarılanhesap = new JTextField();
		aktarılanhesap.setFont(new Font("Tahoma", Font.BOLD, 13));
		aktarılanhesap.setColumns(10);
		aktarılanhesap.setBounds(579, 127, 190, 19);
		frame.add(aktarılanhesap);
		
		tutar = new JTextField();
		tutar.setFont(new Font("Tahoma", Font.BOLD, 13));
		tutar.setColumns(10);
		tutar.setBounds(580, 178, 190, 19);
		frame.add(tutar);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tutar: ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.ORANGE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(417, 167, 152, 43);
		frame.add(lblNewLabel_1_1);
		
		JLabel bilgiEkranı = new JLabel("");
		bilgiEkranı.setForeground(Color.ORANGE);
		bilgiEkranı.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bilgiEkranı.setBounds(382, 319, 387, 50);
		frame.add(bilgiEkranı);
		
		JButton döviztuşu = new JButton("AL/SAT");
		döviztuşu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ç=Integer.parseInt(çevrilenhesap.getText());
					int a=Integer.parseInt(aktarılanhesap.getText());
					int t=Integer.parseInt(tutar.getText());	
					if(Hesap.bakiye(ç)>=t) {
						Hesap.dovizeCevir(ç,a,t);
						bilgiEkranı.setText("İşlem başarılı");
					}
					else {
						bilgiEkranı.setText("Yetersiz bakiye");
					}
					hesapListesi.setText(Main.müşteridatabase.get(MüşteriMenü.id).hesapListem());
					
				}catch(NullPointerException x) {
					bilgiEkranı.setText("Bir hata oluştu,lütfen hesap numaralarını kontrol edin");
				}
			}
		});
		döviztuşu.setFont(new Font("Tahoma", Font.BOLD, 17));
		döviztuşu.setBounds(579, 220, 190, 50);
		frame.add(döviztuşu);
		
		JButton geri = new JButton("GERİ");
		geri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MüşteriMenü(MüşteriMenü.id);
			}
		});
		geri.setFont(new Font("Tahoma", Font.BOLD, 17));
		geri.setBounds(579, 478, 190, 43);
		frame.add(geri);

	}
}
