package Mini_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.*;

public class Temperature extends JFrame implements ActionListener {

    JLabel title;
    JTextField givenTemperature, convertTemperature;
    JComboBox combobox1, combobox2;

    String[] Temp1 = {"select", "Celsius", "Fahrenheit", "Kelvin"};
    String[] Temp2 = {"Celsius", "Fahrenheit", "Kelvin"};

    JButton buttonClear, buttonConvert, buttonBack;

    Temperature() {

        title = new JLabel("Temperature Converter Calculator");
        title.setBounds(30, 20, 400, 20);
        title.setForeground(Color.white);
        title.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(title);

        givenTemperature = new JTextField();
        givenTemperature.setBounds(50, 70, 120, 25);
        givenTemperature.setBackground(Color.white);
        add(givenTemperature);

        convertTemperature = new JTextField();
        convertTemperature.setBounds(50, 120, 120, 25);
        convertTemperature.setBackground(Color.white);
        add(convertTemperature);
        combobox1 = new JComboBox(Temp1);
        combobox1.setBounds(210, 70, 80, 25);
        combobox1.setFont(new Font("Arial", Font.BOLD, 11));
        combobox1.setBackground(Color.white);
        combobox1.setForeground(Color.black);
        add(combobox1);
        combobox2 = new JComboBox(Temp2);
        combobox2.setBounds(210, 120, 80, 25);
        combobox2.setFont(new Font("Arial", Font.BOLD, 11));
        combobox2.setBackground(Color.white);
        combobox2.setForeground(Color.black);
        add(combobox2);
        buttonConvert = new JButton("convert");
        buttonConvert.setBounds(180, 180, 80, 28);
        buttonConvert.setBackground(Color.GREEN);
        buttonConvert.setForeground(Color.black);
        buttonConvert.addActionListener(this);
        add(buttonConvert);
        buttonClear = new JButton("clear");
        buttonClear.setBounds(80, 180, 80, 28);
        buttonClear.setBackground(Color.red);
        buttonClear.setForeground(Color.black);
        buttonClear.addActionListener(this);
        add(buttonClear);
        buttonBack = new JButton("back");
        buttonBack.setBounds(130, 220, 80, 28);
        buttonBack.setBackground(Color.black);
        buttonBack.setForeground(Color.white);
        buttonBack.addActionListener(this);
        add(buttonBack);

        givenTemperature.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent ke) {

                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyChar() == '-' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    givenTemperature.setEditable(true);

                } else {
                    givenTemperature.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Enter only numeric digits");

                }
            }
        });

        getContentPane().setBackground(Color.darkGray);

        setBounds(100, 200, 370, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonClear) {

            givenTemperature.setText("");
            convertTemperature.setText("");

        } else if ((e.getSource() == buttonConvert)) {
            String box1 = (String) combobox1.getSelectedItem();
            String box2 = (String) combobox2.getSelectedItem();
            if (box1.equals("select")) {
                JOptionPane.showMessageDialog(null, "Please Give a value and Select Celsius or Fahrenheit or Kelvin");
            }

            if ((box1.equals("Celsius")) && (box2.equals("Celsius"))) {
                String str1 = givenTemperature.getText();
                convertTemperature.setText("" + str1);
            }
            if ((box1.equals("Fahrenheit")) && (box2.equals("Fahrenheit"))) {
                String str1 = givenTemperature.getText();
                convertTemperature.setText("" + str1);
            }
            if ((box1.equals("Kelvin")) && (box2.equals("kelvin"))) {
                String str1 = givenTemperature.getText();
                convertTemperature.setText("" + str1);
            }
            if ((box1.equals("Celsius")) && (box2.equals("Fahrenheit"))) {

                String str1 = givenTemperature.getText();
                DecimalFormat ob = new DecimalFormat("0.00");
                double c = Double.parseDouble(str1);
                double f = (double) (((9 * c) / 5) + 32);
                convertTemperature.setText("" + ob.format(f));
                convertTemperature.setEditable(false);
            }
            if ((box1.equals("Celsius")) && (box2.equals("Kelvin"))) {

                String str1 = givenTemperature.getText();
                DecimalFormat ob = new DecimalFormat("0.00");
                double c = Double.parseDouble(str1);
                double k = (double) (c + 273.15);
                convertTemperature.setText("" + ob.format(k));
                convertTemperature.setEditable(false);
            }

            if ((box1.equals("Fahrenheit")) && (box2.equals("Celsius"))) {

                String str1 = givenTemperature.getText();
                DecimalFormat ob = new DecimalFormat("0.00");
                double f = Double.parseDouble(str1);
                double c = (double) ((f - 32) * 5 / 9);
                convertTemperature.setText("" + ob.format(c));
                convertTemperature.setEditable(false);
            }
            if ((box1.equals("Fahrenheit")) && (box2.equals("Kelvin"))) {
                String str1 = givenTemperature.getText();
                DecimalFormat ob = new DecimalFormat("0.00");
                double f = Double.parseDouble(str1);
                double k = (double) (273.5 + ((f - 32.0) * (5.0 / 9.0)));
                convertTemperature.setText("" + ob.format(k));
                convertTemperature.setEditable(false);
            }

            if ((box1.equals("Kelvin")) && (box2.equals("Celsius"))) {
                String str1 = givenTemperature.getText();
                DecimalFormat ob = new DecimalFormat("0.00");
                double k = Double.parseDouble(str1);
                double c = (double) (k - 273.15);
                convertTemperature.setText("" + ob.format(c));
                convertTemperature.setEditable(false);
            }

            if ((box1.equals("Kelvin")) && (box2.equals("Fahrenheit"))) {
                String str1 = givenTemperature.getText();
                DecimalFormat ob = new DecimalFormat("0.00");
                double k = Double.parseDouble(str1);
                double f = (double) (k - 273.15) * 9 / 5 + 32;
                convertTemperature.setText("" + ob.format(f));
                convertTemperature.setEditable(false);
            }
        } else if (e.getSource() == buttonBack) {
            new Main_Calculator().setVisible(true);
            this.setVisible(false);

        }

    }

}
