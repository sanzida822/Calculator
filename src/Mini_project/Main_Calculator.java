package Mini_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Main_Calculator extends JFrame implements ActionListener {

    JButton onRadioButton, buttonDot, buttonDelete, buttonClear, buttonZero,
            offRadioButton, buttonSeven, buttonEight, buttonNine,
            buttonFive, buttonSix, buttonThree, buttonOne, buttonEnergy,
            buttonTwo, buttonFour, buttonEqual, buttonDiv, buttonHexa, buttonMul,
            buttonConversion, buttonPlus, buttonMinus, buttonOctal, buttonBMR, buttonTemp, buttonSnake;
    ButtonGroup buttonGroup;
    JLabel label;
    static double a = 0, b = 0, count = 0, result = 0, i;
    static int operator;
    JTextField textField;

    Main_Calculator() {

        label = new JLabel("");
        label.setBounds(250, 0, 80, 50);
        label.setForeground(Color.white);
        add(label);

        textField = new JTextField();
        textField.setBounds(10, 40, 270, 40);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        add(textField);
        textField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent ke) {

                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyChar() == '-' || ke.getKeyChar() == '+' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    textField.setEditable(true);

                } else {
                    textField.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Enter only numeric digits");

                }
            }
        });
        onRadioButton = new JButton("On");
        onRadioButton.setBounds(10, 90, 60, 36);
        onRadioButton.setSelected(true);
        onRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        onRadioButton.setBackground(Color.green);
        onRadioButton.setForeground(Color.white);
        onRadioButton.addActionListener(this);
        add(onRadioButton);

        offRadioButton = new JButton("Off");
        offRadioButton.setBounds(10, 120, 60, 36);
        offRadioButton.setSelected(false);
        offRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        offRadioButton.setBackground(Color.red);
        offRadioButton.setForeground(Color.white);
        offRadioButton.addActionListener(this);

        add(offRadioButton);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(onRadioButton);
        buttonGroup.add(offRadioButton);

        buttonSeven = new JButton("7");
        buttonSeven.setBounds(10, 230, 60, 40);
        buttonSeven.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSeven.addActionListener(this);
        add(buttonSeven);

        buttonEight = new JButton("8");
        buttonEight.setBounds(80, 230, 60, 40);
        buttonEight.setFont(new Font("Arial", Font.BOLD, 20));
        buttonEight.addActionListener(this);
        add(buttonEight);

        buttonNine = new JButton("9");
        buttonNine.setBounds(150, 230, 60, 40);
        buttonNine.setFont(new Font("Arial", Font.BOLD, 20));
        buttonNine.addActionListener(this);
        add(buttonNine);

        buttonFour = new JButton("4");
        buttonFour.setBounds(10, 290, 60, 40);
        buttonFour.setFont(new Font("Arial", Font.BOLD, 20));
        buttonFour.addActionListener(this);
        add(buttonFour);

        buttonFive = new JButton("5");
        buttonFive.setBounds(80, 290, 60, 40);
        buttonFive.setFont(new Font("Arial", Font.BOLD, 20));
        buttonFive.addActionListener(this);
        add(buttonFive);

        buttonSix = new JButton("6");
        buttonSix.setBounds(150, 290, 60, 40);
        buttonSix.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSix.addActionListener(this);
        add(buttonSix);

        buttonOne = new JButton("1");
        buttonOne.setBounds(10, 350, 60, 40);
        buttonOne.setFont(new Font("Arial", Font.BOLD, 20));
        buttonOne.addActionListener(this);
        add(buttonOne);

        buttonTwo = new JButton("2");
        buttonTwo.setBounds(80, 350, 60, 40);
        buttonTwo.setFont(new Font("Arial", Font.BOLD, 20));
        buttonTwo.addActionListener(this);
        add(buttonTwo);

        buttonThree = new JButton("3");
        buttonThree.setBounds(150, 350, 60, 40);
        buttonThree.setFont(new Font("Arial", Font.BOLD, 20));
        buttonThree.addActionListener(this);
        add(buttonThree);

        buttonDot = new JButton(".");
        buttonDot.setBounds(220, 350, 60, 40);
        buttonDot.setBackground(Color.yellow);
        buttonDot.addActionListener(this);
        add(buttonDot);

        buttonZero = new JButton("0");
        buttonZero.setBounds(10, 410, 60, 40);
        buttonZero.setFont(new Font("Arial", Font.BOLD, 20));
        buttonZero.addActionListener(this);
        add(buttonZero);

        buttonTemp = new JButton("Tem");
        buttonTemp.setBounds(80, 410, 60, 40);
        buttonTemp.setFont(new Font("Arial", Font.BOLD, 12));
        buttonTemp.addActionListener(this);
        add(buttonTemp);

        buttonEqual = new JButton("=");
        buttonEqual.setBounds(220, 410, 60, 40);
        buttonEqual.setFont(new Font("Arial", Font.BOLD, 20));
        buttonEqual.setBackground(Color.yellow);
        buttonEqual.addActionListener(this);
        //buttonEqual.setBackground(new Color(239, 188, 2));
        add(buttonEqual);

        buttonDiv = new JButton("/");
        buttonDiv.setBounds(220, 110, 60, 40);
        buttonDiv.setFont(new Font("Arial", Font.BOLD, 20));
        //buttonDiv.setBackground(new Color(239, 188, 2));
        buttonDiv.setBackground(Color.yellow);
        buttonDiv.addActionListener(this);
        add(buttonDiv);

        buttonConversion = new JButton("Conversion");
        buttonConversion.setBounds(10, 170, 131, 40);
        buttonConversion.setFont(new Font("Arial", Font.BOLD, 14));
        buttonConversion.addActionListener(this);
        add(buttonConversion);

        ImageIcon snake = new ImageIcon(ClassLoader.getSystemResource("image/snake2.jpg"));
        Image im = snake.getImage().getScaledInstance(60, 40, Image.SCALE_DEFAULT);
        ImageIcon im2 = new ImageIcon(im);
        buttonSnake = new JButton(im2);
        buttonSnake.setBounds(150, 170, 60, 40);
        buttonSnake.setFont(new Font("Arial", Font.BOLD, 15));
        buttonSnake.addActionListener(this);
        add(buttonSnake);

        buttonMul = new JButton("X");
        buttonMul.setBounds(220, 230, 60, 40);
        buttonMul.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMul.setBackground(Color.yellow);
        buttonMul.addActionListener(this);
        //buttonMul.setBackground(new Color(239, 188, 2));
        add(buttonMul);

        buttonMinus = new JButton("-");
        buttonMinus.setBounds(220, 170, 60, 40);
        buttonMinus.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMinus.setBackground(Color.yellow);
        buttonMinus.addActionListener(this);
        // buttonMinus.setBackground(new Color(239, 188, 2));
        add(buttonMinus);

        buttonPlus = new JButton("+");
        buttonPlus.setBounds(220, 290, 60, 40);
        buttonPlus.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPlus.setBackground(Color.yellow);
        buttonPlus.addActionListener(this);
        // buttonPlus.setBackground(new Color(239, 188, 2));
        add(buttonPlus);

        buttonDelete = new JButton("Del");
        buttonDelete.setBounds(150, 110, 60, 40);
        buttonDelete.setFont(new Font("Arial", Font.BOLD, 11));
        buttonDelete.setBackground(Color.red);
        buttonDelete.setForeground(Color.white);
        buttonDelete.addActionListener(this);
        add(buttonDelete);

        buttonClear = new JButton("Clr");
        buttonClear.setBounds(80, 110, 60, 40);
        buttonClear.setFont(new Font("Arial", Font.BOLD, 11));
        buttonClear.setBackground(Color.red);
        buttonClear.setForeground(Color.white);
        buttonClear.addActionListener(this);
        add(buttonClear);

        buttonBMR = new JButton("BMR");
        buttonBMR.setBounds(150, 410, 60, 40);
        buttonBMR.setFont(new Font("Arial", Font.BOLD, 11));
        buttonBMR.addActionListener(this);
        add(buttonBMR);

        getContentPane().setBackground(Color.black);

        setBounds(100, 200, 295, 495);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("Calculator Design");

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == onRadioButton) {
            textField.setText("");
            label.setText("");
            enable();
        } else if (e.getSource() == offRadioButton) {

            disable();
        } else if (e.getSource() == buttonClear) {
            label.setText("");
            textField.setText("");

        } else if (e.getSource() == buttonDelete) {

            String s = textField.getText();
            textField.setText("");
            for (int i = 0; i < s.length() - 1; i++) {
                textField.setText(textField.getText() + s.charAt(i));
            }
        } //int length = textField.getText().length();
        //int number = length - 1;
        /* if (length > 0) {
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(number);
                textField.setText(back.toString());
 
            }
            if (textField.getText().endsWith("")) {
               label.setText("");
             
        }*/ // }
        else if (e.getSource() == buttonZero) {
            if (textField.getText().equals("0")) {
                //return;
            } else {
                textField.setText(textField.getText() + "0");
            }
        } else if (e.getSource() == buttonOne) {
            textField.setText(textField.getText() + "1");
        } else if (e.getSource() == buttonTwo) {
            textField.setText(textField.getText() + "2");
        } else if (e.getSource() == buttonThree) {
            textField.setText(textField.getText() + "3");
        } else if (e.getSource() == buttonFour) {
            textField.setText(textField.getText() + "4");
        } else if (e.getSource() == buttonFive) {
            textField.setText(textField.getText() + "5");
        } else if (e.getSource() == buttonSix) {
            textField.setText(textField.getText() + "6");
        } else if (e.getSource() == buttonSeven) {
            textField.setText(textField.getText() + "7");
        } else if (e.getSource() == buttonEight) {
            textField.setText(textField.getText() + "8");
        } else if (e.getSource() == buttonNine) {
            textField.setText(textField.getText() + "9");
        } else if (e.getSource() == buttonDot) {
            if (textField.getText().contains(".")) {
                return;
            } else {
                textField.setText(textField.getText() + ".");
            }
        }

        if (e.getSource() == buttonPlus) {
            if (textField.getText().isEmpty()) {
                textField.setText("+");
            } else {
                String str = textField.getText();
                a = Double.parseDouble(textField.getText());
                operator = 1;
                textField.setText("");

                label.setText(str + "+");
            }
        }
        if (e.getSource() == buttonMinus) {

            if (textField.getText().isEmpty()) {
                textField.setText("-");
            } else {
                String str = textField.getText();
                a = Double.parseDouble(textField.getText());
                operator = 2;
                textField.setText("");
                label.setText(str + "-");

            }
        }

        if (e.getSource() == buttonMul) {
            if (textField.getText().isEmpty()) {
                textField.setText("Syntax Error");
            } else {
                String str = textField.getText();
                a = Double.parseDouble(textField.getText());
                operator = 3;
                textField.setText("");
                label.setText(str + "X");
            }
        }
        if (e.getSource() == buttonDiv) {
            if (textField.getText().isEmpty()) {
                textField.setText("Syntax Error");
            } else {
                String str = textField.getText();
                a = Double.parseDouble(textField.getText());
                operator = 4;
                textField.setText("");
                label.setText(str + "/");
            }
        } else if (e.getSource() == buttonEqual) {
            if (textField.getText().isEmpty()) {
                textField.setText("0.0");
            }
            if (label.getText().isEmpty()) {
                result = Double.parseDouble(textField.getText());

            } else {
                b = Double.parseDouble(textField.getText());
                switch (operator) {
                    case 1:
                        result = a + b;
                        textField.setText("");
                        label.setText("");
                        break;

                    case 2:
                        result = a - b;
                        textField.setText("");
                        label.setText("");
                        break;

                    case 3:
                        result = a * b;
                        textField.setText("");
                        label.setText("");
                        break;

                    case 4:
                        result = a / b;
                        textField.setText("");
                        label.setText("");
                        break;

                    default:

                        result = 0;

                }

            }
            textField.setText("" + result);
        } else if (e.getSource() == buttonConversion) {
            new Number_conversion().setVisible(true);
            this.setVisible(false);

        } else if (e.getSource() == buttonTemp) {
            new Temperature().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == buttonBMR) {
            new BMR().setVisible(true);
            this.setVisible(false);

        } else if (e.getSource() == buttonSnake) {
            new Snake().setVisible(true);

        }

    }

    @Override
    public void enable() {
        label.setText("");
        onRadioButton.setEnabled(true);
        offRadioButton.setEnabled(true);
        textField.setEnabled(true);
        label.setEnabled(true);
        buttonClear.setEnabled(true);
        buttonDelete.setEnabled(true);
        buttonDiv.setEnabled(true);

        buttonMinus.setEnabled(true);
        buttonSeven.setEnabled(true);
        buttonEight.setEnabled(true);
        buttonNine.setEnabled(true);
        buttonMul.setEnabled(true);
        buttonFour.setEnabled(true);
        buttonFive.setEnabled(true);
        buttonSix.setEnabled(true);
        buttonPlus.setEnabled(true);
        buttonOne.setEnabled(true);
        buttonTwo.setEnabled(true);
        buttonThree.setEnabled(true);
        buttonEqual.setEnabled(true);
        buttonZero.setEnabled(true);
        buttonDot.setEnabled(true);
        buttonTemp.setEnabled(true);
        buttonBMR.setEnabled(true);

        buttonConversion.setEnabled(true);

    }

    @Override
    public void disable() {

        onRadioButton.setEnabled(true);

        buttonConversion.setEnabled(false);
        offRadioButton.setEnabled(false);
        textField.setText("");
        label.setText(" ");
        buttonClear.setEnabled(false);
        buttonDelete.setEnabled(false);
        buttonDiv.setEnabled(false);

        buttonMinus.setEnabled(false);
        buttonSeven.setEnabled(false);
        buttonEight.setEnabled(false);
        buttonNine.setEnabled(false);
        buttonMul.setEnabled(false);
        buttonFour.setEnabled(false);
        buttonFive.setEnabled(false);
        buttonSix.setEnabled(false);
        buttonPlus.setEnabled(false);
        buttonOne.setEnabled(false);
        buttonTwo.setEnabled(false);
        buttonThree.setEnabled(false);
        buttonEqual.setEnabled(false);
        buttonZero.setEnabled(false);
        buttonDot.setEnabled(false);
        buttonTemp.setEnabled(false);
        buttonBMR.setEnabled(false);
    }

    public static void main(String[] args) {

        new Main_Calculator();

    }
}
