package Mini_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.*;

public class BMR extends JFrame implements ActionListener {

    JComboBox combox;
    JLabel title, label1, label2, label3, label4, label5, labelyear, labelkg, labelcm, labelCalorie;
    String[] BMR = {"select", "Female", "Male"};
    JTextField ageTextfield, weightTextfield, heightTextfield, bmrTextfield;
    JButton submit, clear, back;
    //String s4;

    BMR() {

        combox = new JComboBox(BMR);
        combox.setBounds(70, 52, 80, 25);

        combox.setFont(new Font("Arial", Font.BOLD, 11));
        combox.setBackground(Color.WHITE);
        combox.setForeground(Color.BLACK);
        add(combox);

        title = new JLabel("BMR Calculator");
        title.setBounds(115, 10, 130, 30);
        title.setForeground(Color.white);
        title.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(title);
        label1 = new JLabel("Age:");
        label1.setBounds(70, 90, 80, 20);
        label1.setForeground(Color.white);
        add(label1);
        ageTextfield = new JTextField();
        ageTextfield.setBounds(180, 90, 80, 20);
        ageTextfield.setBackground(Color.white);

        labelyear = new JLabel("year");
        labelyear.setBounds(265, 90, 25, 20);
        labelyear.setForeground(Color.white);
        add(labelyear);

        add(ageTextfield);

        ageTextfield.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent ke) {

                ageTextfield.setEditable(true);
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                } else {
                    ageTextfield.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Enter only numeric digits");

                }
            }
        });

        label2 = new JLabel("Weight:");
        label2.setBounds(70, 125, 80, 20);
        label2.setForeground(Color.white);
        add(label2);

        weightTextfield = new JTextField();
        weightTextfield.setBounds(180, 125, 80, 20);
        weightTextfield.setBackground(Color.white);
        add(weightTextfield);
        labelkg = new JLabel("kg");
        labelkg.setBounds(265, 125, 20, 20);
        labelkg.setForeground(Color.white);
        add(labelkg);

        weightTextfield.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent ke) {

                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    weightTextfield.setEditable(true);

                } else {
                    weightTextfield.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Enter only numeric digits");

                }
            }
        });

        label3 = new JLabel("Height:");
        label3.setBounds(70, 160, 80, 20);
        label3.setForeground(Color.white);
        add(label3);
        heightTextfield = new JTextField();
        heightTextfield.setBounds(180, 160, 80, 20);
        heightTextfield.setBackground(Color.white);
        add(heightTextfield);

        labelcm = new JLabel("cm");
        labelcm.setBounds(265, 160, 40, 20);
        labelcm.setForeground(Color.white);
        add(labelcm);

        heightTextfield.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent ke) {

                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    heightTextfield.setEditable(true);

                } else {
                    heightTextfield.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Enter only numeric digits");

                }
            }
        });
        label4 = new JLabel("Your BMR:");
        label4.setBounds(70, 240, 80, 20);
        label4.setForeground(Color.white);
        add(label4);

        labelCalorie = new JLabel("Cal");
        labelCalorie.setBounds(265, 240, 20, 20);
        labelCalorie.setForeground(Color.white);
        add(labelCalorie);
        bmrTextfield = new JTextField();
        bmrTextfield.setBounds(180, 240, 80, 20);
        bmrTextfield.setBackground(Color.white);

        add(bmrTextfield);
        submit = new JButton("result");
        submit.setBounds(70, 195, 80, 25);
        submit.setBackground(Color.green);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);
        clear = new JButton("clear");
        clear.setBounds(180, 195, 80, 25);
        clear.setBackground(Color.red);
        clear.setForeground(Color.black);
        clear.addActionListener(this);
        add(clear);

        back = new JButton("Back");
        back.setBounds(130, 280, 80, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.darkGray);

        setBounds(100, 200, 370, 365);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clear) {

            ageTextfield.setText("");
            weightTextfield.setText("");
            heightTextfield.setText("");
            bmrTextfield.setText("");

        } else if (e.getSource() == back) {
            new Main_Calculator().setVisible(true);
            this.setVisible(false);

        } else if (e.getSource() == submit) {

            String box = combox.getSelectedItem().toString();

            if (box.equals("select")) {
                JOptionPane.showMessageDialog(null, "Please Select Male or Female");
            }

            if (box.equals("Male")) {
                if (ageTextfield.getText().equals("") || weightTextfield.getText().equals("") || heightTextfield.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "All the fields are required");

                } else {
                    float age = Float.parseFloat(ageTextfield.getText());
                    float weight = Float.parseFloat(weightTextfield.getText());
                    float height = Float.parseFloat(heightTextfield.getText());
                    DecimalFormat ob = new DecimalFormat("0.00");
                    double m = 66.47 + (weight * 13.75) + (height * 5.003) - (age * 6.755);

                    // System.out.println("%.3lf"+m);
                    bmrTextfield.setText(" " + ob.format(m));
                    bmrTextfield.setEditable(false);
                }

            }
            if (box.equals("Female")) {

                if (ageTextfield.getText().equals("") || weightTextfield.getText().equals("") || heightTextfield.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "All the fields are required");

                } else {
                    float age = Float.parseFloat(ageTextfield.getText());
                    float weight = Float.parseFloat(weightTextfield.getText());
                    float height = Float.parseFloat(heightTextfield.getText());
                    DecimalFormat ob = new DecimalFormat("0.00");
                    double m = 655.1 + (weight * 9.563) + (height * 1.85) - (age * 4.676);
                    bmrTextfield.setText("" + ob.format(m));
                    bmrTextfield.setEditable(false);

                    //float age = Float.parseFloat(textfield1.getText());
                }
                //tf4.setText(String.valueOf(m));
            }

        }

    }

}
