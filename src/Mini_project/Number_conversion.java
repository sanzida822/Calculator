package Mini_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Number_conversion extends JFrame implements ActionListener {

    JLabel title, labelDecimal, labelBinary, labelOctal, labelHexa;
    JTextField textfieldDecimal, textfieldBinary, textfieldOctal, textfieldHexa;
    JButton buttonConvert, buttonClear, buttonBack;
    JComboBox combo;
    String[] select = {"Select", "Binary", "Decimal", "Octal", "Hexa"};

    Number_conversion() {

        combo = new JComboBox(select);
        combo.setBounds(60, 55, 100, 23);
        combo.setBackground(Color.white);
        combo.setForeground(Color.black);
        add(combo);

        title = new JLabel("Number Conversion Calculator");
        title.setBounds(45, 10, 250, 30);
        title.setForeground(Color.white);
        title.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(title);
        labelDecimal = new JLabel("Decimal:");
        labelDecimal.setBounds(60, 110, 80, 20);
        labelDecimal.setForeground(Color.white);
        add(labelDecimal);
        textfieldDecimal = new JTextField();
        textfieldDecimal.setBounds(160, 110, 120, 20);
        textfieldDecimal.setBackground(Color.white);
        textfieldDecimal.setForeground(new Color(0, 0, 0));
        add(textfieldDecimal);

        textfieldDecimal.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent ke) {

                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    textfieldDecimal.setEditable(true);

                } else {
                    textfieldDecimal.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Enter only numeric digits");

                }
            }
        });

        labelBinary = new JLabel("Binary:");
        labelBinary.setBounds(60, 145, 800, 20);
        labelBinary.setForeground(Color.white);
        add(labelBinary);
        textfieldBinary = new JTextField();
        textfieldBinary.setBounds(160, 145, 120, 20);
        textfieldBinary.setBackground(Color.white);
        add(textfieldBinary);

        textfieldBinary.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent ke) {

                if (ke.getKeyChar() == '0' || ke.getKeyChar() == '1' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    textfieldBinary.setEditable(true);

                } else {
                    textfieldBinary.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Enter only 0 and 1");

                }
            }
        });

        labelOctal = new JLabel("Octal:");
        labelOctal.setBounds(60, 180, 80, 20);
        labelOctal.setForeground(Color.white);
        add(labelOctal);
        textfieldOctal = new JTextField();
        textfieldOctal.setBounds(160, 180, 120, 20);
        textfieldOctal.setBackground(Color.white);
        add(textfieldOctal);

        textfieldOctal.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent ke) {

                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    textfieldOctal.setEditable(true);

                } else {
                    textfieldOctal.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Enter only numeric digits");

                }
            }
        });
        labelHexa = new JLabel("Hexa:");
        labelHexa.setBounds(60, 215, 80, 20);
        labelHexa.setForeground(Color.white);
        add(labelHexa);
        textfieldHexa = new JTextField();
        textfieldHexa.setBounds(160, 215, 120, 20);
        textfieldHexa.setBackground(Color.white);
        add(textfieldHexa);

        textfieldHexa.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent ke) {

                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == 'a' || ke.getKeyChar() == 'b' || ke.getKeyChar() == 'c' || ke.getKeyChar() == 'd' || ke.getKeyChar() == 'e' || ke.getKeyChar() == 'f' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    textfieldHexa.setEditable(true);

                } else {
                    textfieldHexa.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Enter Hexadecimal value"
                            + "");

                }
            }
        });
        buttonConvert = new JButton("convert");
        buttonConvert.setBounds(85, 260, 80, 28);
        buttonConvert.setBackground(Color.GREEN);
        buttonConvert.setForeground(Color.black);
        buttonConvert.addActionListener(this);
        add(buttonConvert);
        buttonClear = new JButton("clear");
        buttonClear.setBackground(Color.red);
        buttonClear.setBounds(185, 260, 80, 28);
        buttonClear.setForeground(Color.black);
        buttonClear.addActionListener(this);
        add(buttonClear);
        buttonBack = new JButton("back");
        buttonBack.setBackground(Color.black);
        buttonBack.setForeground(Color.white);
        buttonBack.setBounds(135, 297, 80, 28);
        buttonBack.addActionListener(this);
        add(buttonBack);

        getContentPane().setBackground(Color.DARK_GRAY);

        setBounds(100, 200, 370, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonClear) {
            textfieldDecimal.setText("");
            textfieldBinary.setText("");
            textfieldOctal.setText("");
            textfieldHexa.setText("");

        } else if (e.getSource() == buttonConvert) {

            String box = (String) combo.getSelectedItem();
            if (box.equals("Select")) {
                JOptionPane.showMessageDialog(null, "Please Select that number that you wanted to convert");
            }

            if (box.equals("Decimal")) {
                //textfield2.setEditable(false);

                String str = textfieldDecimal.getText();

                int i = Integer.parseInt(str);
                String str1 = Integer.toBinaryString(i);
                textfieldBinary.setText("" + str1);
                textfieldBinary.setEditable(false);

                // str2 = textfield.getText();
                int k = Integer.parseInt(str);
                String str2 = Integer.toHexString(k);
                textfieldHexa.setText("" + str2);
                textfieldHexa.setEditable(false);

                //String str3 = textField.getText();
                int j = Integer.parseInt(str);
                String str3 = Integer.toOctalString(j);
                textfieldOctal.setText("" + str3);
                textfieldOctal.setEditable(false);

            }

            if (box.equals("Binary")) {

                String str1 = textfieldBinary.getText();

                int i = Integer.parseInt(str1, 2);
                textfieldDecimal.setText("" + i);
                //textfield1.setEditable(false);

                // str2 = textfield.getText();
                // int j = Integer.parseInt(str1);
                String str2 = Integer.toHexString(i);
                textfieldHexa.setText("" + str2);
                textfieldHexa.setEditable(false);

                //String str3 = textField.getText();
                //  int   k= Integer.parseInt(str1);
                String str3 = Integer.toOctalString(i);
                textfieldOctal.setText("" + str3);
                textfieldOctal.setEditable(false);

            }

            if (box.equals("Octal")) {

                String str3 = textfieldOctal.getText();

                int i = Integer.parseInt(str3, 8);
                textfieldDecimal.setText("" + i);
                // textfield1.setEditable(false);

                String str1 = Integer.toBinaryString(i);
                textfieldBinary.setText("" + str1);
                textfieldBinary.setEditable(false);

                // str2 = textfield.getText();
                // int j = Integer.parseInt(str1);
                String str2 = Integer.toHexString(i);
                textfieldHexa.setText("" + str2);
                // textfield4.setEditable(false);

                //String str3 = textField.getText();
                //  int   k= Integer.parseInt(str1);
            }

            if (box.equals("Hexa")) {

                String str2 = textfieldHexa.getText();

                int i = Integer.parseInt(str2, 16);
                textfieldDecimal.setText("" + i);
                // textfield1.setEditable(false);

                String str1 = Integer.toBinaryString(i);
                textfieldBinary.setText("" + str1);
                // textfield2.setEditable(false);

                String str3 = Integer.toOctalString(i);
                textfieldOctal.setText("" + str3);
                // textfield3.setEditable(false);

            }

        } else if (e.getSource() == buttonBack) {
            new Main_Calculator().setVisible(true);
            this.setVisible(false);

        }

    }

}
