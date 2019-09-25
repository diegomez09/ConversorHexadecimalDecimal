/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorhexadecimaldecimal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author carlosguso
 */
public class ConversorHexadecimalDecimal extends JFrame implements ActionListener {
    JTextField txt1;
    JButton btn1;
    JLabel lbl1;
    
    
    private int decimal;
    private String hex;
    
    public ConversorHexadecimalDecimal() {
        this.setBounds(100, 100, 400, 400);
        this.setLayout(null);
        this.setResizable(false);
        
        lbl1 = new JLabel();
        lbl1.setOpaque(true);
        lbl1.setBounds(30, 30, 340, 20);
        lbl1.setBackground(Color.WHITE);
        lbl1.setName("lbl1");
        lbl1.setText("0");
        lbl1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        lbl1.setHorizontalAlignment(JLabel.RIGHT);
        this.add(lbl1);

        txt1 = new JTextField();
        txt1.setBounds(30, 60, 60, 20);
        txt1.setName("txt1");
        txt1.setText("");
        txt1.setHorizontalAlignment(JTextField.CENTER);
        this.add(txt1);

        btn1 = new JButton();
        btn1.setBounds(30, 150, 60, 20);
        btn1.setName("btn1");
        btn1.setText("Calcular");
        btn1.addActionListener(this);
        this.add(btn1);

        this.setVisible(true);
        lbl1.setVisible(true);
        txt1.setVisible(true);
        btn1.setVisible(true);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ConversorHexadecimalDecimal C = new ConversorHexadecimalDecimal();
    }
    
    public void setDecimal(int n) {
        this.decimal = n;
    }

    public void setHex(String n) {
        this.hex = n;
    }

    public int getDecimal() {
        return this.decimal;
    }

    public String getHex() {
        return this.hex;
    }

    public int obtenerNumero(Character n) {
        int c;
        switch (n) {
            case 'A':
            case 'a':
                c = 10;
                break;

            case 'B':
            case 'b':
                c = 11;
                break;

            case 'C':
            case 'c':
                c = 12;
                break;

            case 'D':
            case 'd':
                c = 13;
                break;

            case 'E':
            case 'e':
                c = 14;
                break;

            case 'F':
            case 'f':
                c = 15;
                break;
        
            default:
                c = Integer.parseInt(String.valueOf(n));
                //System.out.println(c);
                break;
        }
        return c;
    }

    public void convertir() {
       String s = this.getHex();
       int j, dec = 0, index = s.length()-1;
       for(int i = 0; i < s.length(); i++) {
          j = this.obtenerNumero(s.charAt(i));
          //System.out.println("Numero base: " + j);
          j *= (Math.pow(16,index)); 
          //System.out.println("Numero multiplicado: " + j);
          dec += j;
          //System.out.println("Numero acumulado: " + dec);
          --index;
       }
       this.setDecimal(dec);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn1) {
            this.setHex(txt1.getText());
            this.convertir();
            lbl1.setText(Integer.toString(this.getDecimal()));
        }
    }
    
}
