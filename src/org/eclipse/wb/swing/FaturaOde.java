package org.eclipse.wb.swing;

import proje.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;

public class FaturaOde extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sozlesmeNo;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public FaturaOde() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 580);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SÖZLEŞME NO: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(189, 98, 180, 65);
		contentPane.add(lblNewLabel);
		
		sozlesmeNo = new JTextField();
		sozlesmeNo.setFont(new Font("Tahoma", Font.BOLD, 17));
		sozlesmeNo.setBounds(379, 110, 202, 39);
		contentPane.add(sozlesmeNo);
		sozlesmeNo.setColumns(10);
		
		
		JLabel bilgiEkranı = new JLabel("");
		bilgiEkranı.setForeground(Color.ORANGE);
		bilgiEkranı.setFont(new Font("Tahoma", Font.PLAIN, 17));
		bilgiEkranı.setBounds(300, 180, 516, 39);
		contentPane.add(bilgiEkranı);
		
		JButton sorulamatusu = new JButton("SORGULA");
		sorulamatusu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int n=Integer.parseInt(sozlesmeNo.getText());
				bilgiEkranı.setText(Main.faturadatabase.get(n).faturaborç+"TL "+Main.faturadatabase.get(n).tip+" borcunuz bulunmaktadır.");
				}
				catch(NullPointerException a) {
					bilgiEkranı.setText("Sistemde borcunuz gözükmemektedir");
				}
				}
		});
		sorulamatusu.setFont(new Font("Tahoma", Font.BOLD, 10));
		sorulamatusu.setBounds(634, 119, 85, 21);
		contentPane.add(sorulamatusu);
		
		JLabel lblcretinAlnacaHesap = new JLabel("ÜCRETİN ALINACAĞI HESAP VEYA KART NO: ");
		lblcretinAlnacaHesap.setHorizontalAlignment(SwingConstants.RIGHT);
		lblcretinAlnacaHesap.setForeground(Color.ORANGE);
		lblcretinAlnacaHesap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcretinAlnacaHesap.setBackground(Color.DARK_GRAY);
		lblcretinAlnacaHesap.setBounds(10, 377, 359, 65);
		contentPane.add(lblcretinAlnacaHesap);
		
		JLabel bilgiEkranı_1 = new JLabel("");
		bilgiEkranı_1.setForeground(Color.ORANGE);
		bilgiEkranı_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		bilgiEkranı_1.setBounds(20, 452, 604, 39);
		contentPane.add(bilgiEkranı_1);
		
		JLabel ödemetipi = new JLabel("ÖDEME TİPİ:");
		ödemetipi.setHorizontalAlignment(SwingConstants.RIGHT);
		ödemetipi.setForeground(Color.ORANGE);
		ödemetipi.setFont(new Font("Tahoma", Font.BOLD, 15));
		ödemetipi.setBackground(Color.DARK_GRAY);
		ödemetipi.setBounds(189, 279, 180, 65);
		contentPane.add(ödemetipi);
			
		JButton btnNewButton_1 = new JButton("GERİ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MüşteriMenü(MüşteriMenü.id);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(634, 452, 150, 65);
		contentPane.add(btnNewButton_1);
		
		JComboBox Sec = new JComboBox();

		Sec.setFont(new Font("Tahoma", Font.BOLD, 15));
		Sec.setMaximumRowCount(5);
		Sec.setBounds(379, 399, 180, 21);
		contentPane.add(Sec);
		
		JRadioButton KrediKartı = new JRadioButton("Kredi Kartı");
		KrediKartı.setFont(new Font("Tahoma", Font.BOLD, 13));
		KrediKartı.setForeground(Color.ORANGE);
		KrediKartı.setBackground(Color.DARK_GRAY);
		KrediKartı.setBounds(379, 302, 103, 21);
		contentPane.add(KrediKartı);
		
		JRadioButton Hesapbt = new JRadioButton("Hesap");
		Hesapbt.setFont(new Font("Tahoma", Font.BOLD, 13));
		Hesapbt.setForeground(Color.ORANGE);
		Hesapbt.setBackground(Color.DARK_GRAY);
		Hesapbt.setBounds(484, 302, 103, 21);
		contentPane.add(Hesapbt);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(Hesapbt);
		buttonGroup.add(KrediKartı);
		Hesapbt.addItemListener(new ItemListener() {
	            @SuppressWarnings("unchecked")
				@Override
	            public void itemStateChanged(ItemEvent e) {
	                if (e.getStateChange() == ItemEvent.SELECTED) {
	                    JRadioButton selectedRadioButton = (JRadioButton) e.getItem();
	                    if(selectedRadioButton==Hesapbt) {
	                    Sec.setModel(new DefaultComboBoxModel(Main.müşteridatabase.get(MüşteriMenü.id).toArrayhesap()));	
	                    }
	                }
	            }
	        });
		KrediKartı.addItemListener(new ItemListener() {
            @SuppressWarnings("unchecked")
			@Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JRadioButton selectedRadioButton = (JRadioButton) e.getItem();
                    if(selectedRadioButton==KrediKartı) {
                    Sec.setModel(new DefaultComboBoxModel(Main.müşteridatabase.get(MüşteriMenü.id).toArraykart()));	
                    }
                }
            }
        });
		
		JButton btnNewButton = new JButton("ÖDE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=Integer.parseInt(sozlesmeNo.getText());
				try {
				if(Hesapbt.isSelected()) {
				int h=Integer.parseInt(Sec.getSelectedItem().toString());	
					if(Hesap.bakiye(h)-Main.faturadatabase.get(n).faturaborç>=0&&Main.hesapdatabase.get(h).doviztipi.equals("TL")) {
						Fatura.faturaOde("hesap", n, h);
						bilgiEkranı_1.setText("Ödeme başarılı");
					}
					else {
						bilgiEkranı_1.setText("Yetersiz bakiye yada tl tipi olmayan bir hesaptan ödeme denediniz");
					}
				}
				else if(KrediKartı.isSelected()){
					Long h=Long.parseLong(Sec.getSelectedItem().toString());
					if(Main.kartdatabase.get(h).borc+Main.faturadatabase.get(n).faturaborç<=Main.kartdatabase.get(h).limit&&!Main.kartdatabase.get(h).blokemi) {
						Fatura.faturaOde("kart", n, h);
						bilgiEkranı_1.setText("Ödeme başarılı");
						if(Main.kartdatabase.get(h).borc==Main.kartdatabase.get(h).limit)
							Main.kartdatabase.get(h).blokemi=true;
					}
					else {
						bilgiEkranı_1.setText("Kart limitinizi kontrol ediniz");
					}
				}
				}
				catch(NullPointerException b) {
					bilgiEkranı_1.setText("Sistemde borcunuz gözükmemektedir");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(634, 401, 85, 21);
		contentPane.add(btnNewButton);
	}
}
