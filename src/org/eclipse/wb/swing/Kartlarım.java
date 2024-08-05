package org.eclipse.wb.swing;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import proje.Fatura;
import proje.Hesap;
import proje.KrediKartı;
import proje.Main;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("unused")
public class Kartlarım extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField miktar;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Kartlarım() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 580);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLimit = new JLabel("LİMİT: ");
		lblLimit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLimit.setForeground(Color.ORANGE);
		lblLimit.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLimit.setBounds(375, 67, 165, 21);
		contentPane.add(lblLimit);
		
		JLabel lblLimit_1 = new JLabel("");
		lblLimit_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		lblLimit_1.setBounds(550, 67, 165, 21);
		contentPane.add(lblLimit_1);
		lblLimit_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblLimit_1.setForeground(Color.WHITE);
		lblLimit_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblBor = new JLabel("BORÇ: ");
		lblBor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBor.setForeground(Color.ORANGE);
		lblBor.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblBor.setBounds(375, 112, 165, 21);
		contentPane.add(lblBor);
		
		JLabel lblBor_1 = new JLabel("");
		lblBor_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		lblBor_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblBor_1.setForeground(Color.WHITE);
		lblBor_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBor_1.setBounds(550, 112, 165, 21);
		contentPane.add(lblBor_1);
		
		JLabel lblNewLabel = new JLabel("KARTLARIM:(Kart No)");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 10, 237, 35);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 44, 355, 489);
		contentPane.add(scrollPane);
		
		JList list = new JList(new DefaultComboBoxModel(Main.müşteridatabase.get(MüşteriMenü.id).toArraykart()));
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					Long selectedkart=Long.parseLong(list.getSelectedValue().toString());
					Integer l=Main.kartdatabase.get(selectedkart).limit;
					Integer b=Main.kartdatabase.get(selectedkart).borc;
					lblLimit_1.setText(l.toString());
					lblBor_1.setText(b.toString());		
				}
			}
		});
		list.setForeground(Color.WHITE);
		list.setFont(new Font("Tahoma", Font.BOLD, 14));
		list.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.ORANGE));
		list.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(list);
		
		JLabel bilgiEkranı = new JLabel("");
		bilgiEkranı.setHorizontalAlignment(SwingConstants.CENTER);
		bilgiEkranı.setForeground(Color.ORANGE);
		bilgiEkranı.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bilgiEkranı.setBackground(Color.DARK_GRAY);
		bilgiEkranı.setBounds(421, 234, 180, 21);
		contentPane.add(bilgiEkranı);
		
		JLabel lblHesabSe = new JLabel("HESABI SEÇ: ");
		lblHesabSe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHesabSe.setForeground(Color.ORANGE);
		lblHesabSe.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHesabSe.setBounds(375, 162, 165, 21);
		contentPane.add(lblHesabSe);
		
		JComboBox Sec = new JComboBox();
		Sec.setFont(new Font("Tahoma", Font.BOLD, 13));
		Sec.setMaximumRowCount(5);
		Sec.setBounds(550, 164, 180, 21);
		Sec.setModel(new DefaultComboBoxModel(Main.müşteridatabase.get(MüşteriMenü.id).toArrayhesap()));
		contentPane.add(Sec);
		
		JButton borcuöde = new JButton("BORCU ÖDE");
		borcuöde.setFont(new Font("Tahoma", Font.BOLD, 13));
		borcuöde.setBounds(611, 234, 119, 21);
		contentPane.add(borcuöde);
		
		JLabel lblMiktar = new JLabel("MİKTAR: ");
		lblMiktar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMiktar.setForeground(Color.ORANGE);
		lblMiktar.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMiktar.setBounds(375, 200, 165, 21);
		contentPane.add(lblMiktar);
		
		miktar = new JTextField();
		miktar.setFont(new Font("Tahoma", Font.BOLD, 10));
		miktar.setBounds(550, 203, 180, 21);
		contentPane.add(miktar);
		miktar.setColumns(10);
		
		JButton btnNewButton = new JButton("GERİ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MüşteriMenü(MüşteriMenü.id);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(611, 478, 119, 35);
		contentPane.add(btnNewButton);
		
		JLabel yenikartbilgi = new JLabel("");
		yenikartbilgi.setHorizontalAlignment(SwingConstants.RIGHT);
		yenikartbilgi.setForeground(Color.ORANGE);
		yenikartbilgi.setFont(new Font("Tahoma", Font.BOLD, 13));
		yenikartbilgi.setBounds(493, 344, 237, 21);
		contentPane.add(yenikartbilgi);
		
		JButton btnNewButton_1 = new JButton("YENİ KART İSTE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.müşteridatabase.get(MüşteriMenü.id).kredikartıOnayı=true;
				yenikartbilgi.setText("İsteğiniz bankaya iletilmiştir ");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(550, 299, 180, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Limit Arttır");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String yenilimit=JOptionPane.showInputDialog("İstenilen limiti giriniz: ");
				Main.kartdatabase.get(Long.parseLong(list.getSelectedValue().toString())).istenenLimit=Integer.parseInt(yenilimit);
				JOptionPane.showMessageDialog(null, "Talebiniz alındı");
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_2.setBounds(725, 67, 85, 21);
		contentPane.add(btnNewButton_2);
				
		borcuöde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=Integer.parseInt(miktar.getText());
				int h=Integer.parseInt(Sec.getSelectedItem().toString());
				Long k=Long.parseLong(list.getSelectedValue().toString());
				if(Hesap.bakiye(h)-n>=0) {
				KrediKartı.yatır( k, n);
				bilgiEkranı.setText("Ödeme başarılı");
				}
			}});
	}
}
