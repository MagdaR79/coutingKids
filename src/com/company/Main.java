package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JFrame {

    JFrame frameMain;
    JPanel panelMain;
    JTextField txtFieldMain, txtFieldName, txtFieldAddQuest, txtFieldAddResponse;
    JButton btnStart, btnExit, btnBack;


    public Main () {
        this.initComponents();

    }

    public void initComponents() {

// frameMain
        frameMain = new JFrame();
       frameMain.setTitle("Kids count!");
        frameMain.setBounds(10, 10, 200,200);
       frameMain.setDefaultCloseOperation(3);
        frameMain.setVisible(true);

//        lblMain
//        JLabel lblMain = new JLabel("Let,s count!");
//        lblMain.setLocation(50, 10);
//        frameMain.getContentPane().add(lblMain);

//        panelMain
        panelMain = new JPanel();
        panelMain.setPreferredSize(new Dimension(180, 180));
        panelMain.setBackground(Color.DARK_GRAY);
        frameMain.getContentPane().add(panelMain);


//        textFieldMain
        txtFieldMain = new JFormattedTextField();
        txtFieldMain.setText("Enter your name:");
        txtFieldMain.setEditable(false);
        txtFieldMain.setBounds(20, 20, 100, 40);
        panelMain.add(txtFieldMain);

//        textFieldName
       txtFieldName= new JFormattedTextField("");
       txtFieldName.setLocation(60, 20);
        txtFieldName.setPreferredSize(new Dimension(100, 40));
        txtFieldName.setEditable(true);
        panelMain.add(txtFieldName);

//        btnStart
        btnStart = new JButton("START");
        btnStart.setLocation(60, 80);
        panelMain.add(btnStart);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }

            private void start() {
                String name = txtFieldName.getText();
                String hello = "Hello " + name + "!";
                String[] options = new String[] {"Addition", "Subtraction", "Cancel"};
                int response = JOptionPane.showOptionDialog(null, "Choose what you want to do: ", hello,
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options, options[0]);
//
           if (response == 0) {

                addition();

           } else {panelMain.setBackground(Color.green);}
            }

            private void addition() {

                Random rand = new Random();
                for(int i = 1; i <=20; i++) {
                    int randomNum1 = rand.nextInt(20-1) ;
                    int randomNum2 = rand.nextInt(19-0);

                            String operAdd = new String();
               operAdd = randomNum1 + " + " + randomNum2 + " = ";
               txtFieldMain.setText(operAdd);

//               txtFieldName.setText();

            }}
        });


    }

    public static void main(String[] args) {
	new Main();

    }
}
