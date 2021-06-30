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
    JButton btnStart, btnExit, btnBack,btnCheck;
    String response ;
    int randomNum1, randomNum2, randSum, resp, randSub;

    public Main () {
        this.initComponents();

    }

    public void initComponents() {

// frameMain
        frameMain = new JFrame();
       frameMain.setTitle("Kids count!");
        frameMain.setBounds(10, 10, 200,200);
       frameMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
//        buttonCheck
          btnCheck = new JButton("Check");
        panelMain.add(btnCheck);
        btnCheck.setLocation(100, 100);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }

            private void start() {
                String name = txtFieldName.getText();
                String hello = "Hello " + name + "!";
                panelMain.remove(btnStart);
                txtFieldName.setText("");
                String[] options = new String[]{"Addition", "Subtraction", "Cancel"};
                int response = JOptionPane.showOptionDialog(null, "Choose what you want to do: ", hello,
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options, options[0]);
//
                if (response == 0) {

                    addition();


                } else if (response == 1) {
                    subtraction();
                } else {
                    System.exit(0);
                }
            }


            private void addition() {

                Random rand = new Random();
                for (int i = 1; i <= 20; i++) {
                    randomNum1 = rand.nextInt(20 - 1);
                    randomNum2 = rand.nextInt(19);
                    randSum = randomNum1 + randomNum2;

                    String operAdd = randomNum1 + " + " + randomNum2 + " = ";
                    txtFieldMain.setText(operAdd);

//
                    btnCheck.addActionListener(e -> {
                                String brawo = "Brawo";
                                String[] options = new String[]{"One more time!", "Back"};
                                response = txtFieldName.getText();
                                resp = Integer.parseInt(response);
                                txtFieldName.setText("");
//for (int i = 0; i<)
                                if (randSum == resp) {

                                    int response1 = JOptionPane.showOptionDialog(null, "Correct!", brawo, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                            null, options, options[0]);

                                    if (response1 == 0) {

                                        start();

                                    } else {
                                        panelMain.setBackground(Color.magenta);
                                    }
                                } else {
                                    String keepPractice = "Keep practice!";
                                    String[] options2 = new String[]{"Try again!", "Exit"};
                                    int resp2 = JOptionPane.showOptionDialog(null, "Incorrect!", keepPractice, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                            null, options2, options2[0]);
                                    if (resp2 == 0) {
                                        start();
                                    } else {
                                        System.exit(0);
                                    }


                                }

// "Correct"; try again, exit

                            }
                    );
                }
            }

            private void subtraction() {
                Random rand = new Random();
                for (int i = 1; i <= 20; i++) {
                    randomNum1 = rand.nextInt(20);
                    randomNum2 = rand.nextInt(20);
                    if (randomNum1 > randomNum2) {
                        randSub = randomNum1 - randomNum2;

                        String operSub = randomNum1 + " - " + randomNum2 + " = ";
                        txtFieldMain.setText(operSub);

//
                        btnCheck.addActionListener(e -> {
                                    String brawo = "Brawo";
                                    String[] options = new String[]{"One more time!", "Back"};
                                    response = txtFieldName.getText();
                                    resp = Integer.parseInt(response);
                                    txtFieldName.setText("");
//for (int i = 0; i<)
                                    if (randSub == resp) {

                                        int response1 = JOptionPane.showOptionDialog(null, "Correct!", brawo, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                                null, options, options[0]);

                                        if (response1 == 0) {

                                            start();

                                        } else {
                                            panelMain.setBackground(Color.magenta);
                                        }
                                    } else {
                                        String keepPractice = "Keep practice!";
                                        String[] options2 = new String[]{"Try again!", "Exit"};
                                        int resp2 = JOptionPane.showOptionDialog(null, "Incorrect!", keepPractice, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                                null, options2, options2[0]);
                                        if (resp2 == 0) {
                                            start();
                                        } else {
                                            System.exit(0);
                                        }}


                                    });}
                    else if (randomNum1==0||randomNum1<randomNum2){  subtraction();}

// "Correct"; try again, exit

//                    simplify line above -> it's too heavy!

                }}  }
                        );
                    }




            public static void main(String[] args) {
                new Main();

            }

        }