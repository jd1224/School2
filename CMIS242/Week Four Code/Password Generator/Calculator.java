import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{

        GridLayout layout = new GridLayout(6, 1);

        JLabel label1= new JLabel("Enter Number 1:");

        JLabel label2 = new JLabel("Enter Number 2:");

        JLabel label3 = new JLabel("Answer is:");

        JTextField text1 = new JTextField(30);

        JTextField text2 = new JTextField(30);

        JTextField text3 = new JTextField(30);

        JButton add_btn = new JButton("+");

        JButton sub_btn = new JButton("-");

        JButton mul_btn = new JButton("*");

        JButton div_btn = new JButton("/");

        Float ans;

        public Calculator() {

            super("Calculator");

            setSize(300, 300);

            add(label1);

            add(text1);

            add(label2);

            add(text2);

            add(label3);

            add(text3);

            add(add_btn);

            add(sub_btn);

            add(mul_btn);

            add(div_btn);

            text3.setEditable(false);

            setLayout(layout);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            add_btn.addActionListener(this);

            sub_btn.addActionListener(this);

            mul_btn.addActionListener(this);

            div_btn.addActionListener(this);

            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {

            String number1 = text1.getText();

            String number2 = text2.getText();

            Float num1 = Float.parseFloat(number1);

            Float num2 = Float.parseFloat(number2);

            Object clicked = e.getSource();

 

            if (add_btn == clicked) {

                text3.setText(String.valueOf(num1 + num2));

            }

 

            else if (sub_btn == clicked) {

                text3.setText(String.valueOf(num1 - num2));

            }

 

            else if (mul_btn == clicked) {

                text3.setText(String.valueOf(num1 * num2));

            }

            else {

                if (num2 == 0)

                    text3.setText("Can't Divide By Zero");

                else

                    text3.setText(String.valueOf(num1 / num2));

            }

            text3.setEditable(false);

        }

        public static void main(String[] args) {

            Calculator calc = new Calculator();

            calc.setVisible(true);

        }

     }