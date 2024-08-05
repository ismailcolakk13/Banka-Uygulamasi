package org.eclipse.wb.swing;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import proje.Musteri;

public class YeniMüşteri extends JPanel {
	private static final long serialVersionUID = 1L;
	public YeniMüşteri() {
		JPanel panel = new JPanel(new GridLayout(2, 2));

        JTextField inputField1 = new JTextField();
        JTextField inputField2 = new JTextField();

        panel.add(new JLabel("Müşteri adı:"));
        panel.add(inputField1);
        panel.add(new JLabel("Müşteri soyadı:"));
        panel.add(inputField2);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Two Inputs", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String input1 = inputField1.getText();
            String input2 = inputField2.getText();
            new Musteri(input1,input2,"0000");
        }  
	}






	

}
