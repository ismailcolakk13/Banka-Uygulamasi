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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ParaGönder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField alıcıNo;
	private JTextField tutarNo;


	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ParaGönder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GÖNDEREN HESAP: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(142, 98, 222, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblAlcHesap = new JLabel("ALICI HESAP NO: ");
		lblAlcHesap.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlcHesap.setForeground(Color.ORANGE);
		lblAlcHesap.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAlcHesap.setBounds(142, 191, 222, 21);
		contentPane.add(lblAlcHesap);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(634, 101, 155, 21);
		contentPane.add(lblNewLabel_1);
		
		
		JComboBox sec = new JComboBox();
		sec.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Integer bak=Integer.parseInt(sec.getSelectedItem().toString());
				lblNewLabel_1.setText("Bakiye: "+Hesap.bakiye(bak));
			}
		});
		sec.setFont(new Font("Tahoma", Font.BOLD, 10));
		sec.setBounds(401, 101, 199, 21);
		sec.setModel(new DefaultComboBoxModel(Main.müşteridatabase.get(MüşteriMenü.id).toArrayhesap()));
		contentPane.add(sec);
		
		alıcıNo = new JTextField();
		alıcıNo.setFont(new Font("Tahoma", Font.BOLD, 10));
		alıcıNo.setColumns(10);
		alıcıNo.setBounds(401, 191, 199, 21);
		contentPane.add(alıcıNo);
		
		tutarNo = new JTextField();
		tutarNo.setFont(new Font("Tahoma", Font.BOLD, 10));
		tutarNo.setColumns(10);
		tutarNo.setBounds(401, 254, 199, 21);
		contentPane.add(tutarNo);
		
		JLabel lblTutar = new JLabel("TUTAR: ");
		lblTutar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTutar.setForeground(Color.ORANGE);
		lblTutar.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTutar.setBounds(142, 252, 222, 21);
		contentPane.add(lblTutar);
		
		JLabel bilgiEkranı = new JLabel("");
		bilgiEkranı.setHorizontalAlignment(SwingConstants.CENTER);
		bilgiEkranı.setForeground(Color.ORANGE);
		bilgiEkranı.setFont(new Font("Tahoma", Font.BOLD, 13));
		bilgiEkranı.setBounds(142, 313, 419, 45);
		contentPane.add(bilgiEkranı);
		
		JButton göndertusu = new JButton("GÖNDER");
		göndertusu.setFont(new Font("Tahoma", Font.BOLD, 17));
		göndertusu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int g=Integer.parseInt(sec.getSelectedItem().toString());
				int a=Integer.parseInt(alıcıNo.getText());
				int t=Integer.parseInt(tutarNo.getText());
				try {
				if(Main.hesapdatabase.get(g).doviztipi==Main.hesapdatabase.get(a).doviztipi&&Hesap.bakiye(g)>=t) {
					Hesap.hesabaGonder(g, a, t);
					bilgiEkranı.setText(g+" nolu hesaptan "+a+" nolu hesaba "+t+" miktarında para gönderildi");
				}
				else {
					bilgiEkranı.setText("Yetersiz bakiye ya da farklı döviz türünden hesaba aktarım denediğiniz için işlem yapılamadı");
				}
				}catch(NullPointerException z) {
					bilgiEkranı.setText("Alıcı veya gönderici hesap numaraları hatalı");
				}
			}
		});
		göndertusu.setBounds(574, 313, 155, 45);
		contentPane.add(göndertusu);
		
		JButton btnNewButton = new JButton("GERİ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MüşteriMenü(MüşteriMenü.id);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(574, 401, 155, 45);
		contentPane.add(btnNewButton);
		


		

	}
}
